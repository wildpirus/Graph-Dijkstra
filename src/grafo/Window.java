/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vmmendoza
 */
public class Window extends javax.swing.JFrame {

    /**
     * Creates new form Window
     */
    GrafoG grafo;
    String a[]= {"-","1"};
    
    //temp
    Vertice p1,p2;
    
    //switches
    int op;
    
    public Window() {
        initComponents();
        op=-1;
        grafo = new GrafoG(jPanel2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        dibujarButton = new javax.swing.JButton();
        dirigidoButton = new javax.swing.JButton();
        eulerButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1),  new Integer(0)}
            },
            new String [] {
                "-", "1"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
        );

        dibujarButton.setText("Dibujar");
        dibujarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dibujarButtonActionPerformed(evt);
            }
        });

        dirigidoButton.setText("Es Dirigido?");
        dirigidoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dirigidoButtonActionPerformed(evt);
            }
        });

        eulerButton.setText("Es euleriano?");
        eulerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eulerButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Camino mínimo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jScrollPane2.setViewportView(jLabel2);

        jLabel1.setText("numero de vertices: ");

        jLabel3.setText("Matriz Adyacencia (distancias generadas con Random)");

        jButton2.setText("Recorrido");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dibujarButton))
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dirigidoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(3, 3, 3)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eulerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(dirigidoButton)
                                .addComponent(dibujarButton)
                                .addComponent(eulerButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addComponent(jLabel3)
                            .addComponent(jButton2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        // TODO add your handling code here:
        int n = Integer.parseInt(jSpinner1.getValue().toString());
        String a[]= new String[n+1];
        a[0]="-";
        for (int i = 1; i < a.length; i++) {
            a[i]= Integer.toString(i);
        }
        Object [][] b = new Object[n][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n+1; j++) {
                try{
                    b[i][j]=jTable1.getValueAt(i, j);
                }catch (Exception e){
                    b[i][j]=0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            b[i][0]=i+1;
        }
        jTable1.setModel(new javax.swing.table.DefaultTableModel(b,a));
    }//GEN-LAST:event_jSpinner1StateChanged

    private void dibujarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dibujarButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model =  (DefaultTableModel) jTable1.getModel();
        int nV = jTable1.getRowCount();
        int mat[][] = new int[nV][nV];
        for (int i = 0; i < nV; i++) {
            for (int j = 1; j < nV+1; j++) {
                mat[i][j-1]=Integer.parseInt(model.getValueAt(i, j).toString());
            }
        }
        grafo.generarGrafo(nV,mat);
        dibujar();
        op=-1;
        mensaje("");
    }//GEN-LAST:event_dibujarButtonActionPerformed

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if ((c!='0' || c>'1')) evt.consume(); 
    }//GEN-LAST:event_jTable1KeyTyped

    private void dirigidoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dirigidoButtonActionPerformed
        // TODO add your handling code here:
        dibujar();
        if(!grafo.hasVertices()){
            mensaje("no hay vertices");
        }else {
            mensaje("Seleccione vertice para encontrar grado");
            op=0;
        }
        
    }//GEN-LAST:event_dirigidoButtonActionPerformed

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
        if(op==0){ //Dirigido y grado
            Vertice vertice = grafo.getVertice(evt.getPoint());
            if(vertice!=null){
                p1=vertice;
                p1.setColor(Color.RED);
                dibujar();
                if(!grafo.esDirigido()){
                    mensaje("El grafo no es dirigido. Grado del vertice "+p1.getNombre()+": "+p1.gradoVertice());
                }else {
                    mensaje("El grafo es dirigido. Grado de entrada del vertice "+p1.getNombre()+": "+p1.gradoEntrada()+", grado de salida: "+p1.gradoSalida());
                }
                grafo.setVerticesBlack();
                p1=null;
                op=-1;
            }    
        }
        if(op==1){  //dijkstra
            if(p1 == null){
                p1 = grafo.getVertice(evt.getPoint());
                p1.setColor(Color.RED);
                dibujar();
            }else {
                Vertice vertice = grafo.getVertice(evt.getPoint());
                if (vertice.getColor() != Color.RED){
                    p2 = vertice;
                    Graphics g = jPanel2.getGraphics();
                    ArrayList<Arista> camino = grafo.Dijkstra(p1, p2);
                    if(camino.isEmpty()){
                        mensaje("No se puede llegar hasta el vertice indicado o el grafo no es conexo");
                    }else {
                        String info = "Dijkstra--> ";
                        int suma =0;
                        for (Arista arista : camino) {
                            info += "Arista: ("+arista.getInicio().getNombre()+","+arista.getFin().getNombre()+") costo: ";
                            suma += arista.getDistancia();
                            arista.pintar(g, Color.RED, true);
                        }
                        info += "Distancia mínima total: "+suma+" mts";
                        mensaje(info);
                    }
                    grafo.setVerticesBlack();
                }
            }
        }
    }//GEN-LAST:event_jPanel2MouseClicked

    private void eulerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eulerButtonActionPerformed
        // TODO add your handling code here:
        op=-1;
        dibujar();
        mensaje(grafo.Eulers());
    }//GEN-LAST:event_eulerButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        op=1;
        dibujar();
        mensaje("seleccione vertices");
        p1=null;
        p2= null;        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(grafo.hasEdges()){
            mensaje(grafo.dfs());
        }else {
            mensaje("no hay aristas");
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
    
    public void mensaje(String a){
        jLabel2.setText(a);    
    }
    
    public void dibujar(){
        Graphics g = jPanel2.getGraphics();
        g.clearRect(0,0,jPanel2.getWidth(),jPanel2.getHeight());
        grafo.dibujarGrafo(g, Color.BLACK, true);
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Window().setVisible(true);
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dibujarButton;
    private javax.swing.JButton dirigidoButton;
    private javax.swing.JButton eulerButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
