#Connecting to mysql server
import mysql.connector

#..Open the created database connection with a dictionarey
conDict = {'host':'localhost','database':'ABCbooksStore','user':'root','password':''}

db = mysql.connector.connect(**conDict)

#..Pepare a cursor object using cursor() method to create tables
cursor = db.cursor()

#,,Execute sql query using execute() method
AlterText = "ALTER TABLE 'chapters' ADD CONSTRAINT 'FK_chapters_bookNo' (bookNo) REFERENCES books(bookNo)"
cursor.execute(AlterText)

db.close
