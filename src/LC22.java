import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LC22 {
    public static void main(String[] args) {
        int n =3;
        List l = new LC22().generateParenthesis(n);
        Iterator<String> iterator= l.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
    public List<String> generateParenthesis(int n) {
        int l=n, r=n;

        List<String> list = new ArrayList<>();
        String s="";
        rec(l,r,list , s);

        return list;
    }

    /**
     * This is how the recursion works.
     * https://www.youtube.com/watch?v=ygK0YON10sQ
     *
     * In this question, each time when rec is called, the value of s will be
     * recorded on the stack:
     * e.g. "(" is on the stack, on one hand another "(" will be added to it and "((" will be on the upper level of "(" in the stack;
     * For "((", it will has its further recursion; however, when "(("'s recursion finished, i.e. the recursion call of res based on "((" are
     * popped form the stack, "(" will be on the top of the stack again. And at this time, it goes to the following if condition, i.e. the other
     * half of the branch, and that's how the "()" case is processed.
     *
     * How does the rec() method return the recorded value?
     * --It doesn't actually "return". In fact, the value is preserved on stack and thus it is "returned" when the branch comes back.
     */
    private static void rec(int l, int r, List<String> list,String s){
        if(r==0){
            list.add(s);
//            return;
        }

        if(l>0){
            rec(l-1,r,list,s+"(");
        }
        if(r>l){
            rec(l,r-1,list, s+")");
        }
    }
}


