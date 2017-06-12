package com.test.amirelkayam.testfirebase;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Suppliers extends AppCompatActivity { // Start Suppliers

    private Button mButtonFindSuppliers;
    private Button mButtonNewSupplier;
    private ImageView mMainImage;
    private EditText mFindSuppliers;
    private Button btnBack;



    @Override
    protected void onCreate(Bundle savedInstanceState) {    // Start OnCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suppliers);

        mButtonFindSuppliers = (Button) findViewById(R.id.btn_findSuppliers);
        mButtonNewSupplier = (Button) findViewById(R.id.btn_newSupplier);
        mMainImage = (ImageView)findViewById(R.id.main_image);
        mFindSuppliers = (EditText)findViewById(R.id.editText_findSuppliers);
        btnBack = (Button) findViewById(R.id.btn_back);


        mMainImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }  // End OnCreate


    // OnClick NewSupplier from suppliers XML
    public void btnNewSupplier_Click(View v){
        Intent intent_newSupplier = new Intent(getApplicationContext(), NewSupplier.class);
        startActivity(intent_newSupplier);
    }

    public void btnFindSuppliers_Click(View v){

    }

}  //End Suppliers
