package com.mha.learningConcept.firebaseConcept;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.Map;

public class FirebaseDb {

    private DatabaseReference databaseReference;

    public FirebaseDb(){
         databaseReference = FirebaseDatabase.getInstance().getReference(PersonDetails.class.getSimpleName());
    }

    Task<Void> add(PersonDetails personDetails){
        return databaseReference.push().setValue(personDetails);
    }


    //-N-arMFFeJg6KMFXCo4I
    Query get(){
        return databaseReference;
    }

    Task<Void> remove(String key){
        return databaseReference.child(key).removeValue();
    }

    Task<Void> update(String key, Map<String, Object> data){
        return databaseReference.child(key).updateChildren(data);
    }
}
