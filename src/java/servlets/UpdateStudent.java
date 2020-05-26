/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Gruppyi;
import entity.Studentyi;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet( urlPatterns = {"/updateStud"})
public class UpdateStudent extends HttpServlet {
 @EJB
           Service.StudentyiService stServ;
    @EJB
           Service.GroupInterface grServ;

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
            request.getRequestDispatcher("/studentsTable").forward(request, response);   
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
        String nomerZachetki = (String) request.getParameter("enteredValue");
        Studentyi student=stServ.getStudent(Long.valueOf(nomerZachetki));
        List<Gruppyi> lst=null;
        lst=grServ.getTable();
        
        
        request.setAttribute("grList", lst);
        request.setAttribute("Student", student);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/updateStud.jsp");
        dispatcher.forward(request, response);
        
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
        
        String NomerZachetki = (String) request.getParameter("NomerZachetki");       
        String Familiya = (String) request.getParameter("Familiya");
         String Imya = (String) request.getParameter("Imya");
        String Otchestvo = (String) request.getParameter("Otchestvo");
        String Gorod = (String) request.getParameter("Gorod");
        String Gruppyi = (String) request.getParameter("Gruppyi");
        String Adres = (String) request.getParameter("Adres");
        String Tel = (String) request.getParameter("Tel");
        String Status = (String) request.getParameter("Status");
        
        
        stServ.updateStudent(Long.valueOf(NomerZachetki), Integer.valueOf(Gruppyi), Familiya, Imya, Otchestvo, Gorod, Adres, Tel, Status);
         response.sendRedirect(request.getContextPath() + "/studentsTable");
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
