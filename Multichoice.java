import java.util.HashSet;
import java.util.List;
import java.util.StringJoiner;

public class Multichoice extends Question {
    private boolean single;
    private List<String> options;
    private String solution;

    public Multichoice(int difficulty, String questionText, boolean single, List<String> options, String solution) {
        super(difficulty, questionText);
        this.single = single;
        this.options = options;
        this.solution = solution;
        StringJoiner joiner = new StringJoiner("\n");
        for (int index = 0; index < options.size(); index++) {
            joiner.add(String.format("\t%d) %s",
                    index + 1,
                    options.get(index))
            );
        }
        setDefaultAnswer(joiner.toString());
    }

    @Override
    public String getAnswer() {
        HashSet<String> answers = new HashSet<>(List.of(solution.split(",")));

        StringJoiner joiner = new StringJoiner("\n");
        for (int index = 0; index < options.size(); index++) {
            if (answers.contains(String.valueOf(index + 1))) {
                joiner.add(String.format(" -> %d) %s",
                        index + 1,
                        options.get(index))
                );
            } else {
                joiner.add(String.format("\t%d) %s",
                        index + 1,
                        options.get(index))
                );
            }
        }
        return joiner.toString();
    }
}
