import java.util.*;

public class newFibbonacci{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number");
		int n = sc.nextInt();
		long inputTimeRec = System.nanoTime();
		int recAns = recFibbo(n);
		long outputTimeRec = System.nanoTime();
		long totalTimeRec = outputTimeRec - inputTimeRec;
		
		long inputTimeIter = System.nanoTime();
		int iterAns = iterFibbo(n);
		long outputTimeIter = System.nanoTime();
		long totalTimeIter = outputTimeIter - inputTimeIter;
		
		System.out.println("The nth number in the Fibonacci number is " + recAns);
		System.out.println("The total time taken by recursion is " + totalTimeRec + " nanoseconds");
		System.out.println("_______________________________________________________________________");
		System.out.println("The nth number in the Fibonacci number is " + iterAns);
		System.out.println("The total time taken by recursion is " + totalTimeIter + " nanoseconds");
		
		
	}
	
	
	public static int recFibbo(int n){
		if(n < 2){
			return n;
		}else{
			return recFibbo(n-1) + recFibbo(n-2);
		}
	}
	
	
	public static int iterFibbo(int n){
		if(n<2){
			return n;
		}else{
			int a=0,b=1;
			for(int i=2;i<=n;i++){
				int temp = a;
				a=b;
				b = temp + b;
			}
			return b;
		}
	}
}
	
