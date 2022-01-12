package com.example.login_design;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Customer_Details extends AppCompatActivity{

    EditText ed5,ed6,ed7,ed8;
    Button btn4;

    String n,e,a,p;

    private FirebaseFirestore db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);

        db = FirebaseFirestore.getInstance();
        ed5 = findViewById(R.id.ed5);
        ed6 = findViewById(R.id.ed6);
        ed7 = findViewById(R.id.ed7);
        ed8 = findViewById(R.id.ed8);

        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                n = ed5.getText().toString();
                e = ed6.getText().toString();
                a = ed7.getText().toString();
                p = ed8.getText().toString();

                Log.v("Form_Data", n);
                Log.v("Form_Data", e);
                Log.v("Form_Data", a);
                Log.v("Form_Data", p);




                if (TextUtils.isEmpty(n)){
                    Toast.makeText(Customer_Details.this, "Fill the Name", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(e)){
                    Toast.makeText(Customer_Details.this, "fill the Email", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(a)){
                    Toast.makeText(Customer_Details.this, "Fill the Address", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(p)){
                    Toast.makeText(Customer_Details.this, "Fill the Phone", Toast.LENGTH_SHORT).show();
                }
                else {
                    addDataToFirestore(n,e,a,p);
                    ed5.setText("");
                    ed6.setText("");
                    ed7.setText("");
                    ed8.setText("");
                }
            }

            private void addDataToFirestore(String name, String email, String address, String phone) {
                CollectionReference dbDonate = db.collection("Donate");
                Donate donate = new Donate(name,email,address,phone);
                dbDonate.add(donate).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(Customer_Details.this, "Data is stored", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Customer_Details.this,RecycleActivity.class);
                        startActivity(intent);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Customer_Details.this, "Please fill the all form", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}