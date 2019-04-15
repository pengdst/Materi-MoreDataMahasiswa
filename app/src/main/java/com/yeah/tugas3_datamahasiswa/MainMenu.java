package com.yeah.tugas3_datamahasiswa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity implements View.OnClickListener {
    Button pindah, pindahData, pindahAddlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        pindah = findViewById(R.id.bt_moveActivity);
        pindahData = findViewById(R.id.bt_movedata);
        pindahAddlist = findViewById(R.id.bt_addlist);

        pindah.setOnClickListener(this);
        pindahData.setOnClickListener(this);
        pindahAddlist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.bt_moveActivity:
                intent = new Intent(this, ListDataActivity.class);
                break;
            case R.id.bt_movedata:
                intent = new Intent(this, ListDataActivity.class);
                intent.putExtra("Nama", "Pengkuh Dwi Septiandi");
                intent.putExtra("NIM", "18.02.0269");
                intent.putExtra("Kelas", "D3 MI 2");
                intent.putExtra("Status", "Aktif");
                intent.putExtra("Prodi", "Manajemen Informatika");
                break;
            case R.id.bt_addlist:
                intent = new Intent(this, MainActivity.class);
                break;
        }
        startActivity(intent);
    }
}
