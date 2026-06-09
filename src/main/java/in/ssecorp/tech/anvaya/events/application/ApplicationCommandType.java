package in.ssecorp.tech.anvaya.events.application;

/**
 * Commands sent TO the workflow state machine.
 * Produced by: jobseeker-core-module, employer-core-module
 * Topic: anvaya.application.commands
 *
 * LEARNING NOTE — Commands vs Events:
 * A COMMAND is an instruction: "please do this."
 * An EVENT is a fact: "this already happened."
 *
 * We use commands for triggering workflow transitions and
 * events for broadcasting the outcome to interested parties.
 * This separation is the core of the CQRS/event-driven pattern.
 */
public enum ApplicationCommandType {

    // Seeker-initiated commands
    APPLICATION_SUBMIT,      // Seeker applies for a job
    APPLICATION_WITHDRAW,    // Seeker withdraws their application
    ADDITIONAL_INFO_SUBMIT,  // Seeker submits employer-requested info

    // Employer-initiated commands
    APPLICATION_REVIEW,      // Employer marks application as reviewed
    APPLICATION_SHORTLIST,   // Employer shortlists the applicant
    INTERVIEW_SCHEDULE,      // Employer schedules an interview
    INTERVIEW_COMPLETE,      // Employer marks interview as done
    APPLICANT_HIRE,          // Employer marks candidate as hired
    APPLICATION_REJECT,      // Employer rejects the applicant
    APPLICATION_ARCHIVE,     // Employer archives the application
    ADDITIONAL_INFO_REQUEST  // Employer requests more info from seeker
}
