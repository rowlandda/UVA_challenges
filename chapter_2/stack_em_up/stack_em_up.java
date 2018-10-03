/* @BEGIN_OF_SOURCE_CODE */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Main {

    public static void main(String[] args)
    {
        //create a key to interpret the 1-52 numbers for cards
        HashMap<Integer, String> key = new HashMap<>();
        int value = 2;
        for (int i = 1; i < 14; i++)
        {
            key.put(i, "" + value + " of Clubs");
            value++;
        }
        value = 2;
        for (int i = 14; i < 27; i++)
        {
            key.put(i, "" + value + " of Diamonds");
            value++;
        }
        value = 2;
        for (int i = 27; i < 40; i++)
        {
            key.put(i, "" + value + " of Hearts");
            value++;
        }
        value = 2;
        for (int i = 40; i < 53; i++)
        {
            key.put(i, "" + value + " of Spades");
            value++;
        }

        //take care of the face cards.  probably super inefficient
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

       for (int j = 1; j < 53; j++)
       {
           if ( (j == 10) || (j == 23) || (j == 36) || (j == 49) )
               key.put(j, "Jack of ");
           if ( (j == 11) || (j == 24) || (j == 37) || (j == 50) )
               key.put(j, "Queen of ");
           if ( (j == 12) || (j == 25) || (j == 38) || (j == 51) )
               key.put(j, "King of ");
           if ( (j == 13) || (j == 26) || (j == 39) || (j == 52) )
               key.put(j, "Ace of ");
       }

       for (int i = 1; i < 53; i++)
       {
           if ( (i == 10) || (i == 11) || (i == 12) || (i == 13) )
               key.put(i, key.get(i) + "Clubs");
           if ( (i == 23) || (i == 24) || (i == 25) || (i == 26) )
               key.put(i, key.get(i) + "Diamonds");
           if ( (i == 36) || (i == 37) || (i == 38) || (i == 39) )
               key.put(i, key.get(i) + "Hearts");
           if ( (i == 49) || (i == 50) || (i == 51) || (i == 52) )
               key.put(i, key.get(i) + "Spades");
       }




        Scanner input = new Scanner(System.in);
        int[] deck = new int[52];
        for (int j = 0; j < 52; j++)
            deck[j] = j + 1;
        int cases = input.nextInt();
        for (int i = 0; i < cases; i++)
        {
            //create new deck
            int[] deck2 = Arrays.copyOf(deck, 52);
            ArrayList<int[]> shuffles = new ArrayList<>();
            int num_shuffles = input.nextInt();
            //load the shuffles
            for (int j = 0; j < num_shuffles; j++)
            {
                int[] shuff = new int[52];
                for (int k = 0; k < 52; k++)
                    shuff[k] = input.nextInt();
                shuffles.add(shuff);
            }
            input.nextLine();
            String convert = " ";
            int index = 0;
           while (input.hasNextInt())
            {
                convert = input.nextLine();
                if ( (convert == null) || (convert.equals("")) )
                    break;
                index = Integer.parseInt(convert);
                shuffle(deck2, shuffles.get(index - 1));
            }

            print(deck2, key);
            if (i < cases - 1)
                System.out.println();
        }
        System.exit(0);
    }

    //takes the deck and shuffles using another array as a guide
    public static void shuffle(int[] deck, int[] guide)
    {
        int[] tempArr = new int[52];
        for (int i = 0; i < 52; i++)
        {
                tempArr[i] = deck[guide[i]-1];
        }
        for (int i = 0; i < 52; i++)
            deck[i] = tempArr[i];
    }


    public static void print(int[] deck, HashMap<Integer, String> key)
    {
        for (int i = 0; i < 52; i++)
            System.out.println(key.get(deck[i]));
    }
}
/* @JUDGE_ID: 979449 10205 JAVA "Stack 'em up" */
/* @END_OF_SOURCE_CODE */
