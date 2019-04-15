package Kinito;

import java.util.Scanner;

public class serachByPhoneNumber {
    Scanner input = new Scanner(System.in);

    public void searchByPhoneNumberMain(){
        AddContact contact=new AddContact();
        searchByName printVar=new searchByName();
        int flag=0;//It checks if there is  Contact with this number
        String usersNumber;

        System.out.println("---------------------------");
        System.out.println("| |       SEARCH        | |");
        System.out.println("---------------------------");
        System.out.print("Please enter the Phone Number: ");
        usersNumber=input.next();
        for(Contacts cont:contact.contactlist){
            if(cont.phoneNumer.equals(usersNumber)){
                flag+=1;
                printVar.printContact(cont);
                break;
            }
        }
        if (flag==0){
            System.out.println("There is not contact with number "+usersNumber+" :(");
        }
    }

}
