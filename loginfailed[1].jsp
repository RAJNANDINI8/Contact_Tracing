<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CareConnect</title>
</head>
<style>
    *{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: sans-serif;

  }
  body{
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    background:  linear-gradient(to right,rgb(50, 94, 224),rgb(81, 220, 224));
    background-size: cover;
    background-position: center;
  }
  p{
    font-weight: 40px;
    font-size: 50px;
  }
  a{
    font-size: large;
    position: absolute;
   left: 48%;
  }
</style>
<body>
    <div class="container">
        <p>Login Failed</p>
        <a href="home.jsp">Try again</a>
    </div>
</body>
</html>