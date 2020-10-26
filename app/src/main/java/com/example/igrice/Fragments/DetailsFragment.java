package com.example.igrice.Fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.igrice.Model.Igre;
import com.example.igrice.R;

import java.io.InputStream;

public class DetailsFragment extends Fragment {

    private static Igre igre;
    private TextView tvNaziv, tvOpis, tvKategorija, tvCena;
    private ImageView ivSlika;

    public DetailsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvNaziv = view.findViewById(R.id.textView_Naziv);
        tvOpis = view.findViewById(R.id.textView_Opis);
        tvKategorija = view.findViewById(R.id.textView_Kategorija);
        tvCena = view.findViewById(R.id.textView_Cena);

        ivSlika = view.findViewById(R.id.imageView_Slika);

        setupViews();

    }

    private void setupViews() {
        tvNaziv.setText(igre.getNazivIgrice());
        tvOpis.setText(igre.getOpisIgrice());
        tvKategorija.setText(igre.getKategorija());
        tvCena.setText(igre.getCena() + "Eura");

        try {
            InputStream is = getContext().getAssets().open(igre.getSlikaURL());
            Drawable drawable = Drawable.createFromStream(is, null);

            ivSlika.setImageDrawable(drawable);
        } catch (Exception e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void setIgre(Igre igre) {
        this.igre = igre;
    }
}