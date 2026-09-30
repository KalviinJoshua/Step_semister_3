import java.util.Scanner;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    Question(String questionText, String correctAnswer,
             String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double calculateScore();
}

class MCQQuestion extends Question {

    MCQQuestion(String questionText, String correctAnswer,
                String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    double calculateScore() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }
}

class TFQuestion extends Question {

    TFQuestion(String questionText, String correctAnswer,
               String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    double calculateScore() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }
}

class EssayQuestion extends Question {

    EssayQuestion(String questionText, String correctAnswer,
                  String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    double calculateScore() {

        String[] keywords = correctAnswer.split(",");
        String answer = studentAnswer.toLowerCase();

        int matchedKeywords = 0;

        for (String keyword : keywords) {

            keyword = keyword.trim().toLowerCase();

            if (answer.contains(keyword)) {
                matchedKeywords++;
            }
        }

        if (matchedKeywords >= 2) {
            return points * 0.75;
        }

        if (matchedKeywords == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class ExaminationQuestionGrader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Question[] questions = new Question[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String[] parts = line.split("\"");

            String type = parts[0].trim();

            String questionText = parts[1];
            String correctAnswer = parts[3];
            String studentAnswer = parts[5];

            String pointsPart = parts[6].trim();
            double points = Double.parseDouble(pointsPart);

            types[i] = type;

            switch (type) {

                case "MCQ":
                    questions[i] = new MCQQuestion(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points
                    );
                    break;

                case "TF":
                    questions[i] = new TFQuestion(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points
                    );
                    break;

                case "ESSAY":
                    questions[i] = new EssayQuestion(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points
                    );
                    break;
            }
        }

        double totalScore = 0;

        for (int i = 0; i < n; i++) {

            double score = questions[i].calculateScore();

            System.out.printf(
                "%s: %.2f%n",
                types[i],
                score
            );

            totalScore += score;
        }

        System.out.printf(
            "Total Score: %.2f%n",
            totalScore
        );

        sc.close();
    }
}