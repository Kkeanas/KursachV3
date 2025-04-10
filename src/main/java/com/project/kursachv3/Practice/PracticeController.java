package com.project.kursachv3.Practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/practice")
public class PracticeController {
    @Autowired
    public PracticeService practiceService;

    @GetMapping()
    public List<PracticeGetDTO> getAllPractice() {
        List<Practice> rawResult = practiceService.getAllPractice();
        List<PracticeGetDTO> result = rawResult.stream()
                .map(PracticeGetDTO::convertToDTO)
                .collect(Collectors.toList());
        return result;
    }
    @GetMapping("/{id}")
    public PracticeGetDTO getPractice(@PathVariable long id) {
        Practice rawResult = practiceService.getPracticeById(id);
        PracticeGetDTO result = PracticeGetDTO.convertToDTO(rawResult);
        return result;
    }
    @PostMapping()
    public PracticeGetDTO postPractice(@RequestBody PracticePostDTO practicePostDTO) {
        Practice rawResult = practiceService.postPractice(practicePostDTO);
        PracticeGetDTO result = PracticeGetDTO.convertToDTO(rawResult);
        return result;
    }
}
