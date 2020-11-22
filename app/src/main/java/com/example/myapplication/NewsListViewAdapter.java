package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class NewsListViewAdapter extends RecyclerView.Adapter<NewsListViewAdapter.ViewHolder> {

    List<Product> products;


    public NewsListViewAdapter(List<Product> products) {
        this.products = products;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.custom_list_product, parent, false);
        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product product=products.get(position);
        holder.cost.setText(product.getCost());
        URL url = null;
        try {
            url = new URL("https://picsum.photos/100/100");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Bitmap bmp = null;
        try {
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        holder.productImage.setImageBitmap(bmp);


    }

    @Override
    public int getItemCount() {
        return products.size();
    }


    public static class ViewHolder  extends RecyclerView.ViewHolder  {
        TextView cost;
        ImageView productImage;


        public ViewHolder(@NonNull View view) {
            super(view);

            cost = view.findViewById(R.id.cost);
            productImage = view.findViewById(R.id.productImage);

        }
    }

}
