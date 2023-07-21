<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CareConnect</title>
</head>
<style>
    /* CSS styles go here */

   *{
  margin: 0;
  padding: 10px;
  box-sizing: border-box;
  font-family: sans-serif;

  }
  body{
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    background:linear-gradient(to right,rgb(21, 123, 196),rgb(129, 207, 229));
    background-size: cover;
    background-position: center;
  }
    h1 {
      color:rgb(8, 13, 15);
      text-align: center;
    }
    
    header{
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    padding: 10px 50px;
  
    display:flex;
    justify-content: space-between;
    align-items: center;
    z-index:99 ;
  }
    

    .navigation a{
    position: relative;
    font-size: 1.1em;
    color: #0c0c0c;
    text-decoration: none;
    font-weight: 500;
    margin-left: 40px;
  }
  .navigation a::after{
    content: '';
    position: absolute;
    left: 0;
    bottom: -6px;
    width: 100%;
    height: 3px;
    background: rgb(21, 20, 20);
    border-radius: 5px;
    transform-origin: right;
    transform: scaleX(0);
    transition: transform  0.5s;
  }

  .navigation a:hover::after{
transform-origin: left;
transform: scaleX(1);
}
  .navigation .btnLogin-popup{
    width: 110px;
    height: 40px;
  
    background: transparent;
    border: 2px solid #0f0e0e;
    outline: none;
    border-radius: 6px;
    cursor: pointer;
    font-size: 1.1em;
    color: rgb(9, 8, 8);
 font-weight: 500;
 margin-left: 40px;
 transition:  .5s;
  }
  .navigation .btnLogin-popup:hover{
    background-color: rgb(15, 15, 15);
    color: rgb(253, 243, 243);
  }
 .container{
    right: 0%;
    position: relative;
    width: 900px;
    height: 600px;
    background: transparent;
    border: 2px solid rgba(255, 255, 255, .5);
    border-radius: 20px;
    backdrop-filter: blur(20px);
    box-shadow: 0 0 30px rgba(0, 0, 0, .5);
   
 }
  </style>
  
<body>
    
    <header>
        <h2 class="Logo">CareConnect</h2>
        <nav class="navigation">
          <a href="home.jsp">Home</a>
          <a href="about.jsp">About</a>
          <a href="user.jsp">User</a>
         
         <button class="btnLogin-popup" onclick="window.location.href = 'home.jsp';">Admin</button>
        </nav>
      </header>
  <div class="container">
   
    <h1>Contact Tracing System</h1>
   
    <p>
        <br><br>
        Online contact tracing is a process of identifying and notifying people who may have been exposed to contagious diseases. Contact tracing is a crucial part of controlling the spread of diseases, as it aids the quick identification and isolation of infected persons which can help in preventing the further transmission of the contagion.
        <br><br>


<ul>
   
    <br>
    <h2><b>How it Works:</b></h2>
    <br>
    <p>This system is intended for an <b>administrator's</b> use.<br></p><br>
      1.  The admin enters the details of <b>patient zero(initially infected person)</b> along with the contact information of all the people patient zero has come into contact with.<br>
      2.  The software sends a notification to each of these contacts via email, warning them about the potential danger of getting infected.<br>
      3.  The email in turn collects details of these contacts, including the contact information of those they have been in close physical touch with. Similar emails are sent to these secondary contacts<br>
      4.  The software keeps collecting data of those infected. This data is added in a graph, each node representing an infected person.<br> 
      5.  The graph shows the relationship between infected people and the extent of the diseases' spread.
    
    <br><br>
    <p>Online contact tracing is a useful tool in the fight against contagious diseases while maintaining the privacy of the individuals involved.
    </p>
    
</ul>



      </p>
  </div>
 
</body>
</html>