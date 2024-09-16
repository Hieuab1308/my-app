/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuchicanhan;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HIEU
 */
public class ImportDataNguonthu {
    public static List<Nguonthu> readNguonthuFromCSV(String filePath) throws FileNotFoundException, IOException{
        List<Nguonthu> thus = new ArrayList<Nguonthu>();
        
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String header =  reader.readLine();
            String line;
            
            while((line = reader.readLine()) != null){
                String[] row = line.split(",");
                
                //lấy dữ liệu từ mảng row và khởi tạo đối tượng Nguonthu
                String ID = (row[0]);
                String name = row[1];
                int money = Integer.parseInt(row[2]);
                String date = row[3];
                
                Nguonthu thu = new Nguonthu(ID,name,money,date);
                thus.add(thu);
            }
        }catch(IOException e){
                e.printStackTrace();
                }
        return thus;
    }
    
    //đọc file bin
    public static ArrayList<Nguonthu> readNguonthusFromBin(String filePath) throws IOException, ClassNotFoundException{
        ArrayList<Nguonthu> thu = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))){
            ArrayList<Nguonthu> listthu = (ArrayList<Nguonthu>) in.readObject();
            for(Nguonthu s : listthu){
                String ID = s.getID();
                String name = s.getName();
                int money = s.getMoney();
                String date = s.getDate();
                
                thu.add(new Nguonthu(ID,name,money,date));
            }
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return thu;
    }
    
    //ghi file data
    public static void WriteNguonthuToBin(ArrayList<Nguonthu> thu , String filePath){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(thu);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //them
    public static void addNguonthu(Nguonthu newNguonthu, String filePath) throws IOException, ClassNotFoundException {
        ArrayList<Nguonthu> existingnguonthu = readNguonthusFromBin(filePath);
        existingnguonthu.add(newNguonthu);
        WriteNguonthuToBin(existingnguonthu, filePath);
    }
    
    //delete
    public static void deleteNguonthu(int str, String filePath) throws IOException, ClassNotFoundException{
        ArrayList<Nguonthu> existingnguonthu = readNguonthusFromBin(filePath);
        existingnguonthu.remove(str);
        WriteNguonthuToBin(existingnguonthu, filePath);
    }
    
    //sửa
    public static void Editnguonthu(int str, String filePath,Nguonthu thu) throws IOException, ClassNotFoundException{
        ArrayList<Nguonthu> existingnguonthu = readNguonthusFromBin(filePath);
        existingnguonthu.set(str, thu);
        WriteNguonthuToBin(existingnguonthu, filePath);
    }
    
    
    
}
