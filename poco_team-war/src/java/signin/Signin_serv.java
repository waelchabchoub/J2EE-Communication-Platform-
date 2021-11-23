/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signin;

import beans.UserFacade;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author user
 */
public class Signin_serv extends HttpServlet {
    @EJB
    private UserFacade userFacade;
 

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            boolean credential = false;
         
            //test credential
           for(int i=0;i<userFacade.findAll().size();i++){
           
                User user = userFacade.findAll().get(i); 
                
                //tester si login et pass exist
                if((user.getLogin().equals(request.getParameter("login")))& user.getPassword().equals(request.getParameter("password"))){   
                credential = true;
                
                
               
                
               // set the session credential;
               HttpSession session = request.getSession();
               //set the attribute you want to save
               session.setAttribute("login",request.getParameter("login"));
               session.setAttribute("id",user.getId());
               
                // convert image to array bytes to base 64 and send it to jsp in the session variable
                byte[] content = user.getImage();
                byte[] base64Encoded = Base64.getEncoder().encode(content);
                String img = new String (base64Encoded);
                session.setAttribute("image",img); 

              
               
                }}
               

               
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Signin_serv</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
                if(credential==true){
                //redirect to index.jsp
                response.sendRedirect("index.jsp");
                   
                }
            
                if(credential==false){
                out.println("<script>alert(\"invalid credentials\");window.location.href =\"signin.jsp\";</script>");
                  }                     
       
            out.println("</body>");
            out.println("</html>"); 
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
