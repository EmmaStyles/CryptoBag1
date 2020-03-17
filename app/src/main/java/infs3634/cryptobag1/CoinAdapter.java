package infs3634.cryptobag1;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.ArrayList;

public class CoinAdapter extends RecyclerView.Adapter<CoinAdapter.CoinViewHolder> {
    private MainActivity mParentActivity;
    private ArrayList<Coin> mCoins;
    private RecyclerViewClickListener mListener;
    private boolean mTwoPane;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Coin coin = (Coin) v.getTag();
            if(mTwoPane) {
                Bundle arguments = new Bundle();
                arguments.putString(DetailFragment.ARG_ITEM_ID, coin.getSymbol());
                DetailFragment fragment = new DetailFragment();
                fragment.setArguments(arguments);
                mParentActivity.getSupportFragmentManager().beginTransaction().replace(R.id.detail_container, fragment).commit();
            }
            else {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
            }
        }
    };


    public CoinAdapter(MainActivity parent, ArrayList<Coin> coins, boolean mTwoPane) {
        mParentActivity = parent;
        mCoins = coins;
        mListener = listener;
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

    public static class CoinViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name, value, change;
        private RecyclerViewClickListener mListener;

        public CoinViewHolder(View v, RecyclerViewClickListener listener) {
            super(v);
            mListener = listener;
            v.setOnClickListener(this);
            name = v.findViewById(R.id.tvName);
            value = v.findViewById(R.id.tvValue);
            change = v.findViewById(R.id.tvChange);
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }
    }

    @Override
    public CoinAdapter.CoinViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.coin_list_row, parent, false);
        return new CoinViewHolder(v, mListener);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(CoinViewHolder holder, int position) {
        Coin coin = mCoins.get(position);
        holder.name.setText(coin.getName());
        holder.value.setText(NumberFormat.getCurrencyInstance().format(coin.getValue()));
        holder.change.setText(String.valueOf(coin.getChange1h()) + " %");

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mCoins.size();
    }
}
