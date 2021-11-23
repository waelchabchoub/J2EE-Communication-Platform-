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
public class IntegrerEquipe extends HttpServlet {
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
      
        
        try (PrintWriter out = response.getWriter()) {
             
               
            
             // get the session credential;
             HttpSession session = request.getSession();
             String code = request.getParameter("code");
             
              
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet IntegrerEquipe</title>");            
            out.println("</head>");
            out.println("<body>");
            
           
       
            
            //to insert
                   // User user = userFacade.find(session.getAttribute("id"));
                   // Equipe equipe = equipeFacade.findAll().get(0);
                    //Collection<Equipe> equipeCollection = new ArrayList<>();
                    //equipeCollection.add(equipe);
                    //user.setEquipeCollection(equipeCollection);
                    //userFacade.edit(user);
                    //out.println("<h1 servlet at>"+ user.getEquipeCollection() +" </h1>");   
            
            // to show equipe with specific user
                       // Collection<Equipe> listEquipeCollection = new ArrayList<>();
                       // listEquipeCollection.addAll(user.getEquipeCollection());
                      // out.println("<h1 servlet at>"+ user.getEquipeCollection() +" </h1>");   
          
           // to show users with eqipe = idequipe
                    //Collection<User> listUserCollection = new ArrayList<>();
                    //listUserCollection.addAll(equipe.getUserCollection());
                    //out.println("<h1 servlet at>"+ equipe.getUserCollection() +" </h1>");  
          
            
             //test code exist
             for(int i=0;i<equipeFacade.findAll().size();i++){
           
                    Equipe equipe = equipeFacade.findAll().get(i); 
                    
                     //tester si code exist
                     if((equipe.getCode().equals(code))){
                    
                         
                         
              
                         //test if the user exist in team
                         User user = userFacade.find(session.getAttribute("id"));
                         Collection<Equipe> listEquipeCollection = new ArrayList<>();
                         listEquipeCollection.addAll(user.getEquipeCollection());
                         // test if user is not in the team or user is not the admin of that team
                         if((user.getEquipeCollection().contains(equipe)) || (equipe.getIdAdmin().equals(user))){ out.println("<script>alert(\"you already in this team\");window.location.href =\"integrerequipe.jsp\";</script>");}
                          
                         
                         else{
                         
                         //if the user not exist in team
                         
                         //insert user in liste
                       
                         // instance de Collection equipe
                         
                         Collection<Equipe> equipeCollection = new ArrayList<>();
                         //add the team to current user
                         equipeCollection.add(equipe);
                         user.setEquipeCollection(equipeCollection);
                         //fetch
                         userFacade.edit(user);
                         
                         out.println("<h1 servlet at>"+ user.getEquipeCollection() +" </h1>");   
                         response.sendRedirect("index.jsp");
                         
                     }
                         
                     }  }
               
            //if code incorrect
            out.println("<script>alert(\"please insert a valid team code\");window.location.href =\"integrerequipe.jsp\";</script>");  
            
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
