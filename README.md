
cordova-android-notification-pref
------------------------

Simple function for Android only that allows you to deep link to the Notifications Setting in the App Info for devices running Android O (8.0) or hgher.

`cordova plugin add https://github.com/gregavola/cordova-android-notification-pref`


```
NotificationPref.openSettings(
  result => {
    console.log(result);
  },
  err => {
    console.error(err);
  }
);
```