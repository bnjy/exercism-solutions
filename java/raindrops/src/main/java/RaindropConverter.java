class RaindropConverter {
    StringBuilder str = new StringBuilder();
    String convert(int number) {
        if(number % 3 == 0){
            str.append("Pling");
        }
        if(number % 5 == 0){
            str.append("Plang");
        }
        if(number % 7 == 0){
            str.append("Plong");
        }
        if(str.toString().isEmpty()){
            str.append(number);
        }
        return str.toString();
    }

}
