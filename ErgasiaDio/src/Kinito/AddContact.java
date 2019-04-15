package Kinito;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class AddContact implements Serializable {


    public static ArrayList<Contacts> contactlist = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public boolean checkName(String Name){//It checks if there is another contact with the same name.

        Iterator<Contacts> itr = contactlist.iterator();

        while (itr.hasNext()){
            Contacts cont=(Contacts)itr.next();
            if(cont.firstName.equalsIgnoreCase(Name)){
                System.out.print("There is another one contact with the same name. \nPress Y to replace it or another key to continue: ");
                String sure=input.next();
                if (sure.equalsIgnoreCase("y")){
                    itr.remove();
                    return true;
                }
                else{
                    System.out.print("Enter again the name: ");
                    return false;
                    }
                }
            }
        return true;

    }



    public static boolean checkEmail(String email)//It checks if the email has valid type
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email.length()>0) {

            boolean state= false;
        }
        boolean state= pat.matcher(email).matches();
        if(!state){
            System.out.print("Email "+email+" is not valid.\nPlease enter again your email: ");
        }
        return state;
    }

    public boolean isNumeric(String strNum) {//Checks if the number has invalid string characters

        try{
            Double.parseDouble(strNum);
            return true;
        }
        catch (NumberFormatException e)
        {
            System.out.print(strNum + " is not a valid phone number. \nEnter again :");
            return false;
     }
  }

  public boolean checkNumber(String number){//It check if there is another contact wih the same number
        for(Contacts cont:contactlist){
            if (cont.phoneNumer.equals(number)){
                System.out.println("The contact with name "+cont.firstName+" has this number.");
                return false;
            }
        }
        return true;
  }


  public ArrayList unserializeList(ArrayList list){
      try {
          FileInputStream fileIn = new FileInputStream("myObjects.txt");
          ObjectInputStream in = new ObjectInputStream(fileIn);
          list = (ArrayList<Contacts>) in.readObject();
          in.close();
          fileIn.close();
      } catch (IOException i) {
          i.printStackTrace();

      } catch (ClassNotFoundException c) {
          c.printStackTrace();

      }
      return list;
  }


  public void serializeList(ArrayList list){
      try {
          FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
          ObjectOutputStream o = new ObjectOutputStream(f);
          // Write objects to file
          o.writeObject(list);
          o.close();
          f.close();

      } catch (IOException i) {
          i.printStackTrace();
      }


  }


    public void addContactMain(){
        Contacts contact=new Contacts();


        System.out.println("---------------------------");
        System.out.println("Enter the following information:");
        System.out.print("Name: ");
        do {
            contact.firstName = input.next();
        }while(!checkName(contact.firstName));
        System.out.print("Last Name: ");
        contact.lastName=input.next();
        System.out.print("Phone number: ");
        do {

            contact.phoneNumer = input.next();
        }while (!isNumeric(contact.phoneNumer) || !checkNumber(contact.phoneNumer));
        System.out.print("Address: ");
        contact.completeAddress=input.next();
        System.out.print("Email: ");
        do {
            contact.email = input.next();
        }while (!checkEmail(contact.email));
        System.out.print("Second phone number: ");
        do {
            contact.secondPhoneNumber = input.next();
        }while (!isNumeric(contact.secondPhoneNumber));
        System.out.println("You have added successfully new Contact!");
        contactlist.add(contact);



        serializeList(contactlist);

    }
}
