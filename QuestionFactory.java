import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.LinkedList;
import java.util.List;

public final class QuestionFactory {

    public Question createQuestion(String questionType, Element element) {
        NodeList listDifficulty = element.getElementsByTagName("difficulty");
        int difficulty = Integer.parseInt(listDifficulty.item(0)
                .getChildNodes()
                .item(0)
                .getTextContent()
        );

        NodeList listQuestionText = element.getElementsByTagName("questiontext");
        String questionText = listQuestionText.item(0)
                .getChildNodes()
                .item(0)
                .getTextContent();

        if (questionType.equals("multichoice")) {
            NodeList singleList = element.getElementsByTagName("single");
            boolean single = Boolean.parseBoolean(singleList.item(0)
                    .getChildNodes()
                    .item(0)
                    .getTextContent()
            );

            //todo
            NodeList optionsList = element.getElementsByTagName("options")
                    .item(0)
                    .getChildNodes();
            List<String> options = new LinkedList<>();
            for (int index = 1; index < optionsList.getLength(); index += 2) {
                options.add(optionsList.item(index).getTextContent());
            }

            NodeList solutionList = element.getElementsByTagName("solution");
            String solution = solutionList.item(0)
                    .getChildNodes()
                    .item(0)
                    .getTextContent();

            return new Multichoice(
                    difficulty,
                    questionText,
                    single,
                    options,
                    solution
            );
        }
        if (questionType.equals("truefalse")) {
            NodeList answerList = element.getElementsByTagName("answer");
            boolean answer = Boolean.parseBoolean(answerList.item(0)
                    .getChildNodes()
                    .item(0)
                    .getTextContent()
            );

            return new Truefalse(
                    difficulty,
                    questionText,
                    answer
            );
        }
        if (questionType.equals("short")) {
            NodeList answersList = element.getElementsByTagName("answers");
            String answers = answersList.item(0)
                    .getChildNodes()
                    .item(0)
                    .getTextContent();

            return new Short(
                    difficulty,
                    questionText,
                    answers
            );
        }
        if (questionType.equals("essay")) {
            NodeList answerList = element.getElementsByTagName("answer");
            String answer = answerList.item(0)
                    .getChildNodes()
                    .item(0)
                    .getTextContent();

            return new Essay(
                    difficulty,
                    questionText,
                    answer
            );
        }
        System.out.println("No such type!");
        return null;
    }
}
