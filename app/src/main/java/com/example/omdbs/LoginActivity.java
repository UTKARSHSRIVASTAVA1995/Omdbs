package com.example.omdbs;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.omdbs.dashboard.DashboardActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private final AppCompatActivity activity = LoginActivity.this;
    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextPassword;
    private Button appCompatButtonLogin;
    private TextView textViewLinkRegister;
    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        initListeners();
        initObjects();

    }

    private void initObjects() {

        inputValidation = new InputValidation(activity);
        databaseHelper = new DatabaseHelper(activity);

    }

    private void initListeners() {

        appCompatButtonLogin.setOnClickListener(this);
        textViewLinkRegister.setOnClickListener(this);

    }

    private void initViews() {

        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail);
        textInputLayoutName = findViewById(R.id.textInputEditTextName);
        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword);
        textInputEditTextEmail = findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPassword = findViewById(R.id.textInputEditTextPassword);
        appCompatButtonLogin = findViewById(R.id.appCompatButtonLogin);
        textViewLinkRegister = findViewById(R.id.textViewLinkRegister);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.appCompatButtonLogin:
                verifyFromSQLite();
                break;

            case R.id.textViewLinkRegister:
                Intent intentRegister = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intentRegister);
                break;
        }
    }

    private void verifyFromSQLite() {


        if (!inputValidation.isInputEditTextFilled(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword, getString(R.string.error_message_password1))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword, getString(R.string.error_message_password1))) {
            return;
        }
        if (databaseHelper.checkUser(textInputEditTextEmail.getText().toString().trim(), textInputEditTextPassword.getText().toString().trim())) {

            SharedPreferences.Editor editor = getSharedPreferences("datasaving", MODE_PRIVATE).edit();
            editor.putString("loggedIn", "userlogged");
            editor.apply();

            Intent accountsIntent = new Intent(activity, DashboardActivity.class);
            startActivity(accountsIntent);

        } else {

            Toast.makeText(LoginActivity.this, "No user Found" , Toast.LENGTH_SHORT).show();
        }
    }
}
