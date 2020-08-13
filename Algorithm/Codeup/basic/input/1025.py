a = input()

digit = 4

for i in a:
    i = int(i) * 10 ** digit
    print("[{0}]".format(i))
    digit -= 1
