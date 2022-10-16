class ArmstrongNumbers {

    // main for local tests
    public static void main(String[] args) {
        ArmstrongNumbers a1 = new ArmstrongNumbers();
        
        a1.isArmstrongNumber(153);
    }

    /**
     * Implement boolean method to check if number is armstrong number or not.
     * @param numberToCheck, the number we want to know if it is a Armstrong number
     * @return boolean true/false. True if given number is a Armstrong number. false if not.
     */
    boolean isArmstrongNumber(int numberToCheck) {

        if(numberToCheck== 0){
            return true;
        }

        int numberOfDigits = (int)Math.log10(numberToCheck)+1;
        int armstrongnumber = ArmstrongNumber(numberToCheck, numberOfDigits);

        if(armstrongnumber == numberToCheck){
            return true;
        } else{
            return false;
        }
    }

    int ArmstrongNumber(int numberToCheck, int numberOfDigits){

        String temp = Integer.toString(numberToCheck);

        int[] intArray = new int[temp.length()];
        int sum = 0;

        for(int i = 0; i < temp.length(); i++){
            intArray[i] = temp.charAt(i) - '0';
        }

        for(int i = 0; i<intArray.length; i++){
            sum += Math.pow(intArray[i], numberOfDigits);
        }

        return sum;
    }

}
