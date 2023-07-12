public class conversion {
    private char[] num, dec;

    private String teen[] = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String tens[] =  {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] onedigit = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

    private String []powerOfTens ={"Hundred", "Thousand","Million","Billion"};

    /* Number is a string that
    * includes the cents in the form of
    * RRRRR.CC
    * Please not that it still need inout checking
    * as it cannot accept <> 2 decimal places
    * and does not allow for
    * white spaces in the string
    * and split on a "." not a ","
    * Does not account for negatives */
    public conversion(String number) {
        if(number.length() == 0){
            num = new char[0];
            dec = new char[0];
            return;
        }
        String[] nums =number.split("[.]");
        num = nums[0].toCharArray();
        dec = nums[1].toCharArray();
    }

    public String words() {
        if(dec.length == 0 && num.length == 0){
            return "no number entered";
        }
        String temp ="";
        temp+= wholeNum(num) +"Rand ";
        temp+= "and " + decimal(dec);
        return temp;
    }

    private String wholeNum(char[] num){
        if(num.length == 0){
            return "No number Entered";
        }
        String temp ="";
        char[] gr;
        int len = 0;
        if(num.length > 6) {
            len = num.length - 6;
            gr = new char[len];
            for (int i = 0; i < len; i++) {
                gr[i] = num[i];
            }
            temp += groupVal(gr) + " Million ";
        }
        if(num.length > 3) {
            int count = num.length - 3;
            int size =count;
            if(num.length > 6) {
                len = num.length - 6;
                count = len+3;
                size = 3;
            }
            gr = new char[size];
            int j = 0;
            for (int i = len; i < count; i++) {
                gr[j] = num [i];
                j++;
            }
            temp += groupVal(gr) + " Thousand ";
            len=+3;
        }

        int j = 0;
        gr = new char[num.length];
        for (int i = 0; i < num.length; i++) {
            gr[j] = num[i];
            j++;
        }
        temp += groupVal(gr) +" ";
        return temp;
    }

    private String decimal(char[] cent){
        if(cent.length==0){
            return "";
        }
        String cents ="";
        if(cent[0] == '0'){
            cents =  onedigit[cent[1] -'0'];
        }else{
            if(cent[0] =='1'){
                cents = teen[cent[1] -'0'];
            }else{
                cents = tens[cent[0] -'0'-1] + " " + onedigit[cent[1] -'0'];
            }
        }
        return cents + " cents";
    }

    private String groupVal( char[] gr){
        String temp ="";
        if(gr.length == 1){
            return onedigit[gr[0] -'0'];
        }else if(gr.length ==2){
            if(gr[0] =='1'){
                temp = teen[gr[1] -'0'];
            }else if(gr[1] !='0'){
                temp = tens[gr[0] -'0'] + " " + onedigit[gr[1] -'0'];
            }
        }else{
            if(gr.length == 3 && gr[0] != '0') {
                temp += onedigit[gr[0] - '0'] + " hundred";
            }
            if(gr[1] =='1'){
                temp += " and " +teen[gr[1] -'0'];
            }else if(gr[1] !='0'){
                temp += " and " + tens[gr[1] -'0'-1] + " " + onedigit[gr[2] -'0'];
            }
        }
        return temp;
    }

}
