import java.util.ArrayList;
import java.util.List;

/**
 * A students with results.
 */

public class Student {
  private final String firstName;
  private final String lastName;
  private final List<TeachingUnitResult> results;

  /**
   * Constructs a student with the specified first name and last name and no associated results.
   *
   * @param firstName the first name of the constructed student
   * @param lastName the last name of the constructed student
   */

  public Student(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.results = new ArrayList<>();
  }

  /**
   * Add a grade associated to a teaching unit to the results of the student.
   *
   * @param teachingUnitName the name of the teaching unit of the added result
   * @param grade the grade of the added result
   */
  public void addResult(String teachingUnitName, Grade grade){
      TeachingUnitResult result =  new TeachingUnitResult(teachingUnitName, grade);
      results.add(result);
  }

  /**
   * Returns a string representation of the student in the format first name last name.
   * @return a string representation of the student
   */
  @Override
  public String toString() {

    return firstName + " " + lastName;
  }


  /**
   * Returns the grades of the student.
   *
   * @return the grades of the student
   */
  public List<TeachingUnitResult> getGrades(){
    // return the grade relating to the results
      return this.results;
  }

  /**
   * Returns the average grade of the student.
   *
   * @return the average grade of the student
   */
  public double averageGrade() {

      //don't forget the base case
      if(results.isEmpty()){
          return new Grade(0).getValue();
      }

      double sum = 0.0;
      for (TeachingUnitResult result : results){
          sum += result.getGrade().getValue();
      }

      return sum / results.size();
  }

  /**
   * Print via the standard output the name of the student, all results associated to the students and
   * the average grade of the student.
   */
  public void printResults(){
    System.out.println( firstName + " " + lastName);
    for (TeachingUnitResult result : results){
        System.out.println( "- " + result.toString());
    }
    System.out.println("Average: " + averageGrade());


  }


  /**
   * Determines regardless or whether two students are equal. Two instances of Student are equal if the values
   * of their {@code firtName}  and {@code lastName} member fields are the same.
   * @param o  an object to be compared with this Student
   * @return {@code true} if the object to be compared is an instance of Student and has the same name; {@code false}
   * otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Student student = (Student) o;

    if (!firstName.equals(student.firstName)) return false;
    return lastName.equals(student.lastName);
  }

  /**
   * Returns a hash code value for the object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    int result = firstName.hashCode();
    result = 31 * result + lastName.hashCode();
    return result;
  }


}
