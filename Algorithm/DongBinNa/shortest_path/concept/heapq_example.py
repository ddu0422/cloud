import heapq

array = [2, 1, 5, 8, 4, 7, 3, 6, 0]


def heapsort_desc(iter):
    h = []
    result = []

    for value in iter:
        heapq.heappush(h, value)

    for _ in range(len(h)):
        result.append(heapq.heappop(h))

    return result


def heapsort_asc(iter):
    h = []
    result = []

    for value in iter:
        heapq.heappush(h, -value)

    for _ in range(len(h)):
        result.append(-heapq.heappop(h))

    return result


print(heapsort_desc(array))
print(heapsort_asc(array))
