package use_case;

import model.Candidate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PlanInterviewShould {

    private int candidateId = 1;
    private Candidate candidate = new Candidate("Gilles");
    private List<String> candidateTechnos = Arrays.asList(new String[]{"foo", "bar"});
    private PlanInterview planner;

    private CandidateRepository candidateRepository = Mockito.mock(CandidateRepository.class);
    private RecruiterRepository recruiterRepository = Mockito.mock(RecruiterRepository.class);

    @BeforeEach
    public void init() {
        Mockito.when(candidateRepository.getCandidateById(candidateId)).thenReturn(candidate);
        planner = new PlanInterview(LocalDateTime.now(), candidateRepository, recruiterRepository);
        createDefaultCandidate();
    }

    @Test
    @Disabled
    public void throw_exception_when_recruiter_is_not_available() {
        PlanInterview planner = new PlanInterview(LocalDateTime.now().minusDays(1), candidateRepository, recruiterRepository);

        assertThatExceptionOfType(RecruiterNotAvailableException.class)
                .isThrownBy(() ->
                        planner.plan(1));
    }

    @Test
    public void call_candidate_repository() {
        planner.plan(candidateId);
        Mockito.verify(candidateRepository).getCandidateById(candidateId);
    }

    @Test
    public void call_recruiter_repository() {
        planner.plan(candidateId);
        Mockito.verify(recruiterRepository).getRecruiters(candidateTechnos);
    }

    private void createDefaultCandidate() {
        candidate.setSkills(candidateTechnos);
    }

}
