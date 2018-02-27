package truecorp.ensemble.utils;

import android.app.Activity;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import truecorp.ensemble.R;

/**
 * Created by Jennarong Pinjai on 18/2/2561.
 */

public class DatePickerUtil {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
    public  void createDatePicker(final Activity activity,final View rootView,final View inputView) {

        String hintMessage = "Touch for select date...";
        if(inputView instanceof TextView){
            TextView tv = (TextView)inputView;
            tv.setHint(hintMessage);
            tv.setHintTextColor(activity.getResources().getColor(R.color.grayStatus));

        }else if(inputView instanceof EditText){
            EditText edt = (EditText)inputView;
            edt.setHint(hintMessage);
            edt.setHintTextColor(activity.getResources().getColor(R.color.grayStatus));
        }



        inputView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    setupPopup(activity,rootView, inputView);
                }catch (Exception ex){
                    ex.printStackTrace();
                }

            }
        });



    }

    protected  void setupPopup(final Activity activity,final View rootView,final View inputView) throws Exception{
        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                activity.getSystemService(activity.LAYOUT_INFLATER_SERVICE);
        final View popupView = inflater.inflate(R.layout.datepicker_popup, null);

        // create the popup window

        boolean focusable = true; // lets taps outside the popup also dismiss it
        final View mainView = rootView;

        //int width = (int)(mainView.getWidth()/1);
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;

        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);



        // show the popup window
        popupWindow.showAtLocation(inputView.getRootView(), Gravity.CENTER, 0, 0);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setAnimationStyle(-1);
        popupWindow.setClippingEnabled(true);
        mainView.setAlpha(0.3f);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                mainView.setAlpha(1f);

            }
        });


        String dateShowInput = "";
        String hintMessage = "Touch for select date...";
        if(inputView instanceof TextView){
            TextView tv = (TextView)inputView;
            dateShowInput = tv.getText()==null?"":tv.getText().toString();


        }else if(inputView instanceof EditText){
            EditText edt = (EditText)inputView;
            dateShowInput = edt.getText()==null?"":edt.getText().toString();

        }

        if(!dateShowInput.trim().isEmpty()){

            Date oldDate = null;
            try{ oldDate = dateFormat.parse(dateShowInput); }catch (Exception ex){ex.printStackTrace();}
            if(oldDate!=null){
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(oldDate);
                int oldYear = calendar.get(Calendar.YEAR);
                int oldMonth= calendar.get(Calendar.MONTH);
                int oldDay  = calendar.get(Calendar.DAY_OF_MONTH);
                DatePicker datePicker = popupView.findViewById(R.id.date_picker_popup);
                datePicker.init(oldYear, oldMonth, oldDay, new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        //nothing
                    }
                });


            }

        }



        Button okBtn = popupView.findViewById(R.id.ok_date_btn);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    DatePicker datePicker = popupView.findViewById(R.id.date_picker_popup);
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(datePicker.getYear(),datePicker.getMonth(),datePicker.getDayOfMonth());
                    Date paymentDate = calendar.getTime();
                    String dateShow = dateFormat.format(paymentDate);
                    if (inputView instanceof TextView) {
                        TextView tv = (TextView) inputView;
                        tv.setText(dateShow);
                    } else if (inputView instanceof EditText) {
                        EditText edt = (EditText) inputView;
                        edt.setText(dateShow);
                    }


                    popupWindow.dismiss();
                }catch (Exception ex){

                    ex.printStackTrace();
                    popupWindow.dismiss();

                }
            }
        });

        Button cancelBtn = popupView.findViewById(R.id.cancel_date_btn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }
}
