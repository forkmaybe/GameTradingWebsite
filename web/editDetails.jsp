<%@page import="Dtos.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
        <fmt:setLocale value="${language}"/>
        <fmt:setBundle basename="i18n.text" />
        <title><label for="editDetails"><fmt:message key="gamehub.label.editDetails" /></label></title>

        <link rel="stylesheet" href="style.css" type="text/css" />
        <meta name="viewpoint" content="width=device-width, initial-scale=1.0">

        <script type="text/javascript">
            function validate() {
                if (document.formData.confirmPassword.value !== document.formData.newPassword.value) //Checks if both passwords are the same
                {
                    alert("Passwords are not the same");
                    document.formData.newPassword.value = "";
                    document.formData.confirmPassword.value = "";
                    document.formData.newPassword.focus();

                }
            }
        </script>

    </head>
    <body class="body">
        <!-- copy from this comment to line 36 including <content> -->
        <jsp:include page="nav.jsp" />

        <div class="mainContent">
            <div class="content">
                <article class="topcontent">
                    <header>
                        <h2><a title="Edit Details"><label for="editDetails"><fmt:message key="gamehub.label.editDetails" /></label></a></h2>
                    </header>

                    <content>        

                        <%
                            User useMe = (User) session.getAttribute("loggedUser");
                        %>

                        <form action="BarterServlet" method="post" name="formData">
                            <table>
                                <tr>
                                    <td><label for="fName"><fmt:message key="gamehub.label.fName" /></label>:</td><td> <input name="firstName" size=20 type="text" value=<%=useMe.getFirstname()%>   /> </td> 
                                </tr>
                                <tr>
                                    <td><label for="lName"><fmt:message key="gamehub.label.lName" /></label>:</td><td> <input name="lastName" size=20 type="text" value=<%=useMe.getLastname()%> /> </td> 
                                </tr>
                                <tr>
                                    <td><label for="username"><fmt:message key="gamehub.label.username" /></label>:</td><td> <input name="username" size=20 type="text" value=<%=useMe.getUsername()%> /> </td> 
                                </tr>
                                <tr>
                                    <td><label for="newPassword"><fmt:message key="gamehub.label.newPassword" /></label>:</td><td> <input name="newPassword" size=20 type="password" required /> </td> 
                                </tr>
                                <tr>
                                    <td><label for="confirmNewPassword"><fmt:message key="gamehub.label.confirmNewPassword" /></label>:</td><td> <input name="confirmPassword" size=20 type="password" required  /> </td> 
                                </tr>
                                <tr>
                                    <td><label for="address"><fmt:message key="gamehub.label.address" /></label>:</td><td> <input name="address" size=20 type="text" value=<%=useMe.getAddress()%> /> </td> 
                                </tr>
                                <tr>
                                    <td><label for="city"><fmt:message key="gamehub.label.city" /></label>:</td><td> <input name="city" size=20 type="text" value=<%=useMe.getCity()%> /> </td> 
                                </tr>
                                <tr>
                                    <td><label for="country"><fmt:message key="gamehub.label.country" /></label>:</td><td> <input name="country" size=20 type="text" value=<%=useMe.getCountry()%> /> </td> 
                                </tr>
                            </table>
                            <fmt:message key="gamehub.label.editDetails" var="editDetails" /> 
                            <input type="hidden" name="action" value="editDetails" />
                            <input type="submit" value="${editDetails}" onclick="validate()" />
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