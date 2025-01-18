package co.mercadolibre.qatesters.service;

import co.mercadolibre.qatesters.dto.DeleteResponseDto;
import co.mercadolibre.qatesters.dto.TestCaseDto;
import co.mercadolibre.qatesters.exception.NotFoundException;
import co.mercadolibre.qatesters.model.TestCase;
import co.mercadolibre.qatesters.repository.ITestRepository;
import co.mercadolibre.qatesters.util.MapperConfig;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseServiceImpl implements ITestCaseService{

    @Autowired
    ITestRepository testRepository;

    private final ModelMapper modelMapper;

    public TestCaseServiceImpl() {
        this.modelMapper = MapperConfig.getModelMapper();
    }

    @Override
    public TestCaseDto newTest(TestCaseDto testCaseDto) {
        return modelMapper.map(
                testRepository.save(modelMapper.map(
                        testCaseDto, TestCase.class)), TestCaseDto.class);
    }

    @Override
    public List<TestCaseDto> getAllTest(LocalDate lastUpdate) {
        if(lastUpdate != null) return getAllTestByDate(lastUpdate);
        return testRepository.findAll().stream().map(
                testCase -> modelMapper.map(testCase, TestCaseDto.class)).toList();
    }

    @Override
    public TestCaseDto getTestById(Long id) {
        if (id == null) throw new NotFoundException("Se debe enviar un id para consultar.");
        Optional<TestCase> test = testRepository.findById(id);
        if(test.isPresent()) return modelMapper.map(test.get(), TestCaseDto.class);
        throw new NotFoundException("No existe un Test Case con el id enviado.");
    }

    @Override
    public TestCaseDto updateTestCase(Long id, TestCaseDto test) {
        getTestById(id);
        test.setIdCase(id);
        return modelMapper.map(
                testRepository.save(
                        modelMapper.map(test, TestCase.class)), TestCaseDto.class);
    }

    @Override
    public DeleteResponseDto deleteTestCase(Long id) {
        getTestById(id);
        testRepository.deleteById(id);
        return new DeleteResponseDto(true, "Registro eliminado con éxito.");
    }

    @Override
    public List<TestCaseDto> getAllTestByDate(LocalDate lastUpdate) {
        return testRepository.findByLastUpdateAfter(lastUpdate).stream().map(
                testCase -> modelMapper.map(testCase, TestCaseDto.class))
                .toList();
    }
}
