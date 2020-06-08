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

import com.example.dh_entregableandroid_danteferrari.controller.ItemController;
import com.example.dh_entregableandroid_danteferrari.R;
import com.example.dh_entregableandroid_danteferrari.model.Item;
import com.example.dh_entregableandroid_danteferrari.model.ItemContainer;
import com.example.dh_entregableandroid_danteferrari.util.ResultListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecylerViewFragment extends Fragment implements ItemAdapter.ItemAdapterListener    {

    private RecyclerViewFragmentListener recyclerViewFragmentListener;
    private List<Item> itemList = new ArrayList<>();
    private ItemAdapter itemAdapter;

    public RecylerViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.recyclerViewFragmentListener = (RecyclerViewFragmentListener) context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recyler_view, container, false);

        RecyclerView recyclerViewProductos = view.findViewById(R.id.fragmentRecyclerView_RecyclerView);

        //Controller
        ItemController itemController = new ItemController();
        itemController.getItemContainer("Apple", new ResultListener<ItemContainer>() {
            @Override
            public void onFinish(ItemContainer result) {
                UpdateList(result);
            }
        });


        //List<Producto> productoList = ProvedorDeProductos.getProductos();
        itemAdapter = new ItemAdapter(itemList, this);
        itemAdapter.notifyDataSetChanged();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), RecyclerView.VERTICAL, false);

        recyclerViewProductos.setLayoutManager(linearLayoutManager);
        recyclerViewProductos.setAdapter(itemAdapter);


        return view;
    }

    @Override
    public void onClickItem(Item item) {
        recyclerViewFragmentListener.onClickProductoDesdeFragment(item);
    }

    public interface RecyclerViewFragmentListener {
        public void onClickProductoDesdeFragment(Item item);
    }

    private void UpdateList(ItemContainer itemContainer) {
        itemAdapter.SetItemList(itemContainer.getResults());
    }
}
