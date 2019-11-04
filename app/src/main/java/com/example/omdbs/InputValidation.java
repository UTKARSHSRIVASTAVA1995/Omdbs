package com.example.omdbs;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;



public class InputValidation {
    private Context context;

    public InputValidation(Context context) {
        this.context = context;
    }

   public boolean isInputEditTextFilled(TextInputLayoutEmail textInputLayoutEmail,)























    private void hideKeyboardFrom(View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}

