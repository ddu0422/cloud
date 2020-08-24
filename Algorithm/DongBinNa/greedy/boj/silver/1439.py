s = input()

zero_count = 0
one_count = 0

for i in range(len(s) - 1):
    if s[i] != s[i + 1]:
        if s[i] == '0':
            zero_count += 1
        else:
            one_count += 1

if s[len(s) - 1] == '0':
    zero_count += 1
else:
    one_count += 1

print(min(zero_count, one_count))
