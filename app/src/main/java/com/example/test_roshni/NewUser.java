package com.example.test_roshni;

public class NewUser {

    private String u_name;
    private String u_email;
    private String u_phone;
    private String u_year;
    private String u_dept;


    public NewUser(){
        //empty public constructor to pass data back and forth
    }
    public NewUser(String u_name, String u_email, String u_phone, String u_dept, String u_year) {
        this.u_name = u_name;
        this.u_email = u_email;
        this.u_phone = u_phone;
        this.u_year = u_year;
        this.u_dept = u_dept;

    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public String getU_phone() {
        return u_phone;
    }

    public void setU_phone(String u_phone) {
        this.u_phone = u_phone;
    }

    public String getU_year() {
        return u_year;
    }

    public void setU_year(String u_year) {
        this.u_year = u_year;
    }

    public String getU_dept() {
        return u_dept;
    }

    public void setU_dept(String u_dept) {
        this.u_dept = u_dept;
    }
}
