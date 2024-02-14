available_books = set()
book = dict()
title = dict()
author = dict()
publisher = dict()
chapter_title = []
chapter_st_page = []
chapter_en_page = []
subject_code = dict()
subject_name = dict()
def create_book(book_no,tit,subcode,auth,pub,pri,loc,chap):
    if not subcode in subject_code:
        print("There is no any subject code in the system please try to create new subject code or try with other subject code Thank you")
        return
    available_books.add(book_no)
    title[tit] = book_no
    subject_code[subcode].append(book_no)
    book[book_no] = dict()
    if not auth in author:
        author[auth] = []
    if not pub in publisher:
        publisher[pub] = []
    author[auth].append(book_no)
    publisher[pub].append(book_no)
    book[book_no] = {"Title" : tit,"Subject Code" : subcode,"Author" : auth,
                     "Publisher" : pub,"Price" : pri,"Location" : loc,
                     "Number of Chapters" : chap}

def chap_info(book_no,chap_no,tit,st,en):
    temp = []
    temp[chap_no] = {"Chapter Title" : tit,"Starting page No" : st,"Ending page No" : en}
    chapter[book_no].append(temp)
    
def sub(subno,subname):
    subject_code[subno] = []
    subject_name[subno] = subname
def search(info):
    available = []
    if (info[0]!=-1):
        if (info[0] in available_books):
            available.append(info[0])
    elif (info[1]!="#"):
        if (title[info[1]] in available_books):
            available.append(info[1])
    else:
        if (info[2]!="#" and info[3]!="#"):
            available.append(available_books & author[info[2]] & publisher[info[3]])
        elif (info[2]!='#'):
            available.append(available_books & author[info[2]])
        else:
            available.append(available_books & publisher[info[3]])
    for i in available:
        print(book[i])
        
def edit_book(book_no,tit,subcode,auth,pub,pri,loc,chap):
    if tit!=book[book_no]["Title"] and tit!="#":
        title[book[book_no]["Title"]] = "#"
        book[book_no]["Title"] = tit;
        title[tit] = book_no
    if subcode!=book[book_no]["Subject Code"] and subcode!=-1 :
        subject_code[book[book_no]["Subject Code"]].pop(book_no)
        book[book_no]["Subject Code"] = subcode;
        subject_code[subcode].append(book_no)
    if auth!=book[book_no]["Author"] and auth !="#":
        author[book[book_no]["Author"]].pop(book_no)
        book[book_no]["Author"] = auth;
        author[auth].append(book_no)
    if pub!=book[book_no]["Publisher"] and pub!="#":
        publisher[book[book_no]["Publisher"]].pop(book_no)
        book[book_no]["Publisher"] = pub;
        publisher[pub].append(book_no)
    if pri!=book[book_no]["Price"] and pri!=-1:
        book[book_no]["Price"] = pri;
    if loc!=book[book_no]["Location"] and loc !="#":
        book[book_no]["Location"] = loc;
    if chap!=book[book_no]["Number of Chapters"] and chap!=-1:
        book[book_no]["Number of Chapters"] = chap;
def del_book(book_no):
    available_books.remove(book_no)
    title.pop(book[book_no]["Title"])
    subject_code[book[book_no]["Subject Code"]].remove(book_no)
    author[book[book_no]["Author"]].pop(book_no)
    publisher[book[book_no]["Publisher"]].pop(book_no)
    book.pop(book_no)
print("Welcome to the Book store System")
while(True):
    print("For Create a book press 1")
    print("For edit a book press 2")
    print("For delete a book press 3")
    print("For edit chapter info press 4")
    print("For Create a subject press 5")
    print("To Search a book press 6")
    print("To exit the System press 7")
    print('\n')
    print("Please enter each data in seperate lines")
    x = int(input())
    if x==1:
        print("Please Enter the book no,title,subject code,author,publisher,price,location,number of chapters in given order")
        bookno = int(input())
        tit = str(input())
        subcode = int(input())
        auth = str(input())
        pub = str(input())
        pri = int(input())
        loc = str(input())
        chap = str(input())
        create_book(bookno,tit,subcode,auth,pub,pri,loc,chap)    
    elif x==2:
         print("Please Enter the book no,title,subject code,author,publisher,price,location,number of chapters in given order")
         print("if you want to keep old datas please enter # symbol for text datas and -1 for number datas")
         bookno = int(input())
         tit = str(input())
         subcode = int(input())
         auth = str(input())
         pub = str(input())
         pri = int(input())
         loc = str(input())
         chap = str(input())
         edit_book(bookno,tit,subcode,auth,pub,pri,loc,chap)   
    elif x==3:
        print("Please Enter the Book no")
        bookno = int(input())
        del_book(bookno)
    elif x==4:
        print("Please Enter the Book no,chapter no,title of the chapter,starting page,ending page in given order")
        bookno = int(input())
        chap = int(input())
        tit = str(input())
        st = int(input())
        en = int(input())
        chap_info(bookno,chap,tit,st,en)
        
    elif x==5:
        print("Please enter the Subject no and Subject name in given order")
        subcode = int(input())
        subname = str(input())
        sub(subcode,subname)

    elif x==6:
        temp = []
        print("Please enter book no,title,author name,publisher info in given order")
        print("if you don't have the info please enter # symbol instead of data")
        bookno = input()
        if (bookno !='#'):
            temp.append(int(bookno))
        else:
            temp.append(bookno)
        for i in range (0,3):
            x = str(input())
            temp.append(x)
        search(temp)
    else:
        break
    print('\n')
    
print("Thank you for using the system")
