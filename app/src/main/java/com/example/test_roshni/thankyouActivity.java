package com.example.test_roshni;

import static java.lang.Math.round;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.util.Map;

public class thankyouActivity extends AppCompatActivity {
    private DatabaseReference avgdb;
    float rateavg;
    private TextView total_avg_rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);
        Button btn_homepage, btn_k_web, btn_k_topgg, btn_k_git;
        total_avg_rating = findViewById(R.id.txt_avg_rate);
        avgdb = FirebaseDatabase.getInstance().getReference().child("NewUserFeedback");
        avgdb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int sum = 0;
                int count=0;
                for(DataSnapshot ds : snapshot.getChildren()){
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object rate = map.get("u_rate");
                    int rValue = Integer.parseInt(String.valueOf(rate));
                    sum += rValue;
                    count++;

                }
                DecimalFormat df = new DecimalFormat("#.##");
                rateavg = (float)sum/count;
                total_avg_rating.setText(String.valueOf(df.format(rateavg)));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

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
                Toast.makeText(thankyouActivity.this, "Opening GitHub Repository.", Toast.LENGTH_SHORT).show();
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