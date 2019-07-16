package com.akudama.books.mapper;

import com.akudama.books.domain.Numbers;
import com.akudama.books.domain.dto.ScoreDto;
import com.akudama.books.domain.entity.WorldScore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorldScoreMapperTest {
    private WorldScore worldScore = new WorldScore(1L, 3);

    @Autowired
    private WorldScoreMapper WorldScoreMapper;

    @Test
    public void shouldMapToWorldScoreScore() {
        //Given
        ScoreDto worldScoreDto = ScoreDto.ScoreDtoBuilder.aScoreDtoBuilder()
                .withId(1L)
                .withValue(3)
                .build();

        //When
        WorldScore worldScore = WorldScoreMapper.mapToWorldScore(worldScoreDto);

        //Then
        assertEquals(Numbers.ONE, worldScore.getId());
        assertEquals(3, worldScore.getValue());
    }

    @Test
    public void shouldMapToWorldScoreDto() {
        //When
        ScoreDto worldScoreDto = WorldScoreMapper.mapToWorldScoreDto(worldScore);

        //Then
        assertEquals(Numbers.ONE, worldScoreDto.getId());
        assertEquals(3, worldScoreDto.getValue());
    }

    @Test
    public void shouldMapToWorldScoreDtoList() {
        //Given
        List<WorldScore> worldScores = Arrays.asList(worldScore);
        //When
        List<ScoreDto> worldScoreDtos = WorldScoreMapper.mapToWorldScoreDtoList(worldScores);

        //Then
        assertEquals(1, worldScoreDtos.size());
        assertEquals(Numbers.ONE, worldScoreDtos.get(0).getId());
        assertEquals(3, worldScoreDtos.get(0).getValue());
    }
}
