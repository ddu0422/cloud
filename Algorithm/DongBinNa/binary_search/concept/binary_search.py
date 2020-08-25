# 재귀


def binary_search_recursive(array, target, start, end):
    # 원하는 값이 없는 경우
    if start > end:
        return

    # 중간점
    mid = (start + end) // 2

    # 원하는 값을 찾은 경우
    if target == array[mid]:
        return mid
    # 원하는 값이 중간 값보다 작은 경우 start ------ target ------- mid
    elif target < array[mid]:
        return binary_search_recursive(array, target, start, mid - 1)
    # 원하는 값이 중간 값보다 큰 경우 mid ------ target ------- end
    else:
        return binary_search_recursive(array, target, mid + 1, end)

# 반복문


def binary_search_iteration(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2

        if target == array[mid]:
            return mid
        elif target < array[mid]:
            end = mid - 1
        else:
            start = mid + 1

    return None


n, target = list(map(int, input().split()))
array = list(map(int, input().split()))

result = binary_search_recursive(array, target, 0, n - 1)
result1 = binary_search_iteration(array, target, 0, n - 1)

if result == None:
    print('원소 존재 x')
else:
    print(result + 1)
    print(result1 + 1)
