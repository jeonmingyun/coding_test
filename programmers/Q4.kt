// 제목 : 로또의 최고 순위와 최저 순위
// 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/77484

class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        var count: Int = 0 // 맞춘 번호 수
        var countZero: Int = lottos.count { it == 0 }

        // init count
        for(i in lottos) {
            if(win_nums.indexOf(i) != -1) {
                count++
            }
        }

        answer += getRank(count + countZero) // 최고 등수
        answer += getRank(count) // 최저 등수

        return answer
    }

    // 현재 랭크 값 반환
    fun getRank(count: Int): Int {
        var rankArr: IntArray = intArrayOf(6,5,4,3,2) // index++ = 로또 순위
        var rank = rankArr.indexOf(count)

        if(rank >= 0) {
            rank += 1
        } else {
            rank = 6
        }

        return rank
    }
}