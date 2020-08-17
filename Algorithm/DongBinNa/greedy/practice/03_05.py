n, m = map(int, input().split())
weights = list(map(int, input().split()))

answer = 0

for i in range(n):
    for j in range(i, n):
        if weights[i] != weights[j]:
            answer += 1

print(answer)
