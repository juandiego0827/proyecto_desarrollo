/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.desarrollo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class RegistroUsuario extends javax.swing.JFrame {

    ConexionBD enlace = new ConexionBD();
    Connection conect = enlace.conectar();
    ArrayList<Integer> listaSedes = new ArrayList<>();
    
    /**
     * Creates new form registroUsuario
     */
    public RegistroUsuario() {
        initComponents();
        obtenerSedes();
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    
    //Se obitnenen los datos de la BD y estan contenidos en un arreglo
    private void obtenerSedes() { 
        try {
            Statement leer = conect.createStatement();
            ResultSet resultado = leer.executeQuery("SELECT id_sede FROM sede");
            while(resultado.next()){
                listaSedes.add(resultado.getInt(1));
            }
            for(int i=0;i<listaSedes.size();i++){
                comboboxSede.addItem(Integer.toString(listaSedes.get(i)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    
    private void registroUsuario(){
        if(fieldUser.getText().length()!=0
                && fieldPass.getText().length()!=0
                && fieldNombre.getText().length()!=0
                && fieldCedula.getText().length()!=0
                && fieldTelefono.getText().length()!=0
                && fieldDireccion.getText().length()!=0
                && fieldCiudad.getText().length()!=0){
            if(fieldPass.getText().equals(fieldPass2.getText())){
                try{
                    PreparedStatement guardar = conect.prepareStatement("INSERT INTO empleado(usuario_emp, contrasenia_emp, nombre_emp, cedula_emp, telefono_emp, direccion_emp, ciudad_emp, cargo_emp, id_sede) VALUES(?,?,?,?,?,?,?,?,?)");
                    guardar.setString(1, fieldUser.getText());
                    guardar.setString(2, fieldPass.getText());
                    guardar.setString(3, fieldNombre.getText());
                    guardar.setString(4, fieldCedula.getText());
                    guardar.setString(5, fieldTelefono.getText());
                    guardar.setString(6, fieldDireccion.getText());
                    guardar.setString(7, fieldCiudad.getText());
                    guardar.setString(8, (String) comboboxCargo.getSelectedItem());
                    guardar.setInt(9, (int) Integer.parseInt((String)comboboxSede.getSelectedItem()));
                    guardar.executeUpdate();
                    enlace.cerrar();
                    JOptionPane.showMessageDialog(null, "Los datos se guardaron correctamente");
                    regresarMenu();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "No se completo el registro "+ e);
                }
            }else {
                JOptionPane.showMessageDialog(null, "Las contraseñas no concuerdan");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No pueden haber elementos vacios");
        }
    }
    
    private void regresarMenu(){
        MenuUsuario regresar=new MenuUsuario();
        regresar.setVisible(true);
        this.setVisible(false);
        try {
            enlace.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Se agregan los valores de la BD de sede dentro del Item
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        labelUser = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelCargo = new javax.swing.JLabel();
        labelDireccion = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        labelPass = new javax.swing.JLabel();
        labelPass2 = new javax.swing.JLabel();
        fieldUser = new javax.swing.JTextField();
        fieldTelefono = new javax.swing.JTextField();
        fieldDireccion = new javax.swing.JTextField();
        comboboxCargo = new javax.swing.JComboBox<>();
        botonRegistrar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        fieldCiudad = new javax.swing.JTextField();
        labelCiudad = new javax.swing.JLabel();
        labelSede = new javax.swing.JLabel();
        comboboxSede = new javax.swing.JComboBox<>();
        fieldPass = new javax.swing.JPasswordField();
        fieldPass2 = new javax.swing.JPasswordField();
        labelCedula = new javax.swing.JLabel();
        fieldCedula = new javax.swing.JTextField();
        fieldNombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        titulo.setText("CREAR USUARIO");

        labelUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelUser.setText("Usuario");

        labelNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNombre.setText("Nombre");

        labelCargo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCargo.setText("Cargo");

        labelDireccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDireccion.setText("Dirección");

        labelTelefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTelefono.setText("Telefono");

        labelPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPass.setText("Contraseña");

        labelPass2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPass2.setText("Repetir Contraseña");

        fieldUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldUserActionPerformed(evt);
            }
        });

        fieldTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTelefonoActionPerformed(evt);
            }
        });

        fieldDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldDireccionActionPerformed(evt);
            }
        });

        comboboxCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Operador", "Contador", "Auxiliar de Operación" }));
        comboboxCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxCargoActionPerformed(evt);
            }
        });

        botonRegistrar.setText("Registrar");
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });

        botonRegresar.setText("Regresar");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        fieldCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCiudadActionPerformed(evt);
            }
        });

        labelCiudad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCiudad.setText("Ciudad");

        labelSede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelSede.setText("Sede");

        comboboxSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxSedeActionPerformed(evt);
            }
        });

        fieldPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPassActionPerformed(evt);
            }
        });

        labelCedula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCedula.setText("Cédula");

        fieldCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCedulaActionPerformed(evt);
            }
        });

        fieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNombreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(botonRegresar)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonRegistrar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(titulo))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelUser)
                                    .addComponent(labelPass)
                                    .addComponent(labelPass2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelCedula)
                                        .addComponent(labelNombre))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(labelDireccion)
                                            .addComponent(labelTelefono)
                                            .addComponent(labelCiudad)
                                            .addComponent(labelCargo)
                                            .addComponent(labelSede))
                                        .addGap(8, 8, 8)))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fieldPass2)
                                    .addComponent(fieldPass)
                                    .addComponent(fieldUser)
                                    .addComponent(fieldNombre)
                                    .addComponent(fieldCedula)
                                    .addComponent(fieldTelefono)
                                    .addComponent(fieldDireccion)
                                    .addComponent(fieldCiudad)
                                    .addComponent(comboboxCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboboxSede, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(10, 10, 10)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldPass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPass2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCedula)
                    .addComponent(fieldCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTelefono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDireccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCiudad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboboxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCargo))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboboxSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSede))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRegistrar)
                    .addComponent(botonRegresar))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldUserActionPerformed

    private void fieldTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldTelefonoActionPerformed

    private void fieldDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldDireccionActionPerformed

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed
        // TODO add your handling code here:
        registroUsuario();
    }//GEN-LAST:event_botonRegistrarActionPerformed

    private void comboboxCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxCargoActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        // TODO add your handling code here:
        regresarMenu();
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void fieldCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCiudadActionPerformed

    private void comboboxSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxSedeActionPerformed

    }//GEN-LAST:event_comboboxSedeActionPerformed

    private void fieldPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPassActionPerformed

    private void fieldCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCedulaActionPerformed

    private void fieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNombreActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistroUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JComboBox<String> comboboxCargo;
    private javax.swing.JComboBox<String> comboboxSede;
    private javax.swing.JTextField fieldCedula;
    private javax.swing.JTextField fieldCiudad;
    private javax.swing.JTextField fieldDireccion;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JPasswordField fieldPass;
    private javax.swing.JPasswordField fieldPass2;
    private javax.swing.JTextField fieldTelefono;
    private javax.swing.JTextField fieldUser;
    private javax.swing.JLabel labelCargo;
    private javax.swing.JLabel labelCedula;
    private javax.swing.JLabel labelCiudad;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPass;
    private javax.swing.JLabel labelPass2;
    private javax.swing.JLabel labelSede;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel labelUser;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
