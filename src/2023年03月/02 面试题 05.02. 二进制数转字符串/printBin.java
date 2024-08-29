// 小数的二进制的计算方法：
// 十进制小数转换成二进制小数采用乘2取整，顺序排列法。
// 具体做法是：
// 用2乘十进制小数，可以得到积，将积的整数部分取出，再用2乘余下的小数部分，又得到一个积，再将积的整数部分取出，如此进行，直到积中的小数部分为零，或者达到所要求的精度为止。然后把取出的整数部分按顺序排列起来，先取的整数作为二进制小数的高位有效位，后取的整数作为低位有效位即可。
class Solution {
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        while (sb.length() < 32) {
            num *= 2;//乘以2
            int temp = (int) num;//取整数部分
            sb.append(temp);//转为二进制的一部分
            num -= temp;//去掉整数部分
            if (num == 0) {
                return sb.toString();//为0结束
            }
        }
        return "ERROR";
    }
}