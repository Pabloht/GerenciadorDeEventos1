/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QrCode;

import javax.mail.PasswordAuthentication;


/**
 *
 * @author Leonardo
 */
class SMTPAuthenticator extends javax.mail.Authenticator {
	private static final String SMTP_AUTH_USER = "contato@informacaoimportante.com.br";
	private static final String SMTP_AUTH_PWD  = "rwp4002";

     public PasswordAuthentication getPasswordAuthentication() {
        String username = SMTP_AUTH_USER;
        String password = SMTP_AUTH_PWD;
        return new PasswordAuthentication(username, password);
     }
 }
