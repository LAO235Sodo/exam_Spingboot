package com.exam.serviceimpl;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.ExamManage;
import com.exam.mapper.ExamManageMapper;
import com.exam.service.ExamManageService;
import com.exam.service.FillQuestionService;
import com.exam.service.JudgeQuestionService;
import com.exam.service.MultiQuestionService;
import com.exam.vo.SubjectSumVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamManageServiceImpl implements ExamManageService {
    @Autowired
    private ExamManageMapper examManageMapper;
    @Autowired
    private FillQuestionService fillQuestionService;
    @Autowired
    private JudgeQuestionService judgeQuestionService;
    @Autowired
    private MultiQuestionService multiQuestionService;


    @Override
    public List<ExamManage> findAll() {
        return examManageMapper.findAll();
    }
    @Override
    public IPage<ExamManage> findAll(Page<ExamManage> page) {
        return examManageMapper.findAll(page);
    }

    @Override
    public ExamManage findById(Integer examCode) {
        return examManageMapper.findById(examCode);
    }

    @Override
    public int delete(Integer examCode) {
        return examManageMapper.delete(examCode);
    }

    @Override
    public int update(ExamManage exammanage) {
        return examManageMapper.update(exammanage);
    }

    @Override
    public int add(ExamManage exammanage) {
        return examManageMapper.add(exammanage);
    }

    @Override
    public ExamManage findOnlyPaperId() {
        return examManageMapper.findOnlyPaperId();
    }

    //根据题库名称返回对应的选择题，判断题，填空题数量
    @Override
    public SubjectSumVo findSumBySubject(String subject) {
        int fillNum=fillQuestionService.getSumBySubject(subject);
        int judgeNum=judgeQuestionService.getSumBySubject(subject);
        int multiNum=multiQuestionService.getSumBySubject(subject);
        return new SubjectSumVo(fillNum,judgeNum,multiNum);
    }

    @Override
    public JSONArray getAllTopics() {
        return null;
    }
}
