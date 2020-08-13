month = int(input())

dict = {
    (12, 1, 2): "winter",
    (3, 4, 5): "spring",
    (6, 7, 8): "summer",
    (9, 10, 11): "fall"
}

for key in dict.keys():
    if month in key:
        print(dict.get(key))
