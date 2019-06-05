package use_case;

import model.Recruiter;

import java.time.LocalDateTime;
import java.util.List;

public interface RecruiterRepository {
    Recruiter getRecruiter(String name);

    List<Recruiter> getRecruiters(List<String> candidateTechnos, LocalDateTime interviewDate);
}
