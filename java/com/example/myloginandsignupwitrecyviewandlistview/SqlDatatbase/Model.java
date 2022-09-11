package com.example.myloginandsignupwitrecyviewandlistview.SqlDatatbase;

public class Model {
    int _id;

    String name,number,pasword;

    public Model() {
        this._id = _id;
        this.name = name;
        this.number = number;
        this.pasword = pasword;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
}
