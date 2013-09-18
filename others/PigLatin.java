import java.io.*;
import java.util.Scanner;

public class PigLatin
{
   final static String[] lowerVowels = {"a", "e", "i", "o", "u"};
   final static String[] punctuation = {"?", "/", ".", ">", ",", "<", "'", "\"", ";", ":", "\\", "|", "]", "}", "[", "{", "=", "+", "-", "_", "`", "~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")"};
	
  /* static String regTranslate(String a)
   {
      //a1 = index of consonant to substring, a2 = counter for length, a3 = counter for array, a4 = substring x, a5 = substring y
      int a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 1;
      boolean stop = false, stop1 = false;
      boolean none = false;
      
      for(int o = 0; o < a.length(); o++) //loop through characters of word
      {	
         for(int i =	0;	i < lowerVowels.length; i++) //loop compare each letter to vowel list
         {
            if((!a.substring(a4, a5).equals(lowerVowels[i]) && i == lowerVowels.length-1) && !stop) //if character is not a vowel
            {
               a2++; //increment number of consonants
            }
            if(a.substring(a4, a5).equals(lowerVowels[i]) || ((a.substring(a4, a5).equals("y") && a4 > 0)) && a2 != a.length()-1) //if character is a vowel
            {
               stop = true;
            }
            if(a2 == a.length()-1 && !a.substring(a.length()-1, a.length()).equals("y") && !stop1)
            {
               none = true;
            }
            if(a.substring(a.length()-1,a.length()).equals(lowerVowels[i]))
            {
               none = false;
               stop1 = true;
            }
         }
         a4++;
         a5++;
      }
      
      if(a2 > 0) //if any consonants found
      {
         if(a.substring(a.length()-1, a.length()).equals("y"))
         {
            String specY = a.substring(0,a.length()-1);
            return "y" + specY + "ay";
         }
         if(none)
         {
            return "*****INVALID*****";
         }
         String qCheck = a.substring(a2-1,a2); //special case for "qu"
         if(qCheck.equals("q"))
         {
            String qCheck2 = a.substring(a2,a2+1);
            if(qCheck2.equals("u"))
            {
               String qRet1 = a.substring(0,a2+1);
               String qRet2 = a.substring(a2+1,a.length());
               return qRet2 + qRet1 + "ay";
            }
         }
         
         String reg1 = a.substring(0,a2); //regular return
         String reg2 = a.substring(a2,a.length());
         return reg2 + reg1 + "ay";
      }
      return a;
   }
   */
   static String translate(String a)
   {
      String preTrans = a;
      
   	//punctuation
      int startPE = 0, endPS = a.length(), wordCounter = a.length()-1;
      boolean cont = true;
      String puncStart = "", puncEnd = "";
      
      while(cont)
      {
         cont = false;
         for(int i = 0; i < punctuation.length; i++)
         {
            if(a.substring(wordCounter, wordCounter+1).equals(punctuation[i]))
            {
               endPS--;
               cont = true;
            }
         }
         wordCounter--;
      }
      puncEnd = a.substring(endPS, preTrans.length());
      
      preTrans = a.substring(0,endPS);
      cont = true;
      wordCounter = 0;
      
      while(cont)
      {
         cont = false;
         for(int i = 0; i < punctuation.length; i++)
         {
            if(preTrans.substring(wordCounter, wordCounter+1).equals(punctuation[i]))
            {
               startPE++;
               cont = true;
            }
         }
         wordCounter++;
      }
      puncStart = preTrans.substring(0, startPE);
      
      preTrans = preTrans.substring(startPE, preTrans.length());
   	//first letter vowel
      for(int i = 0; i < lowerVowels.length; i++)
      {
         if(preTrans.substring(0,1).toLowerCase().equals(lowerVowels[i]))
         {
            return puncStart + preTrans + "way" + puncEnd;
         }
      }
      
      //regular translation & precheck for capitalization
      boolean isCapital = false;
      if(Character.isUpperCase(preTrans.charAt(0)))
      {
         isCapital = true;
      }
      
      int a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 1;
      boolean stop = false, stop1 = false;
      boolean none = false;
      
      for(int o = 0; o < preTrans.length(); o++) //loop through characters of word
      {	
         for(int i =	0;	i < lowerVowels.length; i++) //loop compare each letter to vowel list
         {
            if((!preTrans.substring(a4, a5).equals(lowerVowels[i]) && i == lowerVowels.length-1) && !stop) //if character is not a vowel
            {
               a2++; //increment number of consonants
            }
            if(preTrans.substring(a4, a5).equals(lowerVowels[i]) || ((preTrans.substring(a4, a5).equals("y") && a4 > 0)) && a2 != preTrans.length()-1) //if character is a vowel
            {
               stop = true;
            }
            if(a2 == preTrans.length()-1 && !preTrans.substring(preTrans.length()-1, preTrans.length()).equals("y") && !stop1)
            {
               none = true;
            }
            if(preTrans.substring(preTrans.length()-1,preTrans.length()).equals(lowerVowels[i]))
            {
               none = false;
               stop1 = true;
            }
         }
         a4++;
         a5++;
      }
      
      if(a2 > 0) //if any consonants found
      {
         if(preTrans.substring(preTrans.length()-1, preTrans.length()).equals("y"))
         {
            String specY = preTrans.substring(0,preTrans.length()-1);
            preTrans = "y" + specY + "ay";
         }
         if(none)
         {
            preTrans = "*****INVALID*****";
         }
         String qCheck = preTrans.substring(a2-1,a2); //special case for "qu"
         if(qCheck.equals("q"))
         {
            String qCheck2 = preTrans.substring(a2,a2+1);
            if(qCheck2.equals("u"))
            {
               String qRet1 = preTrans.substring(0,a2+1);
               String qRet2 = preTrans.substring(a2+1,preTrans.length());
               preTrans = qRet2 + qRet1 + "ay";
            }
         }
         
         String reg1 = preTrans.substring(0,a2); //regular return
         String reg2 = preTrans.substring(a2,preTrans.length());
         preTrans = reg2 + reg1 + "ay";
      }

   
   	//capitalization   
      if(isCapital == true)
      {
         String s1 = preTrans.toLowerCase().substring(1,preTrans.length());
         String s2 = preTrans.substring(0,1).toUpperCase();
         return puncStart + s2 + s1 + puncEnd;
      }
            
      String finalTrans = puncStart + preTrans + puncEnd;
      return finalTrans;
   }
   
   public static void main(String[] args) throws IOException
   {
      Scanner k1 = new Scanner(System.in);
      System.out.print("Name of input: ");
      String input1 = k1.nextLine().trim();
      File file = new File(input1);
      Scanner k = new Scanner(file);
      File output = new File("igLatinpay.txt");
      PrintStream print = new PrintStream(output);
   	
      while(k.hasNext())
      {
         String s = k.nextLine().trim();
         String ret = translate(s);
         print.println(ret);
      }
      print.close();
   }
}
