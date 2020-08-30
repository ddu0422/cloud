import sys

INF = 987654321

n, m = map(int, sys.stdin.readline().rstrip().split())
coins = []
d = [INF] * (m + 1)

for i in range(n):
    coins.append(int(sys.stdin.readline().rstrip()))

for k in coins:
    d[k] = 1

# 방법 1
d[0] = 0

for k in coins:
    for i in range(k, m + 1):
        if d[i - k] != INF:
            d[i] = min(d[i], d[i - k] + 1)

# 방법 2
for i in range(m + 1):
    for k in coins:
        if i < k:
            continue
        d[i] = min(d[i], d[i - k] + 1)


if d[i] == INF:
    print(-1)
else:
    print(d[i])
