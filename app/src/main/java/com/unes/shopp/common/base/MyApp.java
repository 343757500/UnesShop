package com.unes.shopp.common.base;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import org.greenrobot.eventbus.EventBus;


/**
 * 应用程序上下文对象，常作一些初始化操作
 *
 * @author WJQ
 */
public class MyApp extends Application {


	@Override
	public void onCreate() {
		super.onCreate();
		Global.init(this);
		initLeakCanary();
	}


	private void initLeakCanary() {
		if (LeakCanary.isInAnalyzerProcess(this)) {
			return;
		}
		LeakCanary.install(this);
	}
}
