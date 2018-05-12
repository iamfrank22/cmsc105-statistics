package data_org;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Scanner;

public class DataSampling {
	private static Scanner input = new Scanner(System.in);
	
	ArrayList list;
	String dataTitle;
	
	int dataType;
  double[] percent;
  String[] str;
  double[] midpoint;
  int[] count;
	
	public DataSampling() {
		list = null;
		dataTitle = "";
		dataType = 0;
	}
	
	public DataSampling(int label, String title) {
		if(label == 1 || label == 2 || label == 3) {
			list = new ArrayList<String>();
		}
		else
		if(label == 4) {
			list = new ArrayList<Integer>();
		}
		else
		if(label == 5){
			list = new ArrayList<Float>();
		}
		dataType = label;
		dataTitle = title;
	}
	
	public void display() {
		System.out.println("\n\n");
		System.out.println("TITLE: " + dataTitle);
		System.out.println("==================================");
		for(int i = 0; i < list.size(); i++){
      System.out.print("\t[" + (i+1) + "] " + "\t\t" + list.get(i) + "\t");
      System.out.println();
		}
		System.out.println("==================================");
	}
	
	public void displaySummaryTable() {
     Collections.sort(list);
     
     String values = "Values";
     String per = "Percentage";
     String total = "Total: 100";
     ArrayList<String> temp = new ArrayList<>();
     
     for(int i = 0; i < list.size(); i++){
         if(!(temp.contains(this.list.get(i)))){
             temp.add((String) list.get(i));
         }
     }
     System.out.println("Summary Table");
     System.out.println("TITLE: " + dataTitle);
     System.out.format("%1$12s %2$20s %n", values, per);
     
     String[] t1 = new String[temp.size()];
     double[] t2 = new double[temp.size()];
     int[] t3 = new int[temp.size()];
     float ff;
     int ff1;
     
     for(int i = 0; i < temp.size(); i++){
         int count = 0;
         
         for(int j = 0; j < list.size(); j++ ){
             if(temp.get(i).equals(list.get(j))){
                 count++;
             }
         }
         t1[i] = (String) temp.get(i);
         ff = (float)(count * 100)/list.size() ;
         ff1 = Math.round(ff);
         t2[i] = ff1;
         t3[i] = count;
         System.out.println("\t" + temp.get(i)+ "\t\t"+ ff1);
     }
     
     System.out.format("%1$31s %n", total);
     
     System.out.println("");
     System.out.println("Frequency Counts");
     System.out.print("Value labels - ");
     for(int i = 0; i < t1.length; i++){
         System.out.print("\t"+ t1[i]);
     }
     System.out.println("");
     System.out.print("Total        - ");
     for(int i = 0; i < t1.length; i++){
         System.out.print(" \t"+ t3[i]);
     }
     System.out.println("");
     this.str = t1;
     this.percent = t2;
	}
	
	public void displayIntFDT(int choice) {
		System.out.println("\n\n");
		System.out.println("**************************************************************************************************");
		System.out.println("Frequency Distribution Table");
		System.out.println("TITLE: "+ dataTitle);
    int size = list.size();
    Collections.sort(list);
    
    int min = (int) list.get(0);
    int max = (int) list.get(list.size() - 1);
    
    int range = max - min;
    double m = Math.ceil(1 + (3.322 * Math.log10(size)));
    double width = Math.round(range/m);
    double[] t1 = new double[(int)m];
    int[] t2 = new int[(int)m];
    
    System.out.println("CLASSES: "+ m);
    System.out.println("RANGE: " + range);
    System.out.println("WIDTH: "+ width);
    
    System.out.println("\t CL \t TRUE CL \t MIDPOINTS \t FREQ \t % \t CF \t C% ");
    
    int tmp = min,tmin = min;
    int tmax, cf = 0; 
    double c = 0.0, midpoint, percentage;
    
    for(int i = 0; i < m; i++){
        int count = 0;
        tmax = (int) (tmin + width) - 1;
        
        if(tmax == max-1 && i == m-1){
            tmax = tmax + 1;
        }
        
        for(int j = 0; j < list.size(); j++){
            if((int)list.get(j) >= tmp && (int)list.get(j) <= tmax ){
                count++;
            }
        }
        
        midpoint = (tmp + tmax) / 2.0;
        percentage = (double)count  / (double)list.size()  * 100;
        
        cf = cf + count;
        c = c + percentage;
        
        t1[i] =   midpoint;
        t2[i] = count;
        
        String classLimit;
        String trueClassLimit;
        
        if (choice == 1 && i == 0 || (choice == 3 && i == 0)) {
            classLimit = "<" + tmax;
            trueClassLimit = "<" + ((double) tmax + 0.5);
        }else if (choice == 2 && i == (m - 1) || (choice == 3 && i == (m - 1))) {
            classLimit = ">" + tmp + "";
            trueClassLimit = ">" + ((double) tmp - 0.5);
        }else{
            classLimit = "" + tmp + "-" + tmax;
            trueClassLimit = "" + ((double) tmp - 0.5) + "-" + ((double) tmax + 0.5);
        }
        
        String mid = "-";
        if(choice == 1 || choice == 2 || choice == 3) {
          System.out.format("%1$12s %2$14s %3$11s %4$10d %5$10.1f%% %6$3d %7$10.1f%% %n", classLimit, trueClassLimit, mid, count, percentage, cf, c);

        }
        else {
          System.out.format("%1$12s %2$14s %3$11.1f %4$10d %5$10.1f%% %6$3d %7$10.1f%% %n", classLimit, trueClassLimit, midpoint, count, percentage, cf, c);
        }
        
        tmp = (int) (tmp + width );
        tmin = (int) (tmin + width );
    }
    
    System.out.println("\t    \t         \t           \t "+ list.size()+"\t100 \t  \t  ");
     
    int choice3 = 0;
		System.out.println("\n\n");
		System.out.println("**************************************************************************************************");
		System.out.println("Do you want to display the graph for the table?");
		System.out.println("[1] YES \n[2] NO");
		System.out.println("> ");
		
		if(!(choice >= 1 && choice <= 3)) {
			do {
				try {
					choice3 = input.nextInt();
					if(choice3 == 1) {
						Histogram.generateChart(dataTitle, dataTitle, t1, t2, (int) width);
					}
					if(choice3 < 1 || choice3 > 2) {
						throw new Exception();
					}
				} catch(Exception e) {
					System.out.println("Invalid input! Please try again.");
				}
				input.nextLine();
			} while(choice3 < 1 || choice3 > 2);
		}
	}
	
	public void displayFloatFDT(int choice){
		System.out.println("\n\n");
		System.out.println("**************************************************************************************************");
		System.out.println("Frequency Distribution Table");
		System.out.println("TITLE: "+ dataTitle);
		int size = list.size();
		Collections.sort(list);
		
//		Formatter fmt = new Formatter();
		
		float min = (float) list.get(0);
		float max = (float) list.get(list.size() - 1);
		
		double range = max - min ;
		double m = Math.ceil(1 + (3.322 * Math.log10(size)));
		double width = (range/m);
		
		double[] t1 = new double[(int)m];
		int[] t2 = new int[(int)m];
		
		
		
		System.out.println("CLASSES: "+ m);
		System.out.println("RANGE: " + String.format("%.1f", range));
		System.out.println("WIDTH: "+ String.format("%.1f", width));
		
		System.out.println("\t CL \t TRUE CL \t MIDPOINTS \t FREQ \t % \t CF \t C% ");
		
		double tmp = min,tmin = min;
		double tmax;
		int cf = 0; 
		double c = 0.0, midpoint, percentage;
		
		for(int i = 0; i < m; i++){
		    int count = 0;
		    tmax = (tmin + width - 1) ;
		    
		    for(int j = 0; j < list.size(); j++){
		        if((float)list.get(j) >= tmp && (float)list.get(j) <= tmax ){
		            count++;
		        }
		    }
		    
		    midpoint = (tmp + tmax) / 2.0;
		    percentage = (double)count  / (double)list.size()  * 100;
		    
		    cf = cf + count;
		    c = c + percentage;
		    
		    t1[i] =   midpoint;
		    t2[i] = count;
		    
		    String classLimit;
		    String trueClassLimit;
		    
		    if (choice == 1 && i == 0 || (choice == 3 && i == 0)) {
		        classLimit = "<" + String.format("%.2f", tmax);
		        trueClassLimit = "<" + String.format("%.2f", ((double) tmax + 0.05));
		        for(int j = 0; j < t1.length; j++) {
		        	t1[j] = 0;
		        }
		    }else if (choice == 2 && i == (list.size() - 1) || (choice == 3 && i == (list.size() - 1))) {
		        classLimit = ">" + String.format("%.2f", tmp) + "";
		        trueClassLimit = ">" + String.format("%.2f", ((double) tmp - 0.05));
		        for(int j = 0; j < t1.length; j++) {
		        	t1[j] = 0;
		        }
		    }else{
		        classLimit = "" + String.format("%.2f", tmp) + "-" + String.format("%.2f", tmax);
		        trueClassLimit = "" + String.format("%.2f", ((double) tmp - 0.05)) + "-" + String.format("%.2f", ((double) tmax + 0.05));
		    }
		    
		    if(choice == 1 || choice == 2 || choice == 3) {
        	midpoint = 0;
        }
		    
		    String mid = "-";
        if(choice == 1 || choice == 2 || choice == 3) {
          System.out.format("%1$12s %2$14s %3$11s %4$10d %5$10.1f%% %6$3d %7$10.1f%% %n", classLimit, trueClassLimit, mid, count, percentage, cf, c);

        }
        else {
          System.out.format("%1$12s %2$14s %3$11.1f%% %4$10d %5$10.1f%% %6$3d %7$10.1f%% %n", classLimit, trueClassLimit, midpoint, count, percentage, cf, c);
        }
		    
		    tmp = (int) (tmp + width );
		    tmin = (int) (tmin + width );
		}
		
		System.out.println("\t    \t         \t           \t "+ list.size()+"\t100 \t  \t  ");
		
		this.midpoint = t1;
		this.count = t2;
		
		int choice3 = 0;
		System.out.println("\n\n");
		System.out.println("**************************************************************************************************");
		System.out.println("Do you want to display the graph for the table?");
		System.out.println("[1] YES \n[2] NO");
		System.out.println("> ");
		
		if(!(choice >= 1 && choice <= 3)) {
			do {
				try {
					choice3 = input.nextInt();
					if(choice3 == 1) {
						Histogram.generateChart(dataTitle, dataTitle, t1, t2, (int) width);
					}
					if(choice3 < 1 || choice3 > 2) {
						throw new Exception();
					}
				} catch(Exception e) {
					System.out.println("Invalid input! Please try again.");
				}
				input.nextLine();
			} while(choice3 < 1 || choice3 > 2);
		}
	}
	
	public void displayGraph() {
		if(dataType >= 1 || dataType <= 3) {
			PieChart.generateChart(this.str, this.percent, dataTitle);
		}
	}
	
	public boolean isNumeric(String st) {
		int ctr = 0;
		for(int i = 0; i < st.length(); i++) {
			if(st.charAt(i) == '.' && ctr == 0) {
				ctr++;
			}
			else
			if(!(st.charAt(i) >= '0' && st.charAt(i) <= '9')) {
				return false;
			}
		}
		return true;
		
	}
	
	public boolean isAlphabetic(String st) {
		if(st.length() > 1) {
			return false;
		}
		for(int i = 0; i < st.length(); i++) {
			if(!(st.charAt(i) >= 'a' && st.charAt(i) <= 'z') && !(st.charAt(i) >= 'A' && st.charAt(i) <= 'Z')) {
				return false;
			}
		}
		return true;
	}
}
