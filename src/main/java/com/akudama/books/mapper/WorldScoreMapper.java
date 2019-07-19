package com.akudama.books.mapper;

import static com.akudama.books.domain.dto.ScoreDto.ScoreDtoBuilder.aScoreDtoBuilder;

import com.akudama.books.domain.dto.ScoreDto;
import com.akudama.books.domain.entity.WorldScore;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class WorldScoreMapper {

    public WorldScore mapToWorldScore(final ScoreDto scoreDto) {
        return new WorldScore(
                scoreDto.getId(),
                scoreDto.getValue()
        );
    }

    public ScoreDto mapToWorldScoreDto(final WorldScore myScore) {
        return aScoreDtoBuilder()
                .withId(myScore.getId())
                .withValue(myScore.getValue())
                .build();
    }

    public List<ScoreDto> mapToWorldScoreDtoList(final List<WorldScore> myScoreList) {
        return myScoreList.stream()
                .map(this::mapToWorldScoreDto)
                .collect(Collectors.toList());
    }
}
