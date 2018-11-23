//switch case 

/*
var day = readInt()

day match
{
	case 1 => println("monday")
	case 2 => println("tusday")
	case 3 => println("wednesday")
	case 4 => println("thusday")
	case 5 => println("friday")
	case 6 => println("satarday")
	case 7 => println("sunday")
}
*/
/*
def info (name:String,address:String,age:Int)=
{
	println("your name is "+name)
	println("you live at "+address)
	println("your "+age+" years old")
	println("we know everything come out with your hands up")
}

info (readLine(),readLine(),readInt())
info (readLine(),readLine(),readInt())
*/

/*
def tax(salpretax:Int):Int = 
{

		var sal=salpretax
		if (sal <=1000)
		{
			sal=0	
		}
		else if (sal > 1000 && sal <=2000)
		{
			sal=sal*15/100	
		}
		else if (sal > 2000 && sal <=3000)
		{
			sal=sal*20/100
		}
		else if (sal >= 4000)
		{
			sal=sal*25/100
		}
		return sal
	
}


var salary:Int = readInt()
var yourTaxes = tax(salary)
print("""your salary is £""", salary , """ which means your paying £""", yourTaxes ,"per year")

*/

/*
for ( multiplyer:Int <- 1 to 20)
{
	
	println("times table of "+ multiplyer) 
	for(set:Int <- 1 to 10)
	{
		print(multiplyer +"*"+set+"="+multiplyer*set + "\n");
		
	}
}

*/

var message = "shafeeq is,shafeeq was,shafeeq will be"
var altmessage = " "
var name = "daniel"
var prev = "shafeeq"
var i=0
while (i<= message.length()-1)
{
	if(message.substring(i,i+1)==prev.substring(0,1))
	{
		if(message.substring(i,i+prev.length())==prev)
		{
			altmessage= altmessage + name
			i+=prev.length-1
		}
		else 
		{
		altmessage=altmessage + message.substring(i,i+1)	
		}	
	}
	else
	{

	altmessage=altmessage + message.substring(i,i+1)
	}
	
	i+=1
	
}
print (altmessage)


/*
def ones(no: Int):String =
{
	var results= ""
	no match
	{
		case 1=>results ="one "
		case 2=>results ="two "
		case 3=>results ="three "
		case 4=>results ="fore "
		case 5=>results ="five "
		case 6=>results ="six "
		case 7=>results ="seven "
		case 8=>results ="eight "
		case 9=>results ="nine "
		case 10=>results ="ten "
		case 11=>results ="eleven "
		case 12=>results ="twelve "
		case 13=>results ="thirteen "
		case 14=>results ="forteen "
		case 15=>results ="fifteen "
		case 16=>results ="sixteen "
		case 17=>results ="seventeen "
		case 18=>results ="eighteen "
		case 19=>results ="ninteen "
				case _=> results=""
	}
	return results
}

def ty(no: Int):String =
{
	 var results=""
	 no match {
		case 20=>results ="twenty "
		case 30=>results ="therty "
		case 40=>results ="forty "
		case 50=>results ="fifty "
		case 60=>results ="sixty "
		case 70=>results ="seventy "
		case 80=>results ="eighty "
		case 90=>results ="niney "
		case _=> results=""
	 }
	 return results
}

def  num_to_string(no: Int):String = {
	var answer =""
	var num=no
	if(num <0)
	{
		answer = "minus "
		num=num -(num*2)

	}
	if(num >=1000)
	{
		answer += ones(num /1000)+" thousand "
		num=num-(num/1000)*1000
		
	}
	
	if(num>=100)
	{
		
		answer+=ones(num/100)+" hundred "
		num=num-(num/100)*100
	}
	if(num>=20)
	{
		answer += ty(num/10*10)+ ones(num%10)
	}
	if(num <= 19)
	{
		answer +=ones(num)
	}
	return answer
}
//print(num_to_string(-9999))
for(I <- 1 to 95)
{
	print(num_to_string(I))
}
*/