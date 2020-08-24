n = int(input())
numbers = [int(input()) for _ in range(n)]

# 1. 내장 함수 활용


"""
numbers = sorted(numbers, reverse=True)

for number in numbers:
    print(number, end=" ")
"""

# 2. 선택 정렬


"""
for i in range(0, len(numbers)):
    max_index = i
    for j in range(i + 1, len(numbers)):
        if numbers[max_index] < numbers[j]:
            max_index = j

    numbers[i], numbers[max_index] = numbers[max_index], numbers[i]

for number in numbers:
    print(number, end=" ")
"""

# 3. 삽입 정렬


"""
for i in range(1, len(numbers)):
    for j in range(i, 0, -1):
        if numbers[j] > numbers[j - 1]:
            numbers[j], numbers[j - 1] = numbers[j - 1], numbers[j]
        else:
            break

for number in numbers:
    print(number, end=" ")
"""

# 4. 퀵 정렬


"""
def quick_sort(array, start, end):
    if start >= end:
        return

    pivot = start
    left = start + 1
    right = end

    while left <= right:
        while left <= end and array[left] >= array[pivot]:
            left += 1

        while right > start and array[right] <= array[pivot]:
            right -= 1

        if left > right:
            array[pivot], array[right] = array[right], array[pivot]
        else:
            array[left], array[right] = array[right], array[left]

    quick_sort(array, start, right - 1)
    quick_sort(array, right + 1, end)


quick_sort(numbers, 0, len(numbers) - 1)

for number in numbers:
    print(number, end=" ")
"""
