import sys

n = int(sys.stdin.readline().rstrip())
part_in_the_store = list(map(int, sys.stdin.readline().rstrip().split()))[:n]
m = int(sys.stdin.readline().rstrip())
looking_for_parts = list(map(int, sys.stdin.readline().rstrip().split()))[:m]


# 퀵 정렬 + 이진 탐색

def quick_sort(array, start, end):
    if start >= end:
        return

    pivot = start
    left = start + 1
    right = end

    while left <= right:
        while left <= end and array[left] <= array[pivot]:
            left += 1

        while right > start and array[right] >= array[pivot]:
            right -= 1

        if left > right:
            array[pivot], array[right] = array[right], array[pivot]
        else:
            array[left], array[right] = array[right], array[left]

    quick_sort(array, start, right - 1)
    quick_sort(array, right + 1, end)


def binary_search_recursive(array, target, start, end):
    if start > end:
        return

    mid = (start + end) // 2

    if target == array[mid]:
        return mid
    elif target < array[mid]:
        return binary_search_recursive(array, target, start, mid - 1)
    else:
        return binary_search_recursive(array, target, mid + 1, end)


quick_sort(part_in_the_store, 0, n - 1)

for i in looking_for_parts:
    if binary_search_recursive(part_in_the_store, i, 0, n - 1):
        print("yes", end=" ")
    else:
        print("no", end=" ")
