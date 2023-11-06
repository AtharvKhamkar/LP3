def fractional_knapsack(weights, values, capacity):
    n = len(weights)
    ratios = [(values[i] / weights[i], weights[i]) for i in range(n)]
    ratios.sort(reverse=True, key=lambda x: x[0])

    total_value = 0
    remaining_capacity = capacity

    for ratio, weight in ratios:
        if remaining_capacity >= weight:
            total_value += ratio * weight
            remaining_capacity -= weight
        else:
            total_value += ratio * remaining_capacity
            break

    return total_value

# Example usage
n=int(input("enter no of elements"))
capacity=int(input("enter the capacity of knapsack"))
weights=[]
values=[]
for i in range(1,n+1):
    z=int(input(f"enter weights of{i}-th element "))
    weights.append(z)
    z=int(input(f"enter Profit of{i}th element "))
    values.append(z)

max_value = fractional_knapsack(weights, values, capacity)
print("Maximum value that can be obtained:", max_value)
