public class Truefalse extends Question {
    private boolean answer;

    public Truefalse(int difficulty, String questionText, boolean answer) {
        super(difficulty, questionText);
        this.answer = answer;
        setDefaultAnswer("Answer: true false (circle the right answer)");
    }

    @Override
    public String getAnswer() {
        return "Answer: " + answer;
    }
}
