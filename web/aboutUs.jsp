<%-- 
    Document   : AboutUs
    Created on : 13-Feb-2015, 09:36:33
    Author     : d00135791
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
        <title>AboutUs</title>
        <!-- copy next 2 lines -->
        <link rel="stylesheet" href="style.css" type="text/css" />
        <meta name="viewpoint" content="width=device-width, initial-scale=1.0">

    </head><!-- class="body" -->
    <body class="body">
        <!-- copy from this comment to line 36 including <content> -->
        <jsp:include page="nav.jsp" />

        <div class="mainContent">
            <div class="content">
                <article class="topcontent">
                    <header>
                        <h2><a title="About Us"><label for="aboutGameHub"><fmt:message key="gamehub.label.aboutGameHub" /></label></a></h2>
                    </header>
                    <content>
                        <p><label for="bio"><fmt:message key="gamehub.label.bio" /></label>.</p>
                    </content>

                </article>
                <article class="bottomcontent">
                    <header>
                        <h2><a title="Second post"><label for="members"><fmt:message key="gamehub.label.members" /></label></a></h2>
                    </header>
                    <content>
                        <p><label for="bioList"><fmt:message key="gamehub.label.bioList" /></label>.</p>
                        <p>Seán Enright</p>
                        <p>Luke Goss</p>
                        <p>Kenneth Clifford</p>
                        <p>Tiernan Whelan</p>
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

