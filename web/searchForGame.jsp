<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="i18n.text" />
<%@page import="Dtos.Game"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Search for game</title>
        <link rel="stylesheet" href="style.css" type="text/css" />
        <meta name="viewpoint" content="width=device-width, initial-scale=1.0">
    </head>
    <body class="body">

        <jsp:include page="nav.jsp" />
        <div class="mainContent">
            <div class="content">
                <article class="topcontent">
                    <header>
                        <h2><a title="Search"><label for="searchGame"><fmt:message key="gamehub.label.searchGame" /></label>:</a></h2>
                    </header>
                    <content>
                        <form action="BarterServlet" method="post">

                            <body>
                                <form action="BarterServlet" method="post" id="search">
                                    <center>
                                        <!--if the game attribute is null, display the search bar  -->
                                        <%
                                            if (session.getAttribute("game") == null) {

                                        %>
                                        <table>
                                            <tr>
                                                <td><label for="title"><fmt:message key="gamehub.label.title" /></label>: </td>
                                                <td> <input name="title" size=15 type="text" required autofocus/> </td> 
                                            </tr>
                                        </table>
                                        <fmt:message key="gamehub.label.search" var="search" />  
                                        <input type="hidden" name="action" value="search" />
                                        <input type="submit" value="${search}" />
                                </form>   
<<<<<<< HEAD
                                <!-- else, get the game attribute and display the details of the game.-->
                                <%                                } else {
=======
                                <%} else {
>>>>>>> origin/master
                                    Object obj = session.getAttribute("game");
                                    Game g = (Game) obj;
                                    if (session.getAttribute("game") != null) {
                                %>
                                <table class="table">
                                    <tr>
                                        <th> <label for="gameId"><fmt:message key="gamehub.label.gameId" /></label> </th>
                                        <th> <label for="title"><fmt:message key="gamehub.label.title" /></label> </th>
                                        <th> <label for="platform"><fmt:message key="gamehub.label.platform" /></label> </th>
                                        <th> <label for="genre"><fmt:message key="gamehub.label.genre" /></label> </th>
                                        <th> <label for="quality"><fmt:message key="gamehub.label.quality" /></label> </th>
                                        <th> <label for="price"><fmt:message key="gamehub.label.price" /></label> </th>
<<<<<<< HEAD
                                       
=======
                                        <th></th><th></th>
>>>>>>> origin/master
                                    </tr>

                                    <tr>
                                        <img src= "<%= g.getGameImage()%>" alt="alt text" height="225" width="200"/>
                                        <td><%= g.getGameId()%></td>
                                        <td><%= g.getTitle()%></td>
                                        <td><%= g.getPlatform()%></td>
                                        <td><%= g.getGenre()%></td>
                                        <td><%= g.getQuality()%></td>
                                        <td><%= g.getPrice()%></td>
                                        
                                    <% session.setAttribute("searchGameId", g.getGameId());%>
<<<<<<< HEAD

                                    <!-- buttons to add the game as a have or a want-->
=======
                                    <td>
>>>>>>> origin/master
                                    <form action="BarterServlet" method="post" id="add">
                                        <fmt:message key="gamehub.label.addHave" var="addHave" />  
                                        <input type="hidden" name="action" value="addHave"  />
                                        <input type="submit" value="${addHave}" />
                                    </form>
                                    </td>
                                    
                                    <form action="BarterServlet" method="post" id="add">  
                                    <td>    
                                        <fmt:message key="gamehub.label.addWant" var="addWant" />  
                                        <input type="hidden" name="action" value="addWant" />
                                        <input type="submit" value="${addWant}" />
                                    </td>    
                                    </form>
<<<<<<< HEAD
                                    
                                    <!-- clear the game attribute so search bar appears again when the page is refreshed-->
=======
                                    </tr>
                                    </table>
>>>>>>> origin/master
                                    <% }
                                    session.removeAttribute("game");
                                        }
                                    %>

                        </form>   
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                        </center>
                    </content>
                </article>
            </div>
        </div>
    <aside class="top-sidebar">
        <jsp:include page="topSidebarNav.jsp" />
    </aside>
    <aside class="middle-sidebar">
        <jsp:include page="adminSidebar.jsp" />
    </aside>
    <footer class="mainFooter">
        <p>Copyright &copy; 2015</p>
    </footer>
</body>
</html>
