package com.shawn.getorder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    public TextView txt;
    public View v;

    public ItemViewHolder(View v)
    {
        super(v);
        txt = v.findViewById(R.id.textView2);
        this.v = v;
    }
}