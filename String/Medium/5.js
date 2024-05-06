console.log(longestPalindrome("aba"))
function longestPalindrome(s){
    let startIndex = 0;
    let maxLength = 1; //because it should be atleast 1

    function expandMiddle(left,right){
        while(left>=0 && right<s.length && s[left]===s[right]){
            let length = right-left+1;
            if(length>maxLength){
                maxLength = length;
                startIndex = left;
            }
            left -= 1;
            right += 1;
        }
    }

    for(let i=0;i<s.length;i++){
        expandMiddle(i-1,i+1); //for even string "abba" in this case the pointer should be in between b and b
        expandMiddle(i,i+1); //for odd string "aba"
    }

    return s.slice(startIndex,startIndex+maxLength);
}
