package com.lasalle.midterm.restaurants;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Models.Restaurants;

public class MainActivity extends AppCompatActivity implements ValueEventListener, ChildEventListener {
    DatabaseReference restaurants;
    List<String> restaurantsList;
    ArrayAdapter<String> restaurantAdapter;
    ListView lvRestaurants;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        lvRestaurants = findViewById(R.id.lvRestaurants);
        restaurants = FirebaseDatabase.getInstance().getReference("restaurants");
        restaurantsList = new ArrayList<>();
        restaurantAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,restaurantsList);
        readAllData();




    }

    private void readAllData() {
        restaurants.addChildEventListener(this);

    }

    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
        if(snapshot.exists()){

        }

    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }

    @Override
    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
        // first way of getting data from the snapshot; ---> DataSnapshot

        Restaurants restaurant = snapshot.getValue(Restaurants.class);
        restaurantsList.add(restaurant.toString());
        lvRestaurants.setAdapter(restaurantAdapter);


//        Toast.makeText(this, restaurant.toString(), Toast.LENGTH_SHORT).show();
        Log.d("FIREBASE", restaurant.toString());
    }

    @Override
    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

    }

    @Override
    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

    }

    @Override
    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

    }


}