public class DEC1 {
    public static void main(String[] args) throws Exception {
        String[] indata = {"pqr3stu8vwx", "1abc2", "a1b2c3d4e5f", "treb7uchet"};
        int sum = 0;
        
        //Converts every string in indata to char_array and sends it to get_num
        //Adds returned int to sum
        for (String i : indata) {
            char[] lst_indata = i.toCharArray();
            sum += get_num(lst_indata);
        }
        System.out.println("Calibration value: " + sum);

        }

        static int get_num(char[] lst_indata) { 
            String str_num  = "";
            int num = 0;
            int len_indata = lst_indata.length;

            //Loops through the char_array from begining to end to find the first number
            int index = 0;
            while (Character.isAlphabetic(lst_indata[index])) {
                index += 1;
            }
            str_num += lst_indata[index];

            //Loops through the char_array backwards to find the last number
            index = len_indata - 1;
            while (Character.isAlphabetic(lst_indata[index])) {
                index -= 1;
            };
            //Adds both numbers together as a string, casts it as integer and returns it
            str_num += lst_indata[index];
            num = Integer.parseInt(str_num);
            System.out.println(num);
            return num;
        }
    }
