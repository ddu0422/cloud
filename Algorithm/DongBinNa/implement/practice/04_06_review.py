def possible(answer):
    for x, y, a in answer:
        # 기둥일 경우
        if a == 0:
            # 바닥 위 or 보의 좌측 or 보의 우측 or 기둥 위
            if y == 0 or [x - 1, y, 1] in answer or [x, y, 1] in answer or [x, y - 1, 0] in answer:
                continue
            return False
        # 보일 경우
        elif a == 1:
            # 보의 좌측이 기둥 위 or 보의 우측이 기둥 위 or 보의 양쪽 끝쪽에 보가 있는 경우
            if [x, y - 1, 0] in answer or [x + 1, y - 1, 0] in answer or ([x - 1, y, 1] in answer and [x + 1, y, 1] in answer):
                continue
            return False

    return True


def solution(n, build_frame):
    answer = []

    for x, y, a, b in build_frame:
        if b == 0:
            answer.remove([x, y, a])
            if not possible(answer):
                answer.append([x, y, a])

        if b == 1:
            answer.append([x, y, a])
            if not possible(answer):
                answer.remove([x, y, a])

    return sorted(answer)
