package Kinito;

import java.util.Scanner;



public class Main {

    public static boolean checkInput(int choice){
        if(choice>9||choice<1){
            System.out.print("You must select a number between 1-9: ");
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        AddContact contact = new AddContact();
        viewContact view=new viewContact();
        searchByName searchName=new searchByName();
        serachByPhoneNumber searchNumber=new serachByPhoneNumber();
        editContactByName edit=new editContactByName();
        deleteByName delete=new deleteByName();
        Calculator calculator=new Calculator();
        RandomCup game=new RandomCup();
        Exit exit=new Exit();

        Scanner input = new Scanner(System.in);
        String chooseAgain="";
        contact.contactlist=contact.unserializeList(contact.contactlist);//I load to contact list the previous contacts
        int numSelect=0;

        System.out.println("An app from Dennis Studios. \nPlease select a number between 1-9.");
        do{
        System.out.println("---------------------------");
        System.out.println("1. View Contacts");
        System.out.println("2. Add new Contact");
        System.out.println("3. Search Contact by Name");
        System.out.println("4. Search Contact by Number ");
        System.out.println("5. Edit Contact by Name");
        System.out.println("6. Delete Contact by Name");
        System.out.println("7. Calculator");
        System.out.println("8. Random Cup Game");
        System.out.println("9. Exit");
        System.out.println("---------------------------");
        System.out.print("Choose: ");


               do {
                   numSelect = input.nextInt();
               }while (!checkInput(numSelect));
               switch (numSelect) {
                   case 1:

                       view.viewContactMain();
                       break;

                   case 2:
                       contact.addContactMain();
                       break;

                   case 3:
                       searchName.searchByNameMain();
                       break;

                   case 4:
                       searchNumber.searchByPhoneNumberMain();
                       break;
                   case 5:
                        edit.editContactMain();
                        break;
                   case 6:
                       delete.deleteContactMain();
                        break;
                   case 7:
                        calculator.CalculatorMain();
                        break;
                   case 8:
                       game.RandomCupMain();
                       break;
                   case 9:
                       exit.exitMain();
                       break;
               }

               System.out.print("Press Y to go to menu or another key to exit: ");
                chooseAgain=input.next();
        }while(chooseAgain.equalsIgnoreCase("Y"));
        exit.exitMain();
    }

}
