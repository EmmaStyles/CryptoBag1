package infs3634.cryptobag1;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import infs3634.cryptobag1.Entities.Coin;

@Dao
public interface CoinDao {

    @Query("Select * FROM coin")
    List<Coin> getCoins();

    @Query("SELECT * FROM coin WHERE id = :coinId")
    Coin getCoin(String coinId);

    @Insert
    void insertAll(Coin... coins);

    @Delete
    void deleteAll(Coin... coins);
}
