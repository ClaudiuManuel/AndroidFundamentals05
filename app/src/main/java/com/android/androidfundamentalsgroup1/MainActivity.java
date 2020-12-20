package com.android.androidfundamentalsgroup1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final String ANDROID_DOCS = "https://developer.android.com/";

    private TextView resultTextView;
    private EditText email;
    private EditText phone;
    private CheckBox checkBoxTermsAndConditions;
    private Button buttonGetContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // seteaza layout-ul asociat activatii MainActivity
        // setContentView(R.layout.activity_main);
        // asociem views_sample_1 ca layout al activitatii MainActivity
        setContentView(R.layout.login_view);
        findComponents();

    }

    private void findComponents() {
        email = findViewById(R.id.emailInput);
        phone = findViewById(R.id.phoneInput);
        checkBoxTermsAndConditions = findViewById(R.id.tAndCCheckbox);
        resultTextView = findViewById(R.id.resultTextView);
    }

    public void buttonGetContentOnClick(View view) {
        String resultString = "";
        boolean validForm = true;

        String emailInput = email.getText().toString();
        if (Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            resultString += "Email : " + emailInput + "\n";
        } else {
            email.setError("Please enter a valid email");
            validForm = false;
        }

        String phoneInput = phone.getText().toString();
        if(Patterns.PHONE.matcher(phoneInput).matches()){
            resultString += "Phone : " + emailInput + "\n";
        } else {
            phone.setError("Please enter a valid phone number");
            validForm = false;
        }

        if(!checkBoxTermsAndConditions.isChecked()) {
            validForm = false;
            checkBoxTermsAndConditions.setError("You need to accept the terms&conditions");
        } else {
            checkBoxTermsAndConditions.setError(null);
        }

        if(validForm){
            resultTextView.setText(resultString);
        } else {
            resultTextView.setText("Not yet submitted");
        }

        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(),0);

    }

}
