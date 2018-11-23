import java.sql.{Connection,DriverManager}

try
{
	Class.forName("com.mysql.cj.jdbc.Driver")
	var connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","")
	val statment= connection.createStatement 
	var x=0
	while (x <1)
	{

		println("wecome please press 1: to create an account 2: to deposit 3:to withdraw: 4 to see you current balence")
		var test = scala.io.StdIn.readInt()
	 	if (test==1)
	 	{
	 	
	 		println("plese enter you name and address")
			var in_name = scala.io.StdIn.readLine()
	 		var in_address = scala.io.StdIn.readLine()
	 		println("do you want to save this record"+"name:"+in_name+"address:"+in_address+" press y for yes and n for no")
	 		var yes_no = scala.io.StdIn.readLine()
	 		if (yes_no == "y")
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
	 		
	 		//var aco_no_new =statment.executeQuery("SELECT * from personal where name = '"+in_name+"' and address = '"+in_address+"'")
	 		//print(aco_no_new.getInt("ACNo"))
	 		println("do you want another transaction y/n")
	 		yes_no==scala.io.StdIn.readLine
		 		if(yes_no== "n")
		 		{
		 			x =x +1
		 		}
	 		}
	 		else 
	 		{
	 			println("your account creation has been cancelled ")
	 			println("do you want another transaction y/n")
	 			yes_no==scala.io.StdIn.readLine
		 		if(yes_no== "n")
		 		{
		 			x =x +1
		 		}
	 		}
	 	}

	 	if(test==2)
	 	{
	 		println("please enter your account number bellow")
	 		var account_num = scala.io.StdIn.readInt()
	 		var ac = statment.executeQuery("SELECT * from personal where ACNo ="+account_num+" ")
	 		while(ac.next)
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
	 				println("enter the amount you would like to deposit")
	 				var amount = scala.io.StdIn.readInt()
	 				//print("enter the current date using the formate yyyy-mm-dd")
	 				//var date_of = readLine()
	 				statment.executeUpdate("insert into deposit values("+account_num+",NULL,"+amount+",now())")
	 				println ("this transaction has been made and recorded")
	 				println("would you like to do another transaction? y/n")
	 				yes_no==scala.io.StdIn.readLine
			 		if(yes_no== "n")
			 		{
			 			x =x +1
			 		}

	//statment.executeUpdate("insert into school values(8,'max','SQL',421)")
	 			}
	 			else
	 			{
	 				println("transaction cancelled")
	 				println("would you like to do another transaction? y/n")
	 				yes_no==scala.io.StdIn.readLine
			 		if(yes_no== "n")
			 		{
			 			x =x +1
			 		}
	 			}
	 		
	 	}
	 	if(test==3)
	 	{
	 		var dep_check1=0
	 		var with_checker1=0
	 		println("please enter your account number bellow")
	 		var account_num = scala.io.StdIn.readInt()
	 		var ac = statment.executeQuery("SELECT * from personal where ACNo ="+account_num+" ")
	 		//var max = statment.executeQuery("SELECT sum(amount) from deposit where ACNo ="+account_num+"")
	 		while(ac.next)
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

	 			var dep_check = statment.executeQuery("SELECT sum(amount) as money from deposit where ACNo ="+account_num+"")
	 			if(dep_check.next())
	 			{
	 				 dep_check1 = dep_check.getInt("money")
	 			}
	 			
	 			var with_checker = statment.executeQuery("SELECT sum(amount) as money from withdraw where ACNo ="+account_num+"")
	 			if(with_checker.next())
	 			{
	 				 with_checker1 = with_checker.getInt("money")
	 			}
	 			var balence = dep_check1-with_checker1
	 			print(balence)
	 			if(balence-amount >= 0)
	 			{
	 			statment.executeUpdate("insert into withdraw values("+account_num+",NULL,"+amount+",now())")
	 			println ("this transaction has been made and recorded")
	 			println("would you like to do another transaction? y/n")
	 			}
	 			else 
	 			{
	 			println ("this transaction has cancelled due to insufficent funds")
	 			println("would you like to do another transaction? y/n")
	 			}
	 		yes_no==scala.io.StdIn.readLine
		 	if(yes_no== "n")
		 	{
		 		x =x +1
		 	}

	 		}
	 		else
	 		{
	 			println("transaction cancelled")
	 			println("would you like to do another transaction? y/n")
	 			yes_no==scala.io.StdIn.readLine
		 		if(yes_no== "n")
		 		{
		 			x =x +1
		 		}
	 		}
	 	}

	 	if(test==4)	
	 	{

	 		var dep_check1=0
	 		var with_checker1=0
	 		println("plese enter your account number")
	 		var account_num = scala.io.StdIn.readInt
	 		var dep_check = statment.executeQuery("SELECT sum(amount) as money from deposit where ACNo ="+account_num+"")
	 			if(dep_check.next())
	 			{
	 				 dep_check1 = dep_check.getInt("money")
	 			}
	 			
	 			var with_checker = statment.executeQuery("SELECT sum(amount) as money from withdraw where ACNo ="+account_num+"")
	 			if(with_checker.next())
	 			{
	 				 with_checker1 = with_checker.getInt("money")
	 			}
	 			var balence = dep_check1-with_checker1
	 			println("your current balence is:"+balence)

	 			println("would you like to do another transaction? y/n")

	 				var yes_no = scala.io.StdIn.readLine()
			 		if(yes_no== "n")
			 		{
			 			x =x +1
			 		}
	 	}

	}
 }

	catch
	{
		case e: Exception => println(e)
	}
	/*
	
def y_n(input:String)=
{
	if(input== "n")
	{
		x =x +1
	}
}
*/
