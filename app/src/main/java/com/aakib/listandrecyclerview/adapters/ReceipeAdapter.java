package com.aakib.listandrecyclerview.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aakib.listandrecyclerview.MainActivity;
import com.aakib.listandrecyclerview.R;
import com.aakib.listandrecyclerview.models.ReceipeModel;

import java.util.ArrayList;

public class ReceipeAdapter extends RecyclerView.Adapter<ReceipeAdapter.viewHolder> {

    ArrayList<ReceipeModel> list;
    Context context;

    public ReceipeAdapter(ArrayList<ReceipeModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.resource_recyclerview, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ReceipeModel receipeModel = list.get(position);
        holder.imageView.setImageResource(receipeModel.getPic());
        holder.textView.setText(receipeModel.getText());
        //common click listner for all images and text
//        holder.imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, "Item selected ", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        holder.textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, "text selected", Toast.LENGTH_SHORT).show();
//            }
//        });

        //for particular  images and text

        switch (position) {
            case 0:
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "Item " + (position + 1) + " selected ", Toast.LENGTH_SHORT).show();
                      //goiing to custom activity
                        ///  context.startActivity(new Intent(context, MainActivity.class));
                        view.getContext().startActivity(new Intent(view.getContext(),MainActivity.class));
                        ((Activity)context).finish();
                    }
                });

                holder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "text " + (position + 1) + " selected", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case 1:
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "Item " + (position + 1 + 2 - 2) + " selected ", Toast.LENGTH_SHORT).show();
                    }
                });

                holder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "text " + (position + 1 + 2 - 2) + " selected", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
