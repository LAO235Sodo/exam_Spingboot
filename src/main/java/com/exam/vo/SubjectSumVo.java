package com.exam.vo;

import lombok.Data;

//题库的各类题目数量
@Data
public class SubjectSumVo {
    private int fillNum;//填空题数
    private int judgeNum;//判断题数
    private int multiNum;//选择题数

    public SubjectSumVo() {

    }

    public SubjectSumVo(int fillNum, int judgeNum, int multiNum) {
        this.fillNum = fillNum;
        this.judgeNum = judgeNum;
        this.multiNum = multiNum;
    }
}
