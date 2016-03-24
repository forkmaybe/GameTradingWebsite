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
        <title>Register</title>

        <link rel="stylesheet" href="style.css" type="text/css" />
        <meta name="viewpoint" content="width=device-width, initial-scale=1.0">

        <script type="text/javascript">
            function validate() {
                if (document.formData.cPassword.value !== document.formData.password.value) //Checks if both passwords are the same
                {
                    alert("Passwords are not the same");
                    document.formData.password.value = "";
                    document.formData.cPassword.value = "";
                    document.formData.password.focus();

                }
            }
        </script>

    </head>
    <body class="body">
        <jsp:include page="nav.jsp" />

        <div class="mainContent">
            <div class="content">
                <article class="topcontent">
                    <header>
                        <h2><a title="Register"><label for="register"><fmt:message key="gamehub.label.register" /></label></a></h2>
                    </header>

                    <content>
<%
    String message = (String) session.getAttribute("regMessage");
        if(message != null)
        {
            out.println("<strong>" + message + "</strong>");
            session.removeAttribute("regMessage");//Makes null again.
        }
%>
                        <form action="BarterServlet" method="post" name="formData">
                            <div>
                                <label>
                                    <span><label for="fName"><fmt:message key="gamehub.label.fName" /></label>: </span>
                                    <input name="firstName" type="text" tabindex="1" required autofocus>
                                </label>
                            </div>
                            <div>
                                <label>
                                    <span><label for="lName"><fmt:message key="gamehub.label.lName" /></label>: </span>
                                    <input name="lastName" type="text" tabindex="2" required>
                                </label>
                            </div>
                            <div>
                                <label>
                                    <span><label for="username"><fmt:message key="gamehub.label.username" /></label>: </span>
                                    <input name="username" type="text" tabindex="3" required>
                                </label>
                            </div>
                            <div>
                                <label>
                                    <span><label for="password"><fmt:message key="gamehub.label.password" /></label>: </span>
                                    <input name="password" type="password" tabindex="4" required>
                                </label>
                            </div>
                            <div>
                                <label>
                                    <span><label for="confirmPassword"><fmt:message key="gamehub.label.confirmPassword" /></label>: </span>
                                    <input name="cPassword" type="password" tabindex="5" required>
                                </label>
                            </div>
                            <div>
                                <label>
                                    <span><label for="address"><fmt:message key="gamehub.label.address" /></label>: </span>
                                    <input name="address" type="text" tabindex="6" required>
                                </label>
                            </div>
                            <div>
                                <label>
                                    <span><label for="city"><fmt:message key="gamehub.label.city" /></label>: </span>
                                    <input name="city" type="text" tabindex="7" required>
                                </label>
                            </div>
                            <div>
                                <label>
                                    <span><label for="country"><fmt:message key="gamehub.label.country" /></label>: </span>
                                    <input name="country" type="text" tabindex="8" required>
                                </label>
                            </div>
                            <fmt:message key="gamehub.label.register" var="register" />          
                            <input type="hidden" name="action" value="${register}" />
                            <input type="submit" value="${register}" onclick="validate()"/>
                        </form>

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
