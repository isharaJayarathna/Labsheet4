package com.aie.lab4;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.os.Build.ID;

public class MainActivity extends AppCompatActivity {

       Button sing;
        EditText value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     sing = findViewById(R.id.button);

     sing.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             value = (EditText)findViewById(R.id.name);
             String name = value.getText().toString();

             Intent intent = new Intent(MainActivity.this, Main2Activity.class);
             intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
             NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL ID)
                     .setSmallIcon(R.drawable.ic_launcher_background)
                     .setContentTitle("cLICK ON THIS REGISTER")
                     .setContentText("Hello" + name + "! Welcome to the MAD team")
                     .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                     .setContentIntent(pendingIntent)
                     .setAutoCancel(true);

             NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
             notificationManager.notify(0, builder());



         }
     });






    }
}
