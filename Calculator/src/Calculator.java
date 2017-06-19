import java.util.Scanner;
import java.util.LinkedList;

public class Calculator {

	float holder=0;
	LinkedList<Node> numbers;
	LinkedList<Node> operations;
	float num1;
	
	
	public Calculator(){
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
		Scanner reader = new Scanner (System.in);
		System.out.println("Lets calculate something!: ");
		String s = reader.nextLine();
		int i=0;
		String s1="";
		while(i<s.length()){
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

		num1=(float) Integer.parseInt(numbers.removeFirst().data);
		calculation();
		System.out.println("Do you want to continue? y for yes and n for no");
		s =reader.nextLine();
		if(s.contains("y")){
			settingup();
		}
	}
		
	public void calculation(){
		
		int num2= Integer.parseInt(numbers.removeFirst().data);
		String oper1= operations.removeFirst().data;
		if (oper1.contains("+")){
		System.out.println("1st in add");
		add(num1, num2);
		}else if(oper1.contains("-")){
			System.out.println("1st in sub");
			subtract(num1,num2);
		}else if (oper1.contains("*")){
			System.out.println("1st in mul");
			multiply(num1,num2);
		}else if(oper1.contains("/")){
			System.out.println("1st in div");
			divide(num1,num2);
		}
		while(!numbers.isEmpty()){
			num2=Integer.parseInt(numbers.removeFirst().data);
			String oper2= operations.removeFirst().data;
			if (oper2.contains("+")){
				System.out.println("2nd in add");
				add(holder, num2);
				}else if(oper2.contains("-")){
					System.out.println("2nd in sub");

					subtract(holder,num2);
				}else if (oper2.contains("*")){
					System.out.println("2nd in mul");

					multiply(holder,num2);
				}else if(oper2.contains("/")){
					System.out.println("2nd in div");

					divide(holder,num2);
				}

		}
		System.out.println(holder);
		holder=0;
	}
		
	}
	

