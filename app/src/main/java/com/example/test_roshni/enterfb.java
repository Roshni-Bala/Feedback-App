package com.example.test_roshni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class enterfb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterfb);

        Button btn_finSubmit;
        btn_finSubmit = findViewById(R.id.btn_finSubmit);
        btn_finSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent4 = new Intent(enterfb.this, thankyouActivity.class);
                startActivity(intent4);
            }
        });
    }
}