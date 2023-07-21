
<h1 align="center" id="title">Contact Tracing for Contagious Diseases</h1>


 <h2 align="center" id="title">About Project</h2>
                                                       

A contact tracing system which maintains a record of the people you have come into physical contact with. Each person represents a node in the graph. The Edges of the graph shows the relationship between the contatcs. It categorizes zones into red, yellow or green based on the number of postive patients in a particular pincode. <br><br>

<b>Drive Link to reports:</b> https://drive.google.com/drive/folders/1PsBnx2qPT49jtdomOmn9jeuzhYxog5o_?usp=sharing<br>
<b>Canva Link to PPT: https://www.canva.com/design/DAFhdzPKwjc/6_G3pVzcBbHzFAmKOHWB5Q/watch?utm_content=DAFhdzPKwjc&utm_campaign=designshare&utm_medium=link&utm_source=publishsharelink</b><br>

<b>Backend Video Demonstration link: https://drive.google.com/file/d/1bw02LNpLfvnXhy0_rBAZztDH3qylsMB0/view?usp=sharing</b> <br>
<b>Frontend Video Demonsatration link: https://drive.google.com/file/d/13MmQUjGn9Nql4x_YV6v6m7tSGqWYhwlM/view?usp=sharing</b><br><br>

<h2 align="center" id="title">Brief Explanation of code files</h2>
<h3><b>Backend:</h3></b>
	<ol>
	<li><h4><b>corona.java</b></h4></li>
		<p>Contains main java code that includes:
			<ul>
				<li>Creates graph of contacted patients</li>
				<li>Adds patients</li>
				<li>Displays graph</li>
				<li>Adding patient data to MySQL database</li>
				<li>Updates patient status(ie positive or not)</li>
				<li>Sends mails to contacted people</li>
				<li> Categorizes pincodes into red, yellow or green zones</li>
				<li>Contains driver code(in class corona)</li>
		</ul></p>
		<li><b>connections.java</b></li><br>
		<p>Used to connect to the MySQL database</p>
		<li><b>login.java</b></li><br>
		<p>Used in the Websites login page.<br>
	           Ensures that login details entered by user are present in database. If yes then login is succesfull. If no then login fails</p>
		   </ol><br>
		   <h3><b>Frontend:</b></h3>
		   <ol>
	<li><b>about.jsp</b></li>
	<p>This is the about file. Contains HTML and CSS.<br>
		Explains to the user about how the website and the software works.</p>
	<li><b>admin.jsp</b></li>
	<p>Contains Functionality meant for administrator's use</p>
	<ul>
		<li>Patient anaylysis: Gives bar graph to show how many patients are infected, not infected and contacted</li>
		<li>Shows info about contacted patients</li>
		<li>Shows infected and not infected</li>
		<li>Google Maps: shows nearby hospitals and their details</li>
	</ul>
	<li><b>home.jsp</b></li>
	<p>Login page opens up</p>
	<li><b>bargraph.jsp</b></li>
	<p>Contains code to show bar graph of patients that are infected and not infected</p>
	<li><b>displaypositive.jsp</b></li>
	<p>Shows information of positive patients</p>
	<li><b>negative.jsp</b><li>
	<p>Shows information of negative patients</p>
	<li><b>patient.jsp</b></li>
	<p>Shows information of all patients</p>
	<li><b>user.jsp</b>
		<p>Shows functionality meant for user</p>
		<ul>
			<li>Bargraph: shows status of infected and non-infected people</li>
			<li>Google Maps: shows nearby hospitals and their details</li>
		</ul>
	</li>
	<li><b>mymap.jsp</b></li>
	<p>Uses google maps to show nearby hospitals</p>
	<li><b>loginfailed.jsp</b></li>
	<p>Page that appears when user enters wrong login credentials</p>
		
	
	
	
	
	
	
		
		
		
			
			


<h4><b>PLEASE NOTE: This project is modelled on Covid -19, hence you may seem the Covid-19 multiple times. However, this project can be generailzed to work with any other contagious disease.</b></h4>




	



