package sampling_methods;

import java.util.ArrayList;

public class Sampling {

  ArrayList list;
  int listSize;
  int listType;
  
  public Sampling() {
    this.list = new ArrayList<>();
    this.listSize = 0;
    this.listType = 0;
  }
  
  public Sampling(int dataChoice) {
    if(dataChoice == 1) {
      this.list = new ArrayList<Integer>();
    } else
      if(dataChoice == 2) {
      this.list = new ArrayList<Character>();
    }
  }
  
  public void Sampling(int[] numList, int popSize) {
    for(int i = 0; i < popSize; i++) {
      list.add(numList[i]);
    }
    this.listSize = popSize;
  }
  
  public void Sampling(char[] charList, int popSize) {
    for(int i = 0; i < popSize; i++) {
      list.add(charList[i]);
    }
    this.listSize = popSize;
  }
  
  public void display() {
  	System.out.println("\n\n");
		System.out.println("********************************");
    System.out.println("**** THE SAMPLING FRAME ****");
    System.out.println("********************************");
    for(int i = 0; i < this.listSize; i++) {
      System.out.print("Index " + (i + 1) + "\t\t");
    }
    System.out.println();
    
    for(int i = 0; i < this.listSize; i++) {
      System.out.print("Item " + list.get(i) + "\t\t");
    }
  }
  
  public int size() {
    return this.list.size();
  }
  
  public void SimpleRandom(int sampleSize) {
    int randItem;
    int[] randList = new int[size()];
    
    for(int i = 0; i < size(); i++) {
      randList[i] = 0;
    }
    
    System.out.println("\n\n");
		System.out.println("********************************");
    System.out.println("RANDOM SAMPLE");
    System.out.println();
    for(int i = 0; i < sampleSize; i++) {
    	System.out.print("Index " + (i + 1) + "\t\t");
    }
    
    System.out.println();
    
    for(int i = 0; i < sampleSize; i++) {
      randItem = (int) (Math.random() * size());
  	  System.out.print("Item " + list.get(randItem) + "\t\t");
    }
    System.out.println("");
  }
  
  public void Systematic(int sampleSize) {
    int k = (int) Math.floor(size() / sampleSize);
    int randStart = (int) (Math.random() * k);
    
    System.out.println("\n\n");
    System.out.println("interval for each item (k): "+ k + "\t random starting point: "+ randStart + "\n");
		System.out.println("********************************");
    System.out.println("RANDOM SAMPLE (Systematic Sampling)");
    System.out.println();
    for(int i = 0; i < sampleSize; i++) {
    	System.out.print("Index " + (i + 1) + "\t\t");
    }
    
    System.out.println();
    
    for(int i = 0; i < sampleSize; i++) {
    	System.out.print("Item " + list.get(randStart) + "\t\t");
    	randStart += k;
    }
    System.out.println();
  }
  
  public void segregate() {
    ArrayList array = new ArrayList<>();
    
    if(this.listType == 1)
      array = new ArrayList<Integer>();
    
    if(this.listType == 2)
      array = new ArrayList<Character>();
    
    for(int i = 0; i < size(); i++) {
      if(!(array.contains(this.list.get(i))))
        array.add(this.list.get(i));
    }
    
    for(int i = 0; i < array.size(); i++) {
    	System.out.println();
      System.out.println("STRATA " + (i + 1));
      
      for(int j = 0; j < size(); j++) {
      	if(array.get(i).equals(this.list.get(j))) {
      		System.out.print("Index " + (j + 1) + "\t\t");
      	}
      }
      
      System.out.println();
      
      for(int j = 0; j < size(); j++) {
        if(array.get(i).equals(this.list.get(j))){
        	System.out.print("Item " + list.get(j) + "\t\t");
        }
      }
    }
  }
  
  public void Stratified(int percentage) {
    ArrayList array = new ArrayList<>();
    ArrayList tempArr;
    
    float prcnt = ((float) percentage) / 100.00f;
    
    if(this.listType == 1)
      array = new ArrayList<Integer>();
    
    if(this.listType == 2)
      array = new ArrayList<Character>();
    
    for(int i = 0; i < size(); i++) {
      if(!(array.contains(this.list.get(i))))
        array.add(this.list.get(i));
    }
    
    int[] sample = new int[size()];
    
    for(int i = 0; i < array.size(); i++) {
      sample[i] = 0;
    }
    
    for(int i = 0; i < array.size(); i++) {
      int temp1 = 0;
      
      for(int j = 0; j < size(); j++) {
        if(array.get(i).equals(this.list.get(j)))
          temp1++;
      }
      sample[i] = temp1;
    }
    
    for(int i = 0; i < array.size(); i++) {
      int temp2 = 0;
      tempArr = new ArrayList<Integer>();
      int sampleItem = (int) Math.round(prcnt * (float) sample[i]);
      System.out.println();
  		System.out.println("********************************");
      System.out.println("STRATA " + (i + 1) + " (n = " + sampleItem + ")");
      System.out.println();
      for(int j = 0; j < size(); j++) {
      	if(array.get(i).equals(this.list.get(j)) && temp2 < sampleItem) {
      		System.out.print("Index " + (j + 1) + "\t\t");
      		temp2++;
      	}
      }
       
      System.out.println();
      temp2 = 0;
      for(int j = 0; j < size(); j++) {
        if(array.get(i).equals(this.list.get(j)) && temp2 < sampleItem){
          tempArr.add(j);
        	System.out.print("Item " + list.get(j) + "\t\t");
          temp2++;
        }
      }
      System.out.println("");
    }
    System.out.println("");
  }
}
