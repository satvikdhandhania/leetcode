/*
 *Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output:  321

Example 2:

Input: -123
Output: -321

Example 3:

Input: 120
Output: 21

Note:
Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows. 
 * */
#include<limits.h>
int reverse(int x) {
    int res = 0;
    int sign = (x<0)?1:0;
    if(sign)
        x = 0-x;
    while(x>0){
        if((res > (INT_MAX/10)) || (res<(INT_MIN/10)))
            return 0;
        res = res*10 + x%10;
        x = x/10;
    }
    if(sign)
        return -res;
    return res;
}
