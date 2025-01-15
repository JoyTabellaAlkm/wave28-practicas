package com.example.seguros_api.service.impl;

import com.example.seguros_api.repository.SiniestroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiniestroServiceImpl {
    @Autowired
    private SiniestroRepository siniestroRepository;
}
