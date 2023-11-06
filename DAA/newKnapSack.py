def KnapSacK(W, wt, val, n):
    K = [[0 for x in range(W+1)] for x in range(n+1)]

    for i in range(n+1):
        for w in range(W+1):
            if i == 0 or w == 0:
                K[i][w] = 0
            elif wt[i-1] <= w:
                K[i][w] = max(val[i-1]+K[i-1][w-wt[i-1]], K[i-1][w])
            else:
                K[i][w] = K[i-1][w]

        for i in range(n+1):
            for j in range(W+1):
                print(K[i][j], end=" ")
            print()

        return K[n][W]


if __name__ == '__main__':

    n = int(input("Enter the number of elements"))

    values = [0 for i in range(n)]
    weights = [0 for i in range(n)]

    print("Enter the profit of each element")
    for i in range(n):
        values[i] = int(input("Enter the value:"))

    print("Enter the weight of each element:")
    for i in range(n):
        weights[i] = int(input("Enter weight of the each element"))

    print()

    W = int(input("Enter the capacity:"))

    print()

    import time
    startTime = time.time()
    print("The optimal solution will be", KnapSacK(W, weights, values, n))
    endTime = time.time()

    print("The time required to execute program is", endTime - startTime)
