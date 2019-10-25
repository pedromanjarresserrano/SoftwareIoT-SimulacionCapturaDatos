/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.sistemaiot.ui;

import com.udec.sistemaiot.App;
import com.udec.sistemaiot.dao.SensorRepository;
import com.udec.sistemaiot.domain.Sensor;
import com.udec.sistemaiot.services.RealtimeService;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author PDMS-LAPTOP
 */
public class MainFrame extends javax.swing.JFrame {

    private final SensorRepository sensorRepository;
    private final RealtimeService realtimeService;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        sensorRepository = App.Ctx.getBean(SensorRepository.class);
        realtimeService = App.Ctx.getBean(RealtimeService.class);
        initComponents();
        loadMenuSensores();
    }

    private void loadMenuSensores() {
        sensorRepository.findAll().forEach(sensor -> {
            final JMenuItem jMenuItem = new JMenuItem(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jtpVentanas.add(sensor.getNombre(),new SensorPanel(sensor, sensorRepository));
                }
            });
            jMenuItem.setText(sensor.getNombre());
            jmmSensores.add(jMenuItem);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        jtpVentanas = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmmSensores = new javax.swing.JMenu();
        jmiIniciar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Agregar Sensor");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jmmSensores.setText("Ver sensor");
        jMenu1.add(jmmSensores);

        jmiIniciar.setText("Iniciar registro");
        jmiIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiIniciarActionPerformed(evt);
            }
        });
        jMenu1.add(jmiIniciar);
        jMenu1.add(jSeparator1);

        jMenuItem2.setText("Salir");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpVentanas, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpVentanas, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        SensorForm sensorForm = new SensorForm(e -> {
            sensorRepository.save((Sensor) e);
            loadMenuSensores();
        });
        sensorForm.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        sensorForm.setVisible(true);

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jmiIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiIniciarActionPerformed
        realtimeService.init();
    }//GEN-LAST:event_jmiIniciarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem jmiIniciar;
    private javax.swing.JMenu jmmSensores;
    private javax.swing.JTabbedPane jtpVentanas;
    // End of variables declaration//GEN-END:variables

}
