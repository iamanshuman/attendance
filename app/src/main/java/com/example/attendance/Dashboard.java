package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.StatusBarManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ResourceBundle;

public class Dashboard extends AppCompatActivity {

    Button Button;
    CardView cv1,cv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Button = findViewById(R.id.LogOut);
        cv1 = findViewById(R.id.cv1);
        cv2 = findViewById(R.id.cv2);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        android.graphics.drawable.Drawable background = Dashboard.this.getResources().getDrawable(R.drawable.dashgredient);
        getWindow().setBackgroundDrawable(background);

        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this,Teachersprof.class);
                startActivity(intent);
            }
        });

        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this,Studentsprof.class);
                startActivity(intent);
            }
        });

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logout();
                finish();
            }
        });
    }

    public void logout(){
        FirebaseAuth.getInstance().signOut();
        finish();
    }

}