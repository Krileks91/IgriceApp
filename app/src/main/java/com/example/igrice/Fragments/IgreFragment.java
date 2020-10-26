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

import com.example.igrice.Adapters.IgreRecyclerAdapter;
import com.example.igrice.Providers.IgreProvider;
import com.example.igrice.R;


public class IgreFragment extends Fragment {


    RecyclerView rvList;
    private String kategorija;

    public IgreFragment() {
    }

    public IgreFragment(String kategorija) {
        this.kategorija = kategorija;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_igre, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvList = view.findViewById(R.id.rvList);

        if (kategorija == null)
            setupList();
        else
            setupListByKategorija();

    }

    private void setupList() {

        rvList.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvList.setLayoutManager(layoutManager);

        IgreRecyclerAdapter adapter = new IgreRecyclerAdapter((IgreRecyclerAdapter.OnElementClickListener) getContext());
        rvList.setAdapter(adapter);

    }

    private void setupListByKategorija() {
        rvList.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvList.setLayoutManager(layoutManager);

        IgreRecyclerAdapter adapter = new IgreRecyclerAdapter((IgreRecyclerAdapter.OnElementClickListener) getContext(), IgreProvider.getAllIgreByKategorija(kategorija));
        rvList.setAdapter(adapter);

    }
}