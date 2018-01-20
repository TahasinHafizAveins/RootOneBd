package com.rootonebd.rootonebd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rootonebd.rootonebd.Utilities.RootOneAppPref;

public class LogInActivity extends AppCompatActivity {
    private EditText etEmail, etPassword;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        etEmail = findViewById(R.id.email);
        etPassword = findViewById(R.id.password);
        btnSubmit = findViewById(R.id.custom_submit_btn);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                if(email.equals("reza@gmail.com") && password.equals("123456")){
                    RootOneAppPref appPref = new RootOneAppPref(getApplicationContext());
                    appPref.setLogIn(true);
                    finish();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }
            }
        });
    }
}
