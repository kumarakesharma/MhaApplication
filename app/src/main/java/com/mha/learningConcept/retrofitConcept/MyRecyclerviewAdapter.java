package com.mha.learningConcept.retrofitConcept;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.mha.learningConcept.R;
import com.mha.learningConcept.retrofitConcept.response.ProductResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyRecyclerviewAdapter extends RecyclerView.Adapter<MyRecyclerviewAdapter.MyViewHolder>{

    private Context context;
    private List<ProductResponse> productResponses;

    public MyRecyclerviewAdapter(Context context, List<ProductResponse> productResponses) {
        this.context = context;
        this.productResponses = productResponses;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_product_items, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ProductResponse data = productResponses.get(position);
        holder.tvTitle.setText(data.getTitle());
        holder.tvCategory.setText(data.getCategory());
        Picasso.get().load(data.getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return productResponses.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private MaterialTextView tvTitle, tvCategory;
        private ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategory = itemView.findViewById(R.id.tv_category);
            tvTitle = itemView.findViewById(R.id.tv_title);
            imageView = itemView.findViewById(R.id.image_view);
        }
    }
}
