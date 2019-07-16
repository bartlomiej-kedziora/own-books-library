package com.akudama.books.mapper;

import com.akudama.books.domain.dto.ScoreDto;
import com.akudama.books.domain.entity.MyScore;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MyScoreMapper {
    public MyScore mapToMyScore(final ScoreDto scoreDto) {
        return new MyScore(
                scoreDto.getId(),
                scoreDto.getValue()
        );
    }

    public ScoreDto mapToMyScoreDto(final MyScore myScore) {
        return ScoreDto.ScoreDtoBuilder.aScoreDtoBuilder()
                .withId(myScore.getId())
                .withValue(myScore.getValue())
                .build();
    }

    public List<ScoreDto> mapToMyScoreDtoList(final List<MyScore> myScoreList) {
        return myScoreList.stream()
                .map(this::mapToMyScoreDto)
                .collect(Collectors.toList());
    }
}
