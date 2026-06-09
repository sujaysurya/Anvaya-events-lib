package in.ssecorp.tech.anvaya.events.agency;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * Published to topic: anvaya.agency.events
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgencyEvent {

    private String eventId;
    private AgencyEventType eventType;
    private String agencyId;
    private String employerId;

    // For CANDIDATE_SHORTLISTED events
    private String seekerId;
    private String jobId;
    private String shortlistId;
    private String notes;

    // For PARTNERSHIP events
    private String partnershipId;
    private String requestNotes;

    @Builder.Default
    private Instant occurredAt = Instant.now();
}
