/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import services.AccountService;

/**
 *
 * @author adamw
 */
public class LoginServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get the current session
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("USER");

        // capture the  operation parameter if the user wants to login out the form
        String operation = request.getParameter("operation");

        if (operation != null && operation.equals("logout")) {
            // log out the user
            session.invalidate();
            //session = request.getSession();
            request.setAttribute("MESSAGE", "You have successfully logged out.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        } else if (userName != null) {
            // send the user to a new URL
            // relative URL
            response.sendRedirect("home");

        } else {
            // displays default page
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get the current session
        HttpSession session = request.getSession();
        String name = request.getParameter("USERNAME");
        String userPassword = request.getParameter("PASSWORD");
        
        

        if (name != null && userPassword != null) {
            AccountService account = new AccountService();
            User user = account.login(name, userPassword);
            // non-null, store username in session and redirect 
            if (user != null) {

                session.setAttribute("USER", name);
                response.sendRedirect("home");

            } else {
                session.setAttribute("USER", name);
                request.setAttribute("MESSAGE", "Invalid Log in....");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            }

        }

    }

}
