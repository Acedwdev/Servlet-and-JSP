
package web;

import data.CustomerDaoJDBC;
import domain.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletController")
public class ServletController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "edit":
                    this.editCustomer(request, response);
                    break;
                case "delete":
                    this.deleteCustomer(request, response);
                    break;
                default:
                    this.actionDefault(request, response);
            }
        } else {
            this.actionDefault(request, response);
        }
    }

    private void actionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Customer> customers = new CustomerDaoJDBC().list();
        System.out.println("customers = " + customers);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("customers", customers);
        sesion.setAttribute("totalCustomers", customers.size());
        sesion.setAttribute("totalBalance", this.totalBalanceCalculation(customers));
        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        response.sendRedirect("customers.jsp");
    }

    private double totalBalanceCalculation(List<Customer> customers) {
        double totalBalance = 0;
        for (Customer customer : customers) {
            totalBalance += customer.getBalance();
        }
        return totalBalance;
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos el idCliente
        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
        Customer customer = new CustomerDaoJDBC().search(new Customer(idCustomer));
        request.setAttribute("customer", customer);
        String jspEdit = "/WEB-INF/pages/customer/editCustomer.jsp";
        request.getRequestDispatcher(jspEdit).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "insert":
                    this.insertCustomer(request, response);
                    break;
                case "update":
                    this.modifyCustomer(request, response);
                    break;
                default:
                    this.actionDefault(request, response);
            }
        } else {
            this.actionDefault(request, response);
        }
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        double balance = 0;
        String balanceString = request.getParameter("balance");
        if (balanceString != null && !"".equals(balanceString)) {
            balance = Double.parseDouble(balanceString);
        }
        
        Customer customer = new Customer(name, lastName, email, phone, balance);       
        int modifyRecords = new CustomerDaoJDBC().insert(customer);
        System.out.println("modifyRecords = " + modifyRecords);        
        this.actionDefault(request, response);
    }

    private void modifyCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        double balance = 0;
        String balanceString = request.getParameter("balance");
        if (balanceString != null && !"".equals(balanceString)) {
            balance = Double.parseDouble(balanceString);
        }        
        Customer customer = new Customer(idCustomer, name, lastName, email, phone, balance);        
        int modifyRecords = new CustomerDaoJDBC().update(customer);
        System.out.println("modifyRecords = " + modifyRecords);        
        this.actionDefault(request, response);
    }
    
    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        int idCustomer = Integer.parseInt(request.getParameter("idCustomer")); 
        Customer customer = new Customer(idCustomer);        
        int modifyRecords = new CustomerDaoJDBC().delete(customer);
        System.out.println("modifyRecords = " + modifyRecords);        
        this.actionDefault(request, response);
    }
}
