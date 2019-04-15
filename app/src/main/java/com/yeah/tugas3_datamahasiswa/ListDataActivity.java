package com.yeah.tugas3_datamahasiswa;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class ListDataActivity extends AppCompatActivity {
    TextView  tvNama, tvKelas, tvStatus,tvProdi,tvNIM;
    ImageView imageView;
    Bitmap bitmap;

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
        imageView = findViewById(R.id.imgvw_pic);

        tvNama.setText(intent.getStringExtra("Nama"));
        tvNIM.setText(intent.getStringExtra("NIM"));
        tvKelas.setText(intent.getStringExtra("Kelas"));
        tvProdi.setText(intent.getStringExtra("Prodi"));
        tvStatus.setText(intent.getStringExtra("Status"));

        if (intent.getStringExtra("Picture") != null){
            Uri uri = Uri.parse(intent.getStringExtra("Picture"));
            try {
                bitmap = (Bitmap) MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            imageView.setImageBitmap(bitmap);
        }
    }
}
