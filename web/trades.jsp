
<%-- 
    Document   : trades
    Created on : 18-Mar-2015, 18:09:16
    Author     : d00135791
--%>

<%@page import="Dtos.Game"%>
<%@page import="Daos.GameDao"%>
<%@page import="Daos.TradeDao"%>
<%@page import="Daos.TradeDao"%>
<%@page import="Dtos.Trade"%>
<%@page import="java.util.List"%>
<%@page import="Dtos.User"%>
<%@page import="Daos.UserDao"%>
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
        <title>Active</title>
        <!-- copy next 2 lines -->
        <link rel="stylesheet" href="style.css" type="text/css" />
        <meta name="viewpoint" content="width=device-width, initial-scale=1.0">

    </head><!-- class="body" -->
    <body class="body">
        <jsp:include page="nav.jsp" />
        <div class="mainContent">
            <div class="content">
                <article class="topcontent">
                    <header>
                        <h2><a title="First post"><label for="actTrades"><fmt:message key="gamehub.label.actTrades" /></label></a></h2>
                    </header>
                    <%
                        //For use when trade is completed, string message.
                        //String message = (String) session.getAttribute("tradeCompMessage");

                        //If admin, view all trades, if not admin then view own trades.
                        User loggedUser = (User) session.getAttribute("loggedUser");
                        UserDao userDao = new UserDao();
                        GameDao gameDao = new GameDao();
                        List<Trade> trades = (List<Trade>) session.getAttribute("tradeList");
                        if (trades != null && trades.size() > 0) {
                    %>
                    <center>
                        <table class="table">
                            <tr>
                                <th> <label for="tradeNumber"><fmt:message key="gamehub.label.tradeNumber" /></label> </th>
                                <th> <label for="sender"><fmt:message key="gamehub.label.sender" /></label> </th>
                                <th> <label for="receiver"><fmt:message key="gamehub.label.receiver" /></label> </th>
                                <th> <label for="gameTitle"><fmt:message key="gamehub.label.gameTitle" /></label> </th>
                                <th> <label for="price"><fmt:message key="gamehub.label.price" /></label> </th>
                                <th> <label for="tradeStatus"><fmt:message key="gamehub.label.tradeStatus" /></label> </th>
                                <th></th>
                            </tr>
                            <%
                                Game g = null;
                                User u1 = null;
                                User u2 = null;
                                //if (true) {
                                //Output admin details.
                                //Output yout trades.
                                //When button is clicked, complete trade.
                                for (Trade t : trades) {
                                    g = gameDao.getGameById(t.getGameId());
                                    u1 = userDao.findUserById(t.getSenderId());
                                    u2 = userDao.findUserById(t.getReceiverId());
                                    if (loggedUser.getUserId() == t.getReceiverId()) {
                            %>
                            <form action="BarterServlet" method="post" id="tradeId">
                                <tr>
                                    <td><%= t.getTradeId()%></td>
                                    <td><%= u1.getUsername()%></td>
                                    <td><%= u2.getUsername()%></td>
                                    <td><%= g.getTitle()%></td>
                                    <td><%= t.getPrice()%></td>
                                    <td><% if (t.isIsComplete()) { %> <label for="complete"><fmt:message key="gamehub.label.complete" /></label> <% } else {%><label for="incomplete"><fmt:message key="gamehub.label.incomplete" /></label>e<%}%> </td>
                                    <td>
                                        <%
                                            if (t.isIsComplete()) {
                                        %>
                                        <input type="submit" value="Trade complete." disabled/>
                                        <%
                                        } else {
                                        %>
                                        <input type="hidden" name="tradeId" value=<%= t.getTradeId()%> />
                                        <input type="hidden" name="action" value="completeTrade" />
                                        <input type="submit" value="Complete Trade"/>
                                    </td>
                                    <%--
                                    This button is for completing trades.
                                    --%>
                                    <%
                                        }
                                    %>
                                </tr>
                            </form>
                            <%
                                }else if(loggedUser.getUserId() == t.getSenderId()){
                                    //Print out trade with no complete button.
                                    
                            %>
                            <tr>
                                    <td><%= t.getTradeId()%></td>
                                    <td><%= u1.getUsername()%></td>
                                    <td><%= u2.getUsername()%></td>
                                    <td><%= g.getTitle()%></td>
                                    <td><%= t.getPrice()%></td>
                                    <td><% if(t.isIsComplete()){ %>Completed.<% }else{ %>InComplete.<% } %></td>
                                    <td><input type="submit" value="Disabled." disabled/></td>
                            </tr>
                            <%
                                }
                                }  
                        }
                            %>
                        </table>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                    </center>

                    <content>
                        <%--TODO--%>
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
        <!-- to here -->

    </body>
</html>