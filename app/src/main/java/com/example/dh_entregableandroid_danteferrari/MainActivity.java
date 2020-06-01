package com.example.dh_entregableandroid_danteferrari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements RecylerViewFragment.RecyclerViewFragmentListener {

    private DrawerLayout drawerLayoutMainActivity;
    private NavigationView navigationView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OnFindViewById();

        final RecylerViewFragment recylerViewFragment = new RecylerViewFragment();
        final AboutUsFragment aboutUsFragment = new AboutUsFragment();
        pegarFragment(recylerViewFragment);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.AboutUs:
                        pegarFragment(aboutUsFragment);
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
    public void onClickProductoDesdeFragment(Producto producto) {
        Bundle unBundle = new Bundle();
        DetailFragment detailFragment = new DetailFragment();

        unBundle.putSerializable(DetailFragment.PRODUCTO, producto);
        detailFragment.setArguments(unBundle);

        pegarFragment(detailFragment);

    }

    private void OnFindViewById() {
        drawerLayoutMainActivity = findViewById(R.id.activityMain_DrawerLayout);
        navigationView = findViewById(R.id.activityMain_NavigationView);
    }

}
