package com.example.test_roshni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class thankyouActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);
        Button btn_homepage, btn_k_web, btn_k_topgg, btn_k_git;
        btn_homepage = findViewById(R.id.btn_homepage);
        btn_k_web = findViewById(R.id.btn_k_web);
        btn_k_topgg = findViewById(R.id.btn_k_topgg);
        btn_k_git = findViewById(R.id.btn_k_git);
        btn_homepage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent3 = new Intent(thankyouActivity.this, MainActivity.class);
                    startActivity(intent3);

            }
        });
        btn_k_web.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(thankyouActivity.this, "Opening Kanmani's Website.", Toast.LENGTH_SHORT).show();
                GoToURL("https://abhinand-and-roshni.github.io/Kanmani-Discord-Bot/");
            }
        });
        btn_k_topgg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(thankyouActivity.this, "Opening Kanmani's profile on Top.gg.", Toast.LENGTH_SHORT).show();
                GoToURL("https://top.gg/bot/855000784098164786");
            }
        });
        btn_k_git.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(thankyouActivity.this, "Opening Support Server on Discord.", Toast.LENGTH_SHORT).show();
                GoToURL("https://github.com/Abhinand-and-Roshni/Kanmani-Discord-Bot");
            }
        });
    }
    void GoToURL(String url){
        Uri uri = Uri.parse(url);
        Intent intent= new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
}