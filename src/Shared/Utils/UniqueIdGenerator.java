package Shared.Utils;

import java.util.UUID;

public class UniqueIdGenerator {
    public static String generate() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
