package com.example.dh_entregableandroid_danteferrari.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dh_entregableandroid_danteferrari.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private EditText editTextLoginEmail;
    private EditText editTextLoginPassword;
    private Button buttonRegistrate;
    private FragmentLoginListener fragmentLoginListener;
    private Button buttonIniciarSesion;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        //FindViewById
        buttonIniciarSesion = view.findViewById(R.id.FragmentLogin_Button_IniciarSesion);
        buttonRegistrate = view.findViewById(R.id.FragmentLogin_Button_Registrate);
        editTextLoginEmail = view.findViewById(R.id.FragmentLogin_EditText_Email);
        editTextLoginPassword = view.findViewById(R.id.FragmentLogin_EditText_Password);

        //OnclickListeners
        buttonRegistrate.setOnClickListener(this);
        buttonIniciarSesion.setOnClickListener(this);


        return view;

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.fragmentLoginListener = (FragmentLoginListener) context;
    }

    public void loguearUsuario(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getActivity(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                            // ...
                        }

                        // ...
                    }
                });

    }


    private void updateUI(FirebaseUser currentUser) {
        if (currentUser != null) {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getContext(), "No pudo logearse", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.FragmentLogin_Button_IniciarSesion:
                loguearUsuario(editTextLoginEmail.getText().toString(), editTextLoginPassword.getText().toString());
                break;
            case R.id.FragmentLogin_Button_Registrate:
                fragmentLoginListener.onClickRegister();
                break;
        }
    }

    public interface FragmentLoginListener {
        void onClickRegister();
    }

}

