package truecorp.ensemble;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.support.annotation.Nullable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

import truecorp.core.dataservice.AdjustmentService;
import truecorp.core.dataservice.BillingAccountService;
import truecorp.core.model.AdjustmentDto;
import truecorp.core.model.BillingAccountDto;
import truecorp.core.model.InvoiceItemDto;
import truecorp.core.model.RestResponse;
import truecorp.core.model.SelectItem;
import truecorp.ensemble.components.TitleComponent;

public class AdjustmentActivity extends AppCompatActivity {


    static Long entSeqNo = 0l;
    static Long taxNo = 0l;
    static Date logicalDate = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adjustment);

        TitleComponent.setupTitle("Create Adjustment",false,true,false,true,this);

       final Spinner searchReason = findViewById(R.id.adjustReason);

       /* ArrayAdapter<String> crytiriaListAdap = new ArrayAdapter<String>(this,R.layout.spiner_item);*/
        final AdjustmentDto adjustDto = (AdjustmentDto)getIntent().getSerializableExtra("adjustment");
        InvoiceItemDto invoiceItemDto = (InvoiceItemDto)getIntent().getSerializableExtra("invoiceitem");

        entSeqNo = adjustDto.getEntSeqNo();
        taxNo = adjustDto.getTaxSeqNo();
        logicalDate = adjustDto.getLogicalDate();

        final EditText ban = findViewById(R.id.adjustBan);
        final EditText subscriNo = findViewById(R.id.adjustSubscriberNo);
        final EditText invoice = findViewById(R.id.adjustSearchInvoicePeriod);
        final EditText amt = findViewById(R.id.adjustAmount);
        final EditText creditNo = findViewById(R.id.adjustCreditNoteNo);
        ban.setText(Long.toString(adjustDto.getBan()));
        subscriNo.setText(adjustDto.getSubscriberNo());
        invoice.setText(adjustDto.getInvoicePeriod());
        amt.setText(adjustDto.getAmount().toString());
        creditNo.setText(adjustDto.getCreditNoteNo());

        ban.setEnabled(false);
        subscriNo.setEnabled(false);
        invoice.setEnabled(false);


        adjustDto.getEntSeqNo();



        AsyncTask sendQuery = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {

                try{
                    AdjustmentService adjustService = new AdjustmentService();
                    List<SelectItem> listReason = adjustService.searchAdjustReason();
                    return listReason;

                }catch (Exception ex){
                    ex.printStackTrace();
                    return null;
                }


            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                try{
                    List<SelectItem> lst = (List<SelectItem> )o;
                     ArrayAdapter<String> crytiriaListAdap = new ArrayAdapter<String>(AdjustmentActivity.this,R.layout.spiner_item);
                    for (int i =0;i < lst.size();i++) {
                        crytiriaListAdap.add(lst.get(i).getValue());
                    }
                    searchReason.setPrompt("Search by ");
                    searchReason.setAdapter(crytiriaListAdap);


                }catch (Exception ex){

                    ex.printStackTrace();
                }


            }
        };
        sendQuery.execute();

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Button button= (Button) findViewById(R.id.adjustSaveBtn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                final AdjustmentDto adjustDto = (AdjustmentDto)getIntent().getSerializableExtra("adjustment");
                final EditText amt = findViewById(R.id.adjustAmount);
                BigDecimal amount = adjustDto.getAmount();
                BigDecimal amtEditText = new BigDecimal(amt.getText().toString());

                if(amtEditText.doubleValue()<=amount.doubleValue()){
                    createAdjustment();
                }else{
                    alert("invalid amount : Amount more than invoice amount ");
                }
            }
        });
    }


    public void createAdjustment (){
        try {


            final AdjustmentDto adjustDto2 = new AdjustmentDto();

            final EditText ban = findViewById(R.id.adjustBan);
            final EditText subscriNo = findViewById(R.id.adjustSubscriberNo);
            final EditText invoice = findViewById(R.id.adjustSearchInvoicePeriod);
            final EditText amt = findViewById(R.id.adjustAmount);
            final EditText creditNo = findViewById(R.id.adjustCreditNoteNo);
            final Spinner reason = findViewById(R.id.adjustReason);

            adjustDto2.setBan(Long.parseLong(ban.getText().toString()));
            adjustDto2.setSubscriberNo(subscriNo.getText().toString());
            adjustDto2.setAmount(new BigDecimal(amt.getText().toString()));
            adjustDto2.setCreditNoteNo(creditNo.getText().toString());
            adjustDto2.setInvoicePeriod(invoice.getText().toString());
            adjustDto2.setReason(((String)reason.getSelectedItem()));
            adjustDto2.setEntSeqNo(entSeqNo);
            adjustDto2.setTaxSeqNo(taxNo);
            adjustDto2.setLogicalDate(logicalDate);


            AsyncTask sendQuery = new AsyncTask() {
                @Override
                protected Object doInBackground(Object[] objects) {

                    try{
                        AdjustmentService adjustService = new AdjustmentService();
                        RestResponse createAdjust = adjustService.createAdjustment(adjustDto2);
                        return createAdjust;

                    }catch (Exception ex){
                        ex.printStackTrace();
                        return null;
                    }


                }

                @Override
                protected void onPostExecute(Object o) {
                    super.onPostExecute(o);
                    try{
                        RestResponse response = (RestResponse )o;
                        if(response.getStatus()==200){
                            alert("Successfuly " );
                        }else{
                            alert("fail call web service "+response.getErrors());
                        }
                    }catch (Exception ex){

                        ex.printStackTrace();
                    }


                }
            };
            sendQuery.execute();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void alert(String message){

        AlertDialog.Builder alertBuilder =  new AlertDialog.Builder(AdjustmentActivity.this);
        alertBuilder.setMessage(message);
        alertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertBuilder.show();


    }

}
