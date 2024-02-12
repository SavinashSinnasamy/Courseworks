#..DOC 333 Introduction to Programming Coursework...

#..Question..1

#..Initialize Variables..

Temp_Read_1=0
Temp_Read_2=0
Temp_Read_3=0
Temp_Read_4=0
Temp_Read_5=0
Temp_Read_6=0
Temp_Read_7=0
Temp_Read_8=0
Temp_Read_9=0
Temp_Read_10=0
Avg_Temp=0

#..Input from user..

Temp_Read_1=float(input("Enter first reading of temperature of the patient(in celsius): "))
Temp_Read_2=float(input("Enter second reading of temperature of the patient(in celsius): "))
Temp_Read_3=float(input("Enter third reading of temperature of the patient(in celsius): "))
Temp_Read_4=float(input("Enter fourth reading of temperature of the patient(in celsius): "))
Temp_Read_5=float(input("Enter fifth reading of temperature of the patient(in celsius): "))
Temp_Read_6=float(input("Enter sixth reading of temperature of the patient(in celsius): "))
Temp_Read_7=float(input("Enter seventh reading of temperature of the patient(in celsius): "))
Temp_Read_8=float(input("Enter eighth reading of temperature of the patient(in celsius): "))
Temp_Read_9=float(input("Enter ninth reading of temperature of the patient(in celsius): "))
Temp_Read_10=float(input("Enter tenth reading of temperature of the patient(in celsius): "))

#..Process

Avg_Temp=(Temp_Read_1+Temp_Read_2+Temp_Read_3+Temp_Read_4+Temp_Read_5+Temp_Read_6+Temp_Read_7+Temp_Read_8+Temp_Read_9+Temp_Read_10)/10
Avg_Temp=(Avg_Temp*9/5)+32

#..Output

print("Average body temperature of the patient is: ",format(Avg_Temp,".2f"),"Fahrenheit")

#..Condition

if Avg_Temp>=97 and Avg_Temp<=99:
    print("Your body temperature is normal...")
elif Avg_Temp>=100.4:
    print("You have a fever caused by an infection or illness...")
elif Avg_Temp>=99.1 and Avg_Temp<=100.3:
    print("Your body temperature is high")
else:
    print("Your body temperature is abnormally low...")
