package com.escalones.control12.vistas;

import com.escalones.control12.impresion.TicketPrinter;
import com.escalones.control12.modelos.Alumno;
import com.escalones.control12.modelos.PagoSimple;
import java.awt.Insets;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author xarxa
 */
public class PrevisualizacionTicketFrame extends javax.swing.JFrame {
    private Alumno alumno;
    private ArrayList<PagoSimple> lineasDetalle;
    private double total;
    private double entregado;
    private double cambio;
    private String observaciones;
    private String fecha;
    private String hora;
    private String formaPago;

    /**
     * Creates new form PrevisualizacionTicketFrame
     */
    public PrevisualizacionTicketFrame() {
        initComponents();
        // Configurar la fuente monoespaciada
        jTextAreaTicket.setFont(new java.awt.Font("Monospaced", 0, 12));
        jTextAreaTicket.setMargin(new Insets(10, 10, 10, 10));
        // Inicialmente no visible
        setVisible(false);
    }
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
        actualizarTextArea();
    }
    public String getTicketContent() {
        return jTextAreaTicket.getText();
    }
    public void setLineasDetalle(ArrayList<PagoSimple> lineasDetalle) {
        this.lineasDetalle = lineasDetalle;
        actualizarTextArea();
    }

    public void setTotal(double total) {
        this.total = total;
        actualizarTextArea();
    }

    public void setEntregado(double entregado) {
        this.entregado = entregado;
        actualizarTextArea();
    }

    public void setCambio(double cambio) {
        this.cambio = cambio;
        actualizarTextArea();
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
        actualizarTextArea();
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
        actualizarTextArea();
    }

    public void setHora(String hora) {
        this.hora = hora;
        actualizarTextArea();
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
        actualizarTextArea();
    }

    private void actualizarTextArea() {
    if (alumno != null && lineasDetalle != null) {
        StringBuilder sb = new StringBuilder();
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
        currencyFormat.setMaximumFractionDigits(2);

        // Cabecera del establecimiento
        sb.append("# 12escalones\n");
        sb.append("c/Andorra nº5-6\n");
        sb.append("Jerez de la Frontera\n");
        sb.append("CIF:31716473-W\n");
        sb.append("956396269-618232440\n");
        sb.append("12escalones.com\n");
        sb.append("info@12escalones.com\n\n");

        // Información de la factura
        sb.append(String.format("Fac.Simpli:%-8s %s %s\n", 
                              "10210", fecha, hora));
        sb.append(String.format("Empleado: %s\n", "Java Feña Iglesias")); // Puedes reemplazar con el nombre real
        sb.append(String.format("Cliente: %s %s\n", 
                              alumno.getNombre(), alumno.getApellidos()));
        //sb.append(String.format("Tel: %s\n", alumno.getTelefono() != null ? alumno.getTelefono() : ""));
        //sb.append(String.format("Direccion: %s\n\n", alumno.getDireccion() != null ? alumno.getDireccion() : ""));

        // Encabezado de productos
        sb.append("Uds Descripcion          P.U.    Total\n");
        sb.append("---------------------------------------\n");

        // Líneas de productos
        for (PagoSimple linea : lineasDetalle) {
            String nombre = linea.getNombre() != null ? linea.getNombre() : "";
            Integer unidades = linea.getUnidades() != null ? linea.getUnidades() : 0;
            Double precioUnitario = linea.getPrecioUnitario() != null ? linea.getPrecioUnitario() : 0.0;
            Double subtotal = linea.getSubtotal();

            sb.append(String.format("%-3d %-20s %6s %8s\n", 
                                  unidades, 
                                  nombre.length() > 20 ? nombre.substring(0, 17) + "..." : nombre,
                                  currencyFormat.format(precioUnitario).replace("€", "").trim(),
                                  currencyFormat.format(subtotal).replace("€", "").trim()));
        }

        // Totales
        sb.append("---------------------------------------\n");
        sb.append(String.format("%-25s %8s\n", "Subtotal:", currencyFormat.format(total).replace("€", "").trim()));
        
        // Si hay descuento (puedes añadir esta lógica si aplica)
        // sb.append(String.format("%-25s %8s\n", "Descuento:", "-4,00"));
        
        sb.append(String.format("%-25s %8s\n", "TOTAL:", currencyFormat.format(total).replace("€", "").trim()));
        sb.append(String.format("%-25s %8s\n", "Entrega:", currencyFormat.format(entregado).replace("€", "").trim()));
        sb.append("\n");

        // Forma de pago y mensaje final
        sb.append(String.format("Forma de Pago: %s\n", formaPago));
        sb.append("Impuestos Incluidos\n");
        sb.append("Gracias por su visita\n");

        jTextAreaTicket.setText(sb.toString());
    }
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
        jTextAreaTicket = new javax.swing.JTextArea();
        jButtonImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextAreaTicket.setColumns(20);
        jTextAreaTicket.setRows(5);
        jScrollPane1.setViewportView(jTextAreaTicket);

        jButtonImprimir.setText("IMPRIMIR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(jButtonImprimir)
                .addContainerGap(176, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonImprimir))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Cambiar "JPOS_PRINTER_NAME" por el nombre real de tu impresora POS
            TicketPrinter printer = new TicketPrinter("JPOS_PRINTER_NAME");
            printer.printTicket(this);
            printer.closePrinter();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Error al imprimir: " + e.getMessage(),
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setContenidoTicket(String contenido) {
        jTextAreaTicket.setText(contenido);
    }
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
            java.util.logging.Logger.getLogger(PrevisualizacionTicketFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrevisualizacionTicketFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrevisualizacionTicketFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrevisualizacionTicketFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrevisualizacionTicketFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaTicket;
    // End of variables declaration//GEN-END:variables
}