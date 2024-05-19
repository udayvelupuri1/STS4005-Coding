import java.util.*;

public class Celebrity {

    public static int celebSoln(int[][] mat){
        
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<mat.length;i++){
            st.push(i);
        }

        while(st.size()>1){
            int col =st.pop();
            int row =st.pop();

            if(mat[row][col] == 1){
                st.push(col);
            }
            else{
                st.push(row);
            }
        }

        int x = st.pop();

        for(int j =0;j<mat.length;j++){
            if(j==x){
                continue;
            }
            if(mat[x][j] == 1){
                return -1;
            }
        }

        for(int i=0;i<mat.length;i++){
            if(i==x){
                continue;
            }
            if((mat[i][x]) == 0){
                return -1;

            }
        }

        return x;

    }

    public static void main(String[] args) {

       int mat[][] =   {{0,1,1,0},
                        {0,0,0,0},
                        {0,1,0,0},
                        {1,1,0,0}};

        int res = celebSoln(mat);

        if(res == -1){
            System.out.println("There is no celebrity");
        }
        else{
            System.out.println(res+" is the celebrity");
        }
        
    }
    
}
