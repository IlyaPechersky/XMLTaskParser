public class Essay extends Question {
    private String answer;

    public Essay(int difficulty, String questionText, String answer) {
        super(difficulty, questionText);
        this.answer = answer;
        setDefaultAnswer("\n\n\n\n\n");
    }

    @Override
    public String getAnswer() {
        return String.format("%s\nNote: To be checked manually", answer);
    }
}
