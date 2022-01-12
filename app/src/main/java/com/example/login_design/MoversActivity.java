package com.example.login_design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MoversActivity extends AppCompatActivity {
    Button btn2, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movers);

        btn2 = findViewById(R.id.btn2);
        btn4 = findViewById(R.id.btn4);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new CityPackerFragement());
            }

            private void loadFragment(CityPackerFragement cityPackerFragement) {
                FragmentManager fm = getSupportFragmentManager();  //create the manager
                FragmentTransaction fragmentTransaction = fm.beginTransaction(); //Transaction method
                fragmentTransaction.replace(R.id.framelayout,cityPackerFragement); //call methhod
                fragmentTransaction.commit(); //saving method
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new BetweenCity());
            }

            private void loadFragment(BetweenCity betweenCity) {
                FragmentManager fm = getSupportFragmentManager();  //create the manager
                FragmentTransaction fragmentTransaction = fm.beginTransaction(); //Transaction method
                fragmentTransaction.replace(R.id.framelayout, betweenCity); //call methhod
                fragmentTransaction.commit(); //saving method
            }
        });
    }
}

