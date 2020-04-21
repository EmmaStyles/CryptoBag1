package infs3634.cryptobag1;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import infs3634.cryptobag1.Entities.Coin;

@Database(entities = {Coin.class}, version = 1)
public abstract class CoinDatabase extends RoomDatabase {
    public abstract CoinDao coinDao();
}
