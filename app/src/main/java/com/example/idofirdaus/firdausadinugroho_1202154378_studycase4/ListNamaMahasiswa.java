package com.example.idofirdaus.firdausadinugroho_1202154378_studycase4;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import android.widget.Toast;


import java.util.ArrayList;

public class ListNamaMahasiswa extends AppCompatActivity {
    //membuat array nama mahasiswa
    private String[] nama = { "BREGAS", "UMAM", "YADI", "JIMMY", "RIKO", "INDRA", "YOEL", "DECE", "NOVAL", "DICKY", "WILDAN",
            "HANS", "GALUH", "IKHSAN", "FIKRI", "PRADIKA", "GINANJAR", "ABAY"};
    ListView listnama;
    Button btnmulai;

    private static Parcelable mListViewScrollPos = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nama_mahasiswa);

        listnama = findViewById(R.id.list_nama);
        btnmulai = findViewById(R.id.btn_mulai);

        //mengeset adapter array
        listnama.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,new ArrayList<String>()));

        // Restore the ListView position
        if (mListViewScrollPos != null) {
            listnama.onRestoreInstanceState(mListViewScrollPos);
        }


        btnmulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //memanggil class mytask dan mengeksekusinya
                new mytask().execute();
            }
        });

    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the ListView position
        mListViewScrollPos = listnama.onSaveInstanceState();
    }

    class mytask extends AsyncTask<Void,String,String>{

        ArrayAdapter<String> adapter;
        ProgressDialog progressdialog;
        int count;


        @Override
        protected void onPreExecute() {
            //mengambil adapter dari array tersebut
            adapter = (ArrayAdapter<String>)listnama.getAdapter();

            //membuat object progress dialog
            progressdialog = new ProgressDialog(ListNamaMahasiswa.this);
            //mengeset judul progress dialog
            progressdialog.setTitle("Loading Data");
            progressdialog.setProgressStyle(progressdialog.STYLE_HORIZONTAL);
            progressdialog.setMax(15);
            progressdialog.setProgress(0);
            //menampilkan progress dialog
            progressdialog.show();
            //memastikan bahwa hitungan sebelum di eksekusi adalah 0
            count = 0;



        }


        @Override
        protected String doInBackground(Void... voids) {
            //membuat perulangan untuk memunculkan nama mahasiswa
            for (String namamhs : nama){
                publishProgress(namamhs);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            //mengembalikan nilai dengan tulisan
            return "semua nama sudah muncul";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            //adapter array memluai dari array 0
            adapter.add(values[0]);
            //hitungan pada saat progress update bertambah
            count++;
            //mengeset hitungan di dalam progress dialog
            progressdialog.setProgress(count);
        }

        @Override
        protected void onPostExecute(String result) {
//menampilkan nilai dari return yang ada di method doInBackground
            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
            //setelah loading progress sudah full maka otomatis akan hilang progress dialognya
            progressdialog.hide();


        }

    }


}