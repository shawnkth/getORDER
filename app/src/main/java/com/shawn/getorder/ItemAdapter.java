package com.shawn.getorder;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    Context c;
    ArrayList<String> data;

    public ItemAdapter(Context c, ArrayList<String> data) {
        this.c = c;
        this.data = data;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        final String s = data.get(position);
        holder.txt.setText(s);

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(c);
                alert.setTitle("Add");

                View dialog = LayoutInflater.from(c)
                        .inflate(R.layout.layout_add, null, false);
                TextView txt = dialog.findViewById(R.id.textView3);
                txt.setText(s);

                alert.setView(dialog);

                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        data.remove(position);
                        notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });
                alert.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
