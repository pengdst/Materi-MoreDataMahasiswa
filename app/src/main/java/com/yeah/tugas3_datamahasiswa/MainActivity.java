package com.yeah.tugas3_datamahasiswa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etNama, etKelas, etStatus,etProdi,etNIM;
    Button btInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.et_Nama);
        etKelas = findViewById(R.id.et_Nim);
        etStatus = findViewById(R.id.et_Status);
        etProdi = findViewById(R.id.et_Prodi);
        etNIM = findViewById(R.id.et_Nim);

        btInsert = findViewById(R.id.bt_Insert);

        btInsert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_Insert:
                String strNama = etNama.getText().toString();
                String strNIM = etNIM.getText().toString();
                String strKelas = etKelas.getText().toString();
                String strProdi = etProdi.getText().toString();
                String strStatus = etStatus.getText().toString();

                Intent intent = new Intent(MainActivity.this, ListDataActivity.class);
                intent.putExtra("Nama", strNama);
                intent.putExtra("NIM", strNIM);
                intent.putExtra("Kelas", strKelas);
                intent.putExtra("Prodi", strProdi);
                intent.putExtra("Status", strStatus);
                startActivity(intent);
        }
    }
}
