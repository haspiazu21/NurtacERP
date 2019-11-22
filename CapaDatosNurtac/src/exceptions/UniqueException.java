/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Ellet
 */
public class UniqueException extends Exception {

    public UniqueException(String message, Throwable cause) {
        super(message, cause);
    }

    public UniqueException(String message) {
        super(message);
    }

}
