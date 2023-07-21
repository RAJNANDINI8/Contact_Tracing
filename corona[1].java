import java.io.IOException;

import javax.mail.Message;

import javax.mail.MessagingException;

import javax.mail.Session;

import javax.mail.Transport;

import javax.mail.internet.AddressException;

import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeBodyPart;

import javax.mail.internet.MimeMessage;

import javax.mail.internet.MimeMultipart;

import java.io.BufferedReader;

import java.io.File;

import java.io.FileWriter;

import java.io.InputStreamReader;

import java.util.*;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.io.*;

import java.lang.String;

class Edge1 extends ArrayList<Edge1> { // For Storing all information in node

	String source;

	int SID;

	int DID;

	String destination;

	int PINCODE;

	String condition;

	Edge1(String s, int i, String d, int j, int pincode, String condition) {

		this.source = s;

		this.SID = i;

		this.DID = j;

		this.destination = d;

		this.PINCODE = pincode;

		this.condition = condition;

	}

}

class EmailSending {
//For sending email
	Session newSession = null;

	String emailBody;

	MimeMessage mimeMessage = null;

	public void mail1(String Email) throws AddressException, MessagingException, IOException {
		EmailSending mail = new EmailSending();

		mail.setupServerProperties(); // Set the Server

		mail.draftEmail(Email);

		mail.sendEmail();

	}

	private void sendEmail() throws MessagingException {

		String fromUser = " Enter sender email id  projectwork11@gmail.com"; // Enter sender email id  

		String fromUserPassword = "project@1234"; // Enter sender gmail password , this will be authenticated by gmail  

		String emailHost = "smtp.gmail.com"; // Smtp Server use for sending email

		Transport transport = newSession.getTransport("smtp");

		transport.connect(emailHost, fromUser, fromUserPassword);

		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());

		transport.close();

		System.out.println("Email successfully sent to contacted persons!!!");// After Sending Successfully email

	}

	private MimeMessage draftEmail(String Email) throws AddressException, MessagingException, IOException {// Add Mime
																											// message

		String[] emailReceipients = new String[1];// Enter list of email recepients

		emailReceipients[0] = Email;

		String emailSubject = "Urgent Notice - Possible Exposure to Contagious Disease";

		mimeMessage = new MimeMessage(newSession);

		for (int i = 0; i < emailReceipients.length; i++) {

			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailReceipients[i]));

		}

		mimeMessage.setSubject(emailSubject);

		MimeBodyPart bodyPart = new MimeBodyPart();

//Content for email
		bodyPart.setContent("<h3>Greetings from CareConnect !</h3><br>" +

				"This email informs you that you have come into contact with an individual who <b>tested positive</b> for Covid-19.<br>"

				+

				"<br>On a precautionary note, you must monitor your health and practice <b>self-isolation</b>.<br>" +

				"<br>If symptoms like fever, cough, or shortness of breath develop over time please consult a <b>medical professional</b>.<br>"

				+

				"<br>It is strongly recommended that you follow all guidelines promptly.<br>"
				+ "<br>Please reply this mail by sending following details<br>" + "<br>1.Your name <br>"
				+ "<br>2.Your pincode<br>" + "<br>3.Send the details of  people you had contact with  <br>" +

				"<br>Feel free to contact us if you have questions or concerns.<br>" +

				"<br><br><h3><b>Stay home, Stay Safe!</b></h3>",

				"text/html");

		MimeMultipart multiPart = new MimeMultipart();

		multiPart.addBodyPart(bodyPart);

		mimeMessage.setContent(multiPart);

		return mimeMessage;

	}

	private void setupServerProperties() {
		// Set the Server
		Properties properties = System.getProperties();

		properties.put("mail.smtp.port", "587");// Port

		properties.put("mail.smtp.auth", "true");

		properties.put("mail.smtp.starttls.enable", "true");

		newSession = Session.getDefaultInstance(properties, null);

	}
}

class OperationGraph1 {

	static final String DB_URL = "jdbc:mysql://localhost/corona"; // Set the dbms connections

	static final String USER = "root";

	static final String PASS = "Parbhani@123";// Add your dbms connection password

	ArrayList<String> Receipients = new ArrayList<>();

	Scanner sc = new Scanner(System.in);

	ArrayList<Integer> con_person = new ArrayList<>(); // Add ID of all person who are present in graph

	ArrayList<String> email = new ArrayList<>(); // Add all email in arraylist for sending emails

	InputStreamReader ir = new InputStreamReader(System.in);

	BufferedReader br = new BufferedReader(ir);

	int k = 0;

	EmailSending e = new EmailSending();

	ArrayList<Integer> Pincode = new ArrayList<>(); // Add all pincode in arraylist

	void createGraphFromArrayList(ArrayList<ArrayList<Edge1>> graph) // Create Graph class for import all methods

			throws IOException, AddressException, MessagingException {

		int c;

		ArrayList<String> Receipients = new ArrayList<>();

		ArrayList<Edge1> a1 = new ArrayList<>();
//Details of first person
		System.out.println("Enter the name of the first contacted person:");

		String s1 = br.readLine();

		System.out.println("Enter the id of the first person:");

		int Pid = sc.nextInt();

		System.out.println("Enter the Email address of the first person:");

		String Email = br.readLine();

		email.add(Email);

		System.out.println("Enter the PIN CODE of the first person:");

		int PINCODE = sc.nextInt();

		String condition = "positive";

		con_person.add(Pid);
//For connected people
		do {

			System.out.println("Enter the name of the contacted person:");

			String d1 = br.readLine();

			System.out.println("Enter the id of the contacted person:");

			int Did = sc.nextInt();

			System.out.println("Enter the Email address of the contacted person:");

			String m = br.readLine();

			email.add(m);

			Pincode.add(PINCODE);

			Receipients.add(m);

			con_person.add(Did);

			a1.add(new Edge1(s1, Pid, d1, Did, PINCODE, condition));

			k++;

			System.out.println("Did you come in contact with more? Enter 1 if yes");

			c = sc.nextInt();

		} while (c == 1);

		System.out.println("Sending Email to the contacted people....");

		for (int i = 0; i < Receipients.size(); i++) {

			e.mail1(Receipients.get(i));

		}

		graph.add(a1);

	}

	void displayArrayList(ArrayList<ArrayList<Edge1>> graph) { // Display all people in graph

		System.out.println("patient id pateint name contacted person id Contacted person name pincode condition");

		for (int j = 0; j < graph.size(); j++) {

			for (int i = 0; i < graph.get(j).size(); i++) {

				Edge1 e = graph.get(j).get(i);

				System.out.println(e.SID + " " + e.source + " " + e.DID + " " + e.destination + " " + e.PINCODE + " "

						+ e.condition);

			}
		}
	}

	void update(ArrayList<ArrayList<Edge1>> graph) throws IOException { // For updating their condition by their ID

		System.out.println("Enter ID to update Patient condition");

		int ID = sc.nextInt();

		for (int j = 0; j < graph.size(); j++) {

			Edge1 e = graph.get(j).get(0);

			if (e.SID == ID) {

				System.out.println("Enter your condition");

				String cond = br.readLine();

				e.condition = cond;

				Connection conn = null;

				Statement stmt = null;

				int n;

				try {
//Connect to database and update their condition
					Class.forName("com.mysql.jdbc.Driver");

					conn = DriverManager.getConnection(DB_URL, USER, PASS);

					stmt = conn.createStatement();

					String query = " update patient set Pcondition=?" + " where SID= ?";

					PreparedStatement prep_stmt;

					prep_stmt = conn.prepareStatement(query);

					prep_stmt = conn.prepareStatement(query);

					prep_stmt.setString(1, cond);

					prep_stmt.setInt(2, ID);

					prep_stmt.execute();
//If person is infected or positive then add to another table 
					if (Objects.equals(e.condition, "positive")) {

						String query2 = "insert into positivepatient(SID,Sname,pincode,Pcondition)"

								+ " values(?,?,?,?) ";

						PreparedStatement prep_stmt1;

						prep_stmt1 = conn.prepareStatement(query2);

						prep_stmt1.setString(4, cond);

						prep_stmt1.setString(2, e.source);

						prep_stmt1.setInt(3, e.PINCODE);

						prep_stmt1.setInt(1, ID);

						prep_stmt1.execute();

					}
//If person is negative or non-infected then Add to another table 
					if (Objects.equals(e.condition, "negative")) {

						String query3 = "insert into negativepatient(SID,Sname,pincode,Pcondition)"

								+ " values(?,?,?,?) ";

						PreparedStatement prep_stmt3;

						prep_stmt3 = conn.prepareStatement(query3);

						prep_stmt3.setString(4, cond);

						prep_stmt3.setString(2, e.source);

						prep_stmt3.setInt(3, e.PINCODE);

						prep_stmt3.setInt(1, ID);

						prep_stmt3.execute();

					}

				} catch (Exception e1) {

					System.out.println(e1);
				}
			}
		}
	}

//For Adding more contacted people
	void addmoreperson(ArrayList<ArrayList<Edge1>> graph) throws IOException, AddressException, MessagingException {

		int c;

		for (int i = 1; i < con_person.size(); i++) {
//Enter Details
			ArrayList<Edge1> a1 = new ArrayList<>();

			System.out.println("Enter the details of the person with id " + con_person.get(i));

			System.out.println("Enter the name of the person:");

			String s1 = br.readLine();

			System.out.println("Enter the PINCODE :");

			int PINCODE = sc.nextInt();

			String condition = "NOT DETERMINED";

			Pincode.add(PINCODE);

			do {

				String m;

				System.out.println("Enter the name of the contacted person:");

				String d1 = br.readLine();

				sc.nextLine();

				System.out.println("Enter the id of the contacted person:");

				int Did = sc.nextInt();

				if (!(con_person.contains(Did))) {

					con_person.add(Did);

					System.out.println("Enter the Email address of the contacted person:");

					m = br.readLine();

					email.add(m);

					Receipients.add(m);

				}

				a1.add(new Edge1(s1, con_person.get(i), d1, Did, PINCODE, condition));//Adding all information in graph

				k++;

				System.out.println("Did you come in contact with more? Enter 1 if yes");

				c = sc.nextInt();

			} while (c == 1);

			if (Receipients.size() != 0) {

				System.out.println("Sending Email to the contacted people....");

				for (int j = 0; j < Receipients.size(); j++) {

					e.mail1(Receipients.get(j)); // Send the email to contacted people by calling mail method

				}

			}

			graph.add(a1);

		}

	}

	void zone(ArrayList<Integer> Pincode) {  // Describe Zone condition by Searching people in their zone by entering pincode 

		System.out.println("Enter pincode number to see your zone color");

		int pin = sc.nextInt();

		int count = Collections.frequency(Pincode, pin);//Search Frequency of present pincode in arraylist 

		if (count >= 7) {//Add that time we consider very less condition but we can update this by future scope /condition in society

			System.out.println("Red zone");

		}

		if (count >= 5 && count <= 7) {

			System.out.println("Orange zone");

		}

		if (count < 5 && count > 0) {

			System.out.println("Yellow zone");

		}

		if (count == 0) {

			System.out.println("Green zone");

		}

	}

	void data(ArrayList<ArrayList<Edge1>> graph) {
//Adding data in database
		Connection conn = null;

		Statement stmt = null;

		int n;

		try {
//Add all condition to database
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("connecting to the database");

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();

			do {

				System.out.println(

						"Menu:\n1.Add data in database\n2.Display All contacted People \n3.Display Positive patient \n4.Display negative patient");

				System.out.println("Enter choice:");

				BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

				int a = Integer.parseInt(b.readLine());

				switch (a) {

				case 1:
// query to add information in database
					String query = " insert into patient(email,SID,Patient_Name,DID,Contacted_person,pincode,Pcondition)"

							+ " values(?,?,?,?,?,?,?) ";

					PreparedStatement prep_stmt;

					prep_stmt = conn.prepareStatement(query);

					for (int j = 0; j < graph.size(); j++) {

						prep_stmt.setString(1, email.get(j));

						for (int i = 0; i < graph.get(j).size(); i++) {

							Edge1 e = graph.get(j).get(i);// add all information by get 

							prep_stmt.setInt(2, e.SID);

							prep_stmt.setString(3, e.source);

							prep_stmt.setInt(4, e.DID);

							prep_stmt.setString(5, e.destination);

							prep_stmt.setInt(6, e.PINCODE);

							prep_stmt.setString(7, e.condition);

							prep_stmt.execute();

						}

					}

					break;

				case 2:
//For display people information from database
					query = " select * from Patient ";

					ResultSet rs = stmt.executeQuery(query);

					while (rs.next()) {//by get we can display their attribute in database

						String email = rs.getString("email");

						int SID = rs.getInt("SID");

						String source = rs.getString("Patient_Name");

						int DID = rs.getInt("DID");

						String Destination = rs.getString("Contacted_person");

						int pincode = rs.getInt("pincode");

						String condition = rs.getString("Pcondition");

						String output = "User:%d -%s -%d - %s - %d - %s - %s ";

						System.out.println(

								String.format(output, SID, source, DID, Destination, pincode, email, condition));

					}

					break;

				case 3:
//display infected people
					query = " select * from positivepatient ";

					ResultSet rs1 = stmt.executeQuery(query);

					while (rs1.next()) {

						int SID = rs1.getInt("SID");

						String source = rs1.getString("Sname");

						int pincode = rs1.getInt("pincode");

						String condition = rs1.getString("Pcondition");

						String output = "%d -%s -%d - %s ";

						System.out.println(

								String.format(output, SID, source, pincode, condition));

					}

					break;

				case 4:
//Display non-infected people
					query = " select * from negativepatient ";

					ResultSet rs2 = stmt.executeQuery(query);

					while (rs2.next()) {

						int SID = rs2.getInt("SID");

						String source = rs2.getString("Sname");

						int pincode = rs2.getInt("pincode");

						String condition = rs2.getString("Pcondition");

						String output = "%d -%s -%d - %s ";

						System.out.println(

								String.format(output, SID, source, pincode, condition));

					}

					break;

				default:

					System.out.println("Wrong input!!");

				}

				System.out.println("if you want to continue in database ");

				n = Integer.parseInt(b.readLine());

			} while (n == 1);

		} catch (Exception e) {

			System.out.println(e);

		}

	}

}

public class LatestCode {//Main class

	public static void main(String args[]) throws IOException, AddressException, MessagingException {

		Scanner sc = new Scanner(System.in);

		ArrayList<ArrayList<Edge1>> graph = new ArrayList<ArrayList<Edge1>>();//For create graph we use arraylist of arraylist for adjusency graph

		OperationGraph1 o1 = new OperationGraph1();

		int a = 1;

		int choice = 0;

		do {

			System.out.println("1.Add contacted people");

			System.out.println("2.Display all people in graph");

			System.out.println("3.Add data in database");

			System.out.println("4.Update Patient condition");

			System.out.println("5.Find out  zone condition");

			System.out.println("Enter your choice :");

			choice = sc.nextInt();

			switch (choice) {

			case 1:

				o1.createGraphFromArrayList(graph);//Create Graph

				o1.addmoreperson(graph);

				break;

			case 2:

				o1.displayArrayList(graph);//Display Graph

				break;

			case 3:

				o1.data(graph);//All methods of database

				break;

			case 4:

				o1.update(graph);//Update condition

				break;

			case 5:

				o1.zone(o1.Pincode);//See your Zone area 

				break;

			default:

				System.out.println("Enter correct choice");

			}

			System.out.println("If you want to continue then enter 1:");

			a = sc.nextInt();

		} while (a == 1);

	}

}


//
//1.Add contacted people
//2.Display all people in graph
//3.Add data in database
//4.Update Patient condition
//5.Find out  zone condition
//Enter your choice :
//1
//Enter the name of the first contacted person:
//utkarsha
//Enter the id of the first person:
//401
//Enter the Email address of the first person:
//utkarsha.kumbhar@cumminscollege.in
//Enter the PIN CODE of the first person:
//411052
//Enter the name of the contacted person:
//rajnandini
//Enter the id of the contacted person:
//402
//Enter the Email address of the contacted person:
//rajnandini.kokadwar@cumminscollege.in
//Did you come in contact with more? Enter 1 if yes
//1
//Enter the name of the contacted person:
//lisa
//Enter the id of the contacted person:
//403
//Enter the Email address of the contacted person:
//lisa.susheel@cumminscollege.in
//Did you come in contact with more? Enter 1 if yes
//0
//Sending Email to the contacted people....
//Email successfully sent to contacted persons!!!
//Email successfully sent to contacted persons!!!
//Enter the details of the person with id 402
//Enter the name of the person:
//rajnandini
//Enter the PINCODE :
//411052
//Enter the name of the contacted person:
//utkarsha
//Enter the id of the contacted person:
//401
//Did you come in contact with more? Enter 1 if yes
//1
//Enter the name of the contacted person:
//lisa
//Enter the id of the contacted person:
//403
//Did you come in contact with more? Enter 1 if yes
//1
//Enter the name of the contacted person:
//vaishnavi
//Enter the id of the contacted person:
//404
//Enter the Email address of the contacted person:
//vaishnavi.jejurkar@cumminscollege.in
//Did you come in contact with more? Enter 1 if yes
//0
//Sending Email to the contacted people....
//Email successfully sent to contacted persons!!!
//Enter the details of the person with id 403
//Enter the name of the person:
//lisa
//Enter the PINCODE :
//411052
//Enter the name of the contacted person:
//utkarsha
//Enter the id of the contacted person:
//401
//Did you come in contact with more? Enter 1 if yes
//1
//Enter the name of the contacted person:
//rajnandini
//Enter the id of the contacted person:
//402
//Did you come in contact with more? Enter 1 if yes
//0
//Sending Email to the contacted people....
//Email successfully sent to contacted persons!!!
//Enter the details of the person with id 404
//Enter the name of the person:
//vaishnavi
//Enter the PINCODE :
//411052
//Enter the name of the contacted person:
//rajnandini
//Enter the id of the contacted person:
//402
//Did you come in contact with more? Enter 1 if yes
//0
//Sending Email to the contacted people....
//Email successfully sent to contacted persons!!!
//If you want to continue then enter 1:
//1
//1.Add contacted people
//2.Display all people in graph
//3.Add data in database
//4.Update Patient condition
//5.Find out  zone condition
//Enter your choice :
//2
//patient id pateint name contacted person id Contacted person name pincode condition
//401 utkarsha 402 rajnandini 411052 positive
//401 utkarsha 403 lisa 411052 positive
//402 rajnandini 401 utkarsha 411052 NOT DETERMINED
//402 rajnandini 403 lisa 411052 NOT DETERMINED
//402 rajnandini 404 vaishnavi 411052 NOT DETERMINED
//403 lisa 401 utkarsha 411052 NOT DETERMINED
//403 lisa 402 rajnandini 411052 NOT DETERMINED
//404 vaishnavi 402 rajnandini 411052 NOT DETERMINED
//If you want to continue then enter 1:
//1
//1.Add contacted people
//2.Display all people in graph
//3.Add data in database
//4.Update Patient condition
//5.Find out  zone condition
//Enter your choice :
//3
//connecting to the database
//Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
//Sat Apr 29 20:26:27 IST 2023 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
//Menu:
//1.Add data in database
//2.Display All contacted People 
//3.Display Positive patient 
//4.Display negative patient
//Enter choice:
//1
//java.sql.SQLSyntaxErrorException: Unknown column 'Patient_Name' in 'field list'
//If you want to continue then enter 1:
//1
//1.Add contacted people
//2.Display all people in graph
//3.Add data in database
//4.Update Patient condition
//5.Find out  zone condition
//Enter your choice :
//2
//patient id pateint name contacted person id Contacted person name pincode condition
//401 utkarsha 402 rajnandini 411052 positive
//401 utkarsha 403 lisa 411052 positive
//402 rajnandini 401 utkarsha 411052 NOT DETERMINED
//402 rajnandini 403 lisa 411052 NOT DETERMINED
//402 rajnandini 404 vaishnavi 411052 NOT DETERMINED
//403 lisa 401 utkarsha 411052 NOT DETERMINED
//403 lisa 402 rajnandini 411052 NOT DETERMINED
//404 vaishnavi 402 rajnandini 411052 NOT DETERMINED
//If you want to continue then enter 1:
//1
//1.Add contacted people
//2.Display all people in graph
//3.Add data in database
//4.Update Patient condition
//5.Find out  zone condition
//Enter your choice :
//3
//connecting to the database
//Sat Apr 29 20:26:40 IST 2023 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
//Menu:
//1.Add data in database
//2.Display All contacted People 
//3.Display Positive patient 
//4.Display negative patient
//Enter choice:
//4
//if you want to continue in database 
//0
//If you want to continue then enter 1:
//1
//1.Add contacted people
//2.Display all people in graph
//3.Add data in database
//4.Update Patient condition
//5.Find out  zone condition
//Enter your choice :
//4
//Enter ID to update Patient condition
//402
//Enter your condition
//positive
//Sat Apr 29 20:27:03 IST 2023 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
//If you want to continue then enter 1:
//1
//1.Add contacted people
//2.Display all people in graph
//3.Add data in database
//4.Update Patient condition
//5.Find out  zone condition
//Enter your choice :
//4
//Enter ID to update Patient condition
//403
//Enter your condition
//negative
//Sat Apr 29 20:27:12 IST 2023 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
//If you want to continue then enter 1:
//1
//1.Add contacted people
//2.Display all people in graph
//3.Add data in database
//4.Update Patient condition
//5.Find out  zone condition
//Enter your choice :
//3
//connecting to the database
//Sat Apr 29 20:27:15 IST 2023 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
//Menu:
//1.Add data in database
//2.Display All contacted People 
//3.Display Positive patient 
//4.Display negative patient
//Enter choice:
//3
//402 -rajnandini -411052 - positive 
//if you want to continue in database 
//1
//Menu:
//1.Add data in database
//2.Display All contacted People 
//3.Display Positive patient 
//4.Display negative patient
//Enter choice:
//4
//403 -lisa -411052 - negative 
//if you want to continue in database 
//0
//If you want to continue then enter 1:
//1
//1.Add contacted people
//2.Display all people in graph
//3.Add data in database
//4.Update Patient condition
//5.Find out  zone condition
//Enter your choice :
//5
//Enter pincode number to see your zone color
//411052
//Orange zone
//If you want to continue then enter 1:
//0