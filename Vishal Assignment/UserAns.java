package QuizApp;

public class UserAns {
    public char[] userArr = new char[5];
    public char[] ansArrActual=new char[5];

    public UserAns(char[] _ansArr) {
        this.ansArrActual=_ansArr;
        for(int i =0;i<5;i++){
            userArr[i] ='Y';
        }
    }
    int score=0;
    public int getResult(){
        for(int i=0;i<5;i++){
            if(userArr[i]==ansArrActual[i]){
                score++;
            }
        }
        return score;
    }

    char correctOptionGot;
    char userOptionGot;






    
}