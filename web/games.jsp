<%-- 
    Document   : games
    Created on : 13-Mar-2015, 12:58:38
    Author     : d00135791
--%>

<%@page import="Daos.GameDao"%>
<%@page import="Dtos.Game"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="i18n.text" />
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Games.</title>
        <link rel="stylesheet" href="style.css" type="text/css" />
        <meta name="viewpoint" content="width=device-width, initial-scale=1.0">
    </head>
    <body class="body">
        <div class="page">
            <jsp:include page="nav.jsp" />
            <div class="mainContent">
                <div class="content">
                    <article class="topcontent">
                        <header>
                            <h2><a title="First post"><label for="fName"><fmt:message key="gamehub.label.allGames" /></label></a></h2>
                        </header>
                        <br>
                        <%
                            //String message = (String) session.getAttribute("allGameMessage");
                            //if (message != null) {
                            //    out.println("<strong>" + message + "</strong>");
                            //    session.removeAttribute("allGameMessage");//Makes null again.
                            //}
                            //Get all games and print them here.
                            Object obj = session.getAttribute("gameList");
                            List<Game> gameList = (List<Game>) obj;
                            GameDao gDao = new GameDao();
                            if (gameList != null && gameList.size() > 0) {

                        %>
                        <table class="table">
                            <tr>
                                <th></th>
                                <th><label for="gameId"><fmt:message key="gamehub.label.gameId" /></label></th>
                                <th><label for="title"><fmt:message key="gamehub.label.title" /></label></th>
                                <th><label for="platform"><fmt:message key="gamehub.label.platform" /></label></th>
                                <th><label for="genre"><fmt:message key="gamehub.label.genre" /></label></th>
                                    <%--<th> Quality <th>--%>
                                <th><label for="suggestedprice"><fmt:message key="gamehub.label.suggestedprice" /></label></th>
                                <th></th>
                            </tr>
                            
                                    <%
                                for (Game g : gameList) {
                                    %>

                                    <form action="BarterServlet" method="post">
                                        <tr class="post">
                                            <td> <img src= "<%= g.getGameImage()%>" alt="alt text" height="50" width="50"/></td>
                                            <td><%= g.getGameId()%></td>
                                            <td><%= g.getTitle()%></td>
                                            <td><%= g.getPlatform()%></td>
                                            <td><%= g.getGenre()%></td>
                                            <%--<td><%= g.getQuality()%></td>--%>
                                            <td>
                                                €<c:set var="val" value="<%=g.getPrice()%>" />
                                                <fmt:formatNumber value="${val}" />
                                            </td>
                                            <td>

                                                <input type="hidden" name="gameId" value=<%= g.getGameId()%> />
                                                <fmt:message key="gamehub.label.viewGame" var="viewGame" />  
                                                <input type="hidden" name="action" value="viewGame" />
                                                <input type="submit" value="${viewGame}"/>
                                            </td>
                                        </tr>
                                    </form>

                                    <%
                                        }
                                    %>

                                    <%
                                        }
                                    %>
                                
                        </table>

                        <div class="pagination">
                        </div>

                    </article>
                </div>
            </div>
            <aside class="top-sidebar">
                <jsp:include page="topSidebarNav.jsp" />
            </aside>
            <aside class="middle-sidebar">
                <jsp:include page="adminSidebar.jsp" />
            </aside>
            <%--
            <aside class="bottom-sidebar">
                <br>
            </aside>
            --%>
            <footer class="mainFooter">
                <p>Copyright &copy; 2015</p>
            </footer>


        </div>
        <script src="js/jquery.js"></script>
        <script src="js/paginate.js"></script>
        <script src="js/custom.js"></script>
    </body>
</html>
