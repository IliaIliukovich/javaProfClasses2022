package lesson14122022.junit;

import java.util.List;
import java.util.Objects;

public class StreamFunctions {

    public List<String> filterStringList(List<String> list) {

       return list.stream().filter(Objects::nonNull).filter(s -> !s.isEmpty()).toList();

    }

    public List<String> studentNames(List<String> names) {

        return names.stream().filter(Objects::nonNull)
                .filter(s1 -> !s1.isBlank()).distinct().sorted().map(s -> "Student " + s).toList();

    }

}
