package infs3634.cryptobag1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

import java.text.NumberFormat;
import java.util.ArrayList;

import static infs3634.cryptobag1.Coin.searchCoin;


public class DetailActivity extends AppCompatActivity {
    private TextView mName;
    private TextView mSymbol;
    private TextView mValue;
    private TextView mChange1h;
    private TextView mChange24h;
    private TextView mChange7d;
    private TextView mMarketcap;
    private TextView mVolume;
    private ImageView mSearch;

    private static final String TAG = "DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mName = findViewById(R.id.tvName);
        mSymbol = findViewById(R.id.tvSymbol);
        mValue = findViewById(R.id.tvValueField);
        mChange1h = findViewById(R.id.tvChange1hField);
        mChange24h = findViewById(R.id.tvChange24hField);
        mChange7d = findViewById(R.id.tvChange7dField);
        mMarketcap = findViewById(R.id.tvMarketcapField);
        mVolume = findViewById(R.id.tvVolumeField);
        mSearch = findViewById(R.id.ivSearch);


        Intent intent = getIntent();
        String coinSymbol = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        Log.i(TAG, "Coin-Symbol = " + coinSymbol);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        ArrayList<Coin> coins = Coin.getCoins();

        final Coin coin = Coin.searchCoin(coinSymbol);

        mName.setText(coin.getName());
        mSymbol.setText(coin.getSymbol());
        mValue.setText(formatter.format(coin.getValue()));
        mChange1h.setText((coin.getChange1h()) + "%");
        mChange24h.setText((coin.getChange24h()) + "%");
        mChange7d.setText((coin.getChange7d()) + "%");
        mMarketcap.setText(formatter.format(coin.getMarketcap()));
        mVolume.setText(formatter.format(coin.getVolume()));
        mSearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                searchCoin(coin.getName());
            }
        });


//        mDetailMessage = findViewById(R.id.tvdetailMessage);
//        mDetailMessage.setText(message);

//       mShowVideoButton = findViewById(R.id.btnShowVideo);
//        mShowVideoButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showVideo("https://www.youtube.com/watch?v=-iIbc-h9ijc");
           }
//        });
//    }

    private void showVideo(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
