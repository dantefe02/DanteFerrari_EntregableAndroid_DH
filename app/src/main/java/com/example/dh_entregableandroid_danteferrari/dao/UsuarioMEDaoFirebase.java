package com.example.dh_entregableandroid_danteferrari.dao;

import androidx.annotation.NonNull;

import com.example.dh_entregableandroid_danteferrari.model.Item;
import com.example.dh_entregableandroid_danteferrari.model.UsuarioME;
import com.example.dh_entregableandroid_danteferrari.util.ResultListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class UsuarioMEDaoFirebase {

    private static final String COLLECTION_NAME = "usuarios";
    private FirebaseFirestore instance;
    private CollectionReference reference;
    private FirebaseAuth mAuth;

    public UsuarioMEDaoFirebase() {
        mAuth = FirebaseAuth.getInstance();
        instance = FirebaseFirestore.getInstance();
        reference = instance.collection(COLLECTION_NAME);

    }

    public void agregarUsuario(final UsuarioME usuarioME,
                               final ResultListener<UsuarioME> resultListener) {
        reference.document(mAuth.getCurrentUser().getUid()).set(usuarioME).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                resultListener.onFinish(usuarioME);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                resultListener.onError("ERROR");
            }
        });

    }

    public void eliminarItemFavoritos(final Item item, final ResultListener<Item> resultListenerFromController) {
reference.document(mAuth.getCurrentUser().getUid())
        .update("listaFavoritos",FieldValue.arrayRemove(item))
        .addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                resultListenerFromController.onFinish(item);

            }
        }).addOnFailureListener(new OnFailureListener() {
    @Override
    public void onFailure(@NonNull Exception e) {
        resultListenerFromController.onError(e.getMessage());
    }
});
    }

    public void agregarItemFavoritos(final Item item, final ResultListener<Item> resultListenerFromController) {
        reference.document(mAuth.getCurrentUser().getUid())
                .update("listaFavoritos", FieldValue.arrayUnion(item))
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        resultListenerFromController.onFinish(item);

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                resultListenerFromController.onError(e.getMessage());
            }
        });
    }

    public void getUsuarioME(final ResultListener<UsuarioME> resultListenerFromController) {
        reference.document(mAuth.getCurrentUser().getUid()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                UsuarioME usuarioME = documentSnapshot.toObject(UsuarioME.class);
                resultListenerFromController.onFinish(usuarioME);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                resultListenerFromController.onError(e.getMessage());
            }
        });
    }

}
