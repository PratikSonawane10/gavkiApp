package com.example.LootBazar;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddMember extends AppCompatActivity {

    private static EditText txt_MemberName;
    private static EditText txt_MemberContactNo;
    private static EditText txt_MemberEmail;

    private static Button btn_AddMember;
    private static Button btn_Cancel;

    ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addmember);

        AddMemberButton();
        CancelButton();
    }

    public void AddMemberButton(){
        btn_AddMember =(Button) findViewById(R.id.btnAddMember);
        txt_MemberName =(EditText) findViewById(R.id.txtMemberName);
        txt_MemberContactNo =(EditText) findViewById(R.id.txtMemberContactNo);
        txt_MemberEmail =(EditText) findViewById(R.id.txtMemberEmail);

    }

    public void CancelButton(){
        btn_Cancel=(Button) findViewById(R.id.btnCancel);
        btn_Cancel.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent gotoAddBachatgatform = new Intent(AddMember.this,VendorRegistrationForm.class);
                        startActivity(gotoAddBachatgatform);
                    }
                }
        );
    }
}
