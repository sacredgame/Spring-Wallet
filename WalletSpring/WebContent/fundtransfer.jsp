<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="b" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fund Transfer</title>
</head>
<script type = "text/javascript">
function chkEmpty(){
	var mob = /^[7-9]{1}[0-9]{9}$/;
	
	if (document.frmReg.mobile.value == "") {alert("Please fill sender's mobile number");return false;}
	else if (mob.test(document.frmReg.mobile.value) == false) {alert("Please fill valid sender's mobile number");return false;}

	else if (document.frmReg.amt.value == "") {alert("Please enter amount");return false;}
	else if (document.frmReg.amt.value < 1) {alert("Amount should be greater than equal to Rs.1");return false;}
	
	else if (document.frmReg.mobile1.value == "") {alert("Please fill receiver's mobile number");return false;}
	else if (mob.test(document.frmReg.mobile1.value) == false) {alert("Please fill valid receiver's mobile number");return false;}
	
	else if ((document.frmReg.mobile1.value) == (document.frmReg.mobile.value)) {alert("Sender's and Receiver's mobile number cannot be same");return false;}
	
	else
		return true;
	}
	
</script>
<body>
<b:form action="fund" method="post" modelAttribute="fd" name="frmReg" onSubmit="return chkEmpty()">
<table border="2">
<tr>
<td>Enter Mobile sender's number:</td>
<td><b:input path="mobileNo" id="mobile"/></td>
</tr>

<tr>
<td>Enter Amount to transfer:</td>
<td><b:input path="amount" id="amt"/></td>
</tr>

<tr>
<td>Enter Mobile receiver's number:</td>
<td><b:input path="mobNo" id="mobile1"/></td>
</tr>
<tr>
<td><input type="submit" value="Transfer" /></td>
</tr>
</table>
</b:form>
</body>
</html>