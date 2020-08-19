n = int(input())
seats = input()

i = 0
answer = 1

while i < len(seats):
    if seats[i] == 'S':
        answer += 1
        i += 1
    else:
        answer += 1
        i += 2

print(min(len(seats), answer))
