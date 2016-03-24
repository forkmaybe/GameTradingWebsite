<%-- 
    Document   : Haves
    Created on : 12-Feb-2015, 11:56:11
    Author     : d00135791
--%>

<%@page import="Daos.GameDao"%>
<%@page import="Dtos.Game"%>
<%@page import="Dtos.Haves"%>
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
        <title>My Haves.</title>
        <link rel="stylesheet" href="style.css" type="text/css" />
        <meta name="viewpoint" content="width=device-width, initial-scale=1.0">
        <script>
            function removeHave(id) {
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
                        <h2><a title="First post"><label for="haves"><fmt:message key="gamehub.label.haves" /></label></a></h2>
                    </header>
                    <br>
                    <form action="BarterServlet" method="post" id="haves">
                        <table class="table">
                            
                            <!-- if the users haves list isn't empty, displays the list of the logged in users haves-->
                            <%
                                Object haveObj = session.getAttribute("haveList");
                                GameDao gDao = new GameDao();
                                List<Haves> haveList = (List<Haves>) haveObj;
                                if (haveList != null && haveList.size() > 0) {
                            %>
                            <tr>
                                <th></th>
                                <th> <label for="gameId"><fmt:message key="gamehub.label.gameId" /></label> </th>
                                <th> <label for="title"><fmt:message key="gamehub.label.title" /></label> </th>
                                <th> <label for="platform"><fmt:message key="gamehub.label.platform" /></label> </th>
                                <th> <label for="genre"><fmt:message key="gamehub.label.genre" /></label> </th>
                                    <%--<th> <label for="quality"><fmt:message key="gamehub.label.quality" /></label> </th>--%>
                                <th> <label for="price"><fmt:message key="gamehub.label.price" /></label> </th>
                                <th></th>
                            </tr>
                            <%
                                for (Haves h : haveList) {
                                    int id2 = h.getGameId();
                                    Game g = gDao.getGameById(id2);
                            %>
                            <form action="BarterServlet" method="post" id="haves">
                                <tr class="post">
                                    <td> <img src= "<%= g.getGameImage()%>" alt="alt text" height="50" width="50"/></td>
                                    <td><%= h.getGameId()%></td>
                                    <td><%= g.getTitle()%></td>
                                    <td><%= g.getPlatform()%></td>
                                    <td><%= g.getGenre()%></td>
                                    <%--<td><%= g.getQuality()%></td>--%>
                                    <td><%= h.getSellingPrice()%></td>
                                    <%--<input type="hidden" name="action" value="addWant" />
                                    <td><input type="submit" value=<% addWant(<%=w.getWantId()%>)%> /></td>--%>
                                    
                                    <!-- button to remove the have selected-->
                                    <td><input type="hidden" name="removeHave" value=<%=h.getHaveId()%> />
                                        <fmt:message key="gamehub.label.remove" var="remove" />  
                                        <input type="hidden" name="action" value="removeHave"/>
                                        <input type="submit" value="${remove}" onClick="removeHave(<%= h.getHaveId()%>"/></td>
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
