package com.yeah.tugas3_datamahasiswa;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etNama, etKelas, etStatus,etProdi,etNIM;
    Button btInsert;
    ImageView imageView;
    private int GET_FROM_GALLERY = 1;
    Uri selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.et_Nama);
        etKelas = findViewById(R.id.et_Nim);
        etStatus = findViewById(R.id.et_Status);
        etProdi = findViewById(R.id.et_Prodi);
        etNIM = findViewById(R.id.et_Nim);

        imageView = findViewById(R.id.imgvw_pic);

        btInsert = findViewById(R.id.bt_Insert);

        imageView.setOnClickListener(this);
        btInsert.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bitmap = null;
        //Detects request codes
        if(requestCode==GET_FROM_GALLERY && resultCode == Activity.RESULT_OK) {
            selectedImage = data.getData();
            //bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
            imageView.setImageURI(selectedImage);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgvw_pic:
                openGallery();
                break;
            case R.id.bt_Insert:
                String strNama = etNama.getText().toString();
                String strNIM = etNIM.getText().toString();
                String strKelas = etKelas.getText().toString();
                String strProdi = etProdi.getText().toString();
                String strStatus = etStatus.getText().toString();
                String strPicUri = selectedImage.toString();

                Intent intent = new Intent(MainActivity.this, ListDataActivity.class);
                intent.putExtra("Nama", strNama);
                intent.putExtra("NIM", strNIM);
                intent.putExtra("Kelas", strKelas);
                intent.putExtra("Prodi", strProdi);
                intent.putExtra("Status", strStatus);
                intent.putExtra("Picture", strPicUri);
                startActivity(intent);
                break;
        }
    }

    private void openGallery() {
        Intent intentgbr = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(intentgbr, GET_FROM_GALLERY);
    }
}
