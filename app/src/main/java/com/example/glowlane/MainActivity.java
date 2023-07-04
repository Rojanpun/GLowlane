package com.example.glowlane;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        gridView = findViewById(R.id.gridView);

        int[] imageResources = {

                R.drawable.profile,
                R.drawable.product,
                R.drawable.cart,
                R.drawable.checkout,
                R.drawable.about,
                R.drawable.logout,

        };

        String[] imageTexts = {
                "Profile",
                "Product",
                "Cart",
                "Checkout",
                "About",
                "Exit",

        };

        ImageAdapter adapter = new ImageAdapter(this, imageResources, imageTexts);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        // Profile clicked
                        Intent profileIntent = new Intent(MainActivity.this, Register.class);
                        startActivity(profileIntent);
                        break;
                    case 1:
                        // Product clicked
                        Intent productIntent = new Intent(MainActivity.this, Register.class);
                        startActivity(productIntent);
                        break;
                    case 2:
                        // Cart clicked
                        Intent cartIntent = new Intent(MainActivity.this, Register.class);
                        startActivity(cartIntent);
                        break;
                    case 3:
                        // Checkout clicked
                        Intent checkoutIntent = new Intent(MainActivity.this, Register.class);
                        startActivity(checkoutIntent);
                        break;
                    case 4:
                        // About clicked
                        Intent aboutIntent = new Intent(MainActivity.this, Register.class);
                        startActivity(aboutIntent);
                        break;
                    case 5:
                        // Logout clicked
                        // Implement your logout functionality here
                        // For example, call a logout API or clear user session

                        logoutAndExit(); // Exit the app
                        break;
                }
            }

            private void logoutAndExit() {
                finishAffinity();
                System.exit(0);
            }
        });


    }
}
