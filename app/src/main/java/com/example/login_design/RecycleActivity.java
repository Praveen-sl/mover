package com.example.login_design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecycleActivity extends AppCompatActivity {

    RecyclerView recycle;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        recycle = findViewById(R.id.recycle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recycle.setLayoutManager(layoutManager);
        customAdapter = new CustomAdapter(getData());
        recycle.setItemAnimator(new DefaultItemAnimator());
        recycle.setAdapter(customAdapter);
    }

    private ArrayList<Getter_Setter> getData() {
        ArrayList<Getter_Setter> Getter_SetterArraylist = new ArrayList<>();

        Getter_Setter data = new Getter_Setter();
        data.setImage(R.drawable.truck1);
        data.setName("Praveen");
        data.setCapacity("KA3445");
        data.setButton("9025589987");
        data.setLocation("Bangalore");
        Getter_SetterArraylist.add(data);

        Getter_Setter data1 = new Getter_Setter();
        data1.setImage(R.drawable.shipment);
        data1.setName("Rockie");
        data1.setCapacity("TN209");
        data1.setButton("9056773178");
        data1.setLocation("Chennai");
        Getter_SetterArraylist.add(data1);

        Getter_Setter data2 = new Getter_Setter();
        data2.setImage(R.drawable.pickup);
        data2.setName("John");
        data2.setCapacity("Kl309");
        data2.setButton("9056378228");
        data2.setLocation("Kerala");
        Getter_SetterArraylist.add(data2);

        Getter_Setter data3 = new Getter_Setter();
        data3.setImage(R.drawable.transportation);
        data3.setName("Ganesh");
        data3.setCapacity("Del409");
        data3.setButton("9377575427");
        data3.setLocation("Delhi");
        Getter_SetterArraylist.add(data3);

        Getter_Setter data4 = new Getter_Setter();
        data4.setImage(R.drawable.container);
        data4.setName("Sing");
        data4.setCapacity("Raj209");
        data4.setButton("8476737283");
        data4.setLocation("Rajasthan");
        Getter_SetterArraylist.add(data4);

        return Getter_SetterArraylist;

    }
}