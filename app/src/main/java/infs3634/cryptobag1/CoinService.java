package infs3634.cryptobag1;

import infs3634.cryptobag1.Entities.CoinLoreResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CoinService {
    @GET("/api/tickers/")
    Call<CoinLoreResponse> getCoins();
}
