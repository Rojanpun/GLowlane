package com.example.glowlane;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class ProductSearch extends AppCompatActivity {

    private ListView productListView;
    private ProductAdapter productAdapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_search);

        productListView = findViewById(R.id.productListView);
        productList = new ArrayList<>();
        productAdapter = new ProductAdapter(this, productList);
        productListView.setAdapter(productAdapter);

        fetchProductData();
    }

    private void fetchProductData() {
        // Replace "http://localhost/fetch_product_data.php" with your server URL
        String url = "http://localhost/mp/getSearch.php";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            productList.clear();
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject productJson = response.getJSONObject(i);
                                int id = productJson.getInt("id");
                                String name = productJson.getString("name");
                                String image = productJson.getString("image");
                                String description = productJson.getString("description");
                                String category = productJson.getString("category");
                                String availability = productJson.getString("availability");
                                float price = (float) productJson.getDouble("price");

                                Product product = new Product(id, name, image, description, category, availability, price);
                                productList.add(product);
                            }
                            productAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}
