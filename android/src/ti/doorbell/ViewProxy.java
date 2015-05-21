/**
 * Copyright (c) 2011 by AlejoNext. All Rights Reserved.
 * Author: Alejo Next alejonext@gmail
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

package ti.doorbell;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiContext.OnLifecycleEvent;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.titanium.view.TiUIView;

import android.app.Activity;

@Kroll.proxy(creatableInModule=DoorbellModule.class)
public class ViewProxy extends TiViewProxy implements OnLifecycleEvent {
	private View doorbell;
	private static final String TAG = "doorbellViewProxy";

	public ViewProxy() {
		super();
	}

	@Override
	protected KrollDict getLangConversionTable() {
		KrollDict table = new KrollDict();
		table.put("title", "titleid");
		return table;
	}

	@Override
	public TiUIView createView(Activity activity) {
		doorbell = new View(this);
		return doorbell;
	}

	@Kroll.method
	public void show() {
		Log.d(TAG, "requestAd()");
		doorbell.show();
	}
	
	@Kroll.method
	public void addProperty(String prop, Boolean data)
	{
		Log.d(TAG, "addProperty");
		doorbell.addProperty(prop, data);
	}
	
	@Kroll.method
	public void addProperty(String prop, String data)
	{
		Log.d(TAG, "addProperty");
		doorbell.addProperty(prop, data);
	}
	
	@Kroll.method
	public void addProperty(String prop, Number data)
	{
		Log.d(TAG, "addProperty");
		doorbell.addProperty(prop, data);
	}

	@Kroll.method
	public void addProperty(String prop, Double data)
	{
		Log.d(TAG, "addProperty");
		doorbell.addProperty(prop, data);
	}

}
