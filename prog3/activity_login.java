package com.example.login_signup_page;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_login extends AppCompatActivity implements View.OnClickListener {
    EditText txtLoginUsername;
    EditText txtLoginPassword;
    Button btnLogin;
    String user,pass;
    int count=0;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtLoginUsername=(EditText)findViewById(R.id.text_login_username);
        txtLoginPassword=(EditText)findViewById(R.id.text_login_password);
        btnLogin = (Button) findViewById(R.id.btn_login_signup);

        btnLogin.setOnClickListener(this);

        Bundle bundle = getIntent().getBundleExtra("data");
        user = bundle.getString("Sivani");
        pass = bundle.getString("Sivanipass@123");
    }
    @Override
    public void onClick(View v) {
        String user1 = txtLoginUsername.getText().toString();
        String pass1 = txtLoginPassword.getText().toString();
        if(user.equals(user1)&&pass.equals(pass1))
        {
            Toast.makeText(getBaseContext(),"Login Success", Toast.LENGTH_LONG).show();
        }
        else
        {
            count++;
            if(count==3)
            {
                btnLogin.setEnabled(false);
            }
            else
            {
                Toast.makeText(getBaseContext(),"Login Failed"+count, Toast.LENGTH_LONG).show();
            }
        }
    }

}
