list = list(map(int, input().split()))


def reload(list, i):
    if list[i] == 0:
        return

    print(list[i])
    i = i + 1

    return reload(list, i)


reload(list, 0)
