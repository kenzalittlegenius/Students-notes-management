import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TeachingUnitResultTest {
  private static final TeachingUnitResult twentyAtProg =
          new TeachingUnitResult("Programmation 2", GradeTest.twenty);
  private static final TeachingUnitResult zeroAtStructDiscrete =
          new TeachingUnitResult("Structures discrètes", GradeTest.zero);

  //@Disabled("Disabled until TeachingUnitResult is coded")
  @Test
  void testGetGrade() {
    assertThat(twentyAtProg.getGrade()).isEqualTo(GradeTest.twenty);
    assertThat(zeroAtStructDiscrete.getGrade()).isEqualTo(GradeTest.zero);
  }

  //@Disabled("Disabled until TeachingUnitResult is coded")
  @Test
  void testToString() {
    assertThat(twentyAtProg.toString()).isEqualTo("Programmation 2 : 20.0/20");
    assertThat(zeroAtStructDiscrete.toString()).isEqualTo("Structures discrètes : 0.0/20");
  }
}
