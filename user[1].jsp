<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>CareConnect</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
        integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
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
      background:  linear-gradient(to left, #2899e0 0%, #8ceef0 100%);
      background-size: cover;
      background-position: center;
  }
    .container {
        display: flex;
        flex-direction: column;
        align-items: center;
        height: 100vh;
        /* justify-content: center; 
        background-size: cover; */
        text-align: center;
        transition: filter 0.7s;
       
    }

    h2 {
      left: 0;
      top: 0;
      color: rgb(5, 5, 5);
    }

    .btn {
        position: relative;
      top: 140px;
        padding: 10px 20px;
        cursor: pointer;
        color: black;
        border-radius: 5px;
        font-size: 20px;
        background: transparent;
      border: 2px solid #0f0e0e;
      outline: none;
      border-radius: 6px;
      cursor: pointer;
      font-size: 1.1em;
      margin-top: 20px;
      transition: .5s;
    }
  
    .btn:hover {
        background-color: rgb(15, 15, 15);
      color: rgb(253, 243, 243);
    }
  
    header{
      position: fixed;
      top: 0;
      left: 0;
      width: 100%;
      padding: 20px 100px;
      display:flex;
      justify-content: space-between;
      align-items: center;
      z-index:99 ;
  }
  
  .Logo {
      flex: 1;
  }
  
  .navigation {
      flex: 1;
      display: flex;
      justify-content: center;
      align-items: center;
    
  }
  
  .navigation .btnLogin-popup{
    position: absolute;
   right: 145px;

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
      transition: .5s;
  }
  
  .navigation .btnLogin-popup:hover{
      background-color: rgb(15, 15, 15);
      color: rgb(253, 243, 243);
  }
</style>

<body> 
    <header>
        <h2 class="Logo">CareConnect</h2>
        <nav class="navigation">
            <button class="btnLogin-popup" onclick="window.location.href = 'home.jsp';">Home</button>
         
        </nav>
    </header>
    <div class="container">
        <button class="btn" onclick="window.location.href = 'mymap.jsp';">Check Hospitals </button>
        <button class="btn" onclick="window.location.href = 'bargraph.jsp';">check  people condition</button>
       
     
    </div>  
</body>

</html>