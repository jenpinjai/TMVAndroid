package truecorp.ensemble;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.springframework.web.client.RestClientException;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import truecorp.core.dataservice.CustomerService;
import truecorp.core.model.AdjustmentDto;
import truecorp.core.model.CustomerDto;
import truecorp.core.model.InvoiceItemDto;
import truecorp.core.model.M203UserDto;
import truecorp.core.session.Session;
import truecorp.ensemble.components.TitleComponent;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        //Remove title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu);
        TitleComponent.setupTitle("Menu",true,true,false,false,this);

        try{

            initListinerMenuButton();

        }catch(Exception ex){

            toast(ex.getMessage());
            ex.printStackTrace();

        }

    }

    public void initListinerMenuButton(){

        Button button= (Button) findViewById(R.id.jobMonMenuBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Intent = new Intent(v.getContext(), JobMonitorActivity.class);
                v.getContext().startActivity(Intent);

            }
        });

        Button billingAccbutton= (Button) findViewById(R.id.billingAccountMenuBtn);

        billingAccbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Intent = new Intent(v.getContext(), BillingAccountActivity.class);
                v.getContext().startActivity(Intent);

            }
        });

 /*       Button adjustButton = (Button) findViewById(R.id.AdjMenuBtn);

        adjustButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Intent = new Intent(v.getContext(), AdjustmentActivity.class);
                AdjustmentDto adj = new AdjustmentDto();
                adj.setBan(200068811l);
                adj.setAmount(new BigDecimal(981.70).setScale(2, RoundingMode.HALF_UP));
                adj.setCreditNoteNo("dddd");
                adj.setInvoicePeriod("200902");
                adj.setSubscriberNo("0891178963");
                adj.setEntSeqNo(86l);
                adj.setTaxSeqNo(86l);
                adj.setLogicalDate(Calendar.getInstance().getTime());
                Intent.putExtra("adjustment",adj);
                v.getContext().startActivity(Intent);

            }
        });*/

        Button fileControlButton = (Button) findViewById(R.id.fileControlMenuBtn);
        fileControlButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent Intent = new Intent(v.getContext(), FileControlActivity.class);
                v.getContext().startActivity(Intent);
            }
                                             }
        );

        Button createPaymentButton= (Button) findViewById(R.id.createPaymentMenuBtn);

        createPaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Intent = new Intent(v.getContext(), SearchBANForCreatePaymentActivity.class);
                v.getContext().startActivity(Intent);

            }
        });
    }

    public  void toast(String text){

        Toast.makeText(this,
                text, Toast.LENGTH_LONG).show();

    }
    public void alert(String message){

        AlertDialog.Builder alertBuilder =  new AlertDialog.Builder(MenuActivity.this);
        alertBuilder.setMessage(message);
        alertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertBuilder.show();


    }
}
