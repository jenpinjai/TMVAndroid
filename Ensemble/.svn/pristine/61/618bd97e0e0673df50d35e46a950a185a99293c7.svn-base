package truecorp.ensemble.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import truecorp.core.model.AdjustmentsDto;
import truecorp.core.model.SubscriberDto;
import truecorp.ensemble.BillingAccountActivity;
import truecorp.ensemble.R;

/**
 * Created by Jennarong Pinjai on 19/2/2561.
 */

public class SubscriberInfoDialog extends BaseDialogFragment {

    private SubscriberDto subscriber;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        try{

            View popupView = inflater.inflate(R.layout.subscriber_detail_layout,container,false);

            TextView iconClose = popupView.findViewById(R.id.icon_close_popup);
            final Dialog popupWindow = getDialog();
            iconClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                }
            });
            String amountFormat ="%,.2f";

            TextView subscriberNoView = popupView.findViewById(R.id.subscriber_no_detail_text_popup);
            subscriberNoView.setText(subscriber.getId()==null?"":subscriber.getId().getSubscriberNo());

            TextView subscriberStatusView = popupView.findViewById(R.id.subscriber_status_detail_text_popup);
            subscriberStatusView.setText(subscriber.getSubStatus()==null?"":subscriber.getSubStatus());

            TextView subscriberStatusDateView = popupView.findViewById(R.id.subscriber_status_date_detail_text_popup);
            subscriberStatusDateView.setText(subscriber.getSubStatusDate()==null?"":BillingAccountActivity.dateFormat_NO_CLOCK.format(subscriber.getSubStatusDate()));

            TextView subscriberInitActvDateView = popupView.findViewById(R.id.subscriber_init_actv_date_detail_text_popup);
            subscriberInitActvDateView.setText(subscriber.getInitActivationDate()==null?"":BillingAccountActivity.dateFormat_NO_CLOCK.format(subscriber.getInitActivationDate()));

            TextView subscriberReasonView = popupView.findViewById(R.id.subscriber_reason_detail_text_popup);
            subscriberReasonView.setText(subscriber.getSubStatusRsnCode()==null?"":subscriber.getSubStatusRsnCode());

            TextView subscriberNextBanView = popupView.findViewById(R.id.subscriber_next_ban_detail_text_popup);
            subscriberNextBanView.setText(subscriber.getNextBan()==null?"":String.format("%.0f",subscriber.getNextBan()));

            TextView subscriberNextMoveBanView = popupView.findViewById(R.id.subscriber_next_ban_move_detail_text_popup);
            subscriberNextMoveBanView.setText(subscriber.getNextBanMoveDate()==null?"":BillingAccountActivity.dateFormat_NO_CLOCK.format(subscriber.getNextBanMoveDate()));

            TextView subscriberPreviousBanView = popupView.findViewById(R.id.subscriber_previous_ban_text_popup);
            subscriberPreviousBanView.setText(subscriber.getPrvBan()==null?"":String.format("%.0f",subscriber.getPrvBan()));

            TextView subscriberPreviousBanMoveView = popupView.findViewById(R.id.subscriber_previous_ban_move_text_popup);
            subscriberPreviousBanMoveView.setText(subscriber.getPrvBanMoveDate()==null?"":BillingAccountActivity.dateFormat_NO_CLOCK.format(subscriber.getPrvBanMoveDate()));


            return popupView;
        }catch (Exception ex){

            ex.printStackTrace();
            return null;
        }

    }

    public SubscriberDto getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(SubscriberDto subscriber) {
        this.subscriber = subscriber;
    }
}
