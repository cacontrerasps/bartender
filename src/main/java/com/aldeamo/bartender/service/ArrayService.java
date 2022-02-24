package com.aldeamo.bartender.service;

import com.aldeamo.bartender.model.ArrayBarTender;
import com.aldeamo.bartender.repository.ArrayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ArrayService {
    @Autowired
    private ArrayRepository arrayRepository;

    public ArrayBarTender getArray(Integer id){
    try {
        return arrayRepository.findById(id).get();
    }catch(Exception ex){
        return null;
    }

    }
}
