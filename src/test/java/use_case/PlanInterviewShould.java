package use_case;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PlanInterviewShould {

    private CandidateRepository candidateRepository = Mockito.mock(CandidateRepository.class);

    @Test
    @Disabled
    public void throw_exception_when_recruiter_is_not_available() {
        PlanInterview planner = new PlanInterview(LocalDateTime.now(), candidateRepository);

        assertThatExceptionOfType(RecruiterNotAvailableException.class)
                .isThrownBy(() ->
                        planner.plan(1));
    }

    @Test
    public void call_recruiter_repository() {
        PlanInterview planner = new PlanInterview(LocalDateTime.now(), candidateRepository);

        int candidateId = 1;
        planner.plan(candidateId);
        Mockito.verify(candidateRepository).getCandidateById(candidateId);
    }

}
