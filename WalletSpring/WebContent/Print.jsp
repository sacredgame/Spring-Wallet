<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="fu" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Print Transactions</title>
</head>
<script type = "text/javascript">
function chkEmpty(){
	var mob = /^[7-9]{1}[0-9]{9}$/;
	
	if (document.frmReg.mobile.value == "") {alert("Please fill the mobile number");return false;}
	else if (mob.test(document.frmReg.mobile.value) == false) {alert("Please fill valid mobile number");return false;}

	else
		return true;
	}
	
</script>
<body>
<table border="2">
<fu:form action="printtrans" method="post" name="frmReg" modelAttribute="trans" onSubmit="return chkEmpty()" >

<tr>
<td>Enter Mobile number:</td>
<td><fu:input path="mobileNo" id="mobile"/>
</tr>

<tr><td><input type="submit" value="Print Transactions"></td></tr>
</fu:form>
</table>
</body>
</html>