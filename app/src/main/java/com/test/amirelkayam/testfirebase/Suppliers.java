package com.test.amirelkayam.testfirebase;

import android.content.Context;
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

public class Suppliers extends AppCompatActivity {

    DatabaseReference mDatabaseSuppliers;

    Button mButtonFindSuppliers;
    Button mButtonNewSuppliers;
    ImageView mMainImage;
    EditText mFindSuppliers;


    Button mButtonSave;
    EditText mNameField;
    EditText mEmailField;
    EditText mPhoneField;

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suppliers);

        mDatabaseSuppliers = FirebaseDatabase.getInstance().getReference().child("Suppliers");


        mButtonFindSuppliers = (Button) findViewById(R.id.btn_findSuppliers);
        mButtonNewSuppliers = (Button) findViewById(R.id.btn_newSuppliers);
        mMainImage = (ImageView)findViewById(R.id.main_image);
        mFindSuppliers = (EditText)findViewById(R.id.editText_findSuppliers);


        mButtonSave = (Button) findViewById(R.id.save_btn);
        mNameField = (EditText) findViewById(R.id.name_field);
        mEmailField = (EditText) findViewById(R.id.email_field);
        mPhoneField = (EditText)  findViewById(R.id.phone_field);

/*
        mButtonNewSuppliers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li = LayoutInflater.from(context);
                View customView = li.inflate(R.layout.inflater_new_supplier, null);
            }
        });
*/
        /// itsirat mazinim
        View.OnClickListener ocBtn_findSuppliers =new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //TODO som Action
                Toast.makeText(Suppliers.this, "ocBtn_findSuppliers", Toast.LENGTH_SHORT).show();
            }
        };


        View.OnClickListener ocBtn_newSuppliers =new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //TODO som Action
                LayoutInflater li = LayoutInflater.from(context);
                View customView = li.inflate(R.layout.inflater_new_supplier, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                alertDialogBuilder.setView(customView);

            }
        };

        View.OnClickListener oc_imageView =new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //TODO som Action
                finish();
             //   Toast.makeText(Suppliers.this, "oc_imageView", Toast.LENGTH_SHORT).show();
            }
        };

        View.OnClickListener oc_editText_findSuppliers =new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //TODO som Action
                Toast.makeText(Suppliers.this, "oc_editText_findSuppliers", Toast.LENGTH_SHORT).show();
            }
        };

        /// afalat hakaftorim
        mButtonFindSuppliers.setOnClickListener(ocBtn_findSuppliers);
        mButtonNewSuppliers.setOnClickListener(ocBtn_newSuppliers);
        mMainImage.setOnClickListener(oc_imageView);
        mFindSuppliers.setOnClickListener(oc_editText_findSuppliers);



        // testing GitHub upload
        // upload to MASTERRRRRRRRRRRRRRRRRRRRRRRRRRRR
        //can you SEE ??
    }
}
