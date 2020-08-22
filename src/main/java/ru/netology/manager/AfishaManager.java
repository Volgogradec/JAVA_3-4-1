package ru.netology.manager;

import ru.netology.domain.MovieItem;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
    private AfishaRepository repository;
    private int afishaLength = 10;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public void add(MovieItem item) {
        repository.save(item);
    }

    public MovieItem[] getAll() {
        MovieItem[] items = repository.findAll();
        int resultLength = Math.min(afishaLength, items.length);
        MovieItem[] result = new MovieItem[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

}