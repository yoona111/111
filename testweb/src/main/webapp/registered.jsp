<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>User Registration</title>
  <link rel="stylesheet" type="text/css" href="registered.css">
</head>
<body>
  <div class="form-div">
  <div class="reg-content">
  <h1>User Registration</h1>
  </div>
  <form id ="reg-form" method="post" action="./registered">
    <table>
    <tr>
    <tb class="inputs">
      <label for="username">Username:</label>
      <input type="text" id="username1" name="username1" required>
    </tb>
      </tr>
      
     <tr>
    <tb class="inputs">
      <label for="password">Password:</label>
      <input type="text" id="password1" name="password1" required>
    </tb>
     </tr>
     <tr>
     
    <tb class="inputs">
      <label for="number">tellphonenumber:</label>
      <input type="text" id="number" name="number" required>
    </tb>
     </tr>
     
     </table>
    <div class="buttons">
      <input type="submit" id="submit" value="Submit">
    </div>
    <br class="clear">
  </form>
   </div>
</body>
</html>
