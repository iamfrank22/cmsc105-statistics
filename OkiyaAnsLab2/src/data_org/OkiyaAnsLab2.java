package data_org;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OkiyaAnsLab2 {
	
	public static void simulate() {
		Scanner input = new Scanner(System.in);
		
		DataSampling sample = new DataSampling();
		
		int choice = -1;
		int size =  -1;
		int label = -1;
		int intNum = -1;
		int repeat = 0;
		float floatNum = -1;
		
		String desc = "";
		String strCat = "";
		
		do {
			System.out.println();
			System.out.println("********************************");
			System.out.println("SUMMARIZING AND PRESENTING DATA");
			System.out.println("********************************");
			System.out.println();
			System.out.println("[1] CATEGORICAL");
			System.out.println("[2] NUMERICAL");
			System.out.println("[3] QUIT");
			System.out.println("********************************");
			do {
				System.out.println();
				System.out.println("Choose the type of data you want to summarize and present.");
				try {
					choice = input.nextInt();
				} catch(InputMismatchException e) {
					choice = -1;
					System.out.println("Invalid input! Please try again.");
				}
				input.nextLine();
			} while(choice < 1 || choice > 3);
			
			if(choice >= 1 && choice <= 2) {
				System.out.println();
				System.out.println("********************************");
				System.out.println("Enter a brief description about the data.");
				desc = input.nextLine();
				
				do {
					System.out.println();
					System.out.println("********************************");
					System.out.println("Enter the number of data.");
					try {
						size = Integer.parseInt(input.nextLine());
						break;
					} catch(NumberFormatException e) {
						size = -1;
						System.out.println("Invalid input! Please try again.");
					}
				} while(size < 1);
			}
			
			switch(choice) {
			case 1:
				System.out.println("\n\n");
				System.out.println("********************************");
				System.out.println("******* CATEGORICAL DATA *******");
				System.out.println("********************************");
				System.out.println();
				System.out.println("[1] NUMERIC Label");
				System.out.println("[2] ALPHABETIC Label");
				System.out.println("[3] STRING Label");
				System.out.println("********************************");
				do {
					System.out.println();
					System.out.println("********************************");
					System.out.println("Choose the data label you want.");
					try {
						label = input.nextInt();
					} catch(InputMismatchException e) {
						label = -1;
						System.out.println("Invalid input! Please try again.");
					}
					input.nextLine();
				} while(label < 1 || label > 3);
				
				break;
				
			case 2:
				System.out.println("\n\n");
				System.out.println("********************************");
				System.out.println("******** NUMERICAL DATA ********");
				System.out.println("********************************");
				System.out.println();
				System.out.println("[4] INTEGER Label");
				System.out.println("[5] FLOAT Label");
				System.out.println("********************************");
				do {
					System.out.println();
					System.out.println("********************************");
					System.out.println("Choose the data label you want.");
					try {
						label = input.nextInt();
					} catch(InputMismatchException e) {
						label = -1;
						System.out.println("Invalid input! Please try again.");
					}
					input.nextLine();
				}while(label < 4 || label > 5);
				
				break;
				
			default:
				try{
					System.out.println("\n\n");
          System.out.println("Program terminating.... ");
          try{
              Thread.sleep(2000);
              System.exit(0);
          } catch(InterruptedException e) {
              Thread.currentThread().interrupt();
          }       
				} catch(Exception e) {
					input.nextLine();
				}
				break;
			}
			
			sample = new DataSampling(label, desc);
			
			if(label == 1) {
				System.out.println("\n\n");
				System.out.println("********************************");
				System.out.println("CATEGORICAL DATA: Numeric Label");
				for(int i = 0; i < size; i++) {
					System.out.println();
					System.out.println("Sample " + (i + 1) + ": ");
					do {
						try {
							strCat = input.next();
							if(sample.isNumeric(strCat) == false) {
								throw new Exception();
							}
						} catch(Exception e) {
							System.out.println("Invalid input! Please try again.");
							strCat = "";
						}
						input.nextLine();
					} while(strCat == "");
					sample.list.add(strCat);
				}
			}
			else
			if(label == 2) {
				System.out.println("\n\n");
				System.out.println("********************************");
				System.out.println("*** CATEGORICAL DATA: Alphabetic Label ***");
				for(int i = 0; i < size; i++) {
					System.out.println();
					System.out.println("Sample " + (i + 1) + ": ");
					do {
						try {
							strCat = input.next();
							if(sample.isAlphabetic(strCat) == false) {
								throw new Exception();
							}
						} catch(Exception e) {
							System.out.println("Invalid input! Please try again.");
							strCat = "";
						}
						input.nextLine();
					} while(strCat == "");
					sample.list.add(strCat);
				}
			}
			else
			if(label == 3) {
				System.out.println("\n\n");
				System.out.println("********************************");
				System.out.println("*** CATEGORICAL DATA: String Label ***");
				for(int i = 0; i < size; i++) {
					System.out.println();
					System.out.println("Sample " + (i + 1) + ": ");
					do {
						try {
							strCat = input.next();
						} catch(Exception e) {
							System.out.println("Invalid input! Please try again.");
							strCat = "";
						}
						input.nextLine();
					} while(strCat == "");
					sample.list.add(strCat);
				}
			}
			else
			if(label == 4) {
				System.out.println("\n\n");
				System.out.println("********************************");
				System.out.println("*** NUMERICAL DATA: Integer Label");
				for(int i = 0; i < size; i++) {
					System.out.println();
					System.out.println("Sample " + (i + 1) + ": ");
					do {
						try {
							intNum = input.nextInt();
						} catch(InputMismatchException e) {
							intNum = -1;
							System.out.println("Invalid input! Please try again.");
						}
						input.nextLine();
					} while(intNum < 1);
					sample.list.add(intNum);
				}
			}
			else 
			if(label == 5) {
				System.out.println("\n\n");
				System.out.println("********************************");
				System.out.println("*** NUMERICAL DATA: Float Label");
				for(int i = 0; i < size; i++) {
					System.out.println();
					System.out.println("Sample " + (i + 1) + ": ");
					do {
						try {
							floatNum = input.nextFloat();
						} catch(InputMismatchException e) {
							floatNum = -1;
							System.out.println("Invalid input! Please try again.");
						}
						input.nextLine();
					} while(floatNum < 1);
					sample.list.add(floatNum);
				}
			}
			
			sample.display();
			
			System.out.println("\n\n");
			System.out.println("Press ENTER to continue...");
      input.nextLine();
      try{
        Thread.sleep(2000);
      } catch(InterruptedException e) {
        Thread.currentThread().interrupt();
      }
      
      do {
				if(label >= 1 && label <= 3) {
					sample.displaySummaryTable();
				}
				
				if(label == 4) {
					int choice1 = -1;
					sample.displayIntFDT(choice1);
					System.out.println("\n\n");
					System.out.println("********************************");
					System.out.println("********* CLASS LIMITS *********");
					System.out.println();
					System.out.println("[1] FIRST");
					System.out.println("[2] LAST");
					System.out.println("[3] BOTH");
					System.out.println("********************************");
					do {
						System.out.println();
						System.out.println("What class limit/s do you want to collapse?");	
						try {
							choice1 = input.nextInt();
						} catch(InputMismatchException e) {
							choice1 = -1;
							System.out.println("Invalid input! Please try again.");
						}
						input.nextLine();
					} while(choice1 < 1 || choice1 > 3);
					sample.displayIntFDT(choice1);
				}
				
				if(label == 5) {
					int choice2 = -1;
					sample.displayFloatFDT(choice2);
					System.out.println("\n\n");
					System.out.println("********************************");
					System.out.println("********* CLASS LIMITS *********");
					System.out.println();
					System.out.println("[1] FIRST");
					System.out.println("[2] LAST");
					System.out.println("[3] BOTH");
					System.out.println("********************************");
					do {
						System.out.println();
						System.out.println("What class limit/s do you want to collapse? > ");
						try {
							choice2 = input.nextInt();
						} catch(InputMismatchException e) {
							choice2 = -1;
							System.out.println("Invalid input! Please try again.");
						}
						input.nextLine();
					} while(choice2 < 1 || choice2 > 3);
					sample.displayFloatFDT(choice2);
				}
				
				if(label >= 1 && label <= 3) {
					int choice3 = -1;
					System.out.println("\n\n");
					System.out.println("********************************");
					System.out.println("Do you want to display the graph for the table?");
					System.out.println("[1] YES");
					System.out.println("[2] NO");
					do {
						System.out.println();
						try {
							choice3 = input.nextInt();
							if(choice3 == 1) {
								sample.displayGraph();
							}
						} catch(InputMismatchException e) {
							choice3 = -1;
							System.out.println("Invalid input! Please try again.");
						}
						input.nextLine();
					} while(choice3 < 1 || choice3 > 2);
				}
				
				int choice4 = -1;
				System.out.println("\n\n");
				System.out.println("********************************");
				System.out.println("Do you want to display the table again? > ");
				System.out.println("[1] YES");
				System.out.println("[2] NO");	
				do {
					System.out.println();
					try {
						choice4 = input.nextInt();
					} catch(InputMismatchException e) {
						choice4 = -1;
						System.out.println("Invalid input! Please try again.");
					}
					input.nextLine();
				} while(choice4 < 1 || choice4 > 2);
				
				if(choice4 == 2) {
					repeat = 1;
				}
				else {
					repeat = 0;
				}
			} while(repeat == 0);
      
      System.out.println("\n\n\n\n\n");
		} while(choice != 3);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 simulate();
	}
}
