<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>注册成功</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      text-align: center;
      background-color: #f0f0f0;
      margin: 0;
      padding: 0;
      background-image: url("images/th.jpg");
      background-size: cover; 
    }

    .container {
      max-width: 600px;
      margin: 300px auto 0;
      padding: 20px;
      background-color: #fff;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
    }

    h1 {
      color: #333;
    }

    p {
      color: #666;
    }

    button {
      background-color: #007bff;
      color: #fff;
      border: none;
      padding: 10px 20px;
      cursor: pointer;
      border-radius: 5px;
    }

    button:hover {
      background-color: #0056b3;
    }
  </style>
</head>
<body>
  <div class="container">
    <h1>Information error</h1>
    <p>Password modification failed</p>
  
    <!-- 转到登录页面的按钮 -->
    <button onclick="redirectToLoginPage()">Image change failed</button>
  </div>

  <script>
    function redirectToLoginPage() {
      // 跳转到登录页面
      window.location.href = "login.jsp";
    }
  </script>
</body>
</html>