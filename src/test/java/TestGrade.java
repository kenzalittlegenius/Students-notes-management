import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class TestGrade {
  static Grade twenty = new Grade(20);
  static Grade zero = new Grade(0);
  static Grade ten = new Grade(10);
  private static final double EPSILON = 0.000001d;
  private static final List<Grade> grades = List.of(zero, twenty, ten);
  private static final List<Grade> gradesZero = List.of(zero, zero);

  @Test
  void testHashCode(){
    assertThat(twenty.hashCode()).isEqualTo(new Grade(20).hashCode())
            .isNotEqualTo(ten.hashCode())
            .isNotEqualTo(zero.hashCode());
  }

  @Test
  void testEquals(){
    assertThat(twenty).isEqualTo(new Grade(20))
            .isNotEqualTo(ten)
            .isNotEqualTo(zero)
            .isNotEqualTo(null)
            .isNotEqualTo("20.0/20")
            .isNotEqualTo(20.0);
  }

  @Test
  void testGetValue() {
    assertThat(twenty.getValue()).isCloseTo(20, within(EPSILON));
    assertThat(zero.getValue()).isCloseTo(0, within(EPSILON));
  }

  @Test
  void testToString() {
    assertThat(twenty.toString()).isEqualTo("20.0/20");
    assertThat(zero.toString()).isEqualTo("0.0/20");

  }

  @Test
  void testAverageGrade(){
    assertThat(Grade.averageGrade(grades)).isEqualTo(ten);
    assertThat(Grade.averageGrade(gradesZero)).isEqualTo(zero);
  }
}
