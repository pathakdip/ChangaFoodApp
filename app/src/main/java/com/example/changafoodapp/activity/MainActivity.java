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
import com.example.changafoodapp.model.UserDetails;
import com.firebase.client.Firebase;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText et_username,et_password;
    private TextView txtRegister;
    String user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        Firebase.setAndroidContext(this);

        et_username=findViewById(R.id.et_username);
        et_password=findViewById(R.id.et_password);
        btnLogin=findViewById(R.id.btnLogin);
        txtRegister=findViewById(R.id.txtRegisterHere);

        btnLogin.setOnClickListener(new View.OnClickListener() {
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
                else{
                    //String url = "https://letsgetfoodie-3da95.firebaseio.com//users.json";
                    String url = "https://changafoodapp-9b8f3.firebaseio.com//users.json";
                    final ProgressDialog pd = new ProgressDialog(MainActivity.this);
                    pd.setMessage("Loading...");
                    pd.show();

                    StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>(){
                        @Override
                        public void onResponse(String s) {
                            if(s.equals("null")){
                                Toast.makeText(MainActivity.this, "user not found", Toast.LENGTH_LONG).show();
                            }
                            else{
                                try {
                                    JSONObject obj = new JSONObject(s);

                                    if(!obj.has(user)){
                                        Toast.makeText(MainActivity.this, "user not found", Toast.LENGTH_LONG).show();
                                    }
                                    else if(obj.getJSONObject(user).getString("password").equals(pass)){
                                        UserDetails.username = user;
                                        UserDetails.password = pass;

                                        Toast.makeText(getApplicationContext(),"Login SuccessFul!",Toast.LENGTH_LONG).show();
                                        startActivity(new Intent(MainActivity.this,Dashboard.class));

                                    }
                                    else {
                                        Toast.makeText(MainActivity.this, "incorrect password", Toast.LENGTH_LONG).show();
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
                            System.out.println("" + volleyError);
                            pd.dismiss();
                        }
                    });

                    RequestQueue rQueue = Volley.newRequestQueue(MainActivity.this);
                    rQueue.add(request);
                }

            }
        });


        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Register here",Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this,RegistrationActivity.class));

            }
        });

    }
}