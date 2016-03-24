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
        <title>Login</title>
        <link rel="stylesheet" href="style.css" type="text/css" />
        <meta name="viewpoint" content="width=device-width, initial-scale=1.0">
    </head>
    <body class="body">
    <jsp:include page="nav.jsp" />
    <div class="mainContent">
        <div class="content">
            <article class="topcontent">
                <header>
                    <h2><a title="Login Area"><label for="loginArea"><fmt:message key="gamehub.label.loginArea" /></label></a></h2>
                </header>
                <content>
                    
<%
    String message = (String) session.getAttribute("loginMessage");
        if(message != null)
        {
            out.println("<strong>" + message + "</strong>");
            session.removeAttribute("loginMessage");//Makes null again.
        }
%>
                    <form action="BarterServlet" method="post" id="login">
                    <center>
                        <table>
                            <tr>
                                <td><label for="username"><fmt:message key="gamehub.label.username" /></label>: </td><td> <input name="username" size=15 type="text" required autofocus/> </td> 
                            </tr>
                            <tr>
                                <td><label for="password"><fmt:message key="gamehub.label.password" /></label>: </td><td> <input name="password" size=15 type="password" required/> </td> 
                            </tr>
                        </table>
                         <fmt:message key="gamehub.label.login" var="login" />     
                        <input type="hidden" name="action" value="${login}" />
                        <input type="submit" value="${login}" />
                        <a href="register.jsp"><label for="register"><fmt:message key="gamehub.label.register" /></label>?</a>
                    </center>
                </form>
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



