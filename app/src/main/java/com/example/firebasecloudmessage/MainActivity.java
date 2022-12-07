package com.example.firebasecloudmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        startService(new Intent(this, MessageService.class));
        setContentView(R.layout.activity_main);
        Log.i("Fonchi", "Token: " + FirebaseMessagingService.class);
        //retrieve the token

        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                Log.i("Fonchi", "Fetching FCM registration token failed", task.getException());
                return;
            }

            // Get new FCM registration token
            String token = task.getResult();

            // Log and toast
            Log.i("Fonchi", token);
            Toast.makeText(MainActivity.this, token, Toast.LENGTH_SHORT).show();
        });


    }
}