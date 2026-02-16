package com.mycompany.OOP_Project.domain.person;

public class Staff extends Person {
    private String department;
    private String jobTitle;
    
    public Staff(int id, String firstName, String lastName, String middleName, String address, int age, String email, String pass, String department, String jobTitle) {
        super(id, firstName, lastName, middleName, address, age, email, pass);
        this.department = department;
        this.jobTitle = jobTitle;
    }

    public String getDepartment() {return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getJobTitle() {return jobTitle;}
    public void setJobTitle(String jobTitle) {this.jobTitle = jobTitle; }
   
    @Override
    public void viewProfile() {
        System.out.println("Staff Profile");
        System.out.println("ID: " + getId());
        System.out.println("First Name: " + getFirstName());
        System.out.println("Last Name: " + getLastName());
        System.out.println("Middle Name: " + (getMiddleName().isEmpty() ? "N/A" : getMiddleName()));
        System.out.println("Address: " + getAddress());
        System.out.println("Age: " + getAge());
        System.out.println("Email: " + getEmail());
        System.out.println("Department: " + department);
        System.out.println("Job Title: " + jobTitle);
    }
    
    @Override
    public String toString() {
        return"Staff{" + super.toString()+ "department=" + department + ", jobTitle=" + jobTitle + '}'; 
    }  
}
