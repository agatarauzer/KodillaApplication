package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTest {

    @InjectMocks
    TrelloMapper trelloMapper;


    @Test
    public void mapToBoardsTest() {
        //Given
        List<TrelloBoardDto> boardsDtoTestList = new ArrayList<>();
        boardsDtoTestList.add(new TrelloBoardDto("1", "test board dto 1", new ArrayList<>()));

        //When
        List<TrelloBoard> boardsTestList = trelloMapper.mapToBoards(boardsDtoTestList);

        //Then
        assertEquals(boardsDtoTestList.get(0).getId(), boardsTestList.get(0).getId());
        assertEquals(boardsDtoTestList.get(0).getName(), boardsTestList.get(0).getName());
    }

    @Test
    public void mapToBoardsDtoTest() {
        //Given
        List<TrelloBoard> boardsTestList = new ArrayList<>();
        boardsTestList.add(new TrelloBoard("1", "test board 1", new ArrayList<>()));

        //When
        List<TrelloBoardDto> boardDtoList = trelloMapper.mapToBoardsDto(boardsTestList);

        //Then
        assertEquals(boardsTestList.get(0).getId(), boardDtoList.get(0).getId());
        assertEquals(boardsTestList.get(0).getName(), boardDtoList.get(0).getName());
    }


    @Test
    public void mapToListTest() {
        //Given
        List<TrelloListDto> testListsDto = new ArrayList<>();
        testListsDto.add(new TrelloListDto("1", "test list 1", false));

        //When
        List<TrelloList> testLists = trelloMapper.mapToList(testListsDto);

        //Then
        assertEquals(testListsDto.get(0).getId(), testLists.get(0).getId());
        assertEquals(testListsDto.get(0).getName(), testLists.get(0).getName());
        assertEquals(testListsDto.get(0).isClosed(), testLists.get(0).isClosed());
    }

    @Test
    public void mapToListDtoTest() {
        //Given
        List<TrelloList> testLists = new ArrayList<>();
        testLists.add(new TrelloList("1", "test list 1", false));

        //When
        List<TrelloListDto> testListsDto = trelloMapper.mapToListDto(testLists);

        //Then
        assertEquals(testLists.get(0).getId(), testListsDto.get(0).getId());
        assertEquals(testLists.get(0).getName(), testListsDto.get(0).getName());
        assertEquals(testLists.get(0).isClosed(), testListsDto.get(0).isClosed());
    }

    @Test
    public void mapToCardDtoTest() {
        //Given
        TrelloCard testCard = new TrelloCard("test card 1", "aaaaa", "aa", "1");

        //When
        TrelloCardDto testCardDto = trelloMapper.mapToCardDto(testCard);

        //Then
        assertEquals(testCard.getName(), testCardDto.getName());
        assertEquals(testCard.getDescription(), testCardDto.getDescription());
        assertEquals(testCard.getPos(), testCardDto.getPos());
    }

    @Test
    public void mapToCardTest() {
        //Given
        TrelloCardDto testCardDto = new TrelloCardDto("test card dto 1", "bbbbb", "bb", "1");

        //When
        TrelloCard testCard = trelloMapper.mapToCard(testCardDto);

        //Then
        assertEquals(testCardDto.getName(), testCard.getName());
        assertEquals(testCardDto.getDescription(), testCard.getDescription());
        assertEquals(testCardDto.getPos(), testCard.getPos());
    }
}