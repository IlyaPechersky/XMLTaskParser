import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Question {
    private int difficulty;
    private String questionText;
    private String defaultAnswer = "Answer";

    public Question(int difficulty, String questionText) {
        this.difficulty = difficulty;
        this.questionText = questionText;
    }

    public static void reorderQuestions(List<Question> questions) {
        Collections.sort(questions, Comparator.comparing(Question::getDifficulty));
    }

    public static String printWithAnswers(List<Question> questions) throws IOException {
        StringJoiner joiner = new StringJoiner("\n\n");
        for (int index = 0; index < questions.size(); index++) {
            joiner.add(
                    String.format("%d) %s \n%s",
                            index + 1,
                            questions.get(index).questionText,
                            questions.get(index).getAnswer())
            );
        }
        return joiner.toString();
    }

    public String getAnswer() {
        return "Answer";
    }

    public static String print(List<Question> questions) {
        StringJoiner joiner = new StringJoiner("\n\n");
        for (int index = 0; index < questions.size(); index++) {
            joiner.add(
                    String.format("%d) %s \n%s",
                            index + 1,
                            questions.get(index).questionText,
                            questions.get(index).getDefaultAnswer())
            );
        }
        return joiner + "\n";
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getDefaultAnswer() {
        return defaultAnswer;
    }

    public void setDefaultAnswer(String defaultAnswer) {
        this.defaultAnswer = defaultAnswer;
    }
}
