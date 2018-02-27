package truecorp.ensemble.dialogs;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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
import truecorp.core.model.BillingAccountDto;
import truecorp.core.model.InvoiceItemDto;
import truecorp.core.model.PaymentActivityDto;
import truecorp.core.model.PaymentDto;
import truecorp.core.model.SelectItem;
import truecorp.ensemble.AdjustmentActivity;
import truecorp.ensemble.BillingAccountActivity;
import truecorp.ensemble.R;

/**
 * Created by Jennarong Pinjai on 19/2/2561.
 */

public class PaymentInfoDialog extends BaseDialogFragment {


    private String ban;
    private PaymentDto payment;
    private PaymentActivityDto paymentActivity;
    private boolean createAdjustClicked=false;
    private boolean refundSuccess = false;
    private boolean successBackout=false;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        try{

            final View popupView = inflater.inflate(R.layout.payment_detail_layout,container,false);

            TextView iconClose = popupView.findViewById(R.id.icon_close_popup);
            final Dialog popupWindow = getDialog();
            iconClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                }
            });
            String amountFormat ="%,.2f";


            TextView postingDateView = popupView.findViewById(R.id.payment_posting_date_detail_text_popup);
            postingDateView.setText(paymentActivity.getActvDate()==null?"":BillingAccountActivity.dateFormat_NO_CLOCK.format(paymentActivity.getActvDate()));

            TextView sourceView = popupView.findViewById(R.id.payment_source_detail_text_popup);
            String sourceType =payment.getSourceType()==null?"":payment.getSourceType();
            String sourceId   =payment.getSourceId()==null?"":payment.getSourceId();
            String source = sourceType+" "+sourceId;
            sourceView.setText(source);

            TextView invoiceNumberView = popupView.findViewById(R.id.payment_invoice_no_detail_text_popup);
            invoiceNumberView.setText(payment.getInvoiceNumber()==null?"":payment.getInvoiceNumber());

            TextView methodView = popupView.findViewById(R.id.payment_method_detail_text_popup);
            String pymType=payment.getPymType()==null?"":payment.getPymType();
            String pymSubType=payment.getPymSubType()==null?"":payment.getPymSubType();
            String method = pymType+" "+pymSubType;
            methodView.setText(method);

            TextView postingPeriodView = popupView.findViewById(R.id.payment_posting_period_detail_text_popup);
            postingPeriodView.setText(paymentActivity.getPostingPeriod()==null?"":String.format("%.0f",paymentActivity.getPostingPeriod()));

            TextView lastActivityView = popupView.findViewById(R.id.payment_last_activity_detail_text_popup);
            lastActivityView.setText(paymentActivity.getActvCode()==null?"":paymentActivity.getActvCode());

            TextView originalAccountView = popupView.findViewById(R.id.payment_original_account_detail_text_popup);
            originalAccountView.setText(payment.getOriginalBan()==null?"":String.format("%.0f",payment.getOriginalBan()));

            TextView actualAmountView = popupView.findViewById(R.id.payment_actual_amount_text_popup);
            actualAmountView.setText(paymentActivity.getActvAmt()==null?"0.00":String.format("%,.2f",paymentActivity.getActvAmt()));

            TextView originalAmountView = popupView.findViewById(R.id.payment_original_amount_text_popup);
            originalAmountView.setText(payment.getOriginalAmount()==null?"0.00":String.format("%,.2f",payment.getOriginalAmount()));


            TextView batchIdView = popupView.findViewById(R.id.payment_batch_id_text_popup);
            batchIdView.setText(payment.getBatchNo()==null?"":String.format("%.0f",payment.getBatchNo()));

            TextView batchLineNumberView = popupView.findViewById(R.id.payment_batch_line_number_text_popup);
            batchLineNumberView.setText(payment.getBatchLineNo()==null?"":String.format("%.0f",payment.getBatchLineNo()));

            TextView bankCodeView = popupView.findViewById(R.id.payment_bank_code_text_popup);
            bankCodeView.setText(paymentActivity.getBankCode()==null?"":paymentActivity.getBankCode());

            TextView bankAccountView = popupView.findViewById(R.id.payment_bank_account_text_popup);
            bankAccountView.setText(paymentActivity.getBankAccountNo()==null?"":paymentActivity.getBankAccountNo());

            TextView originalVoucherView = popupView.findViewById(R.id.payment_original_voucher_text_popup);
            originalVoucherView.setText(payment.getDirctDbtVoucher()==null?"":payment.getDirctDbtVoucher());

            TextView fileSeqView = popupView.findViewById(R.id.payment_file_seq_text_popup);
            fileSeqView.setText(payment.getFileSeqNo()==null?"":String.format("%.0f",payment.getFileSeqNo()));

            TextView paymentIdView = popupView.findViewById(R.id.payment_id_text_popup);
            paymentIdView.setText(paymentActivity.getActvBillSeqNo()==null?"":String.format("%.0f",paymentActivity.getActvBillSeqNo()));

            int textMaxWidth = 250;
            int maxLines=20;

            TextView text1View = popupView.findViewById(R.id.payment_text1_text_popup);
            text1View.setText(payment.getPaymentText1()==null?"":payment.getPaymentText1().trim());
            text1View.setEllipsize(TextUtils.TruncateAt.END);
            text1View.setMaxLines(maxLines);
            text1View.setHorizontallyScrolling(false);
            text1View.setMaxWidth(textMaxWidth);

            TextView text2View = popupView.findViewById(R.id.payment_text2_text_popup);
            text2View.setText(payment.getPaymentText2()==null?"":payment.getPaymentText2().trim());
            text2View.setEllipsize(TextUtils.TruncateAt.END);
            text2View.setMaxLines(maxLines);
            text2View.setHorizontallyScrolling(false);
            text2View.setMaxWidth(textMaxWidth);


            TextView text3View = popupView.findViewById(R.id.payment_text3_text_popup);
            text3View.setText(payment.getPaymentText3()==null?"":payment.getPaymentText3().trim());
            text3View.setEllipsize(TextUtils.TruncateAt.END);
            text3View.setHorizontallyScrolling(false);
            text3View.setMaxLines(maxLines);
            text3View.setMaxWidth(textMaxWidth);

            Button backoutBtn = popupView.findViewById(R.id.backout_payment_btn);

            backoutBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openBackoutPopup();
                }
            });

            Button refundBtn = popupView.findViewById(R.id.refund_payment_btn);

            refundBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openRefundPopup();
                }
            });

            return popupView;
        }catch (Exception ex){

            ex.printStackTrace();
            return null;
        }

    }


    public void openBackoutPopup(){

        try{
            // create the popup window

            final BackoutFormDialog backoutFormDialog = new BackoutFormDialog();

            backoutFormDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    hideKeyboard();
                }
            });
            backoutFormDialog.setMainView(getView());
            backoutFormDialog.setWidth(getWidth());
            backoutFormDialog.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
            backoutFormDialog.setBan(getBan());
            backoutFormDialog.setPayment(getPayment());
            backoutFormDialog.setPaymentActivity(getPaymentActivity());
            backoutFormDialog.show(getFragmentManager(),"Backout Form");

            backoutFormDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    setSuccessBackout(backoutFormDialog.isSuccessBackout());
                }
            });

        }catch (Exception ex){
            ex.printStackTrace();
            alert(ex.getMessage());
        }

    }


    public void openRefundPopup(){

        try{
            // create the popup window
            final RefundFormDialog refundFormDialog = new RefundFormDialog();

            refundFormDialog.setWidth(getWidth());
            refundFormDialog.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
            refundFormDialog.setBan(getBan());
            refundFormDialog.setPayment(getPayment());
            refundFormDialog.setPaymentActivity(getPaymentActivity());
            refundFormDialog.setMainView(getView());
            refundFormDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {

                    setRefundSuccess(refundFormDialog.isRefundSuccess());

                }
            });
            refundFormDialog.show(getFragmentManager(),"Refund form");

        }catch (Exception ex){
            ex.printStackTrace();
            alert(ex.getMessage());
        }

    }

    public boolean isCreateAdjustClicked() {
        return createAdjustClicked;
    }

    public void setCreateAdjustClicked(boolean createAdjustClicked) {
        this.createAdjustClicked = createAdjustClicked;
    }

    public PaymentDto getPayment() {
        return payment;
    }

    public void setPayment(PaymentDto payment) {
        this.payment = payment;
    }

    public PaymentActivityDto getPaymentActivity() {
        return paymentActivity;
    }

    public void setPaymentActivity(PaymentActivityDto paymentActivity) {
        this.paymentActivity = paymentActivity;
    }

    public String getBan() {
        return ban;
    }

    public void setBan(String ban) {
        this.ban = ban;
    }

    public boolean isRefundSuccess() {
        return refundSuccess;
    }

    public void setRefundSuccess(boolean refundSuccess) {
        this.refundSuccess = refundSuccess;
    }

    public boolean isSuccessBackout() {
        return successBackout;
    }

    public void setSuccessBackout(boolean successBackout) {
        this.successBackout = successBackout;
    }
}
