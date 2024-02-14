#..DOC 334 Introduction to Programming II - P2 Coursework

#..Calling for a module in same folder
import printStatements
#____________________________Main program____________________________


#Connecting to mysql server
import mysql.connector

#..Open the created database connection with a dictionarey
conDict = {'host':'localhost','database':'ABCbooksStore','user':'root','password':''}

db = mysql.connector.connect(**conDict)

#..Pepare a cursor object using cursor() method to create tables
cursor = db.cursor()

#..initializing variables for loop
q1 = " "
q2 = " "
q3 = " "
q4 = " "
q2a = " "
q2b = " "
q2c = " "
q3a = " "
q3b = " "
q3c = " "
q4a = " "
q4b = " "
q4c = " "
choiceMain = True
choice1 = True
choice2 = True
choice3 = True
choice4 = True
choice5 = True
choice6 = True
choice7 = True
choice8 = True
choice9 = True
choice10 = True
choiceA = True
choiceB = True
choiceC = True
choiceD = True
choiceA1 = True
choiceA2 = True
choiceA3 = True
choiceA4 = True
ans = " "
ans1 = " "
ans2 = " "
ans3 = " "
ans4 = " "
ans5 = " "
ans6 = " "
ans7 = " "
ans8 = " "
ans9 = " "
ansA = " "
ansB = " "
ansC = " "
ansD = " "
ansE = " "
ansF = " "
ansG = " "
ansH = " "
ansAE = " "
#..Initializing variables for functions
record = " "
subject = " "
book = " "
chapter = " "
subject1 = " "
book1 = " "
chapter1 = " "
subject2 = " "
book2 = " "
chapter2 = " "
output = " "
output2 = " "
run = " "

while choiceMain:
    #..functions, inputs and conditions to search for records into the database
    while choiceA1:
        #..Asking whether the user need search for a record in the database
        q1 = input("Do you want to search for a record ? (Y/N) :")    
        if q1 == "Y" or q1 == "y":
            while choice1:
                #..Get user inputs to search for a record in the books table for direct search
                recorddetails = input("Book Number / Book Title / Author / Publisher:")
                if recorddetails == "Book Number" or recorddetails == "book number" or recorddetails == "Book number" or recorddetails == "BOOK NUMBER":
                    #..Get user inputs for book number to direct search
                    nbookNo = input ("Enter book number :")
                    
                    #..execute SQL query using execute() method to view a record in books table
                    cursor.execute ("SELECT * FROM books WHERE bookNo =" + nbookNo + "")

                    #..Fetch results using fetchall() method
                    data = cursor.fetchall()

                    #..Printing values in the record
                    for item in data:
                        for value in item:
                            print (value,end=" ; ")
                        print()

                elif recorddetails == "Book Title" or recorddetails == "book title" or recorddetails == "Book title" or recorddetails == "BOOK TITLE":
                    #..Get user inputs for book title to direct search
                    nbooktitle = input ("Enter book title :")
                    
                    #..execute SQL query using execute() method to view a record in books table
                    cursor.execute ("SELECT * FROM books WHERE bookTitle ='" + nbooktitle + "'")

                    #..Fetch results using fetchall() method
                    data = cursor.fetchall()

                    #..Printing values in the record
                    for item in data:
                        for value in item:
                            print (value,end=" ; ")
                        print()

                elif recorddetails == "Author" or recorddetails == "author" or recorddetails == "AUTHOR":
                    #..Get user inputs for author of the book to direct search
                    nauthor = input ("Enter author name :")
                    
                    #..execute SQL query using execute() method to view a record in books table
                    cursor.execute ("SELECT * FROM books WHERE author ='" + nauthor + "'")

                    #..Fetch results using fetchall() method
                    data = cursor.fetchall()

                    #..Printing values in the record
                    for item in data:
                        for value in item:
                            print (value,end=" ; ")
                        print()

                elif recorddetails == "Publisher" or recorddetails == "publisher" or recorddetails == "PUBLISHER":
                    #..Get user inputs for publisher of the book to direct search
                    npublisher = input ("Enter publisher name :")
                    
                    #..execute SQL query using execute() method to view a record in books table
                    cursor.execute ("SELECT * FROM books WHERE publisher ='" + npublisher + "'")

                    #..Fetch results using fetchall() method
                    data = cursor.fetchall()

                    #..Printing values in the record
                    for item in data:
                        for value in item:
                            print (value,end=" ; ")
                        print()
                        
                elif recorddetails != "Book Number" or recorddetails != "book number" or recorddetails != "Book number" or recorddetails != "BOOK NUMBER" or recorddetails != "Book Title" or recorddetails != "book title" or recorddetails != "Book title" or recorddetails != "BOOK TITLE" or recorddetails != "Author" or recorddetails != "author" or recorddetails != "AUTHOR" or recorddetails != "Publisher" or recorddetails != "publisher" or recorddetails != "PUBLISHER":
                    print ()
                    printStatements.wronginput(output)
                    print ()
                else:
                    print ()
                    
                #..Input and conditions to run the program to search for records from table in a loop
                ans = input("Do you want to search for another record ? (Y/N) :")
                if ans == "Y" or ans == "y":
                    choice1 = True
                    continue
                elif ans == "N" or ans == "n":
                    choice1 = False
                    printStatements.find(record)
                    print ()
                elif ans != "Y" or ans != "y" or ans != "N" or ans != "n":
                    choice1 = False
                    print ()
                    printStatements.wronginput(output)
                    print ()
                else:
                    ans = input("Do you want to search for another record ? (Y/N) :")

        elif q1 == "N" or q1 == "n":
            break
        elif q1 != "Y" or q1 != "y" or q1 != "N" or q1 != "n":
            print()
            printStatements.wronginput(output)
            print()
            break
        else:
            print()

    #..functions, inputs and conditions to add new records into the database
    while choiceA2:
        #..Asking whether the user need to add a record
        q2 = input("Do you want to add a record ? (Y/N) :")
        if q2 == "Y" or q2 == "y":
            while choiceA:
                #..Asking whether the user need to add a record to subjects table
                q2a = input("Do you want to add a record to subjects table ? (Y/N) :")
                if q2a == "Y" or q2a == "y":
                    while choice2:
                        #..Get user inputs for subjects table
                        usubjectCode = input("Enter subject code :")
                        usubjectName = input("Enter subject name :")

                        #..execute SQL query using execute() method to add new data for subjects table
                        mySQLText1 = "INSERT INTO subjects (subjectCode,subjectName) VALUES (%s,%s)"
                        myValues1 = (usubjectCode,usubjectName)
                        cursor.execute (mySQLText1,myValues1)

                        #..Commit the change
                        db.commit()

                        #..Input and conditions to run the program to add new records for subjects table in a loop
                        ans1 = input("Do you want to add another subject ? (Y/N) :")
                        if ans1 == "Y" or ans1 == "y":
                            choice2 = True
                            continue
                        elif ans1 == "N" or ans1 == "n":
                            choice2 = False
                            print()
                            printStatements.add1(subject)
                            print()
                            break
                        elif ans1 != "Y" or ans1 != "y" or ans1 != "N" or ans1 != "n":
                            choice2 = False
                            print()
                            printStatements.wronginput(output)
                            print()
                        else:
                            ans1 = input("Do you want to add another subject ? (Y/N) :")

                elif q2a == "N" or q2a == "n":
                    #..Asking whether the user need to add a record to books table
                    q2b = input("Do you want to add a record to books table ? (Y/N) :")
                    if q2b == "Y" or q2b == "y":
                        while choice3:
                            #..Get user inputs for the Books table 
                            ubookNo = int(input("Enter book number :"))
                            ubooktitle = input("Enter book title :")
                            usubjectCode = input("Enter subject code :")
                            uauthor = input("Enter author name :")
                            upublisher = input("Enter publisher name :")
                            uprice = float(input("Enter price:"))
                            ulocation = input("Enter location:")
                            uisbn = int(input("Enter ISBN number :"))
                            
                            #..execute SQL query using execute() method to add new data for books table
                            mySQLText2 = "INSERT INTO books (bookNo,bookTitle,subjectCode,author,publisher,price,location,isbn) VALUES (%s,%s,%s,%s,%s,%s,%s,%s)"
                            myValues2 = (ubookNo,ubooktitle,usubjectCode,uauthor,upublisher,uprice,ulocation,uisbn)
                            cursor.execute (mySQLText2,myValues2)

                            #..Commit the change
                            db.commit()
                            
                            #..Input and conditions to run the program to add new records for books table in a loop
                            ans2 = input("Do you want to add another book ? (Y/N) :")
                            if ans2 == "Y" or ans2 == "y":
                                choice3 = True
                                continue
                            elif ans2 == "N" or ans2 == "n":
                                choice3 = False
                                print()
                                printStatements.add2(book)
                                print()
                                break
                            elif ans2 != "Y" or ans2 != "y" or ans2 != "N" or ans2 != "n":
                                choice3 = False
                                print()
                                printStatements.wronginput(output)
                                print()
                            else:
                                ans2 = input("Do you want to add another book ? (Y/N) :")
                    
                    elif q2a == "N" or q2a == "n" or q2b == "N" or q2b == "n" :
                        #..Asking whether the user need to add a record to chapters table
                        q2c = input("Do you want to add a record to chapters table ? (Y/N) :")
                        if q2c == "Y" or q2c == "y":                      
                            while choice4:    
                                #..Get user inputs for the tables Books or sublects
                                ubookNo = input("Enter book number :")
                                uchapterNo = input("Enter chapter number :")
                                uchaptertitle = input("Enter title :")
                                ustartPg = int(input("Enter starting page :"))
                                uendPg = int(input("Enter ending page :"))
                                
                                #..execute SQL query using execute() method to add new data for chapters table
                                mySQLText3 = "INSERT INTO chapters (bookNo,chapterNo,chapterTitle,startPg,endPg) VALUES (%s,%s,%s,%s,%s)"
                                myValues3 = (ubookNo,uchapterNo,uchaptertitle,ustartPg,uendPg)
                                cursor.execute (mySQLText3,myValues3)

                                #..Commit the change
                                db.commit()

                                #..Input and conditions to run the program to add new records for chapters table in a loop
                                ans3 = input("Do you want to add another chapter ? (Y/N) :")
                                if ans3 == "Y" or ans3 == "y":
                                    choice4 = True
                                    continue
                                elif ans3 == "N" or ans3 == "n":
                                    choice4 = False
                                    print()
                                    printStatements.add3(chapter)
                                    print()
                                    break
                                elif ans3 != "Y" or ans3 != "y" or ans3 != "N" or ans3 != "n":
                                    print()
                                    choice4 = False
                                    print()
                                    printStatements.wronginput(output)
                                else:
                                    ans3 = input("Do you want to add another chapter ? (Y/N) :")
                                    
                        elif q2c == "N" or q2c == "n":
                            break
                        else:
                            print()
                            
                elif q2a != "N" or q2a != "n" or q2b != "N" or q2b != "n" or q2c != "N" or q2c != "n" or q2a != "Y" or q2a != "y" or q2b != "Y" or q2b != "y" or q2c != "Y" or q2c != "y":
                    print()
                    printStatements.wronginput(output)
                    print()
                
                #..Input and conditions to continue the program in a loop from first after an error
                ansB = input("Do you want to continue adding records? (Y/N) :")
                if ansB == "Y" or ansB == "y":
                    choiceA = True
                    continue
                elif ansB == "N" or ansB == "n":
                    choiceA = False
                    print()
                    break
                elif ansB != "Y" or ansB != "y" or ansB != "N" or ansB != "n":
                    choiceA = False
                    print()
                    printStatements.wronginput(output)
                    print()
                else:
                    ansB = input("Do you want to continue adding records? (Y/N) :")
                break
            
        elif q2 == "N" or q2 == "n" :
            break
        
        elif q2 != "Y" or q2 != "y" or q2 != "N" or q2 != "n":
            choiceA2 = False
            print()
            printStatements.wronginput(output)
            print()
       
    #..functions, inputs and conditions to Update the records in the data base
    while choiceA3:
        #..Asking whether the user need update an available record
        q3 = input("Do you want to update a record ? (Y/N) :")
        if q3 == "Y" or q3 == "y":
            while choiceB:
                #..Asking whether the user need update an available record in subjects table
                q3a = input ("Do you want to update the subject table ? (Y/N) :")
                if q3a == "Y" or q3a == "y":
                    choice5 = True
                    #..Updating subjects table
                    while choice5:
                        #..Asking the user which fields record need to be updated in subjects table
                        subdetails = input ("subject Name / subject Code) :")
                        if subdetails == "SUBJECT CODE" or subdetails == "Subject Code" or subdetails == "Subject Code" or subdetails == "subject code":
                        #..Get user inputs to update subject code
                            usubjectCode = input("Enter existing subject code :")
                            nsubjectCode = input("Enter new subject code :")
                        
                            #..execute SQL query using execute() method to update data in subjects table
                            cursor.execute ("UPDATE subjects SET subjectCode = '" + nsubjectCode + "' WHERE subjectCode = '" + usubjectCode + "'")

                            #..Commit the change
                            db.commit()
                        
                        elif subdetails == "SUBJECT NAME" or subdetails == "Subject name" or subdetails == "Subject Name" or subdetails == "subject name":
                            #..Get user inputs to update subject name in subjects table
                            usubjectCode = input("Enter subject code :")
                            nsubjectName = input("Enter new subject name :")

                            #..execute SQL query using execute() method to update data in subjects table
                            cursor.execute ("UPDATE subjects SET subjectName = '" + nsubjectName + "' WHERE subjectCode = '" + usubjectCode + "'")

                            #..Commit the change
                            db.commit()

                        elif subdetails != "SUBJECT NAME" or subdetails != "subject name" or subdetails != "Subject Name" or subdetails != "SUBJECT CODE" or subdetails != "Subject Code" or subdetails != "subject code":
                            printStatements.wronginput(output)
                        else:
                            print()
                            
                        #..Input and conditions to run the program to update a record for subject table in a loop
                        ans4 = input("Do you want to update another subject ? (Y/N) :")
                        if ans4 == "Y" or ans4 == "y":
                            choice5 = True
                            continue
                        elif ans4 == "N" or ans4 == "n":
                            choice5 = False
                            print()
                            printStatements.update1(subject1)
                            print()
                            break
                        elif ans4 != "Y" or ans4 != "y" or ans4 != "N" or ans4 != "n":
                            choice5 = False
                            print()
                            printStatements.wronginput(output)
                            print()
                        else:
                            ans4 = input("Do you want to update another subject ? (Y/N) :")
                            
                            
                elif q3a == "N" or q3a == "n":
                    #..Asking whether the user need update an available record in books table
                    q3b = input ("Do you want to update the books table ? (Y/N) :")
                    if q3b == "Y" or q3b == "y":
                        #..Updating books table
                        while choice6:
                            #..Asking the user which fields record need to be updated in books table
                            bookdetails = input ("Book Number / Book Title / Author / Publisher / Price /Location/ ISBN Number) :")
                            if bookdetails == "book number" or bookdetails == "Book Number" or bookdetails == "Book number" or bookdetails == "BOOK NUMBER":
                            #..Get user inputs to update book number
                                ubookNo = input("Enter existing book number :")
                                nbookNo = input("Enter new book number :")
                            
                                #..execute SQL query using execute() method to update data in books table
                                cursor.execute ("UPDATE books SET bookNo = '" + nbookNo + "' WHERE bookNo = '" + ubookNo + "'")
                                
                                #..Commit the change
                                db.commit()
                            
                            elif bookdetails == "book title" or bookdetails == "Book Title" or bookdetails == "Book title" or bookdetails == "BOOK TITLE":
                                #..Get user inputs to update book title in books table
                                ubookNo = input("Enter book number :")
                                nbookTitle = input("Enter new book title :")
                            
                                #..execute SQL query using execute() method to update data in books table
                                cursor.execute ("UPDATE books SET bookTitle = '" + nbookTitle + "' WHERE bookNo = '" + ubookNo + "'")
                                
                                #..Commit the change
                                db.commit()
                                
                            elif bookdetails == "author" or bookdetails == "Author" or bookdetails == "AUTHOR":
                                #..Get user inputs to update author of the book in books table
                                ubookNo = input("Enter book number :")
                                nauthor = input("Enter new author of the book :")
                            
                                #..execute SQL query using execute() method to update data in books table
                                cursor.execute ("UPDATE books SET author = '" + nauthor + "' WHERE bookNo = '" + ubookNo + "'")
                                
                                #..Commit the change
                                db.commit()

                            elif bookdetails == "publisher" or bookdetails == "Publisher" or bookdetails == "PUBLISHER":
                                #..Get user inputs to update book title in books table
                                ubookNo = input("Enter book number :")
                                npublisher = input("Enter new publisher :")
                            
                                #..execute SQL query using execute() method to update data in books table
                                cursor.execute ("UPDATE books SET publisher = '" + npublisher + "' WHERE bookNo = '" + ubookNo + "'")
                                
                                #..Commit the change
                                db.commit()

                            elif bookdetails == "price" or bookdetails == "Price" or bookdetails == "PRICE":
                                #..Get user inputs to update price of a book in books table
                                ubookNo = input("Enter book number :")
                                nprice = input("Enter new price of the book :")
                            
                                #..execute SQL query using execute() method to update data in books table
                                cursor.execute ("UPDATE books SET price = '" + nprice + "' WHERE bookNo = '" + ubookNo + "'")
                                
                                #..Commit the change
                                db.commit()

                            elif bookdetails == "location" or bookdetails == "Location" or bookdetails == "LOCATION":
                                #..Get user inputs to update location in books table
                                ubookNo = input("Enter book number :")
                                nlocation = input("Enter new location of the book :")
                            
                                #..execute SQL query using execute() method to update data in books table
                                cursor.execute ("UPDATE books SET location = '" + nlocation + "' WHERE bookNo = '" + ubookNo + "'")
                                
                                #..Commit the change
                                db.commit()

                            elif bookdetails == "ISBN Number" or bookdetails == "isbn number" or bookdetails == "ISBN number" or bookdetails == "ISBN NUMBER":
                                #..Get user inputs for to update ISBN Number in books table
                                ubookNo = input("Enter book number :")
                                nisbnNo = input("Enter new ISBN Number :")
                            
                                #..execute SQL query using execute() method to update data in books table
                                cursor.execute ("UPDATE books SET isbnNo = '" + nisbnNo + "' WHERE bookNo = '" + ubookNo + "'")
                                
                                #..Commit the change
                                db.commit()
                                
                            elif bookdetails != "book number" or bookdetails != "Book Number" or bookdetails != "Book number" or bookdetails != "BOOK NUMBER" or bookdetails != "book title" or bookdetails != "Book Title" or bookdetails != "Book title" or bookdetails != "BOOK TITLE" or bookdetails != "author" or bookdetails != "Author" or bookdetails != "AUTHOR" or bookdetails != "publisher" or bookdetails != "Publisher" or bookdetails != "PUBLISHER" or bookdetails != "price" or bookdetails != "Price" or bookdetails != "PRICE" or bookdetails != "location" or bookdetails != "Location" or bookdetails != "LOCATION" or bookdetails != "ISBN Number" or bookdetails != "isbn number" or bookdetails != "ISBN number" or bookdetails != "ISBN NUMBER":
                                printStatements.wronginput(output)
                            else:
                                print()

                            #..Input and conditions to run the program to update a record for books table in a loop
                            ans5 = input("Do you want to update another book ? (Y/N) :")
                            if ans5 == "Y" or ans5 == "y":
                                choice6 = True
                                continue
                            elif ans5 == "N" or ans5 == "n":
                                choice6 = False
                                print()
                                printStatements.update2(book1)
                                print()
                                break
                            elif ans5 != "Y" or ans5 != "y" or ans5 != "N" or ans5 != "n":
                                choice6 = False
                                print()
                                printStatements.wronginput(output)
                                print()
                            else:
                                ans5 = input("Do you want to update another book ? (Y/N) :")     
                    elif q3b == "N" or q3b == "n" or q3c == "N" or q3c == "n":
                        #..Asking whether the user need update an available record in chapters table
                        q3c = input ("Do you want to update the chapters table ? (Y/N) :")
                        if q3c == "Y" or q3c == "y":
                            #..Updating chapters table
                            while choice7:
                                #..Asking the user which fields record need to be updated in chapters table
                                chapterdetails = input ("Chapter Number / Chapter Title / Starting Page No / Ending Page No :")
                                if chapterdetails == "chapter number" or chapterdetails == "Chapter Number" or chapterdetails == "Chapter number" or chapterdetails == "CHAPTER NUMBER":
                                    #..Get user inputs to update chapter number in chapter table
                                    uchapterNo = input("Enter chapter number :")
                                    nchapterNo = input("Enter new chapter number :")
                                
                                    #..execute SQL query using execute() method to update data in chapters table
                                    cursor.execute ("UPDATE chapters SET chapterNo = '" + nchapterNo + "' WHERE chapterNo = '" + uchapterNo + "'")
                                    
                                    #..Commit the change
                                    db.commit()
                                    
                                elif chapterdetails == "chapter title" or chapterdetails == "Chapter Title" or chapterdetails == "Chapter title" or chapterdetails == "CHAPTER TITLE":
                                    #..Get user inputs to update chapter title in chapter table
                                    uchapterNo = input("Enter chapter number :")
                                    nchapterTitle = input("Enter new chapter title :")
                                
                                    #..execute SQL query using execute() method to update data in chapter table
                                    cursor.execute ("UPDATE chapters SET chapterTitle = '" + nchapterTitle + "' WHERE chapterNo = '" + uchapterNo + "'")
                                    
                                    #..Commit the change
                                    db.commit()
                                elif chapterdetails == "Starting Page No" or chapterdetails == "starting page no" or chapterdetails == "STARTING PG NO":
                                    #..Get user inputs to update starting page of the chapter in chapter table
                                    uchapterNo = input("Enter chapter number :")
                                    nstartPg = input("Enter new starting page of the chapter :")
                                
                                    #..execute SQL query using execute() method to update data in chapter table
                                    cursor.execute ("UPDATE chapters SET startPg = '" + nstartPg + "' WHERE chapterNo = '" + uchapterNo + "'")
                                    
                                    #..Commit the change
                                    db.commit()
                                elif chapterdetails == "Ending Page No" or chapterdetails == "ending page no" or chapterdetails == "ENDING PG NO":
                                    #..Get user inputs to update ending page of the chapter in chapter table
                                    uchapterNo = input("Enter chapter number :")
                                    nendPg = input("Enter new ending page of the chapter :")
                                
                                    #..execute SQL query using execute() method to update data in chapter table
                                    cursor.execute ("UPDATE chapters SET endPg = '" + nendPg + "' WHERE chapterNo = '" + uchapterNo + "'")
                                    
                                    #..Commit the change
                                    db.commit()

                                elif chapterdetails != "book number" or chapterdetails != "Book Number" or chapterdetails != "Book number" or chapterdetails != "BOOK NUMBER" or chapterdetails != "chapter title" or chapterdetails != "Chapter Title" or chapterdetails != "Chapter title" or chapterdetails != "CHAPTER TITLE" or chapterdetails != "Starting Page No" or chapterdetails != "starting page no" or chapterdetails != "STARTING PG NO" or chapterdetails != "Ending Page No" or chapterdetails != "ending page no" or chapterdetails != "ENDING PG NO":
                                    printStatements.wronginput(output)
                                else:
                                    print()
                        
                                #..Input and conditions to run the program to update a record for chapters table in a loop
                                ans6 = input("Do you want to update another chapter ? (Y/N) :")
                                if ans6 == "Y" or ans6 == "y":
                                    choice7 = True
                                    continue
                                elif ans6 == "N" or ans6 == "n":
                                    choice7 = False
                                    print ()
                                    printStatements.update3(chapter1)
                                    print ()
                                    break
                                elif ans6 != "Y" or ans6 != "y" or ans6 != "N" or ans6 != "n":
                                    choice7 = False
                                    print ()
                                    printStatements.wronginput(output)
                                    print ()
                                else:
                                    ans6 = input("Do you want to update another chapter ? (Y/N) :")
                                    
                        elif q3c == "N" or q3c == "n":
                            break
                    elif q3b == "N" or q3b == "n":
                        break
                        
                elif q3a != "N" or q3a != "n" or q3b != "N" or q3b != "n" or q3c != "N" or q3c != "n" or q3a != "Y" or q3a != "y" or q3b != "Y" or q3b != "y" or q3c != "Y" or q3c != "y":
                    print()
                    printStatements.wronginput(output)
                    print()
                    
                #..Input and conditions to continue the program in a loop from first after an error
                ansC = input("Do you want to continue updating? (Y/N) :")
                if ansC == "Y" or ansC == "y":
                    choiceB = True
                    continue
                elif ansC == "N" or ansC == "n":
                    choiceC = True
                    print ()
                    break
                elif ansC != "Y" or ansC != "y" or ansC != "N" or ansC != "n":
                    choiceB = False
                    print ()
                    printStatements.wronginput(output)
                    print ()
                else:
                    ansC = input("Do you want to continue updating? (Y/N) :")

        elif q3 == "N" or q3 == "n":
            break
                            
        elif q3 != "Y" or q3 != "y" or q3 != "N" or q3 != "n":
            choiceA3 = False
            print ()
            printStatements.wronginput(output)
            print ()
        else:
            print()
            
    #..functions, inputs and conditions to delete the records in the data base
    while choiceA4:
        #..Asking whether the user need to delete an available record
        q4 = input("Do you want to delete a record ? (Y/N) :")   
        if q4 == "Y" or q4 == "y":
            while choiceC:
                #..Asking whether the user need to delete an available record in subjects table
                q4a = input ("Do you want to delete a record in the subject table ? (Y/N) :")
                if q4a == "Y" or q4a == "y":
                    while choice8:
                        #..Get user inputs to delete a record in subjects table
                        usubjectCode = input("Enter subject code :")
                    
                        #..execute SQL query using execute() method to delete a record in books table
                        cursor.execute ("DELETE FROM subjects WHERE subjectCode = '" + usubjectCode + "'")
                        
                        #..Commit the change
                        db.commit()
                        
                        #..Input and conditions to run the program to delete a record from subjects table in a loop
                        ans7 = input("Do you want to delete another subject ? (Y/N) :")
                        if ans7 == "Y" or ans7 == "y":
                            choice8 = True
                            continue
                        elif ans7 == "N" or ans7 == "n":
                            choice8 = False
                            print ()
                            printStatements.delete1(subject2)
                            print ()
                            break
                        elif ans7 != "Y" or ans7 != "y" or ans7 != "N" or ans7 != "n":
                            choice8 = False
                            print ()
                            printStatements.wronginput(output)
                            print ()
                        else:
                            ans7 = input("Do you want to delete another subject ? (Y/N) :")
                        break

                elif q4a == "N" or q4a == "n":
                    #..Asking whether the user need delete an available record in books table
                    q4b = input ("Do you want to delete a record in the books table ? (Y/N) :")
                    if q4b == "Y" or q4b == "y":
                        while choice9:
                            #..Get user inputs to delete a record in books table
                            ubookNo = input("Enter book number :")
                        
                            #..execute SQL query using execute() method to delete a record in books table
                            cursor.execute ("DELETE FROM books WHERE bookNo = '" + ubookNo + "'")
                            
                            #..Commit the change
                            db.commit()
                                                        
                            #..Input and conditions to run the program to delete a record from books table in a loop
                            ans8 = input("Do you want to delete another book ? (Y/N) :")
                            if ans8 == "Y" or ans8 == "y":
                                choice9 = True
                                continue
                            elif ans8 == "N" or ans8 == "n":
                                choice9 = False
                                print ()
                                printStatements.delete2(book2)
                                print ()
                                break
                            elif ans8 != "Y" or ans8 != "y" or ans8 != "N" or ans8 != "n":
                                choice9 = False
                                print ()
                                printStatements.wronginput(output)
                                print ()
                            else:
                                ans8 = input("Do you want to delete another book ? (Y/N) :")
                            break
                        
                    elif q4a == "N" or q4a == "n" or q4b == "N" or q4b == "n" :
                        #..Asking whether the user need delete an available record in chapters table
                        q4c = input ("Do you want to delete a record in the chapters table ? (Y/N) :")
                        if q4c == "Y" or q4c == "y":
                            choice10 = True
                            while choice10:
                                #..Get user inputs to delete a record in chapters table
                                uchapterNo = input("Enter chapter number :")
                            
                                #..execute SQL query using execute() method to delete a record in chapters table
                                cursor.execute ("DELETE FROM chapters WHERE bookNo = '" + uchapterNo + "'")
                                
                                #..Commit the change
                                db.commit()
                            
                                #..Input and conditions to run the program to delete a record from chapters table in a loop
                                ans9 = input("Do you want to delete another chapter ? (Y/N) :")
                                if ans9 == "Y" or ans9 == "y":
                                    choice10 = True
                                    continue
                                elif ans9 == "N" or ans9 == "n":
                                    choice10 = False
                                    print ()
                                    printStatements.delete3(chapter2)
                                    print ()
                                    break
                                elif ans9 != "Y" or ans9 != "y" or ans9 != "N" or ans9 != "n":
                                    choice10 = False
                                    print ()
                                    printStatements.wronginput(output)
                                    print ()
                                else:
                                    ans9 = input("Do you want to delete another chapter ? (Y/N) :")
                                break
                        elif q4c == "N" or q4c == "n":
                            break
                        
                    elif q4c == "N" or q4c == "n":
                        break                    
                elif q4a != "N" or q4a != "n" or q4b != "N" or q4b != "n" or q4c != "N" or q4c != "n" or q4a != "Y" or q4a != "y" or q4b != "Y" or q4b != "y" or q4c != "Y" or q4c != "y":
                    print()
                    printStatements.wronginput(output)
                    print()

                #..Input and conditions to continue the program in a loop from first after an error
                ansD = input("Do you want to continue deleting ? (Y/N) :")
                if ansD == "Y" or ansD == "y":
                    choiceC = True
                    continue
                elif ansD == "N" or ansD == "n":
                    choiceC = False
                    print()
                    break
                elif ansD != "Y" or ansD != "y" or ansD != "N" or ansD != "n":
                    choiceC = False
                    print ()
                    printStatements.wronginput(output)
                    print ()
                else:
                    ansD = input("Do you want to continue deleting ? (Y/N) :")
                break 
                   
        elif q4 == "N" or q4 == "n":
            break
        
        elif q4 != "Y" or q4 != "y" or q4 != "N" or q4 != "n":
            print ()
            printStatements.wronginput(output)
            break
            print ()
        else:
            print()
            
    #..close database
    db.close()

    #..Input and conditions to run the complete program in a loop
    ansAE = input("Do you want to run the program again ? (Y/N) :")
    if ansAE == "Y" or ansAE == "y":
        choiceMain = True
        continue
    elif ansAE == "N" or ansAE == "n":
        choiceMain = False
        printStatements.main (run)
        break
    elif ansAE != "Y" or ansAE != "y" or ansAE != "N" or ansAE != "n":
        choiceMain = False
        printStatements.wronginput(output)
    else:
        ansAE = input("Do you want to run the program again ? (Y/N) :")
    break

