package com.example.LootBazar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.LootBazar.Connectivity.RegisterToServer;

public class VendorRegistrationForm extends AppCompatActivity {
    private static EditText txt_username;
    private static EditText txt_firstname;
    private static EditText txt_lastname;
    private static EditText txt_email;
    private static EditText txt_panCardNo;
    private static EditText txt_vat_tin_servicetax_no;
    private static EditText txt_cst;
    private static EditText txt_mobile;
    private static EditText txt_telephone;
    private static EditText txt_bankifscCode;
    private static EditText txt_bankName;
    private static EditText txt_bankAddress;
    private static EditText txt_benifiaciaryName;
    private static EditText txt_acountNo;
    private static EditText txt_typeOfAccount;
    private static EditText txt_payEmail;
    private static EditText txt_whatsappNo;
    private static EditText txt_companyName;
    private static EditText txt_companyId;
    private static EditText txt_companyAddress1;
    private static EditText txt_companyAddress2;
    private static EditText txt_companyCity;
    private static EditText txt_companyPostCode;
    private static EditText ddl_companyCountry;
    private static EditText txt_companyState;
    private static EditText txt_websiteURL;
    private static EditText txt_companyDescription;
    private static EditText ddl_primaryCategory;
    private static EditText ddl_subCategory;
    private static EditText txt_product;
    private static EditText chk_tnc;




    private static Button btn_AddMember;
    private static Button btn_Submit;
    private static Button btn_Cancel;


    String username;
    String firstname;
    String lastname;
    String email;
    String panCardNo;
    String vat_tin_servicetax_no;
    String cst;
    String mobile;
    String telephone;
    String bankifscCode;
    String bankName;
    String bankAddress;
    String benifiaciaryName;
    String acountNo;
    String typeOfAccount;
    String payEmail;
    String whatsappNo;
    String companyName;
    String companyId;
    String companyAddress1;
    String companyAddress2;
    String companyCity;
    String companyPostCode;
    String companyState;
    String companyCountry;
    String websiteURL;
    String companyDescription;
    String primaryCategory;
    String subCategory;
    String product;
    String tnc;



    ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vendor_registration);
        SubmitButton();
        CancelButton();

    }

    public void CancelButton(){
        btn_Cancel=(Button) findViewById(R.id.btnCancel);
        btn_Cancel.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), MainIndex.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.putExtra("EXIT", true);
                        startActivity(intent);
                    }
                }
        );
    }


    public void SubmitButton(){
        btn_Submit=(Button) findViewById(R.id.btnSubmit);


        txt_firstname =(EditText) findViewById(R.id.txtfirstname);
        txt_lastname =(EditText) findViewById(R.id.txtlastname);
        txt_email =(EditText) findViewById(R.id.txtemail);
        txt_mobile =(EditText) findViewById(R.id.txtmobile);
        txt_whatsappNo =(EditText) findViewById(R.id.txtwhatsappNo);
        txt_panCardNo =(EditText) findViewById(R.id.txtpanCardNo);
        txt_vat_tin_servicetax_no =(EditText) findViewById(R.id.txtvat_tin_servicetax_no);
        txt_bankAddress =(EditText) findViewById(R.id.txtbankAddress);
        txt_companyPostCode =(EditText) findViewById(R.id.txtcompanyPostCode);
        txt_product =(EditText) findViewById(R.id.txtproduct);
/*
        txt_username =(EditText) findViewById(R.id.txtusername);
        txt_cst =(EditText) findViewById(R.id.txtcst);
        txt_telephone =(EditText) findViewById(R.id.txttelephone);
        txt_bankifscCode =(EditText) findViewById(R.id.txtbankifscCode);
        txt_bankName =(EditText) findViewById(R.id.txtbankName);
        txt_benifiaciaryName =(EditText) findViewById(R.id.txtbenifiaciaryName);
        txt_acountNo =(EditText) findViewById(R.id.txtacountNo);
        txt_typeOfAccount =(EditText) findViewById(R.id.txttypeOfAccount);
        txt_payEmail =(EditText) findViewById(R.id.txtpayEmail);
        txt_companyName =(EditText) findViewById(R.id.txtcompanyName);
        txt_companyId =(EditText) findViewById(R.id.txtcompanyId);
        txt_companyAddress1 =(EditText) findViewById(R.id.txtcompanyAddress1);
        txt_companyAddress2 =(EditText) findViewById(R.id.txtcompanyAddress2);
        txt_companyCity =(EditText) findViewById(R.id.txtcompanyCity);
        ddl_companyCountry =(EditText) findViewById(R.id.ddlcompanyCountry);
        txt_companyState =(EditText) findViewById(R.id.txtcompanyState);
        txt_websiteURL =(EditText) findViewById(R.id.txtwebsiteURL);
        txt_companyDescription =(EditText) findViewById(R.id.ddlprimaryCategory);
        ddl_primaryCategory =(EditText) findViewById(R.id.ddlprimaryCategory);
        ddl_subCategory =(EditText) findViewById(R.id.ddlsubCategory);

        chk_tnc =(EditText) findViewById(R.id.txttnc);
    */
        btn_Submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        firstname = txt_firstname.getText().toString();
                        lastname = txt_lastname.getText().toString();
                        email = txt_email.getText().toString();
                        mobile  = txt_mobile.getText().toString();
                        whatsappNo = txt_whatsappNo.getText().toString();
                        panCardNo = txt_panCardNo.getText().toString();
                        vat_tin_servicetax_no = txt_vat_tin_servicetax_no.getText().toString();
                        bankAddress = txt_bankAddress.getText().toString();
                        companyPostCode = txt_companyPostCode.getText().toString();
                        product = txt_product.getText().toString();
                        /*
                        username = txt_username.getText().toString();
                        cst = txt_cst.getText().toString();
                        telephone = txt_telephone.getText().toString();
                        bankifscCode = txt_bankifscCode.getText().toString();
                        bankName = txt_bankName.getText().toString();
                        benifiaciaryName = txt_benifiaciaryName.getText().toString();
                        acountNo = txt_acountNo.getText().toString();
                        typeOfAccount = txt_typeOfAccount.getText().toString();
                        payEmail = txt_payEmail.getText().toString();
                        companyName = txt_companyName.getText().toString();
                        companyId = txt_companyId.getText().toString();
                        companyAddress1 = txt_companyAddress1.getText().toString();
                        companyAddress2 = txt_companyAddress2.getText().toString();
                        companyCity = txt_companyCity.getText().toString();
                        companyCountry = ddl_companyCountry.getText().toString();
                        companyState = txt_companyState.getText().toString();
                        websiteURL = txt_websiteURL.getText().toString();
                        companyDescription = txt_companyDescription.getText().toString();
                        primaryCategory = ddl_primaryCategory.getText().toString();
                        subCategory = ddl_subCategory.getText().toString();
                        tnc = chk_tnc.getText().toString();
                    */


                            if( (mobile.length()!=10 && whatsappNo.length()!=10) ) {
                                Toast.makeText(VendorRegistrationForm.this, "Please enter valid No", Toast.LENGTH_LONG).show();
                            }

                            else {
                                progressDialog = new ProgressDialog(VendorRegistrationForm.this);
                                progressDialog.setMessage("Registering Data Wait...");
                                progressDialog.show();
                                try {
                                    RegisterToServer registerToServer = new RegisterToServer(VendorRegistrationForm.this);
                                    //registerToServer.uploadToRemoteServer(username,firstname,lastname,email,panCardNo,vat_tin_servicetax_no,cst,mobile,telephone,bankifscCode,bankName,bankAddress,benifiaciaryName,acountNo,typeOfAccount,payEmail,whatsappNo,companyName,companyId,companyAddress1,companyAddress2,companyCity,companyPostCode,companyCountry,companyState,websiteURL,companyDescription,primaryCategory,subCategory,product,tnc);
                                    registerToServer.uploadToRemoteServer(firstname, lastname, email, mobile, whatsappNo, panCardNo, vat_tin_servicetax_no, bankAddress, companyPostCode, product);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    progressDialog.dismiss();
                                    Toast.makeText(VendorRegistrationForm.this, "Exception : " + e.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }
                        txt_firstname.setText("");
                        txt_lastname.setText("");
                        txt_email.setText("");
                        txt_mobile.setText("");
                        txt_whatsappNo.setText("");
                        txt_panCardNo.setText("");
                        txt_vat_tin_servicetax_no.setText("");
                        txt_bankAddress.setText("");
                        txt_companyPostCode.setText("");
                        txt_product.setText("");
                        }
                }
        );
    }

}
