import sys

n = int(sys.stdin.readline().rstrip())
part_in_the_store = set(map(int, sys.stdin.readline().rstrip().split()))
m = int(sys.stdin.readline().rstrip())
looking_for_parts = list(map(int, sys.stdin.readline().rstrip().split()))

for i in looking_for_parts:
    if i in part_in_the_store:
        print('yes', end=" ")
    else:
        print('no', end=" ")
