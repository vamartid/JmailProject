package vamartid.test1._email;
//——————————————————————————————————————————————————————————————————————————————————————

import java.io.*;
import java.net.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//——————————————————————————————————————————————————————————————————————————————————————

public class MY_socket_CLIENT {

    static int PORT = 444;
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method login send the username and the password and returns the result
     * 
     * @param user represents the username
     * @param pass represents the password
     * @param SOCK the socket of the client
     * @return 0 if login is successful, 1 if it was not successful, 2 if it
     * failed to connect because someone else was logged-in in the account
     * @throws Exception if something goes wrong with the streams
     * 
     */
    int login(String user, String pass, Socket SOCK) throws Exception {
//System.out.println("Server is not up");
        //Socket SOCK = new Socket("localhost", 44);
        PrintStream PS = new PrintStream(SOCK.getOutputStream());
        PS.println(user);
        //System.out.println("i send it");
        InputStreamReader IR = new InputStreamReader(SOCK.getInputStream());
        BufferedReader BR = new BufferedReader(IR);
        //====
        String MESSAGE = BR.readLine();
        //System.out.println(MESSAGE);
        //System.out.println("I am in the login");
        PrintStream PS2 = new PrintStream(SOCK.getOutputStream());
        PS2.println(pass);
        InputStreamReader IR2 = new InputStreamReader(SOCK.getInputStream());
        BufferedReader BR2 = new BufferedReader(IR2);

        String MESSAGE2 = BR2.readLine();

        //System.out.println(MESSAGE2);
        //PS.close();
        //PS2.close();
        //IR.close();
        //IR2.close();
        //BR.close();
        //BR2.close();
        //SOCK.close();
        if (MESSAGE2.equals("1")) {
            System.out.println("CLIENT:done login true");
            return 1;
        } else if (MESSAGE2.equals("0")) {
            System.out.println("CLIENT:done login false");
            return 0;
        } else if (MESSAGE2.equals("2")) {
            System.out.println("CLIENT:done login already logged in from other pc");
            return 2;
        }
        return 0;
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method register an Account object and returns the result of the
     * registration
     * 
     * @param NewUser the Account object that we want to register
     * @param SOCK the socket of the client
     * @return true if register was successful false if not
     * @throws Exception if something goes wrong with the streams
     * 
    
     */
    boolean register(Account NewUser, Socket SOCK) throws Exception {
//System.out.println("Server is not up");
        //Socket SOCK = new Socket("localhost", 444);
        //System.out.println("i want to connect");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(SOCK.getOutputStream());
        //ObjectInputStream objectInputStream=new ObjectInputStream(SOCK.getInputStream());
        objectOutputStream.writeObject(NewUser);

        PrintStream PS2 = new PrintStream(SOCK.getOutputStream());
        InputStreamReader IR2 = new InputStreamReader(SOCK.getInputStream());
        BufferedReader BR2 = new BufferedReader(IR2);
        String MESSAGE2 = BR2.readLine();
        //System.out.println(MESSAGE2+" asdasdasdas");
        //String MESSAGE2 = null;
        //System.out.println(MESSAGE2);

//        PS2.close();
//        IR2.close();
//	BR2.close();
        //SOCK.close();
        if (MESSAGE2.equals("true")) {
            System.out.println("CLIENT:done register true");
            return true;
        } else {
            System.out.println("CLIENT:done register false");
            return false;
        }
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method want_mail_catalogue sent a username and receives the Email Array
     * of the emails of the logged in Client user
     * 
     * @param user the user's name
     * @param SOCK the socket of the client
     * @return an Email[] array with all the user's Emails
     * @throws Exception if something goes wrong with the streams
     * 
     */
    Email[] want_mail_catalogue(String user, Socket SOCK) throws Exception {
//System.out.println("Server is not up");
        //Socket SOCK = new Socket("localhost", 4444);
        PrintStream PS = new PrintStream(SOCK.getOutputStream());
        //stelnw ston server to onoma tou user poy thelei ta mails 
        PS.println(user);
        //System.out.println("user was sent");

        ObjectInputStream objectInputStream = new ObjectInputStream(SOCK.getInputStream());
        Email[] MailsData = (Email[]) objectInputStream.readObject();
//        for (int i = 0; i < MailsData.length; i++) {
//            System.out.println("=======Email "+i+" =====");
//            System.out.println(MailsData[i].get_isNew());
//            System.out.println(MailsData[i].get_sender());
//            System.out.println(MailsData[i].get_receiver());
//            System.out.println(MailsData[i].get_subject());
//            System.out.println(MailsData[i].get_mainbody());
//            System.out.println("========================");
//        }
        //System.out.println("mails came");

//        PS.close();
//	objectInputStream.close();
        //SOCK.close();
        System.out.println("CLIENT:done mail catalogue");
        return MailsData;
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method delet_mail sent the username and the id of the mail the user
     * wants to delete and after the received result it returns a boolean
     * 
     * @param user the username of the client user
     * @param id the id number of the email user wants to delete
     * @param SOCK the socket of the client
     * @return true if it could be deleted or false if not
     * @throws Exception if something goes wrong with the streams
     * 
     */
    boolean delet_mail(String user, String id, Socket SOCK) throws Exception {
//System.out.println("Server is not up");
        //Socket SOCK = new Socket("localhost", 44444);
        PrintStream PS = new PrintStream(SOCK.getOutputStream());
        //stelnw ston server to onoma tou user poy thelei ta mails 
        PS.println(user);
        //System.out.println("user was sent");
        //stelnw ston server to id tou mail poy thelei na svistei 
        PrintStream PS2 = new PrintStream(SOCK.getOutputStream());
        PS2.println(id);
        //System.out.println("id was sent");

////        ObjectInputStream objectInputStream = new ObjectInputStream(SOCK.getInputStream());
////        Email[] MailsData = null;
////        MailsData = (Email[]) objectInputStream.readObject();
////        System.out.println("length is: " + MailsData.length);
////        for (int i = 0; i < MailsData.length; i++) {
////            System.out.println("=======Email " + i + " =====");
////            System.out.println(MailsData[i].get_isNew());
////            System.out.println(MailsData[i].get_sender());
////            System.out.println(MailsData[i].get_receiver());
////            System.out.println(MailsData[i].get_subject());
////            System.out.println(MailsData[i].get_mainbody());
////            System.out.println("========================");
////        }
////        System.out.println("mails came");
        InputStreamReader IR = new InputStreamReader(SOCK.getInputStream());
        BufferedReader BR = new BufferedReader(IR);
        String done = BR.readLine();

//        PS.close();
//        PS2.close();
//        IR.close();
//	BR.close();
        //SOCK.close();
        if (done.equals("true")) {
            System.out.println("CLIENT:done delete true");
            return true;
        } else {
            System.out.println("CLIENT:done delete false");
            return false;
        }
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method set_read sent the username and the id of the mail was read after
     * the received result it returns a boolean
     * 
     * @param user username of the client's user
     * @param id id number of the email which will be read
     * @param SOCK the socket of the client
     * @return true if the change of the isNew value was succesful or false if
     * not
     * @throws Exception if something goes wrong with the streams
     * 
     */
    boolean set_read(String user, String id, Socket SOCK) throws Exception {
//System.out.println("Server is not up");
        //Socket SOCK = new Socket("localhost", 22);
        PrintStream PS = new PrintStream(SOCK.getOutputStream());
        //stelnw ston server to onoma tou user poy thelei ta mails 
        PS.println(user);
        //System.out.println("user was sent");
        //stelnw ston server to id tou mail poy thelei na svistei 
        PrintStream PS2 = new PrintStream(SOCK.getOutputStream());
        PS2.println(id);
        //System.out.println("id was sent");

        InputStreamReader IR = new InputStreamReader(SOCK.getInputStream());
        BufferedReader BR = new BufferedReader(IR);
        String done = BR.readLine();

//        PS.close();
//        PS2.close();
//        IR.close();
//	BR.close();
        //SOCK.close();
        if (done.equals("true")) {
            System.out.println("CLIENT:done set as READ true");
            return true;
        } else {
            System.out.println("CLIENT:done set as READ false");
            return false;
        }
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method send_mail sent the Email object to the server and if it was sent
     * after the received result it returns a boolean
     * 
     * @param NewEmail Email object which will be created
     * @param SOCK the socket of the client
     * @throws Exception if something goes wrong with the streams
     *
     */
    void send_mail(Email NewEmail, Socket SOCK) throws Exception {
//System.out.println("Server is not up");
        //Socket SOCK = new Socket("localhost", 222);

        //stelnw ston server to mail 
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(SOCK.getOutputStream());
        objectOutputStream.writeObject(NewEmail);

        InputStreamReader IR = new InputStreamReader(SOCK.getInputStream());
        BufferedReader BR = new BufferedReader(IR);
        String done = BR.readLine();
        if (done.equals("true")) {
            System.out.println("CLIENT:done mail sent");
        } else {
            System.out.println("CLIENT:done mail false");
        }

//	objectOutputStream.close();
        //SOCK.close();
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method send_orders sent the order string to the server and if it was
     * sent after the received result it returns a boolean
     * 
     * @param order string which contain the order that the user is expecting
     * the client to do
     * @param SOCK the socket of the client
     * @return true if the order was sent false if not
     * @throws Exception if something goes wrong with the streams
     * 
     */
    boolean send_orders(String order, Socket SOCK) throws Exception {
//System.out.println("Server is not up");
        //Socket SOCK = new Socket("localhost", 44);
        PrintStream PS = new PrintStream(SOCK.getOutputStream());
        PS.println(order);
        //System.out.println("i send it");
        InputStreamReader IR = new InputStreamReader(SOCK.getInputStream());
        BufferedReader BR = new BufferedReader(IR);
        String MESSAGE = BR.readLine();
        //System.out.println(MESSAGE);
        if (MESSAGE.equals("true")) {
            System.out.println("CLIENT:done SEND ORDERS true");
            return true;
        } else {
            System.out.println("CLIENT:done SEND ORDERS false");
            return false;
        }
    }
//——————————————————————————————————————————————————————————————————————————————————————    

    /**
     * This method logout sent the username string witch will be deleted to the
     * server
     * 
     * @param user string with the username of the client's user
     * @param SOCK the socket of the client
     * @throws IOException if something goes wrong with the streams
     * 
     */
    void logout(String user, Socket SOCK) throws IOException {
        PrintStream PS = new PrintStream(SOCK.getOutputStream());
        PS.println(user);
    }
//——————————————————————————————————————————————————————————————————————————————————————
}
//——————————————————————————————————————————————————————————————————————————————————————
//——————————————————————————————————————————————————————————————————————————————————————
//——————————————————————————————————————————————————————————————————————————————————————
//——————————————————————————————————————————————————————————————————————————————————————
//——————————————————————————————————————————————————————————————————————————————————————
//——————————————————————————————————————————————————————————————————————————————————————
//    void run(Socket SOCK) throws Exception {
//
//        //Socket SOCK = new Socket("localhost", 444);
//        PrintStream PS = new PrintStream(SOCK.getOutputStream());
//        PS.println("Hello to SERVER from CLIENT.");
//
//        InputStreamReader IR = new InputStreamReader(SOCK.getInputStream());
//        BufferedReader BR = new BufferedReader(IR);
//
//        String MESSAGE = BR.readLine();
//        System.out.println("CLIENT:done run");
//    }
//——————————————————————————————————————————————————————————————————————————————————————    
//    public static void main(String[] args) throws Exception {
////        Tests
//        MY_socket_CLIENT CLIENT = new MY_socket_CLIENT();
//        Socket SOCK = new Socket("localhost", PORT);
//        CLIENT.run(SOCK);
//        CLIENT.send_orders("login", SOCK);
//        CLIENT.login("qwe", "qwe", SOCK);
//        Account asd =new Account("cvb","cvb","cvb","cvb","21/2/22","bsisk@ds.com");
//        CLIENT.register(asd,SOCK);
//        Email[] data = CLIENT.want_mail_catalogue("qwe",SOCK);
//        System.out.println("done");
//        CLIENT.delet_mail("qwe", "2");//pontikes copy-copy
//        Email[] data = CLIENT.want_mail_catalogue("qwe");
//    }
