package com.example.dh_entregableandroid_danteferrari;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    public static final String PRODUCTO = "producto";

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        Bundle bundle = getArguments();
        Producto producto = (Producto) bundle.getSerializable(PRODUCTO);

        ImageView imageViewProducto = view.findViewById(R.id.FragmentDetail_ImageView_ImagenProducto);
        TextView textViewNombreProducto = view.findViewById(R.id.FragmentDetail_TextView_NombreProducto);
        TextView textViewPrecioProducto = view.findViewById(R.id.FragmentDetail_TextView_PrecioProducto);

        imageViewProducto.setImageResource(producto.getImagen());
        textViewNombreProducto.setText(producto.getNombre());
        textViewPrecioProducto.setText("$" + producto.getPrecio().toString());


        return view;

    }
}
