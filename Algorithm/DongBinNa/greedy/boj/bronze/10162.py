t = int(input())

times = [300, 60, 10]
counts = [0] * len(times)

for i in range(len(times)):
    counts[i] += t // times[i]
    t %= times[i]

if t == 0:
    for count in counts:
        print(count, end=" ")
else:
    print(-1)
