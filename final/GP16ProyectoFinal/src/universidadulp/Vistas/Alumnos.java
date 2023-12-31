package universidadulp.Vistas;

//imports de paquetes y clases necesarios
import java.awt.Color;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.*;
import universidadulp.AccesoADatos.*;
import universidadulp.Entidades.Alumno;

public class Alumnos extends javax.swing.JPanel {

    //modelo para tabla alumno usada en el metodo mostrar tabla
    String[] col = {"ID", "Dni", "Alumno"};
    DefaultTableModel modeloAlumno = new DefaultTableModel(null, col) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    //atributos necesarios para los metodos utilizados
    AlumnoData alumnoDB = new AlumnoData();
    private Connection con;

    //constructor vacio
    public Alumnos() {
        initComponents();
        con = Conexion.getConnection();
        mostrarTabla();

        //array con cada boton para que tengan un hover
        JButton btns[] = {jbNuevoAlumno, jbEliminarAlumno, jgModificarAlumno, jbBotonActualizar};

        //loop for para recorrer el array y que realice los cambios a cada boton
        for (JButton btn : btns) {
            //seteo del color default
            btn.setBackground(new Color(60, 63, 65));

            //seteo del look and feel basico de los botones
            btn.setUI(new BasicButtonUI());

            //mouse listener para que detecte al apretar cada boton
            btn.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                //override al evento mouseEntered para que cuando pase el mouse por arriba cambie al color elegido
                @Override
                public void mouseEntered(MouseEvent e) {
                    btn.setBackground(new Color(80, 41, 179));
                }

                //override al evento mouseExited para que cuando pase el mouse por arriba cambie al color elegido
                @Override
                public void mouseExited(MouseEvent e) {
                    btn.setBackground(new Color(60, 63, 65));
                }
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelTop = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelMid = new javax.swing.JPanel();
        panelHalfLeft = new javax.swing.JPanel();
        panelLeft = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panelRight = new javax.swing.JPanel();
        jtID = new javax.swing.JTextField();
        jtDniAlumno = new javax.swing.JTextField();
        jtNombreAlumno = new javax.swing.JTextField();
        jtApellidoAlumno = new javax.swing.JTextField();
        jcbEstadoAlumno = new javax.swing.JCheckBox();
        jdFechaNacAlumno = new com.toedter.calendar.JDateChooser();
        panelHalfRight = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTablaAlumno = new javax.swing.JTable();
        jbBotonActualizar = new javax.swing.JButton();
        panelBot = new javax.swing.JPanel();
        jbNuevoAlumno = new javax.swing.JButton();
        jbEliminarAlumno = new javax.swing.JButton();
        jgModificarAlumno = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        panelTop.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(21, 39, 43)));
        panelTop.setPreferredSize(new java.awt.Dimension(0, 60));
        panelTop.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Alumnos");
        jLabel1.setMinimumSize(new java.awt.Dimension(90, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 0, 17, 660);
        panelTop.add(jLabel1, gridBagConstraints);

        add(panelTop, java.awt.BorderLayout.NORTH);

        panelMid.setLayout(new java.awt.BorderLayout());

        panelHalfLeft.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(21, 39, 43)));
        panelHalfLeft.setPreferredSize(new java.awt.Dimension(640, 0));
        panelHalfLeft.setLayout(new java.awt.BorderLayout());

        panelLeft.setPreferredSize(new java.awt.Dimension(320, 0));
        panelLeft.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Documento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(40, 0, 36, 0);
        panelLeft.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(40, 0, 36, 0);
        panelLeft.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("Apellido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(40, 0, 36, 0);
        panelLeft.add(jLabel4, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("Estado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(40, 0, 36, 0);
        panelLeft.add(jLabel6, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setText("Fecha de nacimiento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(40, 0, 36, 0);
        panelLeft.add(jLabel5, gridBagConstraints);

        panelHalfLeft.add(panelLeft, java.awt.BorderLayout.WEST);

        panelRight.setPreferredSize(new java.awt.Dimension(320, 0));
        panelRight.setLayout(new java.awt.GridBagLayout());

        jtID.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtID.setForeground(java.awt.Color.white);
        jtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtID.setPreferredSize(new java.awt.Dimension(50, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 30, 0);
        panelRight.add(jtID, gridBagConstraints);

        jtDniAlumno.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtDniAlumno.setForeground(java.awt.Color.white);
        jtDniAlumno.setPreferredSize(new java.awt.Dimension(190, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 30, 0);
        panelRight.add(jtDniAlumno, gridBagConstraints);

        jtNombreAlumno.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtNombreAlumno.setForeground(java.awt.Color.white);
        jtNombreAlumno.setMinimumSize(new java.awt.Dimension(250, 40));
        jtNombreAlumno.setPreferredSize(new java.awt.Dimension(14, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(33, 0, 33, 0);
        panelRight.add(jtNombreAlumno, gridBagConstraints);

        jtApellidoAlumno.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtApellidoAlumno.setForeground(java.awt.Color.white);
        jtApellidoAlumno.setPreferredSize(new java.awt.Dimension(250, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(33, 0, 33, 0);
        panelRight.add(jtApellidoAlumno, gridBagConstraints);

        jcbEstadoAlumno.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jcbEstadoAlumno.setForeground(java.awt.Color.white);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(33, 0, 33, 0);
        panelRight.add(jcbEstadoAlumno, gridBagConstraints);

        jdFechaNacAlumno.setForeground(java.awt.Color.white);
        jdFechaNacAlumno.setDateFormatString("yyyy-MM-dd");
        jdFechaNacAlumno.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jdFechaNacAlumno.setPreferredSize(new java.awt.Dimension(250, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(33, 0, 33, 0);
        panelRight.add(jdFechaNacAlumno, gridBagConstraints);

        panelHalfLeft.add(panelRight, java.awt.BorderLayout.EAST);

        panelMid.add(panelHalfLeft, java.awt.BorderLayout.WEST);

        panelHalfRight.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(21, 39, 43)));
        panelHalfRight.setPreferredSize(new java.awt.Dimension(640, 0));
        panelHalfRight.setLayout(new java.awt.BorderLayout());

        jtTablaAlumno.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtTablaAlumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtTablaAlumno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtTablaAlumno.setRowHeight(32);
        jtTablaAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTablaAlumnoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtTablaAlumno);

        panelHalfRight.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jbBotonActualizar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbBotonActualizar.setForeground(java.awt.Color.white);
        jbBotonActualizar.setText("Actualizar");
        jbBotonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBotonActualizarActionPerformed(evt);
            }
        });
        panelHalfRight.add(jbBotonActualizar, java.awt.BorderLayout.PAGE_END);

        panelMid.add(panelHalfRight, java.awt.BorderLayout.EAST);

        add(panelMid, java.awt.BorderLayout.CENTER);

        panelBot.setPreferredSize(new java.awt.Dimension(0, 80));
        panelBot.setLayout(new java.awt.GridLayout(1, 0));

        jbNuevoAlumno.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbNuevoAlumno.setForeground(java.awt.Color.white);
        jbNuevoAlumno.setText("Nuevo");
        jbNuevoAlumno.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(21, 39, 43)));
        jbNuevoAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoAlumnoActionPerformed(evt);
            }
        });
        panelBot.add(jbNuevoAlumno);

        jbEliminarAlumno.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbEliminarAlumno.setForeground(java.awt.Color.white);
        jbEliminarAlumno.setText("Eliminar");
        jbEliminarAlumno.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(21, 39, 43)));
        jbEliminarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarAlumnoActionPerformed(evt);
            }
        });
        panelBot.add(jbEliminarAlumno);

        jgModificarAlumno.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jgModificarAlumno.setForeground(java.awt.Color.white);
        jgModificarAlumno.setText("Modificar");
        jgModificarAlumno.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(21, 39, 43)));
        jgModificarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jgModificarAlumnoActionPerformed(evt);
            }
        });
        panelBot.add(jgModificarAlumno);

        add(panelBot, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    //action boton nuevo alumno
    private void jbNuevoAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoAlumnoActionPerformed
        // TODO add your handling code here:
        //if para comprobar que ningun campo este vacio
        if (jtApellidoAlumno.getText() == null || jtNombreAlumno.getText() == null || jdFechaNacAlumno.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Primero debe realizar una busqueda.");
        } else {

            //seteo variable para enviar a la base de datos
            int dniDB = Integer.parseInt(jtDniAlumno.getText());

            //query para obtener todos los datos dentro de la tabla alumno
            String sql = "select * from alumno where dni = ?";
            try {

                //envio de query a base de datos
                PreparedStatement ps = con.prepareStatement(sql);

                //seteo de valores de query sacados del parametro
                ps.setInt(1, dniDB);
                ResultSet rs = ps.executeQuery();

                //if para comprobar si ya hay un alumno con el dni dado
                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(null, "Ya hay un alumno registrado con ese DNI.");
                } else {

                    //if para que ningun campo este vacio
                    if (jtDniAlumno.getText() == null || jtApellidoAlumno.getText() == null || jtNombreAlumno.getText() == null || jdFechaNacAlumno.getDate() == null) {
                        JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos.");
                    } else {

                        //declaracion de variables que seran enviadas al constructor de alumno
                        int dni = Integer.parseInt(jtDniAlumno.getText());
                        String apellido = jtApellidoAlumno.getText();
                        String nombre = jtNombreAlumno.getText();
                        String fechaNac = ((JTextField) jdFechaNacAlumno.getDateEditor().getUiComponent()).getText();
                        boolean estado = jcbEstadoAlumno.isEnabled();
                        Alumno alu = new Alumno(dni, apellido, nombre, LocalDate.parse(fechaNac), estado);

                        //invocacion de metodo nuevo alumno
                        alumnoDB.nuevoAlumno(alu);

                        //metodo para actualizar tabla
                        actualizarTabla();
                        //limpiar los campos una vez impactado en la DB
                        jtDniAlumno.setText("");
                        jtApellidoAlumno.setText("");
                        jtNombreAlumno.setText("");
                        jdFechaNacAlumno.setDate(null);
                    }
                }
                ps.close();
                rs.close();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "No puede haber campos vacios.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error nuevo.");
            }
        }
    }//GEN-LAST:event_jbNuevoAlumnoActionPerformed

    //action boton eliminar alumno
    private void jbEliminarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarAlumnoActionPerformed
        // TODO add your handling code here:

        //if para comprobar que ningun campo este vacio
        if (jtApellidoAlumno.getText() == null || jtNombreAlumno.getText() == null || jdFechaNacAlumno.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Primero debe realizar una busqueda.");
        } else {
            try {

                //seteo variable para enviar a la base de datos
                int dni = Integer.parseInt(jtDniAlumno.getText());

                //query para obtener idAlumno
                String sql = "select idAlumno from alumno where dni = ?";

                //envio de query a base de datos
                PreparedStatement ps = con.prepareStatement(sql);

                //seteo de valores de query sacados del parametro
                ps.setInt(1, dni);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {

                    //declaracion de variable que sera enviada a metodo eliminar alumno
                    int id = rs.getInt("idAlumno");

                    //invocacion de metodo eliminar alumno
                    alumnoDB.eliminarAlumno(id);

                    //metodo para actualizar tabla
                    actualizarTabla();
                }
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos.");
            }
        }
    }//GEN-LAST:event_jbEliminarAlumnoActionPerformed

    //action boton modificar alumno
    private void jgModificarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jgModificarAlumnoActionPerformed
        // TODO add your handling code here:

        //if para comprobar que ningun campo este vacio
        if (jtApellidoAlumno.getText() == null || jtNombreAlumno.getText() == null || jdFechaNacAlumno.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Primero debe realizar una busqueda.");
        } else {

            //declaracion de variables que seran enviadas al constructor de alumno
            int dni = Integer.parseInt(jtDniAlumno.getText());
            String apellido = jtApellidoAlumno.getText();
            String nombre = jtNombreAlumno.getText();
            String fechaNac = ((JTextField) jdFechaNacAlumno.getDateEditor().getUiComponent()).getText();
            boolean estado = jcbEstadoAlumno.isSelected();

            //query para obtener idAlumno
            String sql = "select idAlumno from alumno where dni = ?";
            try {

                //envio de query a la base de datos
                PreparedStatement ps = con.prepareStatement(sql);

                //seteo de valores de query sacados del parametro
                ps.setInt(1, dni);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {

                    //declaracion de variable que sera enviada a metodo modificar alumno
                    int id = rs.getInt("idAlumno");

                    //constructor alumno con los datos requeridos
                    Alumno alu = new Alumno(id, dni, apellido, nombre, LocalDate.parse(fechaNac), estado);

                    //invocacion de metodo modificar alumno
                    alumnoDB.modificarAlumno(alu);

                    //metodo para actualizar tabla
                    actualizarTabla();
                }
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "error");
            }
        }
    }//GEN-LAST:event_jgModificarAlumnoActionPerformed

    //action boton actualizar alumno
    private void jbBotonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBotonActualizarActionPerformed
        // TODO add your handling code here:
        //declaracion de nuevo modelo de tabla copiando el modelo actual de la tabla
        DefaultTableModel mod = (DefaultTableModel) jtTablaAlumno.getModel();

        //eliminacion de filas
        mod.setRowCount(0);

        //metodo para mostrar tabla
        mostrarTabla();
    }//GEN-LAST:event_jbBotonActualizarActionPerformed

    //action click en combobox tabla alumno
    private void jtTablaAlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTablaAlumnoMouseClicked
        // TODO add your handling code here:
        //seleccion de fila
        int i = jtTablaAlumno.getSelectedRow();

        //declaracion de variables que seran enviadas a cada textfield de la tabla alumno
        int id = Integer.parseInt(jtTablaAlumno.getModel().getValueAt(i, 0).toString());
        int dni = alumnoDB.buscarAlumno(id).getDni();
        String nombre = alumnoDB.buscarAlumno(id).getNombre();
        String apellido = alumnoDB.buscarAlumno(id).getApellido();
        Boolean estado = alumnoDB.buscarAlumno(id).isActivo();
        LocalDate nacimiento = alumnoDB.buscarAlumno(id).getFechaNac();

        //seteo de variables dentro de cada texfield con datos obtenidos
        jtID.setText(String.valueOf(id));
        jtDniAlumno.setText(String.valueOf(dni));
        jtNombreAlumno.setText(nombre);
        jtApellidoAlumno.setText(apellido);
        jcbEstadoAlumno.setSelected(estado);
        jdFechaNacAlumno.setDate(Date.valueOf(nacimiento));
    }//GEN-LAST:event_jtTablaAlumnoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBotonActualizar;
    private javax.swing.JButton jbEliminarAlumno;
    private javax.swing.JButton jbNuevoAlumno;
    private javax.swing.JCheckBox jcbEstadoAlumno;
    private com.toedter.calendar.JDateChooser jdFechaNacAlumno;
    private javax.swing.JButton jgModificarAlumno;
    private javax.swing.JTextField jtApellidoAlumno;
    private javax.swing.JTextField jtDniAlumno;
    private javax.swing.JTextField jtID;
    private javax.swing.JTextField jtNombreAlumno;
    private javax.swing.JTable jtTablaAlumno;
    private javax.swing.JPanel panelBot;
    private javax.swing.JPanel panelHalfLeft;
    private javax.swing.JPanel panelHalfRight;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelMid;
    private javax.swing.JPanel panelRight;
    private javax.swing.JPanel panelTop;
    // End of variables declaration//GEN-END:variables

    //metodo para mostrar tabla alumno
    public void mostrarTabla() {
        //seteo de modelo de la tabla
        jtTablaAlumno.setModel(modeloAlumno);

        //obtener modelo de columna para cambiar tamaño individualmente
        TableColumnModel columna = jtTablaAlumno.getColumnModel();
        columna.getColumn(0).setMaxWidth(45);
        columna.getColumn(1).setMaxWidth(110);
        columna.getColumn(2).setMaxWidth(590);

        //query para obtener idAlumno, dni, nombre, apellido
        String sql = "select idAlumno, dni, nombre, apellido from alumno where estado = 1 order by idAlumno ASC";
        try {

            //envio de query a la base de datos                                     
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                //declaracion de variables que seran mostradas en la tabla alumno
                String id = String.valueOf(rs.getInt("idAlumno"));
                String dni = String.valueOf(rs.getInt("dni"));
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String alumno = nombre + " " + apellido;
                String tbdata[] = {id, dni, alumno};
                modeloAlumno.addRow(tbdata);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error..");
        }
    }

    //metodo para actualizar la tabla alumno
    public void actualizarTabla() {
        //declaracion de nuevo modelo copiando el modelo actual de la tabla
        DefaultTableModel mod = (DefaultTableModel) jtTablaAlumno.getModel();

        //eliminacion de filas
        mod.setRowCount(0);

        //metodo para mostrar tabla alumnos
        mostrarTabla();
    }
}
