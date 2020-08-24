"""
삽입 정렬
1. 첫 번째는 정렬되어 있다고 가정
2. 다음 수부터 정렬된 수열을 탐색하여 자기 위치 찾기
"""

array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

# 오름차순 (내림차순은 if문의 부등호 방향만 바꿔주면 된다.)

# 첫번째는 정렬되어 있다고 가정
for i in range(1, len(array)):
    # 나부터 첫 원소(정렬되어 있는)원소까지 탐색
    for j in range(i, 0, -1):
        # 내가 더 작으면 나랑 자리 바꿔
        if array[j] < array[j - 1]:
            array[j], array[j - 1] = array[j - 1], array[j]
        # 내가 더 크거나 같으면 그 자리가 내 자리
        else:
            break

print(array)
