s = input()

answer = int(s[0])

for i in s[1:]:
    value = int(i)

    if value <= 1 or answer <= 1:
        answer += value
    else:
        answer *= value

print(answer)
