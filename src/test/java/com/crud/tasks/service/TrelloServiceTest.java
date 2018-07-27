package com.crud.tasks.service;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTest {

    @InjectMocks
    private TrelloService trelloService;

    @Mock
    private TrelloClient trelloClient;


    @Test
    public void shouldFetchTrelloBoards() {
        //Given
        List<TrelloListDto> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloListDto("1", "Test List", false));

        List<TrelloBoardDto> boardDtos = new ArrayList<>();
        boardDtos.add(new TrelloBoardDto("1", "Test Task", trelloLists));

        when(trelloClient.getTrelloBoards()).thenReturn(boardDtos);

        //When
        List<TrelloBoardDto> fetchedBoards = trelloService.fetchTrelloBoards();

        //Then
        assertNotNull(fetchedBoards);
        assertEquals(boardDtos.get(0).getId(), fetchedBoards.get(0).getId());
        assertEquals(boardDtos.get(0).getName(), fetchedBoards.get(0).getName());
        assertEquals(boardDtos.get(0).getLists(), fetchedBoards.get(0).getLists());
    }
}