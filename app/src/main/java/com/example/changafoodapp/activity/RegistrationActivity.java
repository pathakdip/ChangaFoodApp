package com.example.changafoodapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.changafoodapp.R;
import com.firebase.client.Firebase;

import org.json.JSONException;
import org.json.JSONObject;

public class RegistrationActivity extends AppCompatActivity {

    private Button btnRegister;
    private EditText et_username,et_password;
    private TextView txtLogin;
    String user, pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_registration);

        Firebase.setAndroidContext(this);

        et_username=findViewById(R.id.et_username);
        et_password=findViewById(R.id.et_password);
        btnRegister=findViewById(R.id.btnRegister);
        txtLogin=findViewById(R.id.txtLoginHere);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user = et_username.getText().toString();
                pass = et_password.getText().toString();

                if(user.equals("")){
                    et_username.setError("can't be blank");
                }
                else if(pass.equals("")){
                    et_password.setError("can't be blank");
                }
                else if(!user.matches("[A-Za-z0-9]+")){
                    et_username.setError("only alphabet or number allowed");
                }
                else if(user.length()<5){
                    et_password.setError("at least 5 characters long");
                }
                else if(pass.length()<5){
                    et_password.setError("at least 5 characters long");
                }
                else {
                    final ProgressDialog pd = new ProgressDialog(RegistrationActivity.this);
                    pd.setMessage("Loading...");
                    pd.show();

                    //String url = "https://letsgetfoodie-3da95.firebaseio.com//users.json";
                    String url = "https://changafoodapp-9b8f3.firebaseio.com//users.json";

                    StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>(){
                        @Override
                        public void onResponse(String s) {
                            //Firebase reference = new Firebase("https://letsgetfoodie-3da95.firebaseio.com/users");
                            Firebase reference = new Firebase("https://changafoodapp-9b8f3.firebaseio.com/users");

                            if(s.equals("null")) {
                                reference.child(user).child("password").setValue(pass);
                                Toast.makeText(RegistrationActivity.this, "registration successful", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(RegistrationActivity.this,Dashboard.class));

                            }
                            else {
                                try {
                                    JSONObject obj = new JSONObject(s);

                                    if (!obj.has(user)) {
                                        reference.child(user).child("password").setValue(pass);
                                        Toast.makeText(RegistrationActivity.this, "registration successful", Toast.LENGTH_LONG).show();
                                        startActivity(new Intent(RegistrationActivity.this,Dashboard.class));

                                    } else {
                                        Toast.makeText(RegistrationActivity.this, "username already exists", Toast.LENGTH_LONG).show();
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            pd.dismiss();
                        }

                    },new Response.ErrorListener(){
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {
                            System.out.println("" + volleyError );
                            pd.dismiss();
                        }
                    });

                    RequestQueue rQueue = Volley.newRequestQueue(RegistrationActivity.this);
                    rQueue.add(request);
                }
            }
        });

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this,MainActivity.class));

            }
        });

    }
}
