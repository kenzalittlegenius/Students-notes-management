import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StudentTest {
  private static final Student arnaudLabourel = new Student("Arnaud", "Labourel");
  private static final Student jeanMichelBruitage = new Student("Jean-Michel", "Bruitage");
  private static final Student davidGoodenough = new Student("David", "Goodenough");

  @Disabled("Disabled until Student is coded")
  @BeforeAll
  static void addResultsToStudents(){
    arnaudLabourel.addResult("Programmation 2", GradeTest.twenty);
    arnaudLabourel.addResult("Structures discrètes", GradeTest.twenty);
    davidGoodenough.addResult("Programmation 2", GradeTest.ten);
    davidGoodenough.addResult("Structures discrètes", GradeTest.zero);
    jeanMichelBruitage.addResult("Programmation 2", GradeTest.ten);
    jeanMichelBruitage.addResult("Structures discrètes", GradeTest.twenty);
  }

  @Disabled("Disabled until Student is coded")
  @Test
  void testHashCode(){
    assertThat(jeanMichelBruitage.hashCode()).isEqualTo(new Student("Jean-Michel", "Bruitage").hashCode())
            .isNotEqualTo(davidGoodenough.hashCode());
  }

  @Disabled("Disabled until Student is coded")
  @Test
  void testEquals(){
    assertThat(jeanMichelBruitage).isEqualTo(new Student("Jean-Michel", "Bruitage"))
            .isNotEqualTo(davidGoodenough)
            .isNotEqualTo(null)
            .isNotEqualTo("Jean-Michel Bruitage");
  }

  @Disabled("Disabled until Student is coded")
  @Test
  void testToString() {
    assertThat(jeanMichelBruitage.toString()).isEqualTo("Jean-Michel Bruitage");
    assertThat(davidGoodenough.toString()).isEqualTo("David Goodenough");
  }

  @Disabled("Disabled until Student is coded")
  @Test
  void testGetGrades() {
    assertThat(arnaudLabourel.getGrades()).isEqualTo(List.of(GradeTest.twenty, GradeTest.twenty));
    assertThat(davidGoodenough.getGrades()).isEqualTo(List.of(GradeTest.ten, GradeTest.zero));
    assertThat(jeanMichelBruitage.getGrades()).isEqualTo(List.of(GradeTest.ten, GradeTest.twenty));
  }

  @Disabled("Disabled until Student is coded")
  @Test
  void testGetAverageGrade() {
    assertThat(arnaudLabourel.averageGrade()).isEqualTo(GradeTest.twenty);
    assertThat(davidGoodenough.averageGrade()).isEqualTo(new Grade(5));
    assertThat(jeanMichelBruitage.averageGrade()).isEqualTo(new Grade(15));
  }

  @Disabled("Disabled until Student is coded")
  @Test
  void testPrintResults() {
    StandardOutputSandbox standardOutputSandbox = new StandardOutputSandbox(arnaudLabourel::printResults);
    String expectedOutput =
            "Arnaud Labourel" + StandardOutputSandbox.NEW_LINE
            + "Programmation 2 : 20.0/20" + StandardOutputSandbox.NEW_LINE
            + "Structures discrètes : 20.0/20" + StandardOutputSandbox.NEW_LINE
            + "Note moyenne : 20.0/20" + StandardOutputSandbox.NEW_LINE;
    standardOutputSandbox.run();
    assertThat(standardOutputSandbox.getProducedOutput()).isEqualTo(expectedOutput);
  }
}