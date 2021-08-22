package br.com.sisdodoi.controller;

import br.com.sisdodoi.DAO.GenericDAO;
import br.com.sisdodoi.DAO.PrincipioAtivoDAOImpl;
import br.com.sisdodoi.model.PrincipioAtivo;
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
@WebServlet(name = "SalvarPrincipioAtivo", urlPatterns = {"/SalvarPrincipioAtivo"})
public class SalvarPrincipioAtivo extends HttpServlet {

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
        String nomePrincipioAtivo = request.getParameter("nomeprincipioativo");
        String observacaoPrincipioAtivo = request.getParameter("observacaoprincipioativo");
        PrincipioAtivo principioAtivo = new PrincipioAtivo();
        principioAtivo.setNomePrincipioAtivo(nomePrincipioAtivo);
        principioAtivo.setObservacaoPrincipioAtivo(observacaoPrincipioAtivo);

        if (request.getParameter("idprincipioativo").equals("")) {

            try {
                GenericDAO dao = new PrincipioAtivoDAOImpl();
                if (dao.cadastrar(principioAtivo)) {
                    mensagem = "Princípio Ativo cadastrado com sucesso!";
                } else {
                    mensagem = "Problemas ao cadastrar Princípio Ativo!";
                }
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("principioativo/salvar.jsp").forward(request, response);
            } catch (Exception ex) {
                System.err.println("Problemas ao cadastrar Principio Ativo!Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
        } else {
            principioAtivo.setIdPrincipioAtivo(Integer.parseInt(request.getParameter("idprincipioativo")));
            try {
                GenericDAO dao = new PrincipioAtivoDAOImpl();
                if (dao.alterar(principioAtivo)) {
                    mensagem = "Princípio Ativo alterado com sucesso!";
                } else {
                    mensagem = "Problemas ao alterar Princípio Ativo!";
                }
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("principioativo/salvar.jsp").forward(request, response);
            } catch (Exception ex) {
                System.err.println("Problemas ao alterar Principio Ativo!Erro:" + ex.getMessage());
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
