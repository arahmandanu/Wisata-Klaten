package adrian.com.wisataklaten;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {
    @GET("parsing.php")
    Call<ResponData> datawisata();

    @GET("categories.php")
    Call<ResponData> datawisatasort(@Query("kat") String kategori);

}
