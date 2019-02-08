package com.akudama.books.mapper;

import com.akudama.books.domain.entity.MyScore;
import com.akudama.books.domain.dto.ScoreDto;

import java.util.List;
import java.util.stream.Collectors;

public class MyScoreMapper {
    public MyScore mapToMyScore(final ScoreDto scoreDto) {
        return new MyScore(
                scoreDto.getId(),
                scoreDto.getValue()
        );
    }

    public ScoreDto mapToMyScoreDto(final MyScore myScore) {
        return new ScoreDto(
                myScore.getId(),
                myScore.getValue()
        );
    }

    public List<ScoreDto> mapToMyScoreDtoList(final List<MyScore> myScoreList) {
        return myScoreList.stream()
                .map(m -> new ScoreDto(
                        m.getId(),
                        m.getValue()))
                .collect(Collectors.toList());
    }
}
