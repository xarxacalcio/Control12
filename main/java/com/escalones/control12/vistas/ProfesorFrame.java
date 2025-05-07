package com.escalones.control12.vistas;

import com.escalones.control12.modelos.Profesor;
import com.escalones.control12.servicios.alumnos.AlumnoValidador;
import com.escalones.control12.servicios.alumnos.AlumnosAccesoApi;
import com.escalones.control12.servicios.profesores.ProfesorAccesoApi;
import com.escalones.control12.servicios.profesores.ProfesorAccionesFrame;
import com.escalones.control12.servicios.profesores.ProfesorValidador;
import static com.escalones.control12.vistas.AlumnoFrame.ACCIONALTA;
import static com.escalones.control12.vistas.AlumnoFrame.ACCIONMODIFICAR;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author xarxa
 */
public class ProfesorFrame extends javax.swing.JFrame {

    public static final int ACCIONALTA = 0;
    public static final int ACCIONMODIFICAR = 1;
    public static final int NINGUNPROFESORACTIVADO = -1;
    public int accionAltaModificar;
    public int idProfesorActual;

    public ArrayList<Profesor> profesores = new ArrayList();

    /**
     * Creates new form InicioFrame
     */
    public ProfesorFrame() {
        initComponents();
        idProfesorActual = NINGUNPROFESORACTIVADO;
        accionAltaModificar = ACCIONALTA;
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelProfesores1 = new javax.swing.JPanel();
        jPanelBarraLateral1 = new javax.swing.JPanel();
        jPanelCabecera = new javax.swing.JPanel();
        jLabel12Escalones1 = new javax.swing.JLabel();
        jLabelAdministrador1 = new javax.swing.JLabel();
        jPanelZonaTabla1 = new javax.swing.JPanel();
        jPanelBusqueda1 = new javax.swing.JPanel();
        jButtonBuscarProfesor = new javax.swing.JButton();
        jTextFieldBuscarProfesor = new javax.swing.JTextField();
        jPanelTabla1 = new javax.swing.JPanel();
        jPanelTablaBotonera1 = new javax.swing.JPanel();
        jButtonEditar1 = new javax.swing.JButton();
        jButtonBorrar1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProfesores = new javax.swing.JTable();
        jPanelFormulario1 = new javax.swing.JPanel();
        jPanelBotonera1 = new javax.swing.JPanel();
        jButtonAnadirProfesor = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonInicio1 = new javax.swing.JButton();
        jLabelNombre1 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabelApellidos1 = new javax.swing.JLabel();
        jTextFieldApellidos = new javax.swing.JTextField();
        jLabelTelefono1 = new javax.swing.JLabel();
        jLabelEmail1 = new javax.swing.JLabel();
        jTextFieldTelefono1 = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelUsuario1 = new javax.swing.JLabel();
        jLabelContrasena = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jTextFieldContrasena = new javax.swing.JTextField();
        jLabelTelefono2 = new javax.swing.JLabel();
        jTextFieldTelefono2 = new javax.swing.JTextField();
        jLabelAnadirProfesor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelBarraLateral1.setBackground(new java.awt.Color(255, 153, 0));
        jPanelBarraLateral1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelBarraLateral1Layout = new javax.swing.GroupLayout(jPanelBarraLateral1);
        jPanelBarraLateral1.setLayout(jPanelBarraLateral1Layout);
        jPanelBarraLateral1Layout.setHorizontalGroup(
            jPanelBarraLateral1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanelBarraLateral1Layout.setVerticalGroup(
            jPanelBarraLateral1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelCabecera.setBackground(new java.awt.Color(255, 153, 0));
        jPanelCabecera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12Escalones1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12Escalones1.setText("CONTROL12 - PROFESORES");

        jLabelAdministrador1.setText("Administrador");

        javax.swing.GroupLayout jPanelCabeceraLayout = new javax.swing.GroupLayout(jPanelCabecera);
        jPanelCabecera.setLayout(jPanelCabeceraLayout);
        jPanelCabeceraLayout.setHorizontalGroup(
            jPanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12Escalones1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelAdministrador1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelCabeceraLayout.setVerticalGroup(
            jPanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12Escalones1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanelCabeceraLayout.createSequentialGroup()
                .addComponent(jLabelAdministrador1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButtonBuscarProfesor.setBackground(new java.awt.Color(242, 183, 1));
        jButtonBuscarProfesor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonBuscarProfesor.setText("Buscar Profesor");
        jButtonBuscarProfesor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButtonBuscarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarProfesorActionPerformed(evt);
            }
        });

        jTextFieldBuscarProfesor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldBuscarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBuscarProfesorActionPerformed(evt);
            }
        });
        jTextFieldBuscarProfesor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarProfesorKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanelBusqueda1Layout = new javax.swing.GroupLayout(jPanelBusqueda1);
        jPanelBusqueda1.setLayout(jPanelBusqueda1Layout);
        jPanelBusqueda1Layout.setHorizontalGroup(
            jPanelBusqueda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBusqueda1Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(jTextFieldBuscarProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBuscarProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelBusqueda1Layout.setVerticalGroup(
            jPanelBusqueda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBusqueda1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBusqueda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBuscarProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBuscarProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTablaBotonera1.setBackground(new java.awt.Color(204, 204, 204));

        jButtonEditar1.setBackground(new java.awt.Color(255, 204, 153));
        jButtonEditar1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonEditar1.setText("EDITAR");
        jButtonEditar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButtonEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditar1ActionPerformed(evt);
            }
        });

        jButtonBorrar1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonBorrar1.setText("BORRAR");
        jButtonBorrar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButtonBorrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTablaBotonera1Layout = new javax.swing.GroupLayout(jPanelTablaBotonera1);
        jPanelTablaBotonera1.setLayout(jPanelTablaBotonera1Layout);
        jPanelTablaBotonera1Layout.setHorizontalGroup(
            jPanelTablaBotonera1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablaBotonera1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTablaBotonera1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEditar1, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(jButtonBorrar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelTablaBotonera1Layout.setVerticalGroup(
            jPanelTablaBotonera1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablaBotonera1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jButtonEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBorrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableProfesores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Apellidos", "Telefono", "Telefono2", "e-mail", "Fecha Nacimiento", "Usuario", "Contraseña"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableProfesores);

        javax.swing.GroupLayout jPanelTabla1Layout = new javax.swing.GroupLayout(jPanelTabla1);
        jPanelTabla1.setLayout(jPanelTabla1Layout);
        jPanelTabla1Layout.setHorizontalGroup(
            jPanelTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTabla1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelTablaBotonera1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelTabla1Layout.setVerticalGroup(
            jPanelTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTabla1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addComponent(jPanelTablaBotonera1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jButtonAnadirProfesor.setBackground(new java.awt.Color(242, 183, 1));
        jButtonAnadirProfesor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonAnadirProfesor.setText("AÑADIR PROFESOR");
        jButtonAnadirProfesor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButtonAnadirProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnadirProfesorActionPerformed(evt);
            }
        });

        jButtonLimpiar.setBackground(new java.awt.Color(255, 204, 153));
        jButtonLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonLimpiar.setText("LIMPIAR FORMULARIO");
        jButtonLimpiar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jButtonInicio1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonInicio1.setText("INICIO");
        jButtonInicio1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout jPanelBotonera1Layout = new javax.swing.GroupLayout(jPanelBotonera1);
        jPanelBotonera1.setLayout(jPanelBotonera1Layout);
        jPanelBotonera1Layout.setHorizontalGroup(
            jPanelBotonera1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonera1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanelBotonera1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonInicio1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAnadirProfesor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelBotonera1Layout.setVerticalGroup(
            jPanelBotonera1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonera1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAnadirProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonInicio1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelNombre1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNombre1.setText("NOMBRE");

        jTextFieldNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });

        jLabelApellidos1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelApellidos1.setText("APELLIDOS");

        jTextFieldApellidos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelTelefono1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelTelefono1.setText("TELÉFONO");

        jLabelEmail1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelEmail1.setText("E-MAIL");

        jTextFieldTelefono1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextFieldEmail.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelUsuario1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelUsuario1.setText("USUARIO");

        jLabelContrasena.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelContrasena.setText("CONTRASEÑA");

        jTextFieldUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextFieldContrasena.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelTelefono2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelTelefono2.setText("TELÉFONO 2");

        jTextFieldTelefono2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelFormulario1Layout = new javax.swing.GroupLayout(jPanelFormulario1);
        jPanelFormulario1.setLayout(jPanelFormulario1Layout);
        jPanelFormulario1Layout.setHorizontalGroup(
            jPanelFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormulario1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                        .addComponent(jTextFieldTelefono1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                        .addComponent(jLabelNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldNombre)
                        .addComponent(jLabelTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldUsuario)
                        .addComponent(jLabelUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                    .addComponent(jTextFieldContrasena)
                    .addComponent(jLabelContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelApellidos1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTelefono2)
                    .addComponent(jLabelTelefono2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jPanelBotonera1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelFormulario1Layout.setVerticalGroup(
            jPanelFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormulario1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFormulario1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanelFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNombre1)
                            .addComponent(jLabelApellidos1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTelefono1)
                            .addComponent(jLabelTelefono2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFormulario1Layout.createSequentialGroup()
                                .addComponent(jTextFieldTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelEmail1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldTelefono2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(jPanelFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelUsuario1)
                            .addComponent(jLabelContrasena))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE))
                    .addComponent(jPanelBotonera1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabelAnadirProfesor.setBackground(new java.awt.Color(255, 204, 51));
        jLabelAnadirProfesor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelAnadirProfesor.setText("NUEVO PROFESOR");
        jLabelAnadirProfesor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 204, 51), null, null));

        javax.swing.GroupLayout jPanelZonaTabla1Layout = new javax.swing.GroupLayout(jPanelZonaTabla1);
        jPanelZonaTabla1.setLayout(jPanelZonaTabla1Layout);
        jPanelZonaTabla1Layout.setHorizontalGroup(
            jPanelZonaTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelZonaTabla1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelZonaTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelZonaTabla1Layout.createSequentialGroup()
                        .addComponent(jLabelAnadirProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanelTabla1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelZonaTabla1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanelBusqueda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanelZonaTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelZonaTabla1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelFormulario1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelZonaTabla1Layout.setVerticalGroup(
            jPanelZonaTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelZonaTabla1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelBusqueda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTabla1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabelAnadirProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(275, Short.MAX_VALUE))
            .addGroup(jPanelZonaTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelZonaTabla1Layout.createSequentialGroup()
                    .addContainerGap(437, Short.MAX_VALUE)
                    .addComponent(jPanelFormulario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jPanelProfesores1Layout = new javax.swing.GroupLayout(jPanelProfesores1);
        jPanelProfesores1.setLayout(jPanelProfesores1Layout);
        jPanelProfesores1Layout.setHorizontalGroup(
            jPanelProfesores1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProfesores1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelBarraLateral1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelProfesores1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelZonaTabla1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanelProfesores1Layout.setVerticalGroup(
            jPanelProfesores1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBarraLateral1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelProfesores1Layout.createSequentialGroup()
                .addComponent(jPanelCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelZonaTabla1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1076, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanelProfesores1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 803, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelProfesores1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarProfesorActionPerformed
        // TODO add your handling code here:
        ProfesorAccionesFrame.filtrarTablaProfesores(this);
    }//GEN-LAST:event_jButtonBuscarProfesorActionPerformed

    private void jTextFieldBuscarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscarProfesorActionPerformed
        // TODO add your handling code here:
        ProfesorAccionesFrame.filtrarTablaProfesores(this);
    }//GEN-LAST:event_jTextFieldBuscarProfesorActionPerformed

    private void jTextFieldBuscarProfesorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarProfesorKeyReleased
        // TODO add your handling code here:
        ProfesorAccionesFrame.filtrarTablaProfesores(this);
    }//GEN-LAST:event_jTextFieldBuscarProfesorKeyReleased

    private void jButtonEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditar1ActionPerformed
        // TODO add your handling code here:
         if (jTableProfesores.getSelectedRow() != -1) {
            idProfesorActual = (int) jTableProfesores.getValueAt(jTableProfesores.getSelectedRow(), 0);
            accionAltaModificar = ACCIONMODIFICAR;
            ProfesorAccionesFrame.modificarBotonesAltaModificar(this);
            ProfesorAccionesFrame.rellenarFormulario(this);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el profesor a editar");
        }
    }//GEN-LAST:event_jButtonEditar1ActionPerformed

    private void jButtonBorrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrar1ActionPerformed

if (jTableProfesores.getSelectedRow() != -1) {
            idProfesorActual = (int) jTableProfesores.getValueAt(jTableProfesores.getSelectedRow(), 0);
            int respuesta = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de que desea eliminar este profesor?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);
            
            if (respuesta == JOptionPane.YES_OPTION) {
                ProfesorAccesoApi.eliminarProfesor(this);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el profesor a eliminar");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBorrar1ActionPerformed

    private void jButtonAnadirProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnadirProfesorActionPerformed
 ProfesorValidador profesorValidador = new ProfesorValidador(this);
        if (!profesorValidador.validarFormularioProfesor()) {
            JOptionPane.showMessageDialog(null, profesorValidador.getErrores());
        } else {
            if (accionAltaModificar == ACCIONALTA) {

                ProfesorAccesoApi.nuevoProfesor(this);
                JOptionPane.showMessageDialog(this, "Nuevo profesor creado con éxito.");//1

            } else if (accionAltaModificar == ACCIONMODIFICAR) {
                ProfesorAccesoApi.modificarProfesor(this);
                JOptionPane.showMessageDialog(this, "Profesor modificado con éxito.");//1
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAnadirProfesorActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed

ProfesorAccionesFrame.borrarFormulario(this);
        if (accionAltaModificar == ACCIONMODIFICAR) {
            ProfesorAccionesFrame.reiniciarAccionAlta(this);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfesorFrame().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonAnadirProfesor;
    private javax.swing.JButton jButtonBorrar1;
    public javax.swing.JButton jButtonBuscarProfesor;
    private javax.swing.JButton jButtonEditar1;
    private javax.swing.JButton jButtonInicio1;
    public javax.swing.JButton jButtonLimpiar;
    private javax.swing.JLabel jLabel12Escalones1;
    private javax.swing.JLabel jLabelAdministrador1;
    private javax.swing.JLabel jLabelAnadirProfesor;
    private javax.swing.JLabel jLabelApellidos1;
    private javax.swing.JLabel jLabelContrasena;
    private javax.swing.JLabel jLabelEmail1;
    private javax.swing.JLabel jLabelNombre1;
    private javax.swing.JLabel jLabelTelefono1;
    private javax.swing.JLabel jLabelTelefono2;
    private javax.swing.JLabel jLabelUsuario1;
    private javax.swing.JPanel jPanelBarraLateral1;
    private javax.swing.JPanel jPanelBotonera1;
    private javax.swing.JPanel jPanelBusqueda1;
    private javax.swing.JPanel jPanelCabecera;
    public javax.swing.JPanel jPanelFormulario1;
    private javax.swing.JPanel jPanelProfesores1;
    private javax.swing.JPanel jPanelTabla1;
    private javax.swing.JPanel jPanelTablaBotonera1;
    private javax.swing.JPanel jPanelZonaTabla1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTableProfesores;
    public javax.swing.JTextField jTextFieldApellidos;
    public javax.swing.JTextField jTextFieldBuscarProfesor;
    public javax.swing.JTextField jTextFieldContrasena;
    public javax.swing.JTextField jTextFieldEmail;
    public javax.swing.JTextField jTextFieldNombre;
    public javax.swing.JTextField jTextFieldTelefono1;
    public javax.swing.JTextField jTextFieldTelefono2;
    public javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables

    
}
