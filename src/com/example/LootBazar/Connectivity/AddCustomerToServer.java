package com.example.LootBazar.Connectivity;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.LootBazar.AddCustomer;
import com.example.LootBazar.MainIndex;
import com.example.LootBazar.VendorRegistrationForm;
import com.example.LootBazar.app.AppController;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class AddCustomerToServer {
    private static Context context = null;

    private static String bgCustomerName;
    private static String bgCustomerContactno;
    private static String bgCustomerEmail;

    private static String method;
    private static String format;
    private static String addCustomerFormResponde;
    private Response.Listener<JSONObject> listener;
    private Map<String, String> params;
    public static String uploadCustomerToServer(String customerName,String customerContactNo, String customerEmail) {

        method = "addCustomer";
        format = "json";

        bgCustomerName = customerName;
        bgCustomerContactno = customerContactNo;
        bgCustomerEmail = customerEmail;

        final String URL="http://storage.couragedigital.com/dev/gavki/api/gavkiapi.php";

        JSONObject  params = new JSONObject();
        try{
            params.put("method",method);
            params.put("format",format);

            params.put("customerName",bgCustomerName);
            params.put("customerContactNo",bgCustomerContactno);
            params.put("customerEmail",bgCustomerEmail);


        }catch (Exception e){

        }

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, URL, params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        VolleyLog.v("Response:%n %s", response.toString());
                        AddCustomer addCustomer = new AddCustomer();
                        try {
                            returnResponse(response.getString("saveCustomerDetailsResponse"));
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

        return addCustomerFormResponde;
    }

    public AddCustomerToServer(Context context) {
        this.context = context;
    }

    public static void returnResponse(String response) {
        if (response.equals("CUSTOMER_DETAILS_SAVED")) {
            Toast.makeText(context, "Successfully Saved.", Toast.LENGTH_SHORT).show();
            Intent gotoMainIndex = new Intent(context, MainIndex.class);
            context.startActivity(gotoMainIndex);
        } else if (response.equals("ERROR")) {
            Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
            Intent gotoAddCustomer = new Intent(context, AddCustomer.class);
            context.startActivity(gotoAddCustomer);
        }
    }
}
