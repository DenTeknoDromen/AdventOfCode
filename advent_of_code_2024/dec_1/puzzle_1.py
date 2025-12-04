input_file = "test_input"

with open(input_file, "r") as f:
    lst_input = f.readlines()

lst_input_a = []
lst_input_b = []
output = 0

for line in lst_input:
    lst_input_a.append(int((line.split(" ")[0])))
    lst_input_b.append(int((line.split(" ")[-1].strip("\n"))))

lst_input_a.sort()
lst_input_b.sort()

for i in range(len(lst_input_a)):
    lowest_a = lst_input_a[i]
    lowest_b = lst_input_b[i]
    if lowest_a >= lowest_b:
        output += lowest_a - lowest_b
    else:
        output += lowest_b - lowest_a

print(output)