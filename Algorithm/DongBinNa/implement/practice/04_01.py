import sys

n = list(map(int, sys.stdin.readline().rstrip()))

left = 0
right = 0
mid = len(n) // 2

for i in range(len(n)):
    if i < mid:
        left += n[i]
    else:
        right += n[i]

if left == right:
    print("LUCKY")
else:
    print("READY")
