<%-- 
    Document   : Home
    Created on : 13-Feb-2015, 09:38:38
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
        <title>Home</title>

        <link rel="stylesheet" href="style.css" type="text/css" />
        <meta name="viewpoint" content="width=device-width, initial-scale=1.0">

    </head>
    <body class="body">
        <jsp:include page="nav.jsp" />
        <div class="mainContent">
            <div class="content">
                <article class="topcontent">
                    <header>
                        <h2><a title="home"><label for="home"><fmt:message key="gamehub.label.home" /></label></a></h2>
                    </header>
                    <content>
                        <p>Lets trade games.</p>
                        <div class="slider">
                            <a class="previousLink" href="#">←</a>
                            
                            <a class="nextLink" href="#">→</a>
                            <div class="frame">
                                <a href="games.jsp" class="image-shown"><img  src="img/lego.jpg" alt="lego" /></a>
                                <a  href="games.jsp" class="image-hidden"><img  src="img/massEffect.jpg" alt="mass effect" /></a>
                                <a  href="games.jsp" class="image-hidden"><img src="img/starcraft.jpg" alt="starcraft" /></a>
                                <a  href="games.jsp" class="image-hidden"><img src="img/tombRaider.jpg" alt="tomb raider" /></a>
                            </div>
                            
                        </div>
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

        <%--
        <aside class="bottom-sidebar">
            <br>
        </aside>
        --%>

        <footer class="mainFooter">
            <p>Copyright &copy; 2015</p>
        </footer>                      

        <script src="js/jquery.js"></script>
        <script src="js/imageSlider.js"></script>

    </body>

</html>
