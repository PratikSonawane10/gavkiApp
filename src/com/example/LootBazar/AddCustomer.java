package com.example.LootBazar;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.LootBazar.Connectivity.AddCustomerToServer;


public class AddCustomer extends AppCompatActivity {

    private static EditText txt_customerName;
    private static EditText txt_customerContactNo;
    private static EditText txt_customerEmail;

    String customerName;
    String customerContactNo;
    String customerEmail;

    private static Button btn_AddCustomerr;
    private static Button btn_Cancel;

    ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcustomer);

        SubmitButton();
        CancelButton();
    }

    public void SubmitButton(){
        btn_AddCustomerr=(Button) findViewById(R.id.btnAddCustomer);

        txt_customerName =(EditText) findViewById(R.id.txtCustomerName);
        txt_customerContactNo =(EditText) findViewById(R.id.txtCustomerContactNo);
        txt_customerEmail =(EditText) findViewById(R.id.txtCustomerEmail);

        btn_AddCustomerr.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        customerName = txt_customerName.getText().toString();
                        customerContactNo = txt_customerContactNo.getText().toString();
                        customerEmail = txt_customerEmail.getText().toString();


                            progressDialog = new ProgressDialog(AddCustomer.this);
                            progressDialog.setMessage("Registering Data Wait...");
                            progressDialog.show();
                            try {
                                AddCustomerToServer addCustomerToServer = new AddCustomerToServer(AddCustomer.this);
                                addCustomerToServer.uploadCustomerToServer(customerName, customerContactNo, customerEmail);
                            } catch (Exception e) {
                                e.printStackTrace();
                                progressDialog.dismiss();
                                Toast.makeText(AddCustomer.this, "Exception : " + e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        txt_customerName.setText("");
                        txt_customerContactNo.setText("");
                        txt_customerEmail.setText("");

                    }
                }
        );

    }

    public void CancelButton(){
        btn_Cancel=(Button) findViewById(R.id.btnCancel);
        btn_Cancel.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent gotoMainIndex = new Intent(AddCustomer.this,MainIndex.class);
                        startActivity(gotoMainIndex);
                    }
                }
        );
    }
}
