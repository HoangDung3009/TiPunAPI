package com.example.tipunapi.services.utilities;

import com.example.tipunapi.models.Utilities;
import com.example.tipunapi.repositories.UtilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilServiceImpl implements UtilService{

    @Autowired
    private UtilRepository utilRepository;
    @Override
    public List<Utilities> getAllUtils() {
        return utilRepository.findAll();
    }
}
