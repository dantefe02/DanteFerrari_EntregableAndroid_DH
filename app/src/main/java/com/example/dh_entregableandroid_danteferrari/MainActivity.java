package com.example.dh_entregableandroid_danteferrari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements RecylerViewFragment.RecyclerViewFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecylerViewFragment recylerViewFragment = new RecylerViewFragment();
        pegarFragment(recylerViewFragment);
    }

    private void pegarFragment(Fragment unFragment) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activityMain_FrameLayout_ContenedorFragment, unFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onClickProductoDesdeFragment(Producto producto) {
        Bundle unBundle = new Bundle();
        DetailFragment detailFragment = new DetailFragment();

        unBundle.putSerializable(DetailFragment.PRODUCTO, producto);
        detailFragment.setArguments(unBundle);

        pegarFragment(detailFragment);

    }
}
