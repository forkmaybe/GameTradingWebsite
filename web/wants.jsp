<%-- 
    Document   : Wants
    Created on : 11-Feb-2015, 21:38:50
    Author     : Arc
--%>

<%@page import="Dtos.Game"%>
<%@page import="Daos.GameDao"%>
<%@page import="Dtos.Wants"%>
<%@page import="java.util.List"%>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wants Test</title>

        <link rel="stylesheet" href="style.css" type="text/css" />
        <meta name="viewpoint" content="width=device-width, initial-scale=1.0">
        <script>
            function removeWant(id) {
                $("#" + id).remove();
            }
        </script>
    </head>
    <body class="body">
        <jsp:include page="nav.jsp" />

        <div class="mainContent">
            <div class="content">
                <article class="topcontent">
                    <header>
                        <h2><a title="First post"><label for="wants"><fmt:message key="gamehub.label.wants" /></label></a></h2>
                    </header>
                    <br>
                    
                    <!-- if the users wants list isn't empty, displays the list of the logged in users wants-->
                        <%
                            Object wantObj = session.getAttribute("wantList");
                            List<Wants> wantList = (List<Wants>) wantObj;
                            GameDao gDao = new GameDao();
                            if (wantList != null && wantList.size() > 0) {
                        %>

                        <table class="table">
                            <tr>
                                <th></th>
                                <th> <label for="gameId"><fmt:message key="gamehub.label.gameId" /></label> </th>
                                <th> <label for="title"><fmt:message key="gamehub.label.title" /></label> </th>
                                <th> <label for="platform"><fmt:message key="gamehub.label.platform" /></label> </th>
                                <th> <label for="genre"><fmt:message key="gamehub.label.genre" /></label> </th>
                                <th> <label for="price"><fmt:message key="gamehub.label.price" /></label> </th>
                                <th></th>
                            </tr>
                            <%
                                for (Wants w : wantList) {
                                    int id3 = w.getGameId();
                                    Game g = gDao.getGameById(id3);
                            %> 

                            <form action="BarterServlet" method="post" id="wants">

                            <tr class="post">
                                <td> <img src= "<%= g.getGameImage()%>" alt="alt text" height="50" width="50"/></td>
                                <td><%= w.getGameId()%></td>
                                <td><%= g.getTitle()%></td>
                                <td><%= g.getPlatform()%></td>
                                <td><%= g.getGenre()%></td>
                                <td><%= w.getMaxPrice()%></td>

                                <!-- button to remove the want selected-->
                                <td><input type="hidden" name="removeWant" value=<%=w.getWantId()%> />
                                    <fmt:message key="gamehub.label.remove" var="remove" />  
                                    <input type="hidden" name="action" value="removeWant" />
                                    <input type="submit" value="${remove}" onClick="removeWant(<%=w.getWantId()%>"/></td>
                            </tr>
                        </form>    
                            <%
                                    }
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
        
        <script src="js/jquery.js"></script>
        <script src="js/paginate.js"></script>
        <script src="js/custom.js"></script>

    </body>
</html>
