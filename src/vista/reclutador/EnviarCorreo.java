/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista.reclutador;

import controlador.ConsultaData;
import static controlador.ConsultaData.subirConsulta;
import java.io.File;
import java.time.LocalDate;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import modelo.Consulta;
import modelo.Reclutador;

/**
 *
 * @author Cosquin
 */
public class EnviarCorreo extends javax.swing.JInternalFrame {

    private static String emailFrom = "laspiurperezjuan@gmail.com";
    private static String passwordFrom = "jincxvjoadtnjhoc";
    private String emailTo;
    private String subject;
    private String content;

    private Properties mProperties = new Properties(); // De Java Util
    private Session mSession; // De una de las librerias importadas
    private MimeMessage mCorreo; //De una de las librerias importadas

    private File[] mArchivosAdjuntos;
    private String nombre_archivoAdjunto;

    private Reclutador reclutador;

    public EnviarCorreo() {
        initComponents();
    }

    public EnviarCorreo(Reclutador reclutador) {
        initComponents();
        this.reclutador = reclutador;
        nombre_archivoAdjunto = "";
        cargarMail(reclutador.getCorreo());
    }

    private void createEmail() {
        emailTo = input_enviarA.getText().trim();
        subject = input_asunto.getText().trim();
        content = input_mensaje.getText().trim();

        //Simple mail transfer protocol
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user", emailFrom);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");

        mSession = Session.getDefaultInstance(mProperties);

        try {
            MimeMultipart mElementosCorreo = new MimeMultipart();
            //Contenido del correo
            MimeBodyPart mContenido = new MimeBodyPart();
            mContenido.setContent(content, "text/html; charset=utf-8");
            mElementosCorreo.addBodyPart(mContenido);

            MimeBodyPart mAdjuntos = null;
            if (mArchivosAdjuntos != null) {
                for (int i = 0; i < mArchivosAdjuntos.length; i++) {
                    mAdjuntos = new MimeBodyPart();
                    mAdjuntos.setDataHandler(new DataHandler(new FileDataSource(mArchivosAdjuntos[i])));
                    mAdjuntos.setFileName(mArchivosAdjuntos[i].getName());
                    mElementosCorreo.addBodyPart(mAdjuntos);
                }
            }

            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(emailFrom));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            mCorreo.setSubject(subject);
            mCorreo.setContent(mElementosCorreo);
            // mCorreo.setText(content,"ISO-8859-1","html");
        } catch (AddressException ex) {
            Logger.getLogger(EnviarCorreo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EnviarCorreo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void sendEmail() {
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailFrom, passwordFrom);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();

            JOptionPane.showMessageDialog(null, "Correo enviado");

            if (this.reclutador != null) {
                LocalDate fechaLocal = LocalDate.now();
                refistrarConsulta(new Consulta(reclutador, java.sql.Date.valueOf(fechaLocal), input_mensaje.getText()));
            }

            input_enviarA.setText("");
            input_asunto.setText("");
            input_mensaje.setText("");
            label_archivosAdjuntos.setText("");
            mArchivosAdjuntos = null;
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(EnviarCorreo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EnviarCorreo.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        input_enviarA = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        input_asunto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        input_mensaje = new javax.swing.JTextPane();
        btn_enviar = new javax.swing.JButton();
        label_archivosAdjuntos = new javax.swing.JLabel();
        btn_archivosAdjuntos = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Envio de Correo");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Enviar a:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Asunto:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Contenido:");

        jScrollPane1.setViewportView(input_mensaje);

        btn_enviar.setText("Enviar");
        btn_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enviarActionPerformed(evt);
            }
        });

        label_archivosAdjuntos.setText("..");

        btn_archivosAdjuntos.setText("Archivos Adjuntos");
        btn_archivosAdjuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_archivosAdjuntosActionPerformed(evt);
            }
        });

        jButton3.setText("Lista Reclutadores");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("MSJ Predeterminado");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_enviar)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(input_asunto, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(label_archivosAdjuntos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_archivosAdjuntos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(input_enviarA, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(input_enviarA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input_asunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_enviar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_archivosAdjuntos)
                        .addGap(18, 18, 18)
                        .addComponent(label_archivosAdjuntos, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enviarActionPerformed
        createEmail();
        sendEmail();
    }//GEN-LAST:event_btn_enviarActionPerformed

    private void btn_archivosAdjuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_archivosAdjuntosActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if (chooser.showSaveDialog(this) != JFileChooser.CANCEL_OPTION) {
            mArchivosAdjuntos = chooser.getSelectedFiles();
            for (File archivo : mArchivosAdjuntos) {
                nombre_archivoAdjunto += archivo.getName() + "<br>";
            }
            label_archivosAdjuntos.setText("<html> <p>" + nombre_archivoAdjunto + "</html> </p>");
        }
    }//GEN-LAST:event_btn_archivosAdjuntosActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JDesktopPane desktop = getDesktopPane();
        desktop.removeAll();
        desktop.repaint();

        ListaDeReclutadores pagina1 = new ListaDeReclutadores();
        pagina1.setVisible(true);
        desktop.add(pagina1);
        desktop.moveToFront(pagina1);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       input_mensaje.setText("");
       input_mensaje.setText("¡Hola [Nombre del destinatario]!\n" +
"\n" +
"Espero que este mensaje te encuentre bien. Mi nombre es [Tu Nombre] y me dirijo a ti con el objetivo de expresar mi interés en la posición de desarrollador web Java en [Nombre de la empresa o proyecto]. Después de haber investigado sobre su empresa y sus proyectos, estoy convencido de que mi experiencia y habilidades pueden aportar significativamente al equipo.");
       
        
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_archivosAdjuntos;
    private javax.swing.JButton btn_enviar;
    private javax.swing.JTextField input_asunto;
    private javax.swing.JTextField input_enviarA;
    private javax.swing.JTextPane input_mensaje;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_archivosAdjuntos;
    // End of variables declaration//GEN-END:variables

    private void cargarMail(Reclutador reclutador) {
        input_enviarA.setText(reclutador.getCorreo());
    }

    private void cargarMail(String correo) {
        input_enviarA.setText(correo);
    }

    private void refistrarConsulta(Consulta consulta) {
        ConsultaData.subirConsulta(consulta);
    }
}
