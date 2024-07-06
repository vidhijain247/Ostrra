/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.Osttra.QuizApp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import javax.security.sasl.SaslException;

/**
 *
 * @author HrithikPandey
 */
    public class Quiz {
    static int score=0;
    static int doneIn=0;
    public static void main(String[] args) {
        String[] list=new String[6];
        list[0]="s";
        for(int x=0;x<5;x++){
        MCQquiz currQues= new MCQquiz();
        MCQuestion q= currQues.pick();
        for(int i=0; i<list.length;i++)
        {
            for(int j=0;j<doneIn;j++)
            {
                while(list[j].equals(q.getQuestion()))
                {
                
                    q= currQues.pick();
                }   
            }
        }
        list[doneIn]=q.getQuestion();
        doneIn++;
        Scanner s= new Scanner(System.in);
        System.out.println(q.getQuestion());
        String [] op= q.getOptions();
        for(var i : op)
        {
            System.out.println(i);
        }
        int ans = s.nextInt();
        if(ans==q.getCorrectOptionIndex())
        {
            score+=1;
        }
        else
        {
            score-=1;
        }
    }
    System.out.println(score);
    }
}
