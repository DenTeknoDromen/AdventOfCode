input_file = "dec_2/test_input"

with open(input_file, "r") as f:
    lst_input = f.readlines()

output = 0

for line in lst_input:
    curr_line = line.split(" ")
    pre_char = int(curr_line[0])
    ascending = -1
    safe = True
    failsafe = 1
    if pre_char > int(curr_line[1]):
        ascending = 1

    for i in range(1, len(curr_line)):
        curr_char = int(curr_line[i])
        diff = (curr_char - pre_char) * ascending
        if diff > -1 or diff < -3:
            safe = False
            if failsafe == 1:
                safe = True
                failsafe = 0
        pre_char = curr_char
        print(f"{curr_line}         safe: {safe} failsafe:{failsafe}")

    print("")

    if safe:
        output += 1

print(output)