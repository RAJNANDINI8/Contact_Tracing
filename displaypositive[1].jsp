<%@page import="java.sql.*"%>
<%@page import="db.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
   <title>CareConnect</title>

    <style>
      * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: sans-serif;
      }
      body {
      
        display: flex;
        justify-content: top;
        align-items: center;
        min-height: 100vh;
       background: linear-gradient(to right,rgb(50, 94, 224),rgb(81, 220, 224)) ;
        background-size: cover;
        background-position: center;
      }
      table {
        border-collapse: collapse;
        width: 100%;
        top: 200px;
        position: absolute;
      }
    
      th,
      td {
        top: 200px;
        text-align: left;
        padding: 8px;
        border-width: medium;
        border-color: black;
      }

      th {
        background-color: #f3ecec;
      }
      h1{
        position: absolute;
        top: 100px;
        color: black;
        left: 40%;
      }
    </style>
  </head>
  <body>
    <h1>Infected Patients </h1>
    <table border="1">
      <tr>
        <th>Patient Id</th>
        <th>Patient Name</th>
        <th>Pincode</th>
        <th>Condition</th>
     
        
      </tr>

      <% Connection conn = null; Statement stmt = null; Blob image=null;
      ResultSet rs=null; try{ Class.forName("com.mysql.jdbc.Driver");
      conn=DriverManager.getConnection("jdbc:mysql://localhost/utkarsha_438","root","Utkarsha@06");
      stmt = conn.createStatement(); String q="select * from positivepatient";
      rs=stmt.executeQuery(q); 
      while(rs.next()){ %>
      <tr>
        <td><%=rs.getInt(1) %></td>
        <td><%=rs.getString(2) %></td>
        <td><%=rs.getString(3) %></td>
        <td><%=rs.getString(4) %></td>
      
    
      </tr>

      <% } } catch(Exception e){ e.printStackTrace(); } %>
    </table>
  </body>