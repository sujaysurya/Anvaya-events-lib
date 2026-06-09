package in.ssecorp.tech.anvaya.events.agency;

/**
 * Events produced by recruitment-agency-module.
 * Topic: anvaya.agency.events
 */
public enum AgencyEventType {
    PARTNERSHIP_REQUESTED,   // Agency requests partnership with employer
    PARTNERSHIP_APPROVED,    // Employer approves agency partnership
    PARTNERSHIP_REJECTED,    // Employer rejects agency partnership
    CANDIDATE_SHORTLISTED,   // Agency shortlists a candidate for an employer job
    SHORTLIST_ACCEPTED,      // Employer accepts agency's candidate shortlist
    SHORTLIST_REJECTED       // Employer rejects agency's candidate shortlist
}
