import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TestTeachingUnitResult {
  private static final TeachingUnitResult twentyAtProg =
          new TeachingUnitResult("Programmation 2", TestGrade.twenty);
  private static final TeachingUnitResult zeroAtStructDiscrete =
          new TeachingUnitResult("Structures discrètes", TestGrade.zero);

  @Test
  void testGetGrade() {
    assertThat(twentyAtProg.getGrade()).isEqualTo(TestGrade.twenty);
    assertThat(zeroAtStructDiscrete.getGrade()).isEqualTo(TestGrade.zero);
  }

  @Test
  void testToString() {
    assertThat(twentyAtProg.toString()).isEqualTo("Programmation 2 : 20.0/20");
    assertThat(zeroAtStructDiscrete.toString()).isEqualTo("Structures discrètes : 0.0/20");
  }
}
