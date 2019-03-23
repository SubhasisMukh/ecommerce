package com.example.rajarshi.herb_o_cure;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpactivity extends AppCompatActivity {
    Context context;
    EditText uname, email, password, retypepassword, phno;
    MySQLiteAdapter mySQLiteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_upactivity);
        uname = (EditText) findViewById(R.id.editText1);
        email = (EditText) findViewById(R.id.editText2);
        password = (EditText) findViewById(R.id.editText3);
        retypepassword = (EditText) findViewById(R.id.editText4);
        phno = (EditText) findViewById(R.id.editText5);
        context = this;
        mySQLiteAdapter = new MySQLiteAdapter(context);

    }

    public void SubmitClicked(View view) {

        String usr_name = uname.getText().toString();
        String usr_email = email.getText().toString();
        String usr_passwd = password.getText().toString();
        String user_retype_pass = retypepassword.getText().toString();
        String usr_phno = phno.getText().toString();
        String[] attributes = {usr_name, usr_email, usr_passwd, user_retype_pass, usr_phno};


        if (validate(attributes)) {
            Toast.makeText(context, "Please Enter all of the credentials......", Toast.LENGTH_SHORT).show();


        } else {

            if (usr_passwd.equals(user_retype_pass)) {
                long id = mySQLiteAdapter.InsertRecord(usr_name, usr_email, usr_passwd, usr_phno);

                if (id == -1) {
                    Toast.makeText(this, "User already exists please sign in.....", Toast.LENGTH_SHORT).show();

                } else {
                    MainActivity mymainActivity = new MainActivity();
                    mymainActivity.finish();
                    this.finish();
                    startActivity(new Intent(getApplicationContext(), Congrats_Screen.class));
                    Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Password doesn't match please check again", Toast.LENGTH_SHORT).show();
            }


        }


    }


    public void resetClicked(View view) {
        uname.setText("");
        phno.setText("");
        email.setText("");
        password.setText("");
        retypepassword.setText("");
    }

    @Override
    public void onBackPressed() {
        this.finish();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        super.onBackPressed();
    }

    private boolean validate(String[] fields) {
        int flag = 0;
        for (int i = 0; i < fields.length; i++) {
            String currentField = fields[i];
            Log.e("validate:", currentField);
            if (currentField.isEmpty()) {
                flag = 1;
                break;
            }
        }

        if (flag == 1) {
            return true;
        } else {
            return false;

        }

    }

}
