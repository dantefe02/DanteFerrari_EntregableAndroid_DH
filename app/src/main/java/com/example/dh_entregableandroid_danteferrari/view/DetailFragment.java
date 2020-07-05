package com.example.dh_entregableandroid_danteferrari.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dh_entregableandroid_danteferrari.controller.UsuarioController;
import com.example.dh_entregableandroid_danteferrari.model.Item;
import com.example.dh_entregableandroid_danteferrari.model.Producto;
import com.example.dh_entregableandroid_danteferrari.R;
import com.example.dh_entregableandroid_danteferrari.util.ResultListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    public static final String ITEM = "item";
    private UsuarioController usuarioController;
    private Button buttonAgregarFavoritos;
    private ImageView imageViewProducto;
    private TextView textViewNombreProducto;
    private TextView textViewPrecioProducto;
    private TextView textViewMercadoPago;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        Bundle bundle = getArguments();
        final Item item = (Item) bundle.getSerializable(ITEM);

        usuarioController = new UsuarioController();

        imageViewProducto = view.findViewById(R.id.FragmentDetail_ImageView_ImagenProducto);
        textViewNombreProducto = view.findViewById(R.id.FragmentDetail_TextView_NombreProducto);
        textViewMercadoPago = view.findViewById(R.id.FragmentDetail_TextView_MercadoPago);
        textViewPrecioProducto = view.findViewById(R.id.FragmentDetail_TextView_PrecioProducto);
        buttonAgregarFavoritos = view.findViewById(R.id.FragmentDetail_Button_AgregarFavoritos);

        String url = item.getThumbnail();
        Glide.with(this).load(url).into(imageViewProducto);

        textViewNombreProducto.setText(item.getTitle());
        textViewPrecioProducto.setText("$  " + item.getPrice().toString());


        ifAcceptsMercadoPago(item, textViewMercadoPago);
        buttonAgregarFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuarioController.agregarItemFavoritos(item, new ResultListener<Item>() {
                    @Override
                    public void onFinish(Item result) {
                        Toast.makeText(getContext(), "ITEM AGREGADO A FAVORITOS " + result.getTitle(), Toast.LENGTH_SHORT)
                                .show();
                    }

                    @Override
                    public void onError(String mensaje) {
                        Toast.makeText(getContext(), mensaje, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        


        return view;

    }
        //Metodos

    public void cambiarBotonAgregar(){
        buttonAgregarFavoritos.setText("ELIMINAR DE FAVORITOS");
    }

    private void ifAcceptsMercadoPago(Item item, TextView textViewMercadoPago) {
        if (item.isAccepts_mercadopago()) {
            textViewMercadoPago.setText("Acepta MercadoPago");
        } else {
            textViewMercadoPago.setText("No acepta MercadoPago");
        }
    }
}
