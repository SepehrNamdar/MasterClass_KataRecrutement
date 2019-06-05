package use_case;

import model.Candidate;
import model.Recruiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlanInterviewShould {

    private int candidateId = 1;
    private Candidate candidate = new Candidate("Gilles");
    private List<String> candidateTechnos = Arrays.asList(new String[]{"foo", "bar"});
    private List<Recruiter> recruiters = Arrays.asList(
            new Recruiter[]{new Recruiter(1, "Ali", LocalDateTime.now()),
                    new Recruiter(2, "James", LocalDateTime.now())});
    private PlanInterview planner;

    private CandidateRepository candidateRepository = Mockito.mock(CandidateRepository.class);
    private RecruiterRepository recruiterRepository = Mockito.mock(RecruiterRepository.class);

    @BeforeEach
    public void init() {
        when(candidateRepository.getCandidateById(candidateId)).thenReturn(candidate);
        planner = new PlanInterview(LocalDateTime.now(), candidateRepository, recruiterRepository);
        createDefaultCandidate();
    }

    @Test
    public void throw_exception_when_no_recruiter_is_competent() {
        PlanInterview planner = new PlanInterview(LocalDateTime.now(), candidateRepository, recruiterRepository);

        assertThatExceptionOfType(NoRecruiterAvailableException.class)
                .isThrownBy(() ->
                        planner.plan(candidateId));
    }

    @Test
    public void call_candidate_repository() {
        when(recruiterRepository.getRecruiters(any(), any())).thenReturn(recruiters);
        planner.plan(candidateId);
        verify(candidateRepository).getCandidateById(candidateId);
    }

    @Test
    public void call_recruiter_repository() {
        when(recruiterRepository.getRecruiters(any(), any())).thenReturn(recruiters);
        planner.plan(candidateId);
        verify(recruiterRepository).getRecruiters(any(), any());
    }

    private void createDefaultCandidate() {
        candidate.setSkills(candidateTechnos);
    }

}
