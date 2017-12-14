public class Day
{
//instance variables
	int day;
	int dayOfWeek;
	int month;
	int year;

	//constructor
	public Day()
	{
		day=1;
		dayOfWeek=1;
		month=1;
		year=1900;
	}

	public void nextDayOfWeek()
	{
		if (dayOfWeek==7)
		{
			dayOfWeek=1;
		}
		else {
			dayOfWeek++;
		}
	}

	public void nextMonth()
	{
		if (month<12)
		{
			month++;
		}
		//month==12
		else
		{
			month=1;
			year++;
		}
	}

	public void nextDay()
	{
		nextDayOfWeek();
		if (day<28)
		{
			day++;
		}
		//day=28 or greater
		else if(month==2)
		{
			if (year%4==0)
			{
				if (day<29)
				{
					day++;
				}
				//day is 29 or greater
				else 
				{
					day=1;
					nextMonth();
				}
			}
			else 
			{
				day=1;
				nextMonth();
			}
		}
		//Thirty days has September, April, June and November.
		else if (month==9||month==4||month==6||month==11)
		{
			if (day<30)
			{
				day++;
			}
			else
			{
				day=1;
				nextMonth();
			}
		}
		else
		{
			if (day<31)
			{
				day++;
			}
			else{
				day=1;
				nextMonth();
			}
		}
	}
}