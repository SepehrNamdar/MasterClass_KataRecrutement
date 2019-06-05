package use_case;

import model.Recruiter;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

public class PlanInterviewShould {

    private RecruiterRepository recruiterRepository = Mockito.mock(RecruiterRepository.class);

    @Test
    public void plan_an_interview_for_available_recruiter() {
        PlanInterview planner = new PlanInterview(LocalDateTime.now());

        Recruiter antoine = new Recruiter(1, "antoine", LocalDateTime.now());

        planner.plan(antoine);
    }

    @Test
    @Disabled
    public void call_recruiter_repository() {
        PlanInterview planner = new PlanInterview(LocalDateTime.now());

        Recruiter antoine = new Recruiter(1, "antoine", LocalDateTime.now());

        planner.plan(antoine);
        Mockito.verify(recruiterRepository).getRecruiter("antoine");
    }

}
