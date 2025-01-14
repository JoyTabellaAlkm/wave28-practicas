package com.mercadolibre.qatesterrs.service;

import com.mercadolibre.qatesterrs.dto.CreateUpdateTestCaseRequestDto;
import com.mercadolibre.qatesterrs.dto.DeleteTestCaseResponseDto;
import com.mercadolibre.qatesterrs.dto.FindTestCaseResponseDto;

import java.util.List;

public interface ITestCaseService {

	public List<FindTestCaseResponseDto> findAll(String lastUpdate);
	public FindTestCaseResponseDto findById(Long id);
	public FindTestCaseResponseDto save(CreateUpdateTestCaseRequestDto request);
	public FindTestCaseResponseDto update(Long id, CreateUpdateTestCaseRequestDto request);
	public DeleteTestCaseResponseDto delete(Long id);

}
