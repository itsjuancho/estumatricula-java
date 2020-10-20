/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.contact;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andres Mauricio Rendon
 */
@WebServlet(name = "contactanos", urlPatterns = {"/contactanos"})
public class contactanos extends HttpServlet {

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
            if(request.getParameter("email").trim().length() > 0 && 
               request.getParameter("nombre").trim().length() > 0 &&
               request.getParameter("motivo").trim().length() > 0 &&
               request.getParameter("telefono_contacto").trim().length() > 0 &&
               request.getParameter("mensaje").trim().length() > 0){
                Contacto contacto = new Contacto();
                contacto.setCorreo(request.getParameter("email"));
                contacto.setAsunto(request.getParameter("motivo"));
                contacto.setNombres(request.getParameter("nombre"));
                contacto.setTelefono(request.getParameter("telefono_contacto"));
                contacto.setMensaje(request.getParameter("mensaje"));
                String texto = "{\"ok\": true,\"texto\": \"Te contactaremos pronto\",\"info\": {\"nombre\": \""+contacto.getNombres()+"\", \"correo\": \""+contacto.getCorreo()+"\", \"asunto\": \""+contacto.getAsunto()+"\", \"telefono\": \""+contacto.getTelefono()+"\", \"mensaje\": \""+contacto.getMensaje()+"\"}}";
                out.println(texto);
            }else{
                String texto = "{\"ok\": false,\"texto\": \"campos vacios\"}";
                out.println(texto);
            }
            /* TODO output your page here. You may use following sample code.
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet contactanos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet contactanos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
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
