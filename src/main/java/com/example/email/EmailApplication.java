package com.example.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@SpringBootApplication
public class EmailApplication {

    @Autowired
    private EmailSenderService senderService;

    public static void main(String[] args) {
        SpringApplication.run(EmailApplication.class, args);

    }


    @EventListener(ApplicationReadyEvent.class)
    public void sendEmail() {
        try
        {
            /*String filePath0 = "C:\\Users\\Moi\\Desktop\\Abitur.pdf";
            String filePath1 = "C:\\Users\\Moi\\Desktop\\Amine Tamar - Lebenslauf.pdf";
            String filePath2 = "C:\\Users\\Moi\\Desktop\\Praktika - Informatik .pdf";
            String filePath3 = "C:\\Users\\Moi\\Desktop\\Diplom -informatik.pdf";
            String filePath4 = "C:\\Users\\Moi\\Desktop\\Deutsch B1 goethe institut Zertifikat   .pdf";

            byte[][] bytesArray = new byte[5][];
            bytesArray[0] = Files.readAllBytes(Paths.get(filePath0));
            bytesArray[1] = Files.readAllBytes(Paths.get(filePath1));
            bytesArray[2] = Files.readAllBytes(Paths.get(filePath2));
            bytesArray[3] = Files.readAllBytes(Paths.get(filePath3));
            bytesArray[4] = Files.readAllBytes(Paths.get(filePath4));

            File file=new File("C:\\Users\\Moi\\Desktop\\emails.txt");    //creates a new file instance
            FileReader fr=new FileReader(file);   //reads the file
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
            StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters
            String line;
            while((line=br.readLine())!=null)
            {
                sb.append(line);      //appends line to string buffer
                sb.append("\n");*/

            senderService.sendEmail("mahdi.bouhouch@edu.uiz.ac.ma",
                    "mahdi.bouhouch7@gmail.com",
                    "Ausbildung - Fachinformatiker Anwendungsentwicklung",
                    "<b>Sehr geehrte Damen und Herren,</b>  <br>\n" +
                            "<br>\n" +
                            "wie ich mit großer Begeisterung auf der Internetseite der Bundesagentur für Arbeit entnehmen konnte, bieten sie eine Ausbildung zum Fachinformatiker an. Gerne bringe ich mit diesem Schreiben meine Motivation und mein Engagement für die Ausbildung in Ihrem Unternehmen zum Ausdruck. <br>\n" +
                            "<br>\n" +
                            "Ich bin ein 27-jähriger Marokkaner. Ich wohne immer noch in Marokko und habe hier mein Abitur absolviert und ein Diplom als IT-Spezialist abgeschlossen. <br>\n" +
                            "Durch mein besonderes Interesse in dem Bereich IT sowie meinen guten Kenntnissen in der Fachinformatik, möchte ich Sie davon überzeugen, dass ich diese Tätigkeit nach Ihren Vorstellungen ausfüllen kann.  <br>\n" +
                            "Ich habe mir Deutsch alleine angeeignet und am Goethe-Institut die Prüfung für das B1-Zertifikat mit \"gut\" bestanden.Momentan lerne ich für das B2-Zertifikat auf einer Privatschule.  <br>\n" +
                            "Interkulturelle Kompetenz bringe ich selbstverständlich ebenfalls mit, da ich Englisch, und Französisch beherrsche. Arabisch ist meine Muttersprache.  <br>\n" +
                            "Jetzt möchte ich sehr gerne noch einen Schritt weiter gehen und die vielen weiteren Facetten, die dieser Beruf mit sich bringt in Deutschland erlernen.  <br>\n" +
                            "<br>\n" +
                            "Im Anhang finden Sie meine  Bewerbungsunterlagen (übersetzt).  <br>\n" +
                            "Bei Rückfragen stehe ich Ihnen gerne zur Verfügung und freue mich schon darauf, Sie in einem persönlichen Vorstellungsgespräch von mir überzeugen zu dürfen .  <br>\n" +
                            "<br>\n" +
                            "Danke im Voraus für Ihre Antwort.  <br>\n" +
                            "<br>\n" +
                            "Freundliche Grüße  <br>\n" +
                            "<br>\n" +
                            "<span style=\"color:#808080\"> <b>Amine Tamar</b> </span>"
            );
            /*}
            fr.close();    //closes the stream and release the resources
            System.out.println("Contents of File: ");
            System.out.println(sb.toString());   //returns a string that textually represents the object
        }
        catch(IOException e)
        {
            e.printStackTrace();*/
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
