package com.example.dh_entregableandroid_danteferrari.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.dh_entregableandroid_danteferrari.R;
import com.example.dh_entregableandroid_danteferrari.model.Item;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements RecylerViewFragment.RecyclerViewFragmentListener, FavoritosFragment.FavoritosFragmentListener {

    private DrawerLayout drawerLayoutMainActivity;
    private NavigationView navigationView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OnFindViewById();

        final RecylerViewFragment recylerViewFragment = new RecylerViewFragment();
        final AboutUsFragment aboutUsFragment = new AboutUsFragment();
        final FavoritosFragment favoritosFragment = new FavoritosFragment();

        pegarFragment(recylerViewFragment);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.AboutUs:
                        pegarFragment(aboutUsFragment);
                        break;
                    case R.id.Perfil:
                        pegarFragment(favoritosFragment);
                        break;
                    case R.id.Inicio:
                        pegarFragment(recylerViewFragment);
                }

                drawerLayoutMainActivity.closeDrawers();

                return true;
            }
        });
    }

    private void pegarFragment(Fragment unFragment) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activityMain_FrameLayout_ContenedorFragment, unFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onClickProductoDesdeRecyclerFragment(Item item) {
        Bundle unBundle = new Bundle();
        DetailFragment detailFragment = new DetailFragment();

        unBundle.putSerializable(DetailFragment.ITEM, item);
        detailFragment.setArguments(unBundle);

        pegarFragment(detailFragment);

    }



    private void OnFindViewById() {
        drawerLayoutMainActivity = findViewById(R.id.activityMain_DrawerLayout);
        navigationView = findViewById(R.id.activityMain_NavigationView);
    }

    @Override
    public void onClickItemDesdeFragmentFavoritos(Item item) {
        Bundle unBundle = new Bundle();
        DetailFragment detailFragment = new DetailFragment();
        unBundle.putSerializable(DetailFragment.ITEM, item);
        detailFragment.setArguments(unBundle);
        pegarFragment(detailFragment);


    }
}
