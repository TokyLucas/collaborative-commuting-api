package itu.mbds.collaborativecommutingapi.enums;

public enum StatutTrajet {
    PREVU,
    EN_ROUTE,
    TERMINE;

    public static StatutTrajet from(String input) {
        for (StatutTrajet s : values()) {
            if (s.name().equalsIgnoreCase(input)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Statut inconnu: " + input);
    }
}

