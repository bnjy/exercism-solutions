class ResistorColor {

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

    static int value;

    public static void main(String[] args) {
        System.out.println(colorCode("black"));    
    }

    static int colorCode(String color) {
        for(int i = 0; i <= colorArray.length-1; i++){
            if(color == colorArray[i]){
                value = i;
            }
        }
        return value;
    }

    static String[] colors() {
        return colorArray;
    }
}
