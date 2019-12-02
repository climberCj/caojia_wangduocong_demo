package com.caojiawangduocongdemo.service.score;

import com.caojiawangduocongdemo.entity.Score;

/**
 * @author caojia
 * @time 下午 9:36
 */
public interface ScoreService {
    Score findLastScore(String studentid);
}
