package Kinito;

import java.util.Scanner;

public class searchByName {
    Scanner input = new Scanner(System.in);


    public void printContact(Contacts object){
        System.out.println("---------------------------");
        System.out.println("First Name: " + object.firstName);
        System.out.println("Last Name: " +object.lastName);
        System.out.println("Phone number: " +object.phoneNumer);
        System.out.println("Second phone number: " + object.secondPhoneNumber);
        System.out.println("Address: " + object.completeAddress);
        System.out.println("Email: " + object.email);
        System.out.println("---------------------------");    }

    public void searchByNameMain(){
        AddContact contact=new AddContact();
        String usersName;
        int flag=0;//Variable to check if there is the name in list

        System.out.println("---------------------------");
        System.out.println("| |       SEARCH        | |");
        System.out.println("---------------------------");
        System.out.print("Enter the Contact's name to search: ");
        usersName=input.next();
        for (int i=0;i<contact.contactlist.size();i++){
            if (usersName.equalsIgnoreCase(contact.contactlist.get(i).firstName)){
                flag+=1;
                    printContact(contact.contactlist.get(i));
                break;

            }
            }
        if (flag==0){
            System.out.println("There is not contact with name "+usersName+" :(");
        }

        }

    }

