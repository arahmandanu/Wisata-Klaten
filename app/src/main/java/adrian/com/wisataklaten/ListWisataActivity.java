package adrian.com.wisataklaten;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListWisataActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    List<Data> listdata;
    DataAdapter adapterdata;
    RecyclerView rvwisata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_wisata);

        Spinner myspinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> myadapter = new ArrayAdapter<String >(ListWisataActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.pilihan));
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myadapter);
        myspinner.setOnItemSelectedListener(this);

        listdata = new ArrayList<>();
        rvwisata = findViewById(R.id.rvwisata);

        adapterdata = new DataAdapter(listdata,this);
        rvwisata.setLayoutManager(new LinearLayoutManager(this));
        rvwisata.addOnItemTouchListener(clickdata());
        rvwisata.setAdapter(adapterdata);

    }

    private void loaddata(String p) {
        listdata.clear();
        Retrofit retrofit   = new Retrofit.Builder()
                .baseUrl("http://wisata-klaten.site/config/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API ambilapi  = retrofit.create(API.class);
        Call<ResponData> ngambil = ambilapi.datawisatasort(p);

        ngambil.enqueue(new Callback<ResponData>() {
            @Override
            public void onResponse(Call<ResponData> call, Response<ResponData> response) {
                listdata.addAll(response.body().getWisata());
                adapterdata.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponData> call, Throwable t) {
                Toast.makeText(ListWisataActivity.this , "Data Kosong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private RecyclerView.OnItemTouchListener clickdata() {
        return  new RecyclerClickListener(this, rvwisata, new RecyclerClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(ListWisataActivity.this, KeteranganActivity.class);
                intent.putExtra("wisata",new Gson().toJson(listdata.get(position)));
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            String nilai = adapterView.getItemAtPosition(i).toString();
            loaddata(nilai);
           // Toast.makeText(this,nilai, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
