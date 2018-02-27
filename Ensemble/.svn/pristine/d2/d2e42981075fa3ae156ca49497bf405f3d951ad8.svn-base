package truecorp.ensemble.dialogs;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import truecorp.core.dataservice.BackoutService;
import truecorp.core.dataservice.RefundService;
import truecorp.core.model.AdjustmentDto;
import truecorp.core.model.BackoutRequestDto;
import truecorp.core.model.BillingAccountDto;
import truecorp.core.model.InvoiceItemDto;
import truecorp.core.model.M203UserDto;
import truecorp.core.model.PaymentActivityDto;
import truecorp.core.model.PaymentDto;
import truecorp.core.model.RefundRequestDto;
import truecorp.core.model.RestResponse;
import truecorp.core.model.SelectItem;
import truecorp.ensemble.AdjustmentActivity;
import truecorp.ensemble.BillingAccountActivity;
import truecorp.ensemble.R;
import truecorp.ensemble.utils.UserUtils;

/**
 * Created by Jennarong Pinjai on 19/2/2561.
 */

public class BackoutFormDialog extends PaymentInfoDialog {


    private Map<String,String> dropDownBackoutResonMap ;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        try{

            final View popupView = inflater.inflate(R.layout.backout_popup,container,false);

            TextView iconClose = popupView.findViewById(R.id.icon_close_popup);
            final Dialog popupWindow = getDialog();
            iconClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                }
            });
            Button confirmlBtn = popupView.findViewById(R.id.confirm_backout_btn);
            confirmlBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    processBackout(popupWindow,popupView,getBan(),getPayment(),getPaymentActivity());
                }
            });


            Button cancelBtn = popupView.findViewById(R.id.cancel_backout_btn);
            cancelBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hideKeyboard();
                    popupWindow.dismiss();
                }
            });
            final Spinner backout_reason_selected = popupView.findViewById(R.id.backout_reason_selected);
            backout_reason_selected.setPrompt("Backout reason");

            final ProgressDialog loadDialog = ProgressDialog.show(getActivity(),"Loading Backout reason...","Please wait",true,false);
            final int spinnerMaxWidth =(int)(getWidth()/2);
            AsyncTask loadReason = new AsyncTask() {
                @Override
                protected Object doInBackground(Object[] objects) {
                    try {
                        BackoutService backoutService = new BackoutService();

                        List<SelectItem> items = backoutService.searchBackoutReason();
                        return items;
                    }catch (Exception ex){
                        ex.printStackTrace();
                        loadDialog.dismiss();
                        return null;
                    }
                }

                @Override
                protected void onPostExecute(Object o) {
                    super.onPostExecute(o);
                    try {
                        if(o==null){
                            throw new Exception("Not found reason!");
                        }
                        List<SelectItem> items = (ArrayList<SelectItem>)o;


                        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getActivity(),R.layout.spiner_white_item);
                        dropDownBackoutResonMap = new HashMap<String,String>();
                        for(SelectItem item : items){

                            spinnerAdapter.add(item.getValueDesc());
                            dropDownBackoutResonMap.put(item.getValueDesc(),item.getValue());
                        }


                        backout_reason_selected.setAdapter(spinnerAdapter);

                        Spinner.LayoutParams layoutParams = backout_reason_selected.getLayoutParams();
                        layoutParams.width =spinnerMaxWidth;
                        backout_reason_selected.setLayoutParams(layoutParams);


                        loadDialog.dismiss();
                    }catch (Exception ex){
                        loadDialog.dismiss();
                        ex.printStackTrace();
                        alert(ex.getMessage());
                    }


                }
            };
            loadReason.execute();


            return popupView;
        }catch (Exception ex){

            ex.printStackTrace();
            return null;
        }

    }

    public void processBackout(final Dialog popupWindow, final View rootView, final String ban, final PaymentDto payment , final PaymentActivityDto paymentActivity){

        try{
            final ProgressDialog loadDialog = ProgressDialog.show(getActivity(),"Processing Backout...","Please wait",true,false);

            AsyncTask processBackout = new AsyncTask() {
                @Override
                protected Object doInBackground(Object[] objects) {
                    try {
                        BackoutService backoutService = new BackoutService();
                        BackoutRequestDto request = new BackoutRequestDto();
                        double invert = -1;
                        BigDecimal actvAmt = paymentActivity.getActvAmt()==null?BigDecimal.ZERO:paymentActivity.getActvAmt();
                        BigDecimal bckEuActvAmt = paymentActivity.getEuActvAmt()==null?BigDecimal.ZERO:paymentActivity.getEuActvAmt().multiply(BigDecimal.valueOf(invert));
                        Spinner reasonSelector = rootView.findViewById(R.id.backout_reason_selected);


                        String reasonDesc = String.valueOf(((TextView)reasonSelector.getSelectedView()).getText());
                        String reason     = dropDownBackoutResonMap.get(reasonDesc);
                        M203UserDto user = UserUtils.getUser();
                        request.setActvCode("RFN");
                        request.setActvReasonCode(reason);
                        request.setActvSeqNo(paymentActivity.getId().getActvSeqNo());
                        request.setBan(Long.valueOf(ban));
                        request.setActvAmt(actvAmt);
                        request.setActvDate(new Date());
                        request.setEntSeqNo(paymentActivity.getId().getEntSeqNo());
                        request.setOperatorId(Long.valueOf(user.getUserId()));
                        System.out.println("Refund request:"+"EntSeqNo="+request.getEntSeqNo()+" "+request.toString());

                        RestResponse response = backoutService.proccessBackout(request);
                        return  response;
                    }catch (Exception ex){
                        ex.printStackTrace();
                        return null;
                    }
                }

                @Override
                protected void onPostExecute(Object o) {
                    super.onPostExecute(o);

                    try{
                        if(o==null){
                            throw new Exception("Backout failed processing!");
                        }
                        RestResponse response = (RestResponse)o;

                        String message = "Status : "+response.getStatus()+"\n";
                        message += response.getMessage()+"\n";
                        if(response.getErrors()!=null){
                            for(String errorMes : response.getErrors()){
                                message += errorMes+"\n";
                            }
                        }
                        if(response.getStatus()==200){
                            BillingAccountDto bill = new BillingAccountDto();
                            bill.setBan(Long.valueOf(ban));
                            setSuccessBackout(true);
                        }else {
                            setSuccessBackout(false);
                        }
                        popupWindow.dismiss();
                        loadDialog.dismiss();
                        alert(message);

                    }catch (Exception ex){
                        loadDialog.dismiss();
                        ex.printStackTrace();
                        alert(ex.getMessage());

                    }
                }
            };
            processBackout.execute();



        }catch (Exception ex){

            ex.printStackTrace();
            alert(ex.getMessage());
        }


    }




    public Map<String, String> getDropDownBackoutResonMap() {
        return dropDownBackoutResonMap;
    }

    public void setDropDownBackoutResonMap(Map<String, String> dropDownBackoutResonMap) {
        this.dropDownBackoutResonMap = dropDownBackoutResonMap;
    }


}
