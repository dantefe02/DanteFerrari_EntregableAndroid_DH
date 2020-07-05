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
import com.example.dh_entregableandroid_danteferrari.controller.UsuarioController;
import com.example.dh_entregableandroid_danteferrari.model.Item;
import com.example.dh_entregableandroid_danteferrari.model.UsuarioME;
import com.example.dh_entregableandroid_danteferrari.util.ResultListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private EditText editTextRegisterNombre;
    private EditText editTextRegisterEmail;
    private EditText editTextRegisterPassword;
    private EditText editTextRegisterApellido;
    private Button botonListo;
    private MaterialTextView textViewIniciarSesion;
    private FragmentRegisterListener fragmentRegisterListener;
    private UsuarioController usuarioController;



    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        // Initialize Firebase
        mAuth = FirebaseAuth.getInstance();
        usuarioController = new UsuarioController();

        //FindViewById
        editTextRegisterEmail = view.findViewById(R.id.FragmentRegister_EditText_Email);
        editTextRegisterApellido = view.findViewById(R.id.FragmentRegister_EditText_Apellido);
        editTextRegisterNombre = view.findViewById(R.id.FragmentRegister_EditText_Nombre);
        editTextRegisterPassword = view.findViewById(R.id.FragmentRegister_EditText_Password);
        botonListo = view.findViewById(R.id.FragmentRegister_Button_Listo);
        textViewIniciarSesion = view.findViewById(R.id.FragmentRegister_TextView_IniciarSesion);

        //OnClicks
        botonListo.setOnClickListener(this);
        textViewIniciarSesion.setOnClickListener(this);

        return view;

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.fragmentRegisterListener = (FragmentRegisterListener) context;
    }

    //onClicks
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.FragmentRegister_Button_Listo:
                crearUsuario(editTextRegisterEmail.getText().toString(), editTextRegisterPassword.getText().toString());
                break;
            case R.id.FragmentRegister_TextView_IniciarSesion:
                fragmentRegisterListener.onClickIniciarSesion();

        }
    }


    //Metodo updateUI
    private void updateUI(FirebaseUser currentUser) {
        if (currentUser != null) {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getContext(), "No pudo registrarse", Toast.LENGTH_SHORT).show();
        }
    }

    //crear usuario
    private void crearUsuario(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getActivity(), "succesful", Toast.LENGTH_SHORT).show();

                            //Agrego info a un usuario
                            UsuarioME usuarioME = new UsuarioME(
                                    editTextRegisterNombre.getText().toString(),
                                    editTextRegisterApellido.getText().toString(),
                                    editTextRegisterEmail.getText().toString(), new ArrayList<Item>()
                            );
                            usuarioController.agregarUsuario(usuarioME, new ResultListener<UsuarioME>() {
                                @Override
                                public void onFinish(UsuarioME result) {
                                    Toast.makeText(getContext(), "usuario agregado", Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onError(String mensaje) {
                                    Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
                                }
                            });
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

    public interface FragmentRegisterListener {
        void onClickIniciarSesion();
    }

}
