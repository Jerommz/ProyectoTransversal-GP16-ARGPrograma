
package universidadulp.Vistas;

import java.awt.Component;
import javax.swing.table.DefaultTableModel;
import universidadulp.AccesoADatos.MateriaData;

public class Interfaz extends javax.swing.JFrame {
    
    MateriaData mat=new MateriaData();
    DefaultTableModel modelo=new DefaultTableModel();

    public Interfaz() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mFormularioAlumno = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mFormularioMateria = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mManejoInscripciones = new javax.swing.JMenuItem();
        mManejoNotas = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mAlumnosMateria = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 697, Short.MAX_VALUE)
        );

        jMenu1.setText("Alumno");

        mFormularioAlumno.setText("Formulario de alumno");
        mFormularioAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mFormularioAlumnoActionPerformed(evt);
            }
        });
        jMenu1.add(mFormularioAlumno);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Materia");

        mFormularioMateria.setText("Formulario de materia");
        mFormularioMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mFormularioMateriaActionPerformed(evt);
            }
        });
        jMenu2.add(mFormularioMateria);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Administracion");

        mManejoInscripciones.setText("Manejo de inscripciones");
        mManejoInscripciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mManejoInscripcionesActionPerformed(evt);
            }
        });
        jMenu3.add(mManejoInscripciones);

        mManejoNotas.setText("Manipulacion de notas");
        mManejoNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mManejoNotasActionPerformed(evt);
            }
        });
        jMenu3.add(mManejoNotas);

        jMenuItem1.setText("Administracion de alumnos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Consultas");

        mAlumnosMateria.setText("Alumnos por materia");
        mAlumnosMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mAlumnosMateriaActionPerformed(evt);
            }
        });
        jMenu4.add(mAlumnosMateria);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Salir");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        setSize(new java.awt.Dimension(1296, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mFormularioAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mFormularioAlumnoActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        Alumnos ga=new Alumnos();
        frameCentrado(ga);
        escritorio.moveToFront(ga);
    }//GEN-LAST:event_mFormularioAlumnoActionPerformed

    private void mFormularioMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mFormularioMateriaActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        Materias gm=new Materias();
        frameCentrado(gm);
        escritorio.moveToFront(gm);
    }//GEN-LAST:event_mFormularioMateriaActionPerformed

    private void mManejoInscripcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mManejoInscripcionesActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        Inscripciones gi=new Inscripciones();
        frameCentrado(gi);
        escritorio.moveToFront(gi);
    }//GEN-LAST:event_mManejoInscripcionesActionPerformed

    private void mManejoNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mManejoNotasActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        Notas gn=new Notas();
        frameCentrado(gn);
        escritorio.moveToFront(gn);
    }//GEN-LAST:event_mManejoNotasActionPerformed

    private void mAlumnosMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAlumnosMateriaActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        AlumnosPorMateria gam=new AlumnosPorMateria();
        frameCentrado(gam);
        escritorio.moveToFront(gam);
    }//GEN-LAST:event_mAlumnosMateriaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem mAlumnosMateria;
    private javax.swing.JMenuItem mFormularioAlumno;
    private javax.swing.JMenuItem mFormularioMateria;
    private javax.swing.JMenuItem mManejoInscripciones;
    private javax.swing.JMenuItem mManejoNotas;
    // End of variables declaration//GEN-END:variables

    public void frameCentrado(Component frameCentrado){
        escritorio.add(frameCentrado);
        frameCentrado.setLocation((escritorio.getWidth()-frameCentrado.getWidth())/2, (escritorio.getHeight()-frameCentrado.getHeight())/2);
        frameCentrado.setVisible(true);
    }
    
}
