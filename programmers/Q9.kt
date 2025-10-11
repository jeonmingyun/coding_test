// 제목 : 키패드 누르기
// 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/67256

import kotlin.math.abs

class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        val leftBtn = arrayOf(1,4,7)
        val rightBtn = arrayOf(3,6,9)
        var answer = ""
        var right = 10 // 오른손 초기값 = *
        var left = 12 // 왼손 초기값 = #

        for(num in numbers) {
            // num 0값 초기화
            var numTemp = if(num == 0) 11 else num

            if(leftBtn.indexOf(numTemp) != -1) {
                answer += "L"
                left = numTemp
            } else if(rightBtn.indexOf(numTemp) != -1) {
                answer += "R"
                right = numTemp
            } else {
                var leftDis = 0 // 왼손으로부터 거리
                var rightDis = 0 // 오른손으로부터 거리

                if(numTemp == left) {
                    answer += "L"
                    left = numTemp
                } else if(numTemp == right) {
                    answer += "R"
                    right = numTemp
                } else {
                    leftDis = getBtnDistance(left, numTemp)
                    rightDis = getBtnDistance(right, numTemp)

                    if(leftDis < rightDis) {
                        answer += "L"
                        left = numTemp
                    } else if(leftDis > rightDis) {
                        answer += "R"
                        right = numTemp
                    } else if(leftDis == rightDis && hand == "left") {
                        answer += "L"
                        left = numTemp
                    } else if(leftDis == rightDis && hand == "right") {
                        answer += "R"
                        right = numTemp
                    }
                }
            }
        }

        return answer
    }

    // 두 인수 사이의 거리 리턴
    fun getBtnDistance(hand:Int, num:Int): Int {
        var cha = abs(num - hand)
        var distance = 0

        // 한칸 : 차가 1,3
        // 두칸 : 차가 2,4,6
        // 세칸 : 차가 5,7,9
        // 네칸 : 차가 8,10
        if(cha == 1 || cha == 3) {
            distance = 1
        } else if(cha == 2 || cha == 4 || cha == 6) {
            distance = 2
        } else if(cha == 5 || cha == 7 || cha == 9) {
            distance = 3
        } else if(cha == 8 || cha == 10) {
            distance = 4
        } else {
            distance = -1 // 예외발생
        }

        return distance
    }

}