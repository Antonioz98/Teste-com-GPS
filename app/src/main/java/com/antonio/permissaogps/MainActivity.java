package com.antonio.permissaogps;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button testeLigarGPS = findViewById(R.id.main_teste_ligar_gps);
        testeLigarGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LigarGpsActivity.class));
            }
        });

        Button testeServiceGPS = findViewById(R.id.main_teste_service_gps);
        testeServiceGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ServiceGpsActivity.class));
            }
        });

    }
}
