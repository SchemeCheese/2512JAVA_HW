package buoi5.bt.B3;

public class Student {

    String  id;
    String  name;
    double  attendanceScore;
    double examScore;

    public Student(String id, String name, double attendanceScore, double examScore) {
        this.id = id;
        this.name = name;
        this.attendanceScore = attendanceScore;
        this.examScore = examScore;
    }

    public double  calculateFinalScore() {
        return attendanceScore * 0.3 + examScore * 0.7;
    }

    public String getGrade() {
        double score =  calculateFinalScore();

        if (score >= 8.5) {
            return "A";
        } else if (score >= 7.0) {
            return "B";
        } else if (score >= 5.5) {
            return "C";
        } else {
            return "D";
        }
    }
}
