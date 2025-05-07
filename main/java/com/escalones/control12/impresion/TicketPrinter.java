package com.escalones.control12.impresion;

import com.escalones.control12.vistas.PrevisualizacionTicketFrame;
import jpos.JposException;
import jpos.POSPrinter;
import jpos.POSPrinterConst;
import javax.swing.JOptionPane;

public class TicketPrinter {
    private POSPrinter printer;
    private String printerName;

    public TicketPrinter(String printerLogicalName) {
        this.printerName = printerLogicalName;
        printer = new POSPrinter();
        try {
            printer.open(printerName);
            printer.claim(1000);
            printer.setDeviceEnabled(true);
        } catch (JposException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al inicializar la impresora '" + printerName + "': " + e.getMessage(), 
                "Error de Impresión", 
                JOptionPane.ERROR_MESSAGE);
            printer = null;
        }
    }

    /**
     * Imprime el ticket usando el contenido ya generado en PrevisualizacionTicketFrame
     * @param previewFrame Frame que contiene el ticket ya formateado
     */
    public void printTicket(PrevisualizacionTicketFrame previewFrame) {
        if (printer == null) {
            JOptionPane.showMessageDialog(null, 
                "La impresora '" + printerName + "' no está inicializada.", 
                "Error de Impresión", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Obtener el contenido ya formateado del frame
            String ticketContent = previewFrame.getTicketContent();
            
            // Configurar la impresora
            printer.setRecLetterQuality(true); // Alta calidad
            printer.setMapMode(POSPrinterConst.PTR_MM_METRIC); // Modo métrico
            
            // Imprimir línea por línea con formato POS
            String[] lines = ticketContent.split("\n");
            for (String line : lines) {
                printer.printNormal(POSPrinterConst.PTR_S_RECEIPT, line + "\n");
            }
            
            // Añadir comandos POS específicos
            printer.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\n\n\n"); // Espacio final
            printer.cutPaper(90); // Cortar papel (90% de corte)
            
        } catch (JposException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al imprimir el ticket: " + e.getMessage(), 
                "Error de Impresión", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public void closePrinter() {
        if (printer != null) {
            try {
                printer.setDeviceEnabled(false);
                printer.release();
                printer.close();
            } catch (JposException e) {
                JOptionPane.showMessageDialog(null, 
                    "Error al cerrar la impresora '" + printerName + "': " + e.getMessage(), 
                    "Error de Impresión", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}