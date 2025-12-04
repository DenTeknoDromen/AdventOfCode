input_file = "puzzle_input"

with open(input_file, "r") as f:
    lst_input = f.readlines()

lst_input_a = []
lst_input_b = []
output = 0

for line in lst_input:
    lst_input_a.append(int((line.split(" ")[0])))
    lst_input_b.append(int((line.split(" ")[-1].strip("\n"))))

for i in lst_input_a:
    output += i * lst_input_b.count(i)

print(output)