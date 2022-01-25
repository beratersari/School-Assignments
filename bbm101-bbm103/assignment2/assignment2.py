"""My name is Mehmet Berat Ersari. My number is 21992943. This is my assignment2."""
our_input=list(input("Please enter feeding map as a list:"))
our_first_direction=list(input("Please enter direction of movements as a list:"))
count=-1 #I determine a counter to convert our first input as a useful list
list1, our_map, our_direction= [], [], [] # i create a few empty lists because i will use to convert our inputs as a useful list
for i in our_input: # this for loop convert our first input as a useful list and save as our_map
    if i == "C" or i== "A" or i=="W" or i=="M" or i=="X" or i=="P" or i=="*":
        list1.append(i)
    elif i =="[" or i=="]":
        count+=1
    if count==2:
        our_map.append(list1)
        list1=[]
        count=0
count=0 #I determine a counter to convert our second input as a useful list
for i in our_first_direction: # this for loop convert our second input as a useful list and save as our_direction
    if i == "R" or i == "L" or i == "U" or i == "D":
        our_direction.append(i)
    elif i == "[" or i == "]":
        count += 1
    if count == 2:
        break
for_find_y_position_of_star, for_find_x_position_of_star= 0, 0 # i determined these to find position of rabbit. And I thought of the list as x-y coordinat system it is easy to understand up to me.
for i in our_map:
    for j in i:
        if j=="*":
            positon_of_star_on_x_axis=for_find_x_position_of_star #i save x position as positon_of_star_on_x_axis
            positon_of_star_on_y_axis=for_find_y_position_of_star #i save y position as positon_of_star_on_y_axis
            break
        for_find_x_position_of_star+=1
    for_find_y_position_of_star+=1
    for_find_x_position_of_star=0
def writing_list_as_2darray(our_matrix): # i determined a function to print our maps.
    for i in our_matrix:
        for j in i:
            print(j,end=" ")
        print("")
first_horizontal_position, first_vertical_position= positon_of_star_on_x_axis, positon_of_star_on_y_axis # And i copy rabbit position as first hortizonal and first vertical.
print("Your board is:")
writing_list_as_2darray(our_map)
score=0 # to calculate score
def puan(positon_of_star_on_x_axis, positon_of_star_on_y_axis): # i determined a function to calculate score.
    global score
    if our_map[positon_of_star_on_y_axis][positon_of_star_on_x_axis]== "C":
        score+=10
        our_map[positon_of_star_on_y_axis][positon_of_star_on_x_axis] = "X"
    if our_map[positon_of_star_on_y_axis][positon_of_star_on_x_axis]== "A":
        score+=5
        our_map[positon_of_star_on_y_axis][positon_of_star_on_x_axis]= "X"
    if our_map[positon_of_star_on_y_axis][positon_of_star_on_x_axis]== "M":
        score-=5
        our_map[positon_of_star_on_y_axis][positon_of_star_on_x_axis]= "X"
for i in our_direction: #i created a for loop to move our rabbit
    if our_map[positon_of_star_on_y_axis][positon_of_star_on_x_axis] == "P":
        break
    if i=="U":
        positon_of_star_on_y_axis-=1
        if positon_of_star_on_y_axis<0 or our_map[positon_of_star_on_y_axis][positon_of_star_on_x_axis] == "W": # if there is a wall or there is empty up of rabbit, i add 1 our y position again.
            positon_of_star_on_y_axis+=1
        puan(positon_of_star_on_x_axis, positon_of_star_on_y_axis) # i calculated puan after this moving.
    if i=="D":
        positon_of_star_on_y_axis+=1
        if positon_of_star_on_y_axis>len(our_map)-1 or our_map[positon_of_star_on_y_axis][positon_of_star_on_x_axis] == "W": # if there is a wall or there is empty under of rabbit, i subsract 1 our y position again.
            positon_of_star_on_y_axis-=1
        puan(positon_of_star_on_x_axis, positon_of_star_on_y_axis) # i calculated puan after this moving.
    if i=="R":
        positon_of_star_on_x_axis+=1
        if positon_of_star_on_x_axis>len(our_map[0])-1 or our_map[positon_of_star_on_y_axis][positon_of_star_on_x_axis] == "W": # if there is a wall or there is empty right of rabbit, i subsract 1 our x position again.
            positon_of_star_on_x_axis-=1
        puan(positon_of_star_on_x_axis, positon_of_star_on_y_axis) # i calculated puan after this moving.
    if i=="L": # if there is a wall or there is empty left of rabbit, i add 1 our x position again.
        positon_of_star_on_x_axis-=1
        if positon_of_star_on_x_axis<0 or our_map[positon_of_star_on_y_axis][positon_of_star_on_x_axis] == "W" :
            positon_of_star_on_x_axis+=1
        puan(positon_of_star_on_x_axis, positon_of_star_on_y_axis) # i calculated puan after this moving.
our_map[positon_of_star_on_y_axis][positon_of_star_on_x_axis] = "*" # and determine the last position as "*"
if  not (positon_of_star_on_y_axis == first_vertical_position and positon_of_star_on_x_axis == first_horizontal_position): # if first and last positions are different, determine as "*" our first position
    our_map[first_vertical_position][first_horizontal_position]= "X"
print("Your output should be like this:")
writing_list_as_2darray(our_map)
print("Your score is:",score)

