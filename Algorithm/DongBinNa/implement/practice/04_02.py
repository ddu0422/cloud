import sys

input_data = input()
text = []
number = []

for data in input_data:
    if data.isalpha():
        text.append(data)
    else:
        number.append(int(data))

text = sorted(text)
number = sorted(number)

for data in text:
    print(data, end="")

print(sum(number))
