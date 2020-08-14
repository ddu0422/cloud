n, m, k = map(int, input().split())
numbers = list(map(int, input().split()))[:n]

numbers.sort(reverse=True)
sum = 0
count = 0

for i in range(m):
    if count != 0 and count % k == 0:
        sum += numbers[1]
        count = 0
    else:
        sum += numbers[0]
        count += 1

print(sum)
