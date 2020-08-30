import sys

n = int(sys.stdin.readline().rstrip())
warehouse = list(map(int, sys.stdin.readline().rstrip().split()))
d = [0] * (n + 1)

# 점화식
# d[i] = max(d[i - 1], d[i - 2] + a[i])

d[1] = warehouse[0]

for i in range(2, n + 1):
    d[i] = max(d[i - 1], d[i - 2] + warehouse[i - 1])

print(d[n])
