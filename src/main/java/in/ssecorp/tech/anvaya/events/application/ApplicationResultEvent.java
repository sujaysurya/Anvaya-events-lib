package in.ssecorp.tech.anvaya.events.application;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * The message published to topic: anvaya.application.events
 * after employer-core processes an ApplicationCommandEvent.
 *
 * LEARNING NOTE — Why broadcast back?
 * When an employer shortlists a seeker, the seeker's dashboard
 * needs to reflect "SHORTLISTED" status. The seeker's service
 * (jobseeker-core) subscribes to this topic and updates its
 * own read model / invalidates its cache.
 *
 * This is the EVENT SOURCING pattern — the source of truth is
 * the event log, and each service maintains its own derived view.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicationResultEvent {

    private String eventId;
    private ApplicationEventType eventType;
    private String applicationId;
    private String seekerId;
    private String jobId;
    private String employerId;

    // The new status after this transition
    private String newStatus;

    // Optional: interview date for INTERVIEW_SCHEDULED events
    private String interviewDate;

    // Optional: additional info for ADDITIONAL_INFO_REQUESTED events
    private String additionalInfo;

    // Whether processing succeeded
    private boolean success;
    private String errorMessage;

    @Builder.Default
    private Instant occurredAt = Instant.now();
}
