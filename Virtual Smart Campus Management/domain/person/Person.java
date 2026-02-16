package com.mycompany.OOP_Project.domain.person;

import com.mycompany.OOP_Project .util.interfaces.Notifiable;

public abstract class Person implements Notifiable {
    private int id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String address;
    private int age;
    private String email;
    private String pass;
    
    public Person(int id, String firstName, String lastName, String middleName, String address, int age, String email, String pass) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.address = address;
        this.age = age;
        this.email = email;
        this.pass = pass;
    }
    
    public int getId() {return id;}
    public void setId(int id) { this.id = id;}

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName != null ? middleName : ""; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email; }

    public String getPass() {return pass;}
    public void setPass(String pass) {this.pass = pass;}
    
    public boolean login(String email, String pass) {
        return this.email.equals(email) && this.pass.equals(pass);
    }

    public abstract void viewProfile();
    
    @Override
    public void sendNotification(String message) {
        System.out.println("Notification for " + firstName + " " + lastName + ": " + message);
    }

    @Override
    public String toString() {
        return "Person{" + id + ", firstName=" + firstName + ", lastName=" + lastName +", middleName=" + (middleName.isEmpty() ? "N/A" : middleName) +", address=" + address + ", age=" + age + ", email=" + email + "}";
    }
}
