def hello():
    print("hello world!")


hello()


def my_abs(arg):
    if (arg < 0):
        result = arg * -1
    else:
        result = arg

    return result


print(my_abs(-5))
print(my_abs(10))
