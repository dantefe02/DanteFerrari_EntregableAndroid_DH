package com.example.dh_entregableandroid_danteferrari.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dh_entregableandroid_danteferrari.model.Item;
import com.example.dh_entregableandroid_danteferrari.model.Producto;
import com.example.dh_entregableandroid_danteferrari.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    public static final String ITEM = "item";

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        Bundle bundle = getArguments();
        Item item = (Item) bundle.getSerializable(ITEM);


        ImageView imageViewProducto = view.findViewById(R.id.FragmentDetail_ImageView_ImagenProducto);
        TextView textViewNombreProducto = view.findViewById(R.id.FragmentDetail_TextView_NombreProducto);
        TextView textViewMercadoPago = view.findViewById(R.id.FragmentDetail_TextView_MercadoPago);
        TextView textViewPrecioProducto = view.findViewById(R.id.FragmentDetail_TextView_PrecioProducto);

        String url = item.getThumbnail();
        Glide.with(this).load(url).into(imageViewProducto);

        textViewNombreProducto.setText(item.getTitle());
        textViewPrecioProducto.setText("$  " + item.getPrice().toString());


        ifAcceptsMercadoPago(item, textViewMercadoPago);


        return view;

    }

    private void ifAcceptsMercadoPago(Item item, TextView textViewMercadoPago) {
        if (item.isAccepts_mercadopago()){
            textViewMercadoPago.setText("Acepta MercadoPago");
        } else {
            textViewMercadoPago.setText("No acepta MercadoPago");
        }
    }
}
