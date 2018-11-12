package adrian.com.wisataklaten;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

import ss.com.bannerslider.Slider;

public class MainActivity extends AppCompatActivity {
Button panggil ;
Slider slider ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        panggil = (Button) findViewById(R.id.blihat);
        Slider.init(new PicassoImageLoadingService(this));
        slider = findViewById(R.id.banner);
                 slider.setAdapter(new BannerAdapter());

        panggil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , ListWisataActivity.class);
                intent.putExtra("id_wisata", 10);
                startActivity(intent);

            }
        });
    }
}
