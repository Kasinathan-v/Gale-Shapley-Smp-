/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author 1024993
 */
import java.util.*;
public class Algo {

    /**
     * @param args the command line arguments
     */
    static int number=4;
    static int partwomen[]= new int [number];
    
    //to know the priority
    static Boolean prefer(int matrix[][],int m1,int m,int n,int f)
    {
        for(int i=0;i<n;i++)
        {
            if(matrix[f][i]==m1)
            {
                return true;
            }
            else if(matrix[f][i]==m)
            {
                return false;
            }
        }
        return false;
    }
    static void solve(int matrix[][],int n)
    {   int freemen=n;
        boolean freem[]= new boolean[freemen];//freem is to know whether the men is free or not.,false=free and true=occupied.by default it is false
        
        Arrays.fill(partwomen, -1);  //partwomen[] is to know the current pair.
        int m=-1;
        while(freemen>0)// this proceeds untill thr is  men free.
        {
            for(int i=0;i<n;i++) //if men is free,then tat men is considerd for further purpose
            {
                if(freem[i]==false)
                {   m=i;
                    freemen--;
                    break;
                }
            }
            for(int j=0;j<n&&freem[m]==false;j++)
            {
                int f=matrix[m][j];    //first women of that mens list is considerd
                if(partwomen[f-n]==-1) //checking if tat women is free or not
                {
                    partwomen[f-n]=m; // if free then the pair is updated
                    freem[m]=true; //and men is not free now.
                    break;
                }
                else   // if the women is not free,then we are cheching for priority
                {
                    int m1=partwomen[f-n];  //considering the old men
                    if(prefer(matrix,m1,m,n,f)==false) //comparing old men m1 with current men m
                    {
                        freem[m1]=false; //if the current one is preffered,then old is free again
                        partwomen[f-n]=m;//the current is paired up
                        freem[m]=true;//the current men is unavailble
                        break;
                    }
                }
                    
            }
        }
        
    }
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
         number=obj.nextInt();
        int matrix[][]=new int[2*number][number];
        for(int i=0;i<(2*number);i++)
        {
            for(int j=0;j<number;j++)
            {   
                
                matrix[i][j]=obj.nextInt();      
            }
        }
       
        solve(matrix,number);
        
        for(int p=0;p<number;p++)
        {
            System.out.println(number+p+" "+partwomen[p]);
        }
    }
    
}