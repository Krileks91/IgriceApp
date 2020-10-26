package com.example.igrice.Adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.igrice.Model.Igre;
import com.example.igrice.R;

import java.util.List;

public class IgreAdapter extends BaseAdapter {

    private List<Igre> igra;
    private Activity activity;

    public IgreAdapter(List<Igre> igra, Activity activity) {
        this.igra = igra;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return igra.size();
    }

    @Override
    public Igre getItem(int position) {
        return igra.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = activity.getLayoutInflater().inflate(R.layout.listview_igre_kategorije, null);
        }
        TextView tvNaziv = view.findViewById(R.id.tvNazivIgre);
        TextView tvKategorija = view.findViewById(R.id.tvKategorijaIgre);

        tvNaziv.setText(igra.get(position).getNazivIgrice());
        tvKategorija.setText(igra.get(position).getKategorija());


        return view;
    }

}
