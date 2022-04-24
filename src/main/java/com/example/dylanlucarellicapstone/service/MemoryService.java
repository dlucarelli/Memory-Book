package com.example.dylanlucarellicapstone.service;

import com.example.dylanlucarellicapstone.models.Memory;

import java.util.List;

public interface MemoryService {
    List<Memory> getAllMemories();

    void saveMemory(Memory memory);

    Memory getMemoryById(long id);

    Memory getMemoryByTitle(String title);

    void deleteMemoryById(long id);
}
