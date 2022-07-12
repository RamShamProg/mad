import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnStart, btnStop;
    TextView lblCounter;
    int counter=0;
    boolean running=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart=(Button)findViewById(R.id.btn_start);
        btnStart.setOnClickListener(this);
        btnStop=(Button)findViewById(R.id.btn_stop);
        btnStop.setOnClickListener(this);
        lblCounter=(TextView) findViewById(R.id.lbl_text);
    }

    public void onClick(View v) {
        if(v.equals(btnStart)){
            counter=0;
            running=true;
            new MyCounter().start();
        } else if(v.equals(btnStop)) {
            running=false;
        }

    }


    Handler handler = new Handler(Looper.getMainLooper())
    {
        public void handleMessage(Message m){
            lblCounter.setText(String.valueOf(m.what));
        }
    };


    class MyCounter extends Thread{
        public void run()
        {
            while(running){
                counter++;
                handler.sendEmptyMessage(counter);
                try{
                    Thread.sleep(1000);
                } catch(Exception e){}

            }
        }
    }
}