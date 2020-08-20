n = int(input())
peaks = list(map(int, input().split()))

answer = 0
count = 0
current = peaks[0]

for i in range(1, len(peaks)):
    if current > peaks[i]:
        count += 1
    else:
        count = 0
        current = peaks[i]

    answer = max(answer, count)

print(answer)
