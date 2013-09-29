public class Qsort
{
	public static void quickSort(double[] info, int first, int last)
	{
		int splitPt;
		if (first < last)
		{
			splitPt = split(info, first, last);
			quickSort(info, first, splitPt - 1);
			quickSort(info, splitPt + 1, last);
		}
	}
	public static void swap(double[] info, int a, int b)
	{
		double temp = info[a];
		info[a] = info[b];
		info[b] = temp;
	}
	public static int split(double[] info, int first, int last)
	{
		int splitPt = first;
		double pivot = info[first];
		while (first <= last)
		{
			if (info[first] <= pivot)
			{
				first++;
			}
			else if (info[last] >= pivot)
			{
				last--;
			}
			else
			{
				swap(info, first, last);
				first++;
				last--;
			}
		}
		swap(info, last, splitPt);
		splitPt = last;
		return splitPt;
	}
	public static void print(double[] array)
	{
		for(double theNumber : array )     //doing something to each
			System.out.println(theNumber);
		System.out.println();
	}
	public static void main(String[] args)
	{
		double[] test = new double[10];
		for (int i = 0; i < 10; i++)
		{
			test[i] = (double)(Math.random()*10);
		}
		print(test);
		int x = split(test,0,test.length-1);
		System.out.println("x: " + x + " info[x]: " + test[x]);
		print(test);
		
	}
}
