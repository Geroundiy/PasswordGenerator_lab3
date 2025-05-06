package com.example.passwordgenerator.cache;

import com.example.passwordgenerator.entity.Password;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class PasswordCache {

    private final Map<String, Object> cache = new HashMap<>();

    public Optional<List<Password>> getAllPasswords() {
        return Optional.ofNullable((List<Password>) cache.get("allPasswords"));
    }

    public void putAllPasswords(List<Password> passwords) {
        cache.put("allPasswords", passwords);
    }

    public Optional<Password> getPasswordById(Long id) {
        return Optional.ofNullable((Password) cache.get("password_" + id));
    }

    public void putPasswordById(Long id, Password password) {
        cache.put("password_" + id, password);
    }

    public Optional<List<Password>> getPasswordsByTag(String tagName) {
        return Optional.ofNullable((List<Password>) cache.get("tag_" + tagName));
    }

    public void putPasswordsByTag(String tagName, List<Password> passwords) {
        cache.put("tag_" + tagName, passwords);
    }

    public Optional<String> getGeneratedPassword(int length, int complexity) {
        String key = "generated_" + length + "_" + complexity;
        return Optional.ofNullable((String) cache.get(key));
    }

    public void putGeneratedPassword(int length, int complexity, String password) {
        String key = "generated_" + length + "_" + complexity;
        cache.put(key, password);
    }

    public void clearCache() {
        cache.clear();
    }
}