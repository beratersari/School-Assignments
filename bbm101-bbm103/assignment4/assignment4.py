import sys
import os
karakterler=["A","a","B","b","C","c","D","d","E","e","F","f","G","g","H","h","I","i","J","j","K","k","L","l","M","m","N","n","O","o","P","p","R","r","S","s","T","t","U","u","V","v","Y","y","Z","z","w","W"," ","X","x","Q","q"]
numaralar=["1","2","3","4","5","6","7","8","9","0",","]
ters_dict = {1: "A", 2: "B", 3: "C", 4: "D", 5: "E", 6: "F", 7: "G", 8: "H", 9: "I",10: "J", 11: "K",12: "L",13: "M", 14: "N", 15: "O", 16: "P", 17: "Q", 18: "R",19: "S", 20: "T", 21: "U", 22: "V", 23: "W", 24: "X", 25: "Y", 26: "Z", 27: " "}
dictim={"A":1,"a":1,"B":2,"b":2,"C":3,"c":3,"D":4,"d":4,"E":5,"e":5,"F":6,"f":6,"G":7,"g":7,"H":8,"h":8,"I":9,"i":9,"J":10,"j":10,"K":11,"k":11,"L":12,"l":12,"M":13,"m":13,"N":14,"n":14,"O":15,"o":15,"P":16,"p":16,"Q":17,"q":17,"R":18,"r":18,"S":19,"s":19,"T":20,"t":20,"U":21,"u":21,"V":22,"v":22,"W":23,"w":23,"X":24,"x":24,"Y":25,"y":25,"Z":26,"z":26," ":27}
try:
    kodcesidi=sys.argv[1]
    keyfile=sys.argv[2]
    inputfile=sys.argv[3]
    outputfile=sys.argv[4]
    if len(sys.argv)>5: raise IndexError
    if not (kodcesidi=="enc" or kodcesidi=="dec"): raise Exception
except IndexError:
    print("Parameter number error.")
    exit()
except :
    print("Undefined parameter error.")
    exit()
try:
    if inputfile[-3:]!="txt": raise Exception
    assert os.path.exists(inputfile)
except AssertionError:
    print("Input file not found error.")
    exit()
except:
    print("Input file could not be read error.")
    exit()
try:
    if keyfile[-3:]!="txt": raise Exception
    assert os.path.exists(keyfile)
except AssertionError:
    print("Key file not found error.")
    exit()
except :
    print("Key file could not be read.")
    exit()
u=open(inputfile,"r")
try:
    if u.readlines()==[]: raise Exception
except:
    print("Input file is empty error.")
    exit()
u.close()
u=open(keyfile,"r")
try:
    if u.readlines()==[]: raise Exception
except:
    print("Key file is empty error.")
    exit()
u.close()
if kodcesidi=="enc": # this check in plaininput
    u=open(inputfile,"r")
    k=u.readlines()
    for i in range(len(k)):
        k[i]=k[i].strip("\n")
    try:
        for i in k:
            for j in i:
                if j not in karakterler: raise Exception
    except:
        print("Invalid character in input file error.")
        exit()
    u.close()
elif kodcesidi=="dec": # this check in chipertext
    u=open(inputfile,"r")
    k=u.readlines()
    for i in range(len(k)):
        k[i]=k[i].strip("\n")
    try:
        for i in k:
            for j in i:
                if j not in numaralar: raise Exception
    except:
        print("Invalid character in ciphertext error.")
        exit()
u.close()
u=open(keyfile,"r")
k=u.readlines()
for i in range(len(k)):
    k[i]=k[i].strip("\n")
try:
    for i in k:
        for j in i:
            if j not in numaralar: raise Exception
except:
    print("Invalid character in key file error.")
    exit()
u.close()
def matrixlericarp(matrix1,matrix2):
    global result
    result=[]
    for i in range(len(matrix2)): # this loop add [0] as much as the length of the matrix.
        result.append([0])
    for i in range(len(matrix1)):
        for j in range(len(matrix2[0])):
            for k in range(len(matrix2)):
                result[i][j]+=matrix1[i][k]*matrix2[k][j]
if kodcesidi=="enc":
    key=open(keyfile,"r")
    keymatrix=[]
    for i in key:
        i=i.strip("\n")
        keymatrix.append(i.split(","))
    for i in range(len(keymatrix)):
        for j in range(len(keymatrix[i])):
            keymatrix[i][j]=int(keymatrix[i][j])
    key.close()
    input=open(inputfile,"r")
    sifre=input.readlines()
    if len(sifre[0])%len(keymatrix)==0: pass
    else:
        kalan=len(sifre[0])%len(keymatrix)
        sifre[0]=sifre[0]+" "*(len(keymatrix)-kalan) # this line adds whitespace if remainder is not zero
    inputmatrix=[]
    counter1=0
    counter2=len(keymatrix)
    while True:  #this loop separate the input file
        if counter2==(len(sifre[0])+len(keymatrix)): break
        inputmatrix.append(sifre[0][counter1:counter2])
        counter1+=len(keymatrix)
        counter2+=len(keymatrix)
    inputun_carpilmadan_onceki_hali=[]
    tekkullanimlik=[]
    for i in inputmatrix: # alt alta olan iki for dongusu inputu carpilmadan once carpim fonksiyonunda kullabilecegim hale donusturuyor
        for j in i:
            tekkullanimlik.append(int(dictim[j]))
        inputun_carpilmadan_onceki_hali.append(tekkullanimlik)
        tekkullanimlik=[]
    for i in range(len(inputun_carpilmadan_onceki_hali)):
        for j in range(len(inputun_carpilmadan_onceki_hali[i])):
            inputun_carpilmadan_onceki_hali[i][j]=[inputun_carpilmadan_onceki_hali[i][j]]
    son_sonuc=[]
    for i in inputun_carpilmadan_onceki_hali:
        matrixlericarp(keymatrix,i)
        son_sonuc.append(result)
    output=open(outputfile,"w")
    mystr=""
    for i in son_sonuc:
        for j in i:
            for l in j:
                mystr=mystr+str(l)+","
    output.write(mystr[:-1])
    output.close()
elif kodcesidi=="dec":
    key=open(keyfile,"r")
    keymatrix=[]
    for i in key:
        i=i.strip("\n")
        keymatrix.append(i.split(","))
    for i in range(len(keymatrix)):
        for j in range(len(keymatrix[i])):
            keymatrix[i][j]=int(keymatrix[i][j])
    def minor(mymatrix, i, j):
        mymatrix = mymatrix[:i] + mymatrix[i + 1:]
        for k in range(0, len(mymatrix)):
            mymatrix[k] = mymatrix[k][:j] + mymatrix[k][j + 1:]
        return mymatrix
    def determinant_bulma(mymatrix):
        if len(mymatrix)==2 :return mymatrix[0][0] * mymatrix[1][1] - mymatrix[0][1] * mymatrix[1][0]
        toplam = 0
        for j in range(0, len(mymatrix)):
            toplam = toplam + ((-1)**j) * mymatrix[0][j] * determinant_bulma(minor(mymatrix, 0, j))
        return toplam
    inversedict={}
    def inversematrix(mymatrix):
        global inversedict
        for i in range(len(mymatrix)):
            for j in range(len(mymatrix)):
                x=determinant_bulma(minor(mymatrix, i, j))
                k=str(j+1)+str(i+1) #bu iki satirda eslenikte 21 konumunda olan 12ye kaydedildigi icin sozlukte 21'i 12 olarak kaydettim.
                inversedict[k]=x
    inversematrix(keymatrix)
    sonucliste=[]
    for i in range(len(keymatrix)): #2 for loopunda eslenigi determinant bolerken index error almamak icin kullanacagim listeyi ona uygun bir forma donusturuyor.
        sonucliste.append([0])
    for i in range(len(keymatrix)):
        for j in range(len(keymatrix)-1):
            sonucliste[i].append(0)
    determinant=determinant_bulma(keymatrix)
    for i in range(len(keymatrix)):
        for j in range(len(keymatrix)):
            k=str(i+1)+str(j+1)
            sonucliste[i][j]=((-1)**(i+j))*(inversedict[k]/determinant)
    u=open(sys.argv[3],"r")
    for i in u:
        cipher_listesi=i.split(",")
    for j in range(len(cipher_listesi)):
        cipher_listesi[j]=int(cipher_listesi[j])
    sifrelistesi=[]
    kullanimlikliste=[]
    for j in range(len(cipher_listesi)): #bu for dongusu ciphertextteki sayilari key matrixinin uzunluguna gore carpim fonksiyonunda kullabilecegim hale donusturuyor
        kullanimlikliste.append([cipher_listesi[j]])
        if (j+1)%len(keymatrix)==0:
            sifrelistesi.append(kullanimlikliste)
            kullanimlikliste=[]
    gerceksonuc=[]
    for i in sifrelistesi:
        matrixlericarp(sonucliste,i)
        gerceksonuc.append(result)
    mystr=""
    mylist=[]
    for i in gerceksonuc:
        """bu dongu carpimin sonucundaki sayilarin hepsini tek listeye ekliyor """
        for j in i:
            for l in j:
                mylist.append(l)
    mystr=""
    for i in range(len(mylist)):
        """ bu dongu buldugum son degeri round edip sonra da o sayiya karsilik
        sozlukte hangi harf varsa stringime ekliyor en sonda da o stringi sonuc dosyasina yazdiriyorum """
        mylist[i]=round(float(mylist[i]))
        mystr=mystr+ters_dict[mylist[i]]
    output=open(outputfile,"w")
    output.write(mystr)
    output.close()
