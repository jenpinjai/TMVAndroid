package truecorp.ensemble.dialogs;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Gravity;
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

import truecorp.core.dataservice.RefundService;
import truecorp.core.model.AdjustmentDto;
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

public class RefundFormDialog extends PaymentInfoDialog {

    private Map<String,String> dropDownRefundResonMap ;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        try{

            final View popupView = inflater.inflate(R.layout.refund_popup,container,false);

            TextView iconClose = popupView.findViewById(R.id.icon_close_popup);
            final Dialog popupWindow = getDialog();
            iconClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hideKeyboard();
                    popupWindow.dismiss();
                }
            });

            Button cancelBtn = popupView.findViewById(R.id.cancel_refund_btn);
            cancelBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hideKeyboard();
                    popupWindow.dismiss();
                }
            });

            final int spinnerMaxWidth =(int)(getWidth()/2);

            final Spinner  refund_reason_selected = popupView.findViewById(R.id.refund_reason_selected);
            refund_reason_selected.setPrompt("Refund reason");
            refund_reason_selected.setPopupBackgroundDrawable(popupView.getResources().getDrawable(R.drawable.spinner_background_white));

            final ProgressDialog loadDialog = ProgressDialog.show(getActivity(),"Loading Refund reason...","Please wait",true,false);

            AsyncTask loadReason = new AsyncTask() {
                @Override
                protected Object doInBackground(Object[] objects) {
                    try {
                        RefundService refundService = new RefundService();

                        List<SelectItem> items = refundService.searchRefundReason();
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
                        dropDownRefundResonMap = new HashMap<String,String>();

                        for(SelectItem item : items){

                            spinnerAdapter.add(item.getValueDesc());
                            dropDownRefundResonMap.put(item.getValueDesc(),item.getValue());

                        }

                        refund_reason_selected.setAdapter(spinnerAdapter);

                        Spinner.LayoutParams layoutParams = refund_reason_selected.getLayoutParams();
                        layoutParams.width = spinnerMaxWidth;
                        refund_reason_selected.setLayoutParams(layoutParams);


                        loadDialog.dismiss();
                    }catch (Exception ex){
                        loadDialog.dismiss();
                        ex.printStackTrace();
                        alert(ex.getMessage());
                    }


                }
            };
            loadReason.execute();


            final int textMaxWidh = (int)(getWidth()/1.6);

            EditText refundCNInput = popupView.findViewById(R.id.refund_cn_number_edit_text_popup);
            refundCNInput.setMaxWidth(textMaxWidh);

            EditText refundCommentInput = popupView.findViewById(R.id.refund_bill_comment_text_popup);
            refundCommentInput.setMaxWidth(textMaxWidh);

            Button confirmBtn = popupView.findViewById(R.id.confirm_refund_btn);

            confirmBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    try {
                        processRefund(popupWindow,popupView,getBan(),getPayment(),getPaymentActivity());
                    }catch (Exception ex){
                        ex.printStackTrace();
                        alert(ex.getMessage());

                    }

                }
            });



            return popupView;
        }catch (Exception ex){

            ex.printStackTrace();
            return null;
        }

    }
    public void processRefund(final Dialog popupWindow, final View rootView, final String ban, final PaymentDto payment , final PaymentActivityDto paymentActivity){

        try{
            final ProgressDialog loadDialog = ProgressDialog.show(getActivity(),"Processing Refund...","Please wait",true,false);

            AsyncTask processRefund = new AsyncTask() {
                @Override
                protected Object doInBackground(Object[] objects) {
                    try {
                        RefundService refundService = new RefundService();
                        RefundRequestDto request = new RefundRequestDto();
                        double invert = -1;
                        BigDecimal bckActvAmt = paymentActivity.getActvAmt()==null?BigDecimal.ZERO:paymentActivity.getActvAmt();
                        BigDecimal bckEuActvAmt = paymentActivity.getEuActvAmt()==null?BigDecimal.ZERO:paymentActivity.getEuActvAmt().multiply(BigDecimal.valueOf(invert));
                        Spinner reasonSelector = rootView.findViewById(R.id.refund_reason_selected);

                        EditText cnNumberInput = rootView.findViewById(R.id.refund_cn_number_edit_text_popup);
                        EditText commentInput  = rootView.findViewById(R.id.refund_bill_comment_text_popup);
                        String cnNumber = cnNumberInput.getText()==null?"":(cnNumberInput.getText().toString().trim().isEmpty()?"":cnNumberInput.getText().toString());
                        String comment = commentInput.getText()==null?"":(commentInput.getText().toString().trim().isEmpty()?"":commentInput.getText().toString());
                        String reasonDesc = String.valueOf(((TextView)reasonSelector.getSelectedView()).getText());
                        String reason = dropDownRefundResonMap.get(reasonDesc);
                        M203UserDto user = UserUtils.getUser();
                        request.setCnNumber(payment.getCheckNo());
                        request.setActvReasonCode(reason);
                        request.setCnNumber(cnNumber);
                        request.setBan(Long.valueOf(ban));
                        request.setActvAmt(bckActvAmt.doubleValue());
                        request.setBillComment(comment);
                        request.setEntSeqNo(paymentActivity.getId().getEntSeqNo());
                        request.setOperatorId(Long.valueOf(user.getUserId()));
                        System.out.println("Backout request:"+"EntSeqNo="+request.getEntSeqNo()+" "+request.toString());

                        RestResponse response = refundService.proccessRefund(request);
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
                            throw new Exception("Refund failed processing!");
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
                            setRefundSuccess(true);
                        }else{
                            setRefundSuccess(false);
                        }
                        popupWindow.dismiss();
                        loadDialog.dismiss();

                        alert(message);
                        hideKeyboard();


                    }catch (Exception ex){
                        loadDialog.dismiss();
                        ex.printStackTrace();
                        alert(ex.getMessage());


                    }
                }
            };
            processRefund.execute();



        }catch (Exception ex){

            ex.printStackTrace();
            alert(ex.getMessage());
        }


    }

    public Map<String, String> getDropDownRefundResonMap() {
        return dropDownRefundResonMap;
    }

    public void setDropDownRefundResonMap(Map<String, String> dropDownRefundResonMap) {
        this.dropDownRefundResonMap = dropDownRefundResonMap;
    }

}
