package com.example.LootBazar.Connectivity;


import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import com.example.LootBazar.AddCustomer;
import com.example.LootBazar.MainIndex;
import com.example.LootBazar.VendorRegistrationForm;

import org.json.JSONObject;
import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONException;
import com.example.LootBazar.app.AppController;


import java.util.Map;

public class RegisterToServer {
    private static Context context = null;

    private static String bgfirstname;
    private static String bglastname;
    private static String bgemail;
    private static String bgmobile;
    private static String bgwhatsappNo;
    private static String bgpanCardNo;
    private static String bgvat_tin_servicetax_no;
    private static String bgbankAddress;
    private static String bgcompanyPostCode;
    private static String bgproduct;
    /*
    private static String bgusername;
    private static String bgcst;
    private static String bgtelephone;
    private static String bgbankifscCode;
    private static String bgbankName;
    private static String bgbenifiaciaryName;
    private static String bgacountNo;
    private static String bgtypeOfAccount;
    private static String bgpayEmail;
    private static String bgcompanyName;
    private static String bgcompanyId;
    private static String bgcompanyAddress1;
    private static String bgcompanyAddress2;
    private static String bgcompanyCity;
    private static String bgcompanyCountry;
    private static String bgcompanyState;
    private static String bgwebsiteURL;
    private static String bgcompanyDescription;
    private static String bgprimaryCategory;
    private static String bgsubCategory;
    private static String bgtnc;
    */
    private static String method;
    private static String format;
    private static String vendorRegistrationFormResponde;
    private Response.Listener<JSONObject> listener;
    private Map<String, String> params;

    //public static String uploadToRemoteServer(String username,String firstname,String lastname,String email,String panCardNo,String vat_tin_servicetax_no,String cst,String mobile,String telephone,String bankifscCode,String bankName,String bankAddress,String benifiaciaryName,String acountNo,String typeOfAccount,String payEmail,String whatsappNo,String companyName,String companyId,String companyAddress1,String companyAddress2,String companyCity,String companyPostCode,String companyCountry,String companyState,String websiteURL,String companyDescription,String primaryCategory,String subCategory,String product,String tnc) {
    public static String uploadToRemoteServer(String firstname,String lastname,String email,String mobile,String whatsappNo,String panCardNo,String vat_tin_servicetax_no,String bankAddress,String companyPostCode,String product) {
        method = "registration";
        format = "json";

        bgfirstname = firstname;
        bglastname = lastname;
        bgemail = email;
        bgmobile = mobile;
        bgwhatsappNo = whatsappNo;
        bgpanCardNo = panCardNo;
        bgvat_tin_servicetax_no = vat_tin_servicetax_no;
        bgbankAddress = bankAddress;
        bgcompanyPostCode = companyPostCode;
        bgproduct = product;
        /*
        bgusername = username;
        bgcst = cst;
        bgtelephone = telephone;
        bgbankifscCode = bankifscCode;
        bgbankName = bankName;
        bgbenifiaciaryName = benifiaciaryName;
        bgacountNo = acountNo;
        bgtypeOfAccount = typeOfAccount;
        bgpayEmail = payEmail;
        bgcompanyName = companyName;
        bgcompanyId = companyId;
        bgcompanyAddress1 = companyAddress1;
        bgcompanyAddress2 = companyAddress2;
        bgcompanyCity = companyCity;
        bgcompanyCountry = companyCountry;
        bgcompanyState= companyState;
        bgwebsiteURL = websiteURL;
        bgcompanyDescription = companyDescription;
        bgprimaryCategory = primaryCategory;
        bgsubCategory = subCategory;
        bgtnc = tnc;
        */
        final String URL="http://storage.couragedigital.com/dev/gavki/api/gavkiapi.php";

        JSONObject  params = new JSONObject();
        try{
            params.put("method",method);
            params.put("format",format);

            params.put("firstname",bgfirstname);
            params.put("lastname",bglastname);
            params.put("email",bgemail);
            params.put("mobile",bgmobile);
            params.put("whatsappNo",bgwhatsappNo);
            params.put("panCardNo",bgpanCardNo);
            params.put("vat_tin_servicetax_no",bgvat_tin_servicetax_no);
            params.put("bankAddress",bgbankAddress);
            params.put("companyPostCode",bgcompanyPostCode);
            params.put("product",bgproduct);
        /*
            params.put("username",bgusername);
            params.put("cst",bgcst);
            params.put("telephone",bgtelephone);
            params.put("bankifscCode",bgbankifscCode);
            params.put("bankName",bgbankName);
            params.put("benifiaciaryName",bgbenifiaciaryName);
            params.put("acountNo",bgacountNo);
            params.put("typeOfAccount",bgtypeOfAccount);
            params.put("payEmail",bgpayEmail);
            params.put("companyName",bgcompanyName);
            params.put("companyId",bgcompanyId);
            params.put("companyAddress1",bgcompanyAddress1);
            params.put("companyAddress2",bgcompanyAddress2);
            params.put("companyCity",bgcompanyCity);
            params.put("companyCountry",bgcompanyCountry);
            params.put("companyState",bgcompanyState);
            params.put("websiteURL",bgwebsiteURL);
            params.put("companyDescription",bgcompanyDescription);
            params.put("primaryCategory",bgprimaryCategory);
            params.put("subCategory",bgsubCategory);
        */

        }catch (Exception e){

        }

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, URL, params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        VolleyLog.v("Response:%n %s", response.toString());
                        VendorRegistrationForm vendorRegistrationForm = new VendorRegistrationForm();
                        try {
                            returnResponse(response.getString("saveRegistrationDetailsResponse"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
            }
        }
        );
        AppController.getInstance().addToRequestQueue(req);
        return vendorRegistrationFormResponde;
    }

    public RegisterToServer(Context context) {
        this.context = context;
    }

    public static void returnResponse(String response) {
        if (response.equals("REGISTRATION_DETAILS_SAVED")) {
            Toast.makeText(context, "Successfully Saved.", Toast.LENGTH_SHORT).show();
            Intent gotoAddCustomer = new Intent(context, MainIndex.class);
            context.startActivity(gotoAddCustomer);
        } else if (response.equals("ERROR")) {
            Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
            Intent gotovendorRegistrationForm = new Intent(context, VendorRegistrationForm.class);
            context.startActivity(gotovendorRegistrationForm);
        }
    }
}
