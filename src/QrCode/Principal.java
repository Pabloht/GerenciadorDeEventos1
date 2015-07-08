/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QrCode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.table.DefaultTableModel;
import model.Evento;
import model.Inscrito;
import service.EventoService;
import service.InscritoService;
import util.EntityManagerUtil;

/**
 *
 * @author Leonardo
 */
public class Principal {

    private static final String SMTP_HOST_NAME = "mail.informacaoimportante.com.br";
    private final EntityManager entityManager = EntityManagerUtil.getEntityManager();
    private InscritoService inscritoService = new InscritoService();
    
    private Inscrito inscrito = new Inscrito();
    static String filePath = "C:\\Users\\PabloHenrique\\Documents\\NetBeansProjects\\GerenciadorDeEventos\\qrcode.png";

    public static void main(String args[]) {

        try {
            //ArrayList<Inscrito> listaInscrito = new ArrayList<Inscrito>();
            //listaInscrito = inscritoService.listarInscrito().                 //retornarInscritoPorEvento; //Este metodo tem que ser criado, depois eu faço ele e te envio :D	
            EventoService eventoService = new EventoService();
            Inscrito inscrito = new Inscrito();
            Evento evento = new Evento();
            evento = eventoService.retornarEvento(1);
            String conteudoQrCode = "Nome do Evento: ";
            conteudoQrCode += ""+ evento.getNome();
            conteudoQrCode += "Local do Evento "+ evento.getLocal();
            gerarQrCode(conteudoQrCode);
            //int cont = 0;
           //While(listaInscrito.size > cont) {
           // enviarEmail("leonardomf90@hotmail.com",inscrito.getNome(), filePath);
                //enviarEmail(listaIncritos().getEmailInscrito ,listaInscritos.getNome(),filePath);
          //  }
       } catch (Exception e) {
            
          System.out.println("ERRO " + e);
       }
    }



    /**
     * try { gerarQrCode(""); String nome = null;
     * //enviarEmail(inscrito.getEmail(), inscrito.getNome(), filePath);
     * //enviarEmail(listaIncritos().getEmailInscrito
     * ,listaInscritos.getNome(),filePath);
     *
     * } catch (Exception e) { // TODO: handle exception
     * System.out.println("ERRO " + e);
        }*
     */


public static void gerarQrCode(String texto) {

        String myCodeText = texto;
        int size = 250;
        String fileType = "png";
        File myFile = new File(filePath);
        try {
            Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<EncodeHintType, ErrorCorrectionLevel>();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix byteMatrix = qrCodeWriter.encode(myCodeText, BarcodeFormat.QR_CODE, size, size, hintMap);
            int CrunchifyWidth = byteMatrix.getWidth();
            BufferedImage image = new BufferedImage(CrunchifyWidth, CrunchifyWidth,
                    BufferedImage.TYPE_INT_RGB);
            image.createGraphics();

            Graphics2D graphics = (Graphics2D) image.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, CrunchifyWidth, CrunchifyWidth);
            graphics.setColor(Color.BLACK);

            for (int i = 0; i < CrunchifyWidth; i++) {
                for (int j = 0; j < CrunchifyWidth; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
            ImageIO.write(image, fileType, myFile);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("\n\nYou have successfully created QR Code.");
    }

    public static void enviarEmail(String para, String nome, String pathQrCode, String conteudoEmail, String nomeEvento) {
        Inscrito inscrito = new Inscrito();
        try {

            Properties props = new Properties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.host", SMTP_HOST_NAME);
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");

            Authenticator auth = new SMTPAuthenticator();
            Session mailSession = Session.getDefaultInstance(props, auth);
            //mailSession.setDebug(true);
            // uncomment for debugging infos to stdout
            // mailSession.setDebug(true);
            Transport transport = mailSession.getTransport();
            // String texto = "Olá <b>"+nome+"</b><br><br>";
          String texto = "<html><body><center><img src='C:\\Users\\Leonardo\\Desktop\\dedo.jpg'></center>";
            texto += "Olá " + nome + ", </b><br><br>";
           texto += "Seja bem-vindo(a) ao " + nomeEvento + ".<br><br>";          
            texto += conteudoEmail + "<br><br>";
            texto += "<br>Agradecemos pela atenção e desejamos um bom evento!<br><br>";
            texto += "<p style='color:red;font-weight:bold'>ESTE EMAIL FOI GERADO AUTOMATICAMENTE PELO SISTEMA GERENCIADOR DE EVENTOS - FAVOR NÃO RESPONDÊ-LO.</p>";
            texto += "Equipe Gerenciaodora dos Eventos</body></html>";
            MimeMessage message = new MimeMessage(mailSession);
            //message.setContent(texto, "html");
            message.setFrom(new InternetAddress("leonardomf1990@gmail.com"));
            message.setSubject("[IMPORTANTE] Orientações Bibliotech 2015");
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(para));
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(texto, "text/html; charset=UTF-8");
            Multipart multipart = new MimeMultipart();

            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(pathQrCode);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(pathQrCode);
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);

            transport.connect();
            transport.sendMessage(message,
                    message.getRecipients(Message.RecipientType.TO));
            transport.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("erro envio email: " + e);
        }

    }

          
  
    
        
    }
