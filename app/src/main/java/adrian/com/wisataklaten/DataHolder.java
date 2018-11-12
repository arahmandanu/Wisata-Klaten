package adrian.com.wisataklaten;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DataHolder extends RecyclerView.ViewHolder {
    TextView tvnama ;
    TextView tvalamat;
    ImageView imgwisata;

    public DataHolder (View view) {
        super(view);
        tvnama =(TextView)view.findViewById(R.id.nama);
        tvalamat =(TextView)view.findViewById(R.id.alamat);
        imgwisata =(ImageView)view.findViewById(R.id.gambar);
    }

}
