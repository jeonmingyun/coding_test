// 제목 : 문자열 나누기
// 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/140108

class Solution {

    companion object {
        private const val INIT_CHAR_VALUE = ' '
        private const val INIT_INT_VALUE = 0
    }

    fun solution(s: String): Int {

        var answer: Int = 0
        var isSameValue: Int = INIT_INT_VALUE
        var isNotSameValue: Int = INIT_INT_VALUE
        var startChar: Char = INIT_CHAR_VALUE
        var charArr: CharArray = s.toCharArray()

        for(compareChar in charArr) {
            // startChar 시작 알파벳 초기화
            if(startChar == INIT_CHAR_VALUE || startChar == null) {
                startChar = compareChar
            }

            // 알파벳 비교 후 count
            if(startChar == compareChar) {
                isSameValue++
            } else {
                isNotSameValue++
            }

            // 한 사이클 끝 -> 모든 값 지움
            if(isSameValue == isNotSameValue) {
                answer++
                startChar = INIT_CHAR_VALUE
                isSameValue = INIT_INT_VALUE
                isNotSameValue = INIT_INT_VALUE
            }
        }

        // 한 사이클이 끝나지 않았는데 반복문 종료시
        if(startChar != INIT_CHAR_VALUE)
            answer++

        return answer
    }
}