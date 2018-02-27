package truecorp.ensemble;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import truecorp.core.dataservice.FileControlService;
import truecorp.core.model.FileControlDto;
import truecorp.ensemble.components.TitleComponent;

public class FileControlActivity extends Activity {

    SimpleDateFormat dateFormatUS = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US);
    SimpleDateFormat dateFormatTH = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", new Locale("th", "TH"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //final ActivityFileControlBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_file_control);
        //setContentView(R.layout.activity_file_control);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_file_control);
        TextView titleCom = findViewById(R.id.titleComponent);
        titleCom.setText("File Control");
        TitleComponent.setupTitle("Job monitor", false, true, true, true, this);
        getJobList();



    }

    public void getJobList(){
        //final List<FileControlDto> fileControlJobs = new ArrayList<FileControlDto>();

        AsyncTask getAllJobs = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                FileControlService fileControl = new FileControlService();
                List<FileControlDto> fileControlJobs = new ArrayList<FileControlDto>();
                fileControl.getAllJobs(fileControlJobs);
                return fileControlJobs;
            }

            @Override
            protected  void onPostExecute(Object o){
                //super.onPostExecute(o);
                List<FileControlDto> fileControlJobs = (List<FileControlDto>) o;
                try{
                    if(fileControlJobs.isEmpty() || fileControlJobs==null){
                        System.out.println("fileControlActivity fileControlJobs null/empty");
                    }
                    printJobsTable(fileControlJobs);
                    //binding.setJobsList(fileControlJobs.get(0));

                }catch (Exception ex){
                    System.out.println("fileControlActivity fileControlJobs error"+ex.getMessage());
                    ex.printStackTrace();
                    //textView.setText(e.getMessage());
                }
            }
        };
        getAllJobs.execute();

    }

    public void printJobsTable(List<FileControlDto> jobs){
        System.out.println("start print Jobs");
        TableLayout fileControlTableLayout = (TableLayout)findViewById(R.id.fileControlTableLayout);
        TableLayout dataTableLayoutHeader = (TableLayout)findViewById(R.id.fileControlDataTableLayoutHeader);
        TableRow fileControlDataRow = (TableRow)findViewById(R.id.fileControlDataRow);
        System.out.println("1");
        try {
            fileControlDataRow.removeAllViews();
            System.out.println("remove view row");
        } catch (Exception ex) {

        }

        //Detach
        System.out.println("2");
        try {
            fileControlTableLayout.removeViews(1, fileControlTableLayout.getChildCount() - 1);
            System.out.println("remove view table");
        } catch (Exception ex) {
        }
        int rowId;
        for (int i = 0; i < 2; i++) {
            rowId = 0;
            System.out.println("i : "+i);
            for (FileControlDto job : jobs) {
                System.out.println("printing job : "+job.getFileName());

                rowId++;
                fileControlDataRow = new TableRow(this);
                TableRow.LayoutParams layParams = new TableRow.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT,2);
                if (rowId % 2 == 0) {
                    fileControlDataRow.setBackground(getResources().getDrawable(R.drawable.onrowtouched));
                } else {
                    fileControlDataRow.setBackground(getResources().getDrawable(R.drawable.onrowtouchedsoftgray));
                }

                layParams.setMargins(0, 10, 0, 10);


                TableRow.LayoutParams tbrLayout = new TableRow.LayoutParams(0,TableLayout.LayoutParams.WRAP_CONTENT,2.4f);
                tbrLayout.column = 1;

                fileControlDataRow.setLayoutParams(layParams);
                fileControlDataRow.setWeightSum(5);
                fileControlDataRow.setPadding(0, 10, 10, 10);
                fileControlDataRow.setGravity(Gravity.CENTER);
                TextView nameView = new TextView(new ContextThemeWrapper(this, R.style.dataText));
                nameView.setHeight(80);
                nameView.setLayoutParams(tbrLayout);
                //nameView.setLayoutParams(new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.MATCH_PARENT,2));
                nameView.setText(job.getFileName());
                nameView.setGravity(Gravity.CENTER_VERTICAL);
                nameView.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                nameView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 13);
                nameView.setPadding(20, 0, 0, 0);

                int timeShowWidth = 150;

                tbrLayout = new TableRow.LayoutParams(0,TableLayout.LayoutParams.WRAP_CONTENT,2f);
                tbrLayout.column = 2;

                TextView startView = new TextView(new ContextThemeWrapper(this, R.style.dataText));
                startView.setLayoutParams(tbrLayout);
                //startView.setLayoutParams(new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.MATCH_PARENT,2));
                startView.setText(job.getSysCreationDate() == null ? "" : dateFormatUS.format(job.getSysCreationDate()));
                startView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                startView.setGravity(Gravity.CENTER);
                startView.setTextSize(12);
                startView.setEllipsize(TextUtils.TruncateAt.END);
                startView.setHorizontallyScrolling(false);
                startView.setMaxWidth(timeShowWidth);

                tbrLayout = new TableRow.LayoutParams(0,TableLayout.LayoutParams.WRAP_CONTENT,0.6f);
                tbrLayout.column = 3;
                TextView statusView = new TextView(new ContextThemeWrapper(this, R.style.dataText));
                statusView.setLayoutParams(tbrLayout);
                //statusView.setLayoutParams(new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.MATCH_PARENT,1));
                statusView.setText(job.getFileStatus());
                statusView.setBackgroundColor(getStatusColor(job.getFileStatus() == null ? "" : job.getFileStatus().trim()));
                statusView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                statusView.setGravity(Gravity.CENTER);
                statusView.setTextSize(12);
                statusView.setPadding(0, 0, 10, 0);

                fileControlDataRow.addView(nameView);
                fileControlDataRow.addView(startView);
                fileControlDataRow.addView(statusView);
                setOnClickForRow(fileControlDataRow,job);

                System.out.println("Name Start Status : "+nameView.getWidth()+", "+startView.getWidth()+", "+statusView.getWidth());

                if (i == 1 && rowId == 1) {
                    TableRow.LayoutParams layParam2 = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 0);
                    fileControlDataRow.setLayoutParams(layParam2);
                    fileControlDataRow.setVisibility(View.INVISIBLE);
                    dataTableLayoutHeader.addView(fileControlDataRow);
                } else if (i == 0) {
                    fileControlTableLayout.addView(fileControlDataRow);
                }
                System.out.println("finish : "+job.getFileName());
            }
        }

        System.out.println("finish print");


    }

    public int getStatusColor(String status) {

        int color = 0;
        Map<String, Integer> colorMap = new HashMap<String, Integer>();

        colorMap.put("CO", getResources().getColor(R.color.greenStatus));
        colorMap.put("KL", getResources().getColor(R.color.orangeStatus));
        colorMap.put("HL", getResources().getColor(R.color.grayStatus));
        colorMap.put("SK", getResources().getColor(R.color.skyBlueStatus));
        colorMap.put("RD", getResources().getColor(R.color.white));
        colorMap.put("IU", getResources().getColor(R.color.yellowSoft));
        colorMap.put("AF", getResources().getColor(R.color.redSoft));
        color = colorMap.get(status);

        return color;
    }

    private void setOnClickForRow(TableRow row,final FileControlDto fileDetail){
        final Button showDetailBtn = findViewById(R.id.showDetailButton);
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout detailShowLayout = findViewById(R.id.detailShowLayout);
                detailShowLayout.setVisibility(View.VISIBLE);
                showJobDetail(fileDetail);
                showDetailBtn.setText("Hide Detail");
            }
        });

        showDetailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(showDetailBtn.getText().equals("Hide Detail")){
                    showDetailBtn.setText("Show Detail");
                    hideJobDetail();
                }else if(showDetailBtn.getText().equals("Show Detail")){
                    showDetailBtn.setText("Hide Detail");
                    showJobDetail(fileDetail);
                }else{
                    showDetailBtn.setText("Cannot Get Job Detail");
                    hideJobDetail();
                }
            }
        });
    }

    private void showJobDetail(FileControlDto fileDetail){
        LinearLayout detailLayout = (LinearLayout)findViewById(R.id.detailLayout);
        TextView fileName = (TextView)findViewById(R.id.detailFileName);
        TextView fileStatus = (TextView)findViewById(R.id.detailFileStatus);
        TextView recQuantity = (TextView)findViewById(R.id.detailRecQuantity);
        TextView sysCreationDate = (TextView)findViewById(R.id.detailSysCreationDate);
        TextView sysUpdateDate = (TextView)findViewById(R.id.detailSysUpdateDate);
        TextView operatorId = (TextView)findViewById(R.id.detailOperatorId);
        TextView pgmName = (TextView)findViewById(R.id.detailPgmName);
        TextView pgmErrMsg = (TextView)findViewById(R.id.detailPgmErrMsg);

        fileName.setText(fileDetail.getFileName());
        fileStatus.setText(fileDetail.getFileStatus());

        recQuantity.setText(fileDetail.getRecQuantity().toString());
        String dateTxt = fileDetail.getSysCreationDate()==null?"":dateFormatUS.format(fileDetail.getSysCreationDate());
        sysCreationDate.setText(dateTxt);
        dateTxt = fileDetail.getSysUpdateDate()==null?"":dateFormatUS.format(fileDetail.getSysUpdateDate());
        sysUpdateDate.setText(dateTxt);
        String oprId = fileDetail.getOperatorId()==null?"":fileDetail.getOperatorId().toString();
        operatorId.setText(oprId);
        pgmName.setText(fileDetail.getPgmName()==null?"":fileDetail.getPgmName());
        pgmErrMsg.setText(fileDetail.getPgmErrMsg()==null?"":fileDetail.getPgmErrMsg());

        detailLayout.setVisibility(View.VISIBLE);
    }

    private void hideJobDetail(){
        LinearLayout detailLayout = (LinearLayout)findViewById(R.id.detailLayout);
        detailLayout.setVisibility(View.GONE);
    }


}
