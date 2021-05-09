package com.example.ecommoblie_app;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ecommoblie_app.Model.Products;

import java.util.List;

public class list_adapter extends ArrayAdapter {
    private Activity mcontext;
    List<Products> productsList;

    public list_adapter(Activity mcontext, List<Products> productsList) {
        super(mcontext, R.layout.list_item, productsList);
        this.mcontext = mcontext;
        this.productsList = productsList;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mcontext.getLayoutInflater();
        View view = inflater.inflate(R.layout.list_item, null, true);

        TextView id = view.findViewById(R.id.id_product);
        TextView name = view.findViewById(R.id.name_product);
        TextView role = view.findViewById(R.id.role_product);

        Products products= productsList.get(position);

        id.setText(String.valueOf(products.getId()));
        name.setText(products.getName());
        role.setText(products.getRole());

        return view;
    }
}
