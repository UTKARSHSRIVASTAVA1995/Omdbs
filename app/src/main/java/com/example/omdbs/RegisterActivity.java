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

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = RegisterActivity.this;


    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutCompanyOrganization;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private TextInputLayout textInputLayoutVerifyEmail;
    private TextInputEditText textInputEditTextName;
    private TextInputEditText textInputEditTextCompanyOrganization;
    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextPassword;
    private TextInputEditText textInputEditTextVerifyEmail;
    private Button appCompatButtonRegister;
    private TextView appCompatTextViewLoginLink;
    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();
        initListeners();
        initObjects();
    }

    private void initObjects() {

        inputValidation = new InputValidation(activity);
        databaseHelper = new DatabaseHelper(activity);
        user = new User();

    }

    private void initListeners() {

        appCompatButtonRegister.setOnClickListener(this);
        appCompatTextViewLoginLink.setOnClickListener(this);

    }

    private void initViews() {

        textInputLayoutName = findViewById(R.id.textInputLayoutName);
        textInputLayoutCompanyOrganization = findViewById(R.id.textInputLayoutCompanyOrganization);
        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword);
        textInputLayoutVerifyEmail = findViewById(R.id.textInputLayoutVerifyEmail);
        textInputEditTextName = findViewById(R.id.textInputEditTextName);
        textInputEditTextCompanyOrganization = findViewById(R.id.textInputEditTextCompanyOrganization);
        textInputEditTextEmail = findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPassword = findViewById(R.id.textInputEditTextPassword);
        textInputEditTextVerifyEmail = findViewById(R.id.textInputEditTextVerifyEmail);
        appCompatButtonRegister = findViewById(R.id.appCompatButtonRegister);
        appCompatTextViewLoginLink = findViewById(R.id.appCompatTextViewLoginLink);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.appCompatButtonRegister:
                postDataToSQLite();
                break;
            case R.id.appCompatTextViewLoginLink:
                finish();
                break;
        }
    }

    private void postDataToSQLite() {

        if (!inputValidation.isInputEditTextFilled(textInputEditTextName, textInputLayoutName, getString(R.string.error_message_name))) {
            return;
        }

        if (!inputValidation.isInputEditTextFilled(textInputEditTextCompanyOrganization, textInputLayoutCompanyOrganization, getString(R.string.error_message_company_organization))) {

            return;
        }

        if (!inputValidation.isInputEditTextFilled(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }

        if (!inputValidation.isInputEditTextEmail(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextMatches(textInputEditTextEmail, textInputEditTextVerifyEmail, textInputLayoutVerifyEmail, getString(R.string.error_email_match))) {
            return;
        }

        if (!inputValidation.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword, getString(R.string.error_message_password))) {
            return;

            
        }

        if (!databaseHelper.checkUsers(textInputEditTextEmail.getText().toString().trim())) {
            user.setName(textInputEditTextName.getText().toString().trim());
            user.setEmail(textInputEditTextEmail.getText().toString().trim());
            user.setPassword(textInputEditTextPassword.getText().toString().trim());
            user.setCompanyOrganization(textInputEditTextCompanyOrganization.getText().toString().trim());
            databaseHelper.addUser(user);

            SharedPreferences.Editor editor = getSharedPreferences("datasaving", MODE_PRIVATE).edit();
            editor.putString("loggedIn", "userlogged");
            editor.apply();

            Toast.makeText(RegisterActivity.this, "Registration SuccessFull", Toast.LENGTH_LONG).show();
            startActivity(new Intent(RegisterActivity.this, DashboardActivity.class));
        } else {
            Toast.makeText(RegisterActivity.this, "Registration not SuccessFull", Toast.LENGTH_LONG).show();
        }
    }
}
