package com.project.kursachv3.Practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracticeService {
    @Autowired
    PracticeRepository practiceRepository;

    public List<Practice> getAllPractice() {
        List<Practice> result = practiceRepository.findAll();
        return result;
    }

    public Practice getPracticeById(long id) {
        Practice result = practiceRepository.findById(id).orElse(null);
        return result;
    }

    public Practice postPractice(PracticePostDTO practicePostDTO) {
        ;
        return practiceRepository.save(PracticePostDTO.convertFromDTO(practicePostDTO));
    }
}
