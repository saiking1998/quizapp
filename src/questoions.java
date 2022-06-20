import java.util.HashMap;
import java.util.Random;

public class questoions {

    protected String [] mainques = {
            "what is the capital of India ?",
            "which of the following is used for printing in java?",
            "who created java?",
            "on which year java is invented ?",
            "which company invented java?",
            "Which one of the following is not a Java feature?",
            "Which of these cannot be used for a variable name in Java?",
            "What is the extension of java code files?",
            "Which environment variable is used to set the java path?",
            "Which of the following is not an OOPS concept in Java?",
            "What is not the use of “this” keyword in Java?",
            "Which of the following is a type of polymorphism in Java Programming?",
            "What is Truncation in Java?",
            "What is the extension of compiled java classes?",
            "Which exception is thrown when java is out of memory?"

            };
    protected String[][] mainans ={
            {"New Delhi","Mumbai","Kolkata","Hyderabad"},
            {"print","printf","cout","System.out.print"},
            {"James Gosling","Steve jobs","Bill gates","Charles Babbage"},
            {"1992","1996","1993","1990"},
            {"moon micro systems","Apple","sun micro systems","Microsoft"},
            {"oops","pointers","portable","dynamic and extensible"},
            {"identifiers and keywords","identifiers","keyword","none"},
            {".js",".txt",".cpp",".java"},
            {"MAVEN_Path","JavaPATH","JAVA","JAVA_HOME"},
            {"polymorphism","Inheritance","Compilation","Encapsulation"},
            {"Referring to the instance variable when a local variable has the same name",
                    " Passing itself to the method of the same class","Passing itself to another method",
                    " Calling another constructor in constructor chaining"},
            {"Multiple polymorphism","Compile time polymorphism","Multilevel polymorphism"," Execution time polymorphism"},
            {"Floating-point value assigned to a Floating type","Floating-point value assigned to an integer type",
                    "Integer value assigned to floating type","Integer value assigned to floating type"},
            {".txt","..js",".class",".java"},
            {"MemoryError","OutOfMemoryError","MemoryOutOfBoundsException","MemoryFullException"}


         };
    protected char[]  mainselections= {
            'A','D','A','B','C','B','C','D','D','C','B','B','B','C','B'
    };
        public void setpaper(String[] ques,String[][]ans,char[] opt,int noof){
        HashMap<Integer,Integer> prev = new HashMap<>();
        int n= 0;
        int idx=0;
        Random rand = new Random();
        while (n<noof){
            int m = rand.nextInt(15);
            if(prev.containsKey(m)){
                prev.put(m,prev.getOrDefault(m,0)+1);
            }
            else{
                ques[idx] = mainques[m];
                for(int j=0;j<4;j++){
                    ans[idx][j]=mainans[m][j];
                }
                opt[idx] = mainselections[m];
                prev.put(m,1);
                n++;
                idx++;
            }

        }


    }

}
