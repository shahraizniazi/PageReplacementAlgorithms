import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;


public class driver
{
    
  
  public static void main(String[] args)
  {
    
    Scanner s = new Scanner(System.in);
    System.out.println("Please choose an algorithm" + "\n" + "1.FIFO" + "\n" + "2.SC");
    int choice = s.nextInt();
    System.out.println("How many virtual pages are in the process: ");
    int nVirtualPages = s.nextInt();
    System.out.println("How many frames are allocated to the process: " );
    int nFrames = s.nextInt();
    System.out.println("How many page references would you like to simulate: " );
    int nPageReference = s.nextInt();
    
    Random r = new Random();
    int[] frames = new int[nFrames];
    int[] pageReference = new int[nPageReference];
    
    for(int i =0;i<pageReference.length; i++){
       pageReference[i]= r.nextInt(nVirtualPages) +1;
    }
    
   
    
    int pageFaults=0;
    int pointer =0; 
    
    
    if(choice ==1){
        System.out.println("FIFO running.........");
        for(int i =0; i<pageReference.length;i++){
            int element = pageReference[i];
            boolean check = false;
            for(int j =0; j<frames.length;j++){
                if(element == frames[j]){
                    check = true;
                    
                }
            }
            
            if(pointer==frames.length){
                pointer=0;
            }
            else{
                
                if(check == false){
                    
                    frames[pointer]=element;
                    pointer++;
                    pageFaults++;
                    
                }
            }
            
        }
        
       
        
    }
    
    else{
        System.out.println("SC is running....");
        ArrayList<Integer> sc = new ArrayList<>();
        int round=0;
        
        for(int i =0; i<pageReference.length;i++){
            int element = pageReference[i];
            boolean check = false;
            for(int j =0; j<frames.length;j++){
                if(element == frames[j]){
                    check = true;
                }
            }
         
        if(pointer == frames.length){pointer=0;round++;}
         
        
        
        if(check == true){
                 if(sc.contains(element)){
                     sc.remove(sc.indexOf(element));
                     
                     
                 }
                 else{sc.add(element);}
                
             }
             
        if(check == false && round ==0){
            
                    frames[pointer]=element;
                    pointer++;
                    pageFaults++;
                
                
            }
            
        if(check==false && round>0){
            if(sc.size()==0){
                    
                    frames[pointer]=element;
                    pointer++;
                    pageFaults++;
                
            }
        else{
                while(frames[pointer]==sc.get(0)){
                        pointer++;
                        pointer = pointer%frames.length;
                        sc.remove(0);
                        
                    }
                    
                }
                
                    frames[pointer]=element;
                    pointer++;
                    pageFaults++;
                
                
                
            }
            
            
        }
            

            
            
        }
             
             
    

    double pageFaultPercentage = ((double)pageFaults/nPageReference)*100;
                       
    System.out.println("The algorithm produced "+ pageFaults+ " page faults, or " +pageFaultPercentage + "%");                
   

  }
  
  
}
