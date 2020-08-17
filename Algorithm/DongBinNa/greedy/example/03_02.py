n, m, k = map(int, input().split())
numbers = list(map(int, input().split()))[:n]

numbers.sort(reverse=True)
sum = 0
count = 0

for i in range(m):
    if count != 0 and count % k == 0:
        sum += numbers[1]
        count = 0
    else:
        sum += numbers[0]
        count += 1

print(sum)

"""
n, m, k = map(int, input().split())
numbers = list(map(int, input().split()))[:m]

numbers.sort()
first = numbers[n - 1]  # 가장 큰 수
second = numbers[n - 2]  # 다음 큰 수

# 큰 수의 개수
count = (m // (k + 1)) * k
count += m % (k + 1)


# 결과
answer = first * count
answer += second * (m - count)

print(answer)
"""
