package truecorp.ensemble.components;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import truecorp.core.dataservice.CustomerService;
import truecorp.core.model.M203UserDto;
import truecorp.core.session.Session;
import truecorp.ensemble.MainActivity;
import truecorp.ensemble.MenuActivity;
import truecorp.ensemble.R;

/**
 * Created by Jennarong Pinjai on 15/1/2561.
 */

public class TitleComponent {

    public static void setupTitle(String titleName, boolean haveAccName, boolean haveBack, boolean haveReload,boolean haveMenu,final Activity context){

        TextView titleCom = context.findViewById(R.id.titleComponent);
        titleCom.setText(titleName);

        ImageButton backBtn = context.findViewById(R.id.backBtn);
        TextView  userDetailTop = context.findViewById(R.id.userDetailTop);
        ImageButton reloadBtn = context.findViewById(R.id.reloadBtn);
        ImageView menuBtn = context.findViewById(R.id.toMenuBtn);

        if(haveBack){

            backBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.onBackPressed();
                }
            });
        }else{
            backBtn.setVisibility(View.INVISIBLE);
        }

        if(haveAccName){
            final CustomerService cusService = new CustomerService();

            M203UserDto user = (M203UserDto) Session.getAttribute("user");
            userDetailTop.setText("Hi "+(user.getFirstName()==null?"":user.getFirstName()) +" "+(user.getLastName()==null?"":user.getLastName()));
        }else{
            userDetailTop.setVisibility(View.INVISIBLE);
        }

        if(haveReload){

            reloadBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.finish();
                    context.startActivity(context.getIntent());
                }
            });

        }else{
            reloadBtn.setVisibility(View.INVISIBLE);
        }

        if(haveMenu){

            menuBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // context.finish();
                    context.navigateUpTo(new Intent(context.getBaseContext(),MenuActivity.class));
                }
            });

        }else{
            menuBtn.setVisibility(View.INVISIBLE);
        }


    }

}
