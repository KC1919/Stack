// import java.util.*;
class Stack
{
    private int MaxCapacity=0;  //maximum capacity of the stack
    private int a[];            //array to implement stack
    private int NoOfElements;   //current number of elements in the stack
    private int tos;            //top element of the stack

    Stack(int size)      //this constructor will initialize the Stack with the given size
    {
        initialize(size);
    }

    Stack()
    { 
        this(10);   //constructor chaining, this will initialize the Stack with size=10(default)
    }

    protected void initialize(int size)
    {
        this.a=new int[size];
        this.MaxCapacity=size;
        this.NoOfElements=0;
        this.tos=-1;
    }

    public void push()
    {

    }

    public void pop()
    {

    }

    public int peek()
    {
        return -1;
    }
}