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
                            "wie ich mit gro??er Begeisterung auf der Internetseite der Bundesagentur f??r Arbeit entnehmen konnte, bieten sie eine Ausbildung zum Fachinformatiker an. Gerne bringe ich mit diesem Schreiben meine Motivation und mein Engagement f??r die Ausbildung in Ihrem Unternehmen zum Ausdruck. <br>\n" +
                            "<br>\n" +
                            "Ich bin ein 27-j??hriger Marokkaner. Ich wohne immer noch in Marokko und habe hier mein Abitur absolviert und ein Diplom als IT-Spezialist abgeschlossen. <br>\n" +
                            "Durch mein besonderes Interesse in dem Bereich IT sowie meinen guten Kenntnissen in der Fachinformatik, m??chte ich Sie davon ??berzeugen, dass ich diese T??tigkeit nach Ihren Vorstellungen ausf??llen kann.  <br>\n" +
                            "Ich habe mir Deutsch alleine angeeignet und am Goethe-Institut die Pr??fung f??r das B1-Zertifikat mit \"gut\" bestanden.Momentan lerne ich f??r das B2-Zertifikat auf einer Privatschule.  <br>\n" +
                            "Interkulturelle Kompetenz bringe ich selbstverst??ndlich ebenfalls mit, da ich Englisch, und Franz??sisch beherrsche. Arabisch ist meine Muttersprache.  <br>\n" +
                            "Jetzt m??chte ich sehr gerne noch einen Schritt weiter gehen und die vielen weiteren Facetten, die dieser Beruf mit sich bringt in Deutschland erlernen.  <br>\n" +
                            "<br>\n" +
                            "Im Anhang finden Sie meine  Bewerbungsunterlagen (??bersetzt).  <br>\n" +
                            "Bei R??ckfragen stehe ich Ihnen gerne zur Verf??gung und freue mich schon darauf, Sie in einem pers??nlichen Vorstellungsgespr??ch von mir ??berzeugen zu d??rfen .  <br>\n" +
                            "<br>\n" +
                            "Danke im Voraus f??r Ihre Antwort.  <br>\n" +
                            "<br>\n" +
                            "Freundliche Gr????e  <br>\n" +
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
