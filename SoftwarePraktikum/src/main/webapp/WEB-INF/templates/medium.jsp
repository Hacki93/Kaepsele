<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<html> 
<body>  
<h2>Hacki's FileManager</h2> 
	<form method="POST" commandName="file"  enctype="multipart/form-data"> 
		Upload your file please:  
		<input type="file" name="file" /> 
		<input type="submit" value="upload" /> 
		<form:errors path="medium" cssStyle="color: #ff0000;" /> 
	 </form> 
	<b>Übungsblatt_2_Projektplan.pdf</b>&nbsp;
	<a href="mediumrunterladen.htm">Click and download file here</a>
</body> 
</html>