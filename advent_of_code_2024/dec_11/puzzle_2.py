import re

input_file = "dec_11/puzzle_input"
output = 0

with open(input_file, "r") as f:
    lst_stones = f.read().split(" ")

dct_map = {}
for x in lst_stones:
    dct_map[x] = 1


# Gets rid of leading zeroes
# Returns a string
def get_zero(curr_num):
    curr_num = re.sub("^0+", "", curr_num)
    if len(curr_num) == 0:
        curr_num = "0"
    return curr_num
    

# Adds the current quantity to an old key or creates a new one if it does not exist
def add_dct(dct_map, key, quantity):
    if key in dct_map.keys():        
        dct_map[key] += quantity
    else:
        dct_map[key] = quantity

    return dct_map


# Aplies the puzzle rules and updates the dictionary for each 'blink'
# Uses a copy of the dictionary to avoid updating quantities twice
for blink in range(75):
    old_dct = dct_map.copy()

    for key in old_dct.keys():
        quantity = old_dct[key]
        dct_map[key] -= quantity

        if key == "0":
            dct_map = add_dct(dct_map, "1", quantity) 
        elif len(key) % 2 == 0:
            half_length = int(len(key) / 2)
            dct_map = add_dct(dct_map, key[:half_length:], quantity) 
            dct_map = add_dct(dct_map, get_zero(key[half_length:]), quantity)
        else:
            curr_num = int(key) * 2024
            dct_map = add_dct(dct_map, str(curr_num), quantity)


# Adds together the number of times each 'stone' appears in the dictionary
for x in dct_map.keys():
    output += dct_map[x]

print("-"*40)
print(f"Output: {output}")
