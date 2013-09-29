/* 
Calls methods in the classes Merge and QuickSort. 
 Students are to write the Merge and QuickSort classes.
*/
//import java.util.*;
//import java.io.*;

public class Merge_Quick_shell
{
  public static void main(String[] args) throws Exception
  {
	 int n = (int)(Math.random()*100);
	 double[] array = new double[n];
	 for(int k = 0; k < array.length; k++)
		array[k] = Math.random();	
	 print(array);
	 //Merge.sort(array);
	 QuickSort.sort(array);
	 print(array);
	 if(check(array))
		System.out.println("In order!");
	 else
		System.out.println("oops!");
  }
  public static void print(double[] array)
  {
	 for(double theNumber : array )     //doing something to each
		System.out.println(theNumber);
	 System.out.println();
  }
  public static boolean check(double[] a)
  {
	 return true; //change this
  }
}
/////////////////////////////////////////////////
// from Lambert & Osborne, p. 482 - 485
class Merge
{
  private static final int CUTOFF = 10;  // for small lists, recursion isn't worth it
  public static void sort(double[] array)
  { 
	 double[] copyBuffer = new double[array.length];
	 mergeSortHelper(array, copyBuffer, 0, array.length - 1);
  }

  private static void mergeSortHelper(double[] array, double[] copyBuffer,
														 int low, int high)
  {  
	 if (array.length <= CUTOFF)
	 {
			for (int i = 0; i < array.length; i++)
			{
				for (int j = i; j < array.length; j++)
				{
					if (array[i] > array[j])
					{
						double temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					}
				}
			}
	 }
	 else if (low < high)
	 {
		int middle = low + (high - low) / 2;
		mergeSortHelper(array, copyBuffer, low, middle);
		mergeSortHelper(array, copyBuffer, middle + 1, high);
		merge(array, copyBuffer, low, middle, high);
	 }
  }

  public static void merge(double[] array, double[] copyBuffer,
								  int low, int middle, int high)
  // array				array that is being sorted
  // copyBuffer		temp space needed during the merge process
  // low				beginning of first sorted subarray
  // middle			end of first sorted subarray
  // middle + 1		beginning of second sorted subarray
  // high				end of second sorted subarray
  {
	  for (int i = 0; i < array.length; i++)
		{
			copyBuffer[i] = array[i];
		}
		int i = low;
		int j = middle + 1;
		int k = low;
		while (i <= middle && j <= high)
		{
			if (copyBuffer[i] <= copyBuffer[j])
			{
				array[k] = copyBuffer[i];
				i++;
			}
			else
			{
				array[k] = copyBuffer[j];
				j++;
			}
			k++;
		}
		while (i <= middle)
		{
			array[k] = copyBuffer[i];
			k++;
			i++;
		}
  }		
}

////////////////////////////////////////////////////
class QuickSort
{
  public static void sort(double[] array)
  {
	 helper(array, 0, array.length - 1);
  }
  private static void helper(double[] array, int first, int last)
  {
	  int splitPt;
		if (first < last)
		{
			splitPt = split(array, first, last);
			helper(array, first, splitPt - 1);
			helper(array, splitPt + 1, last);
		}
  }
  
  private static void swap(double[] array, int a, int b)
  {
	  double temp = array[a];
	  array[a] = array[b];
	  array[b] = temp;
  }
  private static int split(double[] array, int first, int last)
  {
	  int splitPt = first;
		double pivot = array[first];
		while (first <= last)
		{
			if (array[first] <= pivot)
			{
				first++;
			}
			else if (array[last] >= pivot)
			{
				last--;
			}
			else
			{
				swap(array, first, last);
				first++;
				last--;
			}
		}
		swap(array, last, splitPt);
		splitPt = last;
		return splitPt;
  }
  
}
