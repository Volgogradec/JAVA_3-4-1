package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.MovieItem;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MovieManagerTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private MovieManager manager;
    private MovieItem first = new MovieItem(1, "first", "http://github.com/1", 1);
    private MovieItem second = new MovieItem(2, "second", "http://github.com/2", 2);
    private MovieItem third = new MovieItem(3, "third", "http://github.com/3", 1);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

//    @Test
//    public void getAllTest() {
//        // настройка заглушки
//        MovieItem[] returned = new MovieItem[]{first, second, third};
//        doReturn(returned).when(afishaRepository).findAll();
//
//        MovieItem[] expected = new MovieItem[]{third, second, first};
//        MovieItem[] actual = afishaManager.getAll();
//        assertArrayEquals(expected, actual);
//    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        // настройка заглушки
        MovieItem[] returned = new MovieItem[]{second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);
        MovieItem[] expected = new MovieItem[]{third, second};
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        // удостоверяемся, что заглушка была вызвана с нужным значением
        // но это уже проверка "внутренней" реализации
        verify(repository).removeById(idToRemove);
    }
}