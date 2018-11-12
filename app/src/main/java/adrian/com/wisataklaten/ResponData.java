package adrian.com.wisataklaten;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponData {
    @SerializedName("wisata")
    @Expose
    private List<Data> wisata = null;

    public List<Data> getWisata() { return wisata;  }

    public void setWisata(List<Data> wisata) { this.wisata = wisata; }
}
