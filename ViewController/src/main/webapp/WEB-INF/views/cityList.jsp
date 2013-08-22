<html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<head>

    <title>PM2d5</title>

    <!-- Le styles -->
    <link rel="stylesheet" type="text/css" href="<c:url value='/bootstrap/css/bootstrap.min.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/bootstrap/css/bootstrap-responsive.min.css'/>" />

</head>

<body class="body">

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="brand" href="#">Project name</a>
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="#about">About</a></li>
                    <li><a href="#contact">Contact</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>
</div>


<div class="container">

    <h1>Bootstrap starter template</h1>
    <p>Use this document as a way to quick start any new project.<br> All you get is this message and a barebones HTML document.</p>

    <c:if test="${!empty list}">

        <c:forEach items="${list}" var="c">
            ${c.name}
        </c:forEach>

    </c:if>

</div> <!-- /container -->

<!-- Le javascript
   ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="<c:url value='/bootstrap/js/jquery.min.js'/>"></script>
<script src="<c:url value='/bootstrap/js/bootstrap.min.js'/>"></script>

<script src="//cdnjs.bootcss.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="//cdnjs.bootcss.com/ajax/libs/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>

</body>
</html>
