/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transaksidata;

/**
 *
 * @author lenovo
 */
public class mainTrans {
    
    public static void main(String[] args) {
        
        viewTrans view = new viewTrans();
        modTrans model = new modTrans();
        
        conTrans controller = new conTrans(model, view);
    }
    
}
