package com.example.test_roshni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class FeedbackFormActivity extends AppCompatActivity {
    Button btn_submit1;
    EditText usernametext, userphonetext, useremailtext;
    public String user_name;
    public String user_phone;
    public static String user_email;
    public String user_dept;
    public String user_yr;
    int user_year_id;
    Spinner spinner_department;
    RadioGroup rad_year;
    RadioButton user_rad_year;
    CharSequence user_year_select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_form);

        btn_submit1 = findViewById(R.id.btn_submit1);
        usernametext = findViewById(R.id.user_name1);
        userphonetext = findViewById(R.id.user_phone1);
        useremailtext = findViewById(R.id.user_email1);
        spinner_department = findViewById(R.id.spinner_department);

        rad_year = findViewById(R.id.rad_year); //radiogrp ID
        DAONewUser dao = new DAONewUser();

        btn_submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_name = String.valueOf(usernametext.getText());
                user_phone = String.valueOf(userphonetext.getText());
                user_email = String.valueOf(useremailtext.getText());
                user_dept = String.valueOf(spinner_department.getSelectedItem());

                user_year_id = rad_year.getCheckedRadioButtonId();//selected radio button by user ID
                user_rad_year = (RadioButton) findViewById(user_year_id); //getting the checked rad button from grp ID
                user_year_select = user_rad_year.getText(); //text of selected radio button
                user_yr = user_year_select.toString();


                    if (user_name.length() != 0 && isValid(user_email, user_phone))
                    {
                        NewUser new_user = new NewUser(user_name, user_email, user_phone, user_yr , user_dept);
                        dao.add(new_user).addOnSuccessListener(suc->{
                                    Toast.makeText(FeedbackFormActivity.this, "Successful.", Toast.LENGTH_SHORT).show();
                                }
                                ).addOnFailureListener(er->{
                            Toast.makeText(FeedbackFormActivity.this, "Try again.", Toast.LENGTH_SHORT).show();
                        });
                            Intent intent2 = new Intent(FeedbackFormActivity.this, enterfb.class);
                            Toast.makeText(FeedbackFormActivity.this, "Welcome, " + user_name + "!", Toast.LENGTH_SHORT).show();
                            startActivity(intent2);
                    }
                    else{
                        Toast.makeText(FeedbackFormActivity.this, "Please enter valid details.", Toast.LENGTH_SHORT).show();
                    }

            }
        });

    }
    //validate email and phone number entered by user
    public static boolean isValid(CharSequence user_email, CharSequence user_phone) {
        return (!TextUtils.isEmpty(user_email) && Patterns.EMAIL_ADDRESS.matcher(user_email).matches() && user_phone.length() == 10 );
    }

}

