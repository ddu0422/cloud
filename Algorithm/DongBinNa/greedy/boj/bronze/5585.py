n = 1_000 - int(input())

coins = [500, 100, 50, 10, 5, 1]
answer = 0

for i in coins:
    answer += n // i
    n %= i

print(answer)
