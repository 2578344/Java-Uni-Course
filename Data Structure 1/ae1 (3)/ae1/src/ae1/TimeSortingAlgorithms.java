package ae1;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TimeSortingAlgorithms {

	public static void timeSort(String input) throws Exception {
		List<Integer> list = new ArrayList<Integer>();
		Scanner scan = new Scanner(new FileReader(input));
		int line;
		while(scan.hasNext()) {
			line = Integer.parseInt(scan.next());
			list.add(line);
		}
		//convert to array 
		Integer[] arr = list.toArray(new Integer[0]);
		System.out.println("-------------------------------------------------------");
		System.out.println("Time taken to sort "+ input);
		System.out.println();
		Integer[] cArr = Arrays.copyOf(arr, arr.length);
		long time1=System.currentTimeMillis();
		Part1.quickSort(cArr,0,cArr.length-1);
		long time2=System.currentTimeMillis();
		System.out.println("Quicksort: "+(time2-time1)+" milliseconds");
		
		System.out.println();
		cArr = Arrays.copyOf(arr, arr.length);
		time1=System.currentTimeMillis();
		Part1.quickSortCutoff(cArr,0,cArr.length-1);
		time2=System.currentTimeMillis();
		System.out.println("QuickSortCutoff: "+(time2-time1)+" milliseconds");
		
		System.out.println();
		cArr = Arrays.copyOf(arr, arr.length);
		time1=System.currentTimeMillis();
		Part1.quickSortMedian(cArr,0,cArr.length-1);
		time2=System.currentTimeMillis();
		System.out.println("QuickSortMedian: "+(time2-time1)+" milliseconds");
		
		System.out.println();
		cArr = Arrays.copyOf(arr, arr.length);
		time1=System.currentTimeMillis();
		Part1.quickSort3Way(cArr,0,cArr.length-1);
		time2=System.currentTimeMillis();
		System.out.println("QuickSort3Way: "+(time2-time1)+" milliseconds");

		System.out.println();
		cArr = Arrays.copyOf(arr, arr.length);
		time1=System.currentTimeMillis();
		InserAndMergSorts.insertionSort(cArr);
		time2=System.currentTimeMillis();
		System.out.println("InsertionSort: "+(time2-time1)+" milliseconds");
		
		System.out.println();
		cArr = Arrays.copyOf(arr, arr.length);
		time1=System.currentTimeMillis();
		InserAndMergSorts.mergeSort(cArr,0,cArr.length-1);
		time2=System.currentTimeMillis();
		System.out.println("MergeSort: "+(time2-time1)+" milliseconds");
		
		System.out.println("-------------------------------------------------------");
		
	}
}
