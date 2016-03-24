/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Daos.UserDao;
import Dtos.User;
import Service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author d00133633
 */
public class RegisterCommand implements CommandInterface {

    /**
     * This command is used to register a account 
     * it takes your information like username, password etc
     * and puts it in a object 
     * 
     * @param request used to get session variables.
     * @param response used for such things as setting headers and body tags. HTML Elements.
     * @return String of the jsp to forward to login.jsp.
     */
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = new UserService();
        // If registration is successful then go to login
        String forwardToJsp = "login.jsp";
        HttpSession session = request.getSession();
        String message = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("cPassword");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String country = request.getParameter("country");

        User u = userService.userRegister(username, password, firstName, lastName, address, city, country);
        if (u == null) {// if username taken u is null
            message = "Username taken.";
        }// if any required fields are null
        else if (u.getUsername() == null || u.getPassword() == null || u.getFirstname() == null || u.getLastname() == null || u.getAddress() == null || u.getCity() == null || u.getCountry() == null) {
            message = "Register failed.";
        }// if any required fields are blank
        else if (u.getUsername().equals("") || u.getPassword().equals("") || u.getFirstname().equals("") || u.getLastname().equals("") || u.getAddress().equals("") || u.getCity().equals("") || u.getCountry().equals("")) {
            message = "Please fill required fields.";
        }// if password and confirm password are not the same
        else if (!password.equals(confirmPassword)){
            message = "Passwords are not the same.";
        }
        // send message to register
        session.setAttribute("regMessage", message);
        return forwardToJsp;
    }
}
