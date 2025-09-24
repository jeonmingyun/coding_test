// 제목 : 숫자 짝꿍
// 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/131128

// 두번째 답 제출 > 성공
// 처음 안 것 : char를 정수로 형변환시 char - '0' 사용
class Solution {
    fun solution(X: String, Y: String): String {
        var answer: String = ""
        // 각 숫자의 등장 횟수 카운트
        val countX = IntArray(10)
        val countY = IntArray(10)

        // ch - '0' -> 문자를 ASCII가 아닌 정수로 변환하는 방법
        for (ch in X) countX[ch - '0']++
        for (ch in Y) countY[ch - '0']++

        // 공통으로 등장하는 개수만큼 결과에 넣기
        val result = StringBuilder()
        for (i in 9 downTo 0) { // 큰 수부터 정렬 효과
            val common = minOf(countX[i], countY[i])
            repeat(common) { result.append(i) }
        }

        if (result.isEmpty()) {
            answer = "-1"
        } else if (result[0] == '0') {
            answer = "0"
        } else {
            answer = result.toString()
        }

        return answer
    }
}

// 첫번째 답 제출 > 실패
// 오류 : 실행 시간 초과 발생
// 이유 : 반복문안에 indexOf(), contains()등을 사용시 시간 복잡도가 O(n^2)으로 상승함
// 수정 : indexOf를 반복문 안에 사용하지 않도록 수정
class Solution {
    fun solution(X: String, Y: String): String {
        var answer: String = ""
        var xList: MutableList<Char> = X.toMutableList()
        var yList: MutableList<Char> = Y.toMutableList()
        var tempList: MutableList<Int> = mutableListOf()

        for((xIndex, xChar) in xList.withIndex()) {
            var yIndex = yList.indexOf(xChar)

            // 동일 데이터 존재시
            if(yIndex != -1) {
                tempList.add(xChar.digitToInt())
                yList.removeAt(yIndex)
            }

            // 비교 불가시
            if(yList.size <= 0) {
                break
            }
        }

        tempList.sortDescending()

        if(tempList.size <= 0 || tempList == null) {
            answer = "-1"
        } else if(tempList[0] == 0) {
            answer = "0"
        } else {
            answer = tempList.joinToString("")
        }

        return answer
    }
}