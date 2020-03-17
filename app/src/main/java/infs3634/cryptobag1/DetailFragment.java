package infs3634.cryptobag1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";
    private Coin mCoin;
    public static final String ARG_PARAM1 = "param1";
    public static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetailFragment() {
        // Required empty public constructor
    }

//    @Override
//    public void onCreate(Bundle saveInstantSState)
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ARG_ITEM_ID) {
            mCoin = Coin.getCoin(getArguments().getString(ARG_ITEM_ID));
            this.getActivity().setTitle(mCoin.getName());

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        if(mCoin != null){
            NumberFormat formatter = numberFormat.getCurrencyInstance();
            ((TextView) rootView.findViewById(R.id.tvName)).setText(mCoin.getName());
            ((TextView) rootView.findViewById(R.id.tvSymbol)).setText(mCoin.getSymbol());
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
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }
}
