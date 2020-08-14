a, m, d, n = map(int, input().split())

result = int(((m ** (n - 1)) - 1) * d / (m - 1)) if m != 1 else (n - 1) * d

print(a * m ** (n - 1) + result)
