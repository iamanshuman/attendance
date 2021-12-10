package com.example.attendance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


import java.util.concurrent.TimeUnit;

public class PhoneNumber extends AppCompatActivity {

    EditText editText;
    TextView aCountryCode, aGetOtpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phonenumber);

        editText = findViewById(R.id.number);
        aCountryCode = findViewById(R.id.countrycode);
        aGetOtpBtn = findViewById(R.id.getotpbtn);

        aGetOtpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().trim().isEmpty()){
                    Toast.makeText(PhoneNumber.this,"Enter Phone Number", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(getApplicationContext(), Otp.class);
                intent.putExtra("mobile_number", editText.getText().toString().trim());
                startActivity(intent);
                finish();
            }
        });


    }
}