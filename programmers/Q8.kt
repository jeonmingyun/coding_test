// 제목 : 크레인 인형뽑기 게임
// 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/64061

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        var answerList: MutableList<Int> = mutableListOf() // 뽑은 상품
        var boardSize = board.size // 뽑기 기계 가로&새로 길이

        for(move in moves) {
            for(depth in 0 until boardSize) {
                var productNum = board[depth][move-1]

                // 뽑기 성공
                if(productNum != 0) {
                    // 똑같은 상품 겹칠 시
                    if(answerList.size > 0 && answerList[answerList.size-1] == productNum) {
                        answerList.removeAt(answerList.size-1) // 상품 폭파!
                        answer += 2 // 인형 2개씩 폭파
                    } else {
                        answerList.add(productNum)
                    }
                    board[depth][move-1] = 0 // 뽑기 기꼐에서 상품 제거
                    break
                }
            }
        }

        return answer
    }
}