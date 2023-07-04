package com.example.glowlane;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {

    private LayoutInflater inflater;

    public ProductAdapter(Context context, List<Product> productList) {
        super(context, 0, productList);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = inflater.inflate(R.layout.product_search, parent, false);
        }

        Product currentProduct = getItem(position);

        ImageView imageView = itemView.findViewById(R.id.productImage);
        TextView nameTextView = itemView.findViewById(R.id.productName);
        TextView priceTextView = itemView.findViewById(R.id.productPrice);
        TextView availabilityTextView = itemView.findViewById(R.id.productAvailability);

        Picasso.get().load(currentProduct.getImage()).into(imageView);
        nameTextView.setText(currentProduct.getName());
        priceTextView.setText(String.valueOf(currentProduct.getPrice()));
        availabilityTextView.setText(currentProduct.getAvailability());

        return itemView;
    }
}
