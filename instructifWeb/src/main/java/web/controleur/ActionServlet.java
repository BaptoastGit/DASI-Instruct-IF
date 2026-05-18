/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web.controleur;

import jakarta.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.JpaUtil;
import web.modele.ConnexionAction;
import web.modele.InscriptionAction;
import web.modele.MatiereAction;
import web.vue.MatiereSerialisation;
import web.vue.Serialisation;
import web.vue.Suu;

/**
 *
 * @author tmoulard
 */
@WebServlet(name = "ActionServlet", urlPatterns = {"/ActionServlet"})
public class ActionServlet extends HttpServlet {

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
        /*
        try (PrintWriter out = response.getWriter()) {
            // TODO output your page here. You may use following sample code.
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ActionServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActionServlet oulouloulouloulou at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
         */
        String todo = request.getParameter("todo");
        Serialisation serialisation;
        switch (todo) {
            case "inscriptionEleve":
                InscriptionAction inscription = new InscriptionAction();
                inscription.execute(request);
                serialisation = new Suu();
                serialisation.appliquer(request, response);
                break;
                
            case "connexion":
                ConnexionAction connexion = new ConnexionAction();
                connexion.execute(request);
                serialisation = new Suu();
                serialisation.appliquer(request, response);
                break;
            
            case "getMatieres":
                MatiereAction matiereAction = new MatiereAction();
                matiereAction.execute(request);
                serialisation = new MatiereSerialisation();
                serialisation.appliquer(request, response);
                break;
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
    }


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        JpaUtil.creerFabriquePersistance();
    }
    
    
    @Override
    public void destroy() {
        JpaUtil.fermerFabriquePersistance();
        super.destroy(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
