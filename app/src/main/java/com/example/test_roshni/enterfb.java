package com.example.test_roshni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class enterfb extends AppCompatActivity {
    Button btn_finSubmit;
    EditText inptxt_feedback;
    String user_feedback;
    int user_rate;
    SeekBar seekbar_rate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterfb);


        btn_finSubmit = findViewById(R.id.btn_finSubmit);
        inptxt_feedback = findViewById(R.id.inptxt_feedback);
        seekbar_rate= findViewById(R.id.seekbar_rate); // initiate the Seek bar




        btn_finSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                user_feedback = String.valueOf(inptxt_feedback.getText());
                user_rate= seekbar_rate.getProgress();
                if (user_feedback.length() != 0) {
                    Intent intent4 = new Intent(enterfb.this, thankyouActivity.class);
                    startActivity(intent4);
                }else{
                    Toast.makeText(enterfb.this, "Please enter above fields.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}