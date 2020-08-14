n = int(input(), base=16)

for i in range(1, int("F", base=16) + 1):
    print("{0:X}*{1:X}={2:X}".format(n, i, n * i))
