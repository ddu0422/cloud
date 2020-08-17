n = int(input())

changes = [500, 100, 50, 10]
count = 0

for i in changes:
    count += n // i
    n %= i

print(count)
