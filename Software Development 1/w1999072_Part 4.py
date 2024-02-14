#I declare that my work contains no examples of misconduct, sch as plagiarism, or collusion.
#Any code taken from other sources is referenced within my code solution.

#Westminster Student ID: 19990727
#IIT Student ID: 20210847
#Date:

#..Creating variables
credit_pass = 0
credit_defer = 0
credit_fail = 0
str_pass = ""
str_defer = ""
str_fail = ""
total = 0
loop = ""
student_id = ""
student_record = {}
    
#..program predicts progression outcomes of a student at the end of each academic year and print the outcome in the form of a dictionary 
print("\n","="*75,"\n\tWelcome to Annual Academic Progress Outcome Prediction System\n","="*75,"\n")#..Welcome Note
try:
    while True: #..........Program loop.............. 
        try: #Student ID validation      
            student_id = input("Enter Student ID (Ex: w1234567): ").lower()
            student_num = student_id[1:8] #..slicing the student id to check whether the slicd part is an integer
            student_num = int(student_num) 
            if student_id[0] != "w":
                print ("Invalid Student ID\nThe student ID should begin with 'w'\n")
                continue
            elif len(student_id) != 8:
                print("Invalid Student ID length, Try again\n")
                continue            
            else:
                print ("Student ID is:",student_id,"\n")                
        except ValueError:
            print("You have entered an invalid stident id, try again\n")
            continue
        while True: #..Total validating loop
            while True:
                try: #..Validating inputs solely which take the inputs within the range 0 and 120
                    credit_pass = int(input("Please enter your credits at PASS: "))
                    if (0 > credit_pass or 120 < credit_pass) or credit_pass % 20 != 0:
                        print("Out of range.\n")
                        continue
                    else:
                        break
                except ValueError: #..Error handling
                    print("Integer required, Try Again\n")
                    continue
            while True:
                try:        
                    credit_defer = int(input("Please enter your credits at DEFER: "))
                    if (credit_defer < 0 or credit_defer > 120) or credit_defer % 20 != 0:
                        print("Out of range.\n")
                        continue
                    else:
                        break
                except ValueError:  #..Error handling
                    print("Integer required, Try Again\n")
                    continue       
            while True:
                try:
                    credit_fail = int(input("Please enter your credits at FAIL: "))
                    if (credit_fail < 0 or credit_fail > 120) or credit_fail % 20 != 0:
                        print("Out of range.\n")
                        continue
                    else:
                        break
                except ValueError:  #..Error handling
                    print("Integer required, Try Again\n")
                    continue            
            #..Checking whether the total of pass, defer and fail credits is 120
            total = credit_pass + credit_defer + credit_fail
            if total != 120:
                print("Total incorrect.\n")
                continue
            else:
                break
        #..Printing the necessasary output and associating the inputs to the value variable 
        if credit_pass == 120:
            print("Progress\n")
            str_pass = str(credit_pass) #..Converting to string to concatenate values and write into the dictionary
            str_defer = str(credit_defer)
            str_fail = str(credit_fail)
            student_record[student_id] = "Progress - " + str_pass + "," + str_defer + "," + str_fail
        elif credit_pass == 100:
            print("Progress (module trailer)\n")
            str_pass = str(credit_pass) 
            str_defer = str(credit_defer)
            str_fail = str(credit_fail)
            student_record[student_id] = "Progress (module trailer) - " + str_pass + "," + str_defer + "," + str_fail
        elif credit_fail >= 0 and credit_fail <= 60:
            print("Module retreiver\n")
            str_pass = str(credit_pass) 
            str_defer = str(credit_defer)
            str_fail = str(credit_fail)
            student_record[student_id] = "Module retreiver - " + str_pass + "," + str_defer + "," + str_fail
        else:
            print("Exclude\n")
            str_pass = str(credit_pass) 
            str_defer = str(credit_defer)
            str_fail = str(credit_fail) 
            student_record[student_id] = "Exclude - " + str_pass + "," + str_defer + "," + str_fail
        while True: #..program iteration while loop
            loop = input("Would you like to enter another set of data?\nEnter 'y' for yes or 'q' to quit: ").lower() #.. Accepting both upper or lower cases since it will be converted to lower case  
            if loop == "y":
                print()
                break            
            elif loop.isnumeric(): #..checking whether the input is a number
                print("You have entered a number, Try Again\n")
                continue            
            elif loop != "y" and loop != "q":
                print("Invalid input(letter), Try Again\n") #..Printing the statement for other wrong inputs
                continue
            else:
                print()
                for (ID,CREDITS) in student_record.items(): #..Reads keys and their values from the dictionary and print
                    print(ID,":",CREDITS,end=" ")                
                raise StopIteration #..all the innermost Loops at the point are stopped here     
except StopIteration: #... This exception stops all the innermost loops at the raised point #..Referenced - medium.com
    print("\nThe program terminates.")
