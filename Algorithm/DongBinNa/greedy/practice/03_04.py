n = int(input())
numbers = list(map(int, input().split()))[:n]
total = sum(numbers)
natural_numbers = [False] * total

for i in range(n):
    temp = total
    for j in range(n):
        temp -= numbers[(i + j) % n]
        if 1 <= temp <= total:
            natural_numbers[temp - 1] = True

print(natural_numbers.index(False) + 1)

"""
n = int(input())
numbers = list(map(int, input().split()))[:n]

target = 1

for x in numbers:
    if target < x:
        break
    target += x

print(target)
"""
