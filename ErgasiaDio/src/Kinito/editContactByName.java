package Kinito;

import java.util.Scanner;

public class editContactByName {
    Scanner input = new Scanner(System.in);
    AddContact contact = new AddContact();

    public boolean checkInput(int choice)
    {
        if(choice>7 || choice<1){
            System.out.print("You must select a number between 1-6: ");
            return false;
        }
        return true;
    }
    public void editContact(Contacts object) {
        int choice;
        String users="";
        String again;

        do {

            System.out.println("---------------------------");
            System.out.println("1. First Name: " + object.firstName);
            System.out.println("2. Last Name: " + object.lastName);
            System.out.println("3. Phone number: " + object.phoneNumer);
            System.out.println("4. Second phone number: " + object.secondPhoneNumber);
            System.out.println("5. Address: " + object.completeAddress);
            System.out.println("6. Email: " + object.email);
            System.out.println("---------------------------");

            System.out.print("Enter the number of the Detail that you want to edit: ");
            do {
                choice = input.nextInt();
            } while (!checkInput(choice));
            switch (choice) {
                case 1:

                    do {
                        System.out.print("Enter the new name :");
                        users = input.next();
                    }while(!contact.checkName(users));
                    object.firstName=users;
                    break;
                case 2:
                    System.out.print("Enter the new Last Name: ");
                    object.lastName = input.next();
                    break;
                case 3:
                    System.out.print("Enter the new Phone Number: ");
                    do {
                        object.phoneNumer = input.next();
                    } while (!contact.isNumeric(object.phoneNumer) || !contact.checkNumber(object.phoneNumer));
                    break;
                case 4:
                    System.out.print("Enter the new Second phone number: ");
                    do {
                        object.secondPhoneNumber = input.next();
                    }
                    while (!contact.isNumeric(object.secondPhoneNumber));
                    break;
                case 5:
                    System.out.print("Enter the new Address: ");
                    object.completeAddress = input.next();
                    break;
                case 6:
                    System.out.print("Enter the new Email: ");
                    do {
                        object.email = input.next();
                    } while (!contact.checkEmail(object.email));
                    break;
            }
            System.out.print("Press y if you want to edit another detail otherwise press another key: ");
            again=input.next();
        }while (again.equalsIgnoreCase("Y"));
    }

    public void editContactMain() {
        int flag=0;//Variable that shows if the name has been found
        String usersName;
        System.out.println("---------------------------");
        System.out.println("| |        EDIT         | |");
        System.out.println("---------------------------");
            System.out.print("Please enter the name of the contact that you want to edit: ");
            usersName = input.next();
            for (int i =0;i< contact.contactlist.size(); i++) {
                if (usersName.equalsIgnoreCase(contact.contactlist.get(i).firstName)) {
                    flag+=1;
                    editContact(contact.contactlist.get(i));
                    break;
                }
            }
        if (flag==0){
            System.out.println("There isn't Contact with this name.");
        }
        contact.serializeList(contact.contactlist);//Load in file new changes
    }
}