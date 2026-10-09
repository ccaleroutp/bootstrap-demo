/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.bootstrap.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pe.edu.utp.bootstrap.demo.config.Conexion;
import pe.edu.utp.bootstrap.demo.model.Producto;

/**
 *
 * @author Christiam Calero
 */
public class ProductoDAO {

    public int crearProducto(String nombre, double precio) throws
            Exception {
        Connection cn = Conexion.getConexion();
        PreparedStatement ps = cn.prepareStatement(
                "INSERT INTO producto(nombre,precio) VALUES (?,?)");
        ps.setString(1, nombre);
        ps.setDouble(2, precio);
        return ps.executeUpdate();
    }

    public List<Producto> listar() throws Exception {
        List<Producto> list = new ArrayList<>();

        Connection cn = Conexion.getConexion();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM producto");
        while (rs.next()) {
            list.add(new Producto(rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getDouble("precio")));
        }

        return list;
    }

    public Producto obtener(int id) throws Exception {
        Producto producto = null;
        Connection cn = Conexion.getConexion();
        PreparedStatement ps = cn.prepareStatement("SELECT * FROM producto WHERE id =  ?");
        
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            producto = new Producto(rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getDouble("precio"));
        }
        return producto;
    }

    public int actualizar(Producto producto) throws Exception {
        Connection cn = Conexion.getConexion();

        PreparedStatement ps = cn.prepareStatement( "UPDATE producto SET nombre =  ?, precio =  ? WHERE  id =  ?");
        
        ps.setString(1, producto.getNombre());
        ps.setDouble(2, producto.getPrecio());
        
        ps.setInt(3, producto.getId());

        return ps.executeUpdate();
    }

    public int eliminar(int id) throws Exception {
        Connection cn = Conexion.getConexion();
        PreparedStatement ps = cn.prepareStatement(
        "DELETE FROM producto WHERE id =  ?");
        ps.setInt(1, id);
        
        return ps.executeUpdate();
    }

    public List<Producto> buscar(String nombre) throws Exception {
        List<Producto> list = new ArrayList<>();
        Connection cn = Conexion.getConexion();
        PreparedStatement ps = cn.prepareStatement(
        "SELECT * FROM producto WHERE nombre like ?");
            ps.setString(1, nombre + "%"); 
            
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            list.add(new Producto(rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getDouble("precio")));
        }
        return list;
    }
}
