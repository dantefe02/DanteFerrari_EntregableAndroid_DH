package com.example.dh_entregableandroid_danteferrari.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dh_entregableandroid_danteferrari.R;
import com.example.dh_entregableandroid_danteferrari.model.Item;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolderItem> {

    private List<Item> itemList;

    private ItemAdapterListener itemAdapterListener;

    public ItemAdapter(List<Item> itemList, ItemAdapterListener itemAdapterListener) {
        this.itemList = itemList;
        this.itemAdapterListener = itemAdapterListener;
    }

    @NonNull
    @Override
    public ViewHolderItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.celda_item, parent, false);
        return new ViewHolderItem(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderItem holder, int position) {
        Item item = itemList.get(position);
        holder.cargarValor(item);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    protected class ViewHolderItem extends RecyclerView.ViewHolder {

        private TextView nombreItem;
        private TextView precioItem;
        private ImageView imagenItem;


        public ViewHolderItem(@NonNull View itemView) {
            super(itemView);

            nombreItem = itemView.findViewById(R.id.celdaProducto_TextView_Nombre);
            precioItem = itemView.findViewById(R.id.celdaProducto_TextView_Precio);
            imagenItem = itemView.findViewById(R.id.celdaProducto_ImageView_ImagenProducto);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Item item = itemList.get(getAdapterPosition());
                    itemAdapterListener.onClickItem(item);

                }


            });
        }

        public void cargarValor(Item item) {

            Glide.with(itemView).load(item.getThumbnail()).error(R.drawable.ic_launcher_foreground).into(imagenItem);
            nombreItem.setText(item.getTitle());
            precioItem.setText("$ " + item.getPrice().toString());

        }

    }

    public interface ItemAdapterListener {
        public void onClickItem(Item item);
    }

    public void SetItemList(List<Item> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }


}
