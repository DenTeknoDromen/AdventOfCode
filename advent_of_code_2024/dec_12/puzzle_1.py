input_file = "dec_12/test_input"
output = 0

with open(input_file, "r") as f:
    lst_input = f.read().splitlines()

dct_area = {}
dct_peri = {}


def add_to_dct(key, dct):
    if key in dct:
        dct[key] += 1
    else:
        dct[key] = 1
        dct_peri[key] = 0

    return dct


# Iterate through array and get perimeter
for col in range(len(lst_input)):
    last_row = ""
    for row in range(len(lst_input[col])):
        #print(lst_input[col][row], end="")
        curr_region = lst_input[col][row]
        add_to_dct(curr_region, dct_area)
        neighbours = dct_peri[curr_region]
        if row - 1 >= 0 and lst_input[col][row - 1] == curr_region:
            neighbours += 1
        if row + 1 < len(lst_input[row]) and lst_input[col][row + 1] == curr_region:
            neighbours += 1
        if col - 1 >= 0 and lst_input[col - 1][row] == curr_region:
            neighbours += 1
        if col + 1 < len(lst_input) and lst_input[col + 1][row] == curr_region:
            neighbours += 1

        dct_peri[curr_region] = neighbours
        last_row = curr_region

for key in dct_area.keys():
    if key not in dct_peri:
        dct_peri[key] = 0
    area = dct_area[key]
    perimeter = dct_peri[key]
    fences = (area * 4) - perimeter
    output += (area * fences)
    print(f"{key}   area: {area}    perimeter: {perimeter}  fences: {fences}")
        

print("\n\n" + ("-"*40))
print(f"Output: {output}")