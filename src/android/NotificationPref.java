package com.cordova.plugins.NotificationPref;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;

import android.content.Intent;
import android.app.Activity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NotificationPref extends CordovaPlugin {
	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);
		// Plugin specific one off initialization code here, this one doesn't
		// have any
	}

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		// Which method was called? With many methods in a
		// plugin we could do this another way e.g. reflection
		if ("openSettings".equals(action)) {
			openNotifications(callbackContext);
			return true;
		}

		// No action matched
		return false;
	}


	private void openNotifications(CallbackContext callbackContext) {

		Intent intent = new Intent();
		intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");

		//for Android 5-7
		intent.putExtra("app_package", getPackageName());
		intent.putExtra("app_uid", getApplicationInfo().uid);

		// for Android O
		intent.putExtra("android.provider.extra.APP_PACKAGE", getPackageName());

		startActivity(intent);

		callbackContext.success("true");
	}
}