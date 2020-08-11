import math

# 변수의 유효 범위

# python은 모든 변수를 지역 변수로 간주
# 전역 변수는 global 키워드를 사용


def scope_test():
    a = 1
    print('a : {0}'.format(a))


a = 0
scope_test()
print('a : {0}'.format(a))
print('-----')


def scope_test():
    global a
    a = 2
    print('a : {0}'.format(a))


a = 0
scope_test()
print('a : {0}'.format(a))
print('-----')

# 재귀 함수

# 호출 비용이 크다.
# 재귀 함수를 반복문으로 대체하는 것이 낫다.
# 재귀 함수가 종료될 조건을 만들어줘야한다.


def some_func(count):
    if count > 0:
        some_func(count - 1)
    print(count)


some_func(5)
print('-----')


def factorial(n):
    if n == 0:
        return 1
    else:
        return factorial(n - 1) * n


print(factorial(5))
print('-----')


def factorial(n):
    result = 1

    while n > 0:
        result = result * n
        n = n - 1

    return result


print(factorial(5))
print('-----')

# 함수를 변수에 담아 사용하기

# 파이썬에서 함수는 일급 객체 (First Class Object) => 값으로 사용할 수 있다.


def print_something(a):
    print(a)


p = print_something
p(123)
print('-----')


def plus(a, b):
    return a + b


def minus(a, b):
    return a - b


first = [plus, minus]
print(first[0](1, 2))
print(first[1](1, 2))
print('-----')

# Vitamin Quiz
# plus()와 minus() 함수를 딗겨너리에 넣어 호출

dic = {}
dic['plus'] = plus
dic['minus'] = minus


print(dic.get('plus')(1, 2))
print(dic.get('minus')(1, 2))
print('-----')


def hello_korean():
    print('안녕하세요.')


def hello_english():
    print('Hello.')


def greet(hello):
    hello()


greet(hello_korean)
greet(hello_english)
print('-----')


def get_greeting(where):
    if where == 'K':
        return hello_korean
    else:
        return hello_english


hello = get_greeting('K')
hello()
print('-----')

hello = get_greeting('E')
hello()
print('-----')

# 함수 안의 함수 (중첩 함수)


def stddev(*args):
    def mean():
        return sum(args) / len(args)

    def variance(m):
        total = 0
        for arg in args:
            total += (arg - m) ** 2
        return total / (len(args) - 1)

    v = variance(mean())

    return math.sqrt(v)


print(stddev(2.3, 1.7, 1.4, 0.7, 1.9))
print('-----')


def print_star(count):
    for i in range(count, 0, -1):
        for j in range(i):
            print("*", end="")
        print()


print_star(5)
