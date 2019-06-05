package use_case;

import model.Recruiter;

public interface RecruiterRepository {
    Recruiter getRecruiter(String name);
}
