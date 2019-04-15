package Kinito;

import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.util.Iterator;
import java.util.Scanner;
import java.io.*;


public class deleteByName {
    AddContact contact=new AddContact();
    Scanner input = new Scanner(System.in);


    public void deleteContactMain() {
        int flag=0;//Variable that shows if the name has been found
        String usersName;

        System.out.println("---------------------------");
        System.out.println("| |       DELETE        | |");
        System.out.println("---------------------------");

        do {
            Iterator<Contacts> itr= contact.contactlist.iterator();

            System.out.print("Please enter the name of the contact that you want to delete: ");
            usersName = input.next();
            while (itr.hasNext()){
                Contacts cont=(Contacts)itr.next();
                if(cont.firstName.equalsIgnoreCase(usersName)){
                    flag+=1;
                    itr.remove();
                    System.out.println("You have deleted successfully the Contact;");
                }

            }

            if (flag == 0) {
                System.out.println("There isn't Contact with this name.");
            }
    }while(flag==0);
        contact.serializeList(contact.contactlist);//Load in file new changes
    }
}
