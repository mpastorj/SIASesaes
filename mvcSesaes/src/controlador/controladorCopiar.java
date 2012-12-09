/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.VentanaTabla;

/**
 *
 * @author Milii2
 */
public class controladorCopiar implements ActionListener{

    private VentanaTabla vista;

    public controladorCopiar(VentanaTabla vista) {
        this.vista = vista;
        this.vista.copiar.addActionListener(this);
    }

    
    public controladorCopiar() {
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        StringSelection stsel;
        StringBuilder sbf = new StringBuilder();
        int rowCount = vista.tabla.getRowCount ();
        int colCount = vista.tabla.getColumnCount();
        String titulo=vista.titulo.getText();
        sbf.append(vista.titulo.getText());
        sbf.append("\n");
        sbf.append(vista.titulo2.getText());
        sbf.append("\n");
        //sbf.append(muestratotal.getText());
        //sbf.append(total.getText());
        sbf.append("\n");
        
        for(int i=0; i<colCount; i++){
            sbf.append(vista.tabla.getColumnName(i));
            if (i < colCount - 1) { sbf.append("\t"); }
        }
        sbf.append("\n");
            
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                sbf.append(vista.tabla.getValueAt(row,col));
                if (col < colCount - 1) { sbf.append("\t"); }
            }
            sbf.append("\n");
        }
        
        stsel = new StringSelection(sbf.toString());
        java.awt.datatransfer.Clipboard system = Toolkit.getDefaultToolkit().getSystemClipboard();
        system.setContents(stsel, stsel);
        
        javax.swing.JOptionPane.showMessageDialog (null, "La tabla ha sido copiada en el Portapapeles", "Estadísticas", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
