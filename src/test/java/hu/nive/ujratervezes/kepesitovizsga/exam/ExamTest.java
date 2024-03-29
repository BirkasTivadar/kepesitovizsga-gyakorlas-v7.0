package hu.nive.ujratervezes.kepesitovizsga.exam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ExamTest {

    private Exam theoryTestExam;

    private Exam practicalTestExam;

    private List<Exam> exams;

    @BeforeEach
    public void setUp() {

        theoryTestExam = new TheoryTestExam("Junior Java backend fejlesztő írásbeli vizsga", LocalDateTime.of(2021, 4, 28, 11, 0));

        practicalTestExam = new PracticalTestExam("Junior Java backend fejlesztő projektvizsga", LocalDateTime.of(2021, 4, 29, 10, 0));

        exams = new ArrayList<>();
        exams.add(new TheoryTestExam("Junior szoftvertesztelő projektvizsga", LocalDateTime.of(2021, 4, 29, 14, 0)));
        exams.add(new TheoryTestExam("Junior frontend fejlesztő írásbeli vizsga", LocalDateTime.of(2021, 4, 28, 9, 0)));
        exams.add(new TheoryTestExam("Junior rendszerüzemeltető projektvizsga", LocalDateTime.of(2021, 4, 30, 14, 0)));
        exams.add(new TheoryTestExam("Junior szoftvertesztelő írásbeli vizsga", LocalDateTime.of(2021, 4, 28, 15, 0)));
        exams.add(new TheoryTestExam("Junior rendszerüzemeltető írásbeli vizsga", LocalDateTime.of(2021, 4, 28, 13, 0)));
        exams.add(new TheoryTestExam("Junior Java backend fejlesztő projektvizsga", LocalDateTime.of(2021, 4, 29, 10, 0)));
        exams.add(new TheoryTestExam("Junior Java backend fejlesztő írásbeli vizsga", LocalDateTime.of(2021, 4, 28, 11, 0)));
        exams.add(new TheoryTestExam("Junior frontend fejlesztő projektvizsga", LocalDateTime.of(2021, 4, 30, 10, 0)));
    }

    @Test
    void testCreateTheory() {
        assertEquals("Junior Java backend fejlesztő írásbeli vizsga", theoryTestExam.getName());
        assertEquals(LocalDateTime.of(2021, 4, 28, 11, 0), theoryTestExam.getBeginTime());
        assertEquals(1, theoryTestExam.getDurationOfExam());
        assertEquals(1, Exam.getDurationOfIdentification());
        assertEquals(ExamType.THEORY_TEST, theoryTestExam.getType());
    }

    @Test
    void testCreatePractical() {
        assertEquals("Junior Java backend fejlesztő projektvizsga", practicalTestExam.getName());
        assertEquals(LocalDateTime.of(2021, 4, 29, 10, 0), practicalTestExam.getBeginTime());
        assertEquals(3, practicalTestExam.getDurationOfExam());
        assertEquals(1, Exam.getDurationOfIdentification());
        assertEquals(ExamType.PRACTICAL_TEST, practicalTestExam.getType());
    }

    @Test
    void testGetBeginTimeOfExam() {
        assertEquals(LocalDateTime.of(2021, 4, 28, 10, 0), theoryTestExam.getBeginTimeOfExam());
        assertEquals(LocalDateTime.of(2021, 4, 29, 9, 0), practicalTestExam.getBeginTimeOfExam());
    }

    @Test
    void testGetEndTimeOfExam() {
        assertEquals(LocalDateTime.of(2021, 4, 28, 12, 0), theoryTestExam.getEndTimeOfExam());
        assertEquals(LocalDateTime.of(2021, 4, 29, 13, 0), practicalTestExam.getEndTimeOfExam());
    }

    @Test
    void testGetExamsInChronologicalOrder() {
        List<Exam> examsInChronologicalOrder = theoryTestExam.getExamsInChronologicalOrder(exams);

        assertEquals("Junior Java backend fejlesztő írásbeli vizsga", examsInChronologicalOrder.get(1).getName());
        assertEquals(LocalDateTime.of(2021, 4, 29, 10, 0), examsInChronologicalOrder.get(4).getBeginTime());
    }

    @Test
    void testGetExamsBySpecialPredicateTheory() {
        Map<String, LocalDateTime> expected = theoryTestExam.getExamsBySpecialPredicate(exams);
        Map<String, LocalDateTime> examsForDevelopers = Map.of("Junior frontend fejlesztő írásbeli vizsga", LocalDateTime.of(2021, 4, 28, 9, 0),
                "Junior Java backend fejlesztő projektvizsga", LocalDateTime.of(2021, 4, 29, 10, 0),
                "Junior Java backend fejlesztő írásbeli vizsga", LocalDateTime.of(2021, 4, 28, 11, 0),
                "Junior frontend fejlesztő projektvizsga", LocalDateTime.of(2021, 4, 30, 10, 0));

        assertEquals(expected, examsForDevelopers);
    }

    @Test
    void testGetExamsBySpecialPredicatePractical() {
        Map<String, LocalDateTime> expected = practicalTestExam.getExamsBySpecialPredicate(exams);
        Map<String, LocalDateTime> examsAfternoon = Map.of("Junior szoftvertesztelő projektvizsga", LocalDateTime.of(2021, 4, 29, 14, 0),
                "Junior rendszerüzemeltető projektvizsga", LocalDateTime.of(2021, 4, 30, 14, 0),
                "Junior szoftvertesztelő írásbeli vizsga", LocalDateTime.of(2021, 4, 28, 15, 0),
                "Junior rendszerüzemeltető írásbeli vizsga", LocalDateTime.of(2021, 4, 28, 13, 0));

        assertEquals(expected, examsAfternoon);
    }
}