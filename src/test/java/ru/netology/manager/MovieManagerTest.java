package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;
import ru.netology.manager.MovieManager;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {

    @Test
    public void getAllListLimitOverArrayTest() {
        MovieManager manager = new MovieManager();
        MovieItem first = new MovieItem(1, "first", "http://github.com/1", 1);
        MovieItem second = new MovieItem(2, "second", "http://github.com/2", 2);
        MovieItem third = new MovieItem(3, "third", "http://github.com/3", 1);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        MovieItem[] actual = manager.getAll(10);
        MovieItem[] expected = new MovieItem[]{third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getAllListLimitUnderArrayTest() {
        MovieManager manager = new MovieManager();
        MovieItem first = new MovieItem(1, "first", "http://github.com/1", 1);
        MovieItem second = new MovieItem(2, "second", "http://github.com/2", 2);
        MovieItem third = new MovieItem(3, "third", "http://github.com/3", 1);
        MovieItem fourth = new MovieItem(4, "fourth", "http://github.com/4", 1);
        MovieItem fifth = new MovieItem(5, "fifth", "http://github.com/5", 1);
        MovieItem sixth = new MovieItem(6, "sixth", "http://github.com/6", 1);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        MovieItem[] actual = manager.getAll(3);
        MovieItem[] expected = new MovieItem[]{sixth, fifth, fourth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getAllListLimitOver10ItemTest() {
        MovieManager manager = new MovieManager();
        MovieItem first = new MovieItem(1, "first", "http://github.com/1", 1);
        MovieItem second = new MovieItem(2, "second", "http://github.com/2", 2);
        MovieItem third = new MovieItem(3, "third", "http://github.com/3", 1);
        MovieItem fourth = new MovieItem(4, "fourth", "http://github.com/4", 1);
        MovieItem fifth = new MovieItem(5, "fifth", "http://github.com/5", 1);
        MovieItem sixth = new MovieItem(6, "sixth", "http://github.com/6", 1);
        MovieItem seventh = new MovieItem(7, "seventh", "http://github.com/7", 1);
        MovieItem eighth = new MovieItem(8, "eighth", "http://github.com/8", 1);
        MovieItem ninth = new MovieItem(9, "ninth", "http://github.com/9", 1);
        MovieItem tenth = new MovieItem(10, "tenth", "http://github.com/10", 1);
        MovieItem eleventh = new MovieItem(11, "eleventh", "http://github.com/11", 1);
        MovieItem twelfth = new MovieItem(12, "twelfth", "http://github.com/12", 1);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);

        MovieItem[] actual = manager.getAll(11);
        MovieItem[] expected = new MovieItem[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByMovieIdTest() {
        MovieManager manager = new MovieManager();
        int movieIdToRemove = 1;
        MovieItem first = new MovieItem(1, "first", "http://github.com/1", 1);
        MovieItem second = new MovieItem(2, "second", "http://github.com/2", 2);
        MovieItem third = new MovieItem(3, "third", "http://github.com/3", 1);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.removeByMovieId(movieIdToRemove);
        MovieItem[] actual = manager.getAll(3);
        MovieItem[] expected = new MovieItem[]{third, second};

        assertArrayEquals(expected, actual);
    }
}