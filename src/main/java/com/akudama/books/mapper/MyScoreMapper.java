package com.akudama.books.mapper;

import static com.akudama.books.domain.dto.ScoreDto.ScoreDtoBuilder.aScoreDtoBuilder;

import com.akudama.books.domain.dto.ScoreDto;
import com.akudama.books.domain.entity.MyScore;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class MyScoreMapper {

    public MyScore mapToMyScore(final ScoreDto scoreDto) {
        return new MyScore(
                scoreDto.getId(),
                scoreDto.getValue()
        );
    }

    public ScoreDto mapToMyScoreDto(final MyScore myScore) {
        return aScoreDtoBuilder()
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
