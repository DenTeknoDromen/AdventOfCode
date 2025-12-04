input_file = "dec_7/puzzle_input"
output = 0

# Read puzzle input
with open(input_file, "r") as f:
    lst_input = f.readlines()

# Gets the binary representation of a number and
# replaces 1 and zeroes with + and * returns the result as a string.
# Used to calculate all combinations of + and *
def get_bin(index, inverted):
    binary = bin(index)[2:]
    ops = ""
    # print(binary)
    for x in binary:
        if x == "1":
            ops += inverted[0]
        else:
            ops += inverted[1]
    # print(ops)
    return (ops)


# Takes one string of + and * combinations and apllies it to the current number input.
# Returns the result
def calc_ops(nums, ops):
    output_nums = nums.copy()
    for i in range(len(ops)):
        if ops[i] == "+":
            output_nums[0] = int(output_nums[0]) + int(output_nums[i + 1])
        if ops[i] == "*":
            output_nums[0] = int(output_nums[0]) * int(output_nums[i + 1])

    return output_nums[0]


# Goes through current array of numbers and checks if valid
def calc_nums(nums, target_val):
    ops_len = len(nums) - 1
    for i in range(int(2**ops_len / 2), 2**ops_len):
        if calc_ops(nums, get_bin(i, "+*")) == target_val:
            return True

        if calc_ops(nums, get_bin(i, "*+")) == target_val:
            return True

    return False


# Iterates through puzzle input
for line in lst_input:
    nums = line.split(" ")
    result = int(nums[0][:-1])
    print(line, end="")
    if calc_nums(nums[1:], result):
        print(f"     --> result: {result} is valid\n")
        output += result
    else:
        print("")

print(f"\nOutput: {output}")
