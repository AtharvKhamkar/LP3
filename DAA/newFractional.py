def fractional_knapsack(weights, values, capacity):
    n = len(weights)
    ratios = [(values[i]/weights[i], weights[i]) for i in range(n)]
    ratios.sort(reverse =True, key=lambda x: x[0])

    total_value = 0
    remaining_capacity = capacity

    for ratio, weight in ratios:
        if remaining_capacity >= weight:
            total_value += ratio * weight
            remaining_capacity -= weight
        else:
            total_value += ratio*remaining_capacity

    return total_value


n = int(input("Enter the total number of elements"))
capacity = int(input("Enter the capacity"))

weights = []
values = []

for i in range(1, n+1):
    z = int(input(f"Enter the  weight of the {i}th element"))
    weights.append(z)
    z = int(input(f"Enter the values of the {i}th element"))
    values.append(z)

max_value = fractional_knapsack(weights, values, capacity)
print("Maximum value can be obtained is", max_value)
