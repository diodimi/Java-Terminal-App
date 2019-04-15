package Kinito;

import java.io.*;
import java.util.*;


public class RandomCup {

    Random rand = new Random();
    public ArrayList<Integer> highScore=new ArrayList<>();
    Scanner input = new Scanner(System.in);
    String[] cups={"      -------      ","     /       \\     ","    /         \\    ","   /           \\   ","  /_____________\\  "};
    String[] happyface={"   ---------------- ","  |   *     *     | ","  |      |        | ","  \\   \\_____/    /  ","     ----------     "};
    String[] sadFace={"   ---------------  ","  |   @     @     | ","  |      |        | ","   \\   <----->   /  ","      ---------     "};


    public void serializeList(ArrayList list){
        try {
            FileOutputStream f = new FileOutputStream(new File("highScore.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            // Write objects to file
            o.writeObject(list);
            o.close();
            f.close();

        } catch (IOException i) {
            i.printStackTrace();
        }


    }
    public ArrayList unserializeList(ArrayList list){
        try {
            FileInputStream fileIn = new FileInputStream("highScore.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            list = (ArrayList<Integer>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();

        } catch (ClassNotFoundException c) {
            c.printStackTrace();

        }
        return list;
    }

    public int mainGame() {
        int winFlag = 0;
        int choice;
        String playagain="";
        int score = 0;//The number og continuously wins
        int maxScore=0;
        System.out.println("\nFind the happy face to win!");
        do{
            printCups();
            do {
                System.out.print("Select a cup between 1-3: ");
                choice = input.nextInt();
            }while (choice<1 || choice>3);
            int randomNum = rand.nextInt(3);//The variable that sets the cup with the happy face
            randomNum += 1;
            System.out.println();
            for (int i = 0; i < 5; i++) {//The 5 lines
                for (int j = 0; j < 3; j++) {//The 3 Items
                    if (choice == (j + 1)) {//If you selected the right cup
                        if (randomNum == choice) {
                            System.out.print(happyface[i]);
                            winFlag = 1;
                        }
                         else{
                            winFlag = 0;
                            System.out.print(sadFace[i]);
                        }
                    } else
                        System.out.print(cups[i]);
                }
                System.out.println();//Change line
            }
            if (winFlag == 1) {
                System.out.println("You won!!");
                score += 1;
                System.out.println("You have "+score+" wins in row!!");
                if(score>=maxScore) {
                    maxScore = score;
                }
            } else {
                score = 0;
                System.out.println("You lost :(");
            }
            System.out.print("Press Y if you want to play again or another key to return to Game menu: ");
            playagain=input.next();
    }while (playagain.equalsIgnoreCase("y"));
        return maxScore;
    }

    public void printCups(){
        System.out.print("         1         ");
        System.out.print("         2         ");
        System.out.println("         3         ");
        for (int i=0;i<5;i++){
            System.out.print(cups[i]);
            System.out.print(cups[i]);
            System.out.println(cups[i]);

        }
    }

    public void printScore(){
        int sameScores=0;

        System.out.println("---------------------------");
        System.out.println("| |      HIGHSCORE      | |");
        System.out.println("---------------------------");
        Collections.sort(highScore);
        Collections.reverse(highScore);
        System.out.println("1. "+highScore.get(0));//I print it before loop because first item is the biggest
        for (int i=1;i<highScore.size();i++){
            if(highScore.get(i)!=highScore.get(i-1))
                 System.out.println((i+1-sameScores)+". "+highScore.get(i));
            else
                sameScores+=1;

        }
        System.out.print("Press key to return to menu: ");
        input.next();

    }

    public void RandomCupMain(){
        highScore=unserializeList(highScore);
        int Choice;
        System.out.println("---------------------------");
        System.out.println("| |     RANDOM CUP      | |");
        do {
            System.out.println("---------------------------");
            System.out.println("1. Play ");
            System.out.println("2. See High Score list ");
            System.out.println("3. Exit ");
            System.out.println("---------------------------");
            System.out.print("Choose: ");
            Choice = input.nextInt();
            switch (Choice) {
                case 1:

                    highScore.add(mainGame());
                    break;
                case 2:
                    printScore();
                    break;
                case 3:
                    break;

                default:
                    System.out.println("You must select a number between 1-3!");
                    break;

            }
        }while (Choice!=3);
       serializeList(highScore);
    }
}
