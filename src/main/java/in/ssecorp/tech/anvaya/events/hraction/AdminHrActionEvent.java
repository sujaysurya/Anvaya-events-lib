package in.ssecorp.tech.anvaya.events.hraction;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * Published to topic: anvaya.admin.hr-actions
 *
 * Produced by employer-core-module whenever a platform admin (anvaya-admin-module)
 * performs a management action against an employer's HR portal data
 * (HR professionals, roles, groups, grouped roles, agency limits) via the
 * /api/v1/employer/hr/admin/{employerId}/** endpoints.
 *
 * This is a fire-and-forget audit record — not part of a request/decision workflow.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminHrActionEvent {

    private String eventId;

    /** Employer the action was performed against */
    private String employerId;

    /** e.g. "ROLE_STATUS_CHANGED", "PROFESSIONAL_DELETED", "AGENCY_LIMIT_UPDATED" */
    private String actionType;

    /** e.g. "PROFESSIONAL", "ROLE", "ROLE_GROUP", "GROUP", "AGENCY_LIMIT" */
    private String targetType;

    /** id of the affected entity (hrId, roleId, groupId, etc.) */
    private String targetId;

    /** Human-readable summary of the change */
    private String description;

    private Long adminId;
    private String adminName;

    @Builder.Default
    private Instant occurredAt = Instant.now();
}
