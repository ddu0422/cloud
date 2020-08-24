array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]


def quick_sort(array, start, end):
    if start >= end:
        return

    pivot = start
    left = start + 1
    right = end

    # 엇갈릴 때까지 반복
    while left <= right:
        # 큰 데이터를 찾는다.
        while left <= end and array[left] <= array[pivot]:
            left += 1

        # 작은 데이터를 찾는다.
        while right > start and array[right] >= array[pivot]:
            right -= 1

        # 엇갈렸다면 작은 데이터와 피벗을 교체
        if left > right:
            array[pivot], array[right] = array[right], array[pivot]
        # 아니라면 큰 데이터와, 작은 데이터 교체
        else:
            array[left], array[right] = array[right], array[left]

    # right와 pivot을 교체 했기 때문에 현재 pivot의 위치는 right
    # start ------- right - 1 pivot[index = right] right + 1 ------- end
    quick_sort(array, start, right - 1)  # 왼쪽
    quick_sort(array, right + 1, end)    # 오른쪽


quick_sort(array, 0, len(array) - 1)
print(array)
