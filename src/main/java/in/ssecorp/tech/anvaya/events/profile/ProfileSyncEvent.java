package in.ssecorp.tech.anvaya.events.profile;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * Published to topic: anvaya.profile.sync
 * whenever a seeker or employer profile is updated.
 *
 * LEARNING NOTE — Cache Invalidation via Kafka:
 * When a seeker updates their profile in jobseeker-core,
 * it publishes this event. Any service holding a cached
 * copy of that profile (employer-core, workflow-engine)
 * receives this event and deletes its Redis cache entry.
 *
 * On the next profile read, the service fetches fresh data
 * from the source service and re-populates the cache.
 * This is the CACHE-ASIDE (Lazy Loading) + EVENT-DRIVEN
 * INVALIDATION pattern.
 *
 * Why Kafka for cache invalidation vs direct Redis pub/sub?
 * Kafka gives us durability and replay. If a service was
 * down when the invalidation fired, it will process the
 * event when it comes back up (Kafka keeps it for 24h).
 * Redis pub/sub is fire-and-forget — missed events stay stale.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileSyncEvent {

    public enum ProfileType { SEEKER, EMPLOYER }

    private String eventId;
    private ProfileType profileType;

    // The ID of the profile that changed
    private String profileId;

    // Which fields changed (optional — for partial invalidation)
    private String changedFields;

    @Builder.Default
    private Instant occurredAt = Instant.now();
}
