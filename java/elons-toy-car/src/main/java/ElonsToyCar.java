public class ElonsToyCar {
private int distance = 0;
private int battery = 100;

    public static ElonsToyCar buy() {
        ElonsToyCar newCar = new ElonsToyCar();
        return newCar;
    }

    public String distanceDisplay() {
        return "Driven " + distance + " meters";
    }

    public String batteryDisplay() {
        if(battery == 0){
            return "Battery empty";
        } else {
        return "Battery at " + battery + "%";
        }
    }

    public void drive() {
        if (battery == 0){
            return;
        } else {
            distance += 20;
            battery -= 1;
        }
    }
}
