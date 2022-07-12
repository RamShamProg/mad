package com.example.wallpaper;

import androidx.appcompat.app.AppCompatActivity;
import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Button;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnChangeWallpaper;
    boolean running;
    int[] imagesArray = new int[]{
            R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,
            R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,
            R.drawable.img9,R.drawable.img10,R.drawable.img11,R.drawable.img12
    };
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChangeWallpaper = (Button) findViewById(R.id.btn_start_change_wallpaper);
        btnChangeWallpaper.setOnClickListener(this);
    }
    public void onClick(View v)
    {
        if(!running)
        {
            new Timer().schedule(new MyTimer(),0,3000);
            running=true;
        }
    }

    class MyTimer extends TimerTask
    {
        public void run()
        {
            try {
                WallpaperManager wallpaperManager=WallpaperManager.getInstance(getBaseContext());
                Random random = new Random();
                wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(),imagesArray[random.nextInt(12)]));
            }
            catch(Exception e)
            {

            }

        }
    }
}
