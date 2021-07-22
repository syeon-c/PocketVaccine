package com.pocketvaccine.PocketVaccine.repository;

import com.pocketvaccine.PocketVaccine.domain.User;

import java.util.*;

public class MemoryUserRepository implements UserRepository {

    private static Map<String, User> database = new HashMap<>();

    @Override
    public User save(User user) {
        user.setId(user.getId());
        database.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(database.get(id));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(database.values());
    }
}
