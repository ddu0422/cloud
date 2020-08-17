n, m, k = map(int, input().split())

group = 0

if n < 2 or m < 1:
    print(0)
else:
    group = min(n // 2, m)
    remain = n - group * 2 + m - group
    if remain < k:
        group -= (k - remain - 1) // 3 + 1

print(group)
