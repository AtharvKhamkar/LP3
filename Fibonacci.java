import java.util.*;


public class Fibonacci{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int n = sc.nextInt();
	
		long inputTimeRec = System.nanoTime();
		long fibRecAns = fibRecursion(n);
		long outTimeRec = System.nanoTime();
		long totalTimeRec = outTimeRec - inputTimeRec;
	
		long inputTimeIter = System.nanoTime();
		long fibIterAns = fibIterative(n);
		long outTimeIter = System.nanoTime();
		long totalTimeIter = outTimeIter - inputTimeIter;
	
		System.out.println("Fibbonacci Number of n using recursion is " + fibRecAns);
		System.out.println("Time taken to execute using recursion is " + totalTimeRec + "nanoseconds");
		System.out.println("_______________________________________________________");
		System.out.println("Fibbonacci Number of n using Iterative Method is" + fibIterAns);
		System.out.println("Time taken to execute using Iterative Method is" + totalTimeIter+"nanoseconds");
	
	
	
}


public static long fibRecursion(int n){
	if(n < 2){
		return n;
	}else{
		return fibRecursion(n-1) + fibRecursion(n-2);
	}
}


public static long fibIterative(int n){
	if(n<2){
		return n;
	}else{
		long a = 0,b=1;
		for(int i=2;i<=n;i++){
			long temp = a;
			a=b;
			b = temp + b;
		}
		return b;
	}
}
}

