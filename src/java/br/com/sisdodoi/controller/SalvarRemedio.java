package br.com.sisdodoi.controller;

import br.com.sisdodoi.DAO.GenericDAO;
import br.com.sisdodoi.DAO.RemedioDAOImpl;
import br.com.sisdodoi.model.Remedio;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Enilson Filho
 */
@WebServlet(name = "SalvarRemedio", urlPatterns = {"/SalvarRemedio"})
public class SalvarRemedio extends HttpServlet {

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

        String mensagem = null;
        String nomeRemedio = request.getParameter("nomeremedio");
        Double precoRemedio = Double.parseDouble(request.getParameter("precoremedio"));

        Remedio remedio = new Remedio();
        remedio.setNomeRemedio(nomeRemedio);
        remedio.setPrecoRemedio(precoRemedio);

        if (request.getParameter("idremedio").equals("")) {

            try {
                GenericDAO dao = new RemedioDAOImpl();
                if (dao.cadastrar(remedio)) {
                    mensagem = "Remedio cadastrado com sucesso!";
                } else {
                    mensagem = "Problemas ao cadastrar Remedio!";
                }
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("remedio/salvarremedio.jsp").forward(request, response);
            } catch (Exception ex) {
                System.err.println("Problemas ao cadastrar remedio!Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
        } else {
            remedio.setIdRemedio(Integer.parseInt(request.getParameter("idremedio")));
            try {
                GenericDAO dao = new RemedioDAOImpl();
                if (dao.alterar(remedio)) {
                    mensagem = "Remedio alterado com sucesso!";
                } else {
                    mensagem = "Problemas ao alterar Remedio!";
                }
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("remedio/salvarremedio.jsp").forward(request, response);
            } catch (Exception ex) {
                System.err.println("Problemas ao alterar Remedio!Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
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
