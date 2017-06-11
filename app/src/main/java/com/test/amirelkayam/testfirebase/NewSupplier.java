package com.test.amirelkayam.testfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewSupplier extends AppCompatActivity {

    private DatabaseReference mDatabaseSuppliers;

    private ImageView mMainImage;
    private EditText mNameField;
    private EditText mEmailField;
    private EditText mPhoneField;
    private Button mButtonSave;
    private Button btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_supplier);

        mDatabaseSuppliers = FirebaseDatabase.getInstance().getReference().child("Suppliers");

        mMainImage = (ImageView)findViewById(R.id.main_image);
        mNameField = (EditText) findViewById(R.id.name_field);
        mEmailField = (EditText) findViewById(R.id.email_field);
        mPhoneField = (EditText)  findViewById(R.id.phone_field);
        mButtonSave = (Button) findViewById(R.id.save_btn);
        btnBack = (Button) findViewById(R.id.btn_back);


        mMainImage.setOnClickListener(new View.OnClickListener() {   /// app logo - if you click its go back screen
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

    }
}
