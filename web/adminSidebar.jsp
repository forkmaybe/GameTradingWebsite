<%-- 
    Document   : AdminSidebar
    Created on : 09-Mar-2015, 15:41:09
    Author     : d00135791
--%>

<%@page import="Dtos.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="i18n.text" />
<%
    User u = (User) session.getAttribute("loggedUser");
    if(u != null && u.getIsAdmin() == 1){//If 1 then they are admin.
%>
        <article>
            <a href="adminAccount.jsp"><label for="adminAcc"><fmt:message key="gamehub.label.adminAcc" /></label></a>
            </br>
            <a href="adminAddGame.jsp"><label for="addGame"><fmt:message key="gamehub.label.addGame" /></label></a>
            </br>
        </article>   
    <%
        }
    %>