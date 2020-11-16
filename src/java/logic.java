import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class logic extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
          String a,b,c;
          a =request.getParameter("t1");
           b =request.getParameter("t2");
            
            if(a.equals("veg")&& b.equals("starter")){
                 RequestDispatcher rd=request.getRequestDispatcher("/vegstarter.html");  
        rd.forward(request, response); 
                 
                
            }
            
            else if(a.equals("veg")&&b.equals("maincourse")){
                 RequestDispatcher rd=request.getRequestDispatcher("/vegmaincourse.html");  
        rd.forward(request, response); 
                out.println("veg maincourse");
            }
              else if(a.equals("veg")&&b.equals("desert")){
                   RequestDispatcher rd=request.getRequestDispatcher("/vegdesert.html");  
        rd.forward(request, response); 
                out.println("veg desert");
            }
            
              else if(a.equals("nonveg")&&b.equals("desert")){
                   RequestDispatcher rd=request.getRequestDispatcher("/nonvegdesert.html");  
        rd.forward(request, response); 
                out.println("nonveg desert");
            }
            else if(a.equals("nonveg")&&b.equals("starter")){
                 RequestDispatcher rd=request.getRequestDispatcher("/nonvegstarter.html");  
        rd.forward(request, response); 
                out.println("nonveg starter");
            }
             else if(a.equals("nonveg")&&b.equals("maincourse")){
                  RequestDispatcher rd=request.getRequestDispatcher("/nonvegmaincourse.html");  
        rd.forward(request, response); 
                out.println("nonveg maincourse");
                          
        }
            
            
    }
    }
    
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
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request serv     * @param response servlet response
let request
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   