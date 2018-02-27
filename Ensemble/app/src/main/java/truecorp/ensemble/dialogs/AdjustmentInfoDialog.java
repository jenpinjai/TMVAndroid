package truecorp.ensemble.dialogs;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import truecorp.core.model.AdjustmentDto;
import truecorp.core.model.AdjustmentsDto;
import truecorp.core.model.BillingAccountDto;
import truecorp.core.model.InvoiceItemDto;
import truecorp.ensemble.AdjustmentActivity;
import truecorp.ensemble.BillingAccountActivity;
import truecorp.ensemble.R;

/**
 * Created by Jennarong Pinjai on 19/2/2561.
 */

public class AdjustmentInfoDialog extends BaseDialogFragment {

    private AdjustmentsDto adjustment;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        try{

            View popupView = inflater.inflate(R.layout.adjustment_detail_layout,container,false);

            TextView iconClose = popupView.findViewById(R.id.icon_close_popup);
            final Dialog popupWindow = getDialog();
            iconClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                }
            });
            String amountFormat ="%,.2f";

            TextView adjDateView = popupView.findViewById(R.id.adjustment_date_detail_text_popup);
            adjDateView.setText(adjustment.getActvDate()==null?"":BillingAccountActivity.dateFormat_NO_CLOCK.format(adjustment.getActvDate()));

            TextView adjLevelView = popupView.findViewById(R.id.adjustment_level_detail_text_popup);
            adjLevelView.setText(adjustment.getAdjLevelCode()==null?"":adjustment.getAdjLevelCode());

            TextView adjReasonView = popupView.findViewById(R.id.adjustment_reson_detail_text_popup);
            adjReasonView.setText(adjustment.getActvReasonCode()==null?"":adjustment.getActvReasonCode());

            TextView adjDescView = popupView.findViewById(R.id.adjustment_description_detail_text_popup);
            adjDescView.setText(adjustment.getAdjustmentReason()==null?"":adjustment.getAdjustmentReason().getAdjDsc());

            TextView adjSubscriberView = popupView.findViewById(R.id.adjustment_subscriber_detail_text_popup);
            adjSubscriberView.setText(adjustment.getSubscriberNo()==null?"":adjustment.getSubscriberNo());

            double adjAmount =adjustment.getActvAmt()==null?0:adjustment.getActvAmt().doubleValue();
            TextView adjAmountView = popupView.findViewById(R.id.adjustment_amount_detail_text_popup);
            adjAmountView.setText(String.format("%,.2f",adjAmount));

            double adjTax =adjustment.getTaxAmount()==null?0:adjustment.getTaxAmount().doubleValue();
            TextView adjTaxView = popupView.findViewById(R.id.adjustment_tax_detail_text_popup);
            adjTaxView.setText(String.format("%,.2f",adjTax));

            double total = adjAmount + adjTax;
            TextView adjTotalView = popupView.findViewById(R.id.adjustment_total_detail_text_popup);
            adjTotalView.setText(String.format("%,.2f",total));

            TextView adjCRDRView = popupView.findViewById(R.id.adjustment_cr_dr_ban_text_popup);
            adjCRDRView.setText(adjustment.getCreditNoteNo()==null?"":adjustment.getCreditNoteNo());

            return popupView;
        }catch (Exception ex){

            ex.printStackTrace();
            return null;
        }

    }

    public AdjustmentsDto getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(AdjustmentsDto adjustment) {
        this.adjustment = adjustment;
    }
}
