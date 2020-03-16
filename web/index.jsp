<%--
  Created by IntelliJ IDEA.
  User: yanov
  Date: 14/03/2020
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Parser</title>
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-left-align">
  <h1>Parser</h1>
</div>

<div class="w3-container w3-center">
  <h3>Choose file: </h3>
  <form action="table" method="post" enctype="multipart/form-data">
    <p><input type="file" name="file" accept=".xml"/>
    <div class="w3-bar w3-padding-large w3-padding-24">
      <button type="submit" class="w3-btn w3-hover-pale-yellow w3-round-large"
              name="command" value="DOM">DOM
      </button>
      <button type="submit" class="w3-btn w3-hover-pale-yellow w3-round-large"
              name="command" value="SAX">SAX
      </button>

      <button type="submit" class="w3-btn w3-hover-pale-yellow w3-round-large"
              name="command" value="STAX">STAX
      </button>
    </div>
  </form>
</div>
</body>
</html>

