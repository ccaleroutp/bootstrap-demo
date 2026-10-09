package pe.edu.utp.bootstrap.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import pe.edu.utp.bootstrap.demo.dao.ProductoDAO;
import pe.edu.utp.bootstrap.demo.model.Producto;

/**
 *
 * @author Christiam Calero
 */
@WebServlet(name = "ProductoServlet", urlPatterns = {"/producto"})
public class ProductoServlet extends HttpServlet {

    ProductoDAO productoDao = new ProductoDAO();

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
        try {

            String accion = request.getParameter("accion");

            switch (accion) {
                case "listar"  -> {
                    List<Producto> listProducto = productoDao.listar();
                    request.setAttribute("listProducto", listProducto);

                    request.getRequestDispatcher("productos.jsp").forward(request,
                            response);
                }
                case "guardar"  -> {

                    String nombre = request.getParameter("nombre");
                    double precio
                            = Double.parseDouble(request.getParameter("precio"));

                    productoDao.crearProducto(nombre, precio);

                    response.sendRedirect("producto?accion=listar");
                }
                case "buscar" -> {
                    int id
                            = Integer.parseInt(request.getParameter("id"));
                    Producto producto = productoDao.obtener(id);
                    request.setAttribute("producto", producto);

                    request.getRequestDispatcher("editar.jsp").forward(request, response);
                }
                case "actualizar" -> {
                    int id
                            = Integer.parseInt(request.getParameter("id"));
                    String nombre = request.getParameter("nombre");
                    double precio
                            = Double.parseDouble(request.getParameter("precio"));
                    productoDao.actualizar(new Producto(id, nombre,
                            precio));
                    response.sendRedirect("producto?accion=listar");
                }
                case "eliminar" -> {
                    int id
                            = Integer.parseInt(request.getParameter("id"));
                    productoDao.eliminar(id);
                    response.sendRedirect("producto?accion=listar");
                }
                case "buscarNombre" -> {
                    String nombre = request.getParameter("nombre");

                    List<Producto> listProducto
                            = productoDao.buscar(nombre);
                    request.setAttribute("listProducto",
                            listProducto);

                    request.getRequestDispatcher("productos.jsp").forward(request,
                            response);
                }
                default -> {
                    System.err.println("Accion desconocida");
                }
            }
        } catch (Exception e) {
            response.getWriter().println("<h1>Error:</h1>"
                    + e.getMessage());
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
