package com.example.test_roshni;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
//    public static final String url = "jdbc:mysql://127.0.0.1:3306/feedbackdb";
//    public static final String user = "root";
//    public static final String pass = "";

    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CHECK BOX FOR TERMS AND CONDITIONS
        CheckedTextView checkedTextView = findViewById(R.id.checkedTV_termsAndCond);
        checkedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkedTextView.toggle();
                if(checkedTextView.isChecked()){
                    Toast.makeText(MainActivity.this, "You may proceed.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Check the box to proceed.", Toast.LENGTH_SHORT).show();
                }

            }
        });
        button = (Button) findViewById(R.id.btn_startbtn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, FeedbackFormActivity.class);
                if(checkedTextView.isChecked())
                    startActivity(intent);
                else
                    Toast.makeText(MainActivity.this, "Please check the box to continue.", Toast.LENGTH_SHORT).show();
            }
        });



    }
}