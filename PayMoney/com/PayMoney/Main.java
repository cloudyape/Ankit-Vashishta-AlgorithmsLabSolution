package com.PayMoney;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	    int transactionArraySize;
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the Size of Transation Array");
	    transactionArraySize = sc.nextInt();
	    long arr[] = new long[transactionArraySize];
	    long sums[] = new long[transactionArraySize];
	    System.out.println("Enter the values of array ");
	    for(int i=0;i<transactionArraySize;i++){
	        arr[i] = sc.nextLong();
	        if(i==0) {
	            sums[i] = arr[i];
	        }
	        else {
	            sums[i] = arr[i] + sums[i-1];
	        }
	    }
	    int noOfTargets;
	    System.out.println("Enter the total no of targets that needs to be achieved");
	    noOfTargets = sc.nextInt();
	    System.out.println(sums[1]+ "   " + sums[2]);
	    while(noOfTargets != 0){
	    	System.out.println("Enter the value of target");
	        int valueOfTarget;
	        valueOfTarget = sc.nextInt();
	        int i=0;
	        int check = 0;
	        for(i=0;i<noOfTargets;i++){
	            if(sums[transactionArraySize - 1]>= valueOfTarget){
	            	noOfTargets = noOfTargets-1;
	                check++;
	                if(check!=0){
			            System.out.println(i+1);
			            break;
			        }else{
			        	System.out.println("Target achieved");
			        	break;
			        }
	            }
	            else{
	            	if(check!=0){
			            System.out.println(i+1);
			        }else{
			        	System.out.println("Given target is not achieved");
			        	break;
			        }
	            }
	            
	        }
	    }
	}
	}
