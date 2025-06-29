package itu.mbds.collaborativecommutingapi.helpers;

public class StringHelper {
    public static String clean(String string) {
        String cleaned = string
                .replaceAll("[\\\\/:*?\"<>|]", "")   // Remove invalid characters
                .replaceAll("\\s+", "_")            // Replace spaces with underscores
                .replaceAll("\\.+$", "")            // Remove trailing dots
                .replaceAll("^\\.+", "");           // Remove leading dots
        return cleaned.toLowerCase();
    }
}
