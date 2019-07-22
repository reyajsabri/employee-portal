<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <style type="text/css">
        .linkCSS {              
            cursor: pointer;
            text-decoration: none;
        }           
        .padding {
            padding: 13px 0px 20px 145px;
        }
    </style>
</head>
<body style='background-color: #996633;'>
	<h2>Interstellar Transport System wellcomes you !!</h1>
	<br/>
	<h4>You can upload Your Galaxy information in CSV OR XML File </h4>
	<div id="excelFile" class="padding">
        <a id="downloadExcelFileLink" target="_self" class="linkCSS" href="${pageContext.request.contextPath}/download/excel">Download  sample Excel File</a>
    </div>
    <div id="xmlFile" class="padding">
        <a id="downloadXMLFileLink" target="_self" class="linkCSS" href="${pageContext.request.contextPath}/download/xml">Download sample xml File</a>
        <br/>
        <a id="downloadXSDFileLink" target="_self" class="linkCSS" href="${pageContext.request.contextPath}/download/xsd">Download sample xml schema File</a>
    </div>
    <br/>
    <h4>You can upload Your Galaxy information <a id="uploadFile" class="linkCSS" href="${pageContext.request.contextPath}/RouteUpload/"> Here</a> </h4>
    <br/>
    <h4>You can search Travell Information <a id="search" class="linkCSS" href="${pageContext.request.contextPath}/Search/"> Here</a> </h4>
</body>
</html>