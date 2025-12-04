input_file = "dec_9/test_input"
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

def to_string(lst):
    string_output = ""
    for x in lst:
        string_output += x

    return string_output

print("") 
print(to_string(lst_blocks))

def get_similar(index):
    i = index
    curr_char = lst_blocks[index]
    while i < len(lst_blocks) and lst_blocks[i] == curr_char:
        i += 1
    return lst_blocks[index:i]


def get_swap_position(block_len):
    lst__dots = ["."]
    i = 0
    while i < len(lst_blocks):
        if lst_blocks[i] == ".":
            lst__dots = get_similar(i)
        if len(lst__dots) >= block_len:
            return i
        i += len(lst__dots)
    return None
    

for x in range(9, -1, -1):
    start_index = lst_blocks.index(str(x))
    lst_curr_nums = get_similar(start_index)
    dot_index = get_swap_position(len(lst_curr_nums))
    if dot_index == None:
        continue
        # print("dot_index is null!")

    for i in range(len(lst_curr_nums)):
        lst_blocks[dot_index + i] = lst_curr_nums[i]
        lst_blocks[start_index + i] = "."

    print(to_string(lst_blocks))


# # Sort the lists, similar to selection sort algorithm
# for a in range(len(lst_blocks)):
#     if lst_blocks[a] != ".":
#         continue

#     index = len(lst_blocks) - 1
#     while lst_blocks[index] == "." and index > a:
#         index -= 1
#     curr_num = lst_blocks[index]
#     lst_blocks[index] = "."
#     lst_blocks[a] = curr_num
#     print(f"Sorting position: {a}")

# # Calculates the output

#     print(lst_curr_nums)
#     output += (int(lst_blocks[x]) * x)
#     print(f"Adding: {(int(lst_blocks[x]) * x)}")


print(f"Output: {output}")
