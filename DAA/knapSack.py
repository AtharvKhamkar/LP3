def solve_knapsack():
    n=int(input("enter no of elements"))
    W=int(input("enter the capacity of knapsack"))
    wt=[]
    values=[]
    for i in range(1,n+1):
        z=int(input(f"enter weights of{i}-th element "))
        wt.append(z)
        z=int(input(f"enter Profit of{i}th element "))
        values.append(z)
        n=len(values) - 1
    def knapsack(W,n): # (Remaining Weight, Number of items checked)
        #base case
        if n<0 or W<=0:
            return 0
        
        #Higher weight than available
        if wt[n]>W:
            return knapsack(W, n-1)
        
        else:
            return max(values[n] + knapsack(W-wt[n],n-1),knapsack(W,n-1))
            # max(including , not including)
    print(knapsack(W,n))

solve_knapsack()