import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CohortTest {
  private static final Cohort cohort = new Cohort("L2 informatique");
  private static final Student davidGoodenough = new Student("David", "Goodenough");
  private static final Student jeanMichelBruitage = new Student("Jean-Michel", "Bruitage");
  private static final Cohort l1Descartes = new Cohort("L1 Descartes");

  @BeforeAll
  static void addStudentsToCohort(){
    jeanMichelBruitage.addResult("Programmation 2", GradeTest.zero);
    jeanMichelBruitage.addResult("Structures discrètes", GradeTest.twenty);
    davidGoodenough.addResult("Programmation 2", GradeTest.ten);
    davidGoodenough.addResult("Structures discrètes", GradeTest.ten);
    cohort.addStudent(davidGoodenough);
    cohort.addStudent(jeanMichelBruitage);
  }

  @Disabled("Disabled until Cohort is coded")
  @Test
  void testGetStudentsIsEmpty_whenEmptyCohort(){
    assertThat(l1Descartes.getStudents()).isEmpty();
  }

  @Disabled("Disabled until Cohort is coded")
  @Test
  void testGetStudents_whenCohortContainsStudents(){
    assertThat(cohort.getStudents()).isEqualTo(List.of(davidGoodenough, jeanMichelBruitage));
  }

  @Disabled("Disabled until Cohort is coded")
  @Test
  void testPrintStudentsResults_whenCohortIsEmpty() {
    StandardOutputSandbox standardOutputSandbox = new StandardOutputSandbox(l1Descartes::printStudentsResults);
    String expectedOutput = "L1 Descartes" + StandardOutputSandbox.NEW_LINE + StandardOutputSandbox.NEW_LINE;
    standardOutputSandbox.run();
    assertThat(standardOutputSandbox.getProducedOutput()).isEqualTo(expectedOutput);
  }

  @Disabled("Disabled until Cohort is coded")
  @Test
  void testPrintStudentsResults_whenCohortContainsStudents() {
    StandardOutputSandbox standardOutputSandbox = new StandardOutputSandbox(cohort::printStudentsResults);
    String expectedOutput = "L2 informatique" + StandardOutputSandbox.NEW_LINE + StandardOutputSandbox.NEW_LINE
            + "David Goodenough" + StandardOutputSandbox.NEW_LINE
            + "Programmation 2 : 10.0/20" + StandardOutputSandbox.NEW_LINE
            + "Structures discrètes : 10.0/20" + StandardOutputSandbox.NEW_LINE
            + "Note moyenne : 10.0/20" + StandardOutputSandbox.NEW_LINE + StandardOutputSandbox.NEW_LINE
            + "Jean-Michel Bruitage" + StandardOutputSandbox.NEW_LINE
            + "Programmation 2 : 0.0/20" + StandardOutputSandbox.NEW_LINE
            + "Structures discrètes : 20.0/20" + StandardOutputSandbox.NEW_LINE
            + "Note moyenne : 10.0/20" + StandardOutputSandbox.NEW_LINE + StandardOutputSandbox.NEW_LINE;
    standardOutputSandbox.run();
    assertThat(standardOutputSandbox.getProducedOutput()).isEqualTo(expectedOutput);
  }
}
