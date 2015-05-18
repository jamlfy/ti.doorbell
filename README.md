# ti.doorbell

Simply run `titanium build --platform <name of platform> --build-type production --dir /path/to/module`.
You can omit the --dir option if your working directory is in the module's project directory.


INSTALL YOUR MODULE
-------------------

Mac OS X
--------
Copy the distribution zip file into the `~/Library/Application Support/Titanium` folder

Linux
-----
Copy the distribution zip file into the `~/.titanium` folder

Windows
-------
Copy the distribution zip file into the `C:\ProgramData\Titanium` folder


REGISTER YOUR MODULE
--------------------

Register your module with your application by editing `tiapp.xml` and adding your module.
Example:

<modules>
	<module version="0.1">ti.doorbell</module>
</modules>

When you run your project, the compiler will combine your module along with its dependencies
and assets into the application.


USING YOUR MODULE IN CODE
-------------------------

To use your module in code, you will need to require it.

For example,

	var doorbell = require('ti.doorbell');
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


TESTING YOUR MODULE
-------------------

To test with the script, execute:

	titanium run --dir=doorbell

This will execute the app.js in the example folder as a Titanium application.