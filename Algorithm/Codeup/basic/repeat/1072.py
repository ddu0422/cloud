n = int(input())
numbers = list(map(int, input().split()))


def reget(numbers, n, i):
    if i == n:
        return

    print(numbers[i])

    return reget(numbers, n, i + 1)


reget(numbers, n, 0)
