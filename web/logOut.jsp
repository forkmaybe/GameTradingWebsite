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
        <title>Logged Out</title>

        <link rel="stylesheet" href="style.css" type="text/css" />
        <meta name="viewpoint" content="width=device-width, initial-scale=1.0">
    </head>

    <body class="body">
    <jsp:include page="nav.jsp" />
        <div class="mainContent">
            <div class="content">
                <article class="topcontent">
                    <header>
                        <h2><a title="Logged Out"><label for="loggedOut"><fmt:message key="gamehub.label.loggedOut" /></label></a></h2>
                    </header>

                    <content>

                        <center>
                            <h1><label for="loggedOut"><fmt:message key="gamehub.label.loggedOut" /></label></h1>
                            <div><label for="youloggedOut"><fmt:message key="gamehub.label.youloggedOut" /></label></div>
                            <a href="login.jsp"><label for="goBack"><fmt:message key="gamehub.label.goBack" /></label></a>
                        </center>

                    </content>
                </article>

            </div>
        </div>

        <aside class="top-sidebar">
            <jsp:include page="topSidebarNav.jsp" />
        </aside>

        <footer class="mainFooter">
            <p>Copyright &copy; 2015</p>
        </footer>                         
    </body>
</html>