package infs3634.cryptobag1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.detail_container) != null) {
            mTwoPane = true;
        }
        RecyclerView mRecyclerView = findViewById(R.id.rvList);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);



        mTwoPane = findViewById(R.id.detail_container) != null;
        RecyclerView.Adapter mAdapter = new CoinAdapter(this, Coin.getCoins(), mTwoPane);
        mRecyclerView.setAdapter(mAdapter);
    }

//        CoinAdapter.RecyclerViewClickListener listener = new CoinAdapter.RecyclerViewClickListener(){
//            @Override
//            public void onClick(View view, int position) {
//                if (mTwoPane == true) {
//                    final FragmentManager fragmentManager = getSupportFragmentManager();
//                    FragmentTransaction transaction = fragmentManager.beginTransaction();
//                    Bundle arguments = new Bundle();
//                    arguments.putInt("position", position);
//                    DetailFragment fragment = new DetailFragment();
//                    fragment.setArguments(arguments);
//                    transaction.replace(R.id.detailContainer, fragment);
//                    transaction.commit();
//                } else {
//                    launchDetailActivity(position);
//                }
//            }
//        };
//    }
//    private void launchDetailActivity(int position){
//        Intent intent = new Intent( this, DetailActivity.class);
//        intent.putExtra(EXTRA_MESSAGE, position);
//        startActivity(intent);
//    }

}
