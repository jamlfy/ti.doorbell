/**
 * Copyright (c) 2011 by AlejoNext. All Rights Reserved.
 * Author: Alejo Next alejonext@gmail
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */
package ti.doorbell;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiUIView;

import android.os.Bundle;

import io.doorbell.android.Doorbell;

public class View extends TiUIView {
	private static final String TAG = "doorbellView";
	Doorbell doorbellDialog;

	public View(final TiViewProxy proxy) {
		super(proxy);
		Log.d(TAG, "Creating an doorbell ad view");
		// get the publisher id that was set in the module
		Log.d(TAG, "DoorbellModule.APIKEY: " + DoorbellModule.APIKEY);
		Log.d(TAG, "DoorbellModule.APPID: " + DoorbellModule.APPID);
	}

	private void createDialog() {
		Log.d(TAG, "createDialog()");
		// create the Dialog
		doorbellDialog = new Doorbell(this, DoorbellModule.APPID, DoorbellModule.APIKEY);
		if(DoorbellModule.EMAIL != null){
			doorbellDialog.setEmail(DoorbellModule.EMAIL);
		}
		if(DoorbellModule.NAME != null){
			doorbellDialog.setName(DoorbellModule.NAME);
		}
		if(DoorbellModule.TITLE != null){
			doorbellDialog.setTitle(DoorbellModule.TITLE);
		}
		if(DoorbellModule.EMAILHINT != null){
			doorbellDialog.setEmailHint(DoorbellModule.EMAILHINT);
		}
		if(DoorbellModule.MESSAGEHINT != null){
			doorbellDialog.setMessageHint(DoorbellModule.MESSAGEHINT);
		}
		if(DoorbellModule.POSITIVEBUTTONTEXT != null){
			doorbellDialog.setPositiveButtonText(DoorbellModule.POSITIVEBUTTONTEXT);
		}
		if(DoorbellModule.NEGATIVEBUTTONTEXT != null){
			doorbellDialog.setNegativeButtonText(DoorbellModule.NEGATIVEBUTTONTEXT);
		}
		if(DoorbellModule.HIDEEMAIL){
			doorbellDialog.setEmailVisibility(View.GONE); 
		}
		if(DoorbellModule.HIDEPOWEREDBY){
			doorbellDialog.setPoweredByVisibility(View.GONE);
		}
		// set the listener
		doorbellDialog.setOnShowCallback(new io.doorbell.android.callbacks.OnShowCallback() {
			@Override
			public void handle() {
				proxy.fireEvent(DoorbellModule.SHOW, new KrollDict());
			}
		});

		setNativeView(doorbellDialog);
	}

	@Override
	public void processProperties(KrollDict d) {
		super.processProperties(d);
		Log.d(TAG, "process properties");
		if (d.containsKey("apiKey")) {
			Log.d(TAG, "has apiKey: " + d.getString("apiKey"));
			DoorbellModule.APIKEY = d.getString("apiKey");
		}
		if (d.containsKey("appId")) {
			Log.d(TAG, "has appId: " + d.getString("appId"));
			DoorbellModule.APPID = d.getString("appId");
		}
		if (d.containsKey("testing")) {
			Log.d(TAG, "has testing param: " + d.getBoolean("testing"));
			DoorbellModule.TESTING = d.getBoolean("testing");
		}
		if (d.containsKey("hideEmail")) {
			Log.d(TAG, "has hideEmail: " + d.getBoolean("hideEmail"));
			DoorbellModule.HIDEEMAIL = d.getBoolean("hideEmail");
		}
		if (d.containsKey("hidePoweredBy")) {
			Log.d(TAG, "has hidePoweredBy: " + d.getBoolean("hidePoweredBy"));
			DoorbellModule.HIDEPOWEREDBY = d.getBoolean("hidePoweredBy");
		}
		if (d.containsKey("name")) {
			Log.d(TAG, "has name: " + d.getString("name"));
			DoorbellModule.NAME = d.getString("name");
		}
		if (d.containsKey("email")) {
			Log.d(TAG, "has email: " + d.getString("email"));
			DoorbellModule.EMAIL = d.getString("email");
		}
		if(d.containsKey("title") != null){
			Log.d(TAG, "has title: " + d.getString("title"));
			DoorbellModule.TITLE = d.getString("title");
		}
		if(d.containsKey("emailHint") != null){
			Log.d(TAG, "has emailHint: " + d.getString("emailHint"));
			DoorbellModule.EMAILHINT = d.getString("emailHint");
		}
		if(d.containsKey("messageHint") != null){
			Log.d(TAG, "has messageHint: " + d.getString("messageHint"));
			DoorbellModule.MESSAGEHINT = d.getString("messageHint");
		}
		if(d.containsKey("positiveButtonText") != null){
			Log.d(TAG, "has positiveButtonText: " + d.getString("positiveButtonText"));
			DoorbellModule.POSITIVEBUTTONTEXT = d.getString("positiveButtonText");
		}
		if(d.containsKey("negativeButtonText") != null){
			Log.d(TAG, "has negativeButtonText: " + d.getString("negativeButtonText"));
			DoorbellModule.NEGATIVEBUTTONTEXT = d.getString("negativeButtonText");
		}

		// now create the Dialog
		this.createDialog();
	}

	public void show()
	{
		Log.d(TAG, "show");
		doorbellDialog.show();
	}

	public void addProperty(String prop, Boolean data)
	{
		Log.d(TAG, "addProperty");
		doorbellDialog.addProperty(prop, data);
	}

	public void addProperty(String prop, String data)
	{
		Log.d(TAG, "addProperty");
		doorbellDialog.addProperty(prop, data);
	}

	public void addProperty(String prop, Number data)
	{
		Log.d(TAG, "addProperty");
		doorbellDialog.addProperty(prop, data);
	}

	public void addProperty(String prop, Double data)
	{
		Log.d(TAG, "addProperty");
		doorbellDialog.addProperty(prop, data);
	}
}