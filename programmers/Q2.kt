// 제목 : 대충 만든 자판
// 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/160586

class Solution {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        var sumValue = 0
        var compareValue = -1

        for(target in targets) {
            for(char in target){
                for(key in keymap) {
                    var valIndex = key.indexOf(char)

                    if(valIndex >= 0 && valIndex != null) {
                        if(compareValue == -1 || valIndex < compareValue) {
                            compareValue = valIndex
                        }
                    }
                }
                if(compareValue == -1) {
                    sumValue = compareValue
                    break;
                } else {
                    sumValue += compareValue+1
                }
                compareValue = -1
            }
            answer += sumValue
            sumValue = 0
        }

        return answer
    }
}