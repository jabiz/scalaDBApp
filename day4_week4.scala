/*
class Bank
{
	def amount(x:Int)= 
	{
		println("amount:"+(x*Bank.Dollar))
	}
	def setDollar(x:Int)=
	{
		Bank.Dollar=x
	}
}
object Bank 
{
	var Dollar =95
}

var hsbc = new Bank()
var natwest = new Bank()
var barclys = new Bank()

hsbc.amount(1)
natwest.amount(2)
barclys.amount(6)
barclys.setDollar(500)
hsbc.amount(1)
*/

class bank
{
	import java.sql.{Connection,DriverManager}
	Class.forName("com.mysql.cj.jdbc.Driver")
	var connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","")
	val statment= connection.createStatement 
	private var yes_no = ""
	
	def main_menu():Unit=
	{

		try
		{
			var menu_line = 0 
			while (menu_line !=5)
			{
				println("wecome please follow the instructions bellow\nto create an account press: 1\nto deposit press: 2\nto withdraw press: 3\nto see you current balence press: 4\nto quit Application press: 5")
				menu_line = scala.io.StdIn.readInt()
				if(menu_line == 1)
				{
					createAccount()
					
				}
				if(menu_line == 2)
				{
					deposit()
					
				}
				if(menu_line == 3)
				{
					withdraw()
					
				}
				if(menu_line == 4)
				{
					print("Input your account number please: ")
					var account_num = scala.io.StdIn.readInt
					println("Your current balence is: "+balence(account_num))
	 				println("Plese press anykey to Continue")
	 				yes_no=scala.io.StdIn.readLine()
	 				
				}
				else if(menu_line > 5)
				{
					println("Please enter a valid option")
				}

			}
		}
		catch
		{
		
			//case j: SQLSyntaxErrorException => 
			//{ 
			//	print("There was a system error connecting to the banks database we aplogize for the incovenece")
			//}
		
			case d: NumberFormatException => 
			{
				print("sorry you added a letter/s to your input plese only put numbers for money")
				main_menu()
					
			}
		}
	}
	private def balence(acno:Int):Int=
	{
		//try 
		//{
		var ac = statment.executeQuery("SELECT * from personal where ACNo ="+acno)
	 		if(ac.next)
	 		{	
			var dep_check1=0
			var with_checker1=0
			var dep_check = statment.executeQuery("SELECT sum(amount) as money from deposit where ACNo ="+acno+"")
			if(dep_check.next())
				{
					 dep_check1 = dep_check.getInt("money")
				}
			
			var with_checker = statment.executeQuery("SELECT sum(amount) as money from withdraw where ACNo ="+acno+"")
			if(with_checker.next())
				{
					 with_checker1 = with_checker.getInt("money")
				}
			var balence = dep_check1-with_checker1
			return balence
			}
			else
			{
			print("im sorry you don't apper to have a account with us")	
			var balence = 0
			return balence
			}

		//} 
			
		//catch 
		//{
			//case j: SQLSyntaxErrorException => 
			//{ 
			//	print("There was a system error connecting to the banks database we aplogize for the incovenece")
			//}
		//}
		
	}

	private	def createAccount()
	{
		println("plese enter you name and address:")
		print("Name:")
		var in_name = scala.io.StdIn.readLine()
		print("Address:")
	 	var in_address = scala.io.StdIn.readLine()
	 	println(" \ndo you want to save this record"+"name:"+in_name+"address:"+in_address+" press y for yes and n for no")
	 	yes_no = scala.io.StdIn.readLine()
	 	if (yes_no == "y"|| yes_no=="Y")
	 	{
		 	statment.executeUpdate("insert into personal values(Null,'"+in_name+"','"+in_address+"')")
		 	println("your account has been created successfully")
		 	var acno= 0
		 	var you = statment.executeQuery("select max(ACNo) from personal")
		 	if(you.next())
		 		{
		 			 acno = you.getInt("max(ACNo)")
		 		}
		 	println("your account number is:"+acno+" please make a note of it if you lose it contact the bank at 0800 00 1066")	 		
		 	println("Press anykey to Continue:")
		 	yes_no==scala.io.StdIn.readLine
	 	}
	 	else 
	 	{
	 		println("your account creation has been cancelled you will be returned to the main menu")
	 	}
	}

	private	def deposit()
	{
		try
		{
			println("please enter your account number bellow")
	 		var account_num = scala.io.StdIn.readInt()
	 		var ac = statment.executeQuery("SELECT * from personal where ACNo ="+account_num)
	 		if(ac.next)
	 		{
	 			val ACNo1 = ac.getInt(1)
	 			val account_name = ac.getString("Name")
	 			val account_address = ac.getString("address")
	 			println("Account number: "+ACNo1+"\nAccount name: "+account_name+ "\nAccount_address: " +account_address)
	 			println("if this your account press :y for yes \nif not press anykey to end transaction")
	 			var yes_no = scala.io.StdIn.readLine()

	 			if(yes_no == "y"|| yes_no=="Y")
	 			{
	 				println("Enter the amount you would like to deposit:")
	 				print("Amount:")
	 				var amount = scala.io.StdIn.readInt()
	 				println("\nAre you sure you wish to deposit"+amount + " your current balence is: "+balence(account_num)+" after the deposit the balence will be: "+ (balence(account_num)+amount))
	 				println("press y for yes and anykey for no")
	 				yes_no==scala.io.StdIn.readLine
	 				if(yes_no == "y"|| yes_no=="Y")
		 			{
						statment.executeUpdate("insert into deposit values("+account_num+",NULL,"+amount+",now())")
						println ("This transaction has been made and recorded")
							 			
		 			}
	 				else 
	 				{
	 					println("Your transaction has been cancelled")
	 				}
	 				
	 				println("Press anykey to Continue")
	 				yes_no==scala.io.StdIn.readLine
			 	}

	 			else
	 			{
	 				println("transaction cancelled")
	 				println("press anykey to Continue")
	 				yes_no==scala.io.StdIn.readLine
	 			}
	 		}

	 		else 
	 		{
	 			println("No account exists \nyou will be returned to the menu") 
	 			
	 		}
		}
		catch
		{	
			
			case e: NumberFormatException => 
				{
					print("sorry you added a letter/s to your input plese only put numbers for money")
					main_menu()
					println("press enter to contiue")
		 			yes_no==scala.io.StdIn.readLine
				}

		}
				
	}
	private	def withdraw()
	{
		try 
		{
			 
			println("Please enter your account number bellow")
			print("Account number:")
		 		var account_num = scala.io.StdIn.readInt()
		 		var ac = statment.executeQuery("SELECT * from personal where ACNo ="+account_num+" ")
		 		if(ac.next)
		 		{
		 			val ACNo1 = ac.getInt(1)
		 			val account_name = ac.getString("Name")
		 			val account_address = ac.getString("address")
		 			println("\nAccount number: "+ACNo1+"\nAccount name: "+account_name+ "\nAccount_address: " +account_address)
		 			println("Is this your account: press y for yes \nPress n to end transaction")
		 			var yes_no = scala.io.StdIn.readLine()

		 		if(yes_no == "y"|| yes_no=="Y")
		 		{
		 			println("Enter the amount you would like to withdraw")
		 			val amount = scala.io.StdIn.readInt()
		 			println("your current balence is: "+balence(account_num)+" after you withdraw it will be: "+(balence(account_num)-amount))
		 			println("Are you positve you wish to withdraw :"+amount+" \npress y for yes")
		 			yes_no==scala.io.StdIn.readLine
		 			if(yes_no == "y"|| yes_no=="Y")
		 			{
			 			if(balence(account_num)-amount >= 0)
			 			{
			 			statment.executeUpdate("insert into withdraw values("+account_num+",NULL,"+amount+",now())")
			 			println ("This transaction has been made and recorded")
			 			}
			 			else 
			 			{
			 			println ("this transaction has cancelled due to insufficent funds")
			 			}	
		 			}
		 			println("to Continue press enter ")
		 			yes_no==scala.io.StdIn.readLine
		 		}
		 		else
		 		{
		 			println("transaction cancelled")
		 			println("to contiue press enter")
		 			yes_no==scala.io.StdIn.readLine
			 		
		 		}
		 		}	
		 		else 
		 		{
		 			println("no account exists") 
		 			println("you will be returned to the menu")
		 			println("press enter to contiue")
		 			yes_no==scala.io.StdIn.readLine
		 		}
		}		
		catch
		{		
			case j: NumberFormatException => 
			{
				print("sorry you added a letter/s to your input plese only put numbers for money")
				main_menu()
			}

		}
		

	}
	
}

var test = new bank()
test.main_menu()