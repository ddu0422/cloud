charater = ord(input())
start = ord("a")

print(chr(start), end=" ")

while start < charater:
    start += 1
    print(chr(start), end=" ")
