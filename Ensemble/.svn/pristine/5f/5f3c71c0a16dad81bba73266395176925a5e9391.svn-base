package truecorp.ensemble.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.springframework.http.HttpStatus;

import truecorp.core.model.FileUploadResponse;
import truecorp.core.model.RefundDto;
import truecorp.core.model.RestResponse;
import truecorp.ensemble.BillingAccountActivity;
import truecorp.ensemble.R;

/**
 * Created by Jennarong Pinjai on 19/2/2561.
 */

public class SuccessCreatePaymentInfoDialog extends BaseDialogFragment {

    private FileUploadResponse response;
    private boolean success=false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        try{

            View popupView = inflater.inflate(R.layout.success_create_payment_popup,container,false);

            TextView iconClose = popupView.findViewById(R.id.icon_close_popup);
            final Dialog popupWindow = getDialog();
            iconClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                }
            });
            TableLayout mainTable = popupView.findViewById(R.id.create_payment_alert_table_popup);

            if(response.getStatus()!= HttpStatus.OK.value()){


                success=false;
                TextView titleAlert = popupView.findViewById(R.id.title_create_payment_alert_popup);
                titleAlert.setText("Create Fail");


                mainTable.removeViews(1,3);

                TableRow headerTitleTabRow = popupView.findViewById(R.id.create_payment_alert_row_header_popup);
                headerTitleTabRow.setBackgroundColor(popupView.getResources().getColor(R.color.red_dark));

                TextView errorTextView = popupView.findViewById(R.id.error_msg_create_payment_alert_popup);
                errorTextView.setText(response.getErrors()==null?"":response.getErrors().toString());


            }else{
                success = true;

                TextView nameTextView = popupView.findViewById(R.id.name_create_payment_success_popup);
                nameTextView.setText(response.getFileName()==null?"":response.getFileName());

                TextView pathTextView = popupView.findViewById(R.id.path_create_payment_success_popup);
                pathTextView.setText(response.getFilePath()==null?"":response.getFilePath());

                TextView sizeTextView = popupView.findViewById(R.id.size_create_payment_success_popup);
                sizeTextView.setText(response.getFileSize()==null?"":response.getFileSize());

            }
            return popupView;
        }catch (Exception ex){

            ex.printStackTrace();
            return null;
        }

    }

    public FileUploadResponse getResponse() {
        return response;
    }

    public void setResponse(FileUploadResponse response) {
        this.response = response;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
