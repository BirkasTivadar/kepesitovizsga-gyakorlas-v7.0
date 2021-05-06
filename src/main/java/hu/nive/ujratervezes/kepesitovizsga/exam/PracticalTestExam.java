package hu.nive.ujratervezes.kepesitovizsga.exam;

import java.time.LocalDateTime;

public class PracticalTestExam extends Exam {

    public PracticalTestExam(String name, LocalDateTime beginTime) {
        super(name, beginTime, ExamType.PRACTICAL_TEST);
    }
}
