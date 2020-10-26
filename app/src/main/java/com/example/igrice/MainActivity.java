package com.example.igrice;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.example.igrice.Adapters.IgreRecyclerAdapter;
import com.example.igrice.Adapters.KategorijeRecyclerAdapter;
import com.example.igrice.Dialogs.DialogAbout;
import com.example.igrice.Dialogs.DialogChoose;
import com.example.igrice.Fragments.DetailsFragment;
import com.example.igrice.Fragments.IgreFragment;
import com.example.igrice.Fragments.KategorijeFragment;
import com.example.igrice.Fragments.PreferencesFragment;
import com.example.igrice.Model.Igre;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IgreRecyclerAdapter.OnElementClickListener, KategorijeRecyclerAdapter.OnElementClickListener {

    private List<String> drawerItems;
    private ListView drawerList;
    private DrawerLayout drawerLayout;

    private ActionBarDrawerToggle drawerToggle;

    private Toolbar toolbar;
    private AlertDialog dialog_about;
    private AlertDialog dialog_choose;

    public static final int NOTIF_ID = 101;
    public static final String NOTIF_CHANNEL_ID = "nas_notif_kanal";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillData();
        setupToolbar();
        setupDrawer();
    }

    private void fillData() {
        drawerItems = new ArrayList<>();
        drawerItems.add("Kategorije");
        drawerItems.add("Igrice");
        drawerItems.add("Notifikacija");
        drawerItems.add("Podesavanja");
        drawerItems.add("O aplikaciji");
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_dehaze_24);
            actionBar.setHomeButtonEnabled(true);
            actionBar.show();
        }
    }

    private void showSnackbar() {
        Snackbar snackbar;

        snackbar = Snackbar.make(findViewById(R.id.root), "Unos|Izmena|Brisanje", Snackbar.LENGTH_LONG);
        snackbar.show();
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add) {
            showSnackbar();
            showDialogChoose(0);
        } else if (item.getItemId() == R.id.edit) {
            showSnackbar();
            showDialogChoose(1);
        } else if (item.getItemId() == R.id.delete) {
            showSnackbar();
            showDialogChoose(2);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setupDrawer() {
        drawerList = findViewById(R.id.leftDrawer);
        drawerLayout = findViewById(R.id.drawer_layout);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, drawerItems);
        drawerList.setAdapter(adapter);
        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String title = "";
                if (position == 0) {
                    title = "Kategorije";
                    showKategorijeFragment();
                } else if (position == 1) {
                    title = "Igre";
                    showIgreFragment();
                } else if (position == 2) {
                    title = "Notifikacija";
                    showNotification();
                } else if (position == 3) {
                        title = "Podesavanja";
                        showPreferences();
                } else if (position == 4) {
                    title = "O aplikaciji";
                    showDialog();
                }
                setTitle(title);
                drawerLayout.closeDrawer(drawerList);
            }
        });
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name) {
            @Override
            public void onDrawerClosed(View drawerView) {
                getSupportActionBar().setTitle("");
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle("");
                super.onDrawerOpened(drawerView);
            }
        };

    }

    private void showKategorijeFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        KategorijeFragment fragment = new KategorijeFragment();
        transaction.replace(R.id.root, fragment);
        transaction.commit();
    }

    public void showIgreFragment() {
        IgreFragment listfragment = new IgreFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.root, listfragment).commit();
    }

    public void showIgreByKategorijaFragment(String kategorija) {
        IgreFragment listfragment = new IgreFragment(kategorija);
        getSupportFragmentManager().beginTransaction().replace(R.id.root, listfragment).commit();
    }

    private void showDetails(Igre igre) {
        DetailsFragment detailsFragment = new DetailsFragment();
        detailsFragment.setIgre(igre);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.root, detailsFragment)
                .addToBackStack(null)
                .commit();
    }

    private void showPreferences() {
        FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
        PreferencesFragment preferencesFragment = new PreferencesFragment();
        fragment.replace(R.id.root, preferencesFragment);
        fragment.commit();
    }
    private void showNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), NOTIF_CHANNEL_ID);
        //Uvek obvezno da se stavi!
        builder.setContentTitle("Notifikacija")
                .setContentText("Ovo je tekst notifikacije")
                .setSmallIcon(R.drawable.ic_baseline_gesture_24);
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(NOTIF_ID, builder.build());
        Toast.makeText(this, "Ovo je Notifikacija", Toast.LENGTH_SHORT).show();
    }

    private void showDialog() {
        if (dialog_about == null)
            dialog_about = new DialogAbout(this).prepareDialog();
        else if (dialog_about.isShowing())
            dialog_about.dismiss();
        dialog_about.show();
    }

    private void showDialogChoose(int id) {
        if (dialog_choose == null)
            dialog_choose = new DialogChoose(this).prepareDialog(id);
        else if (dialog_choose.isShowing())
            dialog_choose.dismiss();
        dialog_choose.show();
    }

    @Override
    public void onElementClicked(Igre igre) {
        showDetails(igre);
    }

    @Override
    public void onElementClicked(String kategorija) {
        showIgreByKategorijaFragment(kategorija);
    }
}
