package com.akudama.books.mapper;

import com.akudama.books.domain.Numbers;
import com.akudama.books.domain.dto.ScoreDto;
import com.akudama.books.domain.entity.MyScore;
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
public class MyScoreMapperTest {
    private MyScore myScore = new MyScore(1L, 5);

    @Autowired
    private MyScoreMapper myScoreMapper;

    @Test
    public void shouldMapToMyScore() {
        //Given
        ScoreDto myScoreDto = new ScoreDto(1L, 5);

        //When
        MyScore myScore = myScoreMapper.mapToMyScore(myScoreDto);

        //Then
        assertEquals(Numbers.ONE, myScore.getId());
        assertEquals(5, myScore.getValue());
    }

    @Test
    public void shouldMapToMyScoreDto() {
        //When
        ScoreDto myScoreDto = myScoreMapper.mapToMyScoreDto(myScore);

        //Then
        assertEquals(Numbers.ONE, myScoreDto.getId());
        assertEquals(5, myScoreDto.getValue());
    }

    @Test
    public void shouldMapToMyScoreDtoList() {
        //Given
        List<MyScore> myScores = Arrays.asList(myScore);
        //When
        List<ScoreDto> myScoreDtos = myScoreMapper.mapToMyScoreDtoList(myScores);

        //Then
        assertEquals(1, myScoreDtos.size());
        assertEquals(Numbers.ONE, myScoreDtos.get(0).getId());
        assertEquals(5, myScoreDtos.get(0).getValue());
    }
}
