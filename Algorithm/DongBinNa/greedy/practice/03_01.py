n = int(input())
fear = list(map(int, input().split()))

fear.sort()

group = 0
personnel = 0

for i in fear:
    personnel += 1

    if personnel >= i:
        group += 1
        personnel = 0

print(group)
