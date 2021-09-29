package com.example.test_roshni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class thankyouActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);
        Button btn_homepage;
        btn_homepage = findViewById(R.id.btn_homepage);
        btn_homepage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent3 = new Intent(thankyouActivity.this, MainActivity.class);
                    startActivity(intent3);

            }
        });
    }
}