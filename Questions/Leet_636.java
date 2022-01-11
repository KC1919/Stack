/*
Exclusive Time of Functions

On a single-threaded CPU, we execute a program containing n functions. Each function has a unique ID between 0 and n-1.

Function calls are stored in a call stack: when a function call starts, its ID is pushed onto the stack, and when a function call ends, its ID is popped off the stack. The function whose ID is at the top of the stack is the current function being executed. Each time a function starts or ends, we write a log with the ID, whether it started or ended, and the timestamp.

You are given a list logs, where logs[i] represents the ith log message formatted as a string "{function_id}:{"start" | "end"}:{timestamp}". For example, "0:start:3" means a function call with function ID 0 started at the beginning of timestamp 3, and "1:end:2" means a function call with function ID 1 ended at the end of timestamp 2. Note that a function can be called multiple times, possibly recursively.

A function's exclusive time is the sum of execution times for all function calls in the program. For example, if a function is called twice, one call executing for 2 time units and another call executing for 1 time unit, the exclusive time is 2 + 1 = 3.

Return the exclusive time of each function in an array, where the value at the ith index represents the exclusive time for the function with ID i.

 

Example 1:


Input: n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
Output: [3,4]
Explanation:
Function 0 starts at the beginning of time 0, then it executes 2 for units of time and reaches the end of time 1.
Function 1 starts at the beginning of time 2, executes for 4 units of time, and ends at the end of time 5.
Function 0 resumes execution at the beginning of time 6 and executes for 1 unit of time.
So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 spends 4 units of total time executing.
*/



import java.util.Stack;
import java.util.List;

public class Leet_636 
{   
    public int[] exclusiveTime(int n, List<String> logs) 
    {
        class Pair
        {
             String id;
             int sleep;
             int time;

             Pair(String id, int time, int sleep)
             {
                 this.id=id;
                 this.time=time;
                 this.sleep=sleep;
             }
         }
        
        int time[]=new int[n];
        
        Stack<Pair>st=new Stack<>();
        
        for(String log:logs)
        {
            String info[]=log.split(":");
            
            //when a event comes, we check if it  is an start event
            if(info[1].equals("start"))
            {   
                //we push the start event into the stack,with its (id,start-time,sleep-time(0 by default))
                st.push(new Pair(info[0],Integer.parseInt(info[2]),0));
            }
            else
            {
                //when an end event comes,
                Pair rem=st.pop();       //we remove the top most event of the stack, because its end time has come
                int id=Integer.parseInt(info[0]);
                time[id]+=Integer.parseInt(info[2])-rem.time+1-rem.sleep; //we now calculate for how much time it executed
                
                //in the above equation we are substracting the sleep time, beacause, the function might
                //have gone tot he sleep mode if some new function would have come above it.

                // sleep time= the time for which a function goes on stand by, because of a 
                // new function getting added to the stack for execution, so the ycurrent function goes to sleep

                //now we check if after removing the current function from the stack, if any function is 
                //present in the stack, which would have gone to sleep, because of the function above it
                if(st.size()>0)
                {
                    //so if present, then we update its sleep time, which is equal to the 
                    //execution time of the function above it.
                    //the sleep time helps us to calculate the exact time for which a function executed
                    st.peek().sleep+=Integer.parseInt(info[2])-rem.time+1;
                }
            }
        }
        return time;
    }
}
