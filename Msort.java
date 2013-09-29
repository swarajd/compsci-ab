public class Msort {
	public static void mergeSort(int[] li, int[] buf, int low, int high)
	{
		if (low < high)
		{
			int middle = low + (high - low) / 2;
			mergeSort(li, buf, low, middle);
			mergeSort(li, buf, middle + 1, high);
			merge(li, buf, low, middle, high);
		}
	}
	public static void merge(int[] li, int[] buf, int low, int middle, int high)
	{
		for (int i = 0; i < li.length; i++)
		{
			buf[i] = li[i];
		}
		int i = low;
		int j = middle + 1;
		int k = low;
		while (i <= middle && j <= high)
		{
			if (buf[i] <= buf[j])
			{
				li[k] = buf[i];
				i++;
			}
			else
			{
				li[k] = buf[j];
				j++;
			}
			k++;
		}
		while (i <= middle)
		{
			li[k] = buf[i];
			k++;
			i++;
		}
	}
	public static void print(int[] array)
	{
		for(int theNumber : array )     //doing something to each
			System.out.println(theNumber);
		System.out.println();
	}
	public static void main(String[] args)
	{
		int n = 10;//(int)(Math.random()*100);
		int[] array = new int[n];
		int[] buf = new int[n];
		for(int k = 0; k < array.length; k++)
		{
			array[k] = (int)(Math.random()*100);
		}
		System.out.println("init: "); 
		print(array);
		mergeSort(array, buf, 0, array.length - 1);
		System.out.println("result: "); 
		print(array);
	}
}
