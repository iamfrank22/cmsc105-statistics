package sampling_methods;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OkiyaAnsLab1 {
	
	private static Scanner input = new Scanner(System.in);
	
	public static void simulate() {
		Sampling sample = new Sampling();
		
		int choice = -1;
		int pop_size = -1;
		int data_type = -1;
		int size_choice = -1;
		int sample_size = -1;
		int percent = -1;
		int repeat = 0;
		
		
		int[] numList;
		char[] charList;
		
		do {
			System.out.println();
			System.out.println("********************************");
			System.out.println("**** BASIC SAMPLING METHODS ****");
			System.out.println("********************************");
			System.out.println();
			System.out.println("[1] SIMPLE RANDOM");
			System.out.println("[2] SYSTEMATIC");
			System.out.println("[3] STRATIFIED");
			System.out.println("[4] QUIT");
			System.out.println("********************************");
			
			do {
				System.out.println();
				System.out.println("Choose a sampling method to simulate. >");
				try {
					choice = input.nextInt();
				} catch(InputMismatchException e) {
					choice = -1;
					System.out.println("Invalid input! Please try again.");
				}
				input.nextLine();
			} while(choice < 1 || choice > 4);
			
			System.out.println();
			if(choice >= 1 && choice <= 3) {
				do {
					System.out.println();
					System.out.println("********************************");
					System.out.println("Enter the population size. > ");
					try {
						pop_size = Integer.parseInt(input.nextLine());
						break;
					} catch(NumberFormatException e) {
						pop_size = -1;
						System.out.println("Invalid input! Please try again.");
					}
				} while(pop_size < 1);
				
				System.out.println();
				do {
					System.out.println();
					System.out.println("********************************");
					System.out.println("Which of the following data type do you prefer?");
	        System.out.println("[1] NUMERICAL");
	        System.out.println("[2] CHARACTER");
	        try {
	        	data_type = input.nextInt();
	        } catch(InputMismatchException e) {
	        	data_type = -1;
	        	System.out.println("Invalid input! Please try again.");
	        }
	        input.nextLine();
				} while(data_type < 1 || data_type > 2);
				
				if(data_type == 1) {
	        sample = new Sampling(1);
	      } else
	        if(data_type == 2) {
	        sample = new Sampling(2);
	      }
	      
	      numList = new int[pop_size];
	      charList = new char[pop_size];
				
				if(data_type == 1) {
	        for(int ctr = 0; ctr < pop_size; ctr++) {
	        	System.out.println();
	          System.out.println("Sample " + (ctr + 1) + ": ");
	          
	          do{
	            try{
	              numList[ctr] = input.nextInt();
	            }catch(InputMismatchException e) {
	            	numList[ctr] = -1;
	              System.out.println("Invalid input! Please try again.");
	            }
	            input.nextLine();
	          }while(numList[ctr] < 1);
	        }
	        
	        sample.Sampling(numList, pop_size);
	      } else 
	        if(data_type == 2) {
	        for(int ctr = 0; ctr < pop_size; ctr++) {
	          System.out.println("Sample " + (ctr + 1) + ": ");
	          
	          do{
	            try{
	              charList[ctr] = input.next().charAt(0);     
	              if(charList[ctr] >= '0' && charList[ctr] <= '9')
	                throw new Exception();
	            }catch(Exception e) {
	              System.out.println("Invalid input! Please try again.");
	            }
	            
	            input.nextLine();
	          }while(charList[ctr] >= '0' && charList[ctr] <= '9');
	        }
	        sample.Sampling(charList, pop_size);
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
			}
			
			switch(choice) {
			case 1:
				do {
					System.out.println("\n\n");
					System.out.println("********************************");
					System.out.println("**** SIMPLE RANDOM SAMPLING ****");
					System.out.println("********************************");
					do {
						System.out.println();
						System.out.println("Do you want to input sample size?");
						System.out.println("[1] YES");
						System.out.println("[2] NO");
						try {
							size_choice = input.nextInt();
						} catch(InputMismatchException e) {
							size_choice = -1;
							System.out.println("Invalid input! Please try again.");
						}
						input.nextLine();
					} while(size_choice < 1 || size_choice > 2);
					
					if(size_choice == 1) {
						do {
							System.out.println();
							System.out.println("********************************");
							System.out.println("Enter the sample size");
							try {
								sample_size = Integer.parseInt(input.nextLine());
								break;
							} catch(NumberFormatException e) {
								sample_size = -1;
								System.out.println("Invalid input! Please try again.");
							}
							input.nextLine();
						} while(sample_size < pop_size && sample_size < 1);
					}
					else {
						sample_size = (int) Math.ceil(pop_size * 0.20);
					}
					
					sample.SimpleRandom(sample_size);
					
					int choice4 = -1;
          
          do {
          	System.out.println("\n\n");
          	System.out.println("********************************");
            System.out.println("Do you want to display the simualation again?");
            System.out.println("[1] YES");
            System.out.println("[2] NO");
	          try {
	              choice4 = input.nextInt();
	          } catch(InputMismatchException e) {
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
				
				System.out.println("\n\n");
				break;
				
			case 2:
				do {
					System.out.println("\n\n");
					System.out.println("********************************");
					System.out.println("**** SYSTEMATIC SAMPLING ****");
					System.out.println("********************************");
					do {
						System.out.println();
						System.out.println("Do you want to input sample size?");
						System.out.println("[1] YES");
						System.out.println("[2] NO");
						try {
							size_choice = input.nextInt();
						} catch(InputMismatchException e) {
							size_choice = -1;
							System.out.println("Invalid input! Please try again.");
						}
						input.nextLine();
					} while(size_choice < 1 || size_choice > 2);
					
					if(size_choice == 1) {
						do {
							System.out.println();
							System.out.println("********************************");
							System.out.println("Enter the sample size");
							try {
								sample_size = Integer.parseInt(input.nextLine());
								break;
							} catch(NumberFormatException e) {
								sample_size = -1;
								System.out.println("Invalid input! Please try again.");
							}
							input.nextLine();
						} while(sample_size < pop_size && sample_size < 1);
					}
					else {
						sample_size = (int) Math.ceil(pop_size * 0.20);
					}
					
					sample.Systematic(sample_size);
					
					int choice4 = -1;
          
          do {
          	System.out.println("\n\n");
          	System.out.println("********************************");
            System.out.println("Do you want to display the simualation again?");
            System.out.println("[1] YES");
            System.out.println("[2] NO");
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
				
				System.out.println("\n\n");
				break;
			
			case 3:
				do{
					System.out.println("\n\n");
					System.out.println("********************************");
					System.out.println("**** STRATIFIED SAMPLING ****");
					System.out.println("********************************");
					System.out.println();
					sample.segregate();
					System.out.println();
					do{
						System.out.println("");
						System.out.println("********************************");
						System.out.println("Enter the sample percentage");
						try{
							percent = Integer.parseInt(input.nextLine());
							break;
						}catch(NumberFormatException e) {
							percent = -1;
							System.out.println("Invalid input! Please try again.");
						}
					}while(percent < 1 || percent > 100);
					
					System.out.println("\n\n");
					sample.Stratified(percent);
					
					int choice4 = -1;
          
          do {
          	System.out.println("\n\n");
          	System.out.println("********************************");
            System.out.println("Do you want to display the simualation again?");
            System.out.println("[1] YES");
            System.out.println("[2] NO");
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
				}while(repeat == 0);
				
				System.out.println("\n\n");
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
		} while(choice != 4);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		simulate();
	}

}
