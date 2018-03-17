package com.example.idofirdaus.firdausadinugroho_1202154378_studycase4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import java.io.InputStream;

public class PencariGambar extends AppCompatActivity {

    Button cari;
    ImageView tampilangambar;
    EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencari_gambar);

        url = findViewById(R.id.linkgambar);
        cari = findViewById(R.id.btnmencari);
        tampilangambar = findViewById(R.id.gambar);



        cari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String URLGambar = url.getText().toString();
                new DownloadImage().execute(URLGambar);
            }
        });
    }

    class DownloadImage extends AsyncTask<String, Void, Bitmap> {



        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Bitmap doInBackground(String... voids) {

            String imageURL = voids[0];

            Bitmap bitmap = null;
            try {
                // mendownload gambar dari url
                InputStream input = new java.net.URL(imageURL).openStream();
                // menjadikan input dari url ke bitmap
                bitmap = BitmapFactory.decodeStream(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            // mengeset bitmap ke dalam imageView yang sudah di sediakan
            tampilangambar.setImageBitmap(result);

        }
    }
}