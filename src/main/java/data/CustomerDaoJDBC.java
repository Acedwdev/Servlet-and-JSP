
package data;

import domain.Customer;
import java.sql.*;
import java.util.*;


public class CustomerDaoJDBC {
    private static final String SQL_SELECT = "SELECT id_customer, name, lastName, email, phone, balance "
            + " FROM customer";

    private static final String SQL_SELECT_BY_ID = "SELECT id_customer, name, lastName, email, phone, balance "
            + " FROM customer WHERE id_customer = ?";

    private static final String SQL_INSERT = "INSERT INTO customer(name, lastName, email, phone, balance) "
            + " VALUES(?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE customer "
            + " SET name=?, lastName=?, email=?, phone=?, balance=? WHERE id_customer=?";

    private static final String SQL_DELETE = "DELETE FROM customer WHERE id_customer = ?";
    
    public List<Customer> list() {
        java.sql.Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Customer customer = null;
        List<Customer> customers = new ArrayList<>();
        try {
            conn = Connection.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idCustomer = rs.getInt("id_customer");
                String name = rs.getString("name");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                double balance = rs.getDouble("balance");

                customer = new Customer(idCustomer, name, lastName, email, phone, balance);
                customers.add(customer);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Connection.close(rs);
            Connection.close(stmt);
            Connection.close(conn);
        }
        return customers;
    }
    
    public Customer search(Customer customer) {
        java.sql.Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Connection.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, customer.getIdCustomer());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            String name = rs.getString("name");
            String lastName = rs.getString("lastName");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            double balance = rs.getDouble("balance");

            customer.setName(name);
            customer.setLastName(lastName);
            customer.setEmail(email);
            customer.setPhone(phone);
            customer.setBalance(balance);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Connection.close(rs);
            Connection.close(stmt);
            Connection.close(conn);
        }
        return customer;
    }
    
    public int insert(Customer customer) {
        java.sql.Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Connection.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getLastName());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getPhone());
            stmt.setDouble(5, customer.getBalance());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Connection.close(stmt);
            Connection.close(conn);
        }
        return rows;
    }
    
    public int update(Customer customer) {
        java.sql.Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Connection.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getLastName());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getPhone());
            stmt.setDouble(5, customer.getBalance());
            stmt.setInt(6, customer.getIdCustomer());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Connection.close(stmt);
            Connection.close(conn);
        }
        return rows;
    }
    
    public int delete(Customer customer) {
        java.sql.Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Connection.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, customer.getIdCustomer());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Connection.close(stmt);
            Connection.close(conn);
        }
        return rows;
    }
}
