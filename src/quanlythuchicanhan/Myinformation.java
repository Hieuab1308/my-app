/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuchicanhan;

import java.util.Date;

/**
 *
 * @author HIEU
 */
public class Myinformation {
    private int cccd;
    private String name;
    private String add;
    private String congviec;
    private String date;
    private int luong;

    public Myinformation() {
    }

    public Myinformation(int cccd, String name, String add, String congviec,String date, int luong) {
        this.cccd = cccd;
        this.name = name;
        this.add = add;
        this.congviec = congviec;
        this.date = date;
        this.luong = luong;
    }

    public int getCccd() {
        return cccd;
    }

    public void setCccd(int cccd) {
        this.cccd = cccd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getCongviec() {
        return congviec;
    }

    public void setCongviec(String congviec) {
        this.congviec = congviec;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }
    
    
}
