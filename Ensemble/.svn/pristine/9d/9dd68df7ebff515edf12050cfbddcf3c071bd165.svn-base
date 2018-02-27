package truecorp.ensemble;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import truecorp.core.dataservice.BillingAccountService;
import truecorp.core.model.BillingAccountDto;
import truecorp.ensemble.components.TitleComponent;

public class SearchBANForCreatePaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_search_banfor_create_payment);
        TitleComponent.setupTitle("Create Payment",false,true,false,true,this);

        Button nextBtn = findViewById(R.id.next_create_payment_btn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    search();
                }catch (Exception ex){
                    alert(ex.getMessage());
                    ex.printStackTrace();

                }
            }
        });

        final EditText banInputView = findViewById(R.id.ban_num_set_create_payment);
        banInputView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                try {
                    if(event.getAction()==KeyEvent.ACTION_UP){
                        if(banInputView.getText().toString().length()==9){
                            search();
                        }
                    }
                }catch (Exception ex){
                    ex.printStackTrace();

                }

                return false;
            }
        });


    }


    public void search() throws Exception{

        try{
            EditText banInputView = findViewById(R.id.ban_num_set_create_payment);




            final String searchValue = banInputView.getText().toString();


            if(searchValue==null||searchValue.trim().isEmpty()){
                throw new Exception("BAN is empty.\nPlease enter BAN number.");
            }

            List<BillingAccountDto> billList = new ArrayList<BillingAccountDto>();

            final ProgressDialog loadDialog = ProgressDialog.show(this,"Searching...","Please wait",true,false);


            AsyncTask sendQuery = new AsyncTask() {
                @Override
                protected Object doInBackground(Object[] objects) {
                    try{
                        BillingAccountService billService = new BillingAccountService();
                        String field = "BAN";
                        Object result = null;

                        //alert("BAN");
                        field = "BAN";
                        result = billService.searchBillingAccount(field,searchValue);

                        return result;
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
                            throw new Exception("BAN not found!");
                        }

                        if(o instanceof ArrayList){
                            List<BillingAccountDto> billList = (ArrayList<BillingAccountDto>)o;
                            if(billList.size()==0){
                                throw new Exception("BAN not found!");
                            }

                            Intent intent = new Intent(SearchBANForCreatePaymentActivity.this, CreatePaymentActivity.class);
                            intent.putExtra("billingAccount",billList.get(0));
                            SearchBANForCreatePaymentActivity.this.startActivity(intent);


                        }
                        loadDialog.dismiss();
                    }catch (Exception ex){
                        loadDialog.dismiss();
                        alert(ex.getMessage());
                        ex.printStackTrace();
                    }


                }
            };

            sendQuery.execute();

        }catch (Exception ex){

            alert(ex.getMessage());
            ex.printStackTrace();

        }

    }
    public void alert(String message){

        AlertDialog.Builder alertBuilder =  new AlertDialog.Builder(SearchBANForCreatePaymentActivity.this);
        alertBuilder.setMessage(message);
        alertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertBuilder.show();


    }
}
