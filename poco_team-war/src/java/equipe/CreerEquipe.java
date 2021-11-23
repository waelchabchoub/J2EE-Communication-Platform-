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
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


/**
 *
 * @author user
 */
@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class CreerEquipe extends HttpServlet {
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
        Equipe equipe = new Equipe();
        
        equipe.setCode(request.getParameter("code"));
        equipe.setNom(request.getParameter("nom"));
        
         // get the session credential;
         HttpSession session = request.getSession();
         User user = userFacade.find(session.getAttribute("id"));
         
         // set the foreign key idadmin
         equipe.setIdAdmin(user);
         
          boolean image_type=false;
        
        //store the image
            // get the file part
            Part filePart = request.getPart("image");
            //allow only jpeg
            String type=filePart.getContentType();
            type=type.substring(type.lastIndexOf("/")+1);
            if(type.equals("jpeg")){
                image_type=true;
            }
            // obtains inputstream of the upload file , inputstreams represents an ordered stream of bytes. In other words, you can read data from a Java InputStream as an ordered sequence of bytes. This is useful when reading data from a file, or received over the network
            InputStream is = filePart.getInputStream();
            
            //convert input stream to byte array
             ByteArrayOutputStream buffer = new ByteArrayOutputStream();

             int nRead;
             byte[] data = new byte[16384];

             while ((nRead = is.read(data, 0, data.length)) != -1) {
              buffer.write(data, 0, nRead);
             }

            byte[] image = buffer.toByteArray();
            //store the image
            equipe.setIcon(image);
        
        
        try (PrintWriter out = response.getWriter()) {
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreerEquipe</title>");            
            out.println("</head>");
            out.println("<body>");
            
            if(image_type==true){
             //call create method from userFacade instance
            equipeFacade.create(equipe);
             //redirect to signin page
        
            response.sendRedirect("index.jsp");}
            
            if(image_type==false){
             out.println("<script>alert(\"please insert jpg/jpeg image format\");window.location.href =\"creeequipe.jsp\";</script>");}
           
           
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
