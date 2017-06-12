package com.test.amirelkayam.testfirebase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class NewCustomer extends AppCompatActivity {

    private DatabaseReference mDatabaseCustomers;

    private ImageView mMainImage;
    private EditText mNameField;
    private EditText mEmailField;
    private EditText mPhoneField;
    private Button mButtonSave;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_customer);

        mDatabaseCustomers = FirebaseDatabase.getInstance().getReference().child("Customers");

        mMainImage = (ImageView) findViewById(R.id.main_image);
        mNameField = (EditText) findViewById(R.id.name_field);
        mEmailField = (EditText) findViewById(R.id.email_field);
        mPhoneField = (EditText) findViewById(R.id.phone_field);
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


        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = mNameField.getText().toString().trim();
                String email = mEmailField.getText().toString().trim();
                String phone = mPhoneField.getText().toString().trim();

                if(TextUtils.isEmpty(name) || TextUtils.isEmpty(phone)){
                    Toast.makeText(getApplicationContext(), "חובה להזין שם לקוח וטלפון", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!TextUtils.isEmpty(phone)){
                    if(phone.length() < 10){
                        Toast.makeText(getApplicationContext(), "טלפון חייב להיות מינימום 10 תווים", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                HashMap<String, String> dataMap = new HashMap<String, String>();
                dataMap.put("Name", name);
                dataMap.put("Email", email);
                dataMap.put("Phone", phone);

                mDatabaseCustomers.push().setValue(dataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(NewCustomer.this, "הלקוח נוסף בהצלחה!", Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(NewCustomer.this, "שגיאה...", Toast.LENGTH_LONG).show();

                        }
                    }
                });


            }

        });
    }
}