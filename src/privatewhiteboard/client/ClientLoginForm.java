/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privatewhiteboard.client;

import java.net.MalformedURLException;
import java.rmi.AccessException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import privatewhiteboard.client.controllers.ClientController;
import privatewhiteboard.client.mockobjects.MockChatBoard;
import privatewhiteboard.shared.controllers.IClientController;
import privatewhiteboard.shared.interfaces.IChatBoard;
import privatewhiteboard.shared.remotes.IRemoteClient;
import privatewhiteboard.shared.remotes.IRemoteServer;
import privatewhiteboard.shared.remotes.RemoteClient;

/**
 *
 * @author Otamegane
 */
public class ClientLoginForm extends javax.swing.JFrame
{
    static IRemoteClient _remoteClient=null;
    /**
     * Creates new form ClientLoginForm
     */
    public ClientLoginForm()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtServerIP = new javax.swing.JTextField();
        txtServerPort = new javax.swing.JTextField();
        txtServerName = new javax.swing.JTextField();
        txtServerPassword = new javax.swing.JTextField();
        txtNickName = new javax.swing.JTextField();
        btnConnect = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Private Whiteboard Client");

        jLabel1.setText("Server IP address:");

        jLabel2.setText("Server port:");

        jLabel3.setText("Server name:");

        jLabel4.setText("Server password:");

        jLabel5.setText("Your nickname:");

        txtServerPort.setText("1999");

        txtServerName.setText("PrivateWhiteboardServer");

        btnConnect.setText("Connect");
        btnConnect.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnConnectActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtServerPort)
                            .addComponent(txtServerName)
                            .addComponent(txtServerPassword)
                            .addComponent(txtNickName)
                            .addComponent(txtServerIP)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtServerIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtServerPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtServerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtServerPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNickName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConnect)
                    .addComponent(btnExit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnExitActionPerformed
    {//GEN-HEADEREND:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnConnectActionPerformed
    {//GEN-HEADEREND:event_btnConnectActionPerformed
        if(!ValidFields())
            return;
        String exMsg="";
        try
        {
            IRemoteServer remoteServer=(IRemoteServer)Naming.lookup("rmi://"+txtServerIP.getText()+":"+txtServerPort.getText()+"/"+txtServerName.getText());
            MockChatBoard chatBoard=new MockChatBoard();
            ClientController clientController=new ClientController();
            clientController.Initialize(chatBoard, null, remoteServer);
            chatBoard.Initialize(clientController, this);
            IRemoteClient remoteClient=new RemoteClient(clientController);
            if(clientController.Connect(remoteClient, txtNickName.getText(), txtServerPassword.getText()))
            {
                _remoteClient=remoteClient;
                this.setVisible(false);
                chatBoard.Run();
            }
        }
        catch (AccessException ex)
        {
            exMsg=ex.getMessage();
            Logger.getLogger(ClientLoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (RemoteException ex)
        {
            exMsg=ex.getMessage();
            Logger.getLogger(ClientLoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (NotBoundException ex)
        {
            exMsg=ex.getMessage();
            Logger.getLogger(ClientLoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (MalformedURLException ex)
        {
            Logger.getLogger(ClientLoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(exMsg!=null)
            JOptionPane.showMessageDialog(this, exMsg);
    }//GEN-LAST:event_btnConnectActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void _main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(ClientLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ClientLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ClientLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ClientLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ClientLoginForm().setVisible(true);
            }
        });
    }
    
    private boolean ValidFields()
    {
        try
        {
            Integer.parseInt(txtServerPort.getText());
        }
        catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(this, "Port must be type of integer");
            return false;
        }
        
        for(int i=0;i<txtServerName.getText().length();i++)
        {
            if(!Character.isAlphabetic(txtServerName.getText().charAt(i)) && Character.isDigit(txtServerName.getText().charAt(i)))
            {
                JOptionPane.showMessageDialog(this, "Server name can only contain alphablet and digit!");
                return false;
            }
        }
        
        if(txtServerPassword.getText().length()<4)
        {
            JOptionPane.showMessageDialog(this, "Password field must have at least 4 character!");
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtNickName;
    private javax.swing.JTextField txtServerIP;
    private javax.swing.JTextField txtServerName;
    private javax.swing.JTextField txtServerPassword;
    private javax.swing.JTextField txtServerPort;
    // End of variables declaration//GEN-END:variables
}
