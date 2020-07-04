package com.example.notificationchannels;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class BaseApplication extends Application {

  public static final String CHANNEL_ID_1 = "channel1";
  public static final String CHANNEL_ID_2 = "channel2";

  public static final long[] VIBRATION_PATTERN = {100, 400, 250, 350, 1000};

  @Override
  public void onCreate() {
    super.onCreate();

    initNotificationChannels();
  }

  void initNotificationChannels() {
    // make sure the least version is android oreo
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

      // initialise the channels
      NotificationChannel channel1 = new NotificationChannel(
          CHANNEL_ID_1,
          "Channel1",
          NotificationManager.IMPORTANCE_HIGH
      );
      channel1.setVibrationPattern(VIBRATION_PATTERN);
      channel1.setDescription("This is channel 1");

      NotificationChannel channel2 = new NotificationChannel(
          CHANNEL_ID_2,
          "Channel2",
          NotificationManager.IMPORTANCE_LOW
      );
      channel2.setDescription("This is channel 2");

      // create the notification manager
      NotificationManager manager = getSystemService(NotificationManager.class);

      // create the channels
      try {
        manager.createNotificationChannel(channel1);
        manager.createNotificationChannel(channel2);
      } catch(NullPointerException exception) {
        System.err.println("Error: notification manager is NULL");
      }
    }
  }
}
