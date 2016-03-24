<%-- 
    Document   : singleGame
    Created on : 18-Mar-2015, 17:07:39
    Author     : d00135791
--%>
<%@page import="Daos.UserDao"%>
<%@page import="Daos.GameDao"%>
<%@page import="Daos.WantsDao"%>
<%@page import="Dtos.Game"%>
<%@page import="Dtos.User"%>
<%@page import="Dtos.Haves"%>
<%@page import="Dtos.Wants"%>
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
        <title>Single game.</title>
        <link rel="stylesheet" href="style.css" type="text/css" />
        <meta name="viewpoint" content="width=device-width, initial-scale=1.0">
    </head>
    <body class="body">
        <jsp:include page="nav.jsp" />
        <div class="mainContent">
            <div class="content">
                <article class="topcontent">
                    <header>
                        <h2><a title="Single game."><label for="singleGame"><fmt:message key="gamehub.label.singleGame" /></label></a></h2>
                    </header>
                    <%
                        //Get all games and print them here.
                        UserDao userDao = new UserDao();
                        //String message = (String) session.getAttribute("singleMessage");
                        //if (message != null) {
                        //    out.println("<strong>" + message + "</strong>");
                        //}
                        User u = (User) session.getAttribute("loggedUser");
                        Object obj = session.getAttribute("singleGame");
                        Game g = (Game) obj;
                        if (g != null) {
                    %>
                    <center>
                        <img src= "<%= g.getGameImage()%>" alt="alt text" height="225" width="200"/>    
                        <table class="table">
                            <tr>
                                <th> <label for="gameId"><fmt:message key="gamehub.label.gameId" /></label> </th>
                                <th> <label for="title"><fmt:message key="gamehub.label.title" /></label> </th>
                                <th> <label for="platform"><fmt:message key="gamehub.label.platform" /></label> </th>
                                <th> <label for="genre"><fmt:message key="gamehub.label.genre" /></label> </th>
                                    <%--<th> <label for="quality"><fmt:message key="gamehub.label.quality" /></label> </th>--%>
                                <th> <label for="price"><fmt:message key="gamehub.label.price" /></label> </th>
                            </tr>
                            <tr>
                                <td><%= g.getGameId()%></td>
                                <td><%= g.getTitle()%></td>
                                <td><%= g.getPlatform()%></td>
                                <td><%= g.getGenre()%></td>
                                <%--<td><%= g.getQuality()%></td>--%>
                                <td>€<%= g.getPrice()%></td>
                            </tr>
                            <%
                                }
                            %>
                        </table>
                        <header>
                            <h2><a>
                                    <label for="userHave"><fmt:message key="gamehub.label.userHave" /></label><%= g.getTitle()%>.
                                </a>
                            </h2>
                        </header>
                        <table class="table">
                            <%
                                //Get all games and print them here.
                                Object objHaves = session.getAttribute("usersWhoHave");

                                List<Haves> usersWhoHave = (List<Haves>) objHaves;
                                if (usersWhoHave != null) {
                            %>

                            <tr>
                                <%--<th> UserId </th>--%>
                                <th> <label for="gameId"><fmt:message key="gamehub.label.username" /></label> </th>
                                <th> <label for="title"><fmt:message key="gamehub.label.title" /></label> </th>
                                <th> <label for="platform"><fmt:message key="gamehub.label.platform" /></label> </th>
                                    <%--<th> <label for="gameId"><fmt:message key="gamehub.label.quality" /></label> </th>--%>
                                <th> <label for="gameId"><fmt:message key="gamehub.label.sell" /></label> </th>
                                <th>  </th>
                            </tr>
                            <%
                                for (Haves h : usersWhoHave) {
                                    User uH = userDao.findUserById(h.getUserId());
                                    //This is returning 0 for the userid i think.....
                                    session.setAttribute("Test h.userId", h.getUserId());
                                    //session.setAttribute("TEST THIS FROM SINGLE", userDao.findUserById(h.getUserId()));
                                    if (uH.getUserId() == u.getUserId()) {
                                        //Don't print it.....
                                    } else {
                            %>
                            <form action="BarterServlet" method="post" value="buyGame">
                                <tr>
                                    <%--<td><%= uH.getUserId() %></td>--%>
                                    <td><%= uH.getUsername()%></td>
                                    <td><%= g.getTitle()%></td>
                                    <td><%= g.getPlatform()%></td>
                                    <%--<td><%= g.getQuality()%></td>--%>
                                    <td><%= g.getPrice()%></td>
                                    <%//Need to check if i have enough money to buy the item.
                                        if (u.getBalance() > g.getPrice()) {
                                            //Then print buy button.
%>
                                    <td><input type="hidden" name="haveId" value=<%= h.getHaveId()%> />
                                        <input type="hidden" name="action" value="buyGame"/>
                                        <input type="submit" value="BuyGame"/>
                                    </td>
                                    <%
                                    } else {
                                        //print button diabled though.
                                    %>
                                    <td>
                                        <input type="submit" value="BuyGame" disabled/>
                                    </td>
                                    <%
                                            }
                                        }
                                    %>
                                </tr>

                                <%
                                    }
                                } else {
                                %>
                                <tr>
                                    <th></th>
                                </tr>    
                                <td><label for="noUserhas"><fmt:message key="gamehub.label.noUserhas" /></label> <%= g.getTitle()%></td>
                                <%
                                    }
                                %>
                            </form> 
                        </table>
                        <header>
                            <h2><a><label for="userWant"><fmt:message key="gamehub.label.userWant" /></label> <%= g.getTitle()%>.</a></h2>
                        </header>
                        <table class="table">
                            <%
                                //Get all games and print them here.
                                Object obj2 = session.getAttribute("usersWhoWant");
                                List<Wants> usersWhoWant = (List<Wants>) obj2;
                                if (usersWhoWant != null) {
                            %>
                            <tr>
                                <%--<th> UserId </th>--%>
                                <th> <label for="gameId"><fmt:message key="gamehub.label.username" /></label> </th>
                                <th> <label for="gameId"><fmt:message key="gamehub.label.title" /></label> </th>
                                <th> <label for="gameId"><fmt:message key="gamehub.label.platform" /></label>  </th>
                                <th> <label for="gameId"><fmt:message key="gamehub.label.quality" /></label> </th>
                                <th> <label for="gameId"><fmt:message key="gamehub.label.maxPrice" /></label> </th>
                                <th>  </th>
                            </tr>
                            <%
                                for (Wants w : usersWhoWant) {
                                    User uW = userDao.findUserById(w.getUserId());
                            %>
                            <form action="BarterServlet" method="post" value="sellGame">
                                <tr>
                                    <%--<td><%= u.getUserId()%></td>--%>
                                    <td><%= uW.getUsername()%></td>
                                    <td><%= g.getTitle()%></td>
                                    <td><%= g.getPlatform()%></td>
                                    <td><%= g.getQuality()%></td>
                                    <td><%= w.getMaxPrice()%></td>
                                    <%//Need to check if i have enough money to buy the item.
                                        if (u.getBalance() > w.getMaxPrice()) {
                                            //Then print buy button.
%>
                                    <td><input type="hidden" name="wantId" value=<%= w.getWantId()%> />
                                        <input type="hidden" name="action" value="sellGame" />
                                        <input type="submit" value="SellGame"/>
                                    </td>
                                    <%
                                    } else {
                                        //Print button diabled though.
%>
                                    <td><input type="hidden" name="wantId" value=<%= w.getWantId()%> />
                                        <input type="hidden" name="action" value="sellGame" />
                                        <input type="submit" value="SellGame" disabled/>
                                    </td>
                                    <%
                                        }
                                    %>
                                </tr>
                            </form>
                        </table>


                        <%
                            }
                        } else {
                        %>
                        <tr>
                            <th></th>
                        </tr>    
                        <td><label for="noUserwants"><fmt:message key="gamehub.label.noUserwants" /></label> <%= g.getTitle()%></td>
                        <%
                            }
                        %>
                        <br><br><br><br><br>
                    </center>
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
