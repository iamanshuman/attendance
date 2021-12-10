package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splashscreen extends AppCompatActivity {

    private static int SPLASH_TIME = 3000;

    Animation topanim,bottomanim;
    TextView txt1,txt2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        topanim = AnimationUtils.loadAnimation(this,R.anim.top_anim);
        bottomanim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        imageView = findViewById(R.id.imageView);

        txt1.setAnimation(bottomanim);
        txt2.setAnimation(bottomanim);
        imageView.setAnimation(topanim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), PhoneNumber.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME);
    }
}