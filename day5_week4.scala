/*
var counties=List("uk","USA","germany","france")
var capitals= counties.map(findCapitals)

def findCapitals(c:String):String =
{
	var city=""

	if(c=="uk")
	{
		city="London"
	}
	if(c=="USA")
	{
		city="washington"
	}
	if(c=="germany")
	{
		city="berlin"
	}
	if(c=="france")
	{
		city="paris"
	}
	return city
}
print(capitals)
*/
/*
for(x <- capitals)
{
	print(capitals(x))
	
}
*/
/*
import java.sql.{Connection,DriverManager}
Class.forName("com.mysql.cj.jdbc.Driver")
var connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","")
val statment= connection.createStatement 



private def balence(acno:Int):Int=
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
	var acno =List(1,2,3,4,5)

	var balance_check=acno.map(balence)
	print(balance_check)
*/
/*
import java.sql.{Connection,DriverManager}
Class.forName("com.mysql.cj.jdbc.Driver")
var connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","")
val statment= connection.createStatement 



private def balence(acno:Int):Boolean=
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
		
		if(balence == 0)
		{
			return true
		}
		else
		{
			return false
		}
	}
	var acno =List(1,2,3,4,5)

	var balance_check=acno.filter(balence)
	print(balance_check)
	*/



	class school extends discipline {}

	trait discipline
	{
		this:school =>
		var corpral = 1	 
	}

	trait lunch
	{
		this:school =>
		var sandwitch = "yum"
		
	}
	var qa = new school()
	//println(qa.corpral,qa.sandwitch)

	class fuckit extends school with lunch {}
	var printit = new fuckit()
	print(printit.sandwitch)