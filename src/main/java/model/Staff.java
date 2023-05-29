package model;

public class Staff {

    private int staffId;
    private String staffName;
    private String staffEmail;
    private String staffAddress;
    private String phoneNumber;
    private double salary;
    private String department;

    public Staff() {
    }

    public Staff(int staffId, String staffName, String staffEmail, String staffAddress, String phoneNumber, double salary,String department) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.staffEmail = staffEmail;
        this.staffAddress = staffAddress;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.department = department;
    }
    public Staff( String staffName, String staffEmail, String staffAddress, String phoneNumber, double salary,String department) {
        this.staffName = staffName;
        this.staffEmail = staffEmail;
        this.staffAddress = staffAddress;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.department = department;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
