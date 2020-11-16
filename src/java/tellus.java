/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DARSHAN
 */
@WebServlet(urlPatterns = {"/tellus"})
public class tellus extends HttpServlet {
Connection con;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe","root","dope");
            String name=request.getParameter("name");
             String lastname=request.getParameter("lastname");
              String emailid=request.getParameter("emailid");
               String type=request.getParameter("type");
               boolean ty=type.equals("0");
                String country=request.getParameter("country");
                 String city=request.getParameter("city");
                  String pin=request.getParameter("pin");
                   String c_number=request.getParameter("c_number");
                   PreparedStatement st=con.prepareStatement("insert into tellusaboutu values(?,?,?,?,?,?,?,?);");
                   st.setString(1,name);
                   st.setString(2,lastname);
                   st.setString(3,emailid);
                   st.setString(4,type);
                   st.setString(5,country);
                   st.setString(6,city);
                   st.setString(7,pin);
                   st.setString(8,c_number);
                   int n=st.executeUpdate();
                   RequestDispatcher rd=request.getRequestDispatcher("options.html");
                   rd.forward(request, response);
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
    try {
        processRequest(request, response);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(tellus.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(tellus.class.getName()).log(Level.SEVERE, null, ex);
    }
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
    try {
        processRequest(request, response);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(tellus.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(tellus.class.getName()).log(Level.SEVERE, null, ex);
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
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
