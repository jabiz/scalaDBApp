/*
abstract class Bank
{
	def showBalence()
	def deposit(a:Int)
	def withdraw(a:Int)
}

class HSBC extends Bank
{
	def showBalence() =
	{
		println("-20000 in your account ")
	}
	def deposit(a:Int) =
	{
		println("you are trying to put in:"+a+" don't lie you have no money")
	}
	def withdraw(a:Int)=
	{
		println("you are trying withdraw:"+a+"don't make me laugh")
	}
}

var x:Bank = new HSBC()

x.showBalence
x.deposit(23)
x.withdraw(1)
*/
/*
var numbers =  Array(-145654,-2445645,-45454654,-784546,6)

var i=0
var q=numbers(1)
var f=0
while(i< numbers.length)
{
	f=numbers(i)

	if(q<f)
	{
		q= numbers(i)
	}
	i=i+1
}
print(q)
*/
/*
var numbers =  Array(-2,-145654,-45454654,-784546,6)

var i=0
var max=numbers(0)
var almost_max= max
var current_loop=1

while(i< numbers.length)
{
	current_loop=numbers(i)

	if(current_loop>max)
	{
		almost_max=max
		max= numbers(i)		
	}
	if(max == almost_max)
	{
		almost_max = numbers(i)
	}
	
	i=i+1
}
println(max)
println(almost_max)
*/

var regNo = new Array [Int](5)
var name = new Array[String](5)
var marks = new Array[Int](5)
var i=0
var positon=0
var j= marks(0)
while(i< regNo.length)
{
try
{
regNo(i) = readInt
name(i)= readLine
marks(i)=readInt
}
catch
{
	case a:NumberFormatException =>
	{
		println("you incorrected entered a deatil please rember the formate is Int,String,Int" )
		regNo(i) = readInt
		name(i)= readLine
		marks(i)=readInt
	}

}
println (regNo(i),name(i),marks(i))
if(marks(i)>=j)
	{
		j=marks(i)
		positon=i

	}
i=i+1

}

println("registration number: "+regNo(positon)+" name:"+name(positon)+" marks"+marks(positon))