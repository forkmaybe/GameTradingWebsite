<%-- 
    Document   : adminGames
    Created on : 03-Mar-2015, 15:25:07
    Author     : d00133633
--%>

<%@page import="java.util.List"%>
<%@page import="Dtos.Game"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="i18n.text" />
<!DOCTYPE html>


<header>

</header>
<content>
    <%
        Object gameObj = session.getAttribute("gameList");
        List<Game> gameList = (List<Game>) gameObj;
        if (gameList != null && gameList.size() > 0) {
    %>
    <table class="table">
        <tr>
            <th> <label for="title"><fmt:message key="gamehub.label.title" /></label> </th>
            <th> <label for="platform"><fmt:message key="gamehub.label.platform" /></label> </th>
            <th> <label for="quality"><fmt:message key="gamehub.label.quality" /></label> </th>
            <th> <label for="price"><fmt:message key="gamehub.label.price" /></label> </th>
            <th></th>
        </tr>
        <%
            for (Game game : gameList) {

        %>      <%-- the id of the form is the game's id so it can be deleted with the jQuery --%>
        <form action="BarterServlet" method="post" id=<%=game.getGameId()%>>

            <tr class="post">
                <td><%= game.getTitle()%></td>
                <td><%= game.getPlatform()%></td>
                <td><%= game.getQuality()%></td>
                <td><%= game.getPrice()%></td>
                <%-- this input sends the game id to be removed from database --%>
                <td><input type="hidden" name="removeGame" value=<%=game.getGameId()%> />
                    <fmt:message key="gamehub.label.remove" var="remove" />  
                    <input type="hidden" name="action" value="removeGame" />
                    <input type="submit" value="${remove}" onClick="removeGame(<%=game.getGameId()%>)"/></td>
                    <%-- when the button is clicked, the users id is passed through to the function --%>
            </tr>
        </form>
        <%
                }
            }
        %>
    </table>
    <div class="pagination">
    </div>
</content>