package in.ssecorp.tech.anvaya.events.adminrequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * Published to topic: anvaya.admin.decisions
 *
 * Produced by anvaya-admin-module when an Anvaya employee acts on an AdminRequest.
 * Consumed by employer-core-module, jobseeker-core-module and recruitment-agency-module —
 * each consumer filters on `targetService` to pick up only the events meant for it.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminDecisionEvent {

    private String eventId;

    /** anvaya-admin-module's AdminRequest.id */
    private String requestId;

    private String requestTypeCode;
    private AdminRequestCategory category;

    /** Which service this decision is destined for */
    private RequestSourceService targetService;

    /** employerId / seekerId / agencyId the decision applies to */
    private String targetEntityId;

    private AdminDecisionType decision;
    private String decisionNotes;

    private Long decidedByAdminId;
    private String decidedByAdminName;

    @Builder.Default
    private Instant occurredAt = Instant.now();
}
