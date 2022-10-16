class ResistorColorDuo {
    
    private static String[] colorArray = {
        "black",
        "brown",
        "red",
        "orange",
        "yellow",
        "green",
        "blue",
        "violet",
        "grey",
        "white"
    };
    
    // main for local tests
    public static void main(String[] args) {
        String[] colors = {"brown","black"};
        System.out.println("value: " + value(colors));
    }

    static int value(String[] colors) {
        String c1 = colors[0];
        String c2 = colors[1];

        int sum = Integer.valueOf(String.valueOf(colorCode(c1)) + String.valueOf(colorCode(c2))); 

        return sum;
    }

    static int colorCode(String color) {
        int value = 0;
        for(int i = 0; i <= colorArray.length-1; i++){
            if(color == colorArray[i]){
                value = i;
            }
        }
        return value;
    }
}
