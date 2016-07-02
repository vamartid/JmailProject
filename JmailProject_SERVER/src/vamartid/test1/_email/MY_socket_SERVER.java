package vamartid.test1._email;
//——————————————————————————————————————————————————————————————————————————————————————
/*
 * License Copyright © 2000 Vasileios Martidis vamartid@yandex.com 
 * This work is free. You can redistribute it and/or modify it under
 *  the terms of the Do What The Fuck You Want To Public License,
 *  Version 2, as published by Sam Hocevar.
 *  See http://www.wtfpl.net/ for more details.
 */
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.ArrayList;
//——————————————————————————————————————————————————————————————————————————————————————

/**
 * This class MY_socket_SERVER runs the server Creates a threat for each server
 * singed in the server each thread have a method ServerActionsHandler running
 *
 * @author basilism
 */
public class MY_socket_SERVER {

    private JmailHelp JmailHELPER = new JmailHelp();
    static int PORT = 6666;
//—————— M A I N ——————————————————————————————————————————————————————————————————————————

    public static void main(int port) throws Exception {
        PORT = port;
        //System.out.println("MY_socket_SERVER " + PORT);
        MY_socket_SERVER SERVER = new MY_socket_SERVER();
        SERVER.JmailHELPER.resetONN();
        ServerSocket SRVSOCK = new ServerSocket(PORT);

        while (true) {
            Socket SOCK = SRVSOCK.accept();
            SocketStatus a = new SocketStatus(SOCK, false);
            new Thread() {
                public void run() {
                    try {
                        SERVER.ServerActionsHandler(SERVER, SRVSOCK, SOCK, a);
                    } catch (Exception ex) {
                        Logger.getLogger(MY_socket_SERVER.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method accept_login takes the Server's and the Client's socket receive
     * an Account object(username and password fields) and checks and by using a
     * JmailHelp object check's if the login that came was valid or not
     * 
     * @param SRVSOCK is the server socket
     * @param SOCK is the client socket
     * @return true if the login was sent and was successful or return false if
     * it was not successful
     * @throws Exception if there was a stream problem
     * 
     */
    public boolean accept_login(ServerSocket SRVSOCK, Socket SOCK) throws Exception {
//        ServerSocket SRVSOCK = new ServerSocket(44);
//        Socket SOCK = SRVSOCK.accept();
        //System.out.println("I am in the accept_login");
        InputStreamReader IR = new InputStreamReader(SOCK.getInputStream());
        BufferedReader BR = new BufferedReader(IR);
        //System.out.println(BR.readLine());
        //System.out.println("i need to save the message");
        String MESSAGE = BR.readLine();
        //System.out.println(MESSAGE);

        if (MESSAGE != null) {

            PrintStream PS = new PrintStream(SOCK.getOutputStream());

            PS.println("MESSAGE receivedl");

        }

        InputStreamReader IR2 = new InputStreamReader(SOCK.getInputStream());
        BufferedReader BR2 = new BufferedReader(IR2);

        String MESSAGE2 = BR2.readLine();
        //System.out.println(MESSAGE2);

        if (MESSAGE2 != null) {

            PrintStream PS2 = new PrintStream(SOCK.getOutputStream());
            int a = JmailHELPER.login_compare(MESSAGE, MESSAGE2);
            if (a == 1) {
                //yes
                PS2.println("1");
                System.out.println("SERVER     : Done loged in for:" + MESSAGE + " " + SOCK);
                return true;
            } else if (a == 2) {
                //not
                PS2.println("2");
                System.out.println("SERVER     : Login attempt in an already logged in account" + MESSAGE + " " + SOCK);
                //sleep
                return false;
            } else {
                //not
                PS2.println("0");
                System.out.println("SERVER     : Ivalid login attempt" + MESSAGE + " " + SOCK);
                //sleep
                return false;
            }

        }
        return false;
        //IR.close();
        //IR2.close();
        //BR.close();
        //BR2.close();
        //SOCK.close();
        //SRVSOCK.close();
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method accept_register takes the Server's and the Client's socket and by
     * using a JmailHelp object it writes in the file with the accounts the new
     * account if there wasn't one with the same name
     * 
     * @param SRVSOCK is the server socket
     * @param SOCK is the client socket
     * @throws Exception Exception if there was a stream problem
     * 
     */
    public void accept_register(ServerSocket SRVSOCK, Socket SOCK) throws Exception {
//        ServerSocket SRVSOCK = new ServerSocket(444);
//        Socket SOCK = SRVSOCK.accept();
        //System.out.println(SOCK + "accepted");
        ObjectInputStream objectInputStream = new ObjectInputStream(SOCK.getInputStream());
        //ObjectOutputStream objectOutputStream = new ObjectOutputStream(SOCK.getOutputStream());
        Account NewUser = (Account) objectInputStream.readObject();
        //System.out.println(NewUser.getUsername() + "111111");

        if (NewUser.getUsername() != null) {
            PrintStream PS2 = new PrintStream(SOCK.getOutputStream());
////         if (JmailHELPER.register(NewUser.getUsername(),
////                 NewUser.getPassword(),NewUser.getFirstName(),
////                NewUser.getLastName(), NewUser.getBirthday(),
////                NewUser.getCurrentAddress())) {
            InputStreamReader IR2 = new InputStreamReader(SOCK.getInputStream());
            BufferedReader BR2 = new BufferedReader(IR2);
            //String MESSAGE2 = BR2.readLine();
            if (JmailHELPER.checkUsername(NewUser.getUsername())) {
                //yes to onoma yparxei idi ara
                //dinw false oti den to ftiaxnw
                System.out.println("SERVER     : Invalind register attemt" + SOCK);
                PS2.println("false");

            } else {
                //not to onoma den yparxei ara mporw na to dimiourgisw
                PS2.println("true");
                System.out.println("SERVER     : Done register" + SOCK);
                JmailHELPER.register(NewUser.getUsername(),
                        NewUser.getPassword(), NewUser.getFirstName(),
                        NewUser.getLastName(), NewUser.getBirthday(),
                        NewUser.getCurrentAddress());
                //sleep

            }
//            PS2.close();
//            IR2.close();
//            BR2.close();
            //SOCK.close();
            //SRVSOCK.close();

        }
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method send_mail_catalogue takes the Server's and the Client's socket
     * and by using a JmailHelp object it finds the mails of the user (txt files
     * in certain folder) make them Email objects place them in a array and sent
     * the Object array through the stream
     * 
     * @param SRVSOCK is the server socket
     * @param SOCK is the client socket
     * @throws Exception if there was a stream problem
     * 
     */
    public void send_mail_catalogue(ServerSocket SRVSOCK, Socket SOCK) throws Exception {
//        ServerSocket SRVSOCK = new ServerSocket(4444);
//        Socket SOCK = SRVSOCK.accept();
        //System.out.println(SOCK + "accepted");
        //dexomai to onoma tou user
        PrintStream PS = new PrintStream(SOCK.getOutputStream());
        InputStreamReader IR = new InputStreamReader(SOCK.getInputStream());
        BufferedReader BR = new BufferedReader(IR);
        String user = BR.readLine();
        //System.out.println(SOCK + " 1 asked for email-list");
        //kalw to na vrw ta emails tou
        File[] s = JmailHELPER.find_the_mails(JmailHELPER.userMailsDir + "/" + user);

        Email[] all = new Email[s.length];

        for (int i = 0; i < s.length; i++) {
            all[i] = JmailHELPER.read_mail(s[i], false);
        }
//        for (int i = 0; i < all.length; i++) {
//            System.out.println("=======Email "+i+" =====");
//            System.out.println(all[i].get_isNew());
//            System.out.println(all[i].get_sender());
//            System.out.println(all[i].get_receiver());
//            System.out.println(all[i].get_subject());
//            System.out.println(all[i].get_mainbody());
//            System.out.println("========================");
//        }
        //ObjectInputStream objectInputStream = new ObjectInputStream(SOCK.getInputStream());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(SOCK.getOutputStream());
        objectOutputStream.writeObject(all);
        System.out.println("SERVER     : Done send email catalogue" + SOCK);
//        PS.close();
//        IR.close();
//        BR.close();
//        objectOutputStream.close();
        //SOCK.close();
        //SRVSOCK.close();
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method delete_mail takes the Server's and the Client's socket, receives
     * a number finds the email which is declared by that number and by using a
     * JmailHelp object it deletes the email's file
     * 
     * @param SRVSOCK is the server socket
     * @param SOCK is the client socket
     * @throws Exception if there was a stream problem
     * 
     */
    public void delete_mail(ServerSocket SRVSOCK, Socket SOCK) throws Exception {
//        ServerSocket SRVSOCK = new ServerSocket(44444);
//        Socket SOCK = SRVSOCK.accept();

        //System.out.println(SOCK + "accepted");
        //dexomai to onoma tou user
        InputStreamReader IR = new InputStreamReader(SOCK.getInputStream());
        BufferedReader BR = new BufferedReader(IR);
        String user = BR.readLine();
        //System.out.println(SOCK + "user received and asked for email-list: " + user);
        //dexomai to id tou mail
        String id = BR.readLine();
        //System.out.println(SOCK + "asked for email with id: " + Integer.parseInt(id) + " to be deleted");

        //kalw to na vrw ta emails tou
        File[] s = JmailHELPER.find_the_mails(JmailHELPER.userMailsDir + "/" + user);
        //System.out.println("length before delete is: "+s.length);
        s[(Integer.parseInt(id))].delete();

        PrintStream PS = new PrintStream(SOCK.getOutputStream());
        PS.println("true");
        System.out.println("SERVER     : Done delete mail" + SOCK);
////        //to lenght alaxe prepei na xana ftiaxw ton pinaka File[] s
////        s = null;
////        s = JmailHELPER.find_the_mails("_javaMailData/userMails/" + user);
////        //System.out.println("length before delete is: "+s.length);
////        Email[] all = new Email[s.length];
////
////        for (int i = 0; i < s.length; i++) {
////            all[i] = JmailHELPER.read_mail(s[i], false);
////        }
//////        for (int i = 0; i < all.length; i++) {
//////            System.out.println("=======Email "+i+" =====");
//////            System.out.println(all[i].get_isNew());
//////            System.out.println(all[i].get_sender());
//////            System.out.println(all[i].get_receiver());
//////            System.out.println(all[i].get_subject());
//////            System.out.println(all[i].get_mainbody());
//////            System.out.println("========================");
//////        }
////        //ObjectInputStream objectInputStream = new ObjectInputStream(SOCK.getInputStream());
////        ObjectOutputStream objectOutputStream = new ObjectOutputStream(SOCK.getOutputStream());
////        objectOutputStream.writeObject(all);
////        System.out.println("emails data sended to" + SOCK);
//        PS.close();
//        IR.close();
//        BR.close();
        //SOCK.close();
        //SRVSOCK.close();
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method set_read_mail takes the Server's and the Client's socket,
     * receives a number finds the email which is declared by that number and is
     * open in a client and by using a JmailHelp object it changes it's isNew
     * field in the email's file
     * 
     * @param SRVSOCK is the server socket
     * @param SOCK is the client socket
     * @throws Exception if there was a stream problem
     * 
     */
    public void set_read_mail(ServerSocket SRVSOCK, Socket SOCK) throws Exception {
//        ServerSocket SRVSOCK = new ServerSocket(22);
//        Socket SOCK = SRVSOCK.accept();

        //System.out.println(SOCK + "accepted");
        //dexomai to onoma tou user
        InputStreamReader IR = new InputStreamReader(SOCK.getInputStream());
        BufferedReader BR = new BufferedReader(IR);
        String user = BR.readLine();
        //System.out.println(SOCK + " 1 user received and asked for email-list: " + user);
        //dexomai to id tou mail
        String id = BR.readLine();
        //System.out.println(SOCK + " 2 asked for email with id: " + Integer.parseInt(id) + " to be read");

        //kalw to na vrw ta emails tou
        File[] s = JmailHELPER.find_the_mails(JmailHELPER.userMailsDir + "/" + user);

        Email k = JmailHELPER.read_mail(s[(Integer.parseInt(id))], true);

        PrintStream PS = new PrintStream(SOCK.getOutputStream());
        PS.println("true");
        System.out.println("SERVER     : Done set " + Integer.parseInt(id) + "mail as read" + SOCK);

//        PS.close();
//        IR.close();
//        BR.close();
        //SOCK.close();
        //SRVSOCK.close();
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method send_mail takes the Server's and the Client's socket, receives an
     * email object and by using a JmailHelp object it saves it to the
     * receiver's folder
     * 
     * @param SRVSOCK is the server socket
     * @param SOCK is the client socket
     * @throws Exception if there was a stream problem
     * 
     */
    public void send_mail(ServerSocket SRVSOCK, Socket SOCK) throws Exception {
//        ServerSocket SRVSOCK = new ServerSocket(222);
//        Socket SOCK = SRVSOCK.accept();
        //System.out.println(SOCK + "accepted");
        ObjectInputStream objectInputStream = new ObjectInputStream(SOCK.getInputStream());
        //ObjectOutputStream objectOutputStream = new ObjectOutputStream(SOCK.getOutputStream());
        Email NewEmail = (Email) objectInputStream.readObject();
        PrintStream PS = new PrintStream(SOCK.getOutputStream());
        if (JmailHELPER.CreateTheMail(NewEmail)) {
            System.out.println("SERVER     : Done send mail true" + SOCK);
            PS.println("true");
        } else {
            System.out.println("SERVER     : Done send mail false" + SOCK);
            PS.println("false");
        }

//        objectInputStream.close();
        //SOCK.close();
        //SRVSOCK.close();
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method get_orders takes the Server's and the Client's socket, receives a
     * string called order object and by using a JmailHelp object it saves it to
     * the receiver's folder
     * 
     * @param SRVSOCK is the server socket
     * @param SOCK is the client socket
     * @return a string called Message which represent the order of the client
     * which value is
     * "logout","login""new","read","delete","refresh","register","cancel","exit","login"
     * @throws Exception if there was a stream problem
     * 
     */
    String get_orders(ServerSocket SRVSOCK, Socket SOCK) throws Exception {
//        ServerSocket SRVSOCK = new ServerSocket(44);
//        Socket SOCK = SRVSOCK.accept();
        //System.out.println("I am in the get orders");
        InputStreamReader IR = new InputStreamReader(SOCK.getInputStream());
        BufferedReader BR = new BufferedReader(IR);
        //System.out.println(BR.readLine());
        //System.out.println("i need to save the message");
        String MESSAGE = BR.readLine();
        //System.out.println(MESSAGE);
        if (MESSAGE != null) {
            PrintStream PS2 = new PrintStream(SOCK.getOutputStream());
            if (MESSAGE.equals("logout")
                    || MESSAGE.equals("login")
                    || MESSAGE.equals("new")
                    || MESSAGE.equals("read")
                    || MESSAGE.equals("delete")
                    || MESSAGE.equals("refresh")
                    || MESSAGE.equals("register")
                    || MESSAGE.equals("cancel")
                    || MESSAGE.equals("exit")
                    || MESSAGE.equals("login")) {
                //yes
                PS2.println("true");
                System.out.println("SERVER     : Orders came" + SOCK);
                return MESSAGE;
            } else {
                //not
                PS2.println("false");
                System.out.println("SERVER     : Orders did not received" + SOCK);
                //sleep

            }

        }
        return "cancel";
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method ServerActionsHandler takes the Server's and the Client's
     * socket,this is the Server's thread manager This method checks if the
     * client ( Socket Status a ) is logged in or not and gives him the choices
     * for each status and for each his order respectively psevdocode while the
     * user has not exit do if loged in he can refresh/delete/read/new/logout if
     * not he can login/register/exit
     * 
     * @param SERVER is MY_socket_SERVER object of this class
     * @param SRVSOCK is the server socket
     * @param SOCK is the client socket
     * @param a is a SocketStatus object(declares if current thread client is
     * logged in)
     * @throws Exception if there was a stream problem
     * 
     */
    public void ServerActionsHandler(MY_socket_SERVER SERVER, ServerSocket SRVSOCK, Socket SOCK, SocketStatus a) throws Exception {
        boolean i = true;
        while (i) {//trexei o server gia ton sigekrimeno client
            String action = SERVER.get_orders(SRVSOCK, SOCK);
            //zitaw string pou dilwnei ti kinisi na anamenei o server
            if (!(a.getOnline()))//he is not logged in
            {
                System.out.println("SERVER MAIN: I am in the IF-NOT-LOGIN");
                if (action.equals("login")) {//done
                    if (SERVER.accept_login(SRVSOCK, SOCK)) {
                        a.setOnline(true);
                    }
                } else if (action.equals("register")) {//done
                    SERVER.accept_register(SRVSOCK, SOCK);
                } else if (action.equals("exit")) {
                    a = null;
                    i = false;
                    SOCK.close();
                } else {
                    System.err.println("Something went wrong in the non logged in users if");
                }
            } else if (a.getOnline())//he is logged in
            {
                System.out.println("SERVER MAIN: I am in the IF-LOGIN");
                if (action.equals("refresh")) {//done
                    SERVER.send_mail_catalogue(SRVSOCK, SOCK);
                } else if (action.equals("delete")) {//done
                    SERVER.delete_mail(SRVSOCK, SOCK);
                } else if (action.equals("read")) {//done
                    SERVER.set_read_mail(SRVSOCK, SOCK);
                } else if (action.equals("new")) {//done
                    SERVER.send_mail(SRVSOCK, SOCK);
                } else if (action.equals("logout")) {
                    SERVER.logout(SRVSOCK, SOCK);
                    a.setOnline(false);
                    //akirose eisodo stin if twn sindedemenwn kai pane stin panw if
                } else {
                    //OnlineUsers.remove(OnlineUsers.indexOf(a));
                    System.err.println("Something went wrong in the logged in users if");
                }
            }
        }
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method logout takes the Server's and the Client's socket sets the user
     * as logged out in status
     * 
     * @param SRVSOCK is the server socket
     * @param SOCK is the client socket
     * @throws Exception if there was a stream problem
     * 
     */
    public void logout(ServerSocket SRVSOCK, Socket SOCK) throws Exception {
//        ServerSocket SRVSOCK = new ServerSocket(44);
//        Socket SOCK = SRVSOCK.accept();
        //System.out.println("I am in the get orders");
        InputStreamReader IR = new InputStreamReader(SOCK.getInputStream());
        BufferedReader BR = new BufferedReader(IR);
        //System.out.println(BR.readLine());
        //System.out.println("i need to save the message");
        String MESSAGE = BR.readLine();
        //System.out.println(MESSAGE);
        JmailHELPER.logout(MESSAGE);
    }
//——————————————————————————————————————————————————————————————————————————————————————
}
//——————————————————————————————————————————————————————————————————————————————————————
//——————————————————————————————————————————————————————————————————————————————————————
//——————————————————————————————————————————————————————————————————————————————————————
//——————————————————————————————————————————————————————————————————————————————————————
//——————————————————————————————————————————————————————————————————————————————————————
//——————————————————————————————————————————————————————————————————————————————————————
//    public void run(ServerSocket SRVSOCK, Socket SOCK) throws Exception {
//        //ServerSocket SRVSOCK = new ServerSocket(444);
//        //Socket SOCK = SRVSOCK.accept();
//
//        InputStreamReader IR = new InputStreamReader(SOCK.getInputStream());
//        BufferedReader BR = new BufferedReader(IR);
//
//        String MESSAGE = BR.readLine();
//        System.out.println("SERVER     : Done run");
//
//        if (MESSAGE != null) {
//
//            PrintStream PS = new PrintStream(SOCK.getOutputStream());
//
//            PS.println("MESSAGE receivedl");
//
//        }
//    }
//——————————————————————————————————————————————————————————————————————————————————————
//old main with no threads
//    public static void main(String[] args) throws Exception {
//
//        MY_socket_SERVER SERVER = new MY_socket_SERVER();
//        SERVER.JmailHELPER.resetONN();
//        ServerSocket SRVSOCK = new ServerSocket(PORT);
//        //ArrayList<SocketStatus> OnlineUsers = new ArrayList<SocketStatus>();
//        
//        Socket SOCK = SRVSOCK.accept();
//        //new ServerThread(SOCK).start();
//        SocketStatus a = new SocketStatus(SOCK, false);
//        //OnlineUsers.add(a);
//        String action = "";
//        SERVER.ServerActionsHandler(SERVER,SRVSOCK,SOCK,a);
//    }
//——————————————————————————————————————————————————————————————————————————————————————
