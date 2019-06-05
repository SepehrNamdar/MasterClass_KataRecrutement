package use_case;

import model.Recruiter;

import java.time.LocalDateTime;

public class PlanInterview {

    private LocalDateTime interviewDate;
    private RecruiterRepository recruiterRepository;

    public PlanInterview(LocalDateTime interviewDate, RecruiterRepository recruiterRepository) {
        this.interviewDate = interviewDate;
        this.recruiterRepository = recruiterRepository;
    }

    public void plan(Recruiter recruiter) {
        boolean available = recruiter.isAvailable(this.interviewDate);
        if (!available) {
            throw new RecruiterNotAvailableException();
        }
        recruiterRepository.getRecruiter(recruiter.getName());
    }
}
