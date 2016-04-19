/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vamartid.test1._email;
//——————————————————————————————————————————————————————————————————————————————————————

import java.io.Serializable;
//——————————————————————————————————————————————————————————————————————————————————————

/**
 * This class Email Each Email object has an isNew boolean witch declares if the mail
 * is new a sender string with the sender name a receiver string with the
 * receiver's name a subject string with the subject's content and a mainbody
 * with the main body's content These objects are used both by the server and
 * the client
 *
 * @author basilism
 */
public class Email implements Serializable {

    private static final long serialVersionUID = -2723363051271966964L;
    private boolean isNew;
    private String sender;
    private String receiver;
    private String subject;
    private String mainbody;
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This is a constructor of the Email objects and it just gives 
     * the given values to the object's values also declares the mail as not 
     * read(new)
     * 
     * @param a is the sender given
     * @param b is the receiver given
     * @param c is the subject given
     * @param d is the mainbody given
     * 
     */
    Email(String a, String b, String c, String d) {
        this.isNew = Boolean.TRUE;
        this.sender = a;
        this.receiver = b;
        this.subject = c;
        this.mainbody = d;
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This is a constructor of the Email objects and it just gives the
     * given values to the object's values
     * 
     * @param e is the isNew given
     * @param a is the sender given
     * @param b is the receiver given
     * @param c is the subject given
     * @param d is the mainbody given
     * 
     */
    Email(String a, String b, String c, String d, boolean e) {
        this.isNew = e;
        this.sender = a;
        this.receiver = b;
        this.subject = c;
        this.mainbody = d;
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     *This method get_isNew is getter for the Email's object isNew field
     * 
     * @return the Email's object isNew
     * 
     */
    public boolean get_isNew() {
        return isNew;
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method set_isNew is setter for the Email's object isNew field it change
     * it's value with the a value
     * 
     * @param a is the value that will be set to is New
     * 
     */
    public void set_isNew(boolean a) {
        this.isNew = a;
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method get_sender is getter for the Email's object sender field
     * 
     * @return the Email's object sender
     * 
     */
    public String get_sender() {
        return sender;
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method get_receiver is getter for the Email's object receiver field
     * 
     * @return the Email's object receiver
     * 
     */
    public String get_receiver() {
        return receiver;
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method get_subject is getter for the Email's object subject field
     * 
     * @return the Email's object subject
     * 
     */
    public String get_subject() {
        return subject;
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method get_mainbody is getter for the Email's object mainbody field
     * 
     * @return the Email's object mainbody
     * 
     */
    public String get_mainbody() {
        return mainbody;
    }
//——————————————————————————————————————————————————————————————————————————————————————    
}
//——————————————————————————————————————————————————————————————————————————————————————
//——————————————————————————————————————————————————————————————————————————————————————
//——————————————————————————————————————————————————————————————————————————————————————
//——————————————————————————————————————————————————————————————————————————————————————
//——————————————————————————————————————————————————————————————————————————————————————
