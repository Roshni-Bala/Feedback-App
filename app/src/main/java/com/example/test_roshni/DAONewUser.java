package com.example.test_roshni;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAONewUser {
    private DatabaseReference databaseReference;
    public DAONewUser(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(NewUser.class.getSimpleName());
    }
    public Task<Void> add(NewUser new_user){
        return databaseReference.push().setValue(new_user);
    }
}
