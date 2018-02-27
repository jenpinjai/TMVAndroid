package truecorp.ensemble;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
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

import truecorp.core.dataservice.JobcontrolService;
import truecorp.core.model.JobControlDto;
import truecorp.ensemble.components.TitleComponent;

public class JobMonitorActivity extends Activity {

    public static String currentJobName = "";
    private AlertDialog.Builder alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_job_monitor);
        TextView titleCom = findViewById(R.id.titleComponent);
        titleCom.setText("Job monitor");
        alert = new AlertDialog.Builder(JobMonitorActivity.this);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        currentJobName = "";
        Button historyBtn = findViewById(R.id.hitoryJobButton);
        TitleComponent.setupTitle("Job monitor", false, true, true, true, this);

        historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    loadLogList();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });

        fectJobList();

    }


    public void fectJobList() {
        final ProgressDialog loadDialog = ProgressDialog.show(this, "Loading job...", "Please wait", true, false);

        AsyncTask getJobsTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {

                try {
                    JobcontrolService jobService = new JobcontrolService();

                    List<JobControlDto> jobList = jobService.getAllJobControl();


                    return jobList;

                } catch (Exception ex) {
                    ex.printStackTrace();
                    return null;
                }
            }


            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);

                try {
                    List<JobControlDto> jobList = (List<JobControlDto>) o;
                    printJobDataTable(jobList);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    TextView logShow = findViewById(R.id.logShow);
                    logShow.setText(ex.getMessage());

                }
                loadDialog.dismiss();
            }
        };
        getJobsTask.execute();

    }

    public void printJobDataTable(List<JobControlDto> jobList) {


        TableLayout dataTableLayout = findViewById(R.id.dataTableLayout);
        TableLayout dataTableLayoutHeader = findViewById(R.id.dataTableLayoutHeader);
        TableRow dataRowMaster = findViewById(R.id.dataRowMaster);
        try {
            dataRowMaster.removeAllViews();
        } catch (Exception ex) {

        }
        SimpleDateFormat dateFormatUS = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US);
        SimpleDateFormat dateFormatTH = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", new Locale("th", "TH"));

        //Detach
        try {
            dataTableLayout.removeViews(1, dataTableLayout.getChildCount() - 1);
        } catch (Exception ex) {
        }


        int idGen = 0;
        for (int i = 0; i < 2; i++) {
            idGen = 0;
            for (JobControlDto job : jobList) {
                idGen++;

                dataRowMaster = new TableRow(this);

                //dataRowMaster.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

                TableRow.LayoutParams layParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);
                if (idGen % 2 == 0) {
                    dataRowMaster.setBackground(getResources().getDrawable(R.drawable.onrowtouched));
                } else {
                    dataRowMaster.setBackground(getResources().getDrawable(R.drawable.onrowtouchedsoftgray));
                }

                layParams.setMargins(0, 10, 0, 10);

                dataRowMaster.setLayoutParams(layParams);
                dataRowMaster.setPadding(0, 10, 10, 10);
                dataRowMaster.setGravity(Gravity.CENTER);
                TextView nameView = new TextView(new ContextThemeWrapper(this, R.style.dataText));
                nameView.setHeight(80);
                nameView.setLayoutParams(new TableRow.LayoutParams(1));
                nameView.setText(job.getJobname());
                nameView.setGravity(Gravity.CENTER);
                nameView.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                nameView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 13);
                nameView.setPadding(20, 0, 0, 0);

                int timeShowWidth = 150;

                TextView startView = new TextView(new ContextThemeWrapper(this, R.style.dataText));
                startView.setLayoutParams(new TableRow.LayoutParams(2));
                startView.setText(job.getJobstart() == null ? "" : dateFormatUS.format(job.getJobstart()));
                startView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                startView.setGravity(Gravity.CENTER);
                startView.setTextSize(12);
                startView.setEllipsize(TextUtils.TruncateAt.END);
                startView.setHorizontallyScrolling(false);
                startView.setMaxWidth(timeShowWidth);

                TextView endView = new TextView(new ContextThemeWrapper(this, R.style.dataText));
                endView.setLayoutParams(new TableRow.LayoutParams(3));
                endView.setText(job.getJobend() == null ? "" : dateFormatTH.format(job.getJobend()));
                endView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                endView.setGravity(Gravity.CENTER);
                endView.setTextSize(12);

                endView.setEllipsize(TextUtils.TruncateAt.END);
                endView.setHorizontallyScrolling(false);
                endView.setMaxWidth(timeShowWidth);

                TextView statusView = new TextView(new ContextThemeWrapper(this, R.style.dataText));
                statusView.setLayoutParams(new TableRow.LayoutParams(4));
                statusView.setText(job.getJobstatus());
                // statusView.setBackgroundColor(getStatusColor(job.getJobstatus()==null?"":job.getJobstatus().trim()));
                statusView.setBackgroundColor(getStatusColor(job.getJobstatus() == null ? "" : job.getJobstatus().trim()));
                statusView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                statusView.setGravity(Gravity.CENTER);
                statusView.setPadding(0, 0, 10, 0);

                dataRowMaster.addView(nameView);
                dataRowMaster.addView(startView);
                dataRowMaster.addView(endView);
                //setOnClickOnJobRow(job.getJobname(),dataRowMaster);
                setOnClickOnJobRow(job, dataRowMaster);
                dataRowMaster.addView(statusView);
                if (i == 1 && idGen == 1) {
                    TableRow.LayoutParams layParam2 = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 0);
                    dataRowMaster.setLayoutParams(layParam2);
                    dataRowMaster.setVisibility(View.INVISIBLE);
                    dataTableLayoutHeader.addView(dataRowMaster);
                } else if (i == 0) {
                    dataTableLayout.addView(dataRowMaster);
                }
            }
        }


    }

    public void setOnClickOnJobRow(final JobControlDto job, TableRow tableRow) {

        final TextView jobTitleName = findViewById(R.id.jobNameTitle);

        tableRow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                TableRow tableRow = (TableRow) v;
                fetchLog(job.getJobname());
                //logTexView.setText(jobName);

                LinearLayout dataRowLayout = findViewById(R.id.dataRowLayout);
                LinearLayout logShowLayout = findViewById(R.id.logShowLayout);
                LinearLayout jobButtonLayout = findViewById(R.id.jobButtonLayout);
                LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        0,
                        50
                );
                LinearLayout.LayoutParams param2 = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        0,
                        50
                );
                LinearLayout.LayoutParams param3 = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        180
                );
                dataRowLayout.setLayoutParams(param);
                logShowLayout.setLayoutParams(param2);
                jobButtonLayout.setLayoutParams(param3);

                jobTitleName.setText(job.getJobname());

                LinearLayout linear = findViewById(R.id.fileNameShowInScrollLayout);
                linear.removeAllViews();

                Button startJobBtn = findViewById(R.id.startJobButton);
                Button stopJobBtn = findViewById(R.id.stopJobButton);
                Button rerunJobBtn = findViewById(R.id.rerunJobButton);
                Button skipJobBtn = findViewById(R.id.skipJobButton);
                Button holdJobBtn = findViewById(R.id.holdJobButton);
                Button unHoldJobBtn = findViewById(R.id.unHoldJobButton);
                stopJobBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        callJobProcess("stop", job);
                    }
                });
                startJobBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        callJobProcess("start", job);
                    }
                });
                rerunJobBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        callJobProcess("rerun", job);
                    }
                });
                skipJobBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View V) {
                        callJobProcess("skip", job);
                    }
                });
                holdJobBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View V) {
                        callJobProcess("hold", job);
                    }
                });
                unHoldJobBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View V) {
                        callJobProcess("unhold", job);
                    }
                });

                //set default button none visible
                startJobBtn.setVisibility(View.GONE);
                stopJobBtn.setVisibility(View.GONE);
                rerunJobBtn.setVisibility(View.GONE);
                skipJobBtn.setVisibility(View.GONE);
                holdJobBtn.setVisibility(View.GONE);
                unHoldJobBtn.setVisibility(View.GONE);

                //set which button show base on what status
                switch(job.getJobstatus()){
                    case "RD" : startJobBtn.setVisibility(View.VISIBLE);
                                skipJobBtn.setVisibility(View.VISIBLE);
                                holdJobBtn.setVisibility(View.VISIBLE);
                                break;
                    case "IU" : stopJobBtn.setVisibility(View.VISIBLE);
                                break;
                    case "AF" : rerunJobBtn.setVisibility(View.VISIBLE);
                                skipJobBtn.setVisibility(View.VISIBLE);
                                break;
                    case "HL" : unHoldJobBtn.setVisibility(View.VISIBLE);
                                skipJobBtn.setVisibility(View.VISIBLE);
                                break;
                    default   : break;
                }
            }
        });

    }

    public void callJobProcess(final String condition, final JobControlDto job) {

        if (condition.equals("start") || condition.equals("rerun") || condition.equals("stop")) {

            AsyncTask jobProcessTask = new AsyncTask() {
                @Override
                protected Object doInBackground(Object[] objects) {

                    try {
                        JobcontrolService jobService = new JobcontrolService();
                        String shellMessage = jobService.jobProcess(condition, job.getJobname());
                        return shellMessage;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        return null;
                    }
                }

                @Override
                protected void onPostExecute(Object o) {

                    try {
                        if (o == null) {
                            throw new Exception("Empty response!");
                        }

                        String message = (String) o;
                        alert(message);
                        fectJobList();

                        finish();
                        overridePendingTransition(0, 0);
                        startActivity(getIntent());
                        overridePendingTransition(0, 0);

                    } catch (Exception ex) {
                        alert(ex.getMessage());
                        ex.printStackTrace();

                    }

                }
            };
            jobProcessTask.execute();

        } else {
            //call update job status
            final String tmpStatus = getStatus(condition);
            AsyncTask jobProcessTask = new AsyncTask() {
                @Override
                protected Object doInBackground(Object[] objects) {

                    try {
                        JobcontrolService jobService = new JobcontrolService();
                        JobControlDto returnVal = jobService.updateJobStatus(job, tmpStatus);
                        return returnVal.getJobname();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        return null;
                    }
                }

                @Override
                protected void onPostExecute(Object o) {

                    try {
                        if (o == null) {
                            throw new Exception("Empty response!");
                        }

                        String message = (String) o;
                        alert(message);
                        fectJobList();

                        finish();
                        overridePendingTransition(0, 0);
                        startActivity(getIntent());
                        overridePendingTransition(0, 0);

                    } catch (Exception ex) {
                        alert(ex.getMessage());
                        ex.printStackTrace();

                    }

                }
            };
            jobProcessTask.execute();
        }


    }

    public void fetchLog(final String jobName) {
        if (!currentJobName.equals(jobName)) {
            currentJobName = jobName;
        } else {
            // return;
        }

        final ProgressDialog loadDialog = ProgressDialog.show(this, "Loading job's logs", "Please wait", true, false);
        loadDialog.show();
        AsyncTask loadLog = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                TextView logShow = findViewById(R.id.logShow);
                try {
                    String[] fileName;
                    String[] logs;
                    System.out.println("Select " + jobName);
                    JobcontrolService jobService = new JobcontrolService();
                    fileName = jobService.getLogFilename(jobName);
                    if (fileName == null || fileName.length == 0) {
                        throw new Exception("File'neme not found!");
                    }
                    String nameFile = fileName[0] == null ? "" : fileName[0].split("\\.")[0];
                    String typeFile = fileName[0] == null ? "" : fileName[0].split("\\.")[1];
                    logs = jobService.getLogText(nameFile, typeFile);
                    loadDialog.dismiss();
                    return logs;
                } catch (Exception ex) {
                    loadDialog.dismiss();
                    ex.printStackTrace();
                    String[] mess = {"Can't get log!", ""};
                    return mess;
                }

            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                TextView logShow = findViewById(R.id.logShow);
                try {

                    String[] logs = (String[]) o;
                    String show = "";
                    for (String log : logs) {
                        show += log + "\n";
                    }
                    logShow.setText(show);

                } catch (Exception ex) {
                    ex.printStackTrace();
                    logShow.setText(ex.getMessage());
                }
                loadDialog.dismiss();

            }
        };

        loadLog.execute();


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


    public void loadLogList() throws Exception {


        final ProgressDialog loadDialog = ProgressDialog.show(this, "Loading history", "Please wait", true, false);
        final TextView logShow = findViewById(R.id.logShow);
        AsyncTask loadLogs = new AsyncTask() {

            @Override
            protected Object doInBackground(Object[] objects) {

                List<String> fileNames = new ArrayList<String>();
                try {

                    JobcontrolService jobService = new JobcontrolService();

                    if (currentJobName.isEmpty()) {
                        loadDialog.dismiss();
                        return fileNames;
                    }

                    //get only file name
                    currentJobName = currentJobName.trim();
                    if (currentJobName.indexOf('.') <= 0) {
                        return currentJobName;
                    }
                    currentJobName = currentJobName.substring(0, currentJobName.lastIndexOf('.'));

                    String[] filesName = jobService.getLogFilename(currentJobName);

                    for (String fileName : filesName) {
                        fileNames.add(fileName);
                    }

                    return fileNames;
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return fileNames;
                }


            }


            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                List<String> fileNames = (ArrayList<String>) o;
                if (fileNames == null || fileNames.size() == 0) {
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(JobMonitorActivity.this);
                    alertBuilder.setMessage("Not found!");
                    alertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    alertBuilder.show();
                } else {
                    logShow.setText("");
                    String texts = "";
                    LinearLayout linear = findViewById(R.id.fileNameShowInScrollLayout);
                    linear.removeAllViews();
                    int seq = 0;
                    for (final String fileName : fileNames) {
                        seq++;
                        TextView fileNameView = new TextView(new ContextThemeWrapper(JobMonitorActivity.this, R.style.dataText));
                        ViewGroup.LayoutParams layout = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        fileNameView.setLayoutParams(layout);
                        // fileNameView.setHeight(80);
                        fileNameView.setText(fileName);
                        fileNameView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
                        fileNameView.setPadding(20, 20, 0, 20);
//                        if(seq%2==0){
//                            fileNameView.setBackground(getDrawable(R.drawable.onrowtouched));
//                        }else{
//                            fileNameView.setBackground(getDrawable(R.drawable.onrowtouchedsoftgray));
//                        }
                        fileNameView.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        fileNameView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                renderLog(fileName);
                            }
                        });
                        linear.addView(fileNameView);

                    }
                }
                loadDialog.dismiss();
            }
        };

        loadLogs.execute();


    }

    public void alert(String message) {

        alert.setMessage(message);
        alert.show();
    }

    public void renderLog(final String fileName) {

        final ProgressDialog loadDialog = ProgressDialog.show(this, "Loading file.", "Please wait", true, false);
        LinearLayout linear = findViewById(R.id.fileNameShowInScrollLayout);
        linear.removeAllViews();
        AsyncTask loadLog = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                TextView logShow = findViewById(R.id.logShow);
                try {
                    String[] logs;
                    JobcontrolService jobService = new JobcontrolService();

                    if (fileName == null || fileName.isEmpty()) {
                        throw new Exception("File'neme not found!");
                    }
                    String nameFile = fileName == null ? "" : fileName.split("\\.")[0];
                    String typeFile = fileName == null ? "" : fileName.split("\\.")[1];
                    logs = jobService.getLogText(nameFile, typeFile);
                    loadDialog.dismiss();
                    return logs;
                } catch (Exception ex) {
                    loadDialog.dismiss();
                    ex.printStackTrace();
                    String[] mess = {"Can't get log!", ""};
                    return mess;
                }

            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                TextView logShow = findViewById(R.id.logShow);
                try {

                    String[] logs = (String[]) o;
                    String show = "";
                    for (String log : logs) {
                        show += log + "\n";
                    }
                    logShow.setText(show);

                } catch (Exception ex) {
                    ex.printStackTrace();
                    logShow.setText(ex.getMessage());
                }
                loadDialog.dismiss();

            }
        };

        loadLog.execute();


    }

    private String getStatus(String condition){
        switch(condition){
            case "skip"     : return "SK";
            case "hold"     : return "HL";
            case "unhold"   : return "RD";
            default         : return "HL";
        }
    }

}
