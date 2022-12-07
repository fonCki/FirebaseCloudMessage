package com.example.firebasecloudmessage;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MessageService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        // LOG data received
        Log.i("Fonchi", "message received: ");


        //Get the message data
        String title = message.getNotification().getTitle();
        String body = message.getNotification().getBody();
        String localizationKey = message.getNotification().getBodyLocalizationKey();
        Log.i("Fonchi", "title: " + localizationKey);



        //Create a notification channel
        final String CHANNEL_ID = "my_channel";
        final String CHANNEL_NAME = "My Channel";
        final String CHANNEL_DESC = "My Channel Description";

        NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT);

        getSystemService(NotificationManager.class).createNotificationChannel(channel);

        //Create a notification
        Notification.Builder builder = new Notification.Builder(this, CHANNEL_ID)
                    .setContentTitle("from inside the app" + title)
                    .setContentText("from inside the app" + body)
                    .setSmallIcon(R.drawable.ic_baseline_local_fire_department_24)
                    .setAutoCancel(true);

            //Display the notification
            getSystemService(NotificationManager.class).notify(1, builder.build());


        super.onMessageReceived(message);
    }

    @Override
    public void onNewToken(@NonNull String token) {
        Log.i("Fonchi", "Token1: " + token);
        super.onNewToken(token);

    }


    @Override
    public void onCreate() {
        //get the token
        Log.i("Fonchi", "Token2: " + FirebaseMessagingService.class);
        super.onCreate();
    }


}
