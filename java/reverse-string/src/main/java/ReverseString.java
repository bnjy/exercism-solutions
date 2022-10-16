class ReverseString {

    String reverse(String inputString) {
        String newString = "";
        char charRep;
        for(int i = 0; i<inputString.length(); i++){
            charRep = inputString.charAt(i);
            newString = charRep + newString;
        }
        return newString;
    }
}
