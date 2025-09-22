// 제목 : 체육복
// 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/42862

// 세번째 답 제출 > 성공
class Solution {
    private var reserveMap: HashMap<Int, Int> = hashMapOf()

    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer =  n - lost.size
        reserve.sort()
        lost.sort()

        for(i in reserve) {
            if(i in lost) {
                // 본인이 분실
                increaseReserveMap(i)
            } else if(!reserveMap.containsKey(i-1) && i-1 in lost) {
                // 앞번호 친구가 분실
                increaseReserveMap(i-1)
            } else if(!reserveMap.containsKey(i+1) && i+1 in lost) {
                // 뒷번호 친구가 분실
                increaseReserveMap(i+1)
            }
        }
        // 체육복 빌린 친구 추가
        answer += reserveMap.size

        return answer
    }

    // 체육복 빌린 학생 reserveMap(HashMap)
    fun increaseReserveMap(key: Int) {
        if(reserveMap.containsKey(key)) {
            reserveMap[key] = reserveMap[key]!! + 1
        } else {
            reserveMap[key] = 1
        }
    }
}

// 두번째 답 제출 > 실패
// 오류1 : lost 배열을 -1로 초기화시 결과값 오차가 발생
// 수정1 : 체육복 빌린 결과를 -1로 초기화하던 코드 대신 lost 배열을 초기에 오름차순으로 정렬하여 사용하는것으로 변경
class Solution {
    private var reserveMap: HashMap<Int, Int> = hashMapOf()

    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer =  n - lost.size
        reserve.sort()

        for(i in reserve) {
            if(i in lost) {
                // 본인이 분실
                lost[lost.indexOf(i)] = -1
                increaseReserveMap(i)
            } else if(!reserveMap.containsKey(i-1) && i-1 in lost) {
                // 앞번호 친구가 분실
                lost[lost.indexOf(i-1)] = -1
                increaseReserveMap(i-1)
            } else if(!reserveMap.containsKey(i+1) && i+1 in lost) {
                // 뒷번호 친구가 분실
                lost[lost.indexOf(i+1)] = -1
                increaseReserveMap(i+1)
            }
        }
        // 체육복 빌린 친구 추가
        answer += reserveMap.size

        return answer
    }

    // 체육복 빌린 학생 reserveMap(HashMap)
    fun increaseReserveMap(key: Int) {
        if(reserveMap.containsKey(key)) {
            reserveMap[key] = reserveMap[key]!! + 1
        } else {
            reserveMap[key] = 1
        }
    }
}

// 첫번째 답 제출 > 실패
// 오류1 : 정렬되지 않은 reserve 배열을 받을 경우 결과값 차이 발생
// 수정1 : reserve 정렬 코드 추가
// 오류2 : lost 배열에서 체육복을 중복으로 빌리는 경우가 발생
// 수정2 : 이미 체육복을 빌린 경우 lost 값을 -1로 초기화
class Solution {
    private var reserveMap: HashMap<Int, Int> = hashMapOf()

    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer =  n - lost.size

        for(i in reserve) {
            if(i in lost) {
                // 본인이 분실
                increaseReserveMap(i)
            } else if(!reserveMap.containsKey(i-1) && i-1 in lost) {
                // 앞번호 친구가 분실
                increaseReserveMap(i-1)
            } else if(i+1 in lost) {
                // 뒷번호 친구가 분실
                increaseReserveMap(i+1)
            }
        }
        answer += reserveMap.size

        return answer
    }

    // 빌린 학생 reserveMap(HashMap)
    fun increaseReserveMap(key: Int) {
        if(reserveMap.containsKey(key)) {
            reserveMap[key] = reserveMap[key]!! + 1
        } else {
            reserveMap[key] = 1
        }
    }
}