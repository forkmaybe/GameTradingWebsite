<%-- 
    Document   : adminAccount
    Created on : 26-Feb-2015, 10:46:28
    Author     : d00133633
--%>

<%@page import="Daos.UserDao"%>
<%@page import="java.util.List"%>
<%@page import="Dtos.User"%>
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
        <title>Admin Account</title>
        <link rel="stylesheet" href="style.css" type="text/css" />
        <meta name="viewpoint" content="width=device-width, initial-scale=1.0">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script>
            function removeUser(id) {//called by remove user button, id of form is the users id
                $("#" + id).remove();    //removes the form with the table and button inside
            }                         //the user's id matches its form's id so it can be removed
            function removeGame(id) {
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
                        <h2><a title="First post"><label for="user"><fmt:message key="gamehub.label.user" /></label></a></h2>
                    </header>
                    <jsp:include page="adminUsers.jsp" />
                    
                </article>

                <article class="bottomcontent">
                    <header>
                        <h2><a title="Second post"><label for="game"><fmt:message key="gamehub.label.game" /></label></a></h2>
                    </header>

                    <jsp:include page="adminGames.jsp" />
                    
                </article>
            </div>
        </div>

        <aside class="top-sidebar">
            <jsp:include page="topSidebarNav.jsp" />
            </br>
            <%--<a href="editDetails.jsp"><label for="editDetails"><fmt:message key="gamehub.label.editDetails"/></label></a>--%>
        </aside>

        <aside class="middle-sidebar">
            <jsp:include page="adminSidebar.jsp" />
        </aside>

        <footer class="mainFooter">
            <p>Copyright &copy; 2015</p>
        </footer>

        <script src="js/jquery.js"></script>
        <script src="js/paginate.js"></script>
        <script src="js/custom.js"></script>

    </body>
</html>
