package in.ssecorp.tech.anvaya.events.application;

/**
 * Events broadcast FROM the workflow state machine after a transition completes.
 * Produced by: employer-core-module (after processing a command)
 * Consumed by: jobseeker-core-module (to update seeker's application view)
 * Topic: anvaya.application.events
 */
public enum ApplicationEventType {
    APPLICATION_SUBMITTED,
    APPLICATION_WITHDRAWN,
    APPLICATION_REVIEWED,
    APPLICATION_SHORTLISTED,
    INTERVIEW_SCHEDULED,
    INTERVIEW_COMPLETED,
    APPLICANT_HIRED,
    APPLICATION_REJECTED,
    APPLICATION_ARCHIVED,
    ADDITIONAL_INFO_REQUESTED,
    ADDITIONAL_INFO_SUBMITTED
}
