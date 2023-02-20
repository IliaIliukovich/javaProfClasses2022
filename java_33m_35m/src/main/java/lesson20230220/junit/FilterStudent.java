package lesson20230220.junit;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FilterStudent {

    public List<String> filterStudent(List<String> studentList){

        return studentList.stream().filter(Objects::nonNull).map(s -> "Student " + s).collect(Collectors.toList());
    }


}
