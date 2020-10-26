package com.example.igrice.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.igrice.Adapters.KategorijeRecyclerAdapter;
import com.example.igrice.R;

public class KategorijeFragment extends Fragment {

    RecyclerView rvList;

    public KategorijeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_kategorije, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvList = view.findViewById(R.id.rvList_Kategorije);

        setupList();
    }

    private void setupList() {
        rvList.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvList.setLayoutManager(layoutManager);

        KategorijeRecyclerAdapter adapter = new KategorijeRecyclerAdapter((KategorijeRecyclerAdapter.OnElementClickListener) getContext()); //2.
        rvList.setAdapter(adapter);

    }
}