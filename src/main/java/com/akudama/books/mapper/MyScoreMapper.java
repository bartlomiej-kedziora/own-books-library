package com.akudama.books.mapper;

import com.akudama.books.domain.MyScore;
import com.akudama.books.domain.ScoreDto;

import java.util.List;
import java.util.stream.Collectors;

public class MyScoreMapper {
    public MyScore mapToMyScore(ScoreDto scoreDto) {
        return new MyScore(
                scoreDto.getId(),
                scoreDto.getValue()
        );
    }

    public ScoreDto mapToMyScoreDto(MyScore myScore) {
        return new ScoreDto(
                myScore.getId(),
                myScore.getValue()
        );
    }

    public List<ScoreDto> mapToMyScoreDtoList(List<MyScore> myScoreList) {
        return myScoreList.stream()
                .map(m -> new ScoreDto(
                        m.getId(),
                        m.getValue()))
                .collect(Collectors.toList());
    }
}
