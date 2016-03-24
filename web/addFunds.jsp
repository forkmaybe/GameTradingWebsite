<%-- 
    Document   : addFunds
    Created on : 13-Feb-2015, 11:44:30
    Author     : d00134372
--%>
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
        <title><label for="addFunds"><fmt:message key="gamehub.label.addFunds" /></label></title>
        <!-- copy next 2 lines -->
        <link rel="stylesheet" href="style.css" type="text/css" />
        <meta name="viewpoint" content="width=device-width, initial-scale=1.0">

        <script type="text/javascript">

            function valid_credit_card(value)
            {
            value = document.formData.cNumber.value;
                    // accept only digits, dashes or spaces
                    if (/[^0-9-\s]+/.test(value)) return false;
                    // The Luhn Algorithm. 
                    var nCheck = 0, nDigit = 0, bEven = false;
                    value = value.replace(/\D/g, "");
                    //Counting from the check digit, which is the rightmost, and moving left, double the value of every second digit.
                    for (var n = value.length - 1; n >= 0; n--)
            {
            var cDigit = value.charAt(n),
                    nDigit = parseInt(cDigit, 10);
                    if (bEven)
            {
            if ((nDigit *= 2) > 9) nDigit -= 9;
            }

            //Sum the digits of the products together with the undoubled digits from the original number.
            nCheck += nDigit;
                    bEven = !bEven;
            }

            //If the total modulo 10 is equal to 0 then the number is valid according to the Luhn formula; else it is not valid.
            if (nCheck % 10 == 0)
            {
                alert("credit card number is valid");
            }
            else
            {
                alert("credit card number is not valid");
                return false;
            }
        }


        </script>

    </head>
    <body class="body">
        <jsp:include page="nav.jsp" />
        <div class="mainContent">
            <div class="content">
                <article class="topcontent">
                    <content>
                        <h1><label for="addmoneyacc"><fmt:message key="gamehub.label.addmoneyacc" /></label>.</h1>
                        <form action="BarterServlet" method="post" name="formData">
                            <table>

                                <tr>
                                    <td><label for="amount"><fmt:message key="gamehub.label.amount" /></label>:</td><td> <input name="amount" size=20 type="text" required autofocus/> </td> 
                                </tr>
                                <tr>
                                    <td><label for="ccType"><fmt:message key="gamehub.label.ccType" /></label></td><td>
                                        <select name="cType">
                                            <option value="visa"> Visa </option>
                                            <option value="master"> Master </option>
                                            <option value="maestro"> Maestro </option>
                                            <option value="laser"> Laser </option>
                                        </select></td>
                                </tr>
                                <tr>
                                    <td><label for="ccnum"><fmt:message key="gamehub.label.ccnum" /></label>:</td><td> <input name="cNumber" size=20 type="text" required/> </td> 
                                </tr>
                                <tr>
                                    <td><label for="expiry"><fmt:message key="gamehub.label.expiry" /></label>:</td><td> <input name="expiry" size=20 type="date" required/> </td> 
                                </tr>
                                <tr>
                                    <td><label for="address"><fmt:message key="gamehub.label.address" /></label>:</td><td> <input name="address" size=20 type="text" required/> </td> 
                                </tr>
                                <tr>
                                    <td><label for="city"><fmt:message key="gamehub.label.city" /></label>:</td><td> <input name="city" size=20 type="text" required/> </td> 
                                </tr>
                                <tr>
                                    <td><label for="country"><fmt:message key="gamehub.label.country" /></label>:</td><td> <input name="country" size=20 type="text" required/> </td> 
                                </tr>
                            </table>
                                
                                <!-- button to add funds -->
                            <fmt:message key="gamehub.label.addFunds" var="addFunds" /> 
                            <input type="hidden" name="action" value="addFunds" />
                            <input type="submit" value="${addFunds}" onclick="valid_credit_card(value)" />
                        </form>
                        <!-- copy from this line down to the </footer> -->
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
