package pl.spamsoftware.paralex;

public class MyQuestionAndAnswers {
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String correctAnswer;

    MyQuestionAndAnswers(){
        question = null;
        answer1 = null;
        answer2 = null;
        answer3 = null;
        correctAnswer = null;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
