#..DOC 333 Introduction to Programming Coursework...

#..Question..2

#..Initialize Variables..
Year=0
Month=0
Date=0

#..Inputs from user
Year=int(input("Enter year: "))
Month=int(input("Enter month: "))
Date=int(input("Enter date: "))

#..Condition
print(Year,".",Month,".",Date)
if(Month==1 or Month==3 or Month==5 or Month==7 or Month==8 or Month==10 or Month==12):
        Date<=31
elif(Month==4 or Month==6 or Month==9 or Month==11):
        Date<=30
else:
    (Month==2)
    if(Year%4==0 or Year%400==0):
        Date<=29
    else:
        ((Year%4==1) or (Year%400==1))
        (Date<=28)
            
if(Month==1 or Month==3 or Month==5 or Month==7 or Month==8 or Month==10) and (Date<31):
        Date=Date+1
        print("The Date is valid")
        print("The next date is: ",Date,"-",Month,"-",Year)
elif(Month==1 or Month==3 or Month==5 or Month==7 or Month==8 or Month==10) and (Date==31):
            Date=1
            Month=Month+1
            print("The Date is valid")
            print("The next date is: ",Date,"-",Month,"-",Year) 
elif(Month==4 or Month==6 or Month==9 or Month==11) and (Date<30):
        Date=Date+1
        print("The Date is valid")
        print("The next date is: ",Date,"-",Month,"-",Year)
elif(Month==4 or Month==6 or Month==9 or Month==11) and (Date==30):
            Date=1
            Month=Month+1
            print("The Date is valid")
            print("The next date is: ",Date,"-",Month,"-",Year)
elif(Month==2):
    if(Year%4==1 or Year%400==1) and (Date<28):
            Date=Date+1
            print("The Date is valid")
            print("The next date is: ",Date,"-",Month,"-",Year)
    elif(Year%4==0 or Year%400==0) and (Date<29):
            Date=Date+1
            print("The Date is valid")
            print("The next date is: ",Date,"-",Month,"-",Year)
    elif(Year%4==1 or Year%400==1) and (Date==28):
            Date=1
            Month=Month+1
            print("The Date is valid")
            print("The next date is: ",Date,"-",Month,"-",Year)
    elif(Year%4==0 or Year%400==0) and (Date==29):
            Date=1
            Month=Month+1
            print("The Date is valid")
            print("The next date is: ",Date,"-",Month,"-",Year)
    else:
            print("The date is invalid")
elif(Month==12 and Date==31):
        Date=1
        Month=1
        Year=Year+1
        print("The Date is valid")
        print("The next date is: ",Date,"-",Month,"-",Year)
else:
    print("The date is invalid")
