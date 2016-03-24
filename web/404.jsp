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
        <title>404 Error</title>
        <link rel="stylesheet" href="style.css" type="text/css" />
        <meta name="viewpoint" content="width=device-width, initial-scale=1.0">

    </head>
    <body class="body">
        <jsp:include page="nav.jsp" />

        <div class="mainContent">
            <div class="content">
                <article class="topcontent">
                    <header>
                        <h2><a title="Error">404 <label for="error"><fmt:message key="gamehub.label.error" /></label></a></h2>
                    </header>
                    <content>

                        <div><label for="errorPage"><fmt:message key="gamehub.label.errorPage" /></label></div>
                        <div><a href="login.jsp"><label for="goBack"><fmt:message key="gamehub.label.goBack" /></label>.?</a></div>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
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
    </body>
</html>
