/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipe;

import beans.EquipeFacade;
import beans.UserFacade;
import entity.Equipe;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author user
 */
public class IntegratedTeamServ extends HttpServlet {
    @EJB
    private UserFacade userFacade;
    @EJB
    private EquipeFacade equipeFacade;


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
        
          // get the session
        HttpSession session = request.getSession();
        
       
        //get the session id
        String id_admin =  session.getAttribute("id").toString() ;
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet IntegratedTeamServ</title>");            
            out.println("</head>");
            out.println("<body>");
            
           for(int i=0;i<equipeFacade.findAll().size();i++){
               
                Equipe equipe = equipeFacade.findAll().get(i);
                
                User user = userFacade.find(session.getAttribute("id"));
                
                 
                
                
                        //get the collection of users with specific team and test if contains current user
                        if(equipe.getUserCollection().contains(user)){
                               
                       out.println("<form action=\"/poco_team-war/userchat.jsp\" >");    

                    //diplay equipe icon 
                    // convert image to array bytes to base 64 
                        byte[] content = equipe.getIcon();
                        byte[] base64Encoded = Base64.getEncoder().encode(content);
                        String img = new String (base64Encoded);

                        out.println("<img src=\"data:image/jpg;base64,"+img+"\" width=\"50\" height=\"50\" />");
                        out.println("<input type=\"text\" name=\"idequipe\" value="+equipe.getId()+" >");
                        out.println("<input type=\"text\" name=\"nomequipe\" value="+equipe.getNom()+" >");
                        out.println("<input type=\"submit\" value=\"Consulter\" >");

                        out.println("</form>");
               }}
            
           
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
