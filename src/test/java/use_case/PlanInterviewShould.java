package use_case;

import model.Recruiter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PlanInterviewShould {

    private RecruiterRepository recruiterRepository = Mockito.mock(RecruiterRepository.class);

    @Test
    public void throw_exception_when_recruiter_is_not_available() {
        PlanInterview planner = new PlanInterview(LocalDateTime.now(), recruiterRepository);

        Recruiter antoine = new Recruiter(1, "antoine", LocalDateTime.now().plusDays(1));

        assertThatExceptionOfType(RecruiterNotAvailableException.class)
                .isThrownBy(() ->
                        planner.plan(antoine));
    }

    @Test
    public void call_recruiter_repository() {
        PlanInterview planner = new PlanInterview(LocalDateTime.now(), recruiterRepository);

        Recruiter antoine = new Recruiter(1, "antoine", LocalDateTime.now());

        planner.plan(antoine);
        Mockito.verify(recruiterRepository).getRecruiter("antoine");
    }

}
