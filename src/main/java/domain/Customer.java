package domain;

public class Customer {
    private int idCustomer;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private double balance;

    public Customer() {
    }

    public Customer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Customer(String name, String lastName, String email, String phone, double balance) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
    }

    public Customer(int idCustomer, String name, String lastName, String email, String phone, double balance) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Customer{" + "idCustomer=" + idCustomer + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + ", balance=" + balance + '}';
    }

    
}
