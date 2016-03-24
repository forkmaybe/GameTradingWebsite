<%-- 
    Document   : adminUsers
    Created on : 03-Mar-2015, 16:15:44
    Author     : d00133633
--%>

<%@page import="java.util.List"%>
<%@page import="Dtos.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="i18n.text" />
<!DOCTYPE html>
<%
    Object adminUserObject = session.getAttribute("loggedUser");
    User adminUser = (User) adminUserObject;
%>

<content>
    <table class="table">
        <%
            Object userObj = session.getAttribute("userList");
            List<User> userList = (List<User>) userObj;
            if (userList != null && userList.size() > 0) {
        %>

        <tr>
            <th><label for="username"><fmt:message key="gamehub.label.username" /></label> </th>
            <th><label for="country"><fmt:message key="gamehub.label.country" /></label> </th>
            <th><label for="balance"><fmt:message key="gamehub.label.balance" /></label> </th>
            <th><label for="isAdmin"><fmt:message key="gamehub.label.isAdmin" /></label> </th>
            <th></th>
        </tr>
        <%
            for (User user : userList) {
        %>      <%-- the id of the form is the users id so it can be deleted with the jQuery --%>
        <form action="BarterServlet" method="post" id=<%=user.getUserId()%>>
            <tr>
                <td><%= user.getUsername()%></td>
                <td><%= user.getCountry()%></td>
                <td><%= user.getBalance()%></td>
                <td><%= user.getIsAdmin()%></td>
                <%-- this input sends the user id to be removed from database --%>
                <td><input type="hidden" name="removeUser" value=<%=user.getUserId()%> />
                    <fmt:message key="gamehub.label.remove" var="remove" />  
                    <input type="hidden" name="action" value="removeUser" />
                    <input type="submit" value="${remove}" onClick="removeUser(<%=user.getUserId()%>)"/></td>
            </tr> 
            <%-- when the button is clicked, the users id is passed through to the function --%>
        </form>
        <%
                }
            }
        %>
    </table>
</content>
