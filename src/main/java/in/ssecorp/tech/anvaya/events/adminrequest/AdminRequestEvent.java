package in.ssecorp.tech.anvaya.events.adminrequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * Published to topic: anvaya.admin.requests
 *
 * Produced by employer-core-module, jobseeker-core-module and recruitment-agency-module
 * whenever onboarding, a service request, a subscription/tier upgrade, or a security
 * request needs to be handled by an Anvaya employee via anvaya-admin-module.
 *
 * `requestTypeCode` is a free-form string matched against the admin module's
 * dynamic AdminRequestType catalog (e.g. "EMPLOYER_ONBOARDING", "AGENCY_SUBSCRIPTION").
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminRequestEvent {

    private String eventId;

    private String requestTypeCode;
    private AdminRequestCategory category;
    private RequestSourceService sourceService;

    /** employerId / seekerId / agencyId of the entity raising the request */
    private String sourceEntityId;

    private String requestorName;
    private String requestorEmail;

    private String subject;

    /** Free-form JSON payload with request-type-specific details */
    private String details;

    /** For SUBSCRIPTION requests — the tier being requested */
    private String tierRequested;

    @Builder.Default
    private Instant occurredAt = Instant.now();
}
