/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.MovieDAO;
import model.Movie;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MovieServletController
 */
@WebServlet(name="MovieServletController", urlPatterns={"/movie"})
public class MovieServletController extends HttpServlet {
   
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // Handle GET requests here if needed
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String title = request.getParameter("title");
        String genre = request.getParameter("genre");
        int duration = Integer.parseInt(request.getParameter("duration"));
        String releaseDate = request.getParameter("releaseDate");
        String description = request.getParameter("description");
        
        Movie movie = new Movie(0, title, genre, duration, releaseDate, description);
        MovieDAO movieDAO = new MovieDAO();
        boolean isAdded = false;
        try {
            isAdded = movieDAO.addMovie(movie);
        } catch (Exception ex) {
            Logger.getLogger(MovieServletController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Movie Addition Result</title>");            
            out.println("</head>");
            out.println("<body>");
            if (isAdded) {
                out.println("<h1>Movie added successfully!</h1>");
            } else {
                out.println("<h1>Failed to add movie.</h1>");
            }
            out.println("<a href='addMovieForm.jsp'>Go back to add movie form</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
