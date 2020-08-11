import sys

# 1. 4번
# 2. 2번
# 3. 실행결과 : 2

a = 0

if a:
    print("1")
else:
    print("2")

print('------')

# 4. for문을 이용하여 아래와 같이 출력

"""
*
**
***
****
*****
"""

for i in range(1, 6):
    for j in range(i):
        print("*", end="")
    print()

print('------')

# 5. for문을 이용하여 아래와 같이 출력
"""
*****
****
***
**
*
"""


for i in range(5, 0, -1):
    for j in range(i):
        print("*", end="")
    print()

print('------')

# 6. 4, 5번을 while문으로 변경

i = 1

while (i < 6):
    j = 0

    while (j < i):
        print("*", end="")
        j = j + 1
    print()
    i = i + 1

print('------')

i = 5

while (i > 0):
    j = 0
    while (j < i):
        print("*", end="")
        j = j + 1
    print()
    i = i - 1

# 별을 입력한 횟수만큼 출력

while True:
    print("반복횟수를 입력하세요 : ", end="")

    count = int(input())

    if (count <= 0):
        print("0보다 작거나 같은 수는 입력할 수 없습니다.")
        sys.exit(0)
    else:
        for i in range(count + 1):
            for j in range(i):
                print("*", end="")
            print()

    print()
