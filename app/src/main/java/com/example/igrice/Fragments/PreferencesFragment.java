package com.example.igrice.Fragments;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.example.igrice.R;

public class PreferencesFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preferences);
    }
}
