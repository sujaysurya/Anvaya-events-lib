package in.ssecorp.tech.anvaya.events.adminrequest;

/**
 * Broad category of a request raised to anvaya-admin-module.
 * The specific sub-type is carried separately as a string `requestTypeCode`,
 * which is looked up against the admin module's dynamic request-type catalog.
 */
public enum AdminRequestCategory {
    ONBOARDING,
    SERVICE_REQUEST,
    SUBSCRIPTION,
    SECURITY
}
