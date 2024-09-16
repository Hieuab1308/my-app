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
public class Nguonchi implements Serializable {
    private String ID;
    private String name;
    private String date;
    private int money;

    public Nguonchi() {
    }

    public Nguonchi(String ID, String name, int money, String date) {
        this.ID = ID;
        this.name = name;
        this.date = date;
        this.money = money;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Nguonchi{" + "ID=" + ID + ", name=" + name + ", date=" + date + ", money=" + money + '}';
    }
    
    
}
