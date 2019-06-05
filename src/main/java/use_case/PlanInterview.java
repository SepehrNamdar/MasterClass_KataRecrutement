package use_case;

import model.Candidate;
import model.Recruiter;

import java.time.LocalDateTime;
import java.util.List;

public class PlanInterview {

    private LocalDateTime interviewDate;
    private CandidateRepository candidateRepository;
    private RecruiterRepository recruiterRepository;

    public PlanInterview(LocalDateTime interviewDate, CandidateRepository candidateRepository, RecruiterRepository recruiterRepository) {
        this.interviewDate = interviewDate;
        this.candidateRepository = candidateRepository;
        this.recruiterRepository = recruiterRepository;
    }

    public void plan(int candidateId) {
        Candidate candidate = candidateRepository.getCandidateById(candidateId);
        List<Recruiter> recruiters = recruiterRepository.getRecruiters(candidate.getSkills(), interviewDate);
        if(recruiters.isEmpty()) {
            throw new NoRecruiterAvailableException();
        }

    }
}
