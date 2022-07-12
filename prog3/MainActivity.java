package com.example.login_signup_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText txtUsername;
    EditText txtPassword;
    Button btnSignup;
    String re ="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUsername=(EditText)findViewById(R.id.text_username);
        txtPassword=(EditText)findViewById(R.id.text_password);
        btnSignup = (Button) findViewById(R.id.btn_signup);
        btnSignup.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        String username = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();

        if(validatePassword(password))
        {
            Bundle bundle=new Bundle();
            bundle.putString("Sivani",username);
            bundle.putString("Sivanipass@123",password);

            Intent it = new Intent(this,activity_login.class);
            it.putExtra("data",bundle);

            startActivity(it);
        }
        else
        {
            Toast.makeText(getBaseContext(),"Invalid Password",Toast.LENGTH_LONG).show();
        }
    }
    public boolean validatePassword(String pwd)
    {
        Pattern pattern = Pattern.compile(re);
        Matcher matcher = pattern.matcher(pwd);
        return matcher.matches();
    }
}
