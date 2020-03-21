<%--
  Created by IntelliJ IDEA.
  User: yanov
  Date: 14/03/2020
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Tours</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">

<div class="w3-container w3-blue-grey w3-opacity w3-left-align">
    <h1>Tours</h1>
</div>
<table align="center">
    <style>
        table {
            border-collapse: collapse;
            width: 300px;
        }

        TH {
            background: lightgoldenrodyellow;
            text-align: left;
        }

        TD {
            background: #fff;
            text-align: center;
        }

        TH, TD {
            border: 1px solid black;
            padding: 4px;
        }
    </style>
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">Tour name</th>
        <th scope="col">Tour type</th>
        <th scope="col">Country</th>
        <th scope="col">Start date</th>
        <th scope="col">Days</th>
        <th scope="col">Transport</th>
        <th scope="col">Stars</th>
        <th scope="col">Hotel type</th>
        <th scope="col">Rooms</th>
        <th scope="col">Cost</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="tour" items="${requestScope.tours}" varStatus="status">
        <tr>
            <td>${tour.id}</td>
            <td>${tour.tourName}</td>
            <td>${tour.tourType}</td>
            <td>${tour.country}</td>
            <td>${tour.startDate}</td>
            <td>${tour.days}</td>
            <td>${tour.transport}</td>
            <td>${tour.hotelCharacteristic.stars}</td>
            <td>${tour.hotelCharacteristic.hotelType}</td>
            <td>${tour.hotelCharacteristic.rooms}</td>
            <td>${tour.cost}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="w3-container w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large w3-hover-pale-yellow"
            onclick="location.href='/XMLParser'">
        Back to
        main
    </button>
</div>
</body>
</html>

