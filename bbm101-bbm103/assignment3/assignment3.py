#Mehmet Berat Ersari. 21992943.
#Artificial intelligence engineering student
#chess game
import sys
f=open(sys.argv[1], "r")
commands=[[line.split()] for line in f.readlines()]
f.close()
for i in range(len(commands)): #i converted the commands more useful.
    commands[i]=commands[i][0]
board=[["R1","N1","B1","QU","KI","B2","N2","R2"],["P1","P2","P3","P4","P5","P6","P7","P8"],["  ","  ","  ","  ","  ","  ","  ","  "],["  ","  ","  ","  ","  ","  ","  ","  "],["  ","  ","  ","  ","  ","  ","  ","  "],["  ","  ","  ","  ","  ","  ","  ","  "],["p1","p2","p3","p4","p5","p6","p7","p8"],["r1","n1","b1","qu","ki","b2","n2","r2"]]
mymatrix=[["a8","b8","c8","d8","e8","f8","g8","h8"],["a7","b7","c7","d7","e7","f7","g7","h7"],["a6","b6","c6","d6","e6","f6","g6","h6"],["a5","b5","c5","d5","e5","f5","g5","h5"],["a4","b4","c4","d4","e4","f4","g4","h4"],["a3","b3","c3","d3","e3","f3","g3","h3"],["a2","b2","c2","d2","e2","f2","g2","h2"],["a1","b1","c1","d1","e1","f1","g1","h1"]]
whites=["p1","p2","p3","p4","p5","p6","p7","p8","r1","n1","b1","qu","ki","b2","n2","r2"]
blacks=["P1","P2","P3","P4","P5","P6","P7","P8","R1","N1","B1","QU","KI","B2","N2","R2"]
siyah_piyon=["P1","P2","P3","P4","P5","P6","P7","P8"]
beyaz_piyon=["p1","p2","p3","p4","p5","p6","p7","p8"]
def tasin_konumunu_bulma(deger,matrix): # this function finds the position of piece. I used different version of this in assignment 2. But this is shorter than it.
    global x,y # i assume the board as a x-y coordinat system
    a=[(index, row.index(deger)) for index, row in enumerate(matrix) if deger in row]
    x,y=a[0][1],a[0][0]
    return  x and y
def ilktasin_konumunu_bulma(deger,matrix): #i use this function to remove a piece from the board.
    global r,t
    a=[(index, row.index(deger)) for index, row in enumerate(matrix) if deger in row]
    r,t=a[0][1],a[0][0]
    return  r and t
def konumyazdir(): # this line prints command and result. i use this showmoves command
    a.sort()
    komutyazdir()
    if len(a)>0:
        for i in a:
            print(i,end=" ")
        print("")
    else:print("FAILED")
def komutyazdir(): # this line just prints commands i use this for just print move command
    print(">", end=" ")
    for i in commands[k]:
        print(i, end=" ")
    print("")
def haritayazdir(): #this line prints the board
    print("----------------------------")
    for i in board:
        for j in i:
            print(j, end=" ")
        print("")
    print("----------------------------")
def tasin_varligi_kontrol(): # this line checks wheter the chess piece is on the board
    list4=[]
    for i in board:
        for j in i:
            list4.append(j)
    if commands[k][1] in list4:
        return True
    else: return False

def kaleyonler(tasinrengi,zitti): # i use this function to find showmoves of rooks
    global list0
    list0 = []
    tasin_konumunu_bulma(commands[k][1], board)
    m = 1
    while x + m < 8:
        if board[y][x + m] in tasinrengi: break
        count = 1
        if board[y][x + m] in zitti and count == 1:
            count += 1
            list0.append(mymatrix[y][x + m])
            break
        else: list0.append(mymatrix[y][x + m])
        if board[y][x + m] == "KI" or board[y][x + m] == "ki":
            list0.remove(mymatrix[y][x + m])
        m += 1
    m = 1
    while x - m > -1:
        if board[y][x - m] in tasinrengi: break
        count = 1
        if board[y][x - m] in zitti and count == 1:
            count += 1
            list0.append(mymatrix[y][x - m])
            break
        else: list0.append(mymatrix[y][x - m])
        if board[y][x - m] == "KI" or board[y][x - m] == "ki":
            list0.remove(mymatrix[y][x - m])
        m += 1
    m = 1
    while y - m > -1:
        if board[y - m][x] in tasinrengi: break
        count = 1
        if board[y - m][x] in zitti and count == 1:
            count += 1
            list0.append(mymatrix[y - m][x])
            break
        else: list0.append(mymatrix[y - m][x])
        if board[y - m][x] == "KI" or board[y - m][x] == "ki":
            list0.remove(mymatrix[y - m][x])
        m += 1
    m = 1
    while y + m < 8:
        if board[y + m][x] in tasinrengi: break
        count = 1
        if board[y + m][x] in zitti and count == 1:
            count += 1
            list0.append(mymatrix[y + m][x])
            break
        else: list0.append(mymatrix[y + m][x])
        if board[y + m][x] == "KI" or board[y + m][x] == "ki":
            list0.remove(mymatrix[y + m][x])
        m += 1
    return list0
def filbulma(tasinrengi,zitti):  # i use this function to find showmoves of white bishop
    global list0
    list0 = []
    tasin_konumunu_bulma(commands[k][1], board)
    m = 1
    while x + m < 8 and y - m > -1:
        if board[y - m][x + m] in tasinrengi: break
        count = 1
        if board[y - m][x + m] in zitti and count == 1:
            count += 1
            list0.append(mymatrix[y - m][x + m])
            break
        else: list0.append(mymatrix[y - m][x + m])
        if board[y - m][x + m] == "KI" or board[y - m][x + m] == "ki":
            list0.remove(mymatrix[y - m][x + m])
        m += 1
    m = 1
    while x - m > -1 and y - m > -1:
        if board[y - m][x - m] in tasinrengi: break
        count = 1
        if board[y - m][x - m] in zitti and count == 1:
            count += 1
            list0.append(mymatrix[y - m][x - m])
            break
        else: list0.append(mymatrix[y - m][x - m])
        if board[y - m][x - m] == "KI" or board[y - m][x - m] == "ki":
            list0.remove(mymatrix[y - m][x - m])
        m += 1
    return list0
def filbulma2(tasinrengi,zitti): # i use this function to find showmoves of black bishop
        global list0
        list0 = []
        tasin_konumunu_bulma(commands[k][1], board)
        m = 1
        while x + m < 8 and y + m < 8:
            if board[y + m][x + m] in tasinrengi: break
            count = 1
            if board[y + m][x + m] in zitti and count == 1:
                count += 1
                list0.append(mymatrix[y + m][x + m])
                break
            else: list0.append(mymatrix[y + m][x + m])
            if board[y + m][x + m]== "KI" or board[y + m][x + m]== "ki":
                list0.remove(mymatrix[y + m][x + m])
            m += 1
        m = 1
        while x - m > -1 and y + m < 8:
            if board[y + m][x - m] in tasinrengi: break
            count = 1
            if board[y + m][x - m] in zitti and count == 1:
                count += 1
                list0.append(mymatrix[y + m][x - m])
                break
            else: list0.append(mymatrix[y + m][x - m])
            if board[y + m][x - m]== "KI" or board[y + m][x - m]== "ki":
                list0.remove(mymatrix[y + m][x - m])
            m += 1
        return list0
def vezirbulma(tasinrengi,zitti): ## i use this function to find showmoves of queens
    global list0
    list0=[]
    v,n,m=filbulma(tasinrengi,zitti),filbulma2(tasinrengi,zitti),kaleyonler(tasinrengi,zitti)
    list0=v+n+m
    return list0
def atbulma(tasrengi): # i use this function to find showmoves of knights
    global list0
    list0 = []
    tasin_konumunu_bulma(commands[k][1], board)
    m,n = 1,2
    if x + m < 8 and y + n < 8:
        if (board[y + n][x + m] == "  " or board[y + n][x + m] in tasrengi) and (board[y + n][x + m]!="ki" and board[y + n][x + m]!="KI") : list0.append(mymatrix[y + n][x + m])
    if x + n < 8 and y + m < 8:
        if (board[y + m][x + n] == "  " or board[y + m][x + n] in tasrengi) and (board[y + m][x + n]!="ki" and board[y + m][x + n]!="KI"): list0.append(mymatrix[y + m][x + n])
    if x + m < 8 and y - n > -1:
        if (board[y - n][x + m] == "  " or board[y - n][x + m] in tasrengi) and (board[y - n][x + m]!="ki" and board[y - n][x + m]!="KI"): list0.append(mymatrix[y - n][x + m])
    if x - m > -1 and y + n < 8:
        if (board[y + n][x - m] == "  " or board[y + n][x - m] in tasrengi) and (board[y + n][x - m]!="ki" and board[y + n][x - m]!="KI"): list0.append(mymatrix[y + n][x - m])
    if x - m > -1 and y - n > -1:
        if (board[y - n][x - m] == "  " or board[y - n][x - m] in tasrengi) and (board[y - n][x - m]!="ki" and board[y - n][x - m]!="KI"): list0.append(mymatrix[y - n][x - m])
    if x + n < 8 and y - m > -1:
        if (board[y - m][x + n] == "  " or board[y - m][x + n] in tasrengi) and (board[y - m][x + n]!="ki" and board[y - m][x + n]!="KI"): list0.append(mymatrix[y - m][x + n])
    if x - n > -1 and y - m > -1:
        if (board[y - m][x - n] == "  " or board[y - m][x - n] in tasrengi) and (board[y - m][x - n]!="ki" and board[y - m][x - n]!="KI"): list0.append(mymatrix[y - m][x - n])
    if x - n > -1 and y + m < 8:
        if (board[y + m][x - n] == "  " or board[y + m][x - n] in tasrengi) and (board[y + m][x - n]!="ki" and board[y + m][x - n]!="KI"): list0.append(mymatrix[y + m][x - n])
    m, n = 1, 1
    if x + n < 8 and y + m < 8:
        if board[y + m][x + n] == "  ": list0.append(mymatrix[y + m][x + n])
    if x + m < 8 and y - n > -1:
        if board[y - n][x + m] == "  ": list0.append(mymatrix[y - n][x + m])
    if x - m > -1 and y - n > -1:
        if board[y - n][x - m] == "  ": list0.append(mymatrix[y - n][x - m])
    if x - n > -1 and y + m < 8:
        if board[y + m][x - n] == "  ": list0.append(mymatrix[y + m][x - n])
    return list0
def piyonbulma(tasrengi,zitti): # i use this function to find showmoves of pawn
    global list0
    list0 = []
    tasin_konumunu_bulma(commands[k][1], board)
    if tasrengi==whites:
        if y - 1 > -1:
            if (board[y - 1][x] == "  " or board[y - 1][x] in zitti) and (board[y - 1][x]!="ki" and board[y - 1][x]!="KI"): list0.append(mymatrix[y - 1][x])
        return list0
    else:
        if y+1<8:
            if (board[y + 1][x] == "  " or board[y + 1][x] in zitti) and (board[y + 1][x]!="ki" and board[y + 1][x]!="KI"): list0.append(mymatrix[y + 1][x])
        return list0
def kralbulma(tasrengininzitti): # i use this function to find showmoves of king
    global list0
    list0 = []
    tasin_konumunu_bulma(commands[k][1], board)
    if x + 1 < 8:
        if (board[y][x + 1] == "  " or board[y][x + 1] in tasrengininzitti) and (board[y][x + 1]!="ki" and board[y][x + 1]!="KI"): list0.append(mymatrix[y][x + 1])
        if y + 1 < 8:
            if (board[y + 1][x + 1] == "  " or board[y + 1][x + 1] in tasrengininzitti) and (board[y + 1][x + 1]!="ki" and board[y + 1][x + 1]!="KI"): list0.append(mymatrix[y + 1][x + 1])
        if y - 1 > -1:
            if (board[y - 1][x + 1] == "  " or board[y - 1][x + 1] in tasrengininzitti) and (board[y - 1][x + 1]!="ki" and board[y - 1][x + 1]!="KI"): list0.append(mymatrix[y - 1][x + 1])
    if x - 1 > -1:
        if (board[y][x - 1] == "  " or board[y][x - 1] in tasrengininzitti) and (board[y][x - 1]!="ki" and board[y][x - 1]!="KI"): list0.append(mymatrix[y][x - 1])
        if y + 1 < 8:
            if (board[y + 1][x - 1] == "  " or board[y + 1][x - 1] in tasrengininzitti) and (board[y + 1][x - 1]!="ki" and board[y + 1][x - 1]!="KI"): list0.append(mymatrix[y + 1][x - 1])
        if y - 1 > -1:
            if (board[y - 1][x - 1] == "  " or board[y - 1][x - 1] in tasrengininzitti) and (board[y - 1][x - 1]!="ki" and board[y - 1][x - 1]!="KI"): list0.append(mymatrix[y - 1][x - 1])
    if y + 1 < 8:
        if (board[y + 1][x] == "  " or board[y + 1][x] in tasrengininzitti) and (board[y + 1][x]!="ki" and board[y + 1][x]!="KI"): list0.append(mymatrix[y + 1][x])
    if y - 1 > -1:
        if (board[y - 1][x] == "  " or board[y - 1][x] in tasrengininzitti) and (board[y - 1][x]!="ki" and board[y - 1][x]!="KI"): list0.append(mymatrix[y - 1][x])
    return list0
def hareket_tespit(): # this line exucute if a piece eat another piece.
    if commands[k][2] in a:
        tasin_konumunu_bulma(commands[k][2], mymatrix)
        ilktasin_konumunu_bulma(commands[k][1], board)
        board[y][x] = board[t][r]
        board[t][r] = "  "
        komutyazdir()
        print("OK")
    else: komutyazdir(),print("FAILED")
k=-1
for i in commands:
    k += 1
    if i[0] == "exit":
        komutyazdir()
        break
    elif i[0] == "initialize":
        komutyazdir()
        print("OK")
        board = [["R1", "N1", "B1", "QU", "KI", "B2", "N2", "R2"],["P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8"],["  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "],["  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "],["  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "],["  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "],["p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8"],["r1", "n1", "b1", "qu", "ki", "b2", "n2", "r2"]]
        haritayazdir()
    elif i[0] == "print": komutyazdir(), haritayazdir()
    elif i[0] == "showmoves":
        if tasin_varligi_kontrol():
            if commands[k][1] == "r1" or commands[k][1] == "r2": a = kaleyonler(whites, blacks)
            elif commands[k][1] == "R1" or commands[k][1] == "R2": a = kaleyonler(blacks, whites)
            elif commands[k][1] == "b1" or commands[k][1] == "b2": a = filbulma(whites,blacks)
            elif commands[k][1] == "B1" or commands[k][1] == "B2": a = filbulma2(blacks,whites)
            elif commands[k][1] == "qu": a = vezirbulma(whites, blacks)
            elif commands[k][1] == "QU": a = vezirbulma(blacks, whites)
            elif commands[k][1] == "n1" or commands[k][1] == "n2": a = atbulma(blacks)
            elif commands[k][1] == "N1" or commands[k][1] == "N2": a = atbulma(whites)
            elif commands[k][1] in beyaz_piyon: a = piyonbulma(whites, blacks)
            elif commands[k][1] in siyah_piyon: a = piyonbulma(blacks, whites)
            elif commands[k][1] == "ki": a = kralbulma(blacks)
            elif commands[k][1] == "KI": a = kralbulma(whites)
            konumyazdir()
        else: komutyazdir(),print("FAILED")
    elif i[0] == "move":
        if tasin_varligi_kontrol():
            if commands[k][1] == "r1" or commands[k][1] == "r2": a = kaleyonler(whites, blacks)
            elif commands[k][1] == "R1" or commands[k][1] == "R2": a = kaleyonler(blacks, whites)
            elif commands[k][1] == "b1" or commands[k][1] == "b2": a = filbulma(whites,blacks)
            elif commands[k][1] == "B1" or commands[k][1] == "B2": a = filbulma2(blacks,whites)
            elif commands[k][1] == "qu": a = vezirbulma(whites, blacks)
            elif commands[k][1] == "QU": a = vezirbulma(blacks, whites)
            elif commands[k][1] == "n1" or commands[k][1] == "n2": a = atbulma(blacks)
            elif commands[k][1] == "N1" or commands[k][1] == "N2": a = atbulma(whites)
            elif commands[k][1] in beyaz_piyon: a = piyonbulma(whites, blacks)
            elif commands[k][1] in siyah_piyon: a = piyonbulma(blacks, whites)
            elif commands[k][1] == "ki": a = kralbulma(blacks)
            elif commands[k][1] == "KI": a = kralbulma(whites)
            hareket_tespit()
        else: komutyazdir(), print("FAILED")
