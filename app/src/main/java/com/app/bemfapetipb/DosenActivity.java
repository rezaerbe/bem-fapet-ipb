package com.app.bemfapetipb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DosenActivity extends AppCompatActivity {

    private Button intp_btn, iptp_btn;

    private TextView toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen);

        toolbar = findViewById(R.id.toolbar);

        toolbar.setText("Departemen");

        intp_btn = findViewById(R.id.intp_btn);
        iptp_btn = findViewById(R.id.iptp_btn);

        intp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DosenActivity.this, IntpActivity.class);
                startActivity(intent);
            }
        });

        iptp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DosenActivity.this, IptpActivity.class);
                startActivity(intent);
            }
        });


    }
}
