package com.example.jennarongpinjai.training_test;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.jennarongpinjai.dataservice.JobControllService;
import com.example.jennarongpinjai.model.JobControlDto;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


/*        for(JobControlDto job : jobList){

                System.out.println(job.getJobname());

        }*/

        final ProgressDialog loadDialog = ProgressDialog.show(this,"Loading jobs..","Have fun!",true,false);

        AsyncTask loadjob = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                try {
                    JobControllService jobService = new JobControllService();
                    List<JobControlDto> jobList = jobService.getAllJobList();
                    return jobList;
                }catch (Exception ex){
                    ex.printStackTrace();
                    return  null;
                }
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);

                try {
                    if(o==null){
                        throw new Exception("Result is null");
                    }
                    List<JobControlDto> jobList = (List<JobControlDto>)o;
                    printJobList(jobList);
                    loadDialog.dismiss();
                }catch (Exception ex){
                    ex.printStackTrace();
                    loadDialog.dismiss();
                    alert(ex.getMessage());

                }
            }
        };
        loadjob.execute();


    }

    public void printJobList(List<JobControlDto> jobList){

        TableLayout jobTableLayout = findViewById(R.id.job_list_table);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US);
        int seq=0;
        for(JobControlDto job : jobList){
            seq++;
            //TableRow row = new TableRow(new ContextThemeWrapper(this,R.style.text_data_row));
            TableRow row = new TableRow(this);
            TableRow.LayoutParams  rowLayParam = new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            rowLayParam.setMargins(10,0,0,0);
            row.setLayoutParams(rowLayParam);
            row.setGravity(Gravity.CENTER_VERTICAL);
            if(seq%2==0){
                row.setBackground(getResources().getDrawable(R.drawable.ontouch_white));
            }else{
                row.setBackground(getResources().getDrawable(R.drawable.ontouch_gray));
            }
            TextView  nameView = new TextView(new ContextThemeWrapper(this,R.style.text_data_row));

            nameView.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            nameView.setLayoutParams(new TableRow.LayoutParams(1));
            nameView.setText(job.getJobname());

            row.addView(nameView);

            TextView  startDateView = new TextView(new ContextThemeWrapper(this,R.style.text_data_row));
            startDateView.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            startDateView.setLayoutParams(new TableRow.LayoutParams(2));
            startDateView.setText(job.getJobstart()==null?"":dateFormat.format(job.getJobstart()));
            //dateFormat.format(job.getJobstart())
            startDateView.setEllipsize(TextUtils.TruncateAt.END);
            startDateView.setMaxWidth(150);
            startDateView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            row.addView(startDateView);

            TextView  endDateView = new TextView(new ContextThemeWrapper(this,R.style.text_data_row));
            endDateView.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            endDateView.setLayoutParams(new TableRow.LayoutParams(3));
            endDateView.setText(job.getJobend()==null?"":dateFormat.format(job.getJobend()));
            endDateView.setEllipsize(TextUtils.TruncateAt.END);
            endDateView.setMaxWidth(150);
            endDateView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            row.addView(endDateView);

            setJobRowOnclick(row,job.getJobname());
            jobTableLayout.addView(row);
        }


    }

    public void setJobRowOnclick(TableRow row,final String jobName){

        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alert("Job name :"+jobName);

            }
        });

    }

    public void alert(String message){

        AlertDialog.Builder alertBuilder =  new AlertDialog.Builder(ListActivity.this);
        alertBuilder.setMessage(message);
        alertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertBuilder.show();


    }
}
