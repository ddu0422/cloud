# 선택 정렬
"""
[오름차순]
남은 수 중 가장 작은 수를 선택해서 맨 왼쪽으로 이동

[내림차순]
남은 수 중 가장 큰 수를 선택해서 맨 왼쪽으로 이동
"""

# 오름차순 (내림차순은 if문의 부등호 방향만 바꿔주면 된다.)
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(len(array)):
    # 왼쪽부터 차례대로
    min_index = i

    # 가장 작은 수를 찾는다.
    for j in range(i + 1, len(array)):
        if array[min_index] > array[j]:
            min_index = j

    # swap
    array[i], array[min_index] = array[min_index], array[i]

print(array)
