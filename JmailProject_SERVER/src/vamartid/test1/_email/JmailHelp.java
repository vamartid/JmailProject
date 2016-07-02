/*
 * License Copyright © 2000 Vasileios Martidis vamartid@yandex.com 
 * This work is free. You can redistribute it and/or modify it under
 *  the terms of the Do What The Fuck You Want To Public License,
 *  Version 2, as published by Sam Hocevar.
 *  See http://www.wtfpl.net/ for more details.
 */
package vamartid.test1._email;
//——————————————————————————————————————————————————————————————————————————————————————

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
//——————————————————————————————————————————————————————————————————————————————————————

/**
 * This Class JmailHelp is very important class witch gives the server Power to
 * checks files and txt in order to save,and edit data of the user's and their
 * emails
 *
 * @author basilism
 */
public class JmailHelp {

    static String urLoc = "C:/";
    static String loginDataDir = urLoc + "_javaMailData/loginData.txt";
    static String userMailsDir = urLoc + "_javaMailData/userMails";
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This is constructor of JmailHelp object needed to change the directory to
     * the right one
     */
    public JmailHelp() {
        try {
            urLoc = set_path(urLoc);
        } catch (URISyntaxException ex) {
            urLoc = "dicks";
        }
        loginDataDir = urLoc + "_javaMailData/loginData.txt";
        userMailsDir = urLoc + "_javaMailData/userMails";
    }

    /**
     * This method register adds a next raw to the txt with the data of the
     * users using the above parameters
     *
     * @param username1 is the username
     * @param code1 is the password
     * @param first1 is the first name
     * @param last1 is the last name
     * @param birthday1 is the birthday
     * @param currentmail1 is the current email address
     *
     */
    public void register(String username1, String code1, String first1, String last1, String birthday1, String currentmail1) {
        if (!(username1.equals(" Enter a username")
                || (code1.equals(" Enter a password"))
                || (first1.equals(" Enter your FirstName"))
                || (last1.equals(" Enter your LastName"))
                || (birthday1.equals(" Your birthday mm/dd/yy"))
                || (currentmail1.equals(" Enter your address")))) {

            boolean success = (new File(userMailsDir + "/" + username1)).mkdirs();
            if (success) {
                System.out.println("Directories: "
                        + userMailsDir + "/" + username1 + " created");
            }

            try (PrintWriter out
                    = new PrintWriter(new BufferedWriter(new FileWriter(loginDataDir, true)))) {
                //theFile.println(neoAem+" "+neoOnoma+" "+neoEponumo);
                //out.write(username1+":"+code1+":"+first1+":"+last1+":"+birthday1+":"+currentmail1);
                out.println(username1 + "::::" + code1 + "::::" + first1 + "::::" + last1 + "::::" + birthday1 + "::::" + currentmail1 + "::::off");
                out.close();

                System.out.println("JMAIL      : The account has been saved.");
            } catch (IOException e) {
                System.err.println("JMAIL      : Something went wrong.");
            }

        } else {
            System.out.println("JMAIL      : wrong data Write them again");
        }
    }
//——————————————————————————————————————————————————————————————————————————————————————
    //String myfile = "D:\\Desktop\\javamail_data\\loginData.txt";
    //System.out.println("1"+u+"2"+p);
    //"D:\\Desktop\\javamail_data"

    /**
     * This method login_compare takes the 2 important fields and check's if
     * they exist in the login data and returns the value of result.If a user is
     * not log in it writes him as logged in and alow him to log in.
     *
     * @param u username
     * @param p password
     * @return returns 0 if it does not exist,1 if it exist and not logged in
     * then allow to log in,2 if it exist and it is logged in already
     *
     */
    public int login_compare(String u, String p) {
        try (BufferedReader theFile = new BufferedReader(new FileReader(loginDataDir))) {
            String LineFromFile;
            while ((LineFromFile = theFile.readLine()) != null) {
                String[] InfoFromFile = LineFromFile.split("::::");
                String username = InfoFromFile[0];
                String code = InfoFromFile[1];
                if (username.equals(u)) {
                    if (code.equals(p)) {
                        if (InfoFromFile[6].equals("off")) {
                            System.out.println("JMAIL      : >this acc");
                            //                        System.out.println("first name " + InfoFromFile[2]);
                            //                        System.out.println("last name " + InfoFromFile[3]);
                            //                        System.out.println("birthday " + InfoFromFile[4]);
                            //                        System.out.println("currentmail " + InfoFromFile[5]);
                            String newLineIs = InfoFromFile[0] + "::::" + InfoFromFile[1]
                                    + "::::" + InfoFromFile[2] + "::::" + InfoFromFile[3] + "::::"
                                    + InfoFromFile[4] + "::::" + InfoFromFile[5];
                            //System.out.println(newLineIs);
                            //System.out.println();
                            replaceSelected(newLineIs, "::::onn");

                            return 1;
                            //grapse onn ekei
                        } else {
                            return 2;
                        }

                    }
                } else {
                    System.out.println("JMAIL      : >not this acc");
                    if (LineFromFile.equals(null)) {
                        return 0;

                    }
                }

            }
        } catch (Exception e) {
            System.out.println("JMAIL      : errorrororor--login");
        }
        return 0;
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method find_the_mails find all email's of the directory witch is
     * given
     *
     * @param dirName name of the user's directory
     * @return a File[] array with all the data of the user (emails)
     *
     */
    public File[] find_the_mails(String dirName) {
        //dirName = "_javaMailData/userMails/qwe";
        File dir = new File(dirName);

        return dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename) {
                return filename.endsWith(".txt");
            }
        });

    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method read_mail creates an Email object from the txt email file we
     * give and returns it to the server in order to be sent to the client If
     * the asd is false it does not declare it as read(by changing value of
     * isNew(don't forget it can always be false if it was read before)) if it
     * is false it does
     *
     * @param a the file of the email we need to read (change read value)
     * @param asd the boolean witch declares if the receiver read it or just
     * sent the Email object to the receiver
     * @return the Email object
     *
     */
    public Email read_mail(File a, boolean asd) {
        try (BufferedReader theFile = new BufferedReader(new FileReader(a.getAbsolutePath()))) {
            String LineFromFile;
            LineFromFile = theFile.readLine();
            String from = null;
            String to = null;
            String subject = null;
            String message = null;
            boolean aaaaa = true;
            int y = 0;
            while ((LineFromFile != null)) {

                if ((message == null)) {
                    String[] InfoFromFile = LineFromFile.split("::::");
                    if (InfoFromFile[0].equals("true")) {
                        aaaaa = Boolean.parseBoolean(InfoFromFile[0]);
                        boolean read = true;
                    } else {

                    }
                    from = InfoFromFile[1];
                    to = InfoFromFile[2];
                    subject = InfoFromFile[3];
                    message = InfoFromFile[4];
                    aaaaa = Boolean.parseBoolean(InfoFromFile[0]);
                    LineFromFile = theFile.readLine();

                } else {
                    message = message + "\n" + LineFromFile;
                    LineFromFile = theFile.readLine();
                }

            }
            if (asd) {//DIAVAZEI-pes oti diavastike gt anoixe na dei to message
                PrintWriter writer = new PrintWriter(a);
                writer.print("false::::" + from + "::::" + to + "::::" + subject + "::::" + message + "\n");
                writer.close();
                y = 1;
                //kai the these to false kathos pleon den einai kainourio
            } else {//KANEI REFRESH-itan to refresh arra den to alazw
                //do nothing 
            }//[229,137,45]
            Email mail = null;
            if (y == 1) {//
                mail = new Email(from, to, subject, message, false);
                //ftiaxe ena mail me false sto is new
            } else {
                mail = new Email(from, to, subject, message, aaaaa);
            }
            return mail;
        } catch (Exception e) {
            System.err.println("JMAIL      : Read_mail error");
        }

        return new Email("", "", "", "");
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method checkUsername checks if a username exist Server use that
     * method to see if a username of the receiver exist When someone sends a
     * new mail
     *
     * @param username user's username
     * @return true if the username exist false if not
     * @throws IOException if something goes wrong with the streams
     *
     */
    public boolean checkUsername(String username) throws IOException {
        try (BufferedReader theFile = new BufferedReader(new FileReader(loginDataDir))) {
            String LineFromFile;
            int i = 0;
            while ((LineFromFile = theFile.readLine()) != null) {
                i = i + 1;
                String[] InfoFromFile = LineFromFile.split("::::");
                if (InfoFromFile[0].equals(username)) {
                    //System.out.println("vrethike");
                    return true;
                }
                //System.out.println("Den vrethike stin seira " + i);
            }
            //System.out.println("Den vrethike GENIKOS");
            return false;

        }
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method StringToboolean converts string 'true' and 'false' to boolean
     * value
     *
     * @param a the string with the value we want
     * @return true if it was 'true' false if bit
     *
     */
    public boolean StringToboolean(String a) {
        // String Objects
        String str = "false";
        // Case does not matter for conversion
        String str2 = "true";

        // String to boolean conversion
        //boolean bvar = Boolean.parseBoolean(str);
        //boolean bvar2 = Boolean.parseBoolean(str2);
        if (Boolean.parseBoolean(str)) {
            return false;
        } else {
            return true;
        }
//      // Displaying boolean values
//      System.out.println("boolean value of String str is: "+bvar);
//      System.out.println("boolean value of String str2 is: "+bvar2);

    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method CreateTheMail creates a txt witch represent's the email,to
     * the receivers folder
     *
     * @param NewMail the Email we want to sent as an Email object
     * @return a boolean true if the mail was sent false if not
     *
     */
    boolean CreateTheMail(Email NewMail) {
        try (PrintWriter out
                = new PrintWriter(new BufferedWriter(new FileWriter(userMailsDir + "/" + NewMail.get_receiver() + "/" + NewMail.get_subject() + ".txt", true)))) {
            out.println(NewMail.get_isNew() + "::::" + NewMail.get_sender() + "::::" + NewMail.get_receiver() + "::::" + NewMail.get_subject() + "::::" + NewMail.get_mainbody());
            out.close();

            //System.out.println("The Email has been saved to the Reciever");
            System.out.println("JMAIL      : Send mail It will be sent in a bit");
            return true;
        } catch (IOException e) {
            System.err.println("JMAIL      : Send mail Something went wrong");
            return false;
        }
    }
//——————————————————————————————————————————————————————————————————————————————————————
//replace line,onn

    /**
     * This method replaceSelected changes off with on or on with off used for
     * log in and log off
     *
     * @param replaceWith left string witch is ready
     * @param type declares the type of change
     *
     */
    public static void replaceSelected(String replaceWith, String type) {
        try {
            // input the file content to the String "input"
            BufferedReader file = new BufferedReader(new FileReader(loginDataDir));
            String line;
            String input = "";
            while ((line = file.readLine()) != null) {
                input += line + '\n';
            }
            file.close();
            //System.out.println(input); // check that it's inputted right

            // this if structure determines whether or not to replace "0" or "1"
            if (type.equals("::::off")) {
                input = input.replace(replaceWith + "::::onn", replaceWith + "::::off");
            } else if (type.equals("::::onn")) {
                input = input.replace(replaceWith + "::::off", replaceWith + "::::onn");
            }

            // check if the new input is right
            //System.out.println("----------------------------------"  + '\n' + input);
            // write the new String with the replaced line OVER the same file
            FileOutputStream fileOut = new FileOutputStream(loginDataDir);
            fileOut.write(input.getBytes());
            fileOut.close();

        } catch (Exception e) {
            System.out.println("Problem reading file.");
        }
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method resetONN Makes all the users data to declare that they are
     * offline
     *
     */
    public static void resetONN() {
        File f = new File(loginDataDir);
        //System.out.println(loginDataDir);
        if (f.exists() && !f.isDirectory()) {
            try (BufferedReader theFile = new BufferedReader(new FileReader(loginDataDir))) {
                String LineFromFile;
                while ((LineFromFile = theFile.readLine()) != null) {
                    String[] InfoFromFile = LineFromFile.split("::::");
                    String newLineIs = InfoFromFile[0] + "::::" + InfoFromFile[1]
                            + "::::" + InfoFromFile[2] + "::::" + InfoFromFile[3] + "::::"
                            + InfoFromFile[4] + "::::" + InfoFromFile[5];
                    //System.out.println(newLineIs);
                    //System.out.println();
                    replaceSelected(newLineIs, "::::off");
                }
            } catch (Exception e) {
                System.out.println("JMAIL      : something else-reset");
            }
        } else {
            System.out.println("JMAIL      : cant find file -reset");
        }
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method logout makes user's data to declare that he is offline
     *
     * @param u user's name
     *
     */
    public void logout(String u) {
        try (BufferedReader theFile = new BufferedReader(new FileReader(loginDataDir))) {
            String LineFromFile;
            while ((LineFromFile = theFile.readLine()) != null) {
                String[] InfoFromFile = LineFromFile.split("::::");
                String username = InfoFromFile[0];
                String code = InfoFromFile[1];
                if (username.equals(u)) {
                    if (InfoFromFile[6].equals("onn")) {
                        System.out.println("JMAIL      : " + u + " logged out");
                        String newLineIs = InfoFromFile[0] + "::::" + InfoFromFile[1]
                                + "::::" + InfoFromFile[2] + "::::" + InfoFromFile[3] + "::::"
                                + InfoFromFile[4] + "::::" + InfoFromFile[5];
                        //System.out.println(newLineIs);
                        //System.out.println();
                        replaceSelected(newLineIs, "::::off");
                    }
                } else //System.out.println("JMAIL      : >not this acc");
                {
                    if (LineFromFile.equals(null)) {
                        // return 0;

                    }
                }

            }
        } catch (Exception e) {
            System.out.println("JMAIL      : errorrororor--logout");
        }
    }

    /**
     * This method takes the real path of the jar or the project if its running
     * from IDE It changes its from couse getLocation gives it in a not wanted
     * form
     *
     * @param path path of the project or the jar file
     * @return the right path
     * @throws URISyntaxException if something goes wrong with the URI
     *
     */
    private String set_path(String path) throws URISyntaxException {
        path = new File(JmailHelp.class.getProtectionDomain().getCodeSource().getLocation().toURI()).toString();
        String jarname = new java.io.File(JmailHelp.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getName().toString();
        path = path.replace('\\', '/');
        //System.out.println("path>>>>"+path);        
        //System.out.println("jarname>>>>" + jarname);
        if (jarname.equals("classes")) {//if it finds "classes" means it is not running from jar and it is running from IDE.
            path = path.replace("build/classes", ""); // i cut build/classes
            //System.out.println("path2.1>>>>" + path);
        } else { //it is running from jar
            path = path.replace(jarname, ""); //i cut only the .jar name
            //System.out.println("path2.2>>>>" + path);
        }
        return path;
    }
//——————————————————————————————————————————————————————————————————————————————————————
}
//——————————————————————————————————————————————————————————————————————————————————————
//——————————————————————————————————————————————————————————————————————————————————————
//——————————————————————————————————————————————————————————————————————————————————————
//——————————————————————————————————————————————————————————————————————————————————————
//——————————————————————————————————————————————————————————————————————————————————————
