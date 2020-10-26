package com.example.igrice.Dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.example.igrice.Activities.AddActivity;
import com.example.igrice.Activities.DeleteActivity;
import com.example.igrice.Activities.EditActivity;

public class DialogChoose extends AlertDialog.Builder {

    private int id;

    public DialogChoose(@NonNull Context context) {

        super(context);
        setTitle("Izaberite");
        setMessage("Sta zelite da dodate/promenite/obrisete?");
        setPositiveButton("Igre", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (id == 0) {
                    Intent i = new Intent(getContext(), AddActivity.class);
                    i.putExtra("Item", "Igre");
                    context.startActivity(i);
                } else if (id == 1) {
                    Intent i = new Intent(getContext(), EditActivity.class);
                    i.putExtra("Item", "Igre");
                    context.startActivity(i);
                } else if (id == 2) {
                    Intent i = new Intent(getContext(), DeleteActivity.class);
                    i.putExtra("Item", "Igre");
                    context.startActivity(i);
                }
            }
        });
        setNegativeButton("Kategorija", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (id == 0) {
                    Intent i = new Intent(getContext(), AddActivity.class);
                    i.putExtra("Item", "Kategorija");
                    context.startActivity(i);
                } else if (id == 1) {
                    Intent i = new Intent(getContext(), EditActivity.class);
                    i.putExtra("Item", "Kategorija");
                    context.startActivity(i);
                } else if (id == 2) {
                    Intent i = new Intent(getContext(), DeleteActivity.class);
                    i.putExtra("Item", "Kategorija");
                    context.startActivity(i);
                }
            }
        });
        setNeutralButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
    }

    public AlertDialog prepareDialog(int id) {
        this.id = id;
        AlertDialog dialog = create();
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }
}
