package adrian.com.wisataklaten;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.AdapterHolder> {
    List<Data> wisataList;
    Context context;

    public DataAdapter(List<Data> wisataList, Context context) {
        this.wisataList = wisataList;
        this.context = context;
    }

    @Override
    public AdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kerja,parent,false);
        return new AdapterHolder(view);

    }

    @Override
    public void onBindViewHolder(AdapterHolder holder, final int position) {
        holder.nama.setText(wisataList.get(position).getNama());
        holder.alamat.setText(wisataList.get(position).getAlamat());
        if (wisataList.get(position).getGambar().isEmpty())
        {
            holder.gambar.setImageResource(R.mipmap.ic_launcher);
        } else{
            Picasso.with(context).load(wisataList.get(position).getGambar()).resize(100,80).into(holder.gambar);
        }
    }

    @Override
    public int getItemCount() {
        return wisataList.size();
    }

    public class AdapterHolder extends RecyclerView.ViewHolder {
        public  ImageView gambar;
        TextView nama;
        TextView alamat;
        public AdapterHolder(View itemView) {
            super(itemView);
            nama = (TextView) itemView.findViewById(R.id.nama);
            alamat = (TextView) itemView.findViewById(R.id.alamat);
            gambar = (ImageView) itemView.findViewById(R.id.gambar);
        }
    }


}
