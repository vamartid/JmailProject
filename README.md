License
Copyright © 2000 Vasileios Martidis vamartid@yandex.com
This work is free. You can redistribute it and/or modify it under the
terms of the Do What The Fuck You Want To Public License, Version 2,
as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.

	# JmailProject
	JmailProject 
	Is an Email Server Client project implemented in JAVA using socket streams.
	It was a homework for my University during Web Networks lesson.
	It contains an Email Server program and an Email Client program, it has a nice interface fully created by me.
	I was learning both photoshop when I did this :), I hope you like the design and the Code.
	Read complete README in order you can run it with no problems.
	There is a pdf file which explains the classes in Greek (maybe I make one in English someday) also the project have
	a javadoc in English.
	
SERVER![alt tag](https://github.com/vamartid/JmailProject/blob/master/JmailProject_SERVER/src/vamartid/test1/images/server3.png)CLIENT![alt tag](https://raw.githubusercontent.com/vamartid/JmailProject/master/JmailProject_CLIENT/src/vamartid/test1/images/login.png)![alt tag](https://github.com/vamartid/JmailProject/blob/master/JmailProject_CLIENT/src/vamartid/test1/images/help.png)

	***IMPORTANT***
	//Final Version//
	//ReadMe Ver.1.0//
	1)	Frist of all
	Info:
	>>JAVADOC CAN BE OPEND BY DOUBLE CLICKING AN HTML FILE (E.G. index.html)  FROM THE "javadoc" FOLDER IN "dist" FOLDER
	>> _javaMailData is the folder with all the data of the email Server
	Running:
		1>>if you use Netbeans IDE and import the program will run correctly 
			when you have the "_javaMailData" folder in the"JmailProject_SERVER" folder
		2>>if you run the "JmailProject_SERVER.jar" from the "dist" folder the program will run correctly
			when you have "_javaMailData" folder in the "dist" folder
		3>>if you run the "JmailProject_SERVER.jar" a random folder the program will run correctly
			when you have "_javaMailData" and "lib"(this is in the dist folder) folders in the same 
			location as the "JmailProject_SERVER.jar"
	//You can always change the "static String urLoc = "C:/";"  to something you like 
	//in the JmailHelper class in order to have no problems
	//Program runs without cmd but if you want to see the messages(*) of the server and client
	//(*)By messages mean the prints of the functions that uses sockets
	
	1.1) EXISTING ACCOUNTS ARE 
						1		2		3
			username:	qwe		asd		zxc
			password:	qwe		asd		zxc
		
	2)	How to run at cmd.exe
		***   MAKE SURE _javaMailData folder,
		***						  lib folder,
		***	   	  and JmailProject_SERVER.jar ARE IN THE SAME LOCATION
			   
		the format is:	java -jar ""
		e.g.
		java -jar " your path \JmailProject_CLIENT\dist\JmailProject_CLIENT.jar"
		java -jar " your path \JmailProject_SERVER\dist\JmailProject_SERVER.jar"
	
	3)	You can create account
		You can login in one of the already existings accounts
		You can find the already existings accounts from the loginData.txt
		the format is istrue::::from::::to::::subject::::main message
	
	4)	The password field is kind of buggy becouse i didnt knew Netbeans had its own JpasswordField
		and i create one my way... :/
		so if you have a problem with it check loginData.txt and correct my passwordfield mistake
	
	5)	HAVE FUN :)
	
	//Vasileios Martidis
	//vamartid
