package com.unes.shopp.common.base;

import android.app.Application;



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
	}


}
