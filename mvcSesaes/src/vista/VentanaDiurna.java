/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.controladorConfiguracion;
import controlador.controladorDiurna;
import controlador.controladorPersona;
import controlador.controladorVespertina;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Milii2
 */
public class VentanaDiurna extends javax.swing.JFrame {
   
    /**
     * Creates new form VentanaDiurna
     */
   
    public VentanaDiurna() {
        initComponents();
      setLocationRelativeTo(null);
      setDefaultCloseOperation(0);
      gruporadio.add(jRadioProfesional);
      gruporadio.add(jRadioCarrera);
      gruporadio.add(jRadioFacultad);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gruporadio = new javax.swing.ButtonGroup();
        jRadioProfesional = new javax.swing.JRadioButton();
        jRadioCarrera = new javax.swing.JRadioButton();
        jRadioFacultad = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        listaespecialidad = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        listacarrera = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        listafacultad = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        listaperiodo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        listames = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        listasemestre = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        listaaño = new javax.swing.JComboBox();
        jSeparator3 = new javax.swing.JSeparator();
        botonmostrar = new javax.swing.JButton();
        volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());

        jRadioProfesional.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        jRadioProfesional.setText("Especialidad");
        jRadioProfesional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioProfesionalActionPerformed(evt);
            }
        });

        jRadioCarrera.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        jRadioCarrera.setText("Carrera");
        jRadioCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioCarreraActionPerformed(evt);
            }
        });

        jRadioFacultad.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        jRadioFacultad.setText("Facultad");
        jRadioFacultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioFacultadActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel1.setText("Seleccionar Especialidad:");

        listaespecialidad.setEnabled(false);
        listaespecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaespecialidadActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel2.setText("Seleccionar Carrera:");

        listacarrera.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel3.setText("Seleccionar Facultad:");

        listafacultad.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        jLabel4.setText("Seleccione Periodo:");

        listaperiodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione>", "Mensual", "Semestral", "Anual" }));
        listaperiodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaperiodoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri Light", 0, 15)); // NOI18N
        jLabel5.setText("Mes:");

        listames.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        listames.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Calibri Light", 0, 15)); // NOI18N
        jLabel6.setText("Semestre:");

        listasemestre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2" }));
        listasemestre.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Calibri Light", 0, 15)); // NOI18N
        jLabel7.setText("Año:");

        listaaño.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2012", "2013" }));
        listaaño.setEnabled(false);

        botonmostrar.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        botonmostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/lupa-psd-468x468.png"))); // NOI18N
        botonmostrar.setText("Mostrar");

        volver.setFont(new java.awt.Font("Calibri Light", 1, 15)); // NOI18N
        volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/atras_opt.png"))); // NOI18N
        volver.setText("Volver");
        volver.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jRadioProfesional)
                .addGap(63, 63, 63)
                .addComponent(jRadioCarrera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioFacultad)
                .addGap(63, 63, 63))
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(listames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listaperiodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listasemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listaaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel3))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(listaespecialidad, 0, 234, Short.MAX_VALUE)
                            .addComponent(listacarrera, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(listafacultad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(volver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonmostrar)
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioProfesional)
                    .addComponent(jRadioCarrera)
                    .addComponent(jRadioFacultad))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(listaespecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(listacarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(listafacultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(listaperiodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(listames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(listasemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(listaaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonmostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(volver, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaespecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaespecialidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listaespecialidadActionPerformed

    private void jRadioProfesionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioProfesionalActionPerformed
        // TODO add your handling code here:
        if(jRadioProfesional.isSelected()==true){
            listaespecialidad.enable();
            listacarrera.disable();
            listafacultad.disable();
        }
    }//GEN-LAST:event_jRadioProfesionalActionPerformed

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

    private void jRadioCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioCarreraActionPerformed
        if(jRadioCarrera.isSelected()==true){
            listacarrera.enable();
            listaespecialidad.disable();
            listafacultad.disable();
        }
    }//GEN-LAST:event_jRadioCarreraActionPerformed

    private void jRadioFacultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioFacultadActionPerformed
        if(jRadioFacultad.isSelected()==true){
            listafacultad.enable();
            listacarrera.disable();
            listaespecialidad.disable();
        }
    }//GEN-LAST:event_jRadioFacultadActionPerformed

    private void listaperiodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaperiodoActionPerformed
        if(listaperiodo.getSelectedIndex()==0){
            listames.setEnabled(false);
            listasemestre.setEnabled(false);
            listaaño.setEnabled(false);
        }
        else if(listaperiodo.getSelectedIndex()==1){
            listames.setEnabled(true);
            listasemestre.setEnabled(false);
            listaaño.setEnabled(true);
            
        }
        else if(listaperiodo.getSelectedIndex()==2){
            listasemestre.setEnabled(true);
            listames.setEnabled(false);
            listaaño.setEnabled(true);
        }
        else if(listaperiodo.getSelectedIndex()==3){
            listaaño.setEnabled(true);
            listasemestre.setEnabled(false);
            listames.setEnabled(false);
        }
        
            
    }//GEN-LAST:event_listaperiodoActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaDiurna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaDiurna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaDiurna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaDiurna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaDiurna().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton botonmostrar;
    public javax.swing.ButtonGroup gruporadio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JRadioButton jRadioCarrera;
    public javax.swing.JRadioButton jRadioFacultad;
    public javax.swing.JRadioButton jRadioProfesional;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public javax.swing.JComboBox listaaño;
    public javax.swing.JComboBox listacarrera;
    public javax.swing.JComboBox listaespecialidad;
    public javax.swing.JComboBox listafacultad;
    public javax.swing.JComboBox listames;
    public javax.swing.JComboBox listaperiodo;
    public javax.swing.JComboBox listasemestre;
    public javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
