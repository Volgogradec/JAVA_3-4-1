package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.MovieItem;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {
    @Mock
    private AfishaRepository afishaRepository;
    @InjectMocks
    private AfishaManager afishaManager;
    private MovieItem first = new MovieItem(1, "first", "http://github.com/1", 1);
    private MovieItem second = new MovieItem(2, "second", "http://github.com/2", 2);
    private MovieItem third = new MovieItem(3, "third", "http://github.com/3", 1);
    private MovieItem fourth = new MovieItem(4, "fourth", "http://github.com/4", 1);

    @BeforeEach
    public void setUp() {
        afishaManager.add(first);
        afishaManager.add(second);
        afishaManager.add(third);
    }

    @Test
    public void shouldAdd() {
        afishaManager.add(fourth);
        // настройка заглушки
        MovieItem[] returned = new MovieItem[]{first, second, third, fourth};
        doReturn(returned).when(afishaRepository).findAll();

        MovieItem[] expected = new MovieItem[]{first, second, third, fourth};
        MovieItem[] actual = afishaRepository.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldGetAll() {
        // настройка заглушки
        MovieItem[] returned = new MovieItem[]{first, second, third};
        doReturn(returned).when(afishaRepository).findAll();

        MovieItem[] expected = new MovieItem[]{third, second, first};
        MovieItem[] actual = afishaManager.getAll();
        assertArrayEquals(expected, actual);

    }
}