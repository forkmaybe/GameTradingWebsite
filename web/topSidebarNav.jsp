<%-- 
    Document   : topSidebarNav
    Created on : 19-Feb-2015, 12:49:48
    Author     : d00135791
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="i18n.text" />
<html lang="${language}" >

    <%
        if (session.getAttribute("loggedUser") == null || session.getAttribute("clientLoggedInId") == null) {
    %>
    <article>
        <a href="login.jsp"><label for="login"><fmt:message key="gamehub.label.login" /></label></a>
        </br>
        <a href="register.jsp"><label for="register"><fmt:message key="gamehub.label.register" /></label></a>
        </br>
        <a href="aboutUs.jsp"><label for="aboutUs"><fmt:message key="gamehub.label.aboutUs" /></label></a>
        </br>
        <a href="contactUs.jsp"><label for="contactUs"><fmt:message key="gamehub.label.contactUs" /></label></a>
        </br>  
        <form>
            <select id="language" name="language" onchange= "submit()">
                <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                <option value="fr" ${language == 'fr' ? 'selected' : ''}>Français</option>
                <option value="es" ${language == 'es' ? 'selected' : ''}>Español</option>
            </select>
        </form>
    </article>
    <%
    } else {
    %>
    <article>
        <a href="userAccount.jsp" ><label for="account"><fmt:message key="gamehub.label.account" /></label> </a>
        </br>
        <a href="addFunds.jsp"><label for="addFunds"><fmt:message key="gamehub.label.addFunds" /></label> </a>
        </br>
        <a href="editDetails.jsp"><label for="editDetails"><fmt:message key="gamehub.label.editDetails" /></label> </a>
        </br>
        <a href="BarterServlet?action=haves"><label for="haves"><fmt:message key="gamehub.label.haves" /></label> </a>
        </br>
        <a href="BarterServlet?action=wants"><label for="wants"><fmt:message key="gamehub.label.wants" /></label> </a>
        </br>
        <a href="BarterServlet?action=trade"><label for="trade"><fmt:message key="gamehub.label.trade" /></label> </a>
        </br>
        <a href="aboutUs.jsp"><label for="aboutGameHub"><fmt:message key="gamehub.label.aboutGameHub" /></label> </a>
        </br>
        <a href="contactUs.jsp"><label for="contactUs"><fmt:message key="gamehub.label.contactUs" /></label> </a>
        </br>
        <a href="BarterServlet?action=logOut"><label for="logOut"><fmt:message key="gamehub.label.logOut" /></label> </a>
        </br>  
        <form>
            <select id="language" name="language" onchange= "submit()">
                <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                <option value="fr" ${language == 'fr' ? 'selected' : ''}>Français</option>
                <option value="es" ${language == 'es' ? 'selected' : ''}>Español</option>
            </select>
        </form>
    </article>
    <%
        }
    %>
</html>
