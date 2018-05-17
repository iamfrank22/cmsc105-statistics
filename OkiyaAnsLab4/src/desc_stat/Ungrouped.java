package desc_stat;

import java.util.ArrayList;
import java.util.Collections;

public class Ungrouped {

  ArrayList list = new ArrayList<>();
  String title;
  
  int type;
  
  public Ungrouped() {
      list = null;
  }
  
  public Ungrouped(int t) {
      if(t == 1) {
          list = new ArrayList<Integer>();
          type = 1;
      }
      else {
          list = new ArrayList<Float>();
          type = 2;
      }  
  }
  
  public void initialTitle(String d) {
      title = d;
  }
  
  public void display() {
      System.out.println();
      System.out.println("********************************");
      System.out.println(title);
      for(int i = 0; i < list.size(); i++) {
          System.out.println(" [" + (i + 1) +"]:\t" + list.get(i));
      }        
  }
  
  public void display(String interpret) {
      displayResult();
      System.out.println();
      System.out.println("INTERPRETATION: " + interpret);
  }
  
  public void computeMean() {
      float sum = 0;
      float average = 0;
      float variance = 0;
      float stdeviation = 0;
      
      int sum_int = 0;
      int ave_int = 0;
      int variance_int = 0;
      int std_int = 0;
             
      if(type == 1) {
          for (int i = 0; i < list.size(); i++) {
              sum_int = sum_int + (int)list.get(i);
          }
          
          ave_int = sum_int / (int)list.size();
          System.out.println("Mean :" + ave_int);

          for (Object list1 : list) {
              variance_int = variance_int + (((int) list1 - ave_int) * ((int) list1 - ave_int));
          }
          variance_int = variance_int / ((int)list.size() - 1);
          std_int = (int) Math.sqrt(variance_int);

          System.out.print("Variance(s^2): " + variance_int);
          System.out.print("\tStandard Deviation: " + std_int);
      }
      else {
          for (int i = 0; i < list.size(); i++) {
              sum = sum + (float)list.get(i);
          }
          average = sum / (float)list.size();    
          System.out.println("Mean :" + average);
          
          for (Object list1 : list) {
              variance = variance + (((float) list1 - average) * ((float) list1 - average));
          }
          variance = variance / ((float)list.size() - 1);
          stdeviation = (float) Math.sqrt(variance);

          System.out.print("Variance(s^2): " + variance);
          System.out.print("\tStandard Deviation: " + stdeviation);
      }  
  }
  
  public void computeMedian() {
      float range = 0;
      float median = 0;
      
      int range_int = 0;
      int median_int = 0;
      
      Collections.sort(list);
      
      int mid1 = 0;
      int mid2 = 0;
      int size = list.size();
      
      if(type == 1) {
          range_int =  (int)list.get(size-1) - (int)list.get(0);

          if(size % 2 == 0){
              mid1 = size / 2;
              mid2 = mid1 + 1;
              median_int = ((int)list.get(mid1 - 1) + (int)list.get(mid2 - 1)) / 2;
          } else {
              mid1 = (size + 1) / 2;
              median_int = (int)list.get(mid1 - 1);
          }

          System.out.println("Median: " + median_int + "\tRange: "+ range_int);
      }
      else {
          range =  (float)list.get(size-1) - (float)list.get(0);

          if(size % 2 == 0){
              mid1 = size / 2;
              mid2 = mid1 + 1;
              median = ((float)list.get(mid1 - 1) + (float)list.get(mid2 - 1)) / 2;
          } else {
              mid1 = (size + 1) / 2;
              median = (float)list.get(mid1 - 1);
          }

          System.out.println("Median: " + median + "\tRange: "+ range);
      }
      
      
      
  }
  
  public void computeMode() {
      ArrayList modes;
      int maxCount = 0, modeCount = 0;
      
      if(type == 1)
          modes = new ArrayList<Integer>();
      else
          modes = new ArrayList<Float>();
      
      for(int i = 0; i < list.size(); i++){
          if(!(modes.contains(this.list.get(i)))){
              modes.add(list.get(i));
          }
      }
      int[] countModes = new int[modes.size()];
      for(int i = 0; i < modes.size(); i++){
          countModes[i] = 0;
      }
      
      for(int i = 0; i < modes.size(); i++){
          for(int j = 0; j < list.size(); j++){
              if(modes.get(i).equals(list.get(j))){
                  countModes[i]++;
              }
          }
          if(maxCount < countModes[i])
              maxCount = countModes[i];
      }
      
      for(int i = 0; i < countModes.length; i++){
          if(countModes[i] == maxCount)
              modeCount++;
      }
      
     
      if(modeCount == modes.size()){
          System.out.print("No Mode Value: ");
          System.out.println("no mode");
      }else{
          switch (modeCount) {
              case 1:
                  System.out.print("1 Mode: ");
                  System.out.println("unimodal");
                  break;
              case 2:
                  System.out.print("2 Modes: ");
                  System.out.println("bimodal");
                  break;
              default:
                  System.out.print(">=3 Modes: ");
                  System.out.println("multimodal");
                  break;
          }
          for(int i = 0; i < modes.size(); i++){
              if(countModes[i] == maxCount){
                  System.out.println(modes.get(i));
              }
          }
      }
  }
  
  public void displayResult() {
      System.out.println("\n\n");
      computeMean();                             
      System.out.println("\n");
      computeMedian();
      System.out.println();
      computeMode();
  }
  
  public void EditDataSet(int index, int num) {
      list.set(index - 1, num);
  }
  
  public void EditDataSet(int index, float num) {
      list.set(index - 1, num);
  }

}
