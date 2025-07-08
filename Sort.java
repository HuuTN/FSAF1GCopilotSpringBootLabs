import java.util.Collections;
import java.util.List;

public class Sort {
    public List<String> sortNames(List<String> names) {
        return names.stream()
            .sorted(String.CASE_INSENSITIVE_ORDER)
            .toList();
    }
}