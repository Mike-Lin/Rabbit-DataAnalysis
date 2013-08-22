<html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<head><title>PM2d5</title></head>

<style type="text/css">

    .tableClass {
        border: 1px solid red;
        border-collapse: collapse;
    }

    .tableClass tr td, .tableClass tr th {
        border: 1px solid red;
        height: 30px;
        line-height: 30px;
        font-family: "微软雅黑";
        font-size: 14px;
        color: #000000;
        text-align: center;
    }

    .tableClass tr th {
        background-color: purple;
    }

    .oddtrcolor, .oddtrcolor tr td {
        background-color: Yellow;
    }

    .eventrcolor, .eventrcolor tr td {
        background-color: Lime;
    }

    .body {
        background-color: #f5f5dc;
        text-align: center;
        margin-right: auto;
        margin-left: auto;
    }

</style>

<body class="body">

<table class="tableClass" align="center">
    <tr>
        <th>监测点名称</th>
        <th>AQI空气质量指数</th>
        <th>空气质量指数类别</th>
        <th>PM2.5细微粒物</th>
        <th>PM10可吸入颗粒物</th>
        <th>CO一氧化碳</th>
        <th>NO2二氧化氮</th>
        <th>O3臭氧1小时平均</th>
        <th>O3臭氧8小时平均</th>
        <th>SO2二氧化硫</th>
    </tr>

    <c:if test="${!empty list}">

        <c:forEach items="${list}" var="p">


            <tr>
                <td><c:out value="${p.positionName}" default="-"></c:out></td>
                <td><c:out value="${p.aqi}" default="-"/></td>
                <td class="eventrcolor"><c:out value="${p.quality}" default="-"></c:out></td>
                <td><c:out value="${p.pm2_5}" default="-"></c:out></td>
                <td><c:out value="${p.pm10}" default="-"></c:out></td>
                <td><c:out value="${p.co}" default="-"></c:out></td>
                <td><c:out value="${p.no2}" default="-"></c:out></td>
                <td><c:out value="${p.o3}" default="-"></c:out></td>
                <td><c:out value="${p.o3_8h}" default="-"></c:out></td>
                <td><c:out value="${p.so2}" default="-"></c:out></td>
            </tr>
        </c:forEach>

    </c:if>

</table>
当前路径:${pageContext.request.contextPath}

</body>
</html>
