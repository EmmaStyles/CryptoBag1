package infs3634.cryptobag1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.NumberFormat;

public class DetailFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Coin mCoin;
    private TextView mName;
    private TextView mSymbol;
    private TextView mValue;
    private TextView mChange1h;
    private TextView mChange24h;
    private TextView mChange7d;
    private TextView mMarketcap;
    private TextView mVolume;
    private ImageView mSearch;


    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ARG_ITEM_ID) ){
            mCoin = Coin.getCoin(getArguments().getString(ARG_ITEM_ID));
            this.getActivity().setTitle(mCoin.getName());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        int position = 0;
        Boolean mTwoPane = false;

        mName = v.findViewById(R.id.tvValue);
        mSymbol = v.findViewById(R.id.tvSymbol);
        mValue = v.findViewById(R.id.tvValueField);
        mChange1h = v.findViewById(R.id.tvChange1hField);
        mChange24h = v.findViewById(R.id.tvChange24hField);
        mChange7d = v.findViewById(R.id.tvChange7dField);
        mMarketcap = v.findViewById(R.id.tvMarketcapField);
        mVolume = v.findViewById(R.id.tvVolumeField);
        mSearch = v.findViewById(R.id.ivSearch);

        if(this.getArguments() != null){
            mTwoPane = getArguments().getBoolean("position", true);
        }
        if(mTwoPane) {
            mCoin = Coin.getCoins().get(getArguments().getInt("position"));
        }
        else{
            Intent intent = getActivity().getIntent();
            position = intent.getIntExtra("position", 0);
            mCoin = Coin.getCoins().get(position);
        }

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        mName.setText(mCoin.getName());
        mSymbol.setText(mCoin.getSymbol());
        mValue.setText(formatter.format(mCoin.getValue()));
        mChange1h.setText(String.valueOf(mCoin.getChange1h()) + "%");
        mChange24h.setText(String.valueOf(mCoin.getChange24h()) + "%");
        mChange7d.setText(String.valueOf(mCoin.getChange7d()) + "%");
        mMarketcap.setText(formatter.format(mCoin.getMarketcap()));
        mVolume.setText(formatter.format(mCoin.getVolume()));
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchCoin(mCoin.getName());
            }
        });
        return v;
    }

    private void searchCoin(String name) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + name));
    }
}
