package hu.nive.ujratervezes.kepesitovizsga.exam;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exam {

    private String name;

    private LocalDateTime beginTime;

    private ExamType type;

    public Exam(String name, LocalDateTime beginTime, ExamType type) {
        this.name = name;
        this.beginTime = beginTime;
        this.type = type;
    }

    public int getDurationOfExam() {
        return type == ExamType.THEORY_TEST ? 1 : 3;
    }

    public static int getDurationOfIdentification() {
        return 1;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public ExamType getType() {
        return type;
    }

    public LocalDateTime getBeginTimeOfExam() {
        return beginTime.minusHours(1);
    }

    public LocalDateTime getEndTimeOfExam() {
        return beginTime.plusHours(getDurationOfExam());
    }

    public List<Exam> getExamsInChronologicalOrder(List<Exam> exams) {
        return exams.stream().sorted(Comparator.comparing(Exam::getBeginTime)).collect(Collectors.toList());
    }


    public Map<String, LocalDateTime> getExamsBySpecialPredicate(List<Exam> exams) {

        if (type == ExamType.THEORY_TEST) {
            return exams.stream().filter(e -> e.getName().contains("fejlesztő")).collect(
                    Collectors.toMap(Exam::getName, Exam::getBeginTime));
        }

        return exams.stream().filter(e -> e.beginTime.isAfter(LocalDateTime.of(e.beginTime.toLocalDate(), LocalTime.of(12, 0)))).collect(
                Collectors.toMap(Exam::getName, Exam::getBeginTime));
    }
}
