<%-- 
    Document   : adminAddGame
    Created on : 20-Mar-2015, 05:10:09
    Author     : Luke
--%>
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
        <link rel="stylesheet" href="style.css" type="text/css" />
        <meta name="viewpoint" content="width=device-width, initial-scale=1.0">
        <title><label for="addGame"><fmt:message key="gamehub.label.addGame" /></label></title>
    </head>
    <body class="body">
        <jsp:include page="nav.jsp" />

        <div class="mainContent">
            <div class="content">
                <article class="topcontent">

                    <header>
                        <h2><a title="First post"><label for="addGame"><fmt:message key="gamehub.label.addGame" /></label></a></h2>
                    </header>

                    <form action="BarterServlet" method="post" name="formData">
                        <div>
                            <label>
                                <span><label for="title"><fmt:message key="gamehub.label.title" /></label>: </span>
                                <input name="title" type="text" tabindex="1" required autofocus>
                            </label>
                        </div>
                        <div>
                            <label>
                                <span><label for="platform"><fmt:message key="gamehub.label.platform" /></label>: </span>
                                <input name="platform" type="text" tabindex="2" required>
                            </label>
                        </div>
                        <div>
                            <label>
                                <span><label for="genre"><fmt:message key="gamehub.label.genre" /></label>: </span>
                                <input name="genre" type="text" tabindex="3" required>
                            </label>
                        </div>
                        <div>
                            <label>
                                <span><label for="quality"><fmt:message key="gamehub.label.quality" /></label>: </span>
                                <input name="quality"  min="0" max="5" tabindex="4" required>
                            </label>
                        </div>
                        <div>
                            <label>
                                <span><label for="price"><fmt:message key="gamehub.label.price" /></label>: </span>
                                <input name="price"  min="0" max="10000" tabindex="5" required>
                            </label>
                        </div>
                        <div>
                            <label>
                                <span><label for="Image"><fmt:message key="gamehub.label.Image" /></label> </span>
                                <input name="Image"  min="0" max="10000" tabindex="6" required>
                            </label>
                        </div>
                        <fmt:message key="gamehub.label.addGame" var="addGame" />              
                        <input type="hidden" name="action" value="${addGame}" />
                        <input type="submit" value="${addGame}"/>
                    </form>

                </article>                  

            </div>
        </div>

        <aside class="top-sidebar">
            <jsp:include page="topSidebarNav.jsp" />
            </br>
            <a href="editDetails.jsp"><label for="price"><fmt:message key="gamehub.label.editDetails" /></label></a>
        </aside>

        <aside class="middle-sidebar">
            <jsp:include page="adminSidebar.jsp" />
        </aside>

        <footer class="mainFooter">
            <p>Copyright &copy; 2015</p>
        </footer>
    </body>
</html>
