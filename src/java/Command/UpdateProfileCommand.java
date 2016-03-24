package Command;

import Daos.UserDao;
import Dtos.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tiernan
 */
public class UpdateProfileCommand implements CommandInterface {

    /**
     * This command is used to edit the user that is signed in details
     * it gets what is typed in the textbox and then replaces them details
     * the the details in the database.
     * 
     * @param request used to get session variables.
     * @param response used for such things as setting headers and body tags. HTML Elements.
     * @return String of the jsp to forward to userAccount.jsp.
     */
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "userAccount.jsp";
        String message;
        HttpSession session = request.getSession();
        User useMe = (User) session.getAttribute("loggedUser");
        UserDao userDao = new UserDao();

        if (session.getId() != session.getAttribute("clientLoggedInId")) {
            message = "Client id is invalid.";
        } else {
            String newUsername = request.getParameter("username");
            String newPassword = request.getParameter("newPassword");
            String confirmPassword = request.getParameter("confirmPassword");
            String newFirstname = request.getParameter("firstName");
            String newLastName = request.getParameter("lastName");
            String newAddress = request.getParameter("address");
            String newCity = request.getParameter("city");
            String newCountry = request.getParameter("country");
            int usersId = useMe.getUserId();

            if (usersId != 0 && newUsername != null && newPassword != null && confirmPassword != null && newFirstname != null && newLastName != null && newAddress != null && newCity != null && newCountry != null) {

                int usersIdNumber = useMe.getUserId();
                userDao.editDetails(usersIdNumber, newUsername, newPassword, newFirstname, newLastName, newAddress, newCity, newCountry);

                message = "Update successfull.";
            } else {
                message = "Update failed.";
            }
        }
        session.setAttribute("updateMessage", message);
        return forwardToJsp;
    }

}

