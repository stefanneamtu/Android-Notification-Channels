package com.example.notificationchannels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.notificationchannels.BaseApplication.CHANNEL_ID_1;
import static com.example.notificationchannels.BaseApplication.CHANNEL_ID_2;
import static com.example.notificationchannels.BaseApplication.VIBRATION_PATTERN;

public class MainActivity extends AppCompatActivity {

  private NotificationManagerCompat notificationManager;
  private EditText editTextTitle;
  private EditText editTextMessage;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    notificationManager = NotificationManagerCompat.from(this);

    editTextTitle = findViewById(R.id.edit_text_title);
    editTextMessage = findViewById(R.id.edit_text_message);
  }

  public void sendOnChannel1(View v) {
    Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID_1)
        .setSmallIcon(R.drawable.ic_one)
        .setContentTitle(editTextTitle.getText().toString())
        .setContentText(editTextMessage.getText().toString())
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
        .setVibrate(VIBRATION_PATTERN)
        .build();

    notificationManager.notify(1, notification);
  }

  public void sendOnChannel2(View v) {
    Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID_2)
        .setSmallIcon(R.drawable.ic_two)
        .setContentTitle(editTextTitle.getText().toString())
        .setContentText(editTextMessage.getText().toString())
        .setPriority(NotificationCompat.PRIORITY_LOW)
        .build();

    notificationManager.notify(2, notification);
  }
}