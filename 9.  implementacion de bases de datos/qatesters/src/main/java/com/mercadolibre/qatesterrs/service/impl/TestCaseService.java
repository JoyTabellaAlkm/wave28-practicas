package com.mercadolibre.qatesterrs.service.impl;

import com.mercadolibre.qatesterrs.dto.CreateUpdateTestCaseRequestDto;
import com.mercadolibre.qatesterrs.dto.DeleteTestCaseResponseDto;
import com.mercadolibre.qatesterrs.dto.FindTestCaseResponseDto;
import com.mercadolibre.qatesterrs.entity.TestCase;
import com.mercadolibre.qatesterrs.repository.ITestCaseRepository;
import com.mercadolibre.qatesterrs.service.ITestCaseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService {

	@Autowired
	private ITestCaseRepository testCaseRepository;

	@Override
	public List<FindTestCaseResponseDto> findAll(String lastUpdate) {
		ModelMapper mapper = new ModelMapper();

		List<FindTestCaseResponseDto> response = new ArrayList<>();
		List<TestCase> testsCases = testsCases = testCaseRepository.findAll();

		if (lastUpdate != null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate lastUpdatedDate = LocalDate.parse(lastUpdate, formatter);
			testsCases = testsCases.stream()
					.filter(tc -> tc.getLastUpdate().isAfter(lastUpdatedDate))
					.toList();
		}

		testsCases.forEach(tc -> {
			FindTestCaseResponseDto testCase = mapper.map(tc, FindTestCaseResponseDto.class);
			response.add(testCase);
		});

		return response;
	}

	@Override
	public FindTestCaseResponseDto findById(Long id) {
		ModelMapper mapper = new ModelMapper();
		TestCase finded = testCaseRepository.findById(id).orElse(null);

		return mapper.map(finded, FindTestCaseResponseDto.class);
	}

	@Override
	public FindTestCaseResponseDto save(CreateUpdateTestCaseRequestDto request) {
		ModelMapper mapper = new ModelMapper();
		TestCase toSave = mapper.map(request, TestCase.class);
		toSave.setLastUpdate(LocalDate.now());

		TestCase saved = testCaseRepository.save(toSave);
		return mapper.map(saved, FindTestCaseResponseDto.class);
	}

	@Override
	public FindTestCaseResponseDto update(Long id, CreateUpdateTestCaseRequestDto request) {
		ModelMapper mapper = new ModelMapper();
		TestCase finded = testCaseRepository.findById(id).orElse(null);
		TestCase toUpdate = mapper.map(request, TestCase.class);
		toUpdate.setId(id);
		toUpdate.setLastUpdate(LocalDate.now());

		TestCase updated = testCaseRepository.save(toUpdate);
		return mapper.map(updated, FindTestCaseResponseDto.class);
	}

	@Override
	public DeleteTestCaseResponseDto delete(Long id) {
		testCaseRepository.deleteById(id);
		return new DeleteTestCaseResponseDto("El test case con el id " + id + " ha sido eliminado.");
	}
}
