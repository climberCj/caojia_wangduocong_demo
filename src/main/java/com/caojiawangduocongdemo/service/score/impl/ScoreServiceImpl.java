package com.caojiawangduocongdemo.service.score.impl;

import com.caojiawangduocongdemo.dao.ScoreMapper;
import com.caojiawangduocongdemo.entity.Score;
import com.caojiawangduocongdemo.service.score.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author caojia
 * @time 下午 9:41
 */
@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public Score findLastScore(String studentid) {
        List<Score> list = scoreMapper.findLast(studentid);
        if(!CollectionUtils.isEmpty(list)){
            return list.get(0);
        }else{
            return null;
        }
    }
}
