import sys

n = int(sys.stdin.readline().rstrip())
part_in_the_store = [0] * 1000000

for i in sys.stdin.readline().rstrip().split():
    part_in_the_store[int(i)] += 1

m = int(sys.stdin.readline().rstrip())
looking_for_parts = list(map(int, sys.stdin.readline().rstrip().split()))[:m]


for i in looking_for_parts:
    if part_in_the_store[i] == 1:
        print('yes', end=" ")
    else:
        print('no', end=" ")
