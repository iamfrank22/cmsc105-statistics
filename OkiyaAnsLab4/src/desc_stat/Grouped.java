package desc_stat;

public class Grouped {

  float[][] data;
  int[][] int_data;
  int data_type;
  int oc;
  
  int num_freq;
  int num_fxm;
  int num_fxm2;
  
  float frequency;
  float fxm;
  float fxm2;
  
  String title;
  
  public Grouped() {
      data = new float[0][0];
      int_data = new int[0][0];
  }
  
  public Grouped(int interval, int type, int open_close) {
      frequency = 0;
      fxm = 0;
      fxm2 = 0;
      num_freq = 0;
      num_fxm = 0;
      num_fxm2 = 0;
      title = "";
      data_type = type;
      oc = open_close;
      
      if(data_type == 1) {
          int_data = new int[interval][6];
      }
      else {
          data = new float[interval][6];
      }
  }
  
  public void initialTitle(String d) {
      title = d;
  }
  
  public void display() {
      float total_freq = 0;
      float total_fxm = 0;
      float total_fxm2 = 0;
     
      int freq_int = 0;
      int fxm_int = 0;
      int fxm2_int = 0;
     
      System.out.println("\n\n");
      System.out.println("GROUPED: " + title);
      System.out.println("*************************************************************");
      System.out.println(" LC \tUC \tF \tM \tFxM \tFxM2");
     
      if(data_type == 1) {
          for(int i = 0; i < int_data.length; i++) {
              System.out.print("");

              if(int_data[i][0] == -1)
                  System.out.print("--");
              else
                  System.out.print(int_data[i][0]);

              System.out.print("   |   ");

              if(int_data[i][1] == -1)
                  System.out.print("--");
              else
                  System.out.print(int_data[i][1]);

              System.out.print("   |   "+ int_data[i][2]+ "   |   ");

              if(int_data[i][3] == -1)
                  System.out.print("--");
              else
                  System.out.print(int_data[i][3]);

              System.out.print("   |   ");

              if(int_data[i][4] == -1)
                  System.out.print("--");
              else
                  System.out.print(int_data[i][4]);

              System.out.print("   |   ");

              if(int_data[i][5] == -1)
                  System.out.print("--");
              else
                  System.out.print(int_data[i][5]);

              System.out.println("");

              freq_int = freq_int + int_data[i][2];        
              fxm_int = fxm_int + int_data[i][4]; 
              fxm2_int  = fxm2_int + int_data[i][5];
          }
              if(int_data[0][0] == -1 || int_data[int_data.length -1][1] == -1){
                  fxm_int = 0;
                  fxm2_int = 0;
              }
              num_freq = freq_int;
              num_fxm = fxm_int;
              num_fxm2 = fxm2_int;
              System.out.println("------|-------|-------|-------|-------|-------|");
              System.out.println("      |       |n = " + freq_int + " |-------|t = " + fxm_int + "  |" + "     " + fxm2_int + "|");
      }
      else {
          for(int i = 0; i < data.length; i++) {
              System.out.print("");

              if(data[i][0] == -1)
                  System.out.print("--");
              else
                  System.out.print(data[i][0]);

              System.out.print("   |   ");

              if(data[i][1] == -1)
                  System.out.print("--");
              else
                  System.out.print(data[i][1]);

              System.out.print("   |   "+ data[i][2]+ "   |   ");

              if(data[i][3] == -1)
                  System.out.print("--");
              else
                  System.out.print(data[i][3]);

              System.out.print("   |   ");

              if(data[i][4] == -1)
                  System.out.print("--");
              else
                  System.out.print(data[i][4]);

              System.out.print("   |   ");

              if(data[i][5] == -1)
                  System.out.print("--");
              else
                  System.out.print(data[i][5]);

              System.out.println("");

              total_freq = total_freq + data[i][2];        
              total_fxm = total_fxm + data[i][4]; 
              total_fxm2  = total_fxm2 + data[i][5];
          }
              if(data[0][0] == -1 || data[data.length -1][1] == -1){
                  total_fxm = 0;
                  total_fxm2 = 0;
              }
              frequency = total_freq;
              fxm = total_fxm;
              fxm2 = total_fxm2;
              System.out.println("------|-------|-------|-------|-------|-------|");
              System.out.println("      |       |n = "+ total_freq+"|-------|t = " + total_fxm + "|" + total_fxm2 + "|");
      } 
  }
  
  public void display(String interpret) {
  		System.out.println("\n\n");
      System.out.println("*************************************************************");
      displayResult();
      System.out.println();
      System.out.println("INTERPRETATION: " + interpret);
  }
  
  public void getMean() {
      float average = 0;
      float variance = 0;
      float stdeviation = 0;
      
      int ave = 0;
      int var = 0;
      int std = 0;
      
      if(data_type == 1) {
          if(oc == 2) {
              ave = this.num_fxm / this.num_freq;
              var = ((this.num_freq * this.num_fxm2) - (this.num_fxm * this.num_fxm)) / (this.num_freq * (this.num_freq - 1));
              std = (int) Math.sqrt(var);
              System.out.println("Mean: "+ ave);
              System.out.print("Variance: "+ var);
              System.out.print("\tStandard Deviation: "+ std);
          }
          else {
              System.out.println("MEAN, VARIANCE, and STANDARD DEVIATION cannot be calculated.");
          }
      }
      else {
          if(oc == 2) {
              average = this.fxm / this.frequency;
              variance = ((this.frequency * this.fxm2) - (this.fxm * this.fxm)) / (this.frequency * (this.frequency - 1));
              stdeviation = (float) Math.sqrt(variance);
              System.out.println("Mean: "+ average);
              System.out.print("Variance: "+ variance);
              System.out.print("\tStandard Deviation: "+ stdeviation);
          }
          else {
              System.out.println("MEAN, VARIANCE, and STANDARD DEVIATION cannot be calculated.");
          }
      }
  } 
  
  public void getMedian() {
      System.out.println();
      System.out.println("MEDIAN cannot be calculated.");
  }
  
  public void getMode() {
      double tmp = max();
      int modal = 0;
      int modal_num = 0;
      
      if(data_type == 1) {
          for(int i = 0; i < int_data.length; i++) {
              if (int_data[i][2] == tmp) {
                  modal_num++;
              }
          }
      }
      else {
          for(int i = 0; i < data.length; i++) {
              if(data[i][2] == tmp) {
                  modal++;
              }
          }
      }
      
      
      if(data_type == 1) {
          if(modal_num == int_data.length){
              System.out.print("No Modal Class:");
              System.out.println("no mode");
          }
          else{
              switch (modal_num) {
                  case 1:
                      System.out.print("1 Modal Class:");
                      System.out.println("unimodal");
                      break;
                  case 2:
                      System.out.print("2 Modal Classes:");
                      System.out.println("bimodal");
                      break;
                  default:
                      System.out.print(">=3 Modal Classes:");
                      System.out.println("multimodal");
                      break;
              }
              for (int i = 0; i < int_data.length; i++) {
                  if (int_data[i][2] ==  tmp) {
                      if(int_data[i][0] == -1)
                          System.out.println("<" + int_data[i][1]);
                      else if(int_data[i][1] == -1)
                          System.out.println(int_data[i][0] + "<");                       
                      else
                      System.out.println(int_data[i][0] + "-" + int_data[i][1]);
                  }
              }
          }   
      }
      else {
          if(modal == data.length){
              System.out.print("No Modal Class:");
              System.out.println("no mode");
          }
          else{
              switch (modal) {
                  case 1:
                      System.out.print("1 Modal Class:");
                      System.out.println("unimodal");
                      break;
                  case 2:
                      System.out.print("2 Modal Classes:");
                      System.out.println("bimodal");
                      break;
                  default:
                      System.out.print(">=3 Modal Classes:");
                      System.out.println("multimodal");
                      break;
              }
              for (int i = 0; i < data.length; i++) {
                  if (data[i][2] ==  tmp) {
                      if(data[i][0] == -1)
                          System.out.println("<" + data[i][1]);
                      else if(data[i][1] == -1)
                          System.out.println(data[i][0] + "<");                       
                      else
                      System.out.println(data[i][0] + "-" + data[i][1]);
                  }
              }
          }   
      }
  }
  
  public void displayResult() {
      System.out.println("\n\n");
      getMean();                             
      System.out.println();
      getMedian();
      System.out.println();
      getMode();
  }
  
  public double max() {
      double max = 0;
      
      if(data_type == 1) {
          for(int i = 0; i < int_data.length; i++) {
              if(max < int_data[i][2]) {
                  max = int_data[i][2];
              }
          }
      }
      else {
          for(int i = 0; i < data.length; i++) {
              if(max < data[i][2]) {
                  max = data[i][2];
              }
          }
      }
      return max;
  }

}
