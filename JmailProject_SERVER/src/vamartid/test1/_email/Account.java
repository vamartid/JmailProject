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
 * This class Account Each Account object has a username a password a First name, a
 * Last name ,a birthday and a current Address Account objects are used both
 * from the client and the server
 *
 * @author basilism
 */
public class Account implements Serializable {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String birthday;
    private String currentAddress;
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method Account is the constructor of the Account objects and it just
     * gives the given values to the object's Strings
     * 
     * @param u is the username given
     * @param f is the password given
     * @param l is the first Name given
     * @param p is the last Name given
     * @param b is the birthday given
     * @param c is the current Address given
     *
     */
    public Account(String u, String f, String l, String p, String b, String c) {
        this.username = u;
        this.firstName = f;
        this.lastName = l;
        this.password = p;
        this.birthday = b;
        this.currentAddress = c;
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method Account is the second constructor of the Account objects and it
     * just gives the values of a Account object to the object's Strings
     * 
     * @param a is an Account object given
     * 
     */
    public Account(Account a) {
        this.username = a.username;
        this.firstName = a.firstName;
        this.lastName = a.lastName;
        this.password = a.password;
        this.birthday = a.birthday;
        this.currentAddress = a.currentAddress;
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method getUsername is getter for the Account's object username field
     * 
     * @return the Account's object username
     * 
     */
    public String getUsername() {
        return this.username;
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method getPassword is getter for the Account's object password field
     * 
     * @return the Account's object password
     * 
     */
    public String getPassword() {
        return this.password;
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method getFirstName is getter for the Account's object firstName field
     * 
     * @return the Account's object firstName
     * 
     */
    public String getFirstName() {
        return this.firstName;
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method getLastName is getter for the Account's object lastName field
     * 
     * @return the Account's object lastName
     * 
     */
    public String getLastName() {
        return this.lastName;
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method getBirthday is getter for the Account's object birthday field
     * 
     * @return the Account's object birthday
     * 
     */
    public String getBirthday() {
        return this.birthday;
    }
//——————————————————————————————————————————————————————————————————————————————————————

    /**
     * This method getCurrentAddress is getter for the Account's object
     * currentAddress field
     * 
     * @return the Account's object currentAddress
     * 
     */
    public String getCurrentAddress() {
        return this.currentAddress;
    }
//——————————————————————————————————————————————————————————————————————————————————————
}
//——————————————————————————————————————————————————————————————————————————————————————
//——————————————————————————————————————————————————————————————————————————————————————
//——————————————————————————————————————————————————————————————————————————————————————
//——————————————————————————————————————————————————————————————————————————————————————
//——————————————————————————————————————————————————————————————————————————————————————
