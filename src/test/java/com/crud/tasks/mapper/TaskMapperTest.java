package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TaskMapperTest {

    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    public void mapToTaskTest() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "first task", "aaaaaaaa aaa");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(taskDto.getId(), task.getId());
        assertEquals(taskDto.getTitle(), task.getTitle());
        assertEquals(taskDto.getContent(), task.getContent());
    }

    @Test
    public void mapToTaskDtoTest() {
        //Given
        Task task = new Task(2L, "second task", "bbbb bbb");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(task.getId(), taskDto.getId());
        assertEquals(task.getTitle(), taskDto.getTitle());
        assertEquals(task.getContent(), taskDto.getContent());
    }

    @Test
    public void mapToTaskDtoListTest() {
        //Given
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(2L, "second task", "bbbb bbb"));

        //When
        List<TaskDto> taskDtos = taskMapper.mapToTaskDtoList(tasks);

        //Then
        assertEquals(tasks.get(0).getId(), taskDtos.get(0).getId());
        assertEquals(tasks.get(0).getTitle(), taskDtos.get(0).getTitle());
        assertEquals(tasks.get(0).getContent(), taskDtos.get(0).getContent());
    }
}