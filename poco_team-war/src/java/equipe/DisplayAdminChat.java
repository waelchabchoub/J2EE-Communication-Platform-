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
import static java.lang.Integer.parseInt;
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
public class DisplayAdminChat extends HttpServlet {
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
        
         String team_id = request.getParameter("idequipe");
          // get the session
         HttpSession session = request.getSession();
        
       
        //get the session id
        String id_admin =  session.getAttribute("id").toString() ;
        
        
        int id_team = parseInt(request.getParameter("idequipe"));
        //get all users in specific team
        Equipe equipe = equipeFacade.find(id_team);
        Collection<User> listUserCollection = new ArrayList<>();
        listUserCollection.addAll(equipe.getUserCollection());
        
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DisplayTeamMemebersAdminChat</title>");            
            out.println("</head>");
            out.println("<body>");
            
                     //display the admin
               User team_admin = equipe.getIdAdmin();

               out.println("<form action=\"RemoveTeam\" >");    

               //diplay equipe icon 
               // convert image to array bytes to base 64 
               byte[] content = team_admin.getImage();
               byte[] base64Encoded = Base64.getEncoder().encode(content);
                 String img = new String (base64Encoded);

               out.println("<img src=\"data:image/jpg;base64,"+img+"\" width=\"50\" height=\"50\" />");
               out.println("<input type=\"text\" name=\"teamid\" value="+team_id+" >");
               out.println("<input type=\"text\" name=\"idequipe\" value="+team_admin.getId()+" >");
               out.println("<input type=\"text\" name=\"nomadmin\" value="+team_admin.getNom()+" >");
               out.println("<input type=\"text\" name=\"prenomadmin\" value="+team_admin.getPrenom()+" >");
               out.println("<input type=\"text\" name=\"siegle\" value=\"Admin\" >");
               out.println("<input type=\"submit\" value=\"Remove Group\" >");
               out.println("</form><hr><br>"); 


            
            
            // display team members
            
            //out.println("<h1 servlet at>"+ equipe.getUserCollection() +" </h1>");  
            for(int i=0;i<userFacade.findAll().size();i++){
               
                User user = userFacade.findAll().get(i);
                
                //get the collection of users with specific team and test if contains current user
                 if(equipe.getUserCollection().contains(user)){
                               
                       out.println("<form action=\"RemoveFromTeam\" >");    

                    //diplay equipe icon 
                    // convert image to array bytes to base 64 
                        byte[] content2 = user.getImage();
                        byte[] base64Encoded2 = Base64.getEncoder().encode(content2);
                        String img2 = new String (base64Encoded2);

                        out.println("<img src=\"data:image/jpg;base64,"+img2+"\" width=\"50\" height=\"50\" />");
                        out.println("<input type=\"text\" name=\"teamid\" value="+team_id+" >");
                        out.println("<input type=\"text\" name=\"iduser\" value="+user.getId()+" >");
                        out.println("<input type=\"text\" name=\"nomuser\" value="+user.getNom()+" >");
                        out.println("<input type=\"text\" name=\"prenomuser\" value="+user.getPrenom()+" >");
                        out.println("<input type=\"text\" name=\"siegle\" value=\"Memeber\" >");
                        out.println("<input type=\"submit\" value=\"Remove From Groupe\" >");

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
