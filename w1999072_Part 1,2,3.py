#I declare that my work contains no examples of misconduct, sch as plagiarism, or collusion.
#Any code taken from other sources is referenced within my code solution.

#Westminster Student ID: 19990727
#IIT Student ID: 20210847
#Date:

#..Creating variables
credit_pass = 0
credit_defer = 0
credit_fail = 0
total = 0
outcome_count = 0
progress_count = 0
trailer_count = 0
retreiver_count = 0
exclude_count = 0
main_list = []
file = 0

#..This function accepts the input values and append to the list
def list_fun():
    main_list.append(credit_pass) 
    main_list.append(credit_defer)
    main_list.append(credit_fail)

#..This function accepts the input values and change the type then wrte in the text file
def text_file_fun():
    file.write(str(f'{credit_pass}\n'))
    file.write(str(f'{credit_defer}\n'))
    file.write(str(f'{credit_fail}\n'))

#..Part 1 of the coursework that the program predicts progression outcomes at the end of each academic year
file = open("Credit_Volume.txt","w+")
print("","="*75,"\n\tWelcome to Annual Academic Progress Outcome Prediction System\n","="*75,"\n") #Welcome Note
print("""Student section =  1
Staff Section   =  2\n""")
while True: #..........Program loop.............. 
    section = input("Enter desired number to move forward (1/2) ")
    if section == "1":
        break
    elif section == "2":
        break
    else:
        print("Invalid Input, Try Again")
try:
    while True: #.. program section iteration while loop
        while True: #.. Total validating while loop               
            while True:
                try:#..Validating the inputs whether it is an integer and within the range 0 and 120
                    credit_pass = int(input("Please enter your credits at PASS: "))
                    if (0 > credit_pass or 120 < credit_pass) or credit_pass % 20 != 0:
                        print("Out of range.\n")
                        continue
                    else:
                        break
                except ValueError: #..Error handling (validating whether the input is a number)
                    print("Integer required\n")
            while True:
                try:
                    credit_defer = int(input("Please enter your credits at DEFER: "))
                    if (credit_defer < 0 or credit_defer > 120) or credit_defer % 20 != 0:
                        print("Out of range.\n")
                        continue
                    else:
                        break
                except ValueError:
                    print("Integer required\n")
            while True:
                try:
                    credit_fail = int(input("Please enter your credits at FAIL: "))
                    if (credit_fail < 0 or credit_fail > 120) or credit_fail % 20 != 0:
                        print("Out of range.\n")
                        continue
                    else:
                        break
                except ValueError:
                    print("Integer required\n")
            total = credit_pass + credit_defer + credit_fail
            if total != 120:
                print("Total incorrect.\n")
                continue
            else:
                break
        if section == "1":
            #..Printing the necessasary output
            if credit_pass == 120:
                print("Progress\n")
            elif credit_pass == 100:
                print("Progress(module trailer)\n") 
            elif credit_fail >= 0 and credit_fail <= 60:
                print("Module retreiver\n")
            else:
                print("Exclude\n")
        elif section == "2":
            #..Printing the necessasary output and appending the inputs to the list and writing to the text file
            if credit_pass == 120:
                print("Progress\n")
                main_list.append("Progress - ")
                list_fun() #..calling list function
                file.write("Progress -\n")
                text_file_fun() #..calling text file function
                progress_count += 1
            elif credit_pass == 100:
                print("Progress(module trailer)\n")
                main_list.append("Progress(module trailer) - ")
                list_fun()
                file.write("Progress (module trailer) -\n")
                text_file_fun()
                trailer_count += 1
            elif credit_fail >= 0 and credit_fail <= 60:
                print("Module retreiver\n")
                main_list.append("Module retreiver - ")
                list_fun()
                file.write("Module retreiver -\n")
                text_file_fun()
                retreiver_count += 1
            else:
                print("Exclude\n")
                main_list.append("Exclude - ")
                list_fun()
                file.write("Exclude -\n")
                text_file_fun()
                exclude_count += 1
            outcome_count += 1
            main_tuple = tuple(main_list) #..Coverting the list to tuple where the input data cannot be changed since they are marks
        while True:#..program iteration while loop
            loop = input("Would you like to enter another set of data again?\nEnter 'y' for yes or 'q' to quit: ").lower()#.. Accepting both upper or lower cases since it will be converted to lower case  
            if loop == "y":
                print()
                break
            elif loop.isnumeric():
                print("You have entered a number, Try Again\n")#..Printing this statement if the input is a number
                continue
            elif loop != "y" and loop != "q":
                print("Invalid input(letter), Try Again\n") #..Printing this statement for other worng inputs
                continue
            else:
                if section == "1" and loop == "q":
                    raise StopIteration #..all the innermost Loops at the point are stopped here
                else:
                    #..Printing the histogram by recording the times that the loop has executed to print relevant outputs
                    print()
                    print("-"*75,"\nHistogram")
                    print(f'Progress   {progress_count:02} : {"*"*progress_count}\nTrailer    {trailer_count:02} : {"*"*trailer_count}\nRetriever  {retreiver_count:02} : {"*"*retreiver_count}\nExcluded   {exclude_count:02} : {"*"*exclude_count}\n')
                    #..Printing the statement based on english grammar
                    if outcome_count == 1: 
                        print(outcome_count,"outcome in total.")
                        print("-"*75)
                    else:
                        print(outcome_count,"outcomes in total.")
                        print("-"*75)
    #...................Part 2 of the coursework  (printing items appended to the list) 
                    print("\nPart 2:\n")
                    count = 1
                    for value in main_tuple:
                        if count % 4 == 1:
                            print(value,end="")
                        elif count % 4 == 0:
                            print (value,end="")
                            print()
                        else:
                            print(value,end=",")
                        count += 1
    #...................Part 3 of coursework (printing the marks appended in the text file)
                    print ("\nPart 3:\n")
                    with open("Credit_Volume.txt","r") as file:
                        count = 1
                        for line in file:
                            if count % 4 == 1:
                                print(line.strip(),end=" ")
                            elif count % 4 == 0:
                                print(line.strip(),end="")
                                print()
                            else:
                                print(line.strip(),end=",")
                            count += 1
                    raise StopIteration #..all the innermost Loops at the point are stopped here
except StopIteration: #... This exception stops all the innermost loops at the raised point #..Referenced - medium.com
    print("\nThe program terminates.")
file.close()
