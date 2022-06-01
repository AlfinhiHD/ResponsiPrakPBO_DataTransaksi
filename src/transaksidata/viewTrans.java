/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transaksidata;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenovo
 */
public class viewTrans extends JFrame{
    
    JLabel labtitle = new JLabel("PROGRAM DATA TRANSAKSI");
    JLabel labidTrans = new JLabel("ID Transaksi");
    JLabel labnamaBrg = new JLabel("Nama Barang");
    JLabel labnamaKasir = new JLabel("Nama Kasir");
    JLabel labjmlBrg = new JLabel("Jumlah Barang");
    JLabel labhargaBrg = new JLabel("Harga Satuan (Rp)");
    JLabel labdiskon = new JLabel("Diskon (Dalam persen)");
    

    public JTextField tfidTrans = new JTextField();
    public JTextField tfnamaBrg = new JTextField();
    public JTextField tfnamaKasir = new JTextField();
    public JTextField tfjmlBrg = new JTextField();
    public JTextField tfhargaBrg = new JTextField();
    public JTextField tfdiskon = new JTextField();

    public JButton btnInsert = new JButton("Insert");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnReset = new JButton("Reset");

    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane sp;
    public Object[] judul = {"ID Transaksi", "Nama Barang", "Nama Kasir", "Jumlah Barang", "Harga Satuan", "Diskon", "Total Harga"};

    public viewTrans() {
        
        dtm = new DefaultTableModel(judul, 0);
        tabel = new JTable(dtm);
        sp = new JScrollPane(tabel);

        setTitle("Responsi 123200142");
        setSize(850,630);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        
        
        add(sp);
        sp.setBounds(30, 48, 600, 522);
        
        //add label 
        add(labtitle);
        add(labidTrans);
        add(labnamaBrg);
        add(labnamaKasir);
        add(labjmlBrg);
        add(labhargaBrg);
        add(labdiskon);
        //add textfield
        add(tfidTrans);
        add(tfnamaBrg);
        add(tfnamaKasir);
        add(tfjmlBrg);
        add(tfhargaBrg);
        add(tfdiskon);
        //add button
        add(btnInsert);
        add(btnUpdate);
        add(btnDelete);
        add(btnReset);
        
        //setBounds(int x-coordinate, int y-coordinate, int width, int height)
        //desain tampilan ui diatas 
        labtitle.setBounds(350, 0, 180, 40);
        labidTrans.setBounds(655, 40, 90, 25);
        labnamaBrg.setBounds(655, 100, 90, 25);
        labnamaKasir.setBounds(655, 160, 90, 25);
        labjmlBrg.setBounds(655, 220, 90, 25);
        labhargaBrg.setBounds(655, 280, 110, 25);
        labdiskon.setBounds(655, 340, 130, 25);
        
        tfidTrans.setBounds(655, 70, 140, 25);
        tfnamaBrg.setBounds(655, 130, 140, 25);
        tfnamaKasir.setBounds(655, 190, 140, 25);
        tfjmlBrg.setBounds(655, 250, 140, 25);
        tfhargaBrg.setBounds(655, 310, 140, 25);
        tfdiskon.setBounds(655, 370, 140, 25);

        btnInsert.setBounds(655, 420, 140, 30);
        btnUpdate.setBounds(655, 460, 140, 30);
        btnDelete.setBounds(655, 500, 140, 30);
        btnReset.setBounds(655, 540, 140, 30);

    }

    public String getidTrans() {
        return tfidTrans.getText();
    }

    public String getnamaBrg() {
        return tfnamaBrg.getText();
    }

    public String getnamaKasir() {
        return tfnamaKasir.getText();
    }

    public String getjmlBrg() {
        return tfjmlBrg.getText();
    }

    public String gethargaBrg() {
        return tfhargaBrg.getText();
    }

    public String getdiskon() {
        return tfdiskon.getText();
    }
    
    public double getTotal(){
        String harga = gethargaBrg();
        String jumlah = getjmlBrg();
        String diskon = getdiskon();
        
        double harga2 = Float.parseFloat(harga);
        double jumlah2 = Float.parseFloat(jumlah);
        double diskon2 = Float.parseFloat(diskon);
        
        double total = harga2 * jumlah2;
        double total2 = total - (total * (diskon2/100));
    
        return total2;
    }
    
}
