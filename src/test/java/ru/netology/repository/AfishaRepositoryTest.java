package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository afishaRepository = new AfishaRepository();

    private MovieItem first = new MovieItem(1, "first", "http://github.com/1", 1);
    private MovieItem second = new MovieItem(2, "second", "http://github.com/2", 2);
    private MovieItem third = new MovieItem(3, "third", "http://github.com/3", 1);

    @BeforeEach
    public void setUp() {
        afishaRepository.save(first);
        afishaRepository.save(second);
        afishaRepository.save(third);
    }

    @Test
    public void shouldAdd() {
        MovieItem[] actual = afishaRepository.findAll();
        MovieItem[] expected = new MovieItem[]{first, second, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        int idToRemove = 2;
        afishaRepository.removeById(idToRemove);
        MovieItem[] actual = afishaRepository.findAll();
        MovieItem[] expected = new MovieItem[]{first, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdIfExists() {
        int findId = 2;
        MovieItem actual = afishaRepository.findById(findId);
        MovieItem expected = second;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdIfNotExists() {
        int findId = 4;
        MovieItem actual = afishaRepository.findById(findId);

        assertEquals(null, actual);
    }

    @Test
    public void shouldRemoveAll() {
        afishaRepository.removeAll();
        MovieItem[] actual = afishaRepository.findAll();
        MovieItem[] expected = new MovieItem[0];

        assertArrayEquals(expected, actual);
    }
}