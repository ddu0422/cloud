x, y, w, s = map(int, input().split())

# 가로, 세로로만 이동
cost1 = (x + y) * w

# 짝수이면 둘 다 0이므로 대각선만 이용
# 홀수이면 둘 다 1이므로 대각선으로 최대한 이동 후 가로, 세로로 이동

# cost2 = max(x, y) * s if (x + y) % 2 == 0 else (max(x, y) - 1) * s + w
cost2 = (x - (x + y) % 2) * s + (x + y) % 2 * w

# \ 대각선으로 최대한 많이 이동 후 가로, 세로로 이동
cost3 = min(x, y) * s + abs(x - y) * w

print(min(cost1, min(cost2, cost3)))
