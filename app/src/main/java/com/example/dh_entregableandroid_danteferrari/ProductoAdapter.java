package com.example.dh_entregableandroid_danteferrari;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolderProducto> {

    private List<Producto> listaDeProductos;
    private ProductoAdapterListener productoAdapterListener;

    public ProductoAdapter(List<Producto> listaDeProductos, ProductoAdapterListener productoAdapterListener) {
        this.listaDeProductos = listaDeProductos;
        this.productoAdapterListener = productoAdapterListener;
    }

    @NonNull
    @Override
    public ViewHolderProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.celda_producto, parent, false);
        return new ViewHolderProducto(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProducto holder, int position) {
        Producto producto = listaDeProductos.get(position);
        holder.cargarValor(producto);
    }

    @Override
    public int getItemCount() {
        return listaDeProductos.size();
    }

    protected class ViewHolderProducto extends RecyclerView.ViewHolder {

        private TextView nombreProducto;
        private TextView precioProducto;
        private ImageView imagenProducto;


        public ViewHolderProducto(@NonNull View itemView) {
            super(itemView);

            nombreProducto = itemView.findViewById(R.id.celdaProducto_TextView_Nombre);
            precioProducto = itemView.findViewById(R.id.celdaProducto_TextView_Precio);
            imagenProducto = itemView.findViewById(R.id.celdaProducto_ImageView_ImagenProducto);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Producto producto = listaDeProductos.get(getAdapterPosition());
                    productoAdapterListener.onClickProducto(producto);

                }


            });
        }

        public void cargarValor(Producto producto) {
            imagenProducto.setImageResource(producto.getImagen());
            nombreProducto.setText(producto.getNombre());
            precioProducto.setText("$" + producto.getPrecio().toString());
        }

    }

    public interface ProductoAdapterListener {
        public void onClickProducto(Producto producto);
    }

}
