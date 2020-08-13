a = int(input())


def minus_or_plus(number):
    if number > 0:
        return "plus"

    return "minus"


def even_or_odd(number):
    if number % 2 == 0:
        return "even"

    return "odd"


print(minus_or_plus(a))
print(even_or_odd(a))
