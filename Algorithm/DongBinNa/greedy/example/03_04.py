n, k = map(int, input().split())

answer = 0

while True:
    next = (n // k) * k
    answer += n - next
    n = next

    if n < k:
        break

    answer += 1
    n //= k

answer += (n - 1)
print(answer)
