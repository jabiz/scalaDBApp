/*
class MyExp extends Exception
{

}
var first = 10
var sec =12
try
{
	if (sec>first)
	{
		var ref= new MyExp()
		throw ref
	}
}

catch
{
	case x:MyExp => 
		{
			println("Exception test alpha")
		}


}



var sal = 1000
var absenties = 7

def salaryCalulation (sal:Int,absenties:Int):Int = 
{
	try
	{

		if (absenties >= 6)
		{
			var y= new MyExp()
			throw y
		}
	}
	catch
	{
		case y:MyExp =>
		{
			println("guy must be ill")
		}
	}
	finally
	{
		print("finally it works ")
	
	}
	return sal
	
	
}
salaryCalulation(sal,absenties)
*/
/*
class AbsentiesException extends Exception{}
class AbsentiesExceptionOverThirty extends  Exception{}
class ImpossibleExeption extends Exception{}

class Accounts
{
	def salaryCalulation (sal:Int,absenties:Int):Int = 
	{
		var net=0
		if(absenties >=6 && absenties <30)
		{
			var x = new AbsentiesException()
			throw x
			
		}
		if(absenties >= 30 && absenties <45)
		{
			var k = new AbsentiesExceptionOverThirty()
			throw k
		}
		if(absenties >= 50)
		{
			var m= new ImpossibleExeption()
			throw m
		}
		else 
		{
			net = sal*15/100
		}
		return net
	}

}

var ref = new Accounts()
try
{
	ref.salaryCalulation(200,59)
}
catch
{
	case x:AbsentiesException =>
		{
			println("be carful next time")
		}
	case y:AbsentiesExceptionOverThirty =>
		{
			println("so yer sorry but your fired")
		}
	case m:ImpossibleExeption =>
		{
			println("but how???????")
		}
}
*/

/*
class Boom 
{
	var x= 95 //globle varaible 

	def message()=
	{
		var t = 14
		var x = 24 //local variable 
		println("T:"+t)
		println("x:"+this.x,"compared to the local varaibale",x)
	}
	


	def message2()=
	{
		println("x"+x)
	}
}

var ref= new Boom()
ref.message()
ref.message2()
println(ref.x)
*/
/*
class incorrect_passoword_exeption extends Exception{}
class incorrect_username_exeption extends Exception{}
class Password_checker(name:String,password:String)
{
	if (name == "hr" || name == "user")
	{
		if (password == "password")
		{
			println("you have loged in") 
		}
		else
		{
			print("incorect password you have one more attmpt")
			var y = new incorrect_username_exeption()
			throw y
		}
	}
	else 
	{
		print ("incorect username you have one more attempt")
		var x = new incorrect_username_exeption()
		throw x
	}
}

try
{
var x=new Password_checker(readLine,readLine)
}
catch
{
	case x:incorrect_username_exeption => 
	{
		var user_exp = readLine
		var password_exp = readLine
		if (user_exp == "hr" || user_exp == "user")
	{
		if (password_exp == "password")
		{
			println("you have loged in") 
		}
		else
		{
			print("incorect password")
			
		}
	}
	else 
	{
		print ("incorect username")
		
	}
	}

case y:incorrect_passoword_exeption =>
	{
		var password_exp = readLine
		if (password_exp == "password")
		{
			println("you have loged in") 
		}
		else
		{
			print("incorect password bugger of")
			
		}
	}
}
*/
/*

class boom 
{
	println("hello")

	def this(a:Int,b:Int,c:Int)=
	{
		this()
		println("constructor 2")
	}
	def this(a:Int,b:Int)=
	{
		this()
		println("constructor 3")
	}
}

var x = new boom(2,4)
*/

class person()
{
	private var _age =0
	private var _name =""

	def age:Int = _age
	def name:String= _name

	def age_=(value:Int):Unit =
		{
			if(value < 50)
			{
				_age = value
			}
			else 
			{
				_age = 0
			}
		}

	def name_=(value:String) =
		{
			if(value == "daniel")
			{
				_name = "bugger of"
			}
			else 
			{
				_name = value
			}
			
		}

}

val x = new person
x.age = 34
x.name = readLine
print (x.age,x.name)