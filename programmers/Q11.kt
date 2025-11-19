// 제목 : 신규 아이디 추천
// 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/72410

// 첫번째 제출 : 성공
class Solution {
    fun solution(new_id: String): String {
        var answer: String = ""

        answer = new_id.lowercase() // 1단계
        answer = answer.replace(Regex("[^a-z0-9._-]"), "") // 2단계
        answer = answer.replace(Regex("\\.{2,}"), ".") // 3단계
        answer = answer.replace(Regex("^\\."), "").replace(Regex("\\.$"), "") // 4단계
        answer = answer.ifEmpty { "a" } // 5단계
        answer = if(answer.length >= 16) answer.substring(0, 15).replace(Regex("\\.$"), "") else answer // 6단계
        while(answer.length <= 2) answer += answer.last() // 7단계

        return answer
    }
}