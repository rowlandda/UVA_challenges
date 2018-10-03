/* @BEGIN_OF_SOURCE_CODE */

import java.util.*;

public class Main {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String a, b;
        ArrayList<String> output = new ArrayList<String>();
        while (input.hasNextLine())
        {
            a = input.nextLine().trim();
            b = input.nextLine().trim();
            char[] a_array = a.toCharArray();
            char[] b_array = b.toCharArray();
            ArrayList<Character> common = commonLetters(a_array, b_array);
            HashMap<Character, Integer> aMap = new HashMap<>();
            HashMap<Character, Integer> bMap = new HashMap<>();
            for (Character ch : common) {
                int freqA = getFrequency(ch, a_array);
                int freqB = getFrequency(ch, b_array);
                aMap.put(ch, freqA);
                bMap.put(ch, freqB);
            }
            HashMap<Character, Integer> results = lowestFrequency(aMap, bMap);
            output.add(stringX(results));
        }
        for (String sub : output)
            System.out.println(sub);
    }

    private static ArrayList<Character> commonLetters(char[] a, char[] b)
    {
        ArrayList<Character> common = new ArrayList<>();
        ArrayList<Character> aList = new ArrayList<>();
        ArrayList<Character> bList = new ArrayList<>();
        for (int i = 0; i < a.length; i++)
            aList.add(a[i]);
        for (int i = 0; i < b.length; i++)
            bList.add(b[i]);
        if (a.length > b.length)
        {
            for (char letter : a)
            {
                if ((bList.contains(letter)) && (!common.contains(letter)))
                    common.add(letter);
            }
        }else
        {
            for (char letter : b)
            {
                if ((aList.contains(letter)) && (!common.contains(letter)))
                    common.add(letter);
            }

        }
        return common;
    }
    //gets the frequency of a letter in a char array "word"
    private static int getFrequency(char letter, char[] word)
    {
        int count = 0;
        for (int i = 0; i < word.length; i++)
        {
            if (letter == word[i])
                count++;
        }
        return count;
    }

    //returns the lowest frequency of the char between the two "words". both maps must be the
    //same size with same keys. the result is the amount of each character in "x"
    private static HashMap<Character, Integer> lowestFrequency(HashMap<Character, Integer> a,
                                                               HashMap<Character, Integer> b)
    {
        HashMap<Character, Integer> result = new HashMap<>();
        for (Character ch : a.keySet())
        {
            if ( a.get(ch) < b.get(ch) )
                result.put(ch, a.get(ch));
            else
                result.put(ch, b.get(ch));
        }
        return result;
    }
   //return x in string form in alphabetical order
    private static String stringX(HashMap<Character, Integer> result)
    {
        StringBuilder sb = new StringBuilder();
        int size = 0;
        for (Character ch : result.keySet())
        {
            size += result.get(ch);
        }
        ArrayList<Character> answer = new ArrayList<>();
        for (Character ch : result.keySet())
        {
            int max = result.get(ch);
            for (int i = 0; i < max; i++)
                answer.add(ch);
        }
        Character[] charArr = new Character[answer.size()];
        charArr = answer.toArray(charArr);
        Arrays.sort(charArr);
        for (Character ch : charArr)
            sb.append(ch);
        return sb.toString();
    }
}
/* @JUDGE_ID: 979449 10252 JAVA "Common Permutation" */
/* @END_OF_SOURCE_CODE */
