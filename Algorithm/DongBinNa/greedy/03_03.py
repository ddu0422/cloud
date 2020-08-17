n, m = map(int, input().split())
matrix = max([min(list(map(int, input().split()))[:m]) for _ in range(n)])

print(matrix)
