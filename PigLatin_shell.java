// your name, date
   import java.util.*;
   import java.io.*;
    public class PigLatin_shell
   {
       public static void main(String[] args) throws FileNotFoundException
      {
         part_1();
         // part_2();
      }
       public static String pig(String s)
      {
        //init information: vowels, punctuation, first letter
        ArrayList<String> vowels = new ArrayList<String>(Arrays.asList("a","e","i","o","u","A","E","I","O","U"));
        ArrayList<String> punctuation = new ArrayList<String>(Arrays.asList("!","?",".",",",";",":","-","(",")","'","\"","/","\\"));
        String init = s.substring(0,1);
        //check if the first letter is a vowel, if so, just append way and return
        String mid = s;
        
        int eps = s.length();
        int epe = s.length();

        String endP = "";
        
        
        boolean isP = true; 
        int c = s.length()-1;
        while (isP) {
            isP = false;
            for (int j = 0; j < punctuation.size(); j++) {
                if (s.substring(c,c+1).equals(punctuation.get(j))) {
                    eps--;
                    isP = true;
                }
            }
            c--;
        }
        if (eps != epe) {
            endP = s.substring(eps,epe);
            mid = s.substring(0,eps);
        }
        
        for (int j =  0; j < vowels.size(); j++) {
            if (init.equals(vowels.get(j))) {
                return mid + "way" + endP;
            }
        }
        //is y a vowel or consonant 
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i,i+1).equals("y") && i > 0) {
                vowels.add("y");
                vowels.add("Y");
            }
        }
        //punctuation
        String rest = s;
        
        int epstart = s.length();
        int epend   = s.length();

        String endPunctuation = "";
        
        boolean isPunc = true; 
        int counter = s.length()-1;
        while (isPunc) {
            isPunc = false;
            for (int j = 0; j < punctuation.size(); j++) {
                if (s.substring(counter,counter+1).equals(punctuation.get(j))) {
                    epstart--;
                    isPunc = true;
                }
            }
            counter--;
        }
        if (epstart != epend) {
            endPunctuation = s.substring(epstart,epend);
            rest = rest.substring(0,epstart);
        }
        
        int spstart = 0;
        int spend   = 0;
        
        String startPunctuation = "";
        
        isPunc = true;
        counter = 0;
        while (isPunc) {
            isPunc = false;
            for (int j = 0; j < punctuation.size(); j++) {
                if (s.substring(counter,counter+1).equals(punctuation.get(j))) {
                    spend++;
                    isPunc = true;
                }
            }
            counter++;
        }
        
        if (spstart != spend) {
            startPunctuation = s.substring(spstart,spend);
            rest = rest.substring(spend,rest.length());
            //leadingConsonants = leadingConsonants.substring(spend,leadingConsonants.length());
        }
        
        //DEBUG AFTER THIS
        
        //for loop to find the first vowel, mostly for special case of q
        String firstVowel = "orig";
        int vowIndex = -1;
        for (int i = rest.length()-1; i > 0; i--) {
            for (int j =  0; j < vowels.size(); j++) {
                if (rest.substring(i,i+1).equals(vowels.get(j))) {
                    vowIndex = i;
                    firstVowel = vowels.get(j);
                }
            }
        }
        if (vowIndex == -1) {
            return "INVALID";
        }
        if (rest.substring(vowIndex-1,vowIndex).equals("q") && firstVowel.equals("u")) {
            vowels.remove("u");
        }
        //for loop to find the leading consonants
        int end = 0;
        boolean encounteredVowel = false;
        for (int i = 0; i < rest.length(); i++) {
            boolean isAVowel = false;
            for (int j = 0; j < vowels.size(); j++) {
                if (rest.substring(i,i+1).equals(vowels.get(j))) {
                    isAVowel = true;
                }
            }
            if (!isAVowel && !encounteredVowel) {
                end++;
            } else {
                encounteredVowel = true;
            }
        }
        String leadingConsonants = rest.substring(0,end);
        rest = rest.substring(end,rest.length());
        //capitalization
        if (Character.isUpperCase(s.charAt(0))) {
            rest = rest.substring(0,1).toUpperCase() + rest.substring(1,rest.length());
            leadingConsonants = leadingConsonants.substring(0,1).toLowerCase() + leadingConsonants.substring(1,leadingConsonants.length());
        }
        
        //final returns
        return (startPunctuation + rest + leadingConsonants + "ay" + endPunctuation);
      
      }
       public static void part_1()
      {
         Scanner sc = new Scanner(System.in);
         while(true)
         {
            System.out.print("\nWhat word? ");
            String s = sc.next();
            if (s.equals("-1")) 
               break;
            String p = pig(s);
            System.out.println("***** " + p + " *****");
         }		
      }
       public static void part_2() 
      {
         /***************************
         *
         *   enter your code here:
      		 Scanner class, try-catch, nested loops, file output  
         *
         ****************************/
      }
   }
