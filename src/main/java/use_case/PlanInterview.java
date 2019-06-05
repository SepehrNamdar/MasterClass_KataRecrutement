package use_case;

import model.Candidate;

import java.time.LocalDateTime;

public class PlanInterview {

    private LocalDateTime interviewDate;
    private CandidateRepository candidateRepository;

    public PlanInterview(LocalDateTime interviewDate, CandidateRepository candidateRepository) {
        this.interviewDate = interviewDate;
        this.candidateRepository = candidateRepository;
    }

    public void plan(int candidateId) {
        Candidate candidate = candidateRepository.getCandidateById(candidateId);
    }
}
