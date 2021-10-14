/*
901. Online Stock Span

Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backward) for which the stock price was less than or equal to today's price.

For example, if the price of a stock over the next 7 days were [100,80,60,70,60,75,85], then the stock spans would be [1,1,1,2,1,4,6].
Implement the StockSpanner class:

StockSpanner() Initializes the object of the class.
int next(int price) Returns the span of the stock's price given that today's price is price.
 

Example 1:

Input
["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
Output
[null, 1, 1, 1, 2, 1, 4, 6]

Explanation
StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // return 1
stockSpanner.next(80);  // return 1
stockSpanner.next(60);  // return 1
stockSpanner.next(70);  // return 2
stockSpanner.next(60);  // return 1
stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
stockSpanner.next(85);  // return 6 
*/


import java.util.Stack;
import java.util.ArrayList;

class StockSpanner
{
        ArrayList<Integer>list;
        Stack<Integer>st;
        
        public StockSpanner() 
        {
            st=new Stack<>();
            list=new ArrayList<>();
        }
        
        public int next(int price) 
        {
            int span=0;
            if(list.size()==0)
            {
                list.add(price);
                st.push(0);
                return 1;
            }
            else
            {
                if(st.size()>0)
                {
                    if(price>=list.get(st.peek()))
                    {
                        while(st.size()>0 && price>=list.get(st.peek()))
                        {
                            st.pop();
                        }
                        if(st.size()==0)
                            span=list.size()+1;
                        
                        else
                            span=list.size()-st.peek();
                    }
                    else
                    {
                        span=1;
                    }
                    st.push(list.size());
                    list.add(price);
                }
            }
            return span;
        }
    }
    
    /**
     * Your StockSpanner object will be instantiated and called as such:
     * StockSpanner obj = new StockSpanner();
     * int param_1 = obj.next(price);
     */
