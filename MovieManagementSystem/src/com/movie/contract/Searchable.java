package com.movie.contract;

import java.util.List;

public interface Searchable<T> {
    List<T> search(String query);
}
