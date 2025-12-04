
import re
input_file = "puzzle_input"

with open(input_file, "r") as f:
    lst_input = f.read().splitlines()

output = 0


def print_array(array):
    for x in array:
        print(x)
    print("")


def rotate_array(array):
    lst_len = len(array)
    str_len = len(array[0])

    new_array = ["" for x in range(lst_len)]
    for str in range(str_len):
        for lst in range(lst_len, 0, -1):
            lst -= 1
            new_array[str] += array[lst][str]
    return new_array


def get_diagonal(array):
    row = len(array[0])
    col = len(array)

    new_array = ["" for x in range(row + col - 1)]

    for line in range(1, (row + col)):
        start_col = max(0, line - row)
        count = min(line, (col - start_col), row)

        for x in range(0, count):
            new_array[line - 1] += array[min(row, line) - x - 1][start_col + x]

    return new_array


def find_xmas(array):
    num_of_xmas = 0
    for x in array:
        num_of_xmas += len((re.findall("XMAS", x)))

    return num_of_xmas


for x in range(4):
    output += find_xmas(lst_input)
    output += find_xmas(get_diagonal(lst_input))

    lst_input = rotate_array(lst_input)

print(f"Output: {output}")
