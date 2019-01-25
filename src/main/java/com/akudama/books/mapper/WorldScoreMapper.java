package com.akudama.books.mapper;

import com.akudama.books.domain.WorldScore;
import com.akudama.books.domain.ScoreDto;

import java.util.List;
import java.util.stream.Collectors;

public class WorldScoreMapper {
    public WorldScore mapToMyScore(ScoreDto scoreDto) {
        return new WorldScore(
                scoreDto.getId(),
                scoreDto.getValue()
        );
    }

    public ScoreDto mapToWorldScoreDto(WorldScore myScore) {
        return new ScoreDto(
                myScore.getId(),
                myScore.getValue()
        );
    }

    public List<ScoreDto> mapToMyScoreDtoList(List<WorldScore> myScoreList) {
        return myScoreList.stream()
                .map(m -> new ScoreDto(
                        m.getId(),
                        m.getValue()))
                .collect(Collectors.toList());
    }
}
