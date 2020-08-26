# https://programmers.co.kr/learn/courses/30/lessons/60057

def solution(s):
    answer = len(s)

    for step in range(1, len(s) // 2 + 1):
        words = [s[i:i + step] for i in range(0, len(s), step)]
        result = []

        current_count = 1
        current_word = words[0]

        # 현재와 다음을 비교할 때 !!
        for x, y in zip(words, words[1:] + [""]):
            if x == y:
                current_count += 1
            else:
                result.append([current_count, current_word])
                current_count = 1
                current_word = y

        compress = ''.join(
            [
                word if count == 1 else str(count) + word for count, word in result
            ]
        )

        answer = min(answer, len(compress))

    return answer


print(solution('aabbaccc'))
