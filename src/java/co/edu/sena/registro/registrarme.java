/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.registro;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David Esteban Jimenez
 */
@WebServlet(name = "registrarme", urlPatterns = {"/registrarme"})
public class registrarme extends HttpServlet {

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
            if(request.getParameter("email").length() > 0){
                if(request.getParameter("pass").equals(request.getParameter("passConfirm"))){
                    Registro registro = new Registro();
                    registro.setNombre(request.getParameter("nombre"));
                    registro.setApellidos(request.getParameter("apellidos"));
                    registro.setTipoDoc(request.getParameter("tipodoc"));
                    registro.setNroDoc(request.getParameter("docid"));
                    registro.setCorreo(request.getParameter("email"));
                    registro.setPassword(request.getParameter("pass"));
                    String json = "{\"success\": true,\"info\":[{\"nombres\": \""+registro.getNombre()+"\",\"apellidos\": \""+registro.getApellidos()+"\",\"tipo_doc\": \""+registro.getTipoDoc()+"\",\"docid\": \""+registro.getNroDoc()+"\",\"correo\": \""+registro.getCorreo()+"\"}]}";
                    out.println(json);
                }else{
                    String json = "{\"success\": false,\"mensaje\": \"Las contraseñas no coinciden. Revísalas, deben ser iguales.\"}";
                    out.println(json);
                }
            }else{
                String json = "{\"success\": false,\"mensaje\": \"Verifica que todos los campos estén rellenados y diligenciados correctamente.\"}";
                out.println(json);
            }
            /* TODO output your page here. You may use following sample code.
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registrarme</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet registrarme at " + request.getContextPath() + "</h1>");
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
