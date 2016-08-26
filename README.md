
<h1>JmailProject</h1>

<h2>What is this project:</h2>
<ul>
	<li>JmailProject is an Email Server/Client project implemented in JAVA using socket streams.<br>
	<li>It was a homework for my University during Web Networks lesson.
	<li>It contains:
		<ul>
			<li>an Email Server program</li>
			<li>and an Email Client program</li>
		</ul>
	<li>It has a nice interface fully created by me.<br>
	<i>I was learning both photoshop when I did this,
	I hope you like the design and the Code.</i>
	
	<li>Read complete <b>Help</b> category in order you can run it with no problems.<br> 
	<li>There is a pdf file which explains the classes in Greek<br>
	maybe I'll make one in English someday but the project have a javadoc in English.<br>
</ul>

<h3>Help</h3>	
<ol>
<li><b>Info:</b>
	<br>
	JAVADOC can open by by double clicking an html file (e.g. index.html)<br>
	from the "javadoc" folder in the "dist" folder<br>
	_javaMailData is the folder with all the data of the email Server<br>
	<br>
	<b>Running:</b><br>
		<ol>
		<li><b>if you use Netbeans IDE and import the program will run correctly </b><br>
			when you have the "_javaMailData" folder in the"JmailProject_SERVER" folder<br>
		<li><b>if you run the "JmailProject_SERVER.jar" from the "dist" folder the program will run correctly</b><br>
			when you have "_javaMailData" folder in the "dist" folder<br>
		<li><b>if you run the "JmailProject_SERVER.jar" a random folder the program will run correctly</b><br>
			when you have "_javaMailData" and "lib"(this is in the dist folder) folders in the same <br>
			location as the "JmailProject_SERVER.jar"<br>
		</ol>	
	<br>
	You can always change the <br>
	"static String urLoc = "C:/";"  to something you like <br>
	in the JmailHelper class in order to have no problems<br>
	<br>
	Program runs without cmd but if you want to see the messages(*) of the server and client<br>
	<br>
	(*)By messages mean the prints of the functions that uses sockets<br>
<li><b>EXISTING ACCOUNTS ARE:</b><br>
<table>
  <tr>
    <th></th>
    <th>1</th>
    <th>2</th>
    <th>3</th>
  </tr>
  <tr>
    <th>username:</th>
    <td>qwe</td>
    <td>asd</td>
    <td>zxc</td>
  </tr>
  <tr>
    <th>password:</th>
    <td>qwe</td>
    <td>asd</td>
    <td>zxc</td>
  </tr>
</table>
<li><b>How to run at cmd.exe</b><br>
MAKE SURE _javaMailData folder, lib folder, and JmailProject_SERVER.jar ARE IN THE SAME LOCATION<br>
the format is:	java -jar ""<br>
e.g.<br>
java -jar " your path \JmailProject_CLIENT\dist\JmailProject_CLIENT.jar"<br>
java -jar " your path \JmailProject_SERVER\dist\JmailProject_SERVER.jar"<br>
<li><b>You can create account</b><br>
You can login in one of the already existings accounts<br>
You can find the already existings accounts from the loginData.txt<br>
the format is:<br>
<i>true::::from::::to::::subject::::main message</i><br>
<li><b>About the password field</b><br>
Password field is kind of buggy becouse I didnt knew Netbeans <br>
had its own JpasswordField and I create one my way... :/<br>
so if you have a problem with it check loginData.txt and correct my passwordfield mistake<br>
<li><b>HAVE FUN ,     <i>vamartid</i></b><br>
</ol>

<h3>License</h3>
<ul>
	<li>Copyright © 2000 Vasileios Martidis vamartid@yandex.com
	This work is free. You can redistribute it and/or modify it under the
	terms of the Do What The Fuck You Want To Public License, Version 2,
	as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
</ul>

<h3>Image's of the 2 programs</h3>
<ul>
<li>SERVER's windows
<ul>
<li>Server insert port window<br>
<img src="http://imgur.com/iTezxC1.png" alt="Server insert port window">
<li>Server running window<br>
<img src="http://imgur.com/qc8maZJ.png" alt="Server running window">
</ul>
<li>CLIENT's windows
<ul>
<li>Client's insert ip and port window<br>
<img src="http://imgur.com/DnUP9Gz.png" alt="Client's insert ip and port window">
<li>Client's menu window<br>
<img src="http://imgur.com/BE5yYRg.png" alt="Client's menu window">
<li>Client's login window<br>
<img src="http://imgur.com/EUxI5mw.png" alt="Client's login window">
<li>Client's register window<br>
<img src="http://imgur.com/O2NHd3A.png" alt="Client's register window">
<li>Client's window<br>
<img src="http://imgur.com/rrF2G44.png" alt="Client's window">
<li>Client's window help overlay<br>
<img src="http://imgur.com/rZpKsgU.png" alt="Client's window help overlay">
<li>Client's new message window<br>
<img src="http://imgur.com/C2QUdzr.png" alt="Client's new message window">
</ul>
</ul>
