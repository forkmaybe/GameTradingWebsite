<%@page language="java"%>
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
        <title>My Account</title>
        <link rel="stylesheet" href="style.css" type="text/css" />
        <meta name="viewpoint" content="width=device-width, initial-scale=1.0">

    </head>
    <body class="body">
        <jsp:include page="nav.jsp" />
        <div class="mainContent">
            <div class="content">
                <article class="topcontent">
                <%
    String message = (String) session.getAttribute("editMessage");
    String message2 = (String) session.getAttribute("fundsMessage");
        if(message != null)
        {
            out.println("<strong>" + message + "</strong>");
            session.removeAttribute("editMessage");//Makes null again.
        }
        else if(message2 != null){
            out.println("<strong>" + message2 + "</strong>");
            session.removeAttribute("fundsMessage");//Makes null again.
        }
                %>
               
                    <%
                            Object o = session.getAttribute("loggedUser");
                            User u = (User) o;
                        %>
                    <header>
                        <h2><a title="First post"> <label for="hi"><fmt:message key="gamehub.label.hi" /></label> <%= u.getFirstname() %></a></h2>
                    </header>
                    <content>
                       <label for="yourBalance"><fmt:message key="gamehub.label.yourBalance" /></label>: <%= u.getBalance() %>
                    </content>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
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
