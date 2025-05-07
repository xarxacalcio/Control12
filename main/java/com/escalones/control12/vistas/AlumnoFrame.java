package com.escalones.control12.vistas;

import com.escalones.control12.modelos.Alumno;
import com.escalones.control12.servicios.alumnos.AlumnoAccionesFrame;
import com.escalones.control12.servicios.alumnos.AlumnoValidador;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import com.escalones.control12.servicios.alumnos.AlumnosAccesoApi;


/**
 *
 * @author xarxa
 */
public class AlumnoFrame extends javax.swing.JFrame {

    public static final int ACCIONALTA = 0;
    public static final int ACCIONMODIFICAR = 1;
    public static final int NINGUNALUMNOACTIVADO = -1;
    public int accionAltaModificar;
    public int idAlumnoActual;
    private PantallaInicio pantallaInicio;

    public ArrayList<Alumno> alumnos = new ArrayList<>();

    public AlumnoFrame() {
        initComponents();

    }

    public AlumnoFrame(PantallaInicio pantallaInicio) {
        initComponents();
        this.pantallaInicio = pantallaInicio;
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        jPanelBarraLateral = new javax.swing.JPanel();
        jPanelCabecera = new javax.swing.JPanel();
        jLabel12Escalones1 = new javax.swing.JLabel();
        jLabelAdministrador1 = new javax.swing.JLabel();
        jPanelZonaTabla = new javax.swing.JPanel();
        jPanelBusqueda = new javax.swing.JPanel();
        jTextFieldBuscarAlumno = new javax.swing.JTextField();
        jButtonBuscarAlumno = new javax.swing.JButton();
        jPanelTabla = new javax.swing.JPanel();
        jPanelBotoneraTabla = new javax.swing.JPanel();
        jButtonEditar = new javax.swing.JButton();
        jButtonBorrar = new javax.swing.JButton();
        jButtonHistorial = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAlumnos = new javax.swing.JTable();
        jPanelFormulario = new javax.swing.JPanel();
        jLabelAnadirAlumno = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabelTelefono = new javax.swing.JLabel();
        jTextFieldTelefono = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelApellidos = new javax.swing.JLabel();
        jTextFieldApellidos = new javax.swing.JTextField();
        jLabelTelefono2 = new javax.swing.JLabel();
        jTextFieldTelefono2 = new javax.swing.JTextField();
        jLabelFechaNacimiento = new javax.swing.JLabel();
        jDateFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabelFechaInicio = new javax.swing.JLabel();
        jDateFechaInscripcion = new com.toedter.calendar.JDateChooser();
        jPanelBotones = new javax.swing.JPanel();
        jButtonAnadirAlumno = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonInicio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanelBarraLateral.setBackground(new java.awt.Color(255, 153, 51));
        jPanelBarraLateral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelBarraLateralLayout = new javax.swing.GroupLayout(jPanelBarraLateral);
        jPanelBarraLateral.setLayout(jPanelBarraLateralLayout);
        jPanelBarraLateralLayout.setHorizontalGroup(
            jPanelBarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanelBarraLateralLayout.setVerticalGroup(
            jPanelBarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelCabecera.setBackground(new java.awt.Color(255, 153, 51));
        jPanelCabecera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelCabecera.setPreferredSize(new java.awt.Dimension(400, 42));

        jLabel12Escalones1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12Escalones1.setText("CONTROL12 - ALUMNOS");

        jLabelAdministrador1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelAdministrador1.setText("Administrador");

        javax.swing.GroupLayout jPanelCabeceraLayout = new javax.swing.GroupLayout(jPanelCabecera);
        jPanelCabecera.setLayout(jPanelCabeceraLayout);
        jPanelCabeceraLayout.setHorizontalGroup(
            jPanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCabeceraLayout.createSequentialGroup()
                .addComponent(jLabel12Escalones1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelAdministrador1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelCabeceraLayout.setVerticalGroup(
            jPanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCabeceraLayout.createSequentialGroup()
                .addComponent(jLabelAdministrador1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel12Escalones1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelBusqueda.setBackground(new java.awt.Color(204, 204, 204));

        jTextFieldBuscarAlumno.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldBuscarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBuscarAlumnoActionPerformed(evt);
            }
        });
        jTextFieldBuscarAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarAlumnoKeyReleased(evt);
            }
        });

        jButtonBuscarAlumno.setBackground(new java.awt.Color(242, 183, 1));
        jButtonBuscarAlumno.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonBuscarAlumno.setText("Buscar Alumno");
        jButtonBuscarAlumno.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButtonBuscarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarAlumnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBusquedaLayout = new javax.swing.GroupLayout(jPanelBusqueda);
        jPanelBusqueda.setLayout(jPanelBusquedaLayout);
        jPanelBusquedaLayout.setHorizontalGroup(
            jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldBuscarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonBuscarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelBusquedaLayout.setVerticalGroup(
            jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBusquedaLayout.createSequentialGroup()
                .addGroup(jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBuscarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBuscarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanelBotoneraTabla.setBackground(new java.awt.Color(204, 204, 204));

        jButtonEditar.setBackground(new java.awt.Color(255, 204, 0));
        jButtonEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonEditar.setText("EDITAR");
        jButtonEditar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonBorrar.setBackground(new java.awt.Color(255, 204, 153));
        jButtonBorrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonBorrar.setText("BORRAR");
        jButtonBorrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });

        jButtonHistorial.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonHistorial.setText("HISTORIAL");
        jButtonHistorial.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout jPanelBotoneraTablaLayout = new javax.swing.GroupLayout(jPanelBotoneraTabla);
        jPanelBotoneraTabla.setLayout(jPanelBotoneraTablaLayout);
        jPanelBotoneraTablaLayout.setHorizontalGroup(
            jPanelBotoneraTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoneraTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBotoneraTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelBotoneraTablaLayout.setVerticalGroup(
            jPanelBotoneraTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoneraTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableAlumnos.setBackground(new java.awt.Color(242, 242, 242));
        jTableAlumnos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTableAlumnos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTableAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Nombre", "Apellidos", "Telefono", "Telefono 2", "e-mail", "Fecha Nacimiento", "Fecha Inscripción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableAlumnos);

        jLabelAnadirAlumno.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelAnadirAlumno.setText("NUEVO ALUMNO");

        jLabelNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNombre.setText("NOMBRE");

        jTextFieldNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelTelefono.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelTelefono.setText("TELÉFONO");

        jTextFieldTelefono.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelEmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelEmail.setText("E-MAIL");

        jTextFieldEmail.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelApellidos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelApellidos.setText("APELLIDOS");

        jTextFieldApellidos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelTelefono2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelTelefono2.setText("TELÉFONO 2");

        jLabelFechaNacimiento.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelFechaNacimiento.setText("FECHA DE NACIMIENTO");

        jLabelFechaInicio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelFechaInicio.setText("FECHA DE INSCRIPCIÓN");

        jButtonAnadirAlumno.setBackground(new java.awt.Color(242, 183, 1));
        jButtonAnadirAlumno.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonAnadirAlumno.setText("AÑADIR ALUMNO");
        jButtonAnadirAlumno.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButtonAnadirAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnadirAlumnoActionPerformed(evt);
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

        jButtonInicio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonInicio.setText("INICIO");
        jButtonInicio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButtonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotonesLayout = new javax.swing.GroupLayout(jPanelBotones);
        jPanelBotones.setLayout(jPanelBotonesLayout);
        jPanelBotonesLayout.setHorizontalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonLimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonInicio, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonAnadirAlumno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelBotonesLayout.setVerticalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAnadirAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonInicio)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelFormularioLayout = new javax.swing.GroupLayout(jPanelFormulario);
        jPanelFormulario.setLayout(jPanelFormularioLayout);
        jPanelFormularioLayout.setHorizontalGroup(
            jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormularioLayout.createSequentialGroup()
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addComponent(jTextFieldTelefono)
                    .addComponent(jTextFieldNombre)
                    .addComponent(jLabelAnadirAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addComponent(jTextFieldTelefono2)
                    .addComponent(jLabelTelefono2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFechaNacimiento)
                    .addComponent(jDateFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateFechaInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 72, Short.MAX_VALUE))
        );
        jPanelFormularioLayout.setVerticalGroup(
            jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelAnadirAlumno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelFormularioLayout.createSequentialGroup()
                        .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNombre)
                            .addComponent(jLabelApellidos)
                            .addComponent(jLabelFechaNacimiento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTelefono)
                            .addComponent(jLabelTelefono2)
                            .addComponent(jLabelFechaInicio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldTelefono2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jDateFechaInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabelAnadirAlumno.getAccessibleContext().setAccessibleName("AÑADIR PROFESOR");

        javax.swing.GroupLayout jPanelTablaLayout = new javax.swing.GroupLayout(jPanelTabla);
        jPanelTabla.setLayout(jPanelTablaLayout);
        jPanelTablaLayout.setHorizontalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTablaLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelBotoneraTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelTablaLayout.setVerticalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                    .addComponent(jPanelBotoneraTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jPanelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelZonaTablaLayout = new javax.swing.GroupLayout(jPanelZonaTabla);
        jPanelZonaTabla.setLayout(jPanelZonaTablaLayout);
        jPanelZonaTablaLayout.setHorizontalGroup(
            jPanelZonaTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelZonaTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelZonaTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelZonaTablaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelZonaTablaLayout.setVerticalGroup(
            jPanelZonaTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelZonaTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(jPanelBarraLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
                    .addComponent(jPanelZonaTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBarraLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(jPanelCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelZonaTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1078, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 749, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnadirAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnadirAlumnoActionPerformed

        AlumnoValidador alumnoValidador = new AlumnoValidador(this);
        if (!alumnoValidador.validarFormularioAlumno()) {
            JOptionPane.showMessageDialog(null, alumnoValidador.getErrores());
        } else {
            if (accionAltaModificar == ACCIONALTA) {

                AlumnosAccesoApi.nuevoAlumno(this);
                JOptionPane.showMessageDialog(this, "Nuevo alumno creado con éxito.");

            } else if (accionAltaModificar == ACCIONMODIFICAR) {
                AlumnosAccesoApi.modificarAlumno(this);
                JOptionPane.showMessageDialog(this, "Alumno modificado con éxito.");
            }
            pantallaInicio.actualizarElementos();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAnadirAlumnoActionPerformed

    private void jButtonBuscarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarAlumnoActionPerformed
        AlumnoAccionesFrame.filtrarTablaAlumnos(this);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBuscarAlumnoActionPerformed


    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        // TODO add your handling code here:
        if (jTableAlumnos.getSelectedRow() != -1) {
            idAlumnoActual = (int) jTableAlumnos.getValueAt(jTableAlumnos.getSelectedRow(), 0);
            accionAltaModificar = ACCIONMODIFICAR;
            AlumnoAccionesFrame.modificarBotonesAltaModificar(this);
            AlumnoAccionesFrame.rellenarFormulario(this);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el alumno a editar");
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed

        AlumnoAccionesFrame.borrarFormulario(this);
        if (accionAltaModificar == ACCIONMODIFICAR) {
            AlumnoAccionesFrame.reiniciarAccionAlta(this);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed
        
        if (jTableAlumnos.getSelectedRow() != -1) {
            idAlumnoActual = (int) jTableAlumnos.getValueAt(jTableAlumnos.getSelectedRow(), 0);
            int respuesta = JOptionPane.showConfirmDialog(this, 
                "¿Está seguro de que desea eliminar este alumno?", 
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);
            
            if (respuesta == JOptionPane.YES_OPTION) {
                
                if( AlumnosAccesoApi.existePagoAlumno(idAlumnoActual)){
                    JOptionPane.showMessageDialog(this, "El alumno seleccionado no se puede borrar. Tiene pagos asociados");
                }
               
                AlumnosAccesoApi.eliminarAlumno(this);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el alumno a eliminar");
        }        // TODO add your handling code here:
     
    }//GEN-LAST:event_jButtonBorrarActionPerformed

    private void jTextFieldBuscarAlumnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarAlumnoKeyReleased
        AlumnoAccionesFrame.filtrarTablaAlumnos(this);
// TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBuscarAlumnoKeyReleased

    private void jButtonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInicioActionPerformed
        // TODO add your handling code here:
        pantallaInicio.toFront();
    }//GEN-LAST:event_jButtonInicioActionPerformed

    private void jTextFieldBuscarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscarAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBuscarAlumnoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlumnoFrame().setVisible(true);
            }
        });
    }

    public JTable getTablaAlumnos() {

        return jTableAlumnos;

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonAnadirAlumno;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonBuscarAlumno;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonHistorial;
    private javax.swing.JButton jButtonInicio;
    public javax.swing.JButton jButtonLimpiar;
    public com.toedter.calendar.JDateChooser jDateFechaInscripcion;
    public com.toedter.calendar.JDateChooser jDateFechaNacimiento;
    private javax.swing.JLabel jLabel12Escalones1;
    private javax.swing.JLabel jLabelAdministrador1;
    private javax.swing.JLabel jLabelAnadirAlumno;
    private javax.swing.JLabel jLabelApellidos;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelFechaInicio;
    private javax.swing.JLabel jLabelFechaNacimiento;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelTelefono2;
    private javax.swing.JPanel jPanelBarraLateral;
    private javax.swing.JPanel jPanelBotoneraTabla;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelBusqueda;
    private javax.swing.JPanel jPanelCabecera;
    private javax.swing.JPanel jPanelFormulario;
    private javax.swing.JPanel jPanelTabla;
    private javax.swing.JPanel jPanelZonaTabla;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTableAlumnos;
    public javax.swing.JTextField jTextFieldApellidos;
    public javax.swing.JTextField jTextFieldBuscarAlumno;
    public javax.swing.JTextField jTextFieldEmail;
    public javax.swing.JTextField jTextFieldNombre;
    public javax.swing.JTextField jTextFieldTelefono;
    public javax.swing.JTextField jTextFieldTelefono2;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables

}
