package datos;
 
import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
 
/**
 * @author datojava.blogspot.com
 */
public class DJCorreoTexto {
 
 public void mandarCorreo(String envioA, String contrasenia) {
  // El correo gmail de envío
  String correoEnvia = "percepcionuml@gmail.com";
  String claveCorreo = "Nishikori3";
 
  // La configuración para enviar correo
  Properties properties = new Properties();
  properties.put("mail.smtp.host", "smtp.gmail.com");
  properties.put("mail.smtp.starttls.enable", "true");
  properties.put("mail.smtp.port", "587");
  properties.put("mail.smtp.auth", "false");
  properties.put("mail.user", correoEnvia);
  properties.put("mail.password", claveCorreo);
 
  // Obtener la sesion
  Session session = Session.getInstance(properties, null);
 
  try {
   // Crear el cuerpo del mensaje
   MimeMessage mimeMessage = new MimeMessage(session);
 
   // Agregar quien envía el correo
   mimeMessage.setFrom(new InternetAddress(correoEnvia, "Dato IMPORTANTE PercepcionUML"));
    
   // Los destinatarios
   InternetAddress[] internetAddresses = {
     new InternetAddress(envioA)};
 
   // Agregar los destinatarios al mensaje
   mimeMessage.setRecipients(Message.RecipientType.TO,
     internetAddresses);
 
   // Agregar el asunto al correo
   mimeMessage.setSubject("Contraseña para Percepcion UML");
 
   // Creo la parte del mensaje
   MimeBodyPart mimeBodyPart = new MimeBodyPart();
   mimeBodyPart.setText("Usted ha creado un Diagrama de clases, como usted no ha puesto un pass, se le esta asignando uno. \nSolo con esta contraseña podra ingresar al mismo: \n \n " +contrasenia +"\n \n \n Muchas gracias por utilizar este software. ");
 
   

   
   
   
   // Crear el multipart para agregar la parte del mensaje anterior
   Multipart multipart = new MimeMultipart();
   multipart.addBodyPart(mimeBodyPart);
  
 
   // Agregar el multipart al cuerpo del mensaje
   mimeMessage.setContent(multipart);
 
   // Enviar el mensaje
   Transport transport = session.getTransport("smtp");
   transport.connect(correoEnvia, claveCorreo);
   transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
   transport.close();
 
  } catch (Exception ex) {
   ex.printStackTrace();
  }
  System.out.println("Correo enviado");
 }
 
 
 
 public void mandarTXTDeDirectorio() {
	  // El correo gmail de envío
	  String correoEnvia = "percepcionuml@gmail.com";
	  String claveCorreo = "Nishikori3";
	  
	  // La configuración para enviar correo
	  Properties properties = new Properties();
	  properties.put("mail.smtp.host", "smtp.gmail.com");
	  properties.put("mail.smtp.starttls.enable", "true");
	  properties.put("mail.smtp.port", "587");
	  properties.put("mail.smtp.auth", "false");
	  properties.put("mail.user", correoEnvia);
	  properties.put("mail.password", claveCorreo);
	 
	  // Obtener la sesion
	  Session session = Session.getInstance(properties, null);
	 
	  try {
	   // Crear el cuerpo del mensaje
	   MimeMessage mimeMessage = new MimeMessage(session);
	 
	   // Agregar quien envía el correo
	   mimeMessage.setFrom(new InternetAddress(correoEnvia, "Te han enviados los ultimos Boletines de Navegacion maritima."));
	    
	   // Los destinatarios
	   InternetAddress[] internetAddresses = {
	     new InternetAddress("percepcionuml@gmail.com")};
	 
	   // Agregar los destinatarios al mensaje
	   mimeMessage.setRecipients(Message.RecipientType.TO,
	     internetAddresses);
	 
	   // Agregar el asunto al correo
	   mimeMessage.setSubject("Ultimos boletines");
	 
	   // Creo la parte del mensaje
	   MimeBodyPart mimeBodyPart = new MimeBodyPart();
	   mimeBodyPart.setText("Se adjuntan los txt correspondientes a los ultimos boletines. \n\n\nServicio Meteorologico Nacional.");
	 
	   
	   File dir = new File("C:\\Users\\nico_\\Desktop\\Warning\\WarningViejos");
	   String cabeceraDir = "C:\\Users\\nico_\\Desktop\\Warning\\WarningViejos\\";
		
		String[] ficheros = dir.list();
		
		
		
	 
	   
	   
	
	 
	   
	
	   
	   
	   
	
	   
	   
	   Multipart multipart = new MimeMultipart();
	   multipart.addBodyPart(mimeBodyPart);
	   
	   
	   
	   // Crear el multipart para agregar la parte del mensaje anterior
	   for(String s: ficheros) {
			  MimeBodyPart adjunto = new MimeBodyPart();
			   adjunto.setDataHandler(
			       new DataHandler(new FileDataSource(cabeceraDir +s)));
			   adjunto.setFileName(s);
			   multipart.addBodyPart(adjunto);
		  }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   //multipart.addBodyPart(adjunto2);
	   //multipart.addBodyPart(adjuntoDescarga);
	 
	   // Agregar el multipart al cuerpo del mensaje
	   mimeMessage.setContent(multipart);
	 
	   // Enviar el mensaje
	   Transport transport = session.getTransport("smtp");
	   transport.connect(correoEnvia, claveCorreo);
	   transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
	   transport.close();
	 
	  } catch (Exception ex) {
	   ex.printStackTrace();
	  }
	  System.out.println("Correo enviado");
	 }
 
 
 
 public void mandarDCPorCorreo(String enviarA, String enviadoPor, String asunto, String url, String textoOir, String protocolo, String urlRelativa) {
	  // El correo gmail de envío
	  String correoEnvia = "percepcionuml@gmail.com";
	  String claveCorreo = "Nishikori3";
	 
	  // La configuración para enviar correo
	  Properties properties = new Properties();
	  properties.put("mail.smtp.host", "smtp.gmail.com");
	  properties.put("mail.smtp.starttls.enable", "true");
	  properties.put("mail.smtp.port", "587");
	  properties.put("mail.smtp.auth", "false");
	  properties.put("mail.user", correoEnvia);
	  properties.put("mail.password", claveCorreo);
	 
	  // Obtener la sesion
	  Session session = Session.getInstance(properties, null);
	 
	  try {
	   // Crear el cuerpo del mensaje
	   MimeMessage mimeMessage = new MimeMessage(session);
	 
	   // Agregar quien envía el correo
	   mimeMessage.setFrom(new InternetAddress(correoEnvia, "Te han enviado un Diagrama de Clases creado por: Percepcion UML"));
	    
	   // Los destinatarios
	   InternetAddress[] internetAddresses = {
	     new InternetAddress(enviarA)};
	 
	   // Agregar los destinatarios al mensaje
	   mimeMessage.setRecipients(Message.RecipientType.TO,
	     internetAddresses);
	 
	   // Agregar el asunto al correo
	   mimeMessage.setSubject(asunto);
	 
	   // Creo la parte del mensaje
	   MimeBodyPart mimeBodyPart = new MimeBodyPart();
	   mimeBodyPart.setText("Gracias por leernos. Si usted recibio este mensaje es porque alguien quiere compartir un diagrama de clases con " +enviarA +", este diagrama ha sido enviado por "
	   +enviadoPor +"\n\nA continuación se dejara el texto generado para interpretar este DC en el archivo texto.txt \n\n"  +"\n\n\n\nAdemas desea descargar el protocolo que genera el DC puede hacerlo desde el archivo protocolo.txt. \nTambien puede descargar el audio en formato mp3, con el archivo descarga.txt.\n\n\nMuchas gracias... Percepción UML.\n\n\n");
	 
	   
	  
	   
	// Se compone el adjunto con el texto
	   MimeBodyPart adjunto = new MimeBodyPart();
	   adjunto.setDataHandler(
	       new DataHandler(new FileDataSource(urlRelativa+"/texto.txt")));
	   adjunto.setFileName("/texto.txt");
	   
	   
	// Se compone el adjunto con el texto
	   MimeBodyPart adjunto2 = new MimeBodyPart();
	   adjunto2.setDataHandler(
	       new DataHandler(new FileDataSource(urlRelativa+"/protocolo.txt")));
	   adjunto2.setFileName("/protocolo.txt");
	   
	   //adjunto con la descarga del audio
	   MimeBodyPart adjuntoDescarga = new MimeBodyPart();
	   adjuntoDescarga.setDataHandler(
	       new DataHandler(new FileDataSource(urlRelativa+"/descarga.txt")));
	   adjuntoDescarga.setFileName("/descarga.txt");
	   
	   
	   // Crear el multipart para agregar la parte del mensaje anterior
	   Multipart multipart = new MimeMultipart();
	   multipart.addBodyPart(mimeBodyPart);
	   multipart.addBodyPart(adjunto);
	   multipart.addBodyPart(adjunto2);
	   multipart.addBodyPart(adjuntoDescarga);
	 
	   // Agregar el multipart al cuerpo del mensaje
	   mimeMessage.setContent(multipart);
	 
	   // Enviar el mensaje
	   Transport transport = session.getTransport("smtp");
	   transport.connect(correoEnvia, claveCorreo);
	   transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
	   transport.close();
	 
	  } catch (Exception ex) {
	   ex.printStackTrace();
	  }
	  System.out.println("Correo enviado");
	 }
 
 
 public void mandarDCPorCorreoSoloImagen(String enviarA, String enviadoPor, String asunto, String link, String urlRelativa) {
	  // El correo gmail de envío
	  String correoEnvia = "percepcionuml@gmail.com";
	  String claveCorreo = "Nishikori3";
	 
	  // La configuración para enviar correo
	  Properties properties = new Properties();
	  properties.put("mail.smtp.host", "smtp.gmail.com");
	  properties.put("mail.smtp.starttls.enable", "true");
	  properties.put("mail.smtp.port", "587");
	  properties.put("mail.smtp.auth", "false");
	  properties.put("mail.user", correoEnvia);
	  properties.put("mail.password", claveCorreo);
	 
	  // Obtener la sesion
	  Session session = Session.getInstance(properties, null);
	 
	  try {
	   // Crear el cuerpo del mensaje
	   MimeMessage mimeMessage = new MimeMessage(session);
	 
	   // Agregar quien envía el correo
	   mimeMessage.setFrom(new InternetAddress(correoEnvia, "Te han enviado un Diagrama de Clases creado por: Percepcion UML"));
	    
	   // Los destinatarios
	   InternetAddress[] internetAddresses = {
	     new InternetAddress(enviarA)};
	 
	   // Agregar los destinatarios al mensaje
	   mimeMessage.setRecipients(Message.RecipientType.TO,
	     internetAddresses);
	 
	   // Agregar el asunto al correo
	   mimeMessage.setSubject(asunto);
	 
	   // Creo la parte del mensaje
	   MimeBodyPart mimeBodyPart = new MimeBodyPart();
	   mimeBodyPart.setText("Gracias por leernos. Si usted recibio este mensaje es porque alguien quiere compartir un diagrama de clases con " +enviarA +", este diagrama ha sido enviado por "
	   +enviadoPor +"\n\nA continuación se dejara el link para acceder a la imagen del DC\n\n\n\n\n\n\n\nLink: " +link);
	 
	   
	// Se compone el adjunto con el texto
	   MimeBodyPart adjunto = new MimeBodyPart();
	   adjunto.setDataHandler(
	       new DataHandler(new FileDataSource(urlRelativa+"/texto.txt")));
	   adjunto.setFileName("/texto.txt");
	   
	   

	   
	   // Crear el multipart para agregar la parte del mensaje anterior
	   Multipart multipart = new MimeMultipart();
	   multipart.addBodyPart(mimeBodyPart);
	   multipart.addBodyPart(adjunto);

	 
	   // Agregar el multipart al cuerpo del mensaje
	   mimeMessage.setContent(multipart);
	 
	   // Enviar el mensaje
	   Transport transport = session.getTransport("smtp");
	   transport.connect(correoEnvia, claveCorreo);
	   transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
	   transport.close();
	 
	  } catch (Exception ex) {
	   ex.printStackTrace();
	  }
	  System.out.println("Correo enviado");
	 }
 
 
 
 public void mandarDCPorCorreo(String enviarA, String enviadoPor, String asunto,String urlRelativa) {
	  // El correo gmail de envío
	  String correoEnvia = "percepcionuml@gmail.com";
	  String claveCorreo = "Nishikori3";
	 
	  // La configuración para enviar correo
	  Properties properties = new Properties();
	  properties.put("mail.smtp.host", "smtp.gmail.com");
	  properties.put("mail.smtp.starttls.enable", "true");
	  properties.put("mail.smtp.port", "587");
	  properties.put("mail.smtp.auth", "false");
	  properties.put("mail.user", correoEnvia);
	  properties.put("mail.password", claveCorreo);
	 
	  // Obtener la sesion
	  Session session = Session.getInstance(properties, null);
	 
	  try {
	   // Crear el cuerpo del mensaje
	   MimeMessage mimeMessage = new MimeMessage(session);
	 
	   // Agregar quien envía el correo
	   mimeMessage.setFrom(new InternetAddress(correoEnvia, "Te han enviado un Diagrama de Clases creado por: Percepcion UML"));
	    
	   // Los destinatarios
	   InternetAddress[] internetAddresses = {
	     new InternetAddress(enviarA)};
	 
	   // Agregar los destinatarios al mensaje
	   mimeMessage.setRecipients(Message.RecipientType.TO,
	     internetAddresses);
	 
	   // Agregar el asunto al correo
	   mimeMessage.setSubject(asunto);
	 
	   // Creo la parte del mensaje
	   MimeBodyPart mimeBodyPart = new MimeBodyPart();
	   mimeBodyPart.setText("Gracias por leernos. Si usted recibio este mensaje es porque alguien quiere compartir un diagrama de clases con " +enviarA +", este diagrama ha sido enviado por "
	   +enviadoPor +"\n\nA continuación se dejara el texto generado para interpretar este DC en el archivo texto.txt \n\n"  +"\n\n\n\nAdemas desea descargar el protocolo que genera el DC puede hacerlo desde el archivo protocolo.txt. \nTambien puede descargar el audio en formato mp3, con el archivo descarga.txt.\n\n\nMuchas gracias... Percepción UML.\n\n\n");
	 
	   
	
	   
	   
	   // Crear el multipart para agregar la parte del mensaje anterior
	   Multipart multipart = new MimeMultipart();
	   multipart.addBodyPart(mimeBodyPart);
	   
	   // Agregar el multipart al cuerpo del mensaje
	   mimeMessage.setContent(multipart);
	 
	   // Enviar el mensaje
	   Transport transport = session.getTransport("smtp");
	   transport.connect(correoEnvia, claveCorreo);
	   transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
	   transport.close();
	 
	   
	   System.out.println("Correo enviado");
	  } catch (Exception ex) {
	   ex.printStackTrace();
	   System.out.println("Erroor");
	  }
	
	 }

 
 
 
 

}