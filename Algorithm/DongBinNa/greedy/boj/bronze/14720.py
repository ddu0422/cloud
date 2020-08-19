n = int(input())
stores = list(map(int, input().split()))

current = 0
answer = 0

for i in stores:
    if current == i:
        answer += 1
        current = (current + 1) % 3

print(answer)
