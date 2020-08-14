w, h, b = map(int, input().split())

print("{0:.2f} MB".format(w * h * b / (1 << 23)))
