with open("DEC8_input.txt", "r") as f:
    data = f.readlines()

dict_map = {}
steps = 0
directions = data[0]

for x in range(2, len(data)):
    curr_line = data[x]
    dict_map[curr_line[:3]] = [curr_line[7:10], curr_line[12:15]]

curr_node = "AAA"
i = 0
while curr_node != "ZZZ":
    curr_node = dict_map.get(curr_node)[0] if directions[i] == "L" else dict_map.get(curr_node)[1]
    i = + 1 if i <= len(directions) else 0

    steps += 1
    print(curr_node)

print(steps)