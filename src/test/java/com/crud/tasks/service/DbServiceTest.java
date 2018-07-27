package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTest {

    @InjectMocks
    private DbService dbService;

    @Mock
    private TaskRepository taskRepository;


    @Test
    public void getAllTasksTest() {
        //Given
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1L, "task", "content"));
        tasks.add(new Task(2L, "task 2", "content 2"));
        when(taskRepository.findAll()).thenReturn(tasks);

        //When
        List<Task> tasksList = dbService.getAllTasks();

        //Then
        assertEquals(2, tasksList.size());
    }

    @Test
    public void getTaskTest() {
        //Given
        Optional<Task> task = Optional.of(new Task(1L, "task", "content"));
        when(taskRepository.findById(1L)).thenReturn(task);

        //When
        Optional<Task> foundedTask = dbService.getTask(1L);

        //Then
        assertTrue(foundedTask.isPresent());
        assertEquals(task, foundedTask);
    }

    @Test
    public void saveTask() {
        //Given
        Task task = new Task(1L, "task", "content");
        when(dbService.saveTask(task)).thenReturn(task);

        //When
        Task savedTask = dbService.saveTask(task);

        //Then
        assertEquals(task.getId(), savedTask.getId());
        assertEquals(task.getTitle(), savedTask.getTitle());
        assertEquals(task.getContent(), savedTask.getContent());
    }

    @Test
    public void deleteTask() {
        //Given
        //When
        dbService.deleteTask(1L);

        //Then
        verify(taskRepository, times(1)).deleteById(1L);

    }
}