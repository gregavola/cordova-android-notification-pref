package cordova.plugins;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;

import android.content.Intent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NotificationPref extends CordovaPlugin {
	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);
	}

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
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
		intent.putExtra("app_package", cordova.getActivity().getPackageName());
		intent.putExtra("app_uid", cordova.getActivity().getApplicationInfo().uid);

		// for Android O
		intent.putExtra("android.provider.extra.APP_PACKAGE", cordova.getActivity().getPackageName());

		cordova.getActivity().startActivity(intent);

		callbackContext.success("true");
	}
}
