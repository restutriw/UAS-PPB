package com.example.restoran;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DefaultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.default_activity);

        ImageView ivDefault = findViewById(R.id.iv_default);
        TextView tvDefault = findViewById(R.id.tv_default);

        Intent intent = getIntent();

        int fotoMenu = intent.getIntExtra("GAMBAR DEFAULT", 0);
        String namaMenu = intent.getStringExtra("TEKS DEFAULT");

        ivDefault.setImageResource(fotoMenu);
        tvDefault.setText(namaMenu);

    }
}
