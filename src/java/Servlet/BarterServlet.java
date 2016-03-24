/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet;

import Command.CommandFactory;
import Command.CommandInterface;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *this is the only servlet
 * @author d00135791
 */
@WebServlet(name = "BarterServlet", urlPatterns = {"/BarterServlet"})
public class BarterServlet extends HttpServlet {

    /**
     *This is processing the request, it uses the command factory to create commands depending on the action sent from the jsps
     * @param request anything the browser may send
     * @param response sends back to the browser, in response to the HTTP request the browser sent
     * @throws ServletException is thrown when there is a problem with the servlet
     * @throws IOException thrown when there is a problem with input or output
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String forwardToJsp = null;
        String cmdAction = request.getParameter("action");
        if (cmdAction != null) {
            CommandFactory factory = new CommandFactory();
            CommandInterface cmd = factory.createCommand(request.getParameter("action"));
            forwardToJsp = cmd.execute(request, response);
        }
        response.sendRedirect(forwardToJsp);
    }
    
    /**
     *
     * @param request anything the browser may send
     * @param response sends back to the browser, in response to the HTTP request the browser sent
     * @throws ServletException is thrown when there is a problem with the servlet
     * @throws IOException thrown when there is a problem with input or output
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * accepts the data in the request message
     * @param request anything the browser may send
     * @param response sends back to the browser, in response to the HTTP request the browser sent
     * @throws ServletException is thrown when there is a problem with the servlet
     * @throws IOException thrown when there is a problem with input or output
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     *gets the the information about the servlet
     * @return short description is default
     * we didn't put a description in
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
