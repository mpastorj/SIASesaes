/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.controladorAjustesIngreso;
import controlador.controladorConfiguracion;
import controlador.controladorDiurna;
import controlador.controladorPersona;
import controlador.controladorVespertina;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Array;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Milii2
 */

//
//
public class VentanaConfiguracion extends javax.swing.JFrame {

    /**
     * Creates new form VentanaConfiguracion
     */
    public VentanaConfiguracion() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        guardar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        eliminarregistro = new javax.swing.JComboBox();
        jRadioEliminar = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dianacimiento = new javax.swing.JComboBox();
        mesnacimiento = new javax.swing.JComboBox();
        añonacimiento = new javax.swing.JComboBox();
        especialidadprofesional = new javax.swing.JComboBox();
        nombreprofesional = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(360, 400));
        setResizable(false);

        guardar.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/IngresaProfesional_opt.png"))); // NOI18N
        guardar.setText("Guardar");
        guardar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        eliminar.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/eliminar.png"))); // NOI18N
        eliminar.setText("Eliminar");

        eliminarregistro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eliminarregistro.setEnabled(false);

        jRadioEliminar.setFont(new java.awt.Font("Calibri Light", 1, 15)); // NOI18N
        jRadioEliminar.setText("Eliminar Registro");

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 15)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel3.setText("Fecha de Nacimiento:");

        jLabel5.setFont(new java.awt.Font("Calibri Light", 0, 15)); // NOI18N
        jLabel5.setText("Especialidad:");

        dianacimiento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28" }));
        dianacimiento.setEnabled(false);
        dianacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dianacimientoActionPerformed(evt);
            }
        });

        mesnacimiento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        mesnacimiento.setEnabled(false);
        mesnacimiento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mesnacimientoItemStateChanged(evt);
            }
        });

        añonacimiento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993" }));
        añonacimiento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                añonacimientoItemStateChanged(evt);
            }
        });

        especialidadprofesional.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        especialidadprofesional.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione>", "Cirugía", "Enfermería", "Kinesiología", "Medicina General", "Medicina Interna", "Medicina en Hematología", "Neurología", "Nutriología", "Odontología General", "Psicología", "Psiquiatría", "Traumatología", " ", " ", " " }));

        nombreprofesional.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombreprofesionalKeyReleased(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        volver.setFont(new java.awt.Font("Calibri Light", 1, 17)); // NOI18N
        volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/atras_opt.png"))); // NOI18N
        volver.setText("Volver");
        volver.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel5)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(especialidadprofesional, 0, 220, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 130, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(0, 0, Short.MAX_VALUE))
                            .add(layout.createSequentialGroup()
                                .add(jLabel1)
                                .add(18, 18, 18)
                                .add(nombreprofesional))))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(52, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(añonacimiento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(25, 25, 25)
                                .add(mesnacimiento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(dianacimiento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(8, 8, 8))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, guardar))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 10, Short.MAX_VALUE)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 10, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(eliminar)
                            .add(eliminarregistro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 246, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(volver))
                        .add(23, 23, 23))
                    .add(layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jRadioEliminar)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(24, 24, 24)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel1)
                                    .add(nombreprofesional, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(jRadioEliminar))
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                .add(19, 19, 19)
                                .add(jLabel3)
                                .add(9, 9, 9)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(mesnacimiento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(dianacimiento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(añonacimiento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(18, 18, 18)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel5)
                                    .add(especialidadprofesional, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(18, 18, 18)
                                .add(guardar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 59, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                .add(18, 18, 18)
                                .add(eliminarregistro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(30, 30, 30)
                                .add(eliminar)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 8, Short.MAX_VALUE)
                        .add(volver))
                    .add(layout.createSequentialGroup()
                        .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 247, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dianacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dianacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dianacimientoActionPerformed
  
    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        // TODO add your handling code here:
        
        VentanaPrincipal ventanaprincipal=new VentanaPrincipal();
        ventanaprincipal.setVisible(true);
        //VentanaTabla ventanatabla=new VentanaTabla();
        controladorPersona controladorpersona=new controladorPersona(ventanaprincipal);
        controladorDiurna controladordiurna=new controladorDiurna(ventanaprincipal);
        controladorConfiguracion controladorconfiguracion=new controladorConfiguracion(ventanaprincipal);
        controladorVespertina controladorvespertina=new controladorVespertina(ventanaprincipal);
        this.dispose();
    }//GEN-LAST:event_volverActionPerformed

    
       
    private void nombreprofesionalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreprofesionalKeyReleased
      
        String str = nombreprofesional.getText();
        char[] fuente = str.toCharArray();
        char[] resultado = new char[fuente.length];
        char[] arrayCaracteres={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z',' ',+ 
                +'A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z','`','é','í','ó','ú'};
        int j=0;
        boolean error=false;
        for(int i=0; i<fuente.length;i++){
            for(int k=0;k<55;k++){
            if(fuente[i]==arrayCaracteres[k]){
                resultado[j++] = fuente[i];  
            }
            else{
        error=true;
        }
        }
          if(error){
        nombreprofesional.setText("");
        nombreprofesional.setText(new String(resultado,0,j));
        }
        } 
    
    }//GEN-LAST:event_nombreprofesionalKeyReleased

    private void mesnacimientoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mesnacimientoItemStateChanged
        // TODO add your handling code here:
       // dianacimiento.repaint();
        //dianacimiento.getActionListeners();
        //dianacimiento.removeAll();
        //controladorAjustesIngreso contingreso=new controladorAjustesIngreso(this);
        dianacimiento.removeAllItems();
        for(int i=1;i<29;i++){
            String numCadena= String.valueOf(i);
        dianacimiento.addItem(numCadena);
        }
       // dianacimiento.getComponents();
    }//GEN-LAST:event_mesnacimientoItemStateChanged

    private void añonacimientoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_añonacimientoItemStateChanged
        // TODO add your handling code here:
        dianacimiento.disable();
    }//GEN-LAST:event_añonacimientoItemStateChanged

    /**
     * @param args the command line arguments
     */
    
     public Image getIconImage() {
    Image retValue = Toolkit.getDefaultToolkit().
    getImage(ClassLoader.getSystemResource("vista/graficoazul.png"));
    
    return retValue;
    }
     
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
            java.util.logging.Logger.getLogger(VentanaConfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaConfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaConfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaConfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaConfiguracion().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox añonacimiento;
    public javax.swing.JComboBox dianacimiento;
    public javax.swing.JButton eliminar;
    public javax.swing.JComboBox eliminarregistro;
    public javax.swing.JComboBox especialidadprofesional;
    public javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JRadioButton jRadioEliminar;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JComboBox mesnacimiento;
    public javax.swing.JTextField nombreprofesional;
    public javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
