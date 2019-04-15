package Kinito;


import java.util.*;

public class viewContact {
    AddContact obj=new AddContact();

    public boolean check(int num){
        num+=1;
        if(num>obj.contactlist.size() || num<1){
            System.out.print("You can select between 1-"+obj.contactlist.size()+".\nPlease choose again: ");
            return true;
        }
        return false;
    }

    public void viewContactMain(){
        Scanner input = new Scanner(System.in);
        int choice;
        String seeOther="";

        System.out.println("---------------------------");
        System.out.println("| |       CONTACTS      | |");
        System.out.print("---------------------------");


        if(obj.contactlist.size()!=0) {
            do {
                for (int i = 0; i < obj.contactlist.size(); i++) {
                    System.out.print("\n" + (i + 1) + ". " + obj.contactlist.get(i).firstName);


                }
                System.out.print("\nPlease select the number of the contact you want to check: ");
                do {
                    choice = input.nextInt() - 1;
                }while(check(choice));
                System.out.println("---------------------------");
                System.out.println("First Name: " + obj.contactlist.get(choice).firstName);
                System.out.println("Last Name: " + obj.contactlist.get(choice).lastName);
                System.out.println("Phone number: " + obj.contactlist.get(choice).phoneNumer);
                System.out.println("Second phone number: " + obj.contactlist.get(choice).secondPhoneNumber);
                System.out.println("Address: " + obj.contactlist.get(choice).completeAddress);
                System.out.println("Email: " + obj.contactlist.get(choice).email);
                System.out.println("---------------------------");
                System.out.print("Press Y if you  want to check another Contact or press another key to quit: ");
                seeOther = input.next();
            } while (seeOther.equalsIgnoreCase("y"));
        }
        else{
            System.out.println("\nThe contact list is empty :(");
        }

    }
}
