/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.salle.custommoodle.view;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.salle.custommoodle.model.Materia;
import edu.salle.custommoodle.model.Student;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Red
 */
public class TopicWindow extends javax.swing.JFrame {
 private static List<Materia> studentList= new ArrayList<>();
    /**
     * Creates new form TopicWindow
     */
    public TopicWindow() {
        
        initComponents();
        this.setTitle("Materias");
        load();
        refreshTable(studentList);
         setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tTopics = new javax.swing.JTable();
        tfNombre = new javax.swing.JTextField();
        tfDocente = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tTopics.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Docente"
            }
        ));
        jScrollPane1.setViewportView(tTopics);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 320, 100));

        tfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreActionPerformed(evt);
            }
        });
        getContentPane().add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, -1));

        tfDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDocenteActionPerformed(evt);
            }
        });
        getContentPane().add(tfDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 110, -1));

        jButton1.setText("Asignar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, -1));

        jLabel1.setText("Nombre materia:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        jLabel2.setText("Docente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, -1));

        bExit.setBackground(java.awt.SystemColor.window);
        bExit.setForeground(new java.awt.Color(0, 0, 0));
        bExit.setText("Exit");
        bExit.setBorder(null);
        bExit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExitActionPerformed(evt);
            }
        });
        getContentPane().add(bExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 50, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void commitChanges(List<Materia>studentList) {
         try{
        Gson gson = new Gson();
        FileWriter writer= new FileWriter("topics.json");
        writer.write(gson.toJson(studentList));
        writer.close();
    }
         catch(Exception ex)
        {
            ex.printStackTrace();
        }
    
}
public void load() {
        try{
        Gson gson = new Gson();
        BufferedReader br= new BufferedReader(new FileReader("topics.json"));
        studentList= gson.fromJson(br, new TypeToken<List<Materia>>(){}.getType());
        br.close();
            if (studentList==null) {
                studentList= new ArrayList<>();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    private void tfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreActionPerformed

    private void tfDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDocenteActionPerformed
public void update(Materia student) {
        int pos=4;
        if (student.getNombre().toLowerCase().equals("matematicas")) {
        pos=0;
    }
        else{ if(student.getNombre().toLowerCase().equals("computacion")){
            pos=1;
        }
        else{
            if(student.getNombre().toLowerCase().equals("ingles"))
            {
                pos=2;
            }
        }
        }
        studentList.set(pos,student);
    }
private void refreshTable(List<Materia> studentList)
{
    clearTable();
    
    DefaultTableModel dtm= (DefaultTableModel)tTopics.getModel();
    Object[] emptyRow={""};
    for (int i = 0; i < studentList.size();i++) {
        dtm.addRow(emptyRow);
        dtm.setValueAt(studentList.get(i).getNombre(),i,0);
        dtm.setValueAt(studentList.get(i).geDocente(),i,1);
    }
}
private void clearTable(){
    DefaultTableModel dtm= (DefaultTableModel)tTopics.getModel();
    while(dtm.getRowCount()>0)
    {
        dtm.removeRow(0);
    }
}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Materia mat= new Materia();
        mat.setNombre(tfNombre.getText());
        mat.setDocente(tfDocente.getText());
        update(mat);
        JOptionPane.showMessageDialog(null,"Cambio de docente exitoso");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExitActionPerformed
        // TODO add your handling code here:
        commitChanges(studentList);
        MainWindow main = new MainWindow();
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bExitActionPerformed

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
            java.util.logging.Logger.getLogger(TopicWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TopicWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TopicWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TopicWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TopicWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bExit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tTopics;
    private javax.swing.JTextField tfDocente;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}
