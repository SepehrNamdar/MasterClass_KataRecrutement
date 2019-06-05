package use_case;

import model.Recruiter;

import java.time.LocalDateTime;

public class PlanInterview {

    private LocalDateTime interviewDate;

    public PlanInterview(LocalDateTime interviewDate) {
        this.interviewDate = interviewDate;
    }

    public void plan(Recruiter recruiter) {
        boolean available = recruiter.isAvailable(this.interviewDate);
        if (!available) {
            throw new RecruiterNotAvailableException();
        }
    }
}
