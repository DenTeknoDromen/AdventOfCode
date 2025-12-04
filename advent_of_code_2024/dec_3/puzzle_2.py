import re

input_file = "puzzle_input"
output = 0

with open(input_file, "r") as f:
    input = f.read()

input = re.findall("mul[(][0-9]+,[0-9]+[)]|do[(][)]|don't[(][)]", input)

enabled = True
for mul in input:
    if mul == "do()":
        enabled = True
        pass
    elif mul == "don't()":
        enabled = False
        pass
    elif enabled:
        nums = mul[4:-1].split(",")
        result = int(nums[0]) * int(nums[1])
        output += result

print(f"Output: {output}")