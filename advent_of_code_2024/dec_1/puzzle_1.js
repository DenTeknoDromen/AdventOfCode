const fs = require('node:fs');

let input = fs.readFileSync('test_input', 'utf8');

// lst_input_a = []
// lst_input_b = []
// output = 0

let lstInputA = []
let lstInputB = []
let output = 0

// for line in lst_input:
//     lst_input_a.append(int((line.split(" ")[0])))
//     lst_input_b.append(int((line.split(" ")[-1].strip("\n"))))

const arrInput = input.split("\n")
arrInput.forEach(item => {
    lstInputA.push(Number(item.split(" ")[0]))
    let x = item.split(" ")
    lstInputB.push(Number(x[x.length - 1]))
})

// lst_input_a.sort()
// lst_input_b.sort()

lstInputA.sort()
lstInputB.sort()

// for i in range(len(lst_input_a)):
//     lowest_a = lst_input_a[i]
//     lowest_b = lst_input_b[i]
//     print(f"{lowest_a}          {lowest_b}")
//     if lowest_a >= lowest_b:
//         output += lowest_a - lowest_b
//     else:
//         output += lowest_b - lowest_a

for (let i = 0; i < lstInputA.length; i++) {
    lowestA = lstInputA[i]
    lowestB = lstInputB[i]

    if (lowestA >= lowestB) {
        output += lowestA - lowestB
    } else {
        output += lowestB - lowestA
    }


}
// print(output)

console.log(output)
