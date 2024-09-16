/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuchicanhan;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author HIEU
 */
public class Nguonthu implements Serializable{
    private String ID;
    private  String name;
    private int money;
    private String date;

    public Nguonthu() {
    }

    public Nguonthu(String ID, String name, int money, String date) {
        this.ID = ID;
        this.name = name;
        this.money = money;
        this.date = date;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Nguonthu{" + "ID=" + ID + ", name=" + name + ", money=" + money + ", date=" + date + '}';
    }
    
    
    
    
    
}
