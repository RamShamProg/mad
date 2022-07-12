package com.example.parsing_xml_json;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnParseXml,btnParseJson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnParseXml = (Button)findViewById(R.id.btn_parsexml);
        btnParseJson = (Button)findViewById(R.id.btn_parsejson);
        btnParseXml.setOnClickListener(this);
        btnParseJson.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(btnParseJson))
        {
            Intent it = new Intent(this,Activity_view.class);
            it.putExtra("mode",1);
            startActivity(it);
        }
        else if(v.equals(btnParseXml))
        {
            Intent it = new Intent(this,Activity_view.class);
            it.putExtra("mode",2);
            startActivity(it);
        }
    }
}