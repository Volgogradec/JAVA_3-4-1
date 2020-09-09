package ru.netology.manager;

import ru.netology.domain.MovieItem;

public class MovieManager {
  private MovieItem[] items = new MovieItem[0];
  int defaultCount = 10;

  public void add(MovieItem item) {
    // создаём новый массив размером на единицу больше
    int length = items.length + 1;
    MovieItem[] tmp = new MovieItem[length];
    // itar + tab
    // копируем поэлементно
    // for (int i = 0; i < items.length; i++) {
    //   tmp[i] = items[i];
    // }
    System.arraycopy(items, 0, tmp, 0, items.length);
    // кладём последним наш элемент
    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = item;
    items = tmp;
  }

  public MovieItem[] getAll(int movieListLimit) {
    MovieItem[] result = new MovieItem[items.length];
    if (movieListLimit > defaultCount){
      movieListLimit = defaultCount;
    }
    if (movieListLimit > result.length){
      movieListLimit = result.length;
    }
    int movieListStart = result.length - movieListLimit;
    // перебираем массив в прямом порядке
    // но кладём в результаты в обратном
    for (int i = 0; i < movieListLimit; i++) {
      int index = items.length - i - 1;
      result[i] = items[index];
    }

    // Создаём новый массив для вывода результата
    MovieItem[] destArr = new MovieItem[movieListLimit];
    // Копируем элементы из исходного массива в результирующий
    System.arraycopy(result, 0, destArr, 0, movieListLimit);
    for (int i=0; i < movieListLimit; i++) {
      destArr[i] = result[i];
    }
    //    return result;
    return destArr;
  }

  // наивная реализация
  public void removeByMovieId(int id) {
    int length = items.length - 1;
    MovieItem[] tmp = new MovieItem[length];
    int index = 0;
    for (MovieItem item : items) {
      if (item.getMovieId() != id) {
        tmp[index] = item;
        index++;
      }
    }
    // меняем наши элементы
    items = tmp;
  }
}
