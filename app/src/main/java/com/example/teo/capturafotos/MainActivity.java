package com.example.teo.capturafotos;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    static final int CAPTURA_IMAGEN = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnFoto = (Button) findViewById(R.id.btnFoto);
        btnFoto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent hacerFoto  = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (hacerFoto.resolveActivity(getPackageManager())!=null){
            startActivityForResult(hacerFoto, CAPTURA_IMAGEN);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAPTURA_IMAGEN && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageView img = (ImageView) findViewById(R.id.imageView);
            img.setImageBitmap(imageBitmap);
        }
    }
}
