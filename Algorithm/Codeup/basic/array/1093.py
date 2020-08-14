array = [0 for i in range(23)]

n = int(input())
counts = map(int, input().split())

for i in counts:
    array[i - 1] += 1

for i in array:
    print(i, end=" ")
