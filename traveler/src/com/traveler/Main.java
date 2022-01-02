package com.traveler;

import java.util.*;
import java.util.Scanner;
import java.lang.*;

public class Main {
	public static void main(String[] args) {
		int denominationSize;
		int amountToPay;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of currency denominations");
		denominationSize = sc.nextInt();
		int denominationValue[] = new int[denominationSize];
		int sortedDenominationValue[] = new int[denominationSize];
		int totalDenominations[] = new int[denominationSize];
		System.out.println("Enter the currency denominations Value");
		for(int i = 0; i < denominationSize; i++)  {
			denominationValue[i] = sc.nextInt();
		}
		MergeSortAlgorithm MergeSortAlgorithm = new MergeSortAlgorithm();
		MergeSortAlgorithm.sort(denominationValue, 0, denominationValue.length - 1);
		sortedDenominationValue = MergeSortAlgorithm.printArray(denominationValue);
		System.out.println("Enter the amount you want to pay");
		amountToPay = sc.nextInt();
		for (int i = sortedDenominationValue.length-1; i > -1; i--) {
            	totalDenominations[i] = amountToPay / sortedDenominationValue[i];
            	amountToPay = amountToPay - totalDenominations[i] * sortedDenominationValue[i];
        }
		System.out.println("Your payment approach in order to give min no of notes will be");
        for (int i = denominationSize - 1; i > -1; i--) {
        	if (totalDenominations[i] != 0) {
                System.out.println(sortedDenominationValue[i] + ":"
                    + totalDenominations[i]);
        	}
        }
	}
}

class MergeSortAlgorithm {
	void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
  

        int L[] = new int[n1];
        int R[] = new int[n2];
  
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
  

        int i = 0, j = 0;
  
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
  
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
	
	void sort(int arr[], int l, int r)
    {
        if (l < r) {

            int m =l+ (r-l)/2;
  
            sort(arr, l, m);
            sort(arr, m + 1, r);
  
            merge(arr, l, m, r);
        }
    }
	
	static int[] printArray(int arr[])
    {
        int arrLen = arr.length;
        int sortedDenominationValue[] = new int[arrLen];
        for (int i = 0; i < arrLen; ++i) {
        	sortedDenominationValue[i] = arr[i];
        }
        return sortedDenominationValue;
            
    }
}