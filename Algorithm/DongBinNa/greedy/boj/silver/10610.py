n = list(input())
n.sort(reverse=True)

answer = -1

if '0' in n:
    numbers = sum(map(int, n[:len(n) - 1]))

    if numbers % 3 == 0:
        answer = ''.join(n)

print(answer)
