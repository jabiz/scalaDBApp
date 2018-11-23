import java.sql.{Connection,DriverManager}

try
{
	Class.forName("com.mysql.cj.jdbc.Driver")
	var connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","")
	val statment= connection.createStatement 
	var x=0
	var test=0
	var yes_no = ""
	while (test!=5)
	{
		println("wecome please press 1: to create an account 2: to deposit 3:to withdraw: 4 to see you current balence 5 to quit Application")
		test = scala.io.StdIn.readInt()
	 	if (test==1)
	 	{
	 	
	 		println("plese enter you name and address")
			var in_name = scala.io.StdIn.readLine()
	 		var in_address = scala.io.StdIn.readLine()
	 		println("do you want to save this record"+"name:"+in_name+"address:"+in_address+" press y for yes and n for no")
	 		yes_no = scala.io.StdIn.readLine()
	 		if (yes_no == "y" || yes_no=="Y")
	 		{
		 		statment.executeUpdate("insert into personal values(Null,'"+in_name+"','"+in_address+"')")
		 		println("your account has been created successfully")
		 		var acno= 0
		 		var you = statment.executeQuery("select max(ACNo) from personal")
		 		if(you.next())
		 			{
		 				 acno = you.getInt("max(ACNo)")
		 			}
		 		println("your account number is:"+acno+" plese make a note of it if you lose it contact the bank at 080000166")	 		
		 		println("Press Enter to Continue")
		 		yes_no==scala.io.StdIn.readLine

	 		}
	 		else 
	 		{
	 			println("your account creation has been cancelled ")
	 			println("Press ~Enter to Continue")
	 			yes_no==scala.io.StdIn.readLine

	 		}
	 	}

	 	if(test==2)
	 	{
	 		println("please enter your account number bellow")
	 		var account_num = scala.io.StdIn.readInt()
	 		var ac = statment.executeQuery("SELECT * from personal where ACNo ="+account_num+" ")
	 		if(ac.next)
	 		{
	 			val ACNo1 = ac.getInt("ACNo")
	 			val account_name = ac.getString("Name")
	 			val account_address = ac.getString("address")
	 			println("account number: "+ACNo1+" account name: "+account_name+ "account_address: " +account_address)
	 		
				println("is this your account y for yes n to end transaction")
	 			var yes_no = scala.io.StdIn.readLine()

	 			if(yes_no == "y")
	 			{
	 				println("enter the amount you would like to deposit")
	 				var amount = scala.io.StdIn.readInt()
	 				statment.executeUpdate("insert into deposit values("+account_num+",NULL,"+amount+",now())")
	 				println ("this transaction has been made and recorded")
	 				println("press enter to Continue")
	 				yes_no==scala.io.StdIn.readLine	
	 			}
	 			else
	 			{
	 				println("transaction cancelled")
	 				println("press enter to Continue")
	 				yes_no==scala.io.StdIn.readLine
	 			}
	 			
	 		
	 		}
	 	}
	 	if(test==3)
	 	{
	 		println("please enter your account number bellow")
	 		var account_num = scala.io.StdIn.readInt()
	 		var ac = statment.executeQuery("SELECT * from personal where ACNo ="+account_num+" ")
	 		if(ac.next)
	 		{
	 			val ACNo1 = ac.getInt("ACNo")
	 			val account_name = ac.getString("Name")
	 			val account_address = ac.getString("address")
	 			println("account number: "+ACNo1+" account name: "+account_name+ "account_address: " +account_address)
	 		}	
	 		println("is this your account y for yes n to end transaction")
	 		var yes_no = scala.io.StdIn.readLine()

	 		if(yes_no == "y")
	 		{
	 			println("enter the amount you would like to withdraw")
	 			val amount = scala.io.StdIn.readInt()
	 			print(balence(account_num))
	 			if(balence(account_num)-amount >= 0)
	 			{
	 			statment.executeUpdate("insert into withdraw values("+account_num+",NULL,"+amount+",now())")
	 			println ("this transaction has been made and recorded")
	 			println("would you like to do another transaction? y/n")
	 			}
	 			else 
	 			{
	 			println ("this transaction has cancelled due to insufficent funds")
	 			println("to Continue press enter ")
	 			}
	 			yes_no==scala.io.StdIn.readLine
	 		}
	 		else
	 		{
	 			println("transaction cancelled")
	 			println("to contiue press enter")
	 			yes_no==scala.io.StdIn.readLine
		 		
	 		}
	 	}

	 	if(test==4)	
	 	{

	 		println("plese enter your account number")
	 		var account_num = scala.io.StdIn.readInt
	 		println("your current balence is:"+balence(account_num))
	 		println("press enter to Continue")
			yes_no==scala.io.StdIn.readLine
	 	}

	}
	def balence(acno:Int):Int=
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
}
catch
{
	case e: Exception => println(e)
}
