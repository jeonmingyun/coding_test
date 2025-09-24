// 제목 : 성격 유형 검사하기
// 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/118666

import kotlin.math.abs

class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer: String = ""
        var mbtiMap: HashMap<String, Int> = hashMapOf("R" to 0, "T" to 0,
            "C" to 0, "F" to 0,
            "J" to 0, "M" to 0,
            "A" to 0, "N" to 0)

        for((idx, char) in survey.withIndex()) {
            var mbtiChoice = choices[idx]
            var mbtiChar = if(mbtiChoice > 4) char[1].toString() else char[0].toString()
            var mbtiPoint: Int = abs(mbtiChoice - 4)
            println(mbtiMap)
            println(mbtiPoint)
            mbtiMap[mbtiChar] = (mbtiMap[mbtiChar]?:0) + mbtiPoint
        }

        answer += if(mbtiMap["R"]?:0 >= mbtiMap["T"]?:0) "R" else "T"
        answer += if(mbtiMap["C"]?:0 >= mbtiMap["F"]?:0) "C" else "F"
        answer += if(mbtiMap["J"]?:0 >= mbtiMap["M"]?:0) "J" else "M"
        answer += if(mbtiMap["A"]?:0 >= mbtiMap["N"]?:0) "A" else "N"

        return answer
    }
}
