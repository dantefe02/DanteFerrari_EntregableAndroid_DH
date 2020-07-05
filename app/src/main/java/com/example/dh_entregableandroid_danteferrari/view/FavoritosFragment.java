package com.example.dh_entregableandroid_danteferrari.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dh_entregableandroid_danteferrari.R;
import com.example.dh_entregableandroid_danteferrari.controller.UsuarioController;
import com.example.dh_entregableandroid_danteferrari.model.Item;
import com.example.dh_entregableandroid_danteferrari.model.UsuarioME;
import com.example.dh_entregableandroid_danteferrari.util.ResultListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritosFragment extends Fragment implements ItemAdapter.ItemAdapterListener {

    private List<Item> itemListFavoritos = new ArrayList<>();
    private UsuarioController usuarioController;
    private RecyclerView recyclerViewFavoritos;
    private FavoritosFragmentListener favoritosFragmentListener;
    private TextView textViewNoFav;
    private ItemAdapter itemAdapter;

    public FavoritosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.favoritosFragmentListener = (FavoritosFragmentListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_favoritos, container, false);

        //FindViewById
        recyclerViewFavoritos = view.findViewById(R.id.FragmentFavoritos_RecyclerView_Favoritos);
        textViewNoFav = view.findViewById(R.id.FragmentFavoritos_TextView_NoFavoritos);

        //init
        usuarioController = new UsuarioController();
        itemAdapter = new ItemAdapter(itemListFavoritos, this);


        usuarioController.getUsuarioME(new ResultListener<UsuarioME>() {
            @Override
            public void onFinish(UsuarioME result) {
                if (result.getListaFavoritos().isEmpty()) {
                    textViewNoFav.setVisibility(view.VISIBLE);
                    recyclerViewFavoritos.setVisibility(view.GONE);
                } else {
                    itemListFavoritos = result.getListaFavoritos();
                    recyclerViewFavoritos.setAdapter(itemAdapter);
                    itemAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onError(String mensaje) {
                Toast.makeText(getContext(), mensaje, Toast.LENGTH_SHORT).show();
            }
        });

        //Manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), RecyclerView.VERTICAL, false);
        recyclerViewFavoritos.setLayoutManager(linearLayoutManager);

        return view;
    }

    //onClick
    @Override
    public void onClickItem(Item item) {
        favoritosFragmentListener.onClickItemDesdeFragmentFavoritos(item);
    }

    //Listener
    public interface FavoritosFragmentListener {
        void onClickItemDesdeFragmentFavoritos(Item item);
    }
}
