<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="db.*"%>

<!DOCTYPE html>
<html>
<title>CareConnect</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: sans-serif;
}

body {
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	background: linear-gradient(to left, #2899e0 0%, #ffffff 100%);
	background-size: cover;
	background-position: center;
}

#myChart{
    height: 450px;
    width: 550px;
   position: absolute; 
   top: 130px;
    background: transparent;
    border: 2px solid rgba(255, 255, 255, .5);
    border-radius: 20px;
    backdrop-filter: blur(20px);
    box-shadow: 0 0 30px rgba(0, 0, 0, .5);
   
  }
#myChart1{
    height: 400px;
    width: 550px;
   position: relative; 
   top: 518px;
    background: transparent;
    border: 2px solid rgba(255, 255, 255, .5);
    border-radius: 20px;
    backdrop-filter: blur(20px);
    box-shadow: 0 0 30px rgba(0, 0, 0, .5);
    
  }

h1 {
	position: absolute;
	top: 25px;
}
</style>

<body>
	<h1>Patients Informations</h1>
	<canvas id="myChart1" style="width:100%;max-width:700px"></canvas>
	<canvas id="myChart" style="width: 100%; max-width: 600px"></canvas>
	<%
	int count=0,count1=0,count2=0,count3=0;
try
{
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/utkarsha_438","root","Utkarsha@06");     
    Statement st=con.createStatement();
    String strQuery = "SELECT COUNT(*) FROM Patient";
  
  
    ResultSet rs = st.executeQuery(strQuery);
   
    
    String Countrow="";
      while(rs.next()){
      Countrow = rs.getString(1);
   
       } 
      String strQuery1 = "SELECT COUNT(*) FROM positivepatient";
      
      ResultSet rs1 = st.executeQuery(strQuery1);
      String Countrow1="";
     while(rs1.next()){
      Countrow1 = rs1.getString(1);
     
       } 
     
     String strQuery2 = "SELECT COUNT(*) FROM negativepatient";
     ResultSet rs2 = st.executeQuery(strQuery2);
      String Countrow2="";
      while(rs2.next()){
      Countrow2 = rs2.getString(1);
     
      }
      
      String strQuery3 = "SELECT COUNT(*) FROM patient";
      ResultSet rs3 = st.executeQuery(strQuery2);
      String Countrow3="";
      while(rs3.next()){
      Countrow3 = rs3.getString(1);
     
      }
      count=Integer.valueOf(Countrow);
      count1=Integer.valueOf(Countrow1);
      count2=Integer.valueOf(Countrow2);
      count3=Integer.valueOf(Countrow3);

    }
catch (Exception e){
    e.printStackTrace();
  }
  %>

	<script>
	var xValues1 = [ "Positive Patient", "Negative Patient","Not=Detrmined"];
	var yValues1 = [<%=count1%>, <%=count2%>, <%=count3%>];
	var barColors1 = [
	  "red",
	  "green"
	  ,"orange"
	];
	
	new Chart("myChart1", {
		  type: "pie",
		  data: {
		    labels: xValues1,
		    datasets: [{
		      backgroundColor: barColors1,
		      data: yValues1
		    }]
		  },
		  
		});
	
	
	
	
		var xValues = [ "Contacted person", "Positive Patient",
				"Negative Patient" ,"Not-Detremined"];

		var yValues = [<%=count%>, <%=count1%>, <%=count2%>, <%=count3%>];
		var barColors = [ "blue", "rgba(255,0,0,0.8)", "green","orange"

		];

		new Chart("myChart", {
			type : "bar",
			data : {
				labels : xValues,
				datasets : [ {
					backgroundColor : barColors,
					data : yValues
				} ]
			},
			options : {
				legend : {
					display : false
				},
				title : {
					display : true,
				// text: "Corona Patient Prediction"
				},
				scales : {
					yAxes : [ {
						ticks : {
							beginAtZero : true
						}
					} ],
				}
			}
		});
		
	</script>

</body>
</html>