package com.example.test_roshni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class FeedbackFormActivity extends AppCompatActivity {
    Button btn_submit1;
    EditText usernametext, userphonetext, useremailtext;
    public String user_name, user_phone, user_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_form);

        btn_submit1 = findViewById(R.id.btn_submit1);
        usernametext = findViewById(R.id.user_name1);
        userphonetext = findViewById(R.id.user_phone1);
        useremailtext = findViewById(R.id.user_email1);

        btn_submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                success = false;
                user_name = String.valueOf(usernametext.getText());
                user_phone = String.valueOf(userphonetext.getText());
                user_email = String.valueOf(useremailtext.getText());


                if (user_name.length() != 0 && isValid(user_email, user_phone))
                {
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

