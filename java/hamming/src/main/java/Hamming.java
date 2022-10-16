public class Hamming {
  
  private String leftStrand;
  private String rightStrand;

  //class constructor for main class
  public Hamming(String leftStrand, String rightStrand) {
    if(leftStrand.isEmpty() && !rightStrand.isEmpty()){
      throw new IllegalArgumentException("left strand must not be empty.");
    }

    if(rightStrand.isEmpty() && !leftStrand.isEmpty()){
      throw new IllegalArgumentException("right strand must not be empty.");
    }

    if(leftStrand.length() != rightStrand.length()){
      throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }

    this.leftStrand = leftStrand;
    this.rightStrand = rightStrand;
  } 
  
  //main for local tests
  public static void main(String[] args) {
    Hamming a1 = new Hamming("GAGCCTACTAACGGGAT", "CATCGTAATGACGGCCT");
        
    System.out.println("Hamming distance: " + a1.getHammingDistance());
  }

  public int getHammingDistance() {
      int distance = 0; 

      for(int i = 0; i < leftStrand.length(); i++){
        if(this.leftStrand.charAt(i) != this.rightStrand.charAt(i)){
          distance++;
        }
      }
      return distance;
  }
}
