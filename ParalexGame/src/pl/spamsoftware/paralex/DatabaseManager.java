package pl.spamsoftware.paralex;

import java.sql.*;


public class DatabaseManager{


    private MyQuestionAndAnswers myQuestionAndAnswers;

    DatabaseManager(int idVariable) {

        myQuestionAndAnswers = new MyQuestionAndAnswers();
        getDataFromDatabase(idVariable);
    }
    public void getDataFromDatabase(int idVariable){
        try {
            /* Get a connection to database */

            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizowanie", "root", "");
            //System.out.println("Connected to data base.");
            /* Create a statement */
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from questions where id = " + idVariable);
            while (myRs.next()) {

                myQuestionAndAnswers.setQuestion(myRs.getString("question"));
                myQuestionAndAnswers.setAnswer1(myRs.getString("answerA"));
                myQuestionAndAnswers.setAnswer2(myRs.getString("answerB"));
                myQuestionAndAnswers.setAnswer3(myRs.getString("answerC"));
                myQuestionAndAnswers.setCorrectAnswer(myRs.getString("correctAnswe"));
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }


    public MyQuestionAndAnswers getMyQuestionAndAnswers(){

        return myQuestionAndAnswers;
    }


}
