#..DOC 334 Introduction to Programming II - P2 Coursework

#Connect to mysql server
import mysql.connector

#..Open the created database connection with a dictionarey
conDict = {'host':'localhost','database':'ABCbooksStore','user':'root','password':''}

db = mysql.connector.connect(**conDict)

#..Pepare a cursor object using cursor() method to create tables
cursor = db.cursor()

#..Read user inputs for subjects table
usubjectCode = input("Enter subject code :")
usubjectName = input("Enter subject name :")

#..execute SQL query using execute() method to add new data for subjects table
mySQLText1 = "INSERT INTO subjects (subjectCode,subjectName) VALUES (%s,%s)"
myValues1 = (usubjectCode,usubjectName)
cursor.execute (mySQLText1,myValues1)

#..Commit range
db.commit()

#..Check whether the record is added successfully
print (cursor.rowcount, "Record Added")

#..Read user inputs for books table
ubookNo = int(input("Enter book number :"))
utitle = input("Enter title :")
usubjectCode = input("Enter subject code :")
uauthor = input("Enter author name :")
upublisher = input("Enter publisher name :")
uprice = float(input("Enter price:"))
ulocation = input("Enter location:")
uisbn = int(input("Enter ISBN number :"))

#..execute SQL query using execute() method to add new data for books table
mySQLText2 = "INSERT INTO books (bookNo,title,subjectCode,author,publisher,price,location,isbn) VALUES (%s,%s,%s,%s,%s,%s,%s,%s)"
myValues2 = (ubookNo,utitle,usubjectCode,uauthor,upublisher,uprice,ulocation,uisbn)
cursor.execute (mySQLText2,myValues2)

#..Commit range
db.commit()

#..Check whether the record is added successfully
print (cursor.rowcount, "Record Added")

#..Read user inputs for subjects table
ubookNo = input("Enter book number :")
uchapterNo = input("Enter chapter number :")
utitle = input("Enter title :")
ustartPg = int(input("Enter starting page :"))
uendPg = int(input("Enter ending page :"))

#..execute SQL query using execute() method to add new data for chapters table
mySQLText3 = "INSERT INTO chapters (bookNo,chapterNo,title,startPg,endPg) VALUES (%s,%s,%s,%s,%s)"
myValues3 = (ubookNo,uchapterNo,utitle,ustartPg,uendPg)
cursor.execute (mySQLText3,myValues3)

#..Commit range
db.commit()

#..Check whether the record is added successfully
print (cursor.rowcount, "Record Added")


#..close database
db.close()
