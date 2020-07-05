package com.example.dh_entregableandroid_danteferrari.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.example.dh_entregableandroid_danteferrari.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements LoginFragment.FragmentLoginListener, RegisterFragment.FragmentRegisterListener {

    private FirebaseAuth mAuth;
    private final LoginFragment loginFragment = new LoginFragment();
    private final RegisterFragment registerFragment = new RegisterFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pegarFragment(loginFragment);


        //Firebase
        mAuth = FirebaseAuth.getInstance();
    }


    //Checkeo usuario logeado
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            updateUI(currentUser);
        }
    }

    //Metodo updateUI
    private void updateUI(FirebaseUser user) {
        if (user != null) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    //Metodo pegarFragment
    protected void pegarFragment(Fragment fragment) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ActivityLogin_FrameLayout_ContenedorLogin, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    //OnClicks
    public void onClickRegister() {
        pegarFragment(registerFragment);
    }

    public void onClickIniciarSesion(){
        pegarFragment(loginFragment);
    }


}
