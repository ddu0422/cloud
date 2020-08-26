def solution(s):
    answer = -1
    slice = 1

    while slice <= len(s):
        # 초기화
        numbers = []
        text = []

        # slice
        for i in range(0, len(s), slice):
            letter = s[i:i + slice]
            text.append(letter)

        # 각 문자의 개수
        total = 1

        for i in range(len(text) - 1):
            if text[i] == text[i + 1]:
                total += 1
            else:
                numbers.append(total)
                total = 1

        numbers.append(total)  # else가 아니거나 마지막인 경우

        # 문자 구하기
        i = 0
        index = 0
        temp = ''

        while i < len(text):
            if numbers[index] == 1:
                temp += text[i]
            else:
                temp += str(numbers[index]) + text[i]

            i += numbers[index]
            index += 1

        # 최소 길이 판단
        if answer == -1 or answer > len(temp):
            answer = len(temp)

        # 자르는 길이 증가
        slice += 1

    return answer
