package com.example.classapp0501;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Myadaptor extends RecyclerView.Adapter<Myadaptor.ViewHolfer> {
    List<DataList> lists = new ArrayList<>();



    public Myadaptor(List<DataList> lists) {
        this.lists =  lists;
    }

    @NonNull
    @Override
    public ViewHolfer onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list,viewGroup,false);
        return new ViewHolfer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolfer viewHolfer, int position) {
        Log.e("list",lists.get(position).getCategoryDescription().toString());
        DataList data = lists.get(position);
        viewHolfer.id.setText("my name onil");
        viewHolfer.name.setText(data.getCategoryName().toString());
        //viewHolfer.image.setImageResource(data.getCategoryImage());
        viewHolfer.descrip.setText(data.getCategoryImage());

    }



    @Override
    public int getItemCount() {
        //lists = new ArrayList<>();
        return lists.size();
    }

    class ViewHolfer extends RecyclerView.ViewHolder{
        TextView id,name,descrip;
        ImageView image;


        public ViewHolfer(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.categoryId);
            name = itemView.findViewById(R.id.categoryName);
            //image = itemView.findViewById(R.id.categoryImage);
            descrip = itemView.findViewById(R.id.categoryDescription);

        }
    }
}
