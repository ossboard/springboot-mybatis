<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title><spring:message code='html.title'/></title>
    <meta http-equiv="X-UA-Compatible" id="X-UA-Compatible" content="IE=Edge"/>
    <meta http-equiv="X-UA-Compatible" id="browser_mode" content="IE=Edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<body>
<c:set var="servlet_path"><c:out value="${requestScope['javax.servlet.forward.servlet_path']}"/></c:set>
<div class="container">
    <div>
        <h1>WebJars Starter</h1>
        <p class="lead">${servelt_path}</p>
    </div>
</div>

-- HEADER --------------------<br/>