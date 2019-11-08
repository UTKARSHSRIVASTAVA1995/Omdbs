package com.example.omdbs;

import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = RegisterActivity.this;


    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutCreditCard;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private TextInputLayout textInputLayoutVerifyEmail;
    private TextInputEditText textInputEditTextName;
    private TextInputEditText textInputEditTextCreditCard;
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
        getSupportActionBar().hide();
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
        textInputLayoutCreditCard = findViewById(R.id.textInputLayoutCreditCard);
        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword);
        textInputLayoutVerifyEmail = findViewById(R.id.textInputLayoutVerifyEmail);
        textInputEditTextName = findViewById(R.id.textInputEditTextName);
        textInputEditTextCreditCard = findViewById(R.id.textInputEditTextCreditCard);
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
                Toast.makeText(RegisterActivity.this, "Registration SuccessFull", Toast.LENGTH_LONG).show();
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

        if (!inputValidation.isInputEditTextFilled(textInputEditTextCreditCard, textInputLayoutCreditCard, getString(R.string.error_message_credit_card))) {
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
            databaseHelper.addUser(user);
        } else {
        }
        if (!databaseHelper.checkUser1(textInputEditTextCreditCard.getText().toString().trim())) {
            user.setCreditCard(textInputEditTextCreditCard.getText().toString().trim());
            String value = textInputEditTextCreditCard.getText().toString().trim();
            Integer.parseInt(value);
            databaseHelper.addUser(user);
        } else {

        }
    }
}
