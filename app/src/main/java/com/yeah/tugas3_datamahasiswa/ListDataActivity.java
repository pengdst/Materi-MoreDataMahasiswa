package com.yeah.tugas3_datamahasiswa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ListDataActivity extends AppCompatActivity {
    TextView  tvNama, tvKelas, tvStatus,tvProdi,tvNIM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        Intent intent = getIntent();

        tvNama = findViewById(R.id.tv_Nama);
        tvKelas = findViewById(R.id.tv_Kelas);
        tvNIM = findViewById(R.id.tv_Nim);
        tvProdi = findViewById(R.id.tv_Prodi);
        tvStatus = findViewById(R.id.tv_Status);

        tvNama.setText(intent.getStringExtra("Nama"));
        tvNama.setText(intent.getStringExtra("NIM"));
        tvNama.setText(intent.getStringExtra("Kelas"));
        tvNama.setText(intent.getStringExtra("Prodi"));
        tvNama.setText(intent.getStringExtra("Status"));
    }
}
