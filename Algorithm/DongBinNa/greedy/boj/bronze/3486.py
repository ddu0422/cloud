n = int(input())

for i in range(n):
    first, second = input().split()
    sum = int(first[::-1]) + int(second[::-1])
    print(int(str(sum)[::-1]))
