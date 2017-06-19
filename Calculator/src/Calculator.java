import java.util.Scanner;
import java.util.LinkedList;

public class Calculator {

	float holder=0;
	LinkedList<Node> numbers;
	LinkedList<Node> operations;
	float num1;
	
	
	public Calculator(){
	// Initializing the 2 main LinkedLists. 
		 numbers = new LinkedList<Node>();
		 operations = new LinkedList<Node>();	
	}

	public void add(float num1, float num2){
		holder= num1+num2;
	}
	public void subtract(float num1, float num2){
		holder= num1-num2;
	}
	public void multiply(float num1, float num2){
		
		holder= num1*num2;

	}
	public void divide(float num1, float num2){
		holder=  ((float) num1/num2);
		
	}
	
	public void settingup(){
	//Setting up scanner, so that I can read what the user is going to input. 
		Scanner reader = new Scanner (System.in);
		System.out.println("Lets calculate something!: ");
		String s = reader.nextLine();
		int i=0;
		String s1="";
		while(i<s.length()){
		/*Here I am parsing. I have done this because I want to create different Nodes. There are 2 types of nodes. 1) Which contain numbers and 2) Which contain operations. With this while loop I am aiming to separate the numbers from the operations. */
			if(s.charAt(i)=='1' || s.charAt(i)=='2' ||s.charAt(i)=='3' || s.charAt(i)=='4'|| s.charAt(i)=='5' || s.charAt(i)=='6' ||s.charAt(i)=='7' || s.charAt(i)=='8' || s.charAt(i)=='9' || s.charAt(i)=='0' ){
				s1= s1+s.charAt(i);
			}else{
				String oper= ""+ s.charAt(i);
				Node n1 = new Node(s1);
				Node n2 = new Node(oper);
				s1="";
				numbers.add(n1);
				operations.add(n2);
			}
			i++;
		}
		Node n = new Node(s1);
		numbers.add(n);

		calculation();
		System.out.println("Do you want to continue? y for yes and n for no");
		s =reader.nextLine();
		if(s.contains("y")){
			settingup();
		}
	}
		
	public void calculation(){
	
	/*Here I take out the 2 numbers that are on top of the LinkedList and the top operation. This will decide which operation will be executed first. */
		num1=(float) Integer.parseInt(numbers.removeFirst().data);
		int num2= Integer.parseInt(numbers.removeFirst().data);
		String oper1= operations.removeFirst().data;
	/*Checking which operation will be performed first*/
		if (oper1.contains("+")){
		add(num1, num2);
		}else if(oper1.contains("-")){
			subtract(num1,num2);
		}else if (oper1.contains("*")){
			multiply(num1,num2);
		}else if(oper1.contains("/")){
			divide(num1,num2);
		}
		/*Now we go into the loop, that will keep going till the LinkedLists are not empty. The lenght of the 2 linked lists becomes equal after the first stem in calculation() */
		while(!numbers.isEmpty()){
			num2=Integer.parseInt(numbers.removeFirst().data);
			String oper2= operations.removeFirst().data;
			if (oper2.contains("+")){
				add(holder, num2);
				}else if(oper2.contains("-")){

					subtract(holder,num2);
				}else if (oper2.contains("*")){

					multiply(holder,num2);
				}else if(oper2.contains("/")){

					divide(holder,num2);
				}

		}
		/*Returning the answer*/
		System.out.println(holder);
		holder=0;
	}
		
	}
	

