package in.ssecorp.tech.anvaya.events.application;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * The message published to topic: anvaya.application.commands
 *
 * LEARNING NOTE — Kafka Message Key (partitionKey):
 * We set the Kafka message KEY to `applicationId` (or jobId+seekerId
 * for new applications). This guarantees all events for the same
 * application land on the SAME partition, preserving order.
 *
 * Example: If seeker applies, then immediately withdraws, the
 * SUBMIT must be processed before the WITHDRAW. Putting both on
 * the same partition ensures the consumer sees them in order.
 *
 * @JsonInclude(NON_NULL) — don't serialize null fields to JSON.
 * This keeps messages compact. Fields like `interviewDate` and
 * `additionalInfo` are only set for specific command types.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicationCommandEvent {

    // Unique event ID for idempotency checks
    private String eventId;

    // The type of action being requested
    private ApplicationCommandType commandType;

    // Core identifiers — always present
    private String seekerId;
    private String jobId;
    private String employerId;

    // Populated once the application exists
    private String applicationId;

    // For INTERVIEW_SCHEDULE — ISO-8601 datetime string
    private String interviewDate;

    // For ADDITIONAL_INFO_REQUEST / ADDITIONAL_INFO_SUBMIT
    private String additionalInfo;

    // For APPLICATION_REJECT / APPLICATION_ARCHIVE — optional reason
    private String reason;

    // Who triggered this command (SEEKER or EMPLOYER)
    private String actorType;
    private String actorId;

    // When this command was created (for latency tracking)
    @Builder.Default
    private Instant issuedAt = Instant.now();
}
