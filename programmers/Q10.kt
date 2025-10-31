// 제목 : 바탕화면 정리
// 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/161990

// 세번째 제출 : 성공
// 오류 : 칼럼의 colStart, colEnd 변수에 이미 파일(#)이 있는데 startIdx, endIdx 값이 -1인 경우 오류 발생
// 수정1 : 칼럼 변수에 값 할당시 startIdx, endIdx 값 유무 확인 추가
// 수정2 : 코드 마지막에 빈값 초기화 하던 코드 삭제 -> 수정1번으로 대체 됨
class Solution {
    fun solution(wallpaper: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        var rowStart: Int = -1
        var rowEnd: Int = -1
        var colStart: Int = -1
        var colEnd: Int = -1

        var rowIdx = 0
        for(row in wallpaper) {
            // column
            var startIdx = row.indexOf('#')
            var endIdx = row.lastIndexOf('#')

            if(startIdx != -1) {
                if(colStart == -1 || colStart > startIdx) {
                    colStart = startIdx
                }
            }

            if(endIdx != -1) {
                if(colEnd == -1 || colEnd < endIdx) {
                    colEnd = endIdx
                }
            }

            // row
            var hasFile = row.contains('#')

            if(rowStart == -1 && hasFile) {
                rowStart = rowIdx
                rowEnd = rowIdx
            } else if(hasFile) {
                rowEnd = rowIdx
            }
            rowIdx++
        }

        answer = intArrayOf(rowStart, colStart, rowEnd +1, colEnd +1)

        return answer
    }
}

// 두번째 제출 : 실패 - 정답률 83.9%
// 수정 : 파일(#)이 없는 경우 초기화 추가
class Solution {
    fun solution(wallpaper: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        var rowStart: Int = -1
        var rowEnd: Int = -1
        var colStart: Int = -1
        var colEnd: Int = -1

        var rowIdx = 0
        for(row in wallpaper) {
            // column
            var startIdx = row.indexOf('#')
            var endIdx = row.lastIndexOf('#')

            if(colStart == -1 || colStart > startIdx) {
                colStart = startIdx
            }
            if(colEnd == -1 || colEnd < endIdx) {
                colEnd = endIdx
            }

            // row
            var hasFile = row.contains('#')

            if(rowStart == -1 && hasFile) {
                rowStart = rowIdx
                rowEnd = rowIdx
            } else if(hasFile) {
                rowEnd = rowIdx
            }
            rowIdx++
        }

        // no data
        if(rowStart == -1) rowStart = 0
        if(colStart == -1) colStart = 0
        if(rowEnd == -1) rowEnd = 0
        if(colEnd == -1) colEnd = 0

        answer = intArrayOf(rowStart, colStart, rowEnd +1, colEnd +1)

        return answer
    }
}

// 첫번째 제출 : 실패 - 정답률 77.4%
class Solution {
    fun solution(wallpaper: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        var rowStart: Int = -1
        var rowEnd: Int = -1
        var colStart: Int = -1
        var colEnd: Int = -1

        var rowIdx = 0
        for(row in wallpaper) {
            // column
            var startIdx = row.indexOf('#')
            var endIdx = row.lastIndexOf('#')

            if(colStart == -1 || colStart > startIdx) {
                colStart = startIdx
            }
            if(colEnd == -1 || colEnd < endIdx) {
                colEnd = endIdx
            }

            // row
            var hasFile = row.contains('#')

            if(rowStart == -1 && hasFile) {
                rowStart = rowIdx
                rowEnd = rowIdx
            } else if(hasFile) {
                rowEnd = rowIdx
            }
            rowIdx++
        }

        answer = intArrayOf(rowStart, colStart, rowEnd +1, colEnd +1)

        return answer
    }
}