from math import gcd

a, b, c = map(int, input().split())

first_lcm = int(a * b / gcd(a, b))
second_lcm = int(first_lcm * c / gcd(first_lcm, c))

print(second_lcm)
