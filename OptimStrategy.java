import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OptimStrategy {
    public List<String> sortNames(List<String> names) {
        return names.stream()
                    .sorted(String.CASE_INSENSITIVE_ORDER)
                    .collect(Collectors.toList());
    }
}
