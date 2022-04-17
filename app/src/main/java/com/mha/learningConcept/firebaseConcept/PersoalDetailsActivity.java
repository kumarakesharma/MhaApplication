package com.mha.learningConcept.firebaseConcept;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mha.learningConcept.R;
import com.mha.learningConcept.databinding.ActivityPersoalDetailsBinding;
import com.mha.learningConcept.databinding.LayoutAddBinding;
import com.mha.learningConcept.db.LandingActivity;

import java.util.HashMap;
import java.util.Map;

public class PersoalDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseDb firebaseDb;
    private ActivityPersoalDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPersoalDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseDb = new FirebaseDb();

        binding.btnAdd.setOnClickListener(this);

        Map<String, Object>  map = new HashMap<>();
        map.put("firstName", "Rakesh");
        map.put("lastName", "Kumar");
        map.put("mobileNo", "1231231231");

        firebaseDb.update("-N-arYtqrpzD3TaNvxs", map).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(PersoalDetailsActivity.this, "Updated...", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(PersoalDetailsActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

//        firebaseDb.remove("-N-arMFFeJg6KMFXCo4I").addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void unused) {
//                Toast.makeText(PersoalDetailsActivity.this,  "deleted Successfully", Toast.LENGTH_SHORT).show();
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(PersoalDetailsActivity.this,  e.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });

//        firebaseDb.get().addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
//                    PersonDetails personDetails = dataSnapshot.getValue(PersonDetails.class);
//                    personDetails.setKey(dataSnapshot.getKey());
//
//                    Log.d("DATA", personDetails.getFirstName()+" "+personDetails.getLastName());
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        LayoutAddBinding bindingAdd = LayoutAddBinding.inflate(getLayoutInflater());
        Dialog dialog = new Dialog(PersoalDetailsActivity.this);
        dialog.setContentView(bindingAdd.getRoot());
        dialog.setCancelable(false);
        dialog.show();

        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        bindingAdd.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PersonDetails personDetails = new PersonDetails(bindingAdd.tvFname.getEditText().getText().toString(),
                        bindingAdd.tvLname.getEditText().getText().toString(), bindingAdd.tvMobNo.getEditText().getText().toString());
                firebaseDb.add(personDetails).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(PersoalDetailsActivity.this, unused.toString(), Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(PersoalDetailsActivity.this,  e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}