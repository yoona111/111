<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="testweb.vo.messageinfo" %>
    <%@ page import="testweb.vo.UserInfo" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css"> <!-- 引用外部样式表 -->
<style>
  body {
    background-color: lightblue; /* 设置背景颜色为淡蓝色 */
  }
</style>
</head>
<body>
<div style="position: absolute; top: 0; right: 0;">
<button onclick="redirectToRegistrationPage()" style="width: 150px; height: 50px;">modify the Avatar</button>
</div>
  <script>
    function redirectToRegistrationPage() {
      // 跳转到注册页面
      window.location.href = "user.jsp";
    }
  </script>
    <table>
        <tr>
            
            <th>Username</th>
            <th>image</th>
        </tr>

        
        <% List<messageinfo> mess = (List<messageinfo>) session.getAttribute("mess");
               if (mess != null && !mess.isEmpty()) {
               for (messageinfo message : mess) {
               String username = message.getUsername();
               String image = message.getimage();
    %>
    <tr>
        <td><%= username %></td>
        <td class="centered"><img src="<%= image %>" /></td> <!-- 应用样式类来居中图像 -->
    </tr>
        <%}} %>
        <% String daoa1 = (String) session.getAttribute("images");%>
        <div style="width: 100px; height: 100px; overflow: hidden; border-radius: 50%;">
        <img src="data:image/jpeg;base64,<%= daoa1 %>" left: 20 width="200" height="150" object-fit: cover;">
</div>

    </table>
</body>
</html>