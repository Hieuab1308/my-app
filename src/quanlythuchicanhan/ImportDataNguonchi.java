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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import static quanlythuchicanhan.ImportDataNguonchi.readNguonchiFromCSV;
import quanlythuchicanhan.Nguonchi;

/**
 *
 * @author HIEU
 */
public class ImportDataNguonchi {
    public static List<Nguonchi> readNguonchiFromCSV(String filePath) throws FileNotFoundException, IOException{
        List<Nguonchi> chis = new ArrayList<Nguonchi>();
        
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String header =  reader.readLine();
            String line;
            
            while((line = reader.readLine()) != null){
                String[] row = line.split(",");
                
                //lấy dữ liệu từ mảng row và khởi tạo đối tượng Nguonchi
                String ID = (row[0]);
                String name = row[1];
                int money = Integer.parseInt(row[2]);
                String date = row[3];
                
                Nguonchi chi = new Nguonchi(ID,name,money,date);
                chis.add(chi);
            }
        }catch(IOException e){
                e.printStackTrace();
                }
        return chis;
    }
    
    public static ArrayList<Nguonchi> readNguonchisFromBin(String filePath) throws IOException, ClassNotFoundException{
        ArrayList<Nguonchi> chi = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))){
            ArrayList<Nguonchi> listchi = (ArrayList<Nguonchi>) in.readObject();
            for(Nguonchi s : listchi){
                String ID = s.getID();
                String name = s.getName();
                int money = s.getMoney();
                String date = s.getDate();
                
                chi.add(new Nguonchi(ID,name,money,date));
            }
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return chi;
    }
    
    //ghi file data
    public static void WriteNguonchiToBin(ArrayList<Nguonchi> chi , String filePath){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(chi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //them
    public static void addNguonchi(Nguonchi newNguonchi, String filePath) throws IOException, ClassNotFoundException {
        ArrayList<Nguonchi> existingNguonchi = readNguonchisFromBin(filePath);
        existingNguonchi.add(newNguonchi);
        WriteNguonchiToBin(existingNguonchi, filePath);
    }
    
    //delete
    public static void deleteNguonchi(int str, String filePath) throws IOException, ClassNotFoundException{
        ArrayList<Nguonchi> existingNguonchi = readNguonchisFromBin(filePath);
        existingNguonchi.remove(str);
        WriteNguonchiToBin(existingNguonchi, filePath);
    }
    
    //sửa
    public static void EditNguonchi(int str, String filePath,Nguonchi chi) throws IOException, ClassNotFoundException{
        ArrayList<Nguonchi> existingNguonchi = readNguonchisFromBin(filePath);
        existingNguonchi.set(str, chi);
        WriteNguonchiToBin(existingNguonchi, filePath);
    }
    
    
    
}
