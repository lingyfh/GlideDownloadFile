package com.lingyfh.glidedownload;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	private static final String tag = "MainActivity";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		metaData();
	}

	private void metaData() {
		try {
			ApplicationInfo appInfo = this.getPackageManager()
					.getApplicationInfo(this.getPackageName(), PackageManager.GET_META_DATA);
			Log.i(tag, "appInfo.metaData = " + appInfo.metaData);
			if (appInfo.metaData != null) {
				for (String key : appInfo.metaData.keySet()) {
					Log.i(tag, "meta data key = " + key);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
