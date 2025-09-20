// 제목 : 둘만의 암호
// 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/155652

// 두번째 풀이
// 다른 사람들의 풀이를 참고하여 두번째 풀이 제작
class Solution {
    fun solution(s: String, skip: String, index: Int): String {
        var answer: String = ""
        var alphabetArr = ('a'..'z').filter{ it !in skip}

        for (char in s){
            answer += alphabetArr[(alphabetArr.indexOf(char) + index) % alphabetArr.size]
        }

        return answer
    }
}

// 첫번째 풀이
// 풀고 난 후 : 너무 어렵게 풀었다... 정답만 나오면 된다는 생각을 갖고 더 나은 방법을 고민하지 않고 그대로 풀었던게 문제의 요인
class Solution {
    fun solution(s: String, skip: String, index: Int): String {
        var answer: String = ""

        var alphabetArr = arrayOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z")

        // skip 문자 제거
        for(char in skip) {
            alphabetArr[alphabetArr.indexOf(char.toString())] = ""
        }

        // 알파벳 변경
        for(char in s) {
            var charIndex = alphabetArr.indexOf(char.toString())
            println(alphabetArr.joinToString())
            for(i in 0 until index) {
                charIndex = getSkipedChar(charIndex, alphabetArr)
            }
            answer += alphabetArr[charIndex]
        }

        return answer
    }

    // alphabetArr에서 한칸 이동 후 index값 반환
    fun getSkipedChar(index: Int, alphabetArr: Array<String>): Int {
        var skipedIndex = index

        // index +1
        if(skipedIndex == alphabetArr.size-1) { // 마지막 값
            skipedIndex = 0
        } else {
            skipedIndex += 1
        }

        // index 이동 후 skip 문자인지 검사
        return if(alphabetArr[skipedIndex] == "") {
            getSkipedChar(skipedIndex, alphabetArr) // 재귀 -> 한칸 추가 이동
        } else {
            skipedIndex
        }
    }

}