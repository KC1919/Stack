// import java.util.*;
class stack
{
    private int MaxCapacity;  //maximum capacity of the stack
    private int a[];            //array to implement stack
    private int NoOfElements;   //current number of elements in the stack
    private int tos;            //top element of the stack

    stack(int size)      //this constructor will initialize the Stack with the given size
    {
        initialize(size);
    }

    stack()
    { 
        this(10);   //constructor chaining, this will initialize the Stack with size=10(default)
    }

    protected void initialize(int size)  //initializing the class variables with the given values
    {
        this.a=new int[size];
        this.MaxCapacity=size;
        this.NoOfElements=0;
        this.tos=-1;
    }

    private void overflowException() throws Exception
    {
        if(this.tos==this.MaxCapacity){
            throw new Exception("Stack is overflowed");
        }
    }

    private void underflowException() throws Exception
    {
        if(this.tos<0){
            throw new Exception("Stack is underflowed");
        }
    }

    public void push(int x) throws Exception     //function to push an element into the stack
    {
        overflowException();
        a[++this.tos]=x;
        this.NoOfElements=this.tos+1;
    }

    public void pop() throws Exception    //function to pop an element into the stack
    {
        underflowException();
        System.out.println("No elements to pop, the stack is empty!");
    }

    public int peek() throws Exception    //function to peek at the top element of the stack
    {
        underflowException();
        int rv=a[this.tos--];
        return rv;        
    }

    public int totalElements()   //function to get the total number of elements present in the stack
    {
        return NoOfElements;
    }
}