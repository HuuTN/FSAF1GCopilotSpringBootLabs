public List<String> sortNames(List<String> names) {
    return names.stream()
        .sorted(String.CASE_INSENSITIVE_ORDER)
        .collect(Collectors.toList());
}