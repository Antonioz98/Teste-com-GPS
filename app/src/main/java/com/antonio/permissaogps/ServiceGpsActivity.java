package com.antonio.permissaogps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ServiceGpsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_gps);

        Button botaoLigar = findViewById(R.id.service_on);
        botaoLigar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService();
            }
        });

        Button botaoDesligar = findViewById(R.id.service_off);
        botaoDesligar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService();
            }
        });
    }

    public void startService(){
        Intent intent = new Intent(this, ServiceTest.class);
        startService(intent);
    }

    public void stopService(){
        Intent intent = new Intent(this, ServiceTest.class);
        stopService(intent);
    }
}
