package com.ejercicio.QATester.service;

import com.ejercicio.QATester.entity.TestCase;
import com.ejercicio.QATester.repository.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CaseService implements iCaseService{

    @Autowired
    private CaseRepository caseRepo;

    @Override
    public List<TestCase> getAllTestCase() {
        return caseRepo.findAll();
    }

    @Override
    public TestCase getById(Long id) {
        return caseRepo.findById(id).orElse(null);
    }

    @Override
    public TestCase saveTestCase(TestCase tc) {
        tc.setLastUpdate(LocalDate.now());
        return caseRepo.save(tc);
    }

    @Override
    public TestCase updateTestCase(TestCase tc, Long id) {
        TestCase original = caseRepo.findByIdCase(id);

        original.setDescripcion(tc.getDescripcion());
        original.setTested(tc.isTested());
        original.setLastUpdate(LocalDate.now());
        original.setPassed(tc.isPassed());
        original.setNumberOfTries(tc.getNumberOfTries());

        return caseRepo.save(original);
    }

    @Override
    public String deleteTestCase(Long id) {
        caseRepo.deleteById(id);
        return "Objeto eliminado correctamente";
    }

    @Override
    public List<TestCase> findByDate(LocalDate fecha) {
        return caseRepo.findAllByLastUpdateAfter(fecha);
    }
}
