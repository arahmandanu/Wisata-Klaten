package adrian.com.wisataklaten;

import android.content.Intent;
import android.net.Uri;
import android.service.chooser.ChooserTarget;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.net.URI;


public class KeteranganActivity extends AppCompatActivity {

    FloatingActionButton map;
    String lat;
    String lng;
    String nama;
    Data data;
    Float a;
    Float b;
    TextView tvketerangan;
    TextView tvalamat;
    ImageView imgambar;
    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keterangan);

        final Intent intent = getIntent();
        data = new Gson().fromJson(intent.getStringExtra("wisata"), Data.class);

        tvketerangan = (TextView)findViewById(R.id.keterangan);
        tvketerangan.setText(data.getKeterangan());
        tvalamat =(TextView)findViewById(R.id.alamat);
        tvalamat.setText(data.getAlamat());
        imgambar =(ImageView)findViewById(R.id.imgbar);
        if (data.getGambar().isEmpty())
            {
            imgambar.setImageResource(R.drawable.kosong);
        } else{
            Picasso.with(this).load(data.getGambar()).into(imgambar);
        }
        setTitle(null);

        android.support.v7.widget.Toolbar toolbar= (android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(data.getNama());

        map = (FloatingActionButton) findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(KeteranganActivity.this,"Data"+ new Gson().toJson(data.getLat()),Toast.LENGTH_SHORT).show();
                if((data.getLat().isEmpty()) || (data.getLng().isEmpty()) ){
                    Toast.makeText(KeteranganActivity.this,"Sumber data masih kosong",Toast.LENGTH_SHORT).show();
                }
                else{
                    lat = data.getLat();
                    lng = data.getLng();
                    a = Float.parseFloat(lat);
                    b = Float.parseFloat(lng);
                    String query = a + "," + b  ;
                    String encodedQuery = Uri.encode(query);
                    //Toast.makeText(KeteranganActivity.this,"lat" +lat, Toast.LENGTH_SHORT).show();
                    // Buat Uri dari intent string. Gunakan hasilnya untuk membuat Intent.
                    Uri gmmIntentUri = Uri.parse("google.navigation:q=" + encodedQuery);

                    // Buat Uri dari intent gmmIntentUri. Set action => ACTION_VIEW
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

                    // Set package Google Maps untuk tujuan aplikasi yang di Intent
                    mapIntent.setPackage("com.google.android.apps.maps");

                    // Untuk menjalankan aplikasi yang di hendel dari intent
                    startActivity(mapIntent);

//                    intent[0] = new Intent(Intent.ACTION_VIEW);
//                    intent[0].setData(Uri.parse("geo:19.076,72.8777"));

//                Intent intent = new Intent(KeteranganActivity.this, MapsWisata.class);
//                intent.putExtra("lat",new Gson().toJson(data.getLat().toString().trim()));
//                intent.putExtra("lng",new Gson().toJson(data.getLng().toString().trim()));
//                intent.createChooser()
 //               startActivity(intent);
                }
            }
        });


    }
}
