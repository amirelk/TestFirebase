package com.test.amirelkayam.testfirebase;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    DatabaseReference mDatabase;
    Button mButtonChange;
    EditText mNameField;
    EditText mEmailField;
    EditText mPhoneField;
    EditText mShowName;


    Button mSuppliers;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Customers");
        mButtonChange = (Button) findViewById(R.id.change_btn);

        mNameField = (EditText) findViewById(R.id.name_field);
        mEmailField = (EditText) findViewById(R.id.email_field);
        mPhoneField = (EditText)  findViewById(R.id.phone_field);
        mShowName = (EditText) findViewById(R.id.show_name);


        mSuppliers = (Button) findViewById(R.id.btn_suppliers);




        mSuppliers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_sup = new Intent(getApplicationContext(), Suppliers.class);
                startActivity(intent_sup);
            }
        });


/*
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String showName = dataSnapshot.getValue().toString();
                mShowName.setText("Name : " + showName);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
*/

        mButtonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = mNameField.getText().toString().trim();
                String email = mEmailField.getText().toString().trim();
                String phone = mPhoneField.getText().toString().trim();


                HashMap<String, String> dataMap = new HashMap<String, String>();
                dataMap.put("Name", name);
                dataMap.put("Email", email);
                dataMap.put("Phone", phone);


                mDatabase.push().setValue(dataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Stored...", Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(MainActivity.this, "Error...", Toast.LENGTH_LONG).show();

                        }
                    }
                });

            }
        });


    }


}

/*ilya coment*/