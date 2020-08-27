# a 왼쪽 괄호, b 오른쪽 괄호
def balanced_text(text):
    a = b = 0

    for i in text:
        if i == '(':
            a += 1
        else:
            b += 1

        if a == b:
            break

    return a + b


# 올바른 문자열 확인
def collect_string(text):
    stack = []

    for c in text:
        if c == '(':
            stack.append(c)
        else:
            if len(stack):
                stack.pop()
            else:
                return False

    return len(stack) == 0


# 괄호 방향을 변경
def reverse_parentheses(text):
    temp = ''

    for i in text:
        if i == '(':
            temp += ')'
        else:
            temp += '('

    return temp


def go(text):
    # 빈 문자열 일 경우 빈 문자열 반환
    if len(text) == 0:
        return ''

    # 올바른 문자열일 경우 바로 반환
    if collect_string(text):
        return text

    temp = ''

    # 더 이상 쪼갤 수 없는 균형잡힌 문자열 u, 나머지 v
    result = balanced_text(text)
    u = text[:result]
    v = text[result:]

    # 올바른 문자열일 경우
    if collect_string(u):
        # u에 이어 붙이고
        temp += u
        # v를 1단계부터 다시 수행
        temp += go(v)

    # 올바르지 않은 문자열일 경우
    else:
        # '('를 추가
        temp += '('
        # 문자열 v에 대해 1단계부터 재귀
        temp += go(v)
        # ')'를 추가
        temp += ')'
        # u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 추가
        temp += reverse_parentheses(u[1:-1])

    # 생성된 문자열을 반환
    return temp


def solution(p):
    return go(p)
