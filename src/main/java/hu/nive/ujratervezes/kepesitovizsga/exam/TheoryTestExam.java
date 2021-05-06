package hu.nive.ujratervezes.kepesitovizsga.exam;

import java.time.LocalDateTime;

public class TheoryTestExam extends Exam {

    public TheoryTestExam(String name, LocalDateTime beginTime) {
        super(name, beginTime, ExamType.THEORY_TEST);
    }


}
