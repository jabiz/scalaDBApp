/*
var num = 6

	def dec_to_bin(no:Int):String =
	{
		var x = no
		var bin = ""
		while (x >= 1 )
		{
			if(x%2 == 1)
			{
				 bin= "1" + bin
			}
			if(x%2 == 0)
			{
				 bin = "0" +bin
			}
			x=x/2
			
		}
		return bin
	}

	

//println(dec_to_bin(205))

	def bin_to_dec(no:String):Int=
	{
		var dec:Int = 0
		var counter = no.length-1
		var power =0 
		while (counter >=0)
		{
			if(no.substring(counter,counter+1)=="1")
			{
				dec = dec + ((scala.math.pow(2,power))*1).toInt
			}
			else
			{
				dec = dec + ((scala.math.pow(2,power))*0).toInt
			}
			power += 1
			counter -= 1

		}
		return dec
	}



print(bin_to_dec("11001101"))
*/

/*
class parent 
{
	def message(x:String):String=
	{
		var newVariable= x
		print(x)
		return x
	}
}
class child extends parent
{
	override def message(x:String):String=
	{
		print("no")
		return x
	}
}
var x= new child()

x.message("yes")

*/
/*
abstract class Bigbank 
{
	def deposit(a:Int)
	def withdraw(a:Int) 
	def showBalance()
}
class HSBC extends Bigbank
{
	override def deposit(a:Int)=
	{
		println(a + "deposited")
	}
	override def withdraw(a:Int)=
	{
		println(a + "withdrawn")
	}
	override def showBalance()=
	{
		println("hello")
	}
}

var process = new HSBC
process.showBalance
*/
abstract class Draw
{
	def drawing()
}
class Line extends Draw
{
	def drawing()
	{
		println("draw line")
	}
}
class Circle extends Draw
{
	def drawing()
	{
		println("no line for you, you silly goat")
	}
}
var x:Draw = new Line
x.drawing()
var y = new Circle
y.drawing()
def letDoDrawing(x:Draw)=
{
	x.drawing()
} 
letDoDrawing(y)

