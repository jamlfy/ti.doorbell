// This is a test harness for your module
// You should do something interesting in this harness
// to test out the module and to provide instructions
// to users on how to use it by example.


// open a single window
var win = Ti.UI.createWindow({
	backgroundColor:'white'
});
var label = Ti.UI.createLabel();
win.add(label);
win.open();

// TODO: write your module tests here
var doorbell = require('ti.doorbell');
Ti.API.info("module is => " + doorbell);

label.text = doorbell.example();

Ti.API.info("module exampleProp is => " + doorbell.exampleProp);
doorbell.exampleProp = "This is a test value";

if (Ti.Platform.name == "android") {
	var ddialog = doorbell.createDialog({
		apiKey : '--API KEY--',
		appId : '-- APP ID --',
		// Optional
		email : 'alejonext@gmail.com',
		name : 'alejo next',
		testing : true
	});

	dd.addProperty("username", 'alejonext');
	dd.on('show', function(){
		console.log('Is show');
	});

	win.add(proxy);

	proxy.on('click', function (argument) {
		dd.show();
	});
}

