package truecorp.ensemble.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import truecorp.core.model.RefundDto;
import truecorp.core.model.SubscriberDto;
import truecorp.ensemble.BillingAccountActivity;
import truecorp.ensemble.R;

/**
 * Created by Jennarong Pinjai on 19/2/2561.
 */

public class RefundHistoryInfoDialog extends BaseDialogFragment {

    private RefundDto refund;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        try{

            View popupView = inflater.inflate(R.layout.refund_detail_layout,container,false);

            TextView iconClose = popupView.findViewById(R.id.icon_close_popup);
            final Dialog popupWindow = getDialog();
            iconClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                }
            });
            String amountFormat ="%,.2f";

            TextView refundDateView = popupView.findViewById(R.id.refund_date_detail_text_popup);
            refundDateView.setText(refund.getActvDate()==null?"":BillingAccountActivity.dateFormat_NO_CLOCK.format(refund.getActvDate()));

            TextView refundReasonView = popupView.findViewById(R.id.refund_reason_detail_text_popup);
            refundReasonView.setText(refund.getRefundReason()==null?"":refund.getRefundReason().getRefundReasonCode());

            TextView refundDescView = popupView.findViewById(R.id.refund_description_detail_text_popup);
            refundDescView.setText(refund.getRefundReason()==null?"":refund.getRefundReason().getRefundDesc());

            double totalRefund = refund.getActvAmt()==null?0:refund.getActvAmt().doubleValue();
            double taxRefund   = refund.getVatAmt()==null?0:refund.getVatAmt().doubleValue();
            double amount      = totalRefund - taxRefund;

            TextView refundAmountView = popupView.findViewById(R.id.refund_amount_detail_text_popup);
            refundAmountView.setText(String.format("%,.2f",amount));

            TextView refundTaxView = popupView.findViewById(R.id.refund_tax_detail_text_popup);
            refundTaxView.setText(String.format("%,.2f",taxRefund));

            TextView refundTotalView = popupView.findViewById(R.id.refund_total_detail_text_popup);
            refundTotalView.setText(String.format("%,.2f",totalRefund));

            TextView refundCNView = popupView.findViewById(R.id.refund_cn_number_detail_text_popup);
            refundCNView.setText(refund.getCnNumber()==null?"":refund.getCnNumber());

            TextView refundBillCommentView = popupView.findViewById(R.id.refund_bill_comment_text_popup);
            refundBillCommentView.setText(refund.getBillComment()==null?"":refund.getBillComment());


            return popupView;
        }catch (Exception ex){

            ex.printStackTrace();
            return null;
        }

    }

    public RefundDto getRefund() {
        return refund;
    }

    public void setRefund(RefundDto refund) {
        this.refund = refund;
    }
}
