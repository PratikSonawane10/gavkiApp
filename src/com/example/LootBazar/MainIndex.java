package com.example.LootBazar;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainIndex extends AppCompatActivity {
    private static Button btn_AddCustomer;
    private static Button btn_VendorRegistration;

    ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainindex);


        AddCustomer();
        VendorRegistrationForm();
    }
    public void AddCustomer(){
        btn_AddCustomer=(Button)findViewById(R.id.btnAddCustomer);
        btn_AddCustomer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent gotoAddCustomer = new Intent(MainIndex.this,AddCustomer.class);
                        startActivity(gotoAddCustomer);
                    }
                }
        );
    }
    public void VendorRegistrationForm(){
        btn_VendorRegistration=(Button) findViewById(R.id.btnvendorRegistration);
        btn_VendorRegistration.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent gotoVendorRegistrationForm = new Intent(MainIndex.this,VendorRegistrationForm.class);
                        startActivity(gotoVendorRegistrationForm);
                    }
                }
        );
    }
}
