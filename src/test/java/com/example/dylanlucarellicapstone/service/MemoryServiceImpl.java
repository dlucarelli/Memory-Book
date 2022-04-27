package com.example.dylanlucarellicapstone.service;

import com.example.dylanlucarellicapstone.models.Memory;
import com.example.dylanlucarellicapstone.repositories.MemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemoryServiceImpl implements MemoryService {

    private MemoryRepository memoryRepository;

    @Autowired
    public MemoryServiceImpl(MemoryRepository memoryRepository) {
        this.memoryRepository = memoryRepository;
    }

    @Override
    public List<Memory> getAllMemories() {
        return memoryRepository.findAll();
    }

    @Override
    public void saveMemory(Memory memory) {
        memoryRepository.save(memory);
    }

    @Override
    public Memory getMemoryById(long id) {
        Optional<Memory> memoryId = memoryRepository.findById(id);
        if (memoryId.isPresent()) {
            Memory memory = memoryId.get();
            return memory;
        }
        throw new MemoryNotFoundException();
    }

    @Override
    public Memory getMemoryByTitle(String title) {
        Memory memory = memoryRepository.findByTitle(title);
        if (title == null) {
            throw new MemoryNotFoundException();
        }
        return memory;
    }

    @Override
    public Memory getMemoryByDate(String date) {
        Memory memory = memoryRepository.findByDate(date);
        if (date == null) {
            throw new MemoryNotFoundException();
        }
        return memory;
    }

    @Override
    public void deleteMemoryById(long id) {
        memoryRepository.deleteById(id);
    }
}
