<%-- 
    Document   : nav
    Created on : 19-Feb-2015, 12:31:14
    Author     : d00135791
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="Dtos.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="i18n.text" />
<header class="mainHeader">
<img src="GameHubLogo.png"><!-- add image url later -->
<%
    User u = (User) session.getAttribute("loggedUser");
    if(u != null && session.getAttribute("clientLoggedInId") == null){//If 1 then they are admin.
%>
            <nav><ul>
                <li><a href="aboutUs.jsp"><label for="aboutUs"><fmt:message key="gamehub.label.aboutUs" /></label></a></li>
                <li><a href="contactUs.jsp"><label for="contactUs"><fmt:message key="gamehub.label.contactUs" /></label></a></li>
                <li><a href="login.jsp"><label for="login"><fmt:message key="gamehub.label.login" /></label></a>
                <li><a href="register.jsp"><label for="register"><fmt:message key="gamehub.label.register" /></label></a></li>
            </ul></nav>
<%
    }else{
%>
        <nav><ul><!-- add later -->
            <li><a href="home.jsp"><label for="home"><fmt:message key="gamehub.label.home" /></label></a></li>
            <li><a href="BarterServlet?action=ViewAll"><label for="game"><fmt:message key="gamehub.label.game" /></label></a></li>
            <li><a href="BarterServlet?action=haves"><label for="haves"><fmt:message key="gamehub.label.haves" /></label></a></li>
            <li><a href="BarterServlet?action=wants"><label for="wants"><fmt:message key="gamehub.label.wants" /></label></a></li>
            <li><a href="BarterServlet?action=trade"><label for="trade"><fmt:message key="gamehub.label.trade" /></label></a></li>
            <li><a href="searchForGame.jsp"><label for="search"><fmt:message key="gamehub.label.search" /></label></a></li>
            <li><a href="aboutUs.jsp"><label for="aboutUs"><fmt:message key="gamehub.label.aboutUs" /></label></a></li>
            <li><a href="contactUs.jsp"><label for="contactUs"><fmt:message key="gamehub.label.contactUs" /></label></a></li>
        </ul></nav>
<%    
        }
%>
</header>
