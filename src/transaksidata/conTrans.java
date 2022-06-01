/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transaksidata;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author lenovo
 */

public class conTrans {
    modTrans modelData;
    viewTrans viewData;

    public String pilidTrans, pilnamaBrg, pilnamaKasir, piljmlBrg, pilhargaBrg, pildiskon;

    public conTrans(modTrans modelData, viewTrans viewData) {
        this.modelData = modelData;
        this.viewData = viewData;

        if (modelData.getJmlData()!=0) {
            String[][] dataTransaksi = modelData.listTransaksi();
            viewData.tabel.setModel((new JTable(dataTransaksi, viewData.judul)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data masih kosong");
        }


        viewData.btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String id = viewData.getidTrans();
                String nama = viewData.getnamaBrg();
                String kasir = viewData.getnamaKasir();
                String jumlah = viewData.getjmlBrg();
                String harga = viewData.gethargaBrg();
                String diskon = viewData.getdiskon();
                double total = viewData.getTotal();
                modelData.insertData(id, nama, kasir, jumlah, harga, diskon, total);

                String[][] dataTransaksi = modelData.listTransaksi();
                viewData.tabel.setModel((new JTable(dataTransaksi, viewData.judul)).getModel());
            }
        });
        
        viewData.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);

                int baris = viewData.tabel.getSelectedRow();
                
                pilidTrans = viewData.tabel.getValueAt(baris, 0).toString();
                pilnamaBrg = viewData.tabel.getValueAt(baris, 1).toString();
                pilnamaKasir = viewData.tabel.getValueAt(baris, 2).toString();       
                piljmlBrg = viewData.tabel.getValueAt(baris, 3).toString();
                pilhargaBrg = viewData.tabel.getValueAt(baris, 4).toString();
                pildiskon = viewData.tabel.getValueAt(baris, 5).toString();
                
                viewData.tfidTrans.setText(pilidTrans);
                viewData.tfnamaBrg.setText(pilnamaBrg);
                viewData.tfnamaKasir.setText(pilnamaKasir);
                viewData.tfjmlBrg.setText(piljmlBrg);
                viewData.tfhargaBrg.setText(pilhargaBrg);
                viewData.tfdiskon.setText(pildiskon);
            }
               
        });

        viewData.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String id = viewData.getidTrans();
                String nama = viewData.getnamaBrg();
                String kasir = viewData.getnamaKasir();
                String jumlah = viewData.getjmlBrg();
                String harga = viewData.gethargaBrg();
                String diskon = viewData.getdiskon();
                double total = viewData.getTotal();
                modelData.updateData(id, nama, kasir, jumlah, harga, diskon, total);

                String[][] dataTransaksi = modelData.listTransaksi();
                viewData.tabel.setModel((new JTable(dataTransaksi, viewData.judul)).getModel());
            }
        });

        viewData.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda ingin menghapus data ini?", "Opsi", JOptionPane.YES_NO_OPTION);

                if (confirm == 0) {
                    String id = viewData.getidTrans();
                    modelData.deleteData(id);
                    
                    String[][] dataTransaksi = modelData.listTransaksi();
                    viewData.tabel.setModel((new JTable(dataTransaksi, viewData.judul)).getModel());
                } else {
                }
            }
        });

        viewData.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                viewData.tfidTrans.setText("");
                viewData.tfnamaBrg.setText("");
                viewData.tfnamaKasir.setText("");
                viewData.tfjmlBrg.setText("");
                viewData.tfhargaBrg.setText("");
                viewData.tfdiskon.setText("");
            }
        });
    }
   
 }
