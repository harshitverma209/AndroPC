package com.tba.andropc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MyAdapter(Contxt c,ArrayList<>) extends RecyclerView.Adapter<MyAdapter.Holder> {

    Context c;
    int img[] = {
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher
    };

    String data[] = {
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven"
    };

    MyAdapter(Context c)
    {
        this.c=c;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = li.inflate(R.layout.list, parent,false);

        Holder d = new Holder(v);

        return d;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.i.setImageResource(img[position]);
        holder.t.setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return img.length;
    }

    class Holder extends RecyclerView.ViewHolder
    {
        ImageView i;
        TextView t;

        public Holder(@NonNull View itemView) {
            super(itemView);
            i = itemView.findViewById(R.id.imageView);
            t = itemView.findViewById(R.id.textView);
        }
    }
}
