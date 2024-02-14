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
    q1 = input("Do you want to search for a record ? (Y/N) :")    
    if q1 == "Y" or q1 == "y":
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

            print(printStatements.find(record))

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
                
            print(printStatements.find(record))

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

            db.commit()

            print(printStatements.find(record))

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
                
            print(printStatements.find(record))
                
        elif recorddetails != "Book Number" or recorddetails != "book number" or recorddetails != "Book number" or recorddetails != "BOOK NUMBER" or recorddetails != "Book Title" or recorddetails != "book title" or recorddetails != "Book title" or recorddetails != "BOOK TITLE" or recorddetails != "Author" or recorddetails != "author" or recorddetails != "AUTHOR" or recorddetails != "Publisher" or recorddetails != "publisher" or recorddetails != "PUBLISHER":
            print ()
            printStatements.wronginput(output)
            print ()
        else:
            print ()

            #..Input and conditions to run the complete program in a loop
        ansAE = input("Do you want to run the program again ? (Y/N) :")
        if ansAE == "Y" or ansAE == "y":
            choiceMain = True
            print ()
            continue
        elif ansAE == "N" or ansAE == "n":
            choiceMain = False
            print ()
            printStatements.main (run)
            break
        elif ansAE != "Y" or ansAE != "y" or ansAE != "N" or ansAE != "n":
            choiceMain = False
            print ()
            printStatements.wronginput(output)
        else:
            ansAE = input("Do you want to run the program again ? (Y/N) :")
        break
                
    elif q1 == "N" or q1 == "n":
        #..functions, inputs and conditions to add new records into the database
        q2 = input("Do you want to add a record ? (Y/N) :")
        if q2 == "Y" or q2 == "y":
            #..Asking whether the user need to add a record to subjects table
            q2a = input("Do you want to add a record to subjects table ? (Y/N) :")
            if q2a == "Y" or q2a == "y":
            #..Get user inputs for subjects table
                usubjectCode = input("Enter subject code :")
                usubjectName = input("Enter subject name :")

                #..execute SQL query using execute() method to add new data for subjects table
                mySQLText1 = "INSERT INTO subjects (subjectCode,subjectName) VALUES (%s,%s)"
                myValues1 = (usubjectCode,usubjectName)
                cursor.execute (mySQLText1,myValues1)

                #..Commit the change
                db.commit()

                print (cursor.rowcount,add1(subject))

            elif q2a == "N" or q2a == "n":
                #..Asking whether the user need to add a record to books table
                q2b = input("Do you want to add a record to books table ? (Y/N) :")
                if q2b == "Y" or q2b == "y":
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

                        print (cursor.rowcount,add2(book))
                
                elif q2a == "N" or q2a == "n" or q2b == "N" or q2b == "n" :
                    #..Asking whether the user need to add a record to chapters table
                    q2c = input("Do you want to add a record to chapters table ? (Y/N) :")
                    if q2c == "Y" or q2c == "y":                        
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

                            print (cursor.rowcount,add3(chapter))
                                
                    elif q2c == "N" or q2c == "n":
                        #..Input and conditions to run the complete program in a loop
                        ansAE = input("Do you want to run the program again ? (Y/N) :")
                        if ansAE == "Y" or ansAE == "y":
                            choiceMain = True
                            print ()
                            continue
                        elif ansAE == "N" or ansAE == "n":
                            choiceMain = False
                            print ()
                            printStatements.main (run)
                            break
                        elif ansAE != "Y" or ansAE != "y" or ansAE != "N" or ansAE != "n":
                            choiceMain = False
                            print ()
                            printStatements.wronginput(output)
                        else:
                            ansAE = input("Do you want to run the program again ? (Y/N) :")
                        break
                    
                    elif q2c != "Y" or q2c != "y" or q2c != "N" or q2c != "n":
                        print()
                        printStatements.wronginput(output)
                        print()
                    else:
                        print()
                
                elif q2b != "Y" or q2b != "y"  or q2b != "N" or q2b != "n" or q2a != "Y" or q2a != "y" or q2a != "N" or q2a != "n":
                    print()
                    printStatements.wronginput(output)
                    print()
                else:
                    print()
                    
            elif q2b != "Y" or q2b != "y"  or q2b != "N" or q2b != "n" or q2a != "Y" or q2a != "y" or q2a != "N" or q2a != "n" or q2c != "Y" or q2c != "y" or q2c != "N" or q2c != "n" :
                print()
                printStatements.wronginput(output)
                print()
            else:
                print()

#..Updating records            
        elif q2 == "N" or q2 == "n" or  q1 == "N" or q1 == "n":
            #..Asking whether the user need update an available record
            q3 = input("Do you want to update a record ? (Y/N) :")
            if q3 == "Y" or q3 == "y":
                #..Asking whether the user need update an available record in subjects table
                q3a = input ("Do you want to update the subject table ? (Y/N) :")
                if q3a == "Y" or q3a == "y":
                    #..Updating subjects table
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

                        print (cursor.rowcount,update1(subject2))
                    
                    elif subdetails == "SUBJECT NAME" or subdetails == "Subject name" or subdetails == "Subject Name" or subdetails == "subject name":
                        #..Get user inputs to update subject name in subjects table
                        usubjectCode = input("Enter subject code :")
                        nsubjectName = input("Enter new subject name :")

                        #..execute SQL query using execute() method to update data in subjects table
                        cursor.execute ("UPDATE subjects SET subjectName = '" + nsubjectName + "' WHERE subjectCode = '" + usubjectCode + "'")

                        #..Commit the change
                        db.commit()

                        print (cursor.rowcount,update1(subject2))

                    elif subdetails != "SUBJECT NAME" or subdetails != "subject name" or subdetails != "Subject Name" or subdetails != "SUBJECT CODE" or subdetails != "Subject Code" or subdetails != "subject code":
                        printStatements.wronginput(output)
                    else:
                        print()
                                 
                elif q3a == "N" or q3a == "n":
                    #..Asking whether the user need update an available record in books table
                    q3b = input ("Do you want to update the books table ? (Y/N) :")
                    if q3b == "Y" or q3b == "y":
                    #..Updating books table
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

                            print (cursor.rowcount,update2(book2))
                                
                        elif bookdetails == "book title" or bookdetails == "Book Title" or bookdetails == "Book title" or bookdetails == "BOOK TITLE":
                            #..Get user inputs to update book title in books table
                            ubookNo = input("Enter book number :")
                            nbookTitle = input("Enter new book title :")
                        
                            #..execute SQL query using execute() method to update data in books table
                            cursor.execute ("UPDATE books SET bookTitle = '" + nbookTitle + "' WHERE bookNo = '" + ubookNo + "'")
                            
                            #..Commit the change
                            db.commit()

                            print (cursor.rowcount,update2(book2))
                            
                        elif bookdetails == "author" or bookdetails == "Author" or bookdetails == "AUTHOR":
                            #..Get user inputs to update author of the book in books table
                            ubookNo = input("Enter book number :")
                            nauthor = input("Enter new author of the book :")
                        
                            #..execute SQL query using execute() method to update data in books table
                            cursor.execute ("UPDATE books SET author = '" + nauthor + "' WHERE bookNo = '" + ubookNo + "'")
                            
                            #..Commit the change
                            db.commit()

                            print (cursor.rowcount,update2(book2))

                        elif bookdetails == "publisher" or bookdetails == "Publisher" or bookdetails == "PUBLISHER":
                            #..Get user inputs to update book title in books table
                            ubookNo = input("Enter book number :")
                            npublisher = input("Enter new publisher :")
                        
                            #..execute SQL query using execute() method to update data in books table
                            cursor.execute ("UPDATE books SET publisher = '" + npublisher + "' WHERE bookNo = '" + ubookNo + "'")
                            
                            #..Commit the change
                            db.commit()

                            print (cursor.rowcount,update2(book2))

                        elif bookdetails == "price" or bookdetails == "Price" or bookdetails == "PRICE":
                            #..Get user inputs to update price of a book in books table
                            ubookNo = input("Enter book number :")
                            nprice = input("Enter new price of the book :")
                        
                            #..execute SQL query using execute() method to update data in books table
                            cursor.execute ("UPDATE books SET price = '" + nprice + "' WHERE bookNo = '" + ubookNo + "'")
                            
                            #..Commit the change
                            db.commit()

                            print (cursor.rowcount,update2(book2))

                        elif bookdetails == "location" or bookdetails == "Location" or bookdetails == "LOCATION":
                            #..Get user inputs to update location in books table
                            ubookNo = input("Enter book number :")
                            nlocation = input("Enter new location of the book :")
                        
                            #..execute SQL query using execute() method to update data in books table
                            cursor.execute ("UPDATE books SET location = '" + nlocation + "' WHERE bookNo = '" + ubookNo + "'")
                            
                            #..Commit the change
                            db.commit()

                            print (cursor.rowcount,update2(book2))

                        elif bookdetails == "ISBN Number" or bookdetails == "isbn number" or bookdetails == "ISBN number" or bookdetails == "ISBN NUMBER":
                            #..Get user inputs for to update ISBN Number in books table
                            ubookNo = input("Enter book number :")
                            nisbnNo = input("Enter new ISBN Number :")
                        
                            #..execute SQL query using execute() method to update data in books table
                            cursor.execute ("UPDATE books SET isbnNo = '" + nisbnNo + "' WHERE bookNo = '" + ubookNo + "'")
                            
                            #..Commit the change
                            db.commit()

                            print (cursor.rowcount,update2(book2))

                            
                        elif bookdetails != "book number" or bookdetails != "Book Number" or bookdetails != "Book number" or bookdetails != "BOOK NUMBER" or bookdetails != "book title" or bookdetails != "Book Title" or bookdetails != "Book title" or bookdetails != "BOOK TITLE" or bookdetails != "author" or bookdetails != "Author" or bookdetails != "AUTHOR" or bookdetails != "publisher" or bookdetails != "Publisher" or bookdetails != "PUBLISHER" or bookdetails != "price" or bookdetails != "Price" or bookdetails != "PRICE" or bookdetails != "location" or bookdetails != "Location" or bookdetails != "LOCATION" or bookdetails != "ISBN Number" or bookdetails != "isbn number" or bookdetails != "ISBN number" or bookdetails != "ISBN NUMBER":
                            printStatements.wronginput(output)
                        else:
                            print()

                    elif q3b == "N" or q3b == "n" or q3c == "N" or q3c == "n":
                        #..Asking whether the user need update an available record in chapters table
                        q3c = input ("Do you want to update the chapters table ? (Y/N) :")
                        if q3c == "Y" or q3c == "y":
                            #..Updating chapters table
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

                                print (cursor.rowcount,update3(chapter2))
                                
                            elif chapterdetails == "chapter title" or chapterdetails == "Chapter Title" or chapterdetails == "Chapter title" or chapterdetails == "CHAPTER TITLE":
                                #..Get user inputs to update chapter title in chapter table
                                uchapterNo = input("Enter chapter number :")
                                nchapterTitle = input("Enter new chapter title :")
                            
                                #..execute SQL query using execute() method to update data in chapter table
                                cursor.execute ("UPDATE chapters SET chapterTitle = '" + nchapterTitle + "' WHERE chapterNo = '" + uchapterNo + "'")
                                
                                #..Commit the change
                                db.commit()

                                print (cursor.rowcount,update3(chapter2))
                                
                            elif chapterdetails == "Starting Page No" or chapterdetails == "starting page no" or chapterdetails == "STARTING PG NO":
                                #..Get user inputs to update starting page of the chapter in chapter table
                                uchapterNo = input("Enter chapter number :")
                                nstartPg = input("Enter new starting page of the chapter :")
                            
                                #..execute SQL query using execute() method to update data in chapter table
                                cursor.execute ("UPDATE chapters SET startPg = '" + nstartPg + "' WHERE chapterNo = '" + uchapterNo + "'")
                                
                                #..Commit the change
                                db.commit()

                                print (cursor.rowcount,update3(chapter2))
                                
                            elif chapterdetails == "Ending Page No" or chapterdetails == "ending page no" or chapterdetails == "ENDING PG NO":
                                #..Get user inputs to update ending page of the chapter in chapter table
                                uchapterNo = input("Enter chapter number :")
                                nendPg = input("Enter new ending page of the chapter :")
                            
                                #..execute SQL query using execute() method to update data in chapter table
                                cursor.execute ("UPDATE chapters SET endPg = '" + nendPg + "' WHERE chapterNo = '" + uchapterNo + "'")
                                
                                #..Commit the change
                                db.commit()
                                print (cursor.rowcount,update3(chapter2))

                            elif chapterdetails != "book number" or chapterdetails != "Book Number" or chapterdetails != "Book number" or chapterdetails != "BOOK NUMBER" or chapterdetails != "chapter title" or chapterdetails != "Chapter Title" or chapterdetails != "Chapter title" or chapterdetails != "CHAPTER TITLE" or chapterdetails != "Starting Page No" or chapterdetails != "starting page no" or chapterdetails != "STARTING PG NO" or chapterdetails != "Ending Page No" or chapterdetails != "ending page no" or chapterdetails != "ENDING PG NO":
                                printStatements.wronginput(output)
                            else:
                                print()
                                            
                        elif q3c == "N" or q3c == "n":
                            #..Input and conditions to run the complete program in a loop
                            ansAE = input("Do you want to run the program again ? (Y/N) :")
                            if ansAE == "Y" or ansAE == "y":
                                choiceMain = True
                                print ()
                                continue
                            
                            elif ansAE == "N" or ansAE == "n":
                                choiceMain = False
                                print ()
                                printStatements.main (run)
                                break
                            
                            elif ansAE != "Y" or ansAE != "y" or ansAE != "N" or ansAE != "n":
                                choiceMain = False
                                print ()
                                printStatements.wronginput(output)
                            else:
                                ansAE = input("Do you want to run the program again ? (Y/N) :")
                            break
                                                    
                    elif q3a != "N" or q3a != "n" or q3b != "N" or q3b != "n" or q3c != "N" or q3c != "n" or q3a != "Y" or q3a != "y" or q3b != "Y" or q3b != "y" or q3c != "Y" or q3c != "y":
                        print()
                        printStatements.wronginput(output)
                        print()
                    else:
                        print()
                else:
                    print()

            elif q3 == "N" or q3 == "n" or q2 == "N" or q2 == "n" or q1 == "N" or q1 == "n":    
                #..functions, inputs and conditions to delete the records in the data base
                q4 = input("Do you want to delete a record ? (Y/N) :")   
                if q4 == "Y" or q4 == "y":
                    #..Asking whether the user need to delete an available record in subjects table
                    q4a = input ("Do you want to delete a record in the subject table ? (Y/N) :")
                    if q4a == "Y" or q4a == "y":
                            #..Get user inputs to delete a record in subjects table
                            usubjectCode = input("Enter subject code :")
                        
                            #..execute SQL query using execute() method to delete a record in books table
                            cursor.execute ("DELETE FROM subjects WHERE subjectCode = '" + usubjectCode + "'")
                            
                            #..Commit the change
                            db.commit()

                            print (cursor.rowcount,delete1(subject3))
                            
                    elif q4a == "N" or q4a == "n":
                        #..Asking whether the user need delete an available record in books table
                        q4b = input ("Do you want to delete a record in the books table ? (Y/N) :")
                        if q4b == "Y" or q4b == "y":
                                #..Get user inputs to delete a record in books table
                                ubookNo = input("Enter book number :")
                            
                                #..execute SQL query using execute() method to delete a record in books table
                                cursor.execute ("DELETE FROM books WHERE bookNo = '" + ubookNo + "'")
                                
                                #..Commit the change
                                db.commit()

                                print (cursor.rowcount,delete2(book3))
        
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

                                    print (cursor.rowcount,delete3(chapter3))
                                    
                            elif q4c == "N" or q4c == "n":
                                #..Input and conditions to run the complete program in a loop
                                ansAE = input("Do you want to run the program again ? (Y/N) :")
                                if ansAE == "Y" or ansAE == "y":
                                    choiceMain = True
                                    print ()
                                    continue
                                elif ansAE == "N" or ansAE == "n":
                                    choiceMain = False
                                    print ()
                                    printStatements.main (run)
                                    break
                                elif ansAE != "Y" or ansAE != "y" or ansAE != "N" or ansAE != "n":
                                    choiceMain = False
                                    print ()
                                    printStatements.wronginput(output)
                                else:
                                    ansAE = input("Do you want to run the program again ? (Y/N) :")
                                break   
                            
                        else:
                            print()
                        
                    elif q4a != "N" or q4a != "n" or q4b != "N" or q4b != "n" or q4c != "N" or q4c != "n" or q4a != "Y" or q4a != "y" or q4b != "Y" or q4b != "y" or q4c != "Y" or q4c != "y":
                        print()
                        printStatements.wronginput(output)
                        print()
                           
                elif q4 == "N" or q4 == "n":
                    #..Input and conditions to run the complete program in a loop
                    ansAE = input("Do you want to run the program again ? (Y/N) :")
                    if ansAE == "Y" or ansAE == "y":
                        choiceMain = True
                        print ()
                        continue
                    
                    elif ansAE == "N" or ansAE == "n":
                        choiceMain = False
                        print ()
                        printStatements.main (run)
                        break
                    
                    elif ansAE != "Y" or ansAE != "y" or ansAE != "N" or ansAE != "n":
                        choiceMain = False
                        print ()
                        printStatements.wronginput(output)
                    else:
                        ansAE = input("Do you want to run the program again ? (Y/N) :")
                    break
                    
                elif q4 != "Y" or q4 != "y" or q4 != "N" or q4 != "n":
                    print ()
                    printStatements.wronginput(output)
                    break
                    print ()
                else:
                    print()                    
                    
            elif q3 != "Y" or q3 != "y" or q3 != "N" or q3 != "n" or q1 != "Y" or q1 != "y" or q1 != "N" or q1 != "n" or q2 != "Y" or q2 != "y" or q2 != "N" or q2 != "n":
                print ()
                printStatements.wronginput(output)
                break
                print ()
            else:
                print()
                
        elif q1 != "Y" or q1 != "y" or q1 != "N" or q1 != "n" or q2 != "Y" or q2 != "y" or q2 != "N" or q2 != "n" :
            print ()
            printStatements.wronginput(output)
            break
            print ()
        else:
            print()

    elif q1 != "Y" or q1 != "y" or q1 != "N" or q1 != "n" or q2 != "Y" or q2 != "y" or q2 != "N" or q2 != "n" or q3 != "Y" or q3 != "y" or q3 != "N" or q3 != "n" or q4 != "Y" or q4 != "y" or q4 != "N" or q4 != "n":
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
        print ()
        continue
    
    elif ansAE == "N" or ansAE == "n":
        choiceMain = False
        print ()
        printStatements.main (run)
        break
    
    elif ansAE != "Y" or ansAE != "y" or ansAE != "N" or ansAE != "n":
        choiceMain = False
        print ()
        printStatements.wronginput(output)
    else:
        ansAE = input("Do you want to run the program again ? (Y/N) :")
    break


