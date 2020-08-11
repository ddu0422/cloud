# return 값이 존재 -> 해당 값을 반환

def my_abs(arg):
    if arg < 0:
        return arg * -1
    else:
        return arg


result = my_abs(5)
print(result)
print('-----')

# return 값이 존재하지 않음 -> None을 반환


def my_abs(arg):
    if arg < 0:
        return arg * -1
    elif arg > 0:
        return arg


result = my_abs(5)
print(result)
print('-----')
result = my_abs(0)
print(result)
print('-----')

# return을 이용한 함수 종료


def ogamdo(num):
    for i in range(1, num + 1):
        print('제 {0}의 아해'.format(i))
        if i == 5:
            return


ogamdo(3)
print('-----')
ogamdo(5)
print('-----')
ogamdo(8)
print('-----')
