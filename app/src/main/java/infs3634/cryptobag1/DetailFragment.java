package infs3634.cryptobag1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.Format;
import java.text.NumberFormat;

import static infs3634.cryptobag1.Coin.searchCoin;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";
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
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        if(mCoin != null){
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            ((TextView) rootView.findViewById(R.id.tvName)).setText(mCoin.getName());
            ((TextView) rootView.findViewById(R.id.tvSymbol)).setText(mCoin.getSymbol());
            ((TextView) rootView.findViewById(R.id.tvValue)).setText(formatter.format(mCoin.getSymbol()));
            ((TextView) rootView.findViewById(R.id.tvChange1hField)).setText(String.valueOf(mCoin.getChange1h()) + "%");
            ((TextView) rootView.findViewById(R.id.tvChange24hField)).setText(String.valueOf(mCoin.getChange24h()) + "%");
            ((TextView) rootView.findViewById(R.id.tvChange7dField)).setText(String.valueOf(mCoin.getChange7d()) + "%");
            ((TextView) rootView.findViewById(R.id.tvMarketcapField)).setText(formatter.format(mCoin.getMarketcap()));
            ((TextView) rootView.findViewById(R.id.tvVolumeField)).setText(formatter.format(mCoin.getVolume()));
//            mValue.setText(formatter.format(mCoin.getValue()));
//            mChange1h.setText(String.valueOf(mCoin.getChange1h()) + "%");
//            mChange24h.setText(String.valueOf(mCoin.getChange24h()) + "%");
//            mChange7d.setText(String.valueOf(mCoin.getChange7d()) + "%");
//            mMarketcap.setText(formatter.format(mCoin.getMarketcap()));
//            mVolume.setText(formatter.format(mCoin.getVolume()));
//            mSearch.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    searchCoin(mCoin.getName());
//                }
//            });
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }
}
