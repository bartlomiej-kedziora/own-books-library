package com.akudama.books.mapper;

import com.akudama.books.domain.entity.WorldScore;
import com.akudama.books.domain.dto.ScoreDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WorldScoreMapper {
    public WorldScore mapToWorldScore(final ScoreDto scoreDto) {
        return new WorldScore(
                scoreDto.getId(),
                scoreDto.getValue()
        );
    }

    public ScoreDto mapToWorldScoreDto(final WorldScore myScore) {
        return new ScoreDto(
                myScore.getId(),
                myScore.getValue()
        );
    }

    public List<ScoreDto> mapToWorldScoreDtoList(final List<WorldScore> myScoreList) {
        return myScoreList.stream()
                .map(m -> new ScoreDto(
                        m.getId(),
                        m.getValue()))
                .collect(Collectors.toList());
    }
}
