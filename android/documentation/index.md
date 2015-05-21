# Doorbell Module

## Accessing the Doorbell Module

To access this module from JavaScript, you would do the following:

    var doorbell = require("ti.doorbell");

The doorbell variable is a reference to the Module object.

## Usage

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
	dd.show();
