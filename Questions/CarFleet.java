

/*
853. Car Fleet

There are n cars going to the same destination along a one-lane road. The destination is target miles away.

You are given two integer array position and speed, both of length n, where position[i] is the position of the ith car and speed[i] is the speed of the ith car (in miles per hour).

A car can never pass another car ahead of it, but it can catch up to it, and drive bumper to bumper at the same speed.

The distance between these two cars is ignored (i.e., they are assumed to have the same position).

A car fleet is some non-empty set of cars driving at the same position and same speed. Note that a single car is also a car fleet.

If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.

Return the number of car fleets that will arrive at the destination.

 

Example 1:

Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
Output: 3
Explanation: 
The cars starting at 10 and 8 become a fleet, meeting each other at 12.
The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
The cars starting at 5 and 3 become a fleet, meeting each other at 6.
Note that no other cars meet these fleets before the destination, so the answer is 3.
Example 2:

Input: target = 10, position = [3], speed = [3]
Output: 1
*/

import java.util.*;
class CarFleet 
{
    public int carFleet(int target, int[] position, int[] speed) 
    {
        //we make a 2-d array to store the position of a car and its time to reach the target
        double disTime[][]=new double[position.length][2];
        
        int n=disTime.length;
        
        //we iterate over the position and speed array
        for(int i=0;i<n;i++)
        {
            disTime[i][0]=position[i];  //store the position
            disTime[i][1]=(target-position[i])/(speed[i]*1.0);//and calculate the time for the car
                                                              //at ith position to reach the target
        }
        
        //now we sort the array based on the positions of the car in ascending order
        Arrays.sort(disTime,(a,b)->{return (int)(a[0]-b[0]);});
        
        //default number of fleets=1
        int fleet=1;
        
        double prevTime=disTime[n-1][1];  //we take the previous time to get added to the fleet
        
        for(int i=n-2;i>=0;i--)  //we start to iterate from the 2nd last car
        {
            if(disTime[i][1]>prevTime)  //if the car's time ot reach the target is greater than the car ahead of it
            {
                prevTime=disTime[i][1]; //then it would not be able to catch that car at any point of time before teh target
                fleet++;                //so this would increase the number of fleets
            }

            else //if the time is less than or equal to the time of the car ahead ,then it would
            {   //catch that car and will get added to the same fleet, so the number of fleet 
                // will not increase

                //nothing to do (just for explaination)
            }
        }
        
        return fleet;
    }
}