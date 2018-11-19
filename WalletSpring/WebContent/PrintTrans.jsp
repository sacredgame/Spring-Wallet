<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transactions</title>
</head>
<body>
<table>
<tr>
<th>Mobile Number</th>
<th>Credit or Debit</th>
<th>Amount</th>
<th>Balance</th>
</tr>
<a:forEach var="trans" items="${list}">
<tr>
<td>${trans.mobileNo}</td>
<td>${trans.cd}</td>
<td>${trans.amount}</td>
<td>${trans.balance}</td>
</a:forEach>
</table>
</body>
</html>