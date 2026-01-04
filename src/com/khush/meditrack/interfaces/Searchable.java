package com.khush.meditrack.interfaces;

import java.util.List;

public interface Searchable<T> {

    List<T> searchById(int id);

    List<T> searchByName(String name);

    default boolean isValidSearch(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
