/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;


import java.awt.Component;
import java.awt.Font;
import java.io.IOException;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.FontUIResource;
import quanlythuchicanhan.Nguonchi;
import javax.swing.table.DefaultTableModel;
import quanlythuchicanhan.ImportDataNguonchi;
import quanlythuchicanhan.ImportDataNguonchi;
import quanlythuchicanhan.ImportDataNguonthu;
import quanlythuchicanhan.Myinformation;
import quanlythuchicanhan.Nguonthu;
import quanlythuchicanhan.checkDate;
import static quanlythuchicanhan.checkDate.formatDate;

/**
 *
 * @author HIEU
 */
public class MainFrame extends javax.swing.JFrame {

    List<Nguonchi> list = new ArrayList<Nguonchi>();
    List<Nguonthu> lists = new ArrayList<Nguonthu>();
    List<Myinformation> list1 = new ArrayList<Myinformation>();
    HashMap<String, Integer> mapchi = new HashMap<>();
    HashMap<String, Integer> mapthu = new HashMap<>();
    Nguonchi chi;
    Nguonthu thu;
    Myinformation ifo;
    private final String path = "C:\\Users\\HIEU\\code java\\quanlythuchicanhan\\thu.bin";
    private final String paths = "C:\\Users\\HIEU\\code java\\quanlythuchicanhan\\chi.bin";
    private static int str = 0;
    private static int check = 0;
    JPanel panel;
    public MainFrame() throws IOException, ClassNotFoundException {
        initComponents();
        setLocationRelativeTo(null);
        
        
        
        
        //nguon thu
    //    private final String path = "C:\\Users\\HIEU\\code java\\quanlythuchicanhan\\src\\quanlythuchicanhan\\dataNguonthu.bin";
        lists = ImportDataNguonthu.readNguonthusFromBin("C:\\Users\\HIEU\\code java\\quanlythuchicanhan\\thu.bin");
        Views();
        ViewTables();
        
//        lists.add(new Nguonthu(1,"luong",1000, "12/12/2023"));
//        lists.add(new Nguonthu(2,"luong",10010, "2/1/2023"));
//        lists.add(new Nguonthu(3,"luong",10010, "19/11/2023"));
//        View();
//        ViewTable();
        //nguon chi
        list = ImportDataNguonchi.readNguonchisFromBin("C:\\Users\\HIEU\\code java\\quanlythuchicanhan\\chi.bin");
        View();
        ViewTable();
        
        list1.add(new Myinformation(22010104,"Nguyễn Danh Hiêu","Hải Dương","Sinh viên","13/08/2004",2500000));
        ViewInfor();
    }
    
    
    
    public void ViewInfor(){
        ifo = list1.get(str);
        this.txtID.setText(" " + ifo.getCccd());
        this.txtNamecn.setText(ifo.getName());
        this.txtAdress.setText(ifo.getAdd());
        this.txtWorkplace.setText(ifo.getCongviec());
        this.txtDoB.setText(ifo.getDate());
        this.txtluong.setText(""+ifo.getLuong());
    }
    
    //nguồn thu
    public void Views(){
        thu = lists.get(str);
        this.txtNOthu.setText("" + thu.getID());
        this.txtNamethu.setText(thu.getName());
        this.txtSoMthu.setText(""+thu.getMoney());
        this.txtDatethu.setText(thu.getDate());
        
        Onoff(true, false);
        //check = 1;
    }
    
    public void ViewTables(){
        DefaultTableModel model = (DefaultTableModel) this.tablethu.getModel();
        model.setNumRows(0);
        for(Nguonthu thu : lists){
            model.addRow(new Object[] { thu.getID(),thu.getName(),thu.getMoney(),thu.getDate()});
        }
    }
    
    public void VIewTablethu(){
        DefaultTableModel model = (DefaultTableModel) this.tablecanhan.getModel();
        model.setNumRows(0);
        for(Nguonthu thu : lists){
            model.addRow(new Object[] {thu.getID(),thu.getName(),thu.getMoney(),thu.getDate()});
        }
    }
    
    public void VIewTablechi(){
        DefaultTableModel model = (DefaultTableModel) this.tablecanhan.getModel();
        model.setNumRows(0);
        for(Nguonchi chi : list){
            model.addRow(new Object[] {chi.getID(),chi.getName(),chi.getMoney(),chi.getDate()});
        }
    }
    
    public void Onoff(boolean a, boolean b){
        this.btnAdd.show(a);
        this.btnSua.show(a);
        this.btnDelete.show(a);
        
        this.btnSave.show(b);
        this.tbnHuybo.show(b);
    }
    
    //nguồn chi
    public void View(){
        chi = list.get(str);
        this.txtNOchi.setText(""+chi.getID());
        this.txtNamechi.setText(chi.getName());
        this.txtSoMchi.setText(""+chi.getMoney());
        this.txtDatechi.setText(chi.getDate());
        onoff(true,false);
    }
    
    public void ViewTable(){
        DefaultTableModel  model = (DefaultTableModel) this.tablechi.getModel();
        model.setNumRows(0);
        for(Nguonchi chi : list){
            model.addRow(new Object[] {chi.getID(),chi.getName(),chi.getMoney(),chi.getDate()});
        }
    }
    
    public void Viewtablethu(){
        DefaultTableModel  model = (DefaultTableModel) this.tablecanhan.getModel();
        model.setNumRows(0);
        
        for(String key : mapthu.keySet()){
            model.addRow(new Object[]{key , mapthu.get(key)});
        }
    }
    
    public void Viewtablechi(){
        DefaultTableModel model = (DefaultTableModel)this.tablecanhan.getModel();
        model.setNumRows(0);
        for(String key : mapchi.keySet()){
            model.addRow(new Object[] {key,mapchi.get(key)});
        }
    }
    
    public void onoff(boolean a, boolean b){
        this.btnAdd2.show(a);
        this.btnXoa.show(a);
        this.btnSua2.show(a);
        
        this.btnLuu2.show(b);
        this.tbnhuybo.show(b);
        //this.btnSapxep2.show(b);
        //this.btnThongke1.show(b);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNamethu = new javax.swing.JTextField();
        txtSoMthu = new javax.swing.JTextField();
        txtDatethu = new javax.swing.JTextField();
        txtNOthu = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablethu = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        tbntimkiem = new javax.swing.JButton();
        tbnHuybo = new javax.swing.JButton();
        tnbHuytimkiem = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtNamechi = new javax.swing.JTextField();
        txtSoMchi = new javax.swing.JTextField();
        txtDatechi = new javax.swing.JTextField();
        txtNOchi = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablechi = new javax.swing.JTable();
        btnAdd2 = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLuu2 = new javax.swing.JButton();
        btnSua2 = new javax.swing.JButton();
        tbnTimkiem2 = new javax.swing.JButton();
        tbnhuybo = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnIn = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtNamecn = new javax.swing.JTextField();
        txtluong = new javax.swing.JTextField();
        txtDoB = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtAdress = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtWorkplace = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablecanhan = new javax.swing.JTable();
        tnbthongkenguonthu = new javax.swing.JButton();
        tbnthongkenguonchi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý thu chi");

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));
        jPanel1.setForeground(new java.awt.Color(255, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("QUẢN LÝ THU CHI CÁ NHÂN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tên:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Số tiền:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Ngày:");

        txtNamethu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtSoMthu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSoMthu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoMthuActionPerformed(evt);
            }
        });

        txtDatethu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtNOthu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNOthu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNOthuActionPerformed(evt);
            }
        });

        tablethu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Tên", "Số tiền(đồng)", "Ngày"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablethu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablethuMouseClicked(evt);
            }
        });
        tablethu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablethuKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablethuKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablethu);

        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDelete.setText("Xoá");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        tbntimkiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbntimkiem.setText("Tìm kiếm");
        tbntimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbntimkiemActionPerformed(evt);
            }
        });

        tbnHuybo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbnHuybo.setText("Huỷ bỏ");
        tbnHuybo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnHuyboActionPerformed(evt);
            }
        });

        tnbHuytimkiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tnbHuytimkiem.setText("Huỷ tìm kiếm");
        tnbHuytimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnbHuytimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tbnHuybo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(tbntimkiem))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDatethu, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoMthu, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamethu, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNOthu, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tnbHuytimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNOthu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNamethu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSoMthu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDatethu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnSua)
                                .addComponent(btnDelete)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbnHuybo)
                            .addComponent(tbntimkiem))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tnbHuytimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Nguồn thu", jPanel2);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("ID:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Tên:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Số tiền:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Ngày:");

        txtNamechi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtSoMchi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtDatechi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtNOchi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tablechi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Tên", "Số tiền(đồng)", "Ngày"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablechi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablechiMouseClicked(evt);
            }
        });
        tablechi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablechiKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tablechi);

        btnAdd2.setText("Thêm");
        btnAdd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd2ActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLuu2.setText("Lưu");
        btnLuu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuu2ActionPerformed(evt);
            }
        });

        btnSua2.setText("Sửa");
        btnSua2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua2ActionPerformed(evt);
            }
        });

        tbnTimkiem2.setText("Tìm kiếm");
        tbnTimkiem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnTimkiem2ActionPerformed(evt);
            }
        });

        tbnhuybo.setText("Huỷ bỏ");
        tbnhuybo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnhuyboActionPerformed(evt);
            }
        });

        jButton2.setText("Huỷ tìm kiếm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDatechi, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoMchi, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamechi, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNOchi, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap(17, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLuu2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSua2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbnhuybo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbnTimkiem2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtNOchi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtNamechi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtSoMchi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtDatechi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoa)
                            .addComponent(btnAdd2)
                            .addComponent(btnSua2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLuu2)
                            .addComponent(tbnTimkiem2)
                            .addComponent(tbnhuybo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nguồn chi", jPanel5);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("ID:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Tên:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Lương:");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Ngày sinh:");

        txtNamecn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtluong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtDoB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Địa chỉ:");

        txtAdress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Việc làm:");

        txtWorkplace.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tablecanhan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tên", "Số tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablecanhan);

        tnbthongkenguonthu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tnbthongkenguonthu.setText("Thống kê nguồn thu");
        tnbthongkenguonthu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnbthongkenguonthuActionPerformed(evt);
            }
        });

        tbnthongkenguonchi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbnthongkenguonchi.setText("Thống kê nguồn chi");
        tbnthongkenguonchi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnthongkenguonchiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnInLayout = new javax.swing.GroupLayout(btnIn);
        btnIn.setLayout(btnInLayout);
        btnInLayout.setHorizontalGroup(
            btnInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnInLayout.createSequentialGroup()
                .addGroup(btnInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btnInLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(btnInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(btnInLayout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtWorkplace, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(btnInLayout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(btnInLayout.createSequentialGroup()
                                .addGroup(btnInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(btnInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDoB, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtluong, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNamecn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(btnInLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(btnInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tnbthongkenguonthu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tbnthongkenguonchi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnInLayout.setVerticalGroup(
            btnInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnInLayout.createSequentialGroup()
                .addGroup(btnInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btnInLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(btnInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(btnInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtNamecn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(btnInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(btnInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtDoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(btnInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(btnInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtWorkplace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tnbthongkenguonthu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbnthongkenguonchi))
                    .addGroup(btnInLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cá nhân", btnIn);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1)
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNOthuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNOthuActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtNOthuActionPerformed

    private void btnAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd2ActionPerformed
        // TODO add your handling code here:
        this.txtNOchi.setText("");
        this.txtNamechi.setText("");
        this.txtSoMchi.setText("");
        this.txtDatechi.setText("");
        check = 1;
        
        onoff(false, true);
    }//GEN-LAST:event_btnAdd2ActionPerformed

    private void tablechiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablechiMouseClicked
        // TODO add your handling code here:
        str = this.tablechi.getSelectedRow();
        View();
    }//GEN-LAST:event_tablechiMouseClicked

    private void tablechiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablechiKeyReleased
        // TODO add your handling code here:
        str = this.tablechi.getSelectedRow();
        View();
    }//GEN-LAST:event_tablechiKeyReleased

    private void btnLuu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuu2ActionPerformed
        // TODO add your handling code here:
        String ID = (this.txtNOchi.getText());
        String name = this.txtNamechi.getText();
        int money = 0;
        String checkmoney = this.txtSoMchi.getText();
        String date = this.txtDatechi.getText();
        //kiểm tra điều kiện trước khi lưu
        if(check == 1){
            int kiemtra = 0;
            for(Nguonchi chi :list){
                if(chi.getID().equals(ID)){
                    kiemtra = 1;
                    break;
                }
            }
            
            //check form ngày
            int checkdate = 0;
            if(checkDate.isValidDateFormat(date))
            {
                Date d = checkDate.parseDate(date);
                if (d != null) {
                    String formattedDate = formatDate(d);
                } else {
                    checkdate = 1;
                }
            }
            else
            {
                checkdate = -1;
            }
            
            //check money
            boolean checkm;
            if(checkmoney.isEmpty())
            {
               checkm = false;
            }
            else
            {
                checkm = true;
                money = Integer.parseInt(checkmoney);
            }
            
            if(ID.isEmpty()||name.isEmpty()||checkm == false||date.isEmpty()){
                JOptionPane.showMessageDialog(null, "Các trường hợp không được để trống");
            }
            else if(kiemtra == 1){
                JOptionPane.showMessageDialog(null, "Id đã tồn tại!");
           }else if(money < 1000){
               JOptionPane.showMessageDialog(null, "Số tiền không hợp lệ ( lớn hơn 1000)!");
            }
            else if(checkdate == 1){
                JOptionPane.showMessageDialog(null, "Nhập sai ngày/tháng/năm!");
            }
            else if(checkdate == -1)
            {
                JOptionPane.showMessageDialog(null, "Nhập sai ngày/tháng/năm!");
            }
    
            else{
                list.add(new Nguonchi(ID,name,money,date));
                try {
                    ImportDataNguonchi.addNguonchi(new Nguonchi(ID, name, money, date), paths);
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "Thêm thành công!");
                View();
                ViewTable();
            }
        }
        
        //lưu sau khi sửa
        else if(check == -1){
            int checkdate = 0;
            if(checkDate.isValidDateFormat(date))
            {
                Date d = checkDate.parseDate(date);
                if (d != null) {
                    String formattedDate = formatDate(d);
                } else {
                    checkdate = 1;
                }
            }
            else
            {
                checkdate = -1;
            }
             boolean checkm;
            if(checkmoney.isEmpty())
            {
               checkm = false;
            }
            else
            {
                checkm = true;
                money = Integer.parseInt(checkmoney);
            }
            
            if(ID.isEmpty()||name.isEmpty()||checkm == false||date.isEmpty()){
                JOptionPane.showMessageDialog(null, "Các trường hợp không được để trống");
            }
            else if(money < 1000){
                JOptionPane.showMessageDialog(null, "Số tiền không hợp lệ ( lớn hơn 1000)!");
            }
            else if(checkdate == 1)
            {
                JOptionPane.showMessageDialog(null, "Nhập sai ngày/tháng/năm!");
            }
            else if(checkdate == -1)
            {
                JOptionPane.showMessageDialog(null, "Nhập sai ngày/tháng/năm!");
            }
            else{
                list.set(str, new Nguonchi(ID,name,money,date));
                try {
                    ImportDataNguonchi.EditNguonchi(str, paths, new Nguonchi(ID, name, money, date));
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "Sửa thành công!");
                View();
                ViewTable();
            }
                
        } 
    }//GEN-LAST:event_btnLuu2ActionPerformed

    private void btnSua2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua2ActionPerformed
        // TODO add your handling code here:
        onoff(false, true);
        check = -1;
    }//GEN-LAST:event_btnSua2ActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(this, "Nhập ID cần xóa");
        int check = 0;
        int p = -1;
        if(input == null)
        {
            return;
        }
        else
        {
            for(Nguonchi st:list)
            {
                p++;
                if(st.getID().equals(input)) 
                {
                    check = 1;
                    str = p;
                    break;
                }
            }
            if(check == 1)
            {
                int n = JOptionPane.showConfirmDialog(panel, "Bạn có muốn xóa không?");
                if(n == JOptionPane.YES_OPTION)
                {
                    list.remove(str);
                    try {
                        ImportDataNguonchi.deleteNguonchi(str,paths);
                    } catch (IOException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(n == JOptionPane.NO_OPTION)
                {
                    return;
                }
                else return;  
                str= 0;
        View();
        ViewTable();
            }
            else if(input.isEmpty() || check != 1)
            {
                JOptionPane.showMessageDialog(null, "Không tìm thấy nguồn chi cần xoá");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tbnHuyboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnHuyboActionPerformed
        // TODO add your handling code here:
        Views();
       
    }//GEN-LAST:event_tbnHuyboActionPerformed

    private void tbnhuyboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnhuyboActionPerformed
        // TODO add your handling code here:
        View();
    }//GEN-LAST:event_tbnhuyboActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
            // TODO add your handling code here:
        this.txtNOthu.setText("");
        this.txtNamethu.setText("");
        this.txtSoMthu.setText("");
        this.txtDatethu.setText("");
        check = 1;
        
        Onoff(false, true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String ID = (this.txtNOthu.getText());
        String name = this.txtNamethu.getText();
        int money = 0;
        String checkmoney = this.txtSoMthu.getText();
        String date = this.txtDatethu.getText();
        //kiểm tra điều kiện trước khi lưu
        //lưu sau khi thêm
        if(check == 1){
            int kiemtra = 0;
            for(Nguonthu thu :lists){
                //check ID
                if(thu.getID().equals(ID)){
                    kiemtra = 1;
                    break;
                }
            }
            
            //check formDate
            int checkdate = 0;
            if(checkDate.isValidDateFormat(date))
            {
                Date d = checkDate.parseDate(date);
                if (d != null) {
                    String formattedDate = formatDate(d);
                } else { 
                    checkdate = 1;
                }
            }
            else
            {
                checkdate = -1;
            }
            
            //check money
            boolean checkm;
            if(checkmoney.isEmpty())
            {
               checkm = false;
            }
            else
            {
                checkm = true;
                money = Integer.parseInt(checkmoney);
            }
            
            if(ID.isEmpty()||name.isEmpty()||checkm == false||date.isEmpty()){
                JOptionPane.showMessageDialog(null, "Các trường hợp không được để trống");
            }
            else if(kiemtra == 1){
                JOptionPane.showMessageDialog(null, "Id đã tồn tại!");
            }else if(money < 1000){
               JOptionPane.showMessageDialog(null, "Số tiền không hợp lệ ( lớn hơn 1000)!");
            }
            else if(checkdate == 1){
                JOptionPane.showMessageDialog(null, "Nhập sai ngày/tháng/năm!");
            }
            else if(checkdate == -1)
            {
                JOptionPane.showMessageDialog(null, "Nhập sai ngày/tháng/năm!");
            }
            else{
                lists.add(new Nguonthu(ID,name,money,date));
                try {
                    ImportDataNguonthu.addNguonthu(new Nguonthu(ID,name,money,date), path);
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "Thêm thành công!");
                Views();
                ViewTables();
            }
        }
        //lưu sau khi sửa
        else if(check == -1){
            int checkdate = 0;
            if(checkDate.isValidDateFormat(date))
            {
                Date d = checkDate.parseDate(date);
                if (d != null) {
                    String formattedDate = formatDate(d);
                } else {
                    checkdate = 1;
                }
            }
            else
            {
                checkdate = -1;
            }
            
            boolean checkm;
            if(checkmoney.isEmpty())
            {
               checkm = false;
            }
            else
            {
                checkm = true;
                money = Integer.parseInt(checkmoney);
            }
            
            if(ID.isEmpty()||name.isEmpty()||checkm == false||date.isEmpty()){
                JOptionPane.showMessageDialog(null, "Các trường hợp không được để trống");
            }
            else if(money < 1000){
                JOptionPane.showMessageDialog(null, "Số tiền không hợp lệ ( lớn hơn 1000)!");
            }
            else if(checkdate == 1){
                JOptionPane.showMessageDialog(null, "Nhập sai ngày/tháng/năm!");
            }
            else if(checkdate == -1)
            {
                JOptionPane.showMessageDialog(null, "Nhập sai ngày/tháng/năm!");
            }
            else{
                lists.set(str, new Nguonthu(ID,name,money,date));
                try {
                    ImportDataNguonthu.Editnguonthu(str, path, new Nguonthu(ID, name, money, date));
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "Sửa thành công!");
                Views();
                ViewTables();
            }
                
        } 
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(this, "Nhập ID cần xóa");
        int check = 0;
        int p = -1;
        if(input == null)
        {
            return;
        }
        else
        {
            for(Nguonthu st:lists)
            {
                p++;
                if(st.getID().equals(input)) 
                {
                    check = 1;
                    str = p;
                    break;
                }
            }
            if(check == 1)
            {
                int n = JOptionPane.showConfirmDialog(panel, "Bạn có muốn xóa không?");
                if(n == JOptionPane.YES_OPTION)
                {
                    lists.remove(str);
                    try {
                        ImportDataNguonthu.deleteNguonthu(str,path);
                    } catch (IOException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(n == JOptionPane.NO_OPTION)
                {
                    return;
                }
                else return;  
                str= 0;
        Views();
        ViewTables();
            }
            else if(input.isEmpty() || check != 1)
            {
                JOptionPane.showMessageDialog(null, "Không tìm thấy nguồn thu cần xoá");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        Onoff(false, true);
        check = -1;
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tbntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbntimkiemActionPerformed
        // TODO add your handling code here:
        String inputID = (JOptionPane.showInputDialog(this,"Nhập số Name cần tìm"));
        int idex  =  0;
        boolean checkRusl = false;
        DefaultTableModel model = (DefaultTableModel) this.tablethu.getModel();
        model.setNumRows(0);
        for(Nguonthu thu : lists){
            if(thu.getName().equals(inputID)){
                model.addRow(new Object[]{thu.getID(),thu.getName(),thu.getMoney(),thu.getDate()});
                checkRusl = true;
                str = idex;
                //break;
            }else
                idex++;
        }
        
        if(checkRusl == false){
            JOptionPane.showMessageDialog(null, "Lỗi! Không tìm thấy ID mà bạn nhập");
        }else{
             JOptionPane.showMessageDialog(null, "Thành công!");
           // Views();
        }
        
        
    }//GEN-LAST:event_tbntimkiemActionPerformed

    private void tbnTimkiem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnTimkiem2ActionPerformed
        // TODO add your handling code here:
        String inputID = (JOptionPane.showInputDialog(this,"Nhập name cần tìm"));
        int idex  = 0;
        boolean checkRusl = false;
        DefaultTableModel model = (DefaultTableModel) this.tablechi.getModel();
        model.setNumRows(0);
        
        for(Nguonchi chi : list){           
            if(chi.getName().equals(inputID)){
                model.addRow(new Object[]{chi.getID(),chi.getName(),chi.getMoney(),chi.getDate()});
                checkRusl = true;
                str = idex;
                //break;
            }else
                idex++;
        }
        
        if(checkRusl == false){
            JOptionPane.showMessageDialog(null, "Lỗi! Không tìm thấy ID mà bạn nhập");
        }else{
            JOptionPane.showMessageDialog(null, "Thành công!");
           //View();
        }
    }//GEN-LAST:event_tbnTimkiem2ActionPerformed

    private void tablethuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablethuMouseClicked
        // TODO add your handling code here:
        str = this.tablethu.getSelectedRow();
        Views();
    }//GEN-LAST:event_tablethuMouseClicked

    private void tablethuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablethuKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tablethuKeyPressed

    private void tablethuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablethuKeyReleased
        // TODO add your handling code here:
        str = this.tablethu.getSelectedRow();
        Views();
    }//GEN-LAST:event_tablethuKeyReleased

    private void tbnthongkenguonchiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnthongkenguonchiActionPerformed
        for(Nguonchi chi : list){
                if(mapchi.containsKey(chi.getName())){
                    mapchi.put(chi.getName(), chi.getMoney()+mapchi.get(chi.getName()));
                }
                else{
                    mapchi.put(chi.getName(),chi.getMoney());
                }
            }
        
        Viewtablechi();
        mapchi.clear();
     
        
    }//GEN-LAST:event_tbnthongkenguonchiActionPerformed

    private void tnbthongkenguonthuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnbthongkenguonthuActionPerformed
//        DefaultTableModel model = (DefaultTableModel) this.tablecanhan.getModel();
//        model.setNumRows(0);
        
       
            for(Nguonthu thu : lists){
                if(mapthu.containsKey(thu.getName())){
                    mapthu.put(thu.getName(), thu.getMoney()+mapthu.get(thu.getName()));
                }
                else{
                    mapthu.put(thu.getName(),thu.getMoney());
                }
            }
        
        Viewtablethu();
        mapthu.clear();
     
      
        
    }//GEN-LAST:event_tnbthongkenguonthuActionPerformed

    private void tnbHuytimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnbHuytimkiemActionPerformed
        // TODO add your handling code here:
        ViewTables();
    }//GEN-LAST:event_tnbHuytimkiemActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ViewTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtSoMthuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoMthuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoMthuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new MainFrame().setVisible(true);
//               } catch (IOException ex) {
//                   Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//               } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//                }
//           }
//       });
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAdd2;
    private javax.swing.JButton btnDelete;
    private javax.swing.JPanel btnIn;
    private javax.swing.JButton btnLuu2;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSua2;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tablecanhan;
    private javax.swing.JTable tablechi;
    private javax.swing.JTable tablethu;
    private javax.swing.JButton tbnHuybo;
    private javax.swing.JButton tbnTimkiem2;
    private javax.swing.JButton tbnhuybo;
    private javax.swing.JButton tbnthongkenguonchi;
    private javax.swing.JButton tbntimkiem;
    private javax.swing.JButton tnbHuytimkiem;
    private javax.swing.JButton tnbthongkenguonthu;
    private javax.swing.JTextField txtAdress;
    private javax.swing.JTextField txtDatechi;
    private javax.swing.JTextField txtDatethu;
    private javax.swing.JTextField txtDoB;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNOchi;
    private javax.swing.JTextField txtNOthu;
    private javax.swing.JTextField txtNamechi;
    private javax.swing.JTextField txtNamecn;
    private javax.swing.JTextField txtNamethu;
    private javax.swing.JTextField txtSoMchi;
    private javax.swing.JTextField txtSoMthu;
    private javax.swing.JTextField txtWorkplace;
    private javax.swing.JTextField txtluong;
    // End of variables declaration//GEN-END:variables
}
