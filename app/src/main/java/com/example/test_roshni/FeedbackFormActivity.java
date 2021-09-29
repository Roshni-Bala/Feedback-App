package com.example.test_roshni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static com.example.test_roshni.MainActivity.pass;
import static com.example.test_roshni.MainActivity.url;
import static com.example.test_roshni.MainActivity.user;


public class FeedbackFormActivity extends AppCompatActivity{
    Button btn_submit1;
    EditText usernametext, userphonetext, useremailtext;
    public String user_name, user_phone, user_email;
    public boolean success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_form);

        btn_submit1 = findViewById(R.id.btn_submit1);
        usernametext = findViewById(R.id.user_name1);
        userphonetext = findViewById(R.id.user_phone1);
        useremailtext = findViewById(R.id.user_email1);

        btn_submit1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                success = false;
                user_name = String.valueOf(usernametext.getText());
                user_phone = String.valueOf(userphonetext.getText());
                user_email = String.valueOf(useremailtext.getText());
//                ConnectMySql connectMySql_db = new ConnectMySql();
//                connectMySql_db.execute("");
                if(usernametext!=null){
                    Intent intent2 = new Intent(FeedbackFormActivity.this, enterfb.class);
                    startActivity(intent2);
                }
                else{
                    Toast.makeText(FeedbackFormActivity.this, "Please fill in the details.", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
    private class ConnectMySql extends AsyncTask<String, Void, String> {
        String res = "";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(FeedbackFormActivity.this, "Please wait...", Toast.LENGTH_SHORT).show();

        }

        @Override
        protected String doInBackground(String... params) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pass);
                System.out.println("Databaseection success");

                String result = "Database Connection Successful\n";
                Statement st = con.createStatement();
                int rs = st.executeUpdate("INSERT INTO `feedbacktable`(`name`, `email`, `phone`) VALUES('"+user_name+"','"+user_email+"','"+user_phone+"');");

                res = result;
            } catch (Exception e) {
                e.printStackTrace();
                res = e.toString();
            }
            return res;
        }

        @Override
        protected void onPostExecute(String result) {
            if(success){
                Toast.makeText(FeedbackFormActivity.this, "Submitted.", Toast.LENGTH_SHORT).show();

            }
        }
    }
}
