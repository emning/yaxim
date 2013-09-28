package org.yaxim.androidclient.service;

import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.util.Log;

public class YaximScreenReceiver extends BroadcastReceiver {

	static final String TAG = "YaximScreenReceiver";
    	private boolean screenOff;

	@Override
	public void onReceive(Context context, Intent intent) {

		if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
			screenOff = true;
		} else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
			screenOff = false;
		}

		Log.d(TAG, "screenOff: " + String.valueOf(screenOff));

		Intent i = new Intent(context, XMPPService.class);
		i.putExtra("screen_state", screenOff);
		context.startService(i);
	}
}
