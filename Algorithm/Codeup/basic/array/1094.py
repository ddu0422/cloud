n = int(input())
list = list(map(int, input().split()))

list.reverse()

for i in list:
    print(i, end=" ")
