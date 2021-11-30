package com.example.poetry.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poetry.Models.PoetryModel;
import com.example.poetry.R;

import java.util.List;

public class PoetryAdapter extends RecyclerView.Adapter<PoetryAdapter.ViewHolder>{

    Context context;
    List<PoetryModel> poetryModels;

    public PoetryAdapter(Context context, List<PoetryModel> poetryModels) {
        this.context = context;
        this.poetryModels = poetryModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.poetry_list_design,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.poetName.setText(poetryModels.get(position).getPoet_name());
        holder.poetry.setText(poetryModels.get(position).getPoetry_data());
        holder.date_time.setText(poetryModels.get(position).getDate_time());

    }

    @Override
    public int getItemCount() {
        return poetryModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView poetName, poetry, date_time;
        AppCompatButton updateBtn,deleteBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            poetName = itemView.findViewById(R.id.textView_poetName);
            poetry = itemView.findViewById(R.id.textView_poetryData);
            date_time = itemView.findViewById(R.id.textView_poetryDateandTime);

            updateBtn = itemView.findViewById(R.id.updateButton);
            deleteBtn = itemView.findViewById(R.id.deleteButton);

        }
    }

}
