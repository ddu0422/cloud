n, m = map(int, input().split())
weights = list(map(int, input().split()))

answer = 0

for i in range(n):
    for j in range(i, n):
        if weights[i] != weights[j]:
            answer += 1

print(answer)

"""
n, m = map(int, input().split())
weights = list(map(int, input().split()))

# 번호가 1 ~ 10까지이므로
count = [0] * 11 

for i in count:
    count[i] += 1

result = 0

# A가 선택한 무게  * B가 선택할 수 있는 무게의 수(나머지 무게의 수)
for i in weights:
    n -= count[i]  # 나머지 무게의 수
    result += count[i] * n

print(result)
"""
