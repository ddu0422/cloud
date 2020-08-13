list = [
    "even" if i % 2 == 0 else 'odd'
    for i in map(int, input().split())
]

for value in list:
    print(value)
