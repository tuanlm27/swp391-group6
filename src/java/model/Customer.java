/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Customer model class
 */
public class Customer {

    private int customerID;
    private String phone;
    private String customerName;
    private String password;
    private String email;
    private String address;

    public Customer() {
    }

    public Customer(int customerID, String phone, String customerName, String password, String email, String address) {
        this.customerID = customerID;
        this.phone = phone;
        this.customerName = customerName;
        this.password = password;
        this.email = email;
        this.address = address;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerID=" + customerID + ", phone=" + phone + ", customerName=" + customerName + ", password=" + password + ", email=" + email + ", address=" + address + '}';
    }

    
}
