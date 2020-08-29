import sys
from itertools import permutations
from collections import deque

n = int(sys.stdin.readline().rstrip())
numbers = list(sys.stdin.readline().rstrip().split())[:n]
operator_data = list(map(int, sys.stdin.readline().rstrip().split()))[:4]
operators = deque()
dic = {0: '+', 1: '-', 2: '*', 3: '//'}

for i in range(4):
    for _ in range(operator_data[i]):
        operators.append(dic[i])

min_value = 1e9 + 1
max_value = -1e9 - 1

for candidate in set(permutations(operators)):
    answer = '0'
    candidate = deque(candidate)
    candidate.appendleft('+')

    for i in range(n):
        answer = (
            '-' + str(eval('-' + answer + candidate[i] + numbers[i])) if int(answer) < 0 and candidate[i] == '//'
            else str(eval(answer + candidate[i] + numbers[i]))
        )

    max_value = max(max_value, int(answer))
    min_value = min(min_value, int(answer))

print(max_value)
print(min_value)
