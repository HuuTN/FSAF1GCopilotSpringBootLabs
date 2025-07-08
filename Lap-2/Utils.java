public class Utils {
    // Optimize the sortNames method to use Java Streams for case-insensitive sorting
    public List<String> sortNamesCaseInsensitive(List<String> names) {
        return names.stream()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.toList());
    }
}