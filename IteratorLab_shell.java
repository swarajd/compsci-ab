 //Name:      Date:
 // use for-each loops or iterators, not regular for-loops
   import java.io.*;
   import java.util.*;
    public class IteratorLab_shell
   {
       public static void main(String[] args)
      {
         System.out.println("Iterator Lab\n");
         int[] rawNumbers = {-9, 4, 2, 5, -10, 6, -4, 24, 20, -28};
         for(int n : rawNumbers )
            System.out.print(n + " ");    
         ArrayList<Integer> numbers = createNumbers(rawNumbers);
         System.out.println("ArrayList: "+ numbers);      //Implicit Iterator!
         System.out.println("Count negative numbers: " + countNeg(numbers));
         System.out.println("Average: " + average(numbers));
         System.out.println("Replace negative numbers: " + replaceNeg(numbers));
         System.out.println("Delete zeros: " + deleteZero(numbers));
         String[] rawMovies = {null, null, null, "High_Noon"/*, "High_Noon", "Star_Wars", "Tron", "Mary_Poppins", 
               "Dr_No", "Dr_No", "Mary_Poppins", "High_Noon", "Tron"*/};
         ArrayList<String> movies = createMovies(rawMovies);
         System.out.println("Movies: " + movies);
         System.out.println("Movies: " +  removeDupes(movies));
      }
      // pre: an array of just int values 
   	// post: return an ArrayList containing all the values
       public static ArrayList<Integer> createNumbers(int[] rawNumbers) 
      {
        ArrayList<Integer> al = new ArrayList();
        for (int n : rawNumbers) {
            al.add(n);
        }
        return al;
      }
      // pre: an array of just Strings  
   	// post: return an ArrayList containing all the Strings
       public static ArrayList<String> createMovies(String[] rawWords) 
      {
        ArrayList<String> al = new ArrayList();
        for (String w : rawWords) {
            al.add(w);
        }
        return al;
      }
   
   	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: return the number of negative values in the ArrayList a
       public static int countNeg(ArrayList<Integer> a)
      {
         int iter = 0;
         for (int i : a) {
             if (i < 0) {
                 iter++;
             }
         }
         return iter;
      }
   	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: return the average of all values in the ArrayList a
       public static double average(ArrayList<Integer> a)
      {
          double avg = 0;
          int iter = 0;
          for (int i : a) {
              avg += i;
              iter++;
          }
          return (avg / iter);
      }
     	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: replaces all negative values with 0 
       public static ArrayList<Integer> replaceNeg(ArrayList<Integer> a)
      {
          int iter = 0;
          for (int i : a) {
              if (i < 0) {
                  a.set(iter,0);
              }
              iter++;
          }
          return a;
      }
     	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: deletes all zeros in the ArrayList a
       public static ArrayList<Integer> deleteZero(ArrayList<Integer> a)
      {
          Iterator iter = a.iterator();
          while (iter.hasNext()) {
              if (iter.next().equals(0)) {
                  iter.remove();
              }
          }
          return a;
      }
      // pre: ArrayList a is not empty and contains only String objects
   	// post: return ArrayList without duplicate movie titles
		// strategy: build a new array using 2 for-each and a boolean
       public static ArrayList<String> removeDupes(ArrayList<String> a)
      {
          ArrayList<String> vals = new ArrayList<String>();
          for (String sti : a) {
              if (!vals.contains(sti)) {
                  vals.add(sti);
              }
          }
          return vals;
          /* Set set = new Hashset(a)
           * ArrayList vals = new ArrayList(set);
           * return vals
           */  
      }
   
   }

