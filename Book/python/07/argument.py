def print_string(text, count):
    for i in range(count):
        print(text)


print_string('안녕하세요', 3)
print('-----')

# 기본값 매개변수


def print_string(text, count=1):
    for i in range(count):
        print(text)


print_string('안녕하세요')
print('-----')
print_string('안녕하세요', 2)
print('-----')

# 키워드 매개변수


def print_personnel(name, position='staff', nationality='Korea'):
    print('name = {0}'.format(name))
    print('position = {0}'.format(position))
    print('nationality = {0}'.format(nationality))


print_personnel(name='이두호')
print('-----')
print_personnel(name='이두호', nationality='ROK')
print('-----')
print_personnel(name='이두호', position='신입')
print('-----')

# 가변 매개변수

# *를 이용한 가변 매개변수는 튜플
# **를 이용한 가변 매개변수는 딕셔너리


def merge_string(*text_list):
    result = ''
    for s in text_list:
        result = result + s
    return result


print(merge_string('나는', '공부한다', '파이썬'))
print('-----')


def print_team(**machine):
    for k in machine.keys():
        print('{0} = {1}'.format(k, machine[k]))


print_team(노트북='2017 macbook 13 inch', 태블릿='ipad mini', 스마트폰='iphone11')
