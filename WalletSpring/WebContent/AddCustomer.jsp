<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fo" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Customer</title>
</head>
<script >

function chkEmpty(){
	var mob = /^[7-9]{1}[0-9]{9}$/;
	var name=/^[A-Z]{1}[a-z]{2,15}/;
	
	if(document.frmReg.name.value == ""){alert("Please enter first name"); return false;}
	else if (name.test(document.frmReg.name.value) == false) {alert("Please enter valid first name starting with capital letter");return false;}
	
	else if (document.frmReg.mobile.value == "") {alert("Please fill the mobile number");return false;}
	else if (mob.test(document.frmReg.mobile.value) == false) {alert("Please fill valid mobile number");return false;}
	
	else if (document.frmReg.age.value == "") {alert("Please fill age");return false;}
	else if (document.frmReg.age.value <18 || document.frmReg.age.value > 100){alert("Please enter valid age (between 18 to 100 years)");return false;}

	else if (document.frmReg.inibal.value == "") {alert("Please enter amount");return false;}
	else if (document.frmReg.inibal.value < 1) {alert("Amount should be greater than or equal to Rs.1");return false;}
	
	else
		return true;
	
	}
	

</script>
<body>
<table>
<fo:form action="adddata" method="post" name="frmReg" modelAttribute="my" onSubmit="return chkEmpty()">

<tr>
<td>Customer Name</td>
<td><fo:input path="name" id="name"/></td>
</tr>

<tr>
<td>Mobile No.</td>
<td><fo:input path="mobileNo" id="mobile"/></td>
</tr>

<tr>
<td>Age</td>
<td><fo:input path="age" id="age"/></td>
</tr>

<tr>
<td>Initial Balance</td>
<td><fo:input path="initialBalance" id="inibal"/></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="Add Customer"/></td>
</tr>
</fo:form>

</table>
</body>
</html>