/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transaksidata;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class modTrans {
    
    Connection cn;
    Statement st;
    
    String url  = "jdbc:mysql://localhost/trans_db";
    String user = "root";
    String pass = "";
   

    public modTrans() {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(url, user, pass);
            
            System.out.println("Terhubung");
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Gagal terhubung");
        }
    }

    public int getJmlData(){
        
        int bykData = 0;

        try {
            st = cn.createStatement();
            String querySQL = "SELECT * FROM transactions";
            ResultSet rs = st.executeQuery(querySQL);
            
            while (rs.next()){
                bykData++;
            }
            
            return bykData;
        } catch(SQLException e){
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public String[][] listTransaksi(){
        
        int bykData = 0;
        
        try {
            String[][] data = new String[getJmlData()][7];

            String querySQL = "SELECT * FROM transactions";
            ResultSet rs = st.executeQuery(querySQL);
            
            while (rs.next()){
                data[bykData][0] = rs.getString("id_trans");
                data[bykData][1] = rs.getString("nama_barang");
                data[bykData][2] = rs.getString("nama_kasir");
                data[bykData][3] = rs.getString("qty");
                data[bykData][4] = rs.getString("price_per_qty");
                data[bykData][5] = rs.getString("discount");
                data[bykData][6] = rs.getString("price_total");
                
                bykData++;
            }
            
            return data;
        } catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void insertData(String idTrans, String namaBrg, String namaKasir, String jmlBrg, String sHarga, String diskon, double totalHarga){
        int jmlData=0;

        try {
            String query = "SELECT * FROM transactions WHERE id_trans = '" + idTrans + "'";
            System.out.println(idTrans + " " + namaBrg + " " + namaKasir + " " + jmlBrg + " " + sHarga + " " + diskon + " " + totalHarga);
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                jmlData++;
            }

            if (jmlData == 0) {
                query = "INSERT INTO transactions VALUES('" + idTrans + "','" + namaBrg + "','" + namaKasir + "','" + jmlBrg + "','" + sHarga + "','" + diskon + "','" + totalHarga + "')";
                st = cn.createStatement();
                st.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan!");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void updateData(String idTrans, String namaBrg, String namaKasir, String jmlBrg, String sHarga, String diskon, double totalHarga){
        int jmlData = 0;

        try {
            String query = "SELECT * FROM transactions WHERE id_trans = '" + idTrans + "'";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                jmlData++;
            }

            if (jmlData == 1) {
                query = "UPDATE transactions SET id_trans = '" + idTrans + "', nama_barang = '" + namaBrg + "', nama_kasir = '" + namaKasir + "', qty = '" + jmlBrg + "', price_per_qty = '" + sHarga + "', discount = '" + diskon + "', price_total = '" + totalHarga + "' WHERE id_trans = '" + idTrans + "'";
                st = (Statement) cn.createStatement();
                st.executeUpdate(query);
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate!");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void deleteData (String data) {
        try{
            String query = "DELETE FROM transactions WHERE id_trans = '" + data + "'";
            st = cn.createStatement();
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus!");

        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
