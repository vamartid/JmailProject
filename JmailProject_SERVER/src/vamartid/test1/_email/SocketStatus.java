/*
 * License Copyright © 2000 Vasileios Martidis vamartid@yandex.com 
 * This work is free. You can redistribute it and/or modify it under
 *  the terms of the Do What The Fuck You Want To Public License,
 *  Version 2, as published by Sam Hocevar.
 *  See http://www.wtfpl.net/ for more details.
 */
package vamartid.test1._email;
//——————————————————————————————————————————————————————————————————————————————————————

import java.net.Socket;
//——————————————————————————————————————————————————————————————————————————————————————

/**
 * This class was made to know if a socket client which is
 * connected is loged-in or not The object of this class are used on the Loop in
 * the MY_socket_SERVER in the ServerActionsHandler method
 * 
 * @author basilism 
 */
public class SocketStatus {

    private Socket SOCK;
    private boolean online = false;
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method SocketStatus Default constructor for the SocketStatus object
     */
    SocketStatus() {
        this.SOCK = null;
        this.online = false;
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method SocketStatus is constructor of Socket status object gives a and b
     * to the fields
     * 
     * @param a
     * @param b
     * 
     */
    SocketStatus(Socket a, boolean b) {
        this.SOCK = a;
        this.online = b;
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method getOnline is a getter for the value online of the object
     * SocketStatus
     * 
     * @return the online boolean field of the Socket status object
     * 
     */
    boolean getOnline() {
        return this.online;
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method setOnline is a setter for the value online of the object
     * SocketStatus
     * 
     * @param a boolean we want to set to the value of online
     * 
     */
    void setOnline(boolean a) {
        this.online = a;
    }
//——————————————————————————————————————————————————————————————————————————————————————
}
//——————————————————————————————————————————————————————————————————————————————————————
//——————————————————————————————————————————————————————————————————————————————————————
//——————————————————————————————————————————————————————————————————————————————————————
//——————————————————————————————————————————————————————————————————————————————————————
//——————————————————————————————————————————————————————————————————————————————————————
