package truecorp.ensemble;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import truecorp.core.dataservice.LoginService;
import truecorp.core.model.M203UserDto;
import truecorp.core.session.Session;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);


        final AlertDialog.Builder alertBuilder =  new AlertDialog.Builder(MainActivity.this);
        alertBuilder.setMessage("Not found!");
        alertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        Button button= (Button) findViewById(R.id.loginButton);
        final TextView alertMsg = findViewById(R.id.alertMsg);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                v.setEnabled(false);
                alertMsg.setText("Login processing...");
                final ProgressDialog loadDialog = ProgressDialog.show(MainActivity.this,"Loging processing...","Please wait",true,false);

                AsyncTask loginValidateTask = new AsyncTask() {
                    @Override
                    protected Object doInBackground(Object[] objects) {
                        LoginService loginService = new LoginService();
                        try{
                            String username = ((EditText)findViewById(R.id.userName)).getText().toString();
                            String password = ((EditText)findViewById(R.id.password)).getText().toString();
                            M203UserDto  user =  loginService.sendLogin(username,password);
                            return user;
                        }catch(Exception ex){
                            ex.printStackTrace();
                            return null;

                        }

                    }

                    @Override
                    protected void onPostExecute(Object o) {
                        super.onPostExecute(o);

                        try{
                            if(o==null){
                                throw new Exception("Login Exeption!");
                            }else if(o instanceof M203UserDto){
                                M203UserDto user =(M203UserDto)o;
                                if(user.getFirstName()==null){
                                    throw new Exception("Login Fail!");
                                }else{
                                    Session.setAttribute("user",user);
                                }
                            }else{
                                throw new Exception("Login Exeption!");
                            }
                            alertMsg.setText("Login Success");
                            Intent Intent = new Intent(v.getContext(), MenuActivity.class);
                            v.getContext().startActivity(Intent);
                            v.setEnabled(true);
                            loadDialog.dismiss();
                        }catch (Exception ex){
                            v.setEnabled(true);
                            loadDialog.dismiss();
                            alertBuilder.setMessage(ex.getMessage());
                            alertBuilder.show();
                            alertMsg.setText(ex.getMessage());
                            ex.printStackTrace();

                        }

                    }
                };
                loginValidateTask.execute();

            }
        });


    }

    public void loginValidate(){




    }

    public final void toast(String text){

        Toast.makeText(this,
                text, Toast.LENGTH_LONG).show();

    }

}
