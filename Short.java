import java.util.StringJoiner;

public class Short extends Question {
    private String answers;

    public Short(int difficulty, String questionText, String answers) {
        super(difficulty, questionText);
        this.answers = answers;
        setDefaultAnswer("Answer: ____________________");
    }

    @Override
    public String getAnswer() {
        StringJoiner joiner = new StringJoiner(", ");
        for (String answer : answers.split(",")) {
            joiner.add(answer);
        }
        return String.format("Accepted answers: [%s]", joiner);
    }
}
