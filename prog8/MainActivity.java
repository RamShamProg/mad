package com.example.phonedialer;

import javax.swing.text.View;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnOne,btnTwo,btnThree,btnFour,btnFive,btnSix,btnSeven,btnEight,btnNine,btnZero,btnDel,btnStar,btnHash,btnSave,btnCall;
    EditText txtPhonenumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOne = (Button) findViewById(R.id.btn_one);
        btnTwo = (Button) findViewById(R.id.btn_two);
        btnThree= (Button) findViewById(R.id.btn_three);
        btnFour= (Button) findViewById(R.id.btn_four);
        btnFive= (Button) findViewById(R.id.btn_five);
        btnSix= (Button) findViewById(R.id.btn_six);
        btnSeven= (Button) findViewById(R.id.btn_seven);
        btnEight= (Button) findViewById(R.id.btn_eight);
        btnNine= (Button) findViewById(R.id.btn_nine);
        btnZero= (Button) findViewById(R.id.btn_zero);
        btnDel= (Button) findViewById(R.id.btn_delete);
        btnStar= (Button) findViewById(R.id.btn_star);
        btnHash= (Button) findViewById(R.id.btn_hash);
        btnSave= (Button) findViewById(R.id.btn_save);
        btnCall= (Button) findViewById(R.id.btn_call);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnZero.setOnClickListener(this);
        btnStar.setOnClickListener(this);
        btnHash.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnCall.setOnClickListener(this);
        btnDel.setOnClickListener(this);

        txtPhonenumber = (EditText) findViewById(R.id.txt_phonenumber);
        txtPhonenumber.setText("");
    }

    @Override
    public void onClick(View v) {
        if(v.equals(btnOne))    txtPhonenumber.append("1");
        else if(v.equals(btnTwo))    txtPhonenumber.append("2");
        else if(v.equals(btnThree))    txtPhonenumber.append("3");
        else if(v.equals(btnFour))    txtPhonenumber.append("4");
        else if(v.equals(btnFive))    txtPhonenumber.append("5");
        else if(v.equals(btnSix))    txtPhonenumber.append("6");
        else if(v.equals(btnSeven))    txtPhonenumber.append("7");
        else if(v.equals(btnEight))    txtPhonenumber.append("8");
        else if(v.equals(btnNine))    txtPhonenumber.append("9");
        else if(v.equals(btnZero))    txtPhonenumber.append("0");
        else if(v.equals(btnStar))    txtPhonenumber.append("*");
        else if(v.equals(btnHash))    txtPhonenumber.append("#");
        else if(v.equals(btnSave))
        {
            Intent contactintent = new Intent(ContactsContract.Intents.Insert.ACTION);
            contactintent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
            contactintent.putExtra(ContactsContract.Intents.Insert.PHONE,txtPhonenumber.getText().toString());
            startActivity(contactintent);
        }
        else if(v.equals(btnDel))
        {
            String data =txtPhonenumber.getText().toString();
            if(data.length()>0)
            {
                txtPhonenumber.setText(data.substring(0,data.length()-1));
            }
            else
            {
                txtPhonenumber.setText("");
            }
        }
        btnCall.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String data = txtPhonenumber.getText().toString();
                Intent intent= new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+data));
                startActivity(intent);
            }

        });


    }
}