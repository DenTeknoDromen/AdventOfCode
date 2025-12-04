input_file = "dec_14/puzzle_input"
output = 1

with open(input_file, "r") as f:
    lst_input = f.readlines()

ROOM_WIDTH = 101
ROOM_HEIGHT = 103
HALF_WIDTH = int(ROOM_WIDTH / 2)
HALF_HEIGHT = int(ROOM_HEIGHT / 2)
dct_quadrant = {"TOPLEFT": 0, "TOPRIGHT": 0, "BOTTOMLEFT": 0, "BOTTOMRIGHT": 0, "NONE": 0}


def wrap_room(pos, border):
    if pos >= border:
        return pos - border
    if pos < 0:
        return border + pos

    return pos


def get_quadrant(pos_x, pos_y):
    quadrant = ""

    if pos_y < HALF_HEIGHT:
        quadrant = "TOP"
    elif pos_y == HALF_HEIGHT:
        return "NONE"
    else:
        quadrant = "BOTTOM"

    if pos_x < HALF_WIDTH:
        quadrant += "LEFT"
    elif pos_x == HALF_WIDTH:
        return "NONE"
    else:
        quadrant += "RIGHT"

    return quadrant


for line in lst_input:
    line = line.split(" ")
    curr_split = line[0][2:].split(",")
    pos_x = int(curr_split[0])
    pos_y = int(curr_split[1])

    curr_split = line[1][2:].split(",")    
    vel_x = int(curr_split[0])
    vel_y = int(curr_split[1])

    for seconds in range(100):
        pos_x += vel_x
        pos_y += vel_y

        pos_x = wrap_room(pos_x, ROOM_WIDTH)
        pos_y = wrap_room(pos_y, ROOM_HEIGHT)    

    dct_quadrant[get_quadrant(pos_x, pos_y)] += 1        

for key in dct_quadrant.keys():
    print(f"{key}: {dct_quadrant[key]}")
    if key != "NONE":
        output *= dct_quadrant[key]


print("-"*40)
print(f"Output: {output}")
if output == 229868730:
    print("Is valid")
