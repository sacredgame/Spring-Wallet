<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="a" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Withdraw</title>
</head>
<script>
function chkEmpty(){
	var mob = /^[7-9]{1}[0-9]{9}$/;
	
	if (document.frmReg.mobile.value == "") {alert("Please fill the mobile number");return false;}
	else if (mob.test(document.frmReg.mobile.value) == false) {alert("Please fill valid mobile number");return false;}

	else if (document.frmReg.inibal.value == "") {alert("Please enter amount");return false;}
	else if (document.frmReg.inibal.value < 1) {alert("Amount should be greater than equal to Rs.1");return false;}
	
	else
		return true;
	}
	
</script>
<body>
<table border="2">
<a:form action="withdrawamt" name="frmReg" method="post" modelAttribute="with" onSubmit="return chkEmpty()">

<tr>
<td>Enter Mobile number:</td>
<td><a:input path="mobileNo" id="mobile"/>
</tr>

<tr>
<td>Enter Amount to withdraw:</td>
<td><a:input path="amount" id="inibal"/>
</tr>
<tr>
<td colspan="2"><input type="submit" value="Withdraw" /></td>
</tr>
</a:form>

</table>

</body>
</html>