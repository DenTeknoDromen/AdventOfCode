import re

input_file = "dec_11/test_input"
output = 0

with open(input_file, "r") as f:
    input = f.read()

lst_stones = input.split(" ")
print(lst_stones)


def get_zero(curr_num):
    curr_num = re.sub("^0+", "", curr_num)
    if len(curr_num) == 0:
        curr_num = "0"
    return curr_num


def apply_rules(lst_stones):
    i = 0
    while i < len(lst_stones):
        if lst_stones[i] == "0":
            lst_stones[i] = "1"
        elif len(lst_stones[i]) % 2 == 0:
            half_length = int(len(lst_stones[i]) / 2)
            num = lst_stones[i]
            lst_stones[i] = num[:half_length:]
            lst_stones.insert(i + 1, get_zero(num[half_length:]))
            i += 1
        else:
            num = int(lst_stones[i]) * 2024
            lst_stones[i] = str(num)
        i += 1

    return lst_stones

for x in range(6):
    lst_stones = apply_rules(lst_stones)
    print(lst_stones)
    
output = len(lst_stones)
print(f"Output: {output}")