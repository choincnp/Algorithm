class Solution {
    public String solution(String polynomial) {
        int varchar = 0;
        int constant = 0;
        polynomial = polynomial.replaceAll("\\+","");
        String[] arr = polynomial.split(" ");
        for (String i : arr){
            if(i.contains("x")){
                if (i.length()==1) varchar+= 1;
                else varchar += Integer.parseInt(i.replaceAll("x","").trim());
            }
            else if (!i.equals("")) {constant += Integer.parseInt(i);}
            else{};
        }
        // if (varchar==0 && constant==0) return "0";
        if (varchar==0) return constant+"";
        else if (varchar==1&&constant==0) return "x";
        else if (varchar==1) return "x + "+constant;
        else if (constant==0) return varchar+"x";
        else return varchar+"x + "+constant;
    }
}