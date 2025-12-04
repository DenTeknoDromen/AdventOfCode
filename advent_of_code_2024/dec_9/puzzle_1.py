input_file = "dec_9/puzzle_input"
output = 0

with open(input_file, "r") as f:
    input = f.read()

lst_blocks = []
id = 0
# Convert input to blocks with id
for i in range(len(input)):
    if (i % 2) == 0:
        lst_blocks += [str(id) for x in range(int(input[i]))]
        id += 1
    else:
        lst_blocks += ["." for x in range(int(input[i]))]

# Sort the lists, similar to selection sort algorithm
for a in range(len(lst_blocks)):
    if lst_blocks[a] != ".":
        continue

    index = len(lst_blocks) - 1
    while lst_blocks[index] == "." and index > a:
        index -= 1
    curr_num = lst_blocks[index]
    lst_blocks[index] = "."
    lst_blocks[a] = curr_num
    print(f"Sorting position: {a}")

# Calculates the output
for x in range(len(lst_blocks)):
    if lst_blocks[x] == ".":
        continue

    output += (int(lst_blocks[x]) * x)
    print(f"Adding: {(int(lst_blocks[x]) * x)}")


print(f"Output: {output}")
