package org.academiadecodigo.wizards;

public class NotEnoughPermissionsException extends FileException{

    public NotEnoughPermissionsException(){
        super("You don't have permission");
    }

}
