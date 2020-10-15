/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.search;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan Andrés Pérez
 */
@WebServlet(name = "buscarColegios", urlPatterns = {"/buscarColegios"})
public class buscarColegios extends HttpServlet {

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
            /* Instanciamos la clase Colegio*/
            Colegio colegio1 = new Colegio();
            Colegio colegio2 = new Colegio();
            Colegio colegio3 = new Colegio();
            /* Damos set a los atributos de los objetos */
            colegio1.setIdColegio(1);
            colegio1.setNombreColegio("I.E Fray Julio Tobón");
            colegio1.setDireccion("Calle 14 # 16-25");
            colegio1.setMun("El Carmen");
            colegio1.setDept("Antioquia");
            colegio1.setTelf("(4) 5535985");
            colegio1.setEmail("colegio@iefrayjulioelcarmen.edu.co");
            colegio1.setTipoIE("Publica");
            colegio2.setIdColegio(2);
            colegio2.setNombreColegio("I.E El Progreso");
            colegio2.setDireccion("Carrera 11 # 20-15");
            colegio2.setMun("El Carmen");
            colegio2.setDept("Antioquia");
            colegio2.setTelf("(4) 2254536");
            colegio2.setEmail("ieelprogresoelcarmen@gmail.com");
            colegio2.setTipoIE("Privada");
            colegio3.setIdColegio(3);
            colegio3.setNombreColegio("I.E La Paz");
            colegio3.setDireccion("Calle 19 Nro. 17-49");
            colegio3.setMun("La Ceja");
            colegio3.setDept("Antioquia");
            colegio3.setTelf("(4) 4448718");
            colegio3.setEmail(" iedlapaz@gmail.com");
            colegio3.setTipoIE("Publica");
            if(request.getParameter("municipio").equalsIgnoreCase("El Carmen")){
                if(request.getParameter("tipoie").equalsIgnoreCase("Privados")){
                    String var = "{\"success\": true,\"data\":[{\"idcol\":"+colegio2.getIdColegio()+",\"nombrecol\": \""+colegio2.getNombreColegio()+"\",\"direccioncol\": \""+colegio2.getDireccion()+"\",\"municipio\": \""+colegio2.getMun()+"\",\"departamento\": \""+colegio2.getDepto()+"\",\"email\": \""+colegio2.getEmail()+"\",\"telefono\": \""+colegio2.getTlf()+"\",\"tipo_ie\": \""+colegio2.getTipoIE()+"\"}]}";
                    out.println(var);
                } else if(request.getParameter("tipoie").equalsIgnoreCase("Publicos")){
                   String var = "{\"success\": true,\"data\":[{\"idcol\":"+colegio1.getIdColegio()+",\"nombrecol\": \""+colegio1.getNombreColegio()+"\",\"direccioncol\": \""+colegio1.getDireccion()+"\",\"municipio\": \""+colegio1.getMun()+"\",\"departamento\": \""+colegio1.getDepto()+"\",\"email\": \""+colegio1.getEmail()+"\",\"telefono\": \""+colegio1.getTlf()+"\",\"tipo_ie\": \""+colegio1.getTipoIE()+"\"}]}";
                } else if(request.getParameter("tipoie").equalsIgnoreCase("Todos")){
                    String var = "{\"success\": true,\"data\":[{\"idcol\": 1,\"nombrecol\": \"I.E Fray Julio\",\"direccioncol\": \"direccion\",\"municipio\": \"El Carmen\",\"departamento\": \"Antioquia\",\"email\": \"email\",\"telefono\": \"numero\",\"tipo_ie\": \"Publica\"},{\"idcol\": 2,\"nombrecol\": \"I.E El Progreso\",\"direccioncol\": \"direccion\",\"municipio\": \"El Carmen\",\"departamento\": \"Antioquia\",\"email\": \"email\",\"telefono\": \"numero\",\"tipo_ie\": \"Privada\"}]}";
                    out.println(var);
                }else{
                    String var = "{\"success\": false,\"mensaje\": \"Ocurrió un error inesperado.\"}";
                    out.println(var);
                }
            } else if(request.getParameter("municipio").equalsIgnoreCase("La Ceja")){
                if(request.getParameter("tipoie").equalsIgnoreCase("Privados")){
                    String var = "{\"success\": false,\"mensaje\": \"No se encontraron instituciones según el filtro dado.\"}";
                    out.println(var);
                } else if(request.getParameter("tipoie").equalsIgnoreCase("Publicos")){
                    String var = "{\"success\": true,\"data\":[{\"idcol\":"+colegio3.getIdColegio()+",\"nombrecol\": \""+colegio3.getNombreColegio()+"\",\"direccioncol\": \""+colegio3.getDireccion()+"\",\"municipio\": \""+colegio3.getMun()+"\",\"departamento\": \""+colegio3.getDepto()+"\",\"email\": \""+colegio3.getEmail()+"\",\"telefono\": \""+colegio3.getTlf()+"\",\"tipo_ie\": \""+colegio3.getTipoIE()+"\"}]}";
                    out.println(var);
                } else if(request.getParameter("tipoie").equalsIgnoreCase("Todos")){
                    String var = "{\"success\": true,\"data\":[{\"idcol\":"+colegio3.getIdColegio()+",\"nombrecol\": \""+colegio3.getNombreColegio()+"\",\"direccioncol\": \""+colegio3.getDireccion()+"\",\"municipio\": \""+colegio3.getMun()+"\",\"departamento\": \""+colegio3.getDepto()+"\",\"email\": \""+colegio3.getEmail()+"\",\"telefono\": \""+colegio3.getTlf()+"\",\"tipo_ie\": \""+colegio3.getTipoIE()+"\"}]}";
                    out.println(var);
                }else{
                    String var = "{\"success\": false,\"mensaje\": \"Ocurrió un error inesperado.\"}";
                    out.println(var);
                }
            }else{
                String var = "{\"success\": false,\"mensaje\": \"Hubo un error al encontrar las instituciones educativas de este municipio.\"}";
                out.println(var);
            }
            /*out.flush();*/
            /*out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet buscarColegios</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet buscarColegios at " + request.getContextPath() + "</h1>");
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
