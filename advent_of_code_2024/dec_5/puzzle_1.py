input_file = "dec_5/puzzle_input"
output = 0

with open(input_file, "r") as f:
    lst_input = f.read().splitlines()

# Splits input with rule part and input part
lst_notation = []
dct_notation = {}
blank_spot = lst_input.index("")

# Create a dictionary with every unique lefthand value as key
for x in lst_input[:blank_spot]:
    curr_split = x.split("|")
    curr_num_a = curr_split[0]
    curr_num_b = curr_split[1]

    if curr_num_a in dct_notation:
        dct_notation[curr_num_a].append(curr_num_b)
    else:
        dct_notation[curr_num_a] = [curr_num_b]

lst_input = lst_input[blank_spot + 1:]


# Checks if the current line is valid, returns bool value
# Iterates backward through the array
def check_valid_update(index, line):
    lst_invalind_nums = []
    for i in range(index, -1, - 1):
        curr_key = line[i]

        if curr_key in lst_invalind_nums:
            return False

        if curr_key in dct_notation.keys():
            lst_invalind_nums += dct_notation[curr_key]

    return True


# Returns middle number from list
def get_middle_num(line):
    index = int((len(line) / 2))
    return int(line[index])


# Iterates through all the lists and checks if the line follows the correct rules
# Add middle number to output if line is valid
for line in lst_input:
    line = line.split(",")
    print(line)

    if check_valid_update(len(line) - 1, line):
        output += get_middle_num(line)
        print(f"Added: {get_middle_num(line)}")


print(f"\nOutput: {output}")
