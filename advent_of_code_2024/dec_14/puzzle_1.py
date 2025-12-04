input_file = "dec_14/puzzle_input"
output = 1

with open(input_file, "r") as f:
    lst_input = f.readlines()

ROOM_WIDTH = 101
ROOM_HEIGHT = 103
HALF_WIDTH = int(ROOM_WIDTH / 2)
HALF_HEIGHT = int(ROOM_HEIGHT / 2)
lst_robots = []
dct_quadrant = {"TOPLEFT": 0, "TOPRIGHT": 0, "BOTTOMLEFT": 0, "BOTTOMRIGHT": 0, "NONE": 0}


class Robot:
    def __init__(self, pos_x, y_pos, x_vel, y_vel):
        self.pos_x = pos_x
        self.pos_y = y_pos
        self.vel_x = x_vel
        self.vel_y = y_vel

    def wrap_room(self, pos, border):
        if pos >= border:
            return pos - border
        if pos < 0:
            return border + pos

        return pos

    def update_pos(self):
        self.pos_x += self.vel_x
        self.pos_y += self.vel_y

        self.pos_x = self.wrap_room(self.pos_x, ROOM_WIDTH)
        self.pos_y = self.wrap_room(self.pos_y, ROOM_HEIGHT)

    def get_pos(self):
        pos = (self.pos_x, self.pos_y)
        return pos


def get_tuple(line):
    curr_split = line[2:].split(",")
    curr_tuple = (int(curr_split[0]), int(curr_split[1]))
    return curr_tuple


def get_quadrant(pos):
    quadrant = ""

    if pos[1] < HALF_HEIGHT:
        quadrant = "TOP"
    elif pos[1] == HALF_HEIGHT:
        return "NONE"
    else:
        quadrant = "BOTTOM"

    if pos[0] < HALF_WIDTH:
        quadrant += "LEFT"
    elif pos[0] == HALF_WIDTH:
        return "NONE"
    else:
        quadrant += "RIGHT"

    return quadrant


for line in lst_input:
    curr_split = line.split(" ")
    pos = (get_tuple(curr_split[0]))
    val = (get_tuple(curr_split[1]))

    lst_robots.append(Robot(pos[0], pos[1], val[0], val[1]))


for seconds in range(100):
    for robot in lst_robots:
        robot.update_pos()

for robot in lst_robots:
    curr_pos = robot.get_pos()
    dct_quadrant[get_quadrant(curr_pos)] += 1

for key in dct_quadrant.keys():
    print(f"{key}: {dct_quadrant[key]}")
    if key != "NONE":
        output *= dct_quadrant[key]


print("-"*40)
print(f"Output: {output}")
