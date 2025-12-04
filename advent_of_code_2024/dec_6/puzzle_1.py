input_file = "dec_6/puzzle_input"
output = 0

with open(input_file, "r") as f:
    lst_input = f.readlines()

for i in range(len(lst_input)):
    if "\n" in lst_input[i]:
        lst_input[i] = lst_input[i].split()[0]

# Guard pos is (y, x)
guard_pos = (8, 0)
curr_dir = ("y", -1)
lst_obstacles = []
grid_size = (len(lst_input), len(lst_input[0]))
# lst_pos = []
dct_pos = {}

def get_string_pos(y, x):
    return str(y) + str(x)


# Function to keep track of guard direction
def get_directions():
    #lst_directions = ["North", "East", "South", "West"]
    #lst_directions = [0, 1, 2, 3]
    lst_directions = [("y", -1), ("x", 1), ("y", 1), ("x", -1)]
    index = lst_directions.index(curr_dir)

    if index == 3:
        new_dir = lst_directions[0]
    else:
        new_dir = lst_directions[index + 1]

    return new_dir


# Function to predict guards next position
def get_next_pos():
    y = guard_pos[0]
    x = guard_pos[1]

    if curr_dir[0] == "y":
        y += curr_dir[1]
    elif curr_dir[0] == "x":
        x += curr_dir[1]        

    return (y, x)


# Function to check for collision, returns a new direction if there is a collision on the next move
def check_collision():
    guard_next_pos = get_next_pos()
    guard_next_pos = get_string_pos(guard_next_pos[0], guard_next_pos[1])
    for obstacle in lst_obstacles:
        if obstacle == guard_next_pos:
            return get_directions()
    
    return curr_dir

def check_out_of_bounds():
    if guard_pos[0] < 0 or guard_pos[0] > grid_size[0] - 1:
        return False
    if guard_pos[1] < 0 or guard_pos[1] > grid_size[1] - 1:
        return False
    
    return True


# Go through input create list of obstacle and guard postiions
for cols in range(len(lst_input)):
    for rows in range(len(lst_input[0])):
        if lst_input[cols][rows] == "#":
            lst_obstacles.append(get_string_pos(cols, rows))

        if lst_input[cols][rows] == "^":
            guard_pos = (cols, rows)
steps = 0
# Loop until guard is out of bounds
while check_out_of_bounds():
    curr_pos = get_string_pos(guard_pos[0], guard_pos[1])
    dct_pos[curr_pos] = "x"
    curr_dir = check_collision()
    guard_pos = get_next_pos()
    steps += 1

output = len(dct_pos)
print(f"Steps: {steps}")
print(f"Output: {output}")