package com.example.test_roshni;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAONewUserFeedback {
    private DatabaseReference databaseReference;
    public DAONewUserFeedback(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(NewUserFeedback.class.getSimpleName());

    }
    public Task<Void> add(NewUserFeedback u_fb){
        return databaseReference.push().setValue(u_fb);
    }

}
