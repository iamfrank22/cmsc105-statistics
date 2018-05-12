package desc_stat;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OkiyaAnsLab3 {

  private static Scanner input = new Scanner(System.in);
  
  public static void simulate() {
      int choice = -1;
      String desc = "";
      String interpret = "";
      int type = -1;
      int size = -1;
      int edit = 0;
      int repeat = 0;
      int data_int = -1;
      float data_float = -1;
      Ungrouped ug = new Ungrouped();
      Grouped grp = new Grouped();
      
      do {
	      	System.out.println();
	  			System.out.println("********************************");
          System.out.println("**** DESCRIPTIVE STATISTICS ****");
	  			System.out.println("********************************");
          System.out.println();
          System.out.println("[1] Ungrouped");
          System.out.println("[2] Grouped");
          System.out.println("[3] Quit");
          System.out.println("********************************");          
          do {
          		System.out.println();
            	System.out.println("Choose the data you want to measure the central tendency with.");
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
              System.out.println("Enter the data description.");
              desc = input.nextLine();
              
              System.out.println("\n\n");
              System.out.println("********************************");
              System.out.println("[1] Integer");
              System.out.println("[2] Float");
              System.out.println("********************************");
              do{
              		System.out.println();
                	System.out.println("Enter the type of data.");
                  try{
                      type = input.nextInt();
                  } catch(InputMismatchException e) {
                  		type = -1;
                      System.out.println("Invalid input! Please try again.");
                  }
                  input.nextLine();
              } while(type < 1 || type > 2);
          }
          
          
          switch(choice) {
              case 1:
                  do {
	                  	System.out.println();
	                    System.out.println("********************************");
	                    System.out.println("Enter the total number of data.");
                      try{
                          size = input.nextInt();
                      } catch(InputMismatchException e) {
                      		size = -1;
                          System.out.println("Invalid input! Please try again.");
                      }
                      input.nextLine();
                  } while(size < 1);
                  
                  ug = new Ungrouped(type);
                  ug.initialTitle(desc);
                  
                  System.out.println("\n\n");
                  System.out.println("********************************");
                  System.out.println("UNGROUPED DATA: " + desc);
                  
                  if(type == 1) {
                      for(int i = 0; i < size; i++) {
                      		System.out.println();
                          System.out.println("Sample " + (i + 1) + ": ");
                          do {
                          	try {
                          		data_int = input.nextInt();
                          	} catch(InputMismatchException e) {
                          		data_int = -1;
                          		System.out.println("Invalid input! Please try again.");
                          	}
                          	input.nextLine();
                          } while(data_int < 1);
                          
                          ug.list.add(data_int);                       
                      }
                      ug.display();
                  }
                  else {
                      for(int i = 0; i < size; i++) {
                      		System.out.println();
                          System.out.println("Sample " + (i + 1) + ": ");
                          do {
                          	try {
                          		data_float = input.nextFloat();
                          	} catch(InputMismatchException e) {
                          		data_float = -1;
                          		System.out.println("Invalid input! Please try again.");
                          	}
                          	input.nextLine();
                          } while(data_float < 1);
                          
                          ug.list.add(data_float);                       
                      }
                      ug.display();
                  }
                 
                  int choice2 = -1;
                  int index2 = -1;
                  do {
                      System.out.println("\n\n");
                      System.out.println("********************************");
                      System.out.println("What do you want to do?");
                      System.out.println("[1] Edit");
                      System.out.println("[2] Continue");
                      try {
                          choice2 = input.nextInt(); 
                          if(choice2 == 1) {
                          		do {
                          			System.out.println();
                          			System.out.println("Enter the index of the value you want to replace with.");
                                System.out.println("(1 - " + size + "): ");
                                
                                do {
                                	try {
                                		index2 = input.nextInt();
                                	} catch(InputMismatchException e) {
                                		index2 = -1;
                                		System.out.println();
                                	}
                                	input.nextLine();
                                } while(index2 < 1 || index2 > size);
                                
                                System.out.println();
                                System.out.println("********************************");
                                System.out.println("Enter replacement value.");
                                if(type == 1) {
                                	do {
                                  	try {
                                  		data_int = input.nextInt();
                                  	} catch(InputMismatchException e) {
                                  		data_int = -1;
                                  		System.out.println("Invalid input! Please try again.");
                                  	}
                                  	input.nextLine();
                                  } while(data_int < 1);
                                  ug.EditDataSet(index2, data_int);
                                  ug.display();	
                                }
                                else {
                                	do {
                                  	try {
                                  		data_float = input.nextFloat();
	                                  } catch(InputMismatchException e) {
	                                  	data_float = -1;
	                                  	System.out.println("Invalid input! Please try again.");
	                                  }
	                                  	input.nextLine();
	                                } while(data_float < 1);
                                  ug.EditDataSet(index2, data_float);
                                  ug.display();
                                }
                                
                                int edit_choice = -1;
                                System.out.println("\n\n");
                                System.out.println("Do you want to edit the data set again?");
                                System.out.println("[1] YES \n[2] NO");
                                
                                do {
                                    try {
                                        edit_choice = input.nextInt();
                                    } catch(InputMismatchException e) {
                                    		edit_choice = -1;
                                        System.out.println("Invalid input! Please try again.");
                                    }
//                                    input.nextLine();
                                } while(edit_choice < 1 || edit_choice > 2);

                                if(edit_choice == 2) {
                                    edit = 1;
                                }
                                else {
                                    edit = 0;
                                }
                          		} while(edit == 0);
                          		System.out.println("\n\n");
                          }
                          else {
                              break;
                          } 
                      } catch(InputMismatchException e) {
                      		choice2 = -1;
                          System.out.println("Invalid input! Please try again.");
                      }
                      input.nextLine();
                  } while(choice2 < 1 || choice2 > 2);
                  
                  int choice3 = -1;
                  System.out.println("\n\n");
                  System.out.println("**************************************");                    
                  System.out.println("**** MEASURES OF CENTRAL TENDENCY ****");
                  System.out.println("**************************************");                    
                  System.out.println();
                  System.out.println("[1] Mean");
                  System.out.println("[2] Median");
                  System.out.println("[3] Mode");
                  System.out.println("[4] All");
                  System.out.println("********************************");                    
                  
                  do {
                  		System.out.println();
                  		System.out.println("What measurement to do you want to use? > ");
                      try {
                          choice3 = input.nextInt();
                      } catch(InputMismatchException e) {
                      		choice3 = -1;
                          System.out.println("Invalid input! Please try again.");
                      }
                      input.nextLine();
                  } while(choice3 < 1 || choice3 > 4);
                  
                  do { 
                      System.out.println("\n\n");
                      System.out.println("****************************************************************");

                      switch (choice3) {
                          case 1:
                              ug.computeMean();
                              break;
                          case 2:
                              ug.computeMedian();
                              break;
                          case 3:
                              ug.computeMode();
                              break;
                          default:
                              ug.computeMean();                             
                              System.out.println("\n");
                              ug.computeMedian();
                              System.out.println();
                              ug.computeMode();
                              break;
                      }
                      
                      System.out.println();
                      System.out.println("****************************************************************");
                      System.out.println("What's your interpretation of the data? > ");
                      interpret = input.nextLine();
                      System.out.println("********************************");
                      ug.display(interpret);
                      
                      int choice4 = -1;
                      System.out.println("\n\n");
                      System.out.println("Do you want to display the simualation again? > ");
                      System.out.println("[1] YES \n[2] NO");
                      
                      do {
                      		System.out.println();
                          try {
                              choice4 = input.nextInt();
                          } catch(Exception e) {
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
                  
                  break;
              
                  
                  
              case 2:
                  int interval = -1;
                  int open_close = -1;
                  int open_ended = -1;
                  
                  grp.initialTitle(desc);
                  
                  System.out.println();
                  System.out.println("********************************");
                  System.out.println("Enter the number of class intervals. > ");
                  do {
                  		System.out.println();
                      try{
                          interval = input.nextInt();
                      } catch(InputMismatchException e) {
                      		interval = -1;
                          System.out.println();
                      }
                      input.nextLine();
                  } while(interval < 1);

                  System.out.println();
                  System.out.println("********************************************");                    
                  System.out.println("Are there any intervals that are . . . ");
                  System.out.println("[1] Open-ended");
                  System.out.println("[2] Close-ended");
                  
                  do {
                  		System.out.println();
                      try{
                          open_close = input.nextInt();
                      } catch(InputMismatchException e) {
                      		open_close = -1;
                          System.out.println();
                      }
                      input.nextLine();
                  } while(open_close < 1 || open_close > 2);
                  
                  grp = new Grouped(interval, type, open_close);
                  
                  if(open_close == 1) {
                      System.out.println();
                      System.out.println("*********************************************");                    
                      System.out.println("Which class/es is/are open-ended?");
                      System.out.println("[1] First");
                      System.out.println("[2] Last");
                      System.out.println("[3] Both");
                      
                      do {
                      		System.out.println();
                          try {
                              open_ended = input.nextInt();
                          } catch(InputMismatchException e) {
                          		open_ended = -1;
                              System.out.println("Invalid input! Please try again.");
                          }
                          input.nextLine();
                      } while(open_ended < 1 || open_ended > 3);
                  }
                  
                  System.out.println("\n\n");
                  
                  
                  if(type == 1) {
                      for(int i = 0; i < grp.int_data.length; i++) {
                          if((open_ended == 1 || open_ended == 3) && i == 0) {
                              System.out.println("Interval "+ (i+1) +" " );
                              System.out.println("LCL: -- ");
                              grp.int_data[i][0] = -1;
                              
                              System.out.println("UCL: ");
                              do {
                              	System.out.println();
                              	try {
                              		grp.int_data[i][1] = input.nextInt();
                              	} catch(InputMismatchException e) {
                              		grp.int_data[i][1] = -1;
                              		System.out.println();
                              	}
                              	input.nextLine();
                              } while(grp.int_data[i][1] < 1);
                              
                              System.out.println("Frequency: ");
                              do {
                              	System.out.println();
                              	try {
                              		grp.int_data[i][2] = input.nextInt();
                              	} catch(InputMismatchException e) {
                              		grp.int_data[i][2] = -1;
                              		System.out.println();
                              	}
                              	input.nextLine();
                              } while(grp.int_data[i][2] < 1);
                              
                              grp.int_data[i][3] = -1;
                              grp.int_data[i][4] = -1;
                              grp.int_data[i][5] = -1;
                              System.out.println();
                          }
                          else
                          if( (open_ended == 2 || open_ended == 3) && i == (grp.int_data.length - 1)) {
                              System.out.println("Interval "+ (i+1) +" " );
                              System.out.println("LCL: ");
                              do {
                              	System.out.println();
                              	try {
                              		grp.int_data[i][0] = input.nextInt();
                              	} catch(InputMismatchException e) {
                              		grp.int_data[i][0] = -1;
                              		System.out.println();
                              	}
                              	input.nextLine();
                              } while(grp.int_data[i][0] < 1);
                              
                              System.out.println("UCL: --");
                              grp.int_data[i][1] = -1;
                              
                              System.out.println("Frequency: ");
                              do {
                              	System.out.println();
                              	try {
                              		grp.int_data[i][2] = input.nextInt();
                              	} catch(InputMismatchException e) {
                              		grp.int_data[i][2] = -1;
                              		System.out.println();
                              	}
                              	input.nextLine();
                              } while(grp.int_data[i][2] < 1);
                              
                              grp.int_data[i][3] = -1;
                              grp.int_data[i][4] = -1;
                              grp.int_data[i][5] = -1;
                              System.out.println();
                          }
                          else {
                              System.out.println("Interval "+ (i+1) +" " );
                              System.out.println("LCL: ");
                              do {
                              	System.out.println();
                              	try {
                              		grp.int_data[i][0] = input.nextInt();
                              	} catch(InputMismatchException e) {
                              		grp.int_data[i][0] = -1;
                              		System.out.println();
                              	}
                              	input.nextLine();
                              } while(grp.int_data[i][0] < 1);
                              
                              System.out.println("UCL: ");
                              do {
                              	System.out.println();
                              	try {
                              		grp.int_data[i][1] = input.nextInt();
                              	} catch(InputMismatchException e) {
                              		grp.int_data[i][1] = -1;
                              		System.out.println();
                              	}
                              	input.nextLine();
                              } while(grp.int_data[i][1] < 1);
                              
                              System.out.println("Frequency: ");
                              do {
                              	System.out.println();
                              	try {
                              		grp.int_data[i][2] = input.nextInt();
                              	} catch(InputMismatchException e) {
                              		grp.int_data[i][2] = -1;
                              		System.out.println();
                              	}
                              	input.nextLine();
                              } while(grp.int_data[i][2] < 1);
                              
                              grp.int_data[i][3] = (grp.int_data[i][0] + grp.int_data[i][1]) / 2;
                              grp.int_data[i][4] = grp.int_data[i][2] * grp.int_data[i][3];
                              grp.int_data[i][5] = grp.int_data[i][4] * grp.int_data[i][3];
                              System.out.println();
                          }
                      }
                  }
                  else {
                      for(int i = 0; i < grp.data.length; i++) {
                          if((open_ended == 1 || open_ended == 3) && i == 0) {
                              System.out.println("Interval "+ (i+1) +" " );
                              System.out.println("LCL: -- ");
                              grp.data[i][0] = -1;
                              
                              System.out.println("UCL: ");
                              
                              do {
                              	System.out.println();
                              	try {
                                  grp.data[i][1] = input.nextFloat();
                              	} catch(InputMismatchException e) {
                              		grp.data[i][1] = -1;
                              		System.out.println("Invalid input! Please try again.");
                              	}
                              	input.nextLine();
                              }while(grp.data[i][1] < 1);
                              
                              System.out.println("Frequency: ");
                              do {
                              	System.out.println();
                              	try {
                                  grp.data[i][2] = input.nextFloat();
                              	} catch(InputMismatchException e) {
                              		grp.data[i][2] = -1;
                              		System.out.println("Invalid input! Please try again.");
                              	}
                              	input.nextLine();
                              }while(grp.data[i][2] < 1);
                              
                              grp.data[i][3] = -1;
                              grp.data[i][4] = -1;
                              grp.data[i][5] = -1;
                              System.out.println();
                          }
                          else
                          if( (open_ended == 2 || open_ended == 3) && i == (grp.data.length - 1)) {
                              System.out.print("Interval "+ (i+1) +" " );
                              System.out.println("LCL: ");
                              do {
                              	System.out.println();
                              	try {
                                  grp.data[i][0] = input.nextFloat();
                              	} catch(InputMismatchException e) {
                              		grp.data[i][0] = -1;
                              		System.out.println("Invalid input! Please try again.");
                              	}
                              	input.nextLine();
                              }while(grp.data[i][0] < 1);
                              
                              System.out.println("UCL: --");
                              grp.data[i][1] = -1;
                              System.out.println("Frequency: ");
                              do {
                              	System.out.println();
                              	try {
                                  grp.data[i][2] = input.nextFloat();
                              	} catch(InputMismatchException e) {
                              		grp.data[i][2] = -1;
                              		System.out.println("Invalid input! Please try again.");
                              	}
                              	input.nextLine();
                              }while(grp.data[i][2] < 1);
                              
                              grp.data[i][3] = -1;
                              grp.data[i][4] = -1;
                              grp.data[i][5] = -1;
                              System.out.println();
                          }
                          else {
                              System.out.println("Interval "+ (i+1) +" " );
                              System.out.println("LCL: ");
                              do {
                              	System.out.println();
                              	try {
                                  grp.data[i][0] = input.nextFloat();
                              	} catch(InputMismatchException e) {
                              		grp.data[i][0] = -1;
                              		System.out.println("Invalid input! Please try again.");
                              	}
                              	input.nextLine();
                              }while(grp.data[i][0] < 1);
                              
                              System.out.println("UCL: ");
                              do {
                              	System.out.println();
                              	try {
                                  grp.data[i][1] = input.nextFloat();
                              	} catch(InputMismatchException e) {
                              		grp.data[i][1] = -1;
                              		System.out.println("Invalid input! Please try again.");
                              	}
                              	input.nextLine();
                              }while(grp.data[i][1] < 1);
                              
                              System.out.println("Frequency: ");
                              do {
                              	System.out.println();
                              	try {
                                  grp.data[i][2] = input.nextFloat();
                              	} catch(InputMismatchException e) {
                              		grp.data[i][2] = -1;
                              		System.out.println("Invalid input! Please try again.");
                              	}
                              	input.nextLine();
                              }while(grp.data[i][2] < 1);
                              
                              grp.data[i][3] = (grp.data[i][0] + grp.data[i][1]) / 2;
                              grp.data[i][4] = grp.data[i][2] * grp.data[i][3];
                              grp.data[i][5] = grp.data[i][4] * grp.data[i][3];
                              System.out.println();
                          }
                      }
                  }            
                  
                  grp.display();
                  
                  int choice4 = -1;
                  int interval1 = -1;
                  
                  do {
                      System.out.println("\n\n");
                      System.out.println("********************************");
                      System.out.println("What do you want to do?");
                      System.out.println("[1] Edit");
                      System.out.println("[2] Continue");
                      
                      try {
                          choice4 = input.nextInt();
                          
                          if(choice4 == 1) {
                          		do {
	                          			do {
	                                  System.out.println("\n");
	                                  System.out.println("At what interval? ");
	                                  System.out.println("> ");
	                                  try {
	                                      interval1 = input.nextInt();
	                                  } catch(InputMismatchException e) {
	                                  		interval1 = -1;
	                                      System.out.println("Invalid input! Please try again.");
	                                  }
	                                  input.nextLine();
	                          			} while(interval1 < 1 || interval1 >  interval);
	                          			
	                          			if(type == 1) {
	                                  if(interval1 == 1 && (open_ended == 1 || open_ended == 3)) {
	                                      System.out.println("Interval "+ interval1 +" " );
	                                      System.out.println("LCL: -- ");
	                                      grp.int_data[interval1 - 1][0] = -1;
	                                      System.out.println("UCL: ");
	                                      do {
	                                      	try {
	                                      		grp.int_data[interval1 - 1][1] = input.nextInt();
	                                      	} catch(InputMismatchException e) {
	                                      		grp.int_data[interval - 1][1] = -1;
	                                      		System.out.println("Invalid input! Please try again.");
	                                      	}
	                                      	input.nextLine();
	                                      } while(grp.int_data[interval1 - 1][1] < 1);
	                                      
	                                      System.out.println("Frequency: ");
	                                      do {
	                                      	try {
	                                      		grp.int_data[interval1 - 1][2] = input.nextInt();
	                                      	} catch(InputMismatchException e) {
	                                      		grp.int_data[interval1 - 1][2] = -1;
	                                      		System.out.println("Invalid input! Please try again.");
	                                      	}
	                                      	input.nextLine();
	                                      } while(grp.int_data[interval1 - 1][2] < 1);
	                                      
	                                      grp.int_data[interval1 - 1][3] = -1;
	                                      grp.int_data[interval1 - 1][4] = -1;
	                                      grp.int_data[interval1 - 1][5] = -1;
	                                  }
	                                  else
	                                  if(interval1 == grp.int_data.length && (open_ended == 2 || open_ended == 3)) {
	                                      System.out.println("Interval "+ interval1 +" " );
	                                      System.out.println("LCL: ");
	                                      do {
	                                      	try {
	                                      		grp.int_data[interval1 - 1][0] = input.nextInt();
	                                      	} catch(InputMismatchException e) {
	                                      		grp.int_data[interval1 - 1][0] = -1;
	                                      		System.out.println("Invalid input! Please try again.");
	                                      	}
	                                      	input.nextLine();
	                                      } while(grp.int_data[interval1 - 1][0] < 1);
	                                      
	                                      System.out.println("UCL: --");
	                                      grp.int_data[interval1 - 1][1] = -1;
	                                      System.out.println("Frequency: ");
	                                      do {
	                                      	try {
	                                      		grp.int_data[interval1 - 1][2] = input.nextInt();
	                                      	} catch(InputMismatchException e) {
	                                      		grp.int_data[interval1 - 1][2] = -1;
	                                      		System.out.println("Invalid input! Please try again.");
	                                      	}
	                                      	input.nextLine();
	                                      }while(grp.int_data[interval1 - 1][2] < 1);
	                                      
	                                      grp.int_data[interval1 - 1][3] = -1;
	                                      grp.int_data[interval1 - 1][4] = -1;
	                                      grp.int_data[interval1 - 1][5] = -1;
	                                  }
	                                  else {
	                                      System.out.println("Interval "+ interval1 + " " );
	                                      System.out.println("LCL: ");
	                                      do {
	                                      	try {
	                                      		grp.int_data[interval1 - 1][0] = input.nextInt();
	                                      	} catch(InputMismatchException e) {
	                                      		grp.int_data[interval1 - 1][0] = -1;
	                                      		System.out.println("Invalid input! Please try again.");
	                                      	}
	                                      	input.nextLine();
	                                      } while(grp.int_data[interval1 - 1][0] < 1);
	                                      
	                                      System.out.println("UCL: ");
	                                      do {
	                                      	try {
	                                      		grp.int_data[interval1 - 1][1] = input.nextInt();
	                                      	} catch(InputMismatchException e) {
	                                      		grp.int_data[interval - 1][1] = -1;
	                                      		System.out.println("Invalid input! Please try again.");
	                                      	}
	                                      	input.nextLine();
	                                      } while(grp.int_data[interval1 - 1][1] < 1);
	                                      
	                                      System.out.println("Frequency: ");
	                                      do {
	                                      	System.out.println();
	                                      	try {
	                                      		grp.int_data[interval1 - 1][2] = input.nextInt();
	                                      	} catch(InputMismatchException e) {
	                                      		grp.int_data[interval1 - 1][2] = -1;
	                                      		System.out.println("Invalid input! Please try again.");
	                                      	}
	                                      	input.nextLine();
	                                      }while(grp.int_data[interval1 - 1][2] < 1);
	                                      
	                                      grp.int_data[interval1 - 1][3] = (grp.int_data[interval1 - 1][0] + grp.int_data[interval1 - 1][1]) / 2;
	                                      grp.int_data[interval1 - 1][4] = grp.int_data[interval1 - 1][2] * grp.int_data[interval1 - 1][3];
	                                      grp.int_data[interval1 - 1][5] = grp.int_data[interval1 - 1][4] * grp.int_data[interval1 - 1][3];
	                                  }
		                              }
		                              else {
		                                  if(interval1 == 1 && (open_ended == 1 || open_ended == 3)) {
		                                      System.out.println("Interval "+ interval1 +" " );
		                                      System.out.println("LCL: -- ");
		                                      grp.data[interval1 - 1][0] = -1;
		                                      
		                                      System.out.println("UCL: ");
		                                      do {
		                                      	System.out.println();
		                                      	try {
		                                      		grp.data[interval1 - 1][1] = input.nextFloat();
		                                      	} catch(InputMismatchException e) {
		                                      		grp.data[interval1 - 1][1] = -1;
		                                      		System.out.println("Invalid input! Please try again.");
		                                      	}
		                                      	input.nextLine();
		                                      } while(grp.data[interval1 - 1][1] < 1);
		                                      
		                                      System.out.println("Frequency: ");
		                                      do {
		                                      	System.out.println();
		                                      	try {
		                                      		grp.data[interval1 - 1][2] = input.nextFloat();
		                                      	} catch(InputMismatchException e) {
		                                      		grp.data[interval1 - 1][2] = -1;
		                                      		System.out.println("Invalid input! Please try again.");
		                                      	}
		                                      	input.nextLine();
		                                      } while(grp.data[interval1 - 1][2] < 1);
		                                      
		                                      grp.data[interval1 - 1][3] = -1;
		                                      grp.data[interval1 - 1][4] = -1;
		                                      grp.data[interval1 - 1][5] = -1;
		                                  }
		                                  else
		                                  if(interval1 == grp.data.length && (open_ended == 2 || open_ended == 3)) {
		                                      System.out.println("Interval "+ interval1 +" " );
		                                      System.out.println("LCL: ");
		                                      do {
		                                      	System.out.println();
		                                      	try {
		                                      		grp.data[interval1 - 1][0] = input.nextFloat();
		                                      	} catch(InputMismatchException e) {
		                                      		grp.data[interval1 - 1][0] = -1;
		                                      		System.out.println("Invalid input! Please try again.");
		                                      	}
		                                      	input.nextLine();
		                                      } while(grp.data[interval1 - 1][0] < 1);
		                                      
		                                      System.out.println("UCL: --");
		                                      grp.data[interval1 - 1][1] = -1;
		                                      
		                                      System.out.println("Frequency: ");
		                                      do {
		                                      	System.out.println();
		                                      	try {
		                                      		grp.data[interval1][2] = input.nextFloat();
		                                      	} catch(InputMismatchException e) {
		                                      		grp.data[interval1][2] = -1;
		                                      		System.out.println("Invalid input! Please try again.");
		                                      	}
		                                      	input.nextLine();
		                                      } while(grp.data[interval1][2] < 1);
		                                      
		                                      grp.data[interval1][3] = -1;
		                                      grp.data[interval1][4] = -1;
		                                      grp.data[interval1][5] = -1;
		                                  }
		                                  else {
		                                      System.out.println("Interval "+ interval1 + " " );
		                                      System.out.println("LCL: ");
		                                      do {
		                                      	try {
		                                      		grp.data[interval1 - 1][0] = input.nextFloat();
		                                      	} catch(InputMismatchException e) {
		                                      		grp.data[interval1 - 1][0] = -1;
		                                      		System.out.println("Invalid input! Please try again.");
		                                      	}
		                                      	input.nextLine();
		                                      } while(grp.data[interval1 - 1][0] < 1);
		                                      
		                                      System.out.println("UCL: ");
		                                      do {
		                                      	try {
		                                      		grp.data[interval1 - 1][1] = input.nextFloat();
		                                      	} catch(InputMismatchException e) {
		                                      		grp.data[interval1 - 1][1] = -1;
		                                      		System.out.println("Invalid input! Please try again.");
		                                      	}
		                                      	input.nextLine();
		                                      } while(grp.data[interval1 - 1][1] < 1);
		                                      
		                                      System.out.println("Frequency: ");
		                                      do {
		                                      	System.out.println();
		                                      	try {
		                                      		grp.data[interval1 - 1][2] = input.nextFloat();
		                                      	} catch(InputMismatchException e) {
		                                      		grp.data[interval1 - 1][2] = -1;
		                                      		System.out.println("Invalid input! Please try again.");
		                                      	}
		                                      	input.nextLine();
		                                      } while(grp.data[interval1 - 1][2] < 1);
		                                      
		                                      grp.data[interval1 - 1][3] = (grp.data[interval1 - 1][0] + grp.data[interval1 - 1][1]) / 2;
		                                      grp.data[interval1 - 1][4] = grp.data[interval1 - 1][2] * grp.data[interval1 - 1][3];
		                                      grp.data[interval1 - 1][5] = grp.data[interval1 - 1][4] * grp.data[interval1 - 1][3];
		                                  }    
		                              }
	                          			
	                          			grp.display();
	                          			
	                          			int edit_choice = -1;
	                                System.out.println("\n\n");
	                                System.out.println("Do you want to edit the data set again?");
	                                System.out.println("[1] YES \n[2] NO");
	                                
	                                do {
	                                    try {
	                                        edit_choice = input.nextInt();
	                                    } catch(InputMismatchException e) {
	                                    		edit_choice = -1;
	                                        System.out.println("Invalid input! Please try again.");
	                                    }
//	                                    input.nextLine();
	                                } while(edit_choice < 1 || edit_choice > 2);

	                                if(edit_choice == 2) {
	                                    edit = 1;
	                                }
	                                else {
	                                    edit = 0;
	                                }	
                          		} while(edit == 0);
                          		
                          		System.out.println();
                          }
                          else {
                              break;
                          }
                             
                      } catch(InputMismatchException e) {
                      		choice4 = -1;
                          System.out.println("Invalid input! Please try again.");
                      }
                      input.nextLine();
                  } while(choice4 < 1 || choice4 > 2);
                  
                  grp.display();
                  
                  int choice5 = -1;
                  System.out.println("\n\n");
                  System.out.println("*********************************************");                    
                  System.out.println("**** MEASURES OF CENTRAL TENDENCY ****");
                  System.out.println("*********************************************");
                  System.out.println();
                  System.out.println("[1] Mean");
                  System.out.println("[2] Median");
                  System.out.println("[3] Mode");
                  System.out.println("[4] All");
                  System.out.println("*********************************************");
                  
                  do {
                  		System.out.println();
                  		System.out.println("What measurement to do you want to use?");
                      try {
                          choice5 = input.nextInt();
                      } catch(InputMismatchException e) {
                      		choice5 = -1;
                          System.out.println("Invalid input! Please try again.");
                      }
                      input.nextLine();
                  } while(choice5 < 1 || choice5 > 4);
                  
                  do {
                      System.out.println("\n\n");
                      System.out.println("*************************************************************");

                      switch (choice5) {
                          case 1:
                              grp.getMean();
                              break;
                          case 2:
                              grp.getMedian();
                              break;
                          case 3:
                              grp.getMode();
                              break;
                          default:
                              grp.getMean();                             
                              System.out.println();
                              grp.getMedian();
                              System.out.println();
                              grp.getMode();
                              break;
                      }
                      
                      System.out.println();
                      System.out.println("*************************************************************");
                      System.out.println("What's your interpretation of the data? > ");
                      interpret = input.nextLine();
                      System.out.println("*************************************************************");
                      grp.display(interpret);
                      
                      int choice6 = 0;
                      System.out.println("\n\n");
                      System.out.println("*************************************************************");
                      System.out.println("Do you want to display the simualation again? > ");
                      System.out.println("[1] YES \n[2] NO");

                      do {
                      		System.out.println();
                          try {
                              choice6 = input.nextInt();
                              if(choice6 < 1 || choice6 > 2) {
                                  throw new Exception();
                              }
                          } catch(Exception e) {
                              System.out.println("Invalid input! Please try again.");
                          }
                          input.nextLine();
                      } while(choice6 < 1 || choice6 > 2);

                      if(choice6 == 2) {
                          repeat = 1;
                      }
                      else {
                          repeat = 0;
                      }
                  } while(repeat == 0);
                  break;
              
                  
              default:
                  try{
                      System.out.println("\nProgram terminating.... ");
                      try{
                          Thread.sleep(2000);
                      } catch(InterruptedException e) {
                          Thread.currentThread().interrupt();
                      }       
                  } catch(Exception e) {
                      input.nextLine();
                  }
                  break;
          }   
          
          System.out.println("\n\n");
          
      } while(choice != 3);
  }
  
  public static void main(String[] args) {
      simulate();
  }

}
