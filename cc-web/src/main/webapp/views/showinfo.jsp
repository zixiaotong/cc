<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>${title}</title>
  </head>
  
  <body>

          <c:forEach var="runLog" items="${runLogLists}">
              <a>${runLog.createdate}</a>
              <a>${runLog.app}</a>
              <a>${runLog.serverip}</a>
              <a>${runLog.log}</a>
              <a>${runLog.deployid}</a>
          </c:forEach>


  </body>
</html>