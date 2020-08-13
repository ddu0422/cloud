a, b, c = map(int, input().split())

print(a < b and (a < c and a or c) or (b < c and b or c))
