/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.PersonagensDAO;
import java.io.IOException;
import java.io.PrintWriter;
import model.Personagens;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Pedrovisk
 */
@WebServlet(name = "ControlePersonagens", urlPatterns = {"/ControlePersonagens"})
public class ControlePersonagens extends HttpServlet {

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
            
            
        String op = request.getParameter("op");
        PersonagensDAO pdao = new PersonagensDAO();
        Personagens p = new Personagens();
    
        if(op.equals("Cadastrar")) {   
            String nome = request.getParameter("txtnome");
            String descricao = request.getParameter("txtdescricao");
            double avaliacao = Double.parseDouble(request.getParameter("txtavaliacao"));
            p.setNome(nome);
            p.setDescricao(descricao);
            p.setAvaliacao(avaliacao);
            String msg = "Cadastrar";
            
                try {
                    pdao.cadastrar(p);
                    System.out.println("Cadastrado com sucesso!!");
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("result.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }
        }

        else if (op.equals("Deletar")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                p.setId(id);
                String msg = "Deletar";
                try {
                    pdao.deletar(p);
                    List<Personagens> Lprod = pdao.consultarLista();
                    request.setAttribute("Lprod", Lprod);
                    request.getRequestDispatcher("resultconsultarTODOS.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }
                
        } else if (op.equals("Consultar")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                p.setId(id);
                try {
                    p = pdao.consultar(p);
                    request.setAttribute("p", p);
                    request.getRequestDispatcher("resultconsultarID.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                }        
                
                } else if (op.equals("CONSULTAR TODOS")) {
                //NÃO IMPLEMENTADO
                try {
                    List<Personagens> Lprod = pdao.consultarLista();
                    request.setAttribute("Lprod", Lprod);
                    request.getRequestDispatcher("resultconsultarTODOS.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                }        
        }     
        
   
        else if (op.equals("Atualizar")) {
            int id = Integer.parseInt(request.getParameter("txtid"));
            String nome = request.getParameter("txtnome");
            String descricao = request.getParameter("txtdescricao");
            double avaliacao = Double.parseDouble(request.getParameter("txtavaliacao"));
            p.setId(id);
            p.setNome(nome);
            p.setDescricao(descricao);
            p.setAvaliacao(avaliacao);
                try {
                    pdao.consultar(p);
                    request.setAttribute("p", p);
                    request.getRequestDispatcher("atuaresult.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                }

                }
        else if (op.equals("EFETIVAR ATUALIZAÇÃO")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                String nome = request.getParameter("txtnome");
                String descricao = request.getParameter("txtdescricao");
                double avaliacao = Double.parseDouble(request.getParameter("txtavaliacao"));
                p.setId(id);
                p.setNome(nome);
                p.setDescricao(descricao);
                p.setAvaliacao(avaliacao);
                String msg = "Atualizar";
                try {
                    pdao.atualizar(p);
                    System.out.println("Atuaizado com sucesso!!");
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("result.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }

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