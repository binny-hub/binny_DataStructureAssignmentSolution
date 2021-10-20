/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GradedProject3;


import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;

public class ArchitectLogic2 {
    static ArrayList<Integer> array= new ArrayList<Integer>();
    static ArrayList<Integer>array_copy= new ArrayList<Integer>();
    static  int size;
    static Scanner sc= new Scanner(System.in);
    
    static void inputData(){
        System.out.println(" Enter the number of floors ");
        size = sc.nextInt();
            
        for (int i =0; i<size; i++){
            int fl=sc.nextInt();
            array.add(fl);
            array_copy.add(fl);
        } 
    
    }
    static void orderOfFloorsToBeAssembled(){
        Stack<Integer> floors = new Stack<>();
 
        for(int i=1; i<=size; i++)
            floors.add(i);
        
        int d=1,days;
        int flag;
        
        for(int i=0; i<size; i++)
        {   
            flag=0;
          if(!floors.isEmpty()){   
              //Check the floor to be assembled
              int floor = floors.peek();
              
              //check which day the floor D has to be assembled
              for(int j=0; j<size&&flag==0; j++){// if a floor is already built and assembled, this loop will break
                  // since the flag variable is set to 1
                // Check out which floor in the array entered  matches with the next fllor to be assembled   
                
                int floorThatIsBuilt = (int)array.get(j);
                
                if (floor == floorThatIsBuilt){
                    flag=1;
                    int dayThatFloorisActuallyBuilt = array_copy.indexOf(floor);
                    //To print which day the floor is actually used for assembling
                    System.out.println();
                    for(days=d; days<=(dayThatFloorisActuallyBuilt+1); days++)
                        System.out.println("Day "+days);
                    d=days; // d is a variable keeping the count of the last day when floors were assembled
                    // Then printing the floor
                    System.out.print(floor);
                    
                    // Once the floor is assembled, remove the floor from the Queue
                    floors.pop();
                    // Remove that floor from the list that the floor was built
                    array.remove(j);
                    // Reduce the number of floors to be built
                    size--;
                    
                    for(int k=j-1; k>=0;k--){
                        // check if all the floors prior to this floor are already built
                        if(!floors.isEmpty()){  
                            // check if any floor prior to the one assembled is already built or not
                            floor=(int)floors.peek();
                            if((int)array.get(k)== floor){
                                System.out.print(" "+ floor);
                                floors.pop();
                                // If built, use it for assembling and remove that floor from the
                                // list to be built and also from the array
                                array.remove(k);
                                // reduce the size accordingly
                                size--;
                            }
                            else{
                               // if the immediate lower floor is not built, break out of the loop
                               break;
                            }
                        }
                        else
                           return;// return if the Queue is empty - all floors are done
                    }
                 }
                
                }
           } 
           else
              return; // return if the Queue is empty - all floors are done
        }
    }  
    
    public static void main(String args[]) {
        inputData();
        orderOfFloorsToBeAssembled();
    }
}
