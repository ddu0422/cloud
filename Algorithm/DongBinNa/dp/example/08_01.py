import sys

n = int(sys.stdin.readline().rstrip())
d1 = [0] * (n + 1)
d2 = [0] * (n + 1)

# 점화식
# d[n] = min(d[n - 1], d[n // 2], d[n // 3], d[n // 5]) + 1

# top - down


def go(n):
    if n < 2:
        return 0

    if d1[n]:
        return d1[n]

    d1[n] = go(n - 1) + 1

    if n % 2 == 0:
        d1[n] = min(d1[n], go(n // 2) + 1)

    if n % 3 == 0:
        d1[n] = min(d1[n], go(n // 3) + 1)

    if n % 5 == 0:
        d1[n] = min(d1[n], go(n // 5) + 1)

    return d1[n]


# bottom - up
for i in range(2, n + 1):
    d2[i] = d2[i - 1] + 1

    if i % 2 == 0:
        d2[i] = min(d2[i], d2[i // 2] + 1)

    if i % 3 == 0:
        d2[i] = min(d2[i], d2[i // 3] + 1)

    if i % 5 == 0:
        d2[i] = min(d2[i], d2[i // 5] + 1)


go(n)
print(d1[i], d2[i])
